# Simple Inventory Viewer

## Assumptions
1. Backend host is localhost.
2. Backend port is 8081 (configurable via application.properties).
3. Backend exposes a single endpoint to fetch inventory items.
4. Inventory data is loaded via data.sql and no endpoints exist for CUD of inventory records.
5. Embedded container is used for backend service.


## Description 

This application contains two parts:
1. Backend - Uses SpringBoot and embedded container  
2. UI - Uses Angular

## Backend 

### Build  
Backend uses gradle as the build tool.

1. Backend directory context

```
    cd {ROOT_DIR}/backend
```

2. To build code from backend directory context
```
    gradle clean build
```

3. To execute backend application using embedded container from backend directory context
```
   gradle bootrun 
```
    
### API Documentation

```
API Name : Get Inventory Intems 

HTTP Verb : GET 

Resource: /inventory-items

Query Parameters:
                1. page : Page index (optional) 
                2. size : Page size (optional)
 
 Example: 
           All:
           curl --location --request GET 'localhost:8081/inventory-items'
           Paged:
           curl --location --request GET 'localhost:8081/inventory-items?page=0&size=10'
 
```

## UI 

### Deploy

1. UI build context
```
   cd {ROOT_DIR}/ui
```

2. Build and deploy from UI build context:
```
    npm install 
    ng update
    npm update
    ng serve --open
```

### Screenshot

![Screen shot not available][screen_shot]

[screen_shot]: https://github.com/sunnydas/simple-inventory-viewer/blob/master/ui/screen_shot.png "Inventory Viewer"
