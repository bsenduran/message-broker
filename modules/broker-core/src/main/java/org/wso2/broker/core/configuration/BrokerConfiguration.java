/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package org.wso2.broker.core.configuration;

/**
 * Represents configuration for broker.
 */
public class BrokerConfiguration {

    /**
     * Name of the configuration file.
     */
    public static final String BROKER_FILE_NAME = "broker.yaml";
    
    /**
     * system property to specify the path of the broker configuration file.
     */
    public static final String SYSTEM_PARAM_BROKER_CONFIG_FILE = "broker.config";
    
    DatasourceConfiguration datasource;

    Transport transport = new Transport();
    
    public DatasourceConfiguration getDatasource() {
        return datasource;
    }

    public void setDatasource(DatasourceConfiguration datasource) {
        this.datasource = datasource;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    /**
     * Represents a server side transport configuration for broker.
     */
    public static class Transport {

        private String name;

        private String hostName = "localhost";

        private String port = "5672";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHostName() {
            return hostName;
        }

        public void setHostName(String hostName) {
            this.hostName = hostName;
        }

        public String getPort() {
            return port;
        }

        public void setPort(String port) {
            this.port = port;
        }

        @Override
        public String toString() {
            return "Transport [name=" + name + ", hostName=" + hostName + ", port=" + port + "]";
        }

    }

    /**
     * Represents a datasource configuration for broker ( e.g. database)
     */
    public static class DatasourceConfiguration {

        private String url;

        private String databaseDriver;

        private String user;

        private String password;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDatabaseDriver() {
            return databaseDriver;
        }

        public void setDatabaseDriver(String databaseDriver) {
            this.databaseDriver = databaseDriver;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "DatasourceConfigurations [url=" + url + ", databaseDriver=" + databaseDriver + ", user=" + user
                    + ", password=" + password + "]";
        }

    }

}
