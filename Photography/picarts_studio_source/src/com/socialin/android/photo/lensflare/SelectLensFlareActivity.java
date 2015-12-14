// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.lensflare;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.net.a;
import com.socialin.android.photo.h;
import com.socialin.android.photo.i;
import com.socialin.android.photo.j;
import com.socialin.android.util.Utils;
import java.io.File;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo.lensflare:
//            c, LensFlareFactory

public class SelectLensFlareActivity extends AdBaseActivity
    implements i, j
{

    private h a;
    private a b;
    private GridView c;
    private boolean d;

    public SelectLensFlareActivity()
    {
        d = false;
    }

    private void a()
    {
        setContentView(0x7f0301b7);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle(0x7f08060b);
        actionbar.setBackgroundDrawable(getResources().getDrawable(0x7f0205b6));
        initAd();
        c = (GridView)findViewById(0x7f100818);
        c.setAdapter(new c(this));
        c.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            private SelectLensFlareActivity a;

            public final void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(a.getString(0x7f0808fb)).append("/").append(a.getString(0x7f0808dc)).append("/lensflare/source/").append(com.socialin.android.photo.lensflare.LensFlareFactory.a(k)).toString();
                try
                {
                    com.picsart.shop.a.a(a.getApplicationContext()).a(adapterview, "info.json");
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                    (new File(adapterview)).delete();
                }
                com.socialin.android.photo.lensflare.SelectLensFlareActivity.a(a, k);
            }

            
            {
                a = SelectLensFlareActivity.this;
                super();
            }
        });
    }

    static void a(SelectLensFlareActivity selectlensflareactivity, int k)
    {
        if (selectlensflareactivity.b == null)
        {
            selectlensflareactivity.b = m.b(selectlensflareactivity);
        }
        if (selectlensflareactivity.a == null)
        {
            selectlensflareactivity.d = true;
            return;
        } else
        {
            selectlensflareactivity.a.a = k;
            selectlensflareactivity.a.b = selectlensflareactivity.c(k);
            selectlensflareactivity.a.a();
            h.a(selectlensflareactivity, k, selectlensflareactivity.b);
            return;
        }
    }

    public final void a(int k)
    {
        Intent intent = new Intent();
        intent.putExtra("lensFlareIndex", k);
        setResult(-1, intent);
        finish();
        AnalyticUtils.getInstance(this).trackLocalAction("lensFlare:done");
    }

    public final String b(int k)
    {
        return (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append("lensflare/source/1024/").append(com.socialin.android.photo.lensflare.LensFlareFactory.a(k)).toString();
    }

    public final String c(int k)
    {
        return (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(getString(0x7f0808fb)).append("/").append(getString(0x7f0808dc)).append("/lensflare/source/").append(com.socialin.android.photo.lensflare.LensFlareFactory.a(k)).toString();
    }

    public void finish()
    {
        super.finish();
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    public final int getCount()
    {
        return com.socialin.android.photo.lensflare.LensFlareFactory.a();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        a();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        AnalyticUtils.getInstance(this).trackLocalAction("lensFlare:onCreate");
        b = m.b(this);
        a = new h(this, this);
        if (d)
        {
            d = false;
        }
        a();
        Utils.b(hashCode());
    }

    protected void onDestroy()
    {
        super.onDestroy();
        System.gc();
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
        setResult(0);
        finish();
        AnalyticUtils.getInstance(this).trackLocalAction("callout:exit");
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onPause()
    {
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        Utils.b(hashCode());
    }

    public void onStart()
    {
        super.onStart();
        if (b != null)
        {
            b.a(a);
        }
    }

    public void onStop()
    {
        super.onStop();
        if (b != null)
        {
            b.b();
        }
    }

    static 
    {
        com/socialin/android/photo/lensflare/SelectLensFlareActivity.getSimpleName();
    }
}
