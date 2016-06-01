package com.example.jonathandavidblack.todoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    ArrayAdapter<String> items;

    ListView list;
    EditText text;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        text = (EditText) findViewById(R.id.editText);
        addButton = (Button) findViewById(R.id.button); //reaching in and grabbing objects from our gooey so that we can call methods on them etc...

        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1); //initializing
        list.setAdapter(items);

        addButton.setOnClickListener(this); //listener for when the button is clicked
        list.setOnItemLongClickListener(this);

    }

    @Override //will run every time we click our button
    public void onClick(View v) {
        String item = text.getText().toString();
        items.add(item);
        text.setText("");
        // text.clearComposingText();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String item = items.getItem(position);
        items.remove(item);
        return true;
    }
}
