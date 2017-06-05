package jihoon.swipe_refresh;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;

    String[] LIST_MENU = {"LIST1", "LIST2", "LIST3","LIST1", "LIST2", "LIST3","LIST1", "LIST2"
            , "LIST3","LIST1", "LIST2", "LIST3","LIST1", "LIST2", "LIST3","LIST1", "LIST2", "LIST3"} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_layout);
        listView = (ListView) findViewById(R.id.listview);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, LIST_MENU) ;
        listView.setAdapter(adapter);


        swipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //예시 3초간 돌기 위하여
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //TODO 서버측에서 데이터 받아오기
                            //새로고침 완료
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

    }
}
