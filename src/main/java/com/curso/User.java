package com.curso;
/**
 * User object
 .*/
public class User {

    /**Comentario Javadoc para id.*/
    private Integer id;
    /**Comentario Javadoc para username.*/
    private String username;
    /**Comentario Javadoc para password.*/
    private String password;
    /**Comentario Javadoc para email.*/
    private String email;

    /**
     * Creates a new user.
     * @param pUsername unique username of the user
     * @param pPassword password of the user
     * @param pEmail email address of the user
     */
    public User(final String pUsername, final String pPassword,
            final String pEmail) {
        this.username = pUsername;
        this.password = pPassword;
        this.email = pEmail;
    }

    /**Comentario Javadoc para getId.
     * @return El id
     * */
    public Integer getId() {
        return id;
    }

    /**Comentario Javadoc para setId.
     * @param pId El id
     * */
    public void setId(final Integer pId) {
        this.id = pId;
    }

    /**Comentario Javadoc para getUsername.
     * @return El username
     * */
    public String getUsername() {
        return username;
    }

    /**Comentario Javadoc para setUsername.
     * @param pUsername El username
     * */
    public void setUsername(final String pUsername) {
        this.username = pUsername;
    }

    /**Comentario Javadoc para getPassword.
     * @return El password
     * */
    public String getPassword() {
        return password;
    }

    /**Comentario Javadoc para setPassword.
     * @param pPassword El password
     * */
    public void setPassword(final String pPassword) {
        this.password = pPassword;
    }

    /**Comentario Javadoc para getEmail.
     * @return El email
     * */
    public String getEmail() {
        return email;
    }


    public void setEmail(final String pEmail) {
//        /**Comentario Javadoc para setEmail.
//         * @param pEmail El email
//         * */
    	this.email = pEmail;
    }
}
