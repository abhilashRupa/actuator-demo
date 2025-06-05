package com.ablearn.component;

import com.ablearn.state.Status;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "custom-status")
public class StatusCustomEndpoint {

    private Map<String, Status> customMap = new ConcurrentHashMap<>();

    @PostConstruct
    private void setDefaultStatus(){

        Status status = new Status();
        status.setStatusHolder(true);

        customMap.put("application", status);
    }

    @ReadOperation
    public Map<String, Status> allStatus(){
        return customMap;
    }

    @ReadOperation
    public Status getCustomStatus(@Selector String name){
        return customMap.get(name);
    }

    @WriteOperation
    public String setStatus(@Selector String name, Boolean statusHolder){

        Status status = new Status();
        status.setStatusHolder(statusHolder);

        customMap.put(name, status);

        return "status updated successfully";

    }

    @DeleteOperation
    public String deletedStatus(@Selector String name){
        customMap.remove(name);
        return "entry deleted";

    }

}
