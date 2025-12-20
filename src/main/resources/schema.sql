CREATE TABLE IF NOT EXISTS `contact_msg` (
    `contact_id` int AUTO_INCREMENT PRIMARY KEY ,
    `name` varchar(100) NOT NULL ,
    `mobile_num` varchar(15) NOT NULL ,
    `email` varchar(50) NOT NULL ,
    `subject` varchar(100) NOT NULL ,
    `message` varchar(500) NOT NULL ,
    `status` varchar(10) NOT NULL ,
    `created_at` TIMESTAMP NOT NULL ,
    `created_by` varchar(50) NOT NULL ,
    `updated_at` TIMESTAMP DEFAULT NULL ,
    `updated_by` varchar(50) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `holidays`(
    `day` VARCHAR(15) NOT NULL,
    `reason` VARCHAR(100) NOT NULL,
    `type` VARCHAR(20) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` VARCHAR(50) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` VARCHAR(50) DEFAULT NULL
    );

CREATE TABLE IF NOT EXISTS `roles` (
    `role_id` INT AUTO_INCREMENT PRIMARY KEY,
    `role_name` VARCHAR(50) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` VARCHAR(50) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` VARCHAR(50) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `address` (
    `address_id` INT AUTO_INCREMENT PRIMARY KEY,
    `address1` VARCHAR(200) NOT NULL,
    `address2` VARCHAR(200) DEFAULT NULL,
    `city` VARCHAR(50) NOT NULL,
    `state` VARCHAR(50) NOT NULL,
    `zip_code` VARCHAR(10) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` VARCHAR(50) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` VARCHAR(50) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `person`(
    `person_id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `mobile_number` VARCHAR(15) NOT NULL,
    `pwd` VARCHAR(100) NOT NULL,
    `role_id` int NOT NULL,
    `address_id` INT,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` VARCHAR(50) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` VARCHAR(50) DEFAULT NULL,
    FOREIGN KEY (`address_id`) REFERENCES `address`(`address_id`),
    FOREIGN KEY (`role_id`) REFERENCES `roles`(`role_id`)
);





