package com.example.turbo.androidtutorial;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListPage extends AppCompatActivity {

    String[] listItems = {"Introduction to Android", "UI Layouts", "UI Controls", "Input Controls", "Input Events", "Toast", "Buttons", "Intent", "Bundle", "Shared Preference", "List View", "Styles and Themes", "Credits"};
    ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_page);

        ListAdapter myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        myList = (ListView)findViewById(R.id.newList);
        myList.setAdapter(myAdapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                    Intent newIntent = new Intent(Intent.ACTION_VIEW);
                    newIntent.setData(Uri.parse("https://developer.android.com/guide/index.html"));
                    startActivity(newIntent);
                }
                else if(i==1)
                {
                    Intent newIntent = new Intent(Intent.ACTION_VIEW);
                    newIntent.setData(Uri.parse("https://developer.android.com/guide/topics/ui/declaring-layout.html"));
                    startActivity(newIntent);
                }
                else if(i==2)
                {
                    Intent newIntent = new Intent(Intent.ACTION_VIEW);
                    newIntent.setData(Uri.parse("https://developer.android.com/guide/topics/ui/controls.html"));
                    startActivity(newIntent);
                }
                else if(i==3)
                {
                    Intent newIntent = new Intent(Intent.ACTION_VIEW);
                    newIntent.setData(Uri.parse("https://developer.android.com/guide/topics/ui/controls.html"));
                    startActivity(newIntent);
                }
                else if(i==4)
                {
                    Intent newIntent = new Intent(Intent.ACTION_VIEW);
                    newIntent.setData(Uri.parse("https://developer.android.com/guide/topics/ui/ui-events.html"));
                    startActivity(newIntent);
                }
                else if(i==5)
                {
                    Intent newIntent = new Intent(Intent.ACTION_VIEW);
                    newIntent.setData(Uri.parse("https://developer.android.com/guide/topics/ui/notifiers/toasts.html"));
                    startActivity(newIntent);
                }
                else if(i==6)
                {
                    Intent newIntent = new Intent(Intent.ACTION_VIEW);
                    newIntent.setData(Uri.parse("https://developer.android.com/guide/topics/ui/controls/button.html"));
                    startActivity(newIntent);
                }
                else if(i==7)
                {
                    Intent newIntent = new Intent(Intent.ACTION_VIEW);
                    newIntent.setData(Uri.parse("https://developer.android.com/guide/components/intents-filters.html"));
                    startActivity(newIntent);
                }
                else if(i==8)
                {
                    Intent newIntent = new Intent(Intent.ACTION_VIEW);
                    newIntent.setData(Uri.parse("https://developer.android.com/reference/android/os/Bundle.html"));
                    startActivity(newIntent);
                }
                else if(i==9)
                {
                    Intent newIntent = new Intent(Intent.ACTION_VIEW);
                    newIntent.setData(Uri.parse("https://developer.android.com/training/basics/data-storage/shared-preferences.html"));
                    startActivity(newIntent);
                }
                else if(i==10)
                {
                    Intent newIntent = new Intent(Intent.ACTION_VIEW);
                    newIntent.setData(Uri.parse("https://developer.android.com/guide/topics/ui/layout/listview.html"));
                    startActivity(newIntent);
                }
                else if(i==11)
                {
                    Intent newIntent = new Intent(Intent.ACTION_VIEW);
                    newIntent.setData(Uri.parse("https://developer.android.com/guide/topics/ui/look-and-feel/themes.html"));
                    startActivity(newIntent);
                }
                else if(i==12)
                {
                    Intent newIntent = new Intent(ListPage.this, CreditsPage.class);
                    startActivity(newIntent);
                }
            }
        });
    }
}
