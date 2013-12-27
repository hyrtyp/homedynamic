package com.hyrt.cnp.homedynamic.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;

/**
 * Created by GYH on 13-12-27.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubUser {

    private String name;
    private double score;
    private String gravatar_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public void setGravatar_id(String gravatar_id) {
        this.gravatar_id = gravatar_id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (gravatar_id == null ? 0 : gravatar_id.hashCode());
        result = prime * result + (name == null ? 0 : name.hashCode());
        long temp;
        temp = Double.doubleToLongBits(score);
        result = prime * result + (int) (temp ^ temp >>> 32);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        GitHubUser other = (GitHubUser) obj;
        if (gravatar_id == null) {
            if (other.gravatar_id != null) {
                return false;
            }
        } else if (!gravatar_id.equals(other.gravatar_id)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score)) {
            return false;
        }
        return true;
    }

    public static class List {
        private static final long serialVersionUID = 6836514467436078182L;

        private ArrayList<GitHubUser> users;

        public ArrayList<GitHubUser> getUsers() {
            return users;
        }

        public void setUsers(ArrayList<GitHubUser> users) {
            this.users = users;
        }

        public static long getSerialversionuid() {
            return serialVersionUID;
        }
    }

}
