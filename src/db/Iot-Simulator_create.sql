-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-11-22 16:36:47.93

-- tables
-- Table: device
CREATE TABLE device (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    role varchar(255)  NOT NULL,
    CONSTRAINT device_pk PRIMARY KEY (id)
);

-- Table: machine
CREATE TABLE machine (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    role varchar(255)  NOT NULL,
    CONSTRAINT machine_pk PRIMARY KEY (id)
);

-- Table: sensor_connection
CREATE TABLE sensor_connection (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    device_id int  NOT NULL,
    machine_id int  NOT NULL,
    connection_start_time timestamp  NOT NULL,
    time_interval interval  NOT NULL,
    CONSTRAINT sensor_connection_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: sensor_connection_device (table: sensor_connection)
ALTER TABLE sensor_connection ADD CONSTRAINT sensor_connection_device
    FOREIGN KEY (device_id)
    REFERENCES device (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: sensor_connection_machine (table: sensor_connection)
ALTER TABLE sensor_connection ADD CONSTRAINT sensor_connection_machine
    FOREIGN KEY (machine_id)
    REFERENCES machine (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

