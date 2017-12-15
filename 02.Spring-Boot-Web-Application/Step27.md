## What we will do:
- One More Spring Rest Services.
- @PathVariable("id") int id
- http://localhost:8080/rest/todos/1

## Useful Snippets

```
    @RequestMapping(value = "/rest/todos/{id}", method = RequestMethod.GET)
    public Todo retrieveTodo(@PathVariable("id") int id) {
        return service.retrieveTodo(id);
    }

```
## Files List
