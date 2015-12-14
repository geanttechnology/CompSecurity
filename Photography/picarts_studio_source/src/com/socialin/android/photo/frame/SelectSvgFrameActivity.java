// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.frame;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.c;

// Referenced classes of package com.socialin.android.photo.frame:
//            c, a

public class SelectSvgFrameActivity extends AdBaseActivity
    implements android.view.View.OnClickListener, android.widget.AdapterView.OnItemClickListener
{

    public final String a = (new StringBuilder()).append(com/socialin/android/photo/frame/SelectSvgFrameActivity.getSimpleName()).append("_").append(System.currentTimeMillis()).toString();
    private android.graphics.BitmapFactory.Options b;

    public SelectSvgFrameActivity()
    {
        new Handler();
        b = new android.graphics.BitmapFactory.Options();
    }

    static android.graphics.BitmapFactory.Options a(SelectSvgFrameActivity selectsvgframeactivity)
    {
        return selectsvgframeactivity.b;
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    public void onClick(View view)
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f0301b3);
        AnalyticUtils.getInstance(this).trackLocalAction("frameSvgCategory:onCreate");
        bundle = (GridView)findViewById(0x7f100636);
        bundle.setAdapter(new com.socialin.android.photo.frame.c(this));
        bundle.setOnItemClickListener(this);
        bundle = getSupportActionBar();
        bundle.setDisplayHomeAsUpEnabled(true);
        bundle.setBackgroundDrawable(getResources().getDrawable(0x7f0205b6));
        bundle.setTitle(0x7f08060a);
        initAd();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        c.b(a);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent();
        adapterview.putExtra("resId", a.f[i]);
        setResult(-1, adapterview);
        finish();
        AnalyticUtils.getInstance(this).trackLocalAction("frameSvgCategory:done");
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 24
    //                   16908332 26;
           goto _L1 _L2
_L1:
        return true;
_L2:
        finish();
        if (true) goto _L1; else goto _L3
_L3:
    }
}
