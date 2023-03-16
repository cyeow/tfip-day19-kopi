# Controller > Rest Controller > Kenneth's Rest Controller
Big note: Rest controller works locally but cannot be called by the controller when run on localhost. It has been deployed on https://kopi-teh-production.up.railway.app/, ping me if you want to test the website and it's down.

## Rest controller
- POST: <url>/api/pingkenneth?username=xyz&name=abc&price=23.9 (parameters are optional; default values have been set)
- GET: <url>/api/get-all

## Web 
- create item: <url>/
- list all items: <url>/show-all

## Required values
- QPURL: quotation-production endpoint
- RESTURL: coffee rest controller endpoint (<url>/api)