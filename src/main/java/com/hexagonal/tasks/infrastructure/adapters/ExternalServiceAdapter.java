//------------------------------------------------------------------------------------
// Package Section
//------------------------------------------------------------------------------------
package com.hexagonal.tasks.infrastructure.adapters;

//------------------------------------------------------------------------------------
// Imports Section
//------------------------------------------------------------------------------------
import com.hexagonal.tasks.domain.models.AdditionalTaskInfo;
import com.hexagonal.tasks.domain.ports.out.IExternalServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//------------------------------------------------------------------------------------
// Class Definition Section
//------------------------------------------------------------------------------------
public class ExternalServiceAdapter implements IExternalServicePort {
    //--------------------------------------------------------------------------------
    // Constants Section
    //--------------------------------------------------------------------------------
    private final RestTemplate restTemplate;

    //--------------------------------------------------------------------------------
    // Constructor Method Section
    //--------------------------------------------------------------------------------
    public ExternalServiceAdapter() {
        this.restTemplate = new RestTemplate();
    }

    //--------------------------------------------------------------------------------
    // Public Methods Section
    //--------------------------------------------------------------------------------
    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long pTaskId) {
        String apiUrl = "https://jsonplaceholder.typicode.com/todos" + pTaskId;
        ResponseEntity<JsonPlaceholderTodo> todoResponse =
                restTemplate.getForEntity(apiUrl, JsonPlaceholderTodo.class);
        JsonPlaceholderTodo todo = todoResponse.getBody();
        if (todo == null) {
            return null;
        }

        apiUrl = "https://jsonplaceholder.typicode.com/users" + todo.getUserId();
        ResponseEntity<JsonPlaceholderUser> userResponse =
                restTemplate.getForEntity(apiUrl, JsonPlaceholderUser.class);
        JsonPlaceholderUser user = userResponse.getBody();
        if (user == null) {
            return null;
        }
        return new AdditionalTaskInfo(user.getId(), user.getName(), user.getEmail());
    }

    //--------------------------------------------------------------------------------
    // Static Internal Classes Section (Because, Why not?)
    //--------------------------------------------------------------------------------
    // Json PlaceHolder for Todos Class
    //--------------------------------------------------------------------------------
    private static class JsonPlaceholderTodo {
        //----------------------------------------------------------------------------
        // Private Fields Section
        //----------------------------------------------------------------------------
        private Long id;
        private Long userId;

        //----------------------------------------------------------------------------
        // Public Properties Section
        //----------------------------------------------------------------------------
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
    }
    //--------------------------------------------------------------------------------
    // Json Placeholder for User Class
    //--------------------------------------------------------------------------------
    private static class JsonPlaceholderUser {
        //----------------------------------------------------------------------------
        // Private Fields Section
        //----------------------------------------------------------------------------
        private long id;
        private String name;
        private String email;

        //----------------------------------------------------------------------------
        // Public Properties Section
        //----------------------------------------------------------------------------
        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}

