// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import com.aio.downloader.adapter.ApprecommendkeywordAdapter;
import com.aio.downloader.model.SearchkeywordModel;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import com.aio.downloader.views.DeletableEditText;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.aio.downloader.activity:
//            MinigamesSearchResultActivity

public class MinigameRecommendActivity extends Activity
    implements android.view.View.OnClickListener
{
    class Minigamekeywords extends AsyncTask
    {

        final MinigameRecommendActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            list = new ArrayList();
            return publicTools.getUrl("http://android.downloadatoz.com/_201409/market/minigame_search_recommend_list.php");
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
            }
            try
            {
                list.addAll(Myutils.parseminikeywords(s));
                adapter = new ApprecommendkeywordAdapter(getApplicationContext(), list);
                serchgridview.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                progressheel.setVisibility(8);
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            search_view.setHint(((SearchkeywordModel)list.get(0)).getKeyword());
            progress_wheel.setVisibility(8);
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progress_wheel.setVisibility(0);
        }

        Minigamekeywords()
        {
            this$0 = MinigameRecommendActivity.this;
            super();
        }
    }


    private ApprecommendkeywordAdapter adapter;
    private String gamekeywords;
    private List list;
    private ProgressWheel progress_wheel;
    private ProgressWheel progressheel;
    private DeletableEditText search_view;
    private ImageView searchfan;
    private ImageView searchimg;
    private GridView serchgridview;

    public MinigameRecommendActivity()
    {
        gamekeywords = "";
    }

    private void buildListener()
    {
        searchfan.setOnClickListener(this);
        serchgridview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final MinigameRecommendActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(MinigameRecommendActivity.this, com/aio/downloader/activity/MinigamesSearchResultActivity);
                adapterview.putExtra("searchkeywords", ((SearchkeywordModel)list.get(i)).getKeyword());
                startActivity(adapterview);
            }

            
            {
                this$0 = MinigameRecommendActivity.this;
                super();
            }
        });
        search_view.setOnKeyListener(new android.view.View.OnKeyListener() {

            final MinigameRecommendActivity this$0;

            public boolean onKey(View view, int i, KeyEvent keyevent)
            {
label0:
                {
                    if (keyevent.getAction() == 0 && i == 66)
                    {
                        if (TextUtils.isEmpty(search_view.getText()))
                        {
                            break label0;
                        }
                        gamekeywords = search_view.getText().toString();
                        view = new Intent(MinigameRecommendActivity.this, com/aio/downloader/activity/MinigamesSearchResultActivity);
                        view.putExtra("searchkeywords", gamekeywords);
                        startActivity(view);
                    }
                    return false;
                }
                view = new Intent(MinigameRecommendActivity.this, com/aio/downloader/activity/MinigamesSearchResultActivity);
                view.putExtra("searchkeywords", ((SearchkeywordModel)list.get(0)).getKeyword());
                startActivity(view);
                return false;
            }

            
            {
                this$0 = MinigameRecommendActivity.this;
                super();
            }
        });
        searchimg.setOnClickListener(new android.view.View.OnClickListener() {

            final MinigameRecommendActivity this$0;

            public void onClick(View view)
            {
                if (!TextUtils.isEmpty(search_view.getText()))
                {
                    gamekeywords = search_view.getText().toString();
                    view = new Intent(MinigameRecommendActivity.this, com/aio/downloader/activity/MinigamesSearchResultActivity);
                    view.putExtra("searchkeywords", gamekeywords);
                    startActivity(view);
                    return;
                } else
                {
                    view = new Intent(MinigameRecommendActivity.this, com/aio/downloader/activity/MinigamesSearchResultActivity);
                    view.putExtra("searchkeywords", ((SearchkeywordModel)list.get(0)).getKeyword());
                    startActivity(view);
                    return;
                }
            }

            
            {
                this$0 = MinigameRecommendActivity.this;
                super();
            }
        });
    }

    private void init()
    {
        progress_wheel = (ProgressWheel)findViewById(0x7f070072);
        searchfan = (ImageView)findViewById(0x7f0702db);
        serchgridview = (GridView)findViewById(0x7f0702dd);
        progressheel = (ProgressWheel)findViewById(0x7f070072);
        search_view = (DeletableEditText)findViewById(0x7f0702dc);
        searchimg = (ImageView)findViewById(0x7f07015c);
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
        setContentView(0x7f030078);
        init();
        buildListener();
        (new Minigamekeywords()).execute(new Void[0]);
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
