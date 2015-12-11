// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.umeng.analytics.MobclickAgent;

public class AppDetatils_moreActivity extends Activity
{

    private ImageView iv_dea_back;
    private TextView tv_dea_download;
    private TextView tv_dea_sheart;
    private TextView tv_dea_size;
    private TextView tv_dea_title;
    private TextView tv_dea_up;
    private TextView tv_dea_ver;
    private TextView tv_dea_zhengwen;
    private Typeface typeFace;

    public AppDetatils_moreActivity()
    {
        typeFace = null;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030079);
        tv_dea_title = (TextView)findViewById(0x7f0702df);
        iv_dea_back = (ImageView)findViewById(0x7f0702de);
        tv_dea_sheart = (TextView)findViewById(0x7f0702e0);
        tv_dea_zhengwen = (TextView)findViewById(0x7f0702e1);
        tv_dea_ver = (TextView)findViewById(0x7f0702e2);
        tv_dea_up = (TextView)findViewById(0x7f0702e4);
        tv_dea_download = (TextView)findViewById(0x7f0702e3);
        tv_dea_size = (TextView)findViewById(0x7f0702e5);
        bundle = getIntent().getStringExtra("dea_title");
        String s = getIntent().getStringExtra("dea_sheart");
        String s1 = getIntent().getStringExtra("dea_dea");
        getIntent().getStringExtra("dea_up");
        getIntent().getStringExtra("dea_ver");
        getIntent().getStringExtra("dea_down");
        getIntent().getStringExtra("dea_size");
        try
        {
            typeFace = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        }
        catch (Exception exception) { }
        tv_dea_sheart.setTypeface(typeFace);
        tv_dea_title.setText(bundle);
        tv_dea_sheart.setText(s);
        tv_dea_zhengwen.setText((new StringBuilder(String.valueOf(s1))).append("\n").toString());
        tv_dea_ver.setText(getIntent().getStringExtra("dea_ver"));
        tv_dea_up.setText(getIntent().getStringExtra("dea_up"));
        tv_dea_download.setText((new StringBuilder(String.valueOf(getIntent().getStringExtra("dea_down")))).append("downloads").toString());
        tv_dea_size.setText(getIntent().getStringExtra("dea_size"));
        iv_dea_back.setOnClickListener(new android.view.View.OnClickListener() {

            final AppDetatils_moreActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = AppDetatils_moreActivity.this;
                super();
            }
        });
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
