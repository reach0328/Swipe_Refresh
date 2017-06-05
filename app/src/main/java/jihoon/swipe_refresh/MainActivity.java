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


    //더미 리스트 아이템
    String[] LIST_MENU = {"LIST1", "LIST2", "LIST3","LIST1", "LIST2", "LIST3","LIST1", "LIST2"
            , "LIST3","LIST1", "LIST2", "LIST3","LIST1", "LIST2", "LIST3","LIST1", "LIST2", "LIST3"} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_layout);
        listView = (ListView) findViewById(R.id.listview);


        //더미 데이터 Adapter세팅
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, LIST_MENU) ;
        listView.setAdapter(adapter);

        //한바퀴 마다 색상 변경
        swipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );

        //refresh 리스너 등록
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // animation을 멈추려면, fasle로 설정
                swipeRefreshLayout.setRefreshing(true);
            }
        });
    }
}
