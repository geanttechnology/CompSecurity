// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.umeng.analytics.MobclickAgent;

public class ComingSongActivity extends Activity
    implements android.view.View.OnClickListener
{

    private static Typeface typeFace = null;
    private ImageView appfan;
    private EditText et_search_keywords;
    private String searchtitle;

    public ComingSongActivity()
    {
    }

    private void buildListener()
    {
        appfan.setOnClickListener(this);
    }

    private void init()
    {
        appfan = (ImageView)findViewById(0x7f0700fd);
        et_search_keywords = (EditText)findViewById(0x7f07010e);
        et_search_keywords.setHint(searchtitle);
        typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
        et_search_keywords.setTypeface(typeFace);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131165437: 
            finish();
            break;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030029);
        searchtitle = getIntent().getStringExtra("title");
        init();
        buildListener();
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
