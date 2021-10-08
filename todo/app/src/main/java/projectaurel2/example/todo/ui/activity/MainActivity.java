package projectaurel2.example.todo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import java.util.ArrayList;

import projectaurel2.example.todo.R;
import projectaurel2.example.todo.data.conf.NetworkConf;
import projectaurel2.example.todo.data.model.Todo;
import projectaurel2.example.todo.data.service.ApiService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiService apiService = NetworkConf.getApiService();

        apiService.requestListTodo().enqueue(new Callback<ArrayList<Todo>>() {
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                ArrayList<Todo> todos = response.body();
                Toast.makeText(MainActivity.this, "data dari server " + todos.size() Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "terjadi kesalahan" Toast.LENGTH_SHORT).show();
            }
        });
    }
}