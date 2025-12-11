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
