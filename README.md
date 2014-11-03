RestLogin
=========

Simple Rest Oauth2 login with BCrypt password encode

Get access_token:
URL:   http://localhost:8080/oauth/token?grant_type=password&client_id=webstoreadmin&client_secret=webstore-admin-secret-key&username=manager&password=manager

Get refresh_token:
URL:   http://localhost:8080/oauth/token?grant_type=refresh_token&client_id=webstoreadmin&client_secret=webstore-admin-secret-key&refresh_token=YOUR_REFRESH_TOKEN

Access to resources (allow only role 'manager'):
URL:   http://localhost:8080/protected/user/1 
HEADER Authorization: bearer YOUR_ACCESS_TOKEN

For everyone:
URL:   http://localhost:8080/protected/userId/1 
HEADER Authorization: bearer YOUR_ACCESS_TOKEN
