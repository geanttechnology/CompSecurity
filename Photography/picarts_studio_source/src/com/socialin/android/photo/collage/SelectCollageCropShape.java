// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.collage;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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

// Referenced classes of package com.socialin.android.photo.collage:
//            b, a

public class SelectCollageCropShape extends AdBaseActivity
{

    public SelectCollageCropShape()
    {
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f0301ad);
        AnalyticUtils.getInstance(this).trackLocalAction("selectCollageCropShape:onCreate");
        bundle = (GridView)findViewById(0x7f10080d);
        bundle.setAdapter(new b(this));
        bundle.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            private SelectCollageCropShape a;

            public final void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent();
                adapterview.putExtra("shape", a.c[i]);
                a.setResult(-1, adapterview);
                a.finish();
                AnalyticUtils.getInstance(a).trackLocalAction("selectCollageCropShape:selectItem");
            }

            
            {
                a = SelectCollageCropShape.this;
                super();
            }
        });
        bundle = getSupportActionBar();
        bundle.setDisplayHomeAsUpEnabled(true);
        bundle.setBackgroundDrawable(getResources().getDrawable(0x7f0205b6));
        bundle.setTitle(0x7f080609);
        initAd();
    }

    protected void onDestroy()
    {
        super.onDestroy();
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
        AnalyticUtils.getInstance(this).trackLocalAction("selectCollageCropShape:back");
        if (true) goto _L1; else goto _L3
_L3:
    }
}
