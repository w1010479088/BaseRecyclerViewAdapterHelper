package com.chad.baserecyclerviewadapterhelper;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.chad.baserecyclerviewadapterhelper.adapter.ItemDragAdapter;
import com.chad.baserecyclerviewadapterhelper.base.BaseActivity;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class ItemDragAndSwipeUseActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_touch_use);

        setBackBtn();
        setTitle("ItemDrag  And Swipe");
        RecyclerView recyclerView = findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<String> data = generateData(50);
        configDragConfig(recyclerView, data);
    }

    private void configDragConfig(RecyclerView recyclerView, List<String> data) {
        ItemDragAdapter adapter = new ItemDragAdapter(data);
        ItemDragAndSwipeCallback callback = new ItemDragAndSwipeCallback(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        callback.setSwipeMoveFlags(ItemTouchHelper.START | ItemTouchHelper.END);
        adapter.enableSwipeItem();
        adapter.enableDragItem(touchHelper);

        recyclerView.setAdapter(adapter);
    }

    private List<String> generateData(int size) {
        ArrayList<String> data = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            data.add("item " + i);
        }
        return data;
    }
}
