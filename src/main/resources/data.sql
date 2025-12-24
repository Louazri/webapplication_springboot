INSERT INTO `holidays` (`day`, `reason`, `type`, `created_at`, `created_by`)
VALUES ('Jan 1', 'New Year''s Day', 'NATIONAL', CURDATE(), 'DBA');

INSERT INTO `holidays` (`day`, `reason`, `type`, `created_at`, `created_by`)
VALUES ('Jan 11', 'Proclamation of Independence', 'NATIONAL', CURDATE(), 'DBA');

INSERT INTO `holidays` (`day`, `reason`, `type`, `created_at`, `created_by`)
VALUES ('May 1', 'Labour Day', 'NATIONAL', CURDATE(), 'DBA');

INSERT INTO `holidays` (`day`, `reason`, `type`, `created_at`, `created_by`)
VALUES ('Jul 30', 'Throne Day', 'NATIONAL', CURDATE(), 'DBA');

INSERT INTO `holidays` (`day`, `reason`, `type`, `created_at`, `created_by`)
VALUES ('Aug 14', 'Oued Ed-Dahab Day', 'NATIONAL', CURDATE(), 'DBA');

INSERT INTO `holidays` (`day`, `reason`, `type`, `created_at`, `created_by`)
VALUES ('Aug 20', 'Revolution of the King and the People', 'NATIONAL', CURDATE(), 'DBA');

INSERT INTO `holidays` (`day`, `reason`, `type`, `created_at`, `created_by`)
VALUES ('Aug 21', 'Youth Day', 'NATIONAL', CURDATE(), 'DBA');

INSERT INTO `holidays` (`day`, `reason`, `type`, `created_at`, `created_by`)
VALUES ('Nov 6', 'Green March', 'NATIONAL', CURDATE(), 'DBA');

INSERT INTO `holidays` (`day`, `reason`, `type`, `created_at`, `created_by`)
VALUES ('Nov 18', 'Independence Day', 'NATIONAL', CURDATE(), 'DBA');

-- Islamic holidays (variable dates)
INSERT INTO `holidays` (`day`, `reason`, `type`, `created_at`, `created_by`)
VALUES ('Variable', 'Eid al-Fitr', 'RELIGIOUS', CURDATE(), 'DBA');

INSERT INTO `holidays` (`day`, `reason`, `type`, `created_at`, `created_by`)
VALUES ('Variable', 'Eid al-Adha', 'RELIGIOUS', CURDATE(), 'DBA');

INSERT INTO `holidays` (`day`, `reason`, `type`, `created_at`, `created_by`)
VALUES ('Variable', 'Aashura', 'RELIGIOUS', CURDATE(), 'DBA');

INSERT INTO `holidays` (`day`, `reason`, `type`, `created_at`, `created_by`)
VALUES ('Variable', 'Mawlid (Prophet''s Birthday)', 'RELIGIOUS', CURDATE(), 'DBA');



INSERT INTO `roles` (`role_name`, `created_at`, `created_by`)
VALUES ('ADMIN', CURDATE(), 'DBA');
INSERT INTO `roles` (`role_name`, `created_at`, `created_by`)
VALUES ('STUDENT', CURDATE(), 'DBA');



INSERT INTO `person` (`name`, `email`, `mobile_number`, `pwd`, `role_id`, `created_at`, `created_by`)
VALUES ('Admin', 'admin@gmail.com', '0600000000', 'Admin@+#1', 1, CURDATE(), 'DBA');
