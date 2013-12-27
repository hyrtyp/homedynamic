package com.hyrt.cnp.homedynamic.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by GYH on 13-12-27.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usermodel {
    private String token;
    private String uuid;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (token == null ? 0 : token.hashCode());
        result = prime * result + (uuid == null ? 0 : uuid.hashCode());
        result = prime * result + (username == null ? 0 : username.hashCode());
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
        Usermodel other = (Usermodel) obj;
        if (token == null) {
            if (other.token != null) {
                return false;
            }
        } else if (!token.equals(other.token)) {
            return false;
        }
        if (uuid == null) {
            if (other.uuid != null) {
                return false;
            }
        } else if (!uuid.equals(other.uuid)) {
            return false;
        }
        if (username == null) {
            if (other.username != null) {
                return false;
            }
        } else if (!username.equals(other.username)) {
            return false;
        }
        return true;
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Model {
        private static final long serialVersionUID = 6836514467436078182L;
        private String code;
        private String msg;
        private Usermodel data;

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (code == null ? 0 : code.hashCode());
            result = prime * result + (msg == null ? 0 : msg.hashCode());
            result = prime * result + (data == null ? 0 : data.hashCode());
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
            Model other = (Model) obj;
            if (code == null) {
                if (other.code != null) {
                    return false;
                }
            } else if (!code.equals(other.code)) {
                return false;
            }
            if (msg == null) {
                if (other.msg != null) {
                    return false;
                }
            } else if (!msg.equals(other.msg)) {
                return false;
            }
            if (data == null) {
                if (other.data != null) {
                    return false;
                }
            } else if (!data.equals(other.msg)) {
                return false;
            }
            return true;
        }

        public static long getSerialversionuid() {
            return serialVersionUID;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public Usermodel getData() {
            return data;
        }

        public void setData(Usermodel data) {
            this.data = data;
        }

    }
}
