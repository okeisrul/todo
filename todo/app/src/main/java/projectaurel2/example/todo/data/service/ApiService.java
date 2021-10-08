package projectaurel2.example.todo.data.service;

import java.util.ArrayList;

public interface ApiService {

    @GET("v1/todo")
    Call<ArrayList<Todo>> requestListTodo();
}
