package com.hexagonal.tasks.domain.models;

public class AdditionalTaskInfo {
    //----------------------------------------------------------------------------------
    // Constants Section
    //----------------------------------------------------------------------------------
    private final Long userId;
    private final String userName;
    private final String userEmail;

    //----------------------------------------------------------------------------------
    // Constructor Method Section
    //----------------------------------------------------------------------------------

    public AdditionalTaskInfo(Long pUserId, String pUserName, String pUserEmail) {
        this.userId = pUserId;
        this.userName = pUserName;
        this.userEmail = pUserEmail;
    }

    //----------------------------------------------------------------------------------
    // Public Properties Section
    //----------------------------------------------------------------------------------

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
