// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.aio.downloader.adapter.MinigameListviewAdapter;
import com.aio.downloader.model.MiniGameModel;
import com.aio.downloader.refresh.PullableListView;
import com.aio.downloader.utils.ASCIIutil;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import com.aio.downloader.views.DeletableEditText;
import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.umeng.analytics.MobclickAgent;
import java.net.URLEncoder;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.activity:
//            MiniGameDetails

public class MinigamesSearchResultActivity extends Activity
    implements com.aio.downloader.refresh.PullableListView.OnLoadListener, OnDismissCallback, android.view.View.OnClickListener
{
    class Mya1 extends AsyncTask
    {

        final MinigamesSearchResultActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            searchkeywords = URLEncoder.encode(searchkeywords);
            return ASCIIutil.toparse(publicTools.getUrl((new StringBuilder("http://app.loveitsomuch.com/game/h5/search.php?ucode=abc&version=1.0&keyword=")).append(searchkeywords).append("&page=").append(page).toString()));
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            if (s == null)
            {
                return;
            } else
            {
                ShowResult(s);
                ((RelativeLayout)listView.findViewById(0x7f0701db)).setVisibility(0);
                listView.setVisibility(0);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressWheel.setVisibility(0);
        }

        Mya1()
        {
            this$0 = MinigamesSearchResultActivity.this;
            super();
        }
    }


    private MinigameListviewAdapter adapter;
    private ArrayList list;
    private PullableListView listView;
    private int next;
    private int page;
    private ProgressWheel progressWheel;
    private DeletableEditText search_view;
    private ImageView searchfan;
    private ImageView searchimg;
    private String searchkeywords;
    private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;

    public MinigamesSearchResultActivity()
    {
        list = new ArrayList();
        progressWheel = null;
        page = 1;
        next = 1;
        searchkeywords = "";
    }

    private void ShowResult(String s)
    {
        list.addAll(Myutils.parseminigamelist(s));
        if (page == 1)
        {
            adapter = new MinigameListviewAdapter(this, list);
            listView.setAdapter(adapter);
            swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(adapter);
            swingBottomInAnimationAdapter.setListView(listView);
            listView.setAdapter(swingBottomInAnimationAdapter);
        }
        listView.setHasMoreData(true);
        progressWheel.setVisibility(8);
        adapter.notifyDataSetChanged();
    }

    private void buildListener()
    {
        searchfan.setOnClickListener(this);
        searchimg.setOnClickListener(this);
        search_view.setOnKeyListener(new android.view.View.OnKeyListener() {

            final MinigamesSearchResultActivity this$0;

            public boolean onKey(View view, int i, KeyEvent keyevent)
            {
                if (keyevent.getAction() == 0 && i == 66 && !TextUtils.isEmpty(search_view.getText()))
                {
                    searchkeywords = search_view.getText().toString();
                    list.clear();
                    ((RelativeLayout)listView.findViewById(0x7f0701db)).setVisibility(8);
                    listView.setVisibility(8);
                    (new Mya1()).execute(new Void[0]);
                }
                return false;
            }

            
            {
                this$0 = MinigamesSearchResultActivity.this;
                super();
            }
        });
        searchimg.setOnClickListener(new android.view.View.OnClickListener() {

            final MinigamesSearchResultActivity this$0;

            public void onClick(View view)
            {
                if (!TextUtils.isEmpty(search_view.getText()))
                {
                    searchkeywords = search_view.getText().toString();
                    list.clear();
                    ((RelativeLayout)listView.findViewById(0x7f0701db)).setVisibility(8);
                    listView.setVisibility(8);
                    (new Mya1()).execute(new Void[0]);
                }
            }

            
            {
                this$0 = MinigamesSearchResultActivity.this;
                super();
            }
        });
    }

    private void init()
    {
        searchkeywords = getIntent().getStringExtra("searchkeywords");
        searchfan = (ImageView)findViewById(0x7f0702db);
        search_view = (DeletableEditText)findViewById(0x7f0702dc);
        search_view.setText(searchkeywords);
        searchimg = (ImageView)findViewById(0x7f07015c);
        progressWheel = (ProgressWheel)findViewById(0x7f070072);
        listView = (PullableListView)findViewById(0x7f07006f);
        listView.setOnLoadListener(this);
        listView.setHasMoreData(false);
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final MinigamesSearchResultActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(MinigamesSearchResultActivity.this, com/aio/downloader/activity/MiniGameDetails);
                adapterview.putExtra("pos", i);
                adapterview.putExtra("list", list);
                startActivity(adapterview);
            }

            
            {
                this$0 = MinigamesSearchResultActivity.this;
                super();
            }
        });
        ((InputMethodManager)search_view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(search_view.getWindowToken(), 0);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131165915: 
            finish();
            break;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300af);
        init();
        buildListener();
        (new Mya1()).execute(new Void[0]);
    }

    public void onDismiss(ListView listview, int ai[])
    {
    }

    public void onLoad(PullableListView pullablelistview)
    {
        if (list.size() > 0)
        {
            next = ((MiniGameModel)list.get(list.size() - 1)).getNext();
        }
        if (next == 1)
        {
            page = page + 1;
            (new Mya1()).execute(new Void[0]);
            return;
        } else
        {
            listView.setHasMoreData(false);
            return;
        }
    }

    protected void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    protected void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(this);
    }








}
