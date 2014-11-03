insert into Roles (id, role) values (1, 'ROLE_ADMIN'), (2, 'ROLE_USER'), (3, 'manager');
insert into Users (id, name, password) values (1, 'admin', '$2a$10$uxatpmywQLMS7y/qj5Z03ecXj.bd7p21ByXF5eTkz0nmh37sAMf5y');
insert into Users (id, name, password) values (2, 'user', '$2a$10$kG/rqMDg11qXcokSItwBX.OcWQveXbnvpsPLPqqq.qzNL8FhetZ8C');
insert into Users (id, name, password) values (3, 'manager', '$2a$10$z/s33KN/N5PgPuVBBSI3r.bZiQUDltJcdpzNWP5pxR.43/1cvXfxu');
insert into users_roles (user_id, role_id) values (1, 1), (2, 2), (3, 3);
