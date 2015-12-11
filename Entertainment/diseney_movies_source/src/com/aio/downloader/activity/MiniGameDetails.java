// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.aio.downloader.model.MiniGameModel;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.utils.publicTools;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.activity:
//            MiniGamePlayActivity

public class MiniGameDetails extends Activity
    implements android.view.View.OnClickListener
{

    private static Typeface typeFace = null;
    private AdView adView;
    private MyApplcation app;
    private TextView backtv;
    private LinearLayout banner;
    private String banner_type_name;
    private TextView dec;
    private ImageView detailfan;
    private Button detailplaytop;
    private Button gamedetailplaybottom;
    private int id;
    private ArrayList list;
    private RatingBar minigame_ratingbar;
    private TextView minigamehints;
    private ImageView minigameicon;
    private TextView minigametitle;
    private SharedPreferences sp_config;

    public MiniGameDetails()
    {
        sp_config = null;
    }

    private void buildListener()
    {
        detailfan.setOnClickListener(this);
        gamedetailplaybottom.setOnClickListener(this);
        detailplaytop.setOnClickListener(this);
    }

    private void getData()
    {
        minigametitle.setText(((MiniGameModel)list.get(id)).getTitle());
        app.asyncLoadImage(((MiniGameModel)list.get(id)).getIcon(), minigameicon);
        if (id % 2 == 0)
        {
            minigame_ratingbar.setRating(4F);
        } else
        {
            minigame_ratingbar.setRating(5F);
        }
        minigamehints.setText((new StringBuilder("More than ")).append(((MiniGameModel)list.get(id)).getHits()).toString());
        dec.setText(((MiniGameModel)list.get(id)).getDetail());
    }

    private void init()
    {
        detailfan = (ImageView)findViewById(0x7f070098);
        backtv = (TextView)findViewById(0x7f0702cf);
        minigameicon = (ImageView)findViewById(0x7f0702c9);
        minigametitle = (TextView)findViewById(0x7f0702ca);
        minigame_ratingbar = (RatingBar)findViewById(0x7f0702cb);
        minigamehints = (TextView)findViewById(0x7f0702cc);
        detailplaytop = (Button)findViewById(0x7f0700a5);
        dec = (TextView)findViewById(0x7f0702d1);
        gamedetailplaybottom = (Button)findViewById(0x7f0702d2);
        banner = (LinearLayout)findViewById(0x7f070059);
        sp_config = getSharedPreferences("banner_type", 0);
        typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
        backtv.setTypeface(typeFace);
        try
        {
            app = (MyApplcation)getApplicationContext().getApplicationContext();
        }
        catch (Exception exception1) { }
        try
        {
            id = getIntent().getIntExtra("pos", 0);
            list = (ArrayList)getIntent().getSerializableExtra("list");
        }
        catch (Exception exception) { }
        banner_type_name = sp_config.getString("banner_type", "admob");
        if (banner_type_name.equals("admob"))
        {
            adView = new AdView(this, AdSize.SMART_BANNER, "ca-app-pub-2192624499353475/5842010949");
            banner.addView(adView);
            adView.loadAd(new AdRequest());
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131165336: 
            finish();
            return;

        case 2131165349: 
            (new Thread(new Runnable() {

                final MiniGameDetails this$0;

                public void run()
                {
                    publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=minigame&id=")).append(((MiniGameModel)list.get(id)).getSerial()).append("&title=").append(((MiniGameModel)list.get(id)).getTitle()).toString());
                }

            
            {
                this$0 = MiniGameDetails.this;
                super();
            }
            })).start();
            view = new Intent(this, com/aio/downloader/activity/MiniGamePlayActivity);
            view.putExtra("playurl", ((MiniGameModel)list.get(id)).getPlay_url());
            view.putExtra("proc", ((MiniGameModel)list.get(id)).getProc());
            view.putExtra("sound", ((MiniGameModel)list.get(id)).getSound());
            startActivity(view);
            return;

        case 2131165906: 
            (new Thread(new Runnable() {

                final MiniGameDetails this$0;

                public void run()
                {
                    publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=minigame&id=")).append(((MiniGameModel)list.get(id)).getSerial()).append("&title=").append(((MiniGameModel)list.get(id)).getTitle()).toString());
                }

            
            {
                this$0 = MiniGameDetails.this;
                super();
            }
            })).start();
            break;
        }
        view = new Intent(this, com/aio/downloader/activity/MiniGamePlayActivity);
        view.putExtra("playurl", ((MiniGameModel)list.get(id)).getPlay_url());
        view.putExtra("proc", ((MiniGameModel)list.get(id)).getProc());
        view.putExtra("sound", ((MiniGameModel)list.get(id)).getSound());
        startActivity(view);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030075);
        init();
        buildListener();
        getData();
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
