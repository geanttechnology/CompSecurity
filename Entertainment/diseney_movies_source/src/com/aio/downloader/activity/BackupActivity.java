// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.aio.downloader.adapter.BackupNoRootAdapter;
import com.aio.downloader.adapter.TabPagerAdapter;
import com.aio.downloader.views.LImageButton;
import com.aio.downloader.views.LTabIndicator;
import com.stericson.RootTools.RootTools;
import com.umeng.analytics.MobclickAgent;

public class BackupActivity extends FragmentActivity
{

    private LImageButton header_left_aoto;
    private LTabIndicator lineTabIndicator;
    private ViewPager vp_aoto;

    public BackupActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(0x7f03001f);
        header_left_aoto = (LImageButton)findViewById(0x7f070120);
        lineTabIndicator = (LTabIndicator)findViewById(0x7f070121);
        vp_aoto = (ViewPager)findViewById(0x7f070122);
        header_left_aoto.setOnClickListener(new android.view.View.OnClickListener() {

            final BackupActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = BackupActivity.this;
                super();
            }
        });
        if (RootTools.isRootAvailable())
        {
            vp_aoto.setAdapter(new TabPagerAdapter(this, getSupportFragmentManager()));
            lineTabIndicator.setViewPager(vp_aoto);
            return;
        } else
        {
            vp_aoto.setAdapter(new BackupNoRootAdapter(this, getSupportFragmentManager()));
            lineTabIndicator.setViewPager(vp_aoto);
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
