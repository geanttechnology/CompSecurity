// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.library.activity;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import apq;
import azn;
import bby;
import bbz;
import bca;
import bcb;
import bcc;
import bcn;
import bcv;
import bcx;
import bcz;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.comlib.util.ImageCache;
import com.fotoable.fotobeauty.FullscreenActivity;
import com.fotoable.view.actionbar.CommonActionBarView;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.activity.photoselector.InstaPhotoSelectorActivity;
import zr;
import zu;

public class MainDownloadActivity extends FullscreenActivity
{

    CommonActionBarView a;
    private String b;
    private ProgressDialog c;
    private TPhotoMagComposeManager d;
    private TPhotoComposeInfo e;
    private Button f;
    private ImageView g;
    private Button h;
    private BroadcastReceiver i;
    private bcz j;
    private bcx k;
    private boolean l;

    public MainDownloadActivity()
    {
        b = "MainDownloadActivity";
        i = null;
        l = false;
    }

    public static TPhotoComposeInfo a(MainDownloadActivity maindownloadactivity)
    {
        return maindownloadactivity.e;
    }

    public static void a(MainDownloadActivity maindownloadactivity, TPhotoComposeInfo tphotocomposeinfo)
    {
        maindownloadactivity.a(tphotocomposeinfo);
    }

    private void a(TPhotoComposeInfo tphotocomposeinfo)
    {
        Intent intent = new Intent(this, com/wantu/activity/photoselector/InstaPhotoSelectorActivity);
        intent.putExtra("SelectedComposeInfoResId", tphotocomposeinfo.resId);
        intent.putExtra("SelectedComposeInfoImageCount", tphotocomposeinfo.imageCount);
        startActivity(intent);
        finish();
    }

    public static boolean a(MainDownloadActivity maindownloadactivity, boolean flag)
    {
        maindownloadactivity.l = flag;
        return flag;
    }

    public static bcx b(MainDownloadActivity maindownloadactivity)
    {
        return maindownloadactivity.k;
    }

    public static Button c(MainDownloadActivity maindownloadactivity)
    {
        return maindownloadactivity.h;
    }

    public static ImageView d(MainDownloadActivity maindownloadactivity)
    {
        return maindownloadactivity.g;
    }

    public static Button e(MainDownloadActivity maindownloadactivity)
    {
        return maindownloadactivity.f;
    }

    private bcz g()
    {
        if (j == null)
        {
            zr zr1 = new zr(getApplicationContext(), ImageCache.b);
            zr1.a(0.05F);
            zr1.g = true;
            j = new bcz(this, 960, 960);
            j.a(getSupportFragmentManager(), zr1);
        }
        return j;
    }

    private bcx h()
    {
        if (k == null)
        {
            k = new bcc(this);
        }
        return k;
    }

    protected void a()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("ACTION_MAG_MATERIAL_SHARETOWECHAT");
        registerReceiver(i, intentfilter);
    }

    public void a(String s)
    {
        if (c != null && c.isShowing())
        {
            return;
        } else
        {
            c = ProgressDialog.show(this, "", s);
            return;
        }
    }

    public TPhotoMagComposeManager b()
    {
        if (d == null)
        {
            d = apq.c().d();
        }
        return d;
    }

    public void backBtnClicked(View view)
    {
        c();
    }

    public void c()
    {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        if (fragmentmanager.getBackStackEntryCount() > 0)
        {
            FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
            fragmentmanager.popBackStack(fragmentmanager.getBackStackEntryAt(fragmentmanager.getBackStackEntryCount() - 1).getId(), 1);
            fragmenttransaction.commitAllowingStateLoss();
            return;
        } else
        {
            finish();
            overridePendingTransition(0x10a0002, 0x10a0003);
            System.gc();
            return;
        }
    }

    public void d()
    {
        Intent intent = new Intent(this, com/wantu/activity/photoselector/InstaPhotoSelectorActivity);
        intent.putExtra("SelectedComposeInfoResId", e.resId);
        intent.putExtra("SelectedComposeInfoImageCount", e.imageCount);
        startActivity(intent);
        finish();
    }

    public void e()
    {
        if (c != null && c.isShowing())
        {
            c.dismiss();
            c = null;
        }
    }

    public void f()
    {
        while (e == null || (new bcn(this, e)).a() || b() == null || e == null) 
        {
            return;
        }
        bcv.a().a(e, k);
        h.setEnabled(false);
        g.setBackgroundColor(0x106000b);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f03009e);
        h();
        a = (CommonActionBarView)findViewById(0x7f0d02a7);
        a.setIsNextButtonShow(false);
        a.setActionBarTitle("");
        a.setOnAcceptListener(new bby(this));
        e = InstaBeautyApplication.e;
        if (bundle != null)
        {
            e.resId = bundle.getInt(azn.a);
            e.previewUrl = bundle.getString(azn.d);
            e.imageCount = bundle.getInt(azn.c);
            e.otherAppStoreId = bundle.getString(azn.e);
            e.version = bundle.getString(azn.b);
            e.needReviewing = bundle.getBoolean(azn.f);
            e.zipUrl = bundle.getString(azn.g);
        }
        c = new ProgressDialog(this);
        Log.v(b, (new StringBuilder()).append(b).append(" onCreate").toString());
        g = (ImageView)findViewById(0x7f0d024b);
        g.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        f = (Button)findViewById(0x7f0d0262);
        f.setOnClickListener(new bbz(this));
        h = (Button)findViewById(0x7f0d0263);
        h.setOnClickListener(new bca(this));
        j = g();
        if (e.previewUrl != null)
        {
            Log.v(b, (new StringBuilder()).append(b).append(" preViewUrl : ").append(e.previewUrl).toString());
            j.a(e, g);
        } else
        {
            Log.v(b, (new StringBuilder()).append(b).append(" preViewUrl : is null").toString());
        }
        i = new bcb(this);
        a();
    }

    protected void onDestroy()
    {
        e();
        bcv.a().b();
        if (g != null)
        {
            zu.a(g);
            g.setImageDrawable(null);
        }
        unregisterReceiver(i);
        super.onDestroy();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && keyevent.getRepeatCount() == 0)
        {
            c();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public void onPause()
    {
        super.onPause();
        Log.v(b, (new StringBuilder()).append(b).append(" onPause").toString());
    }

    public void onResume()
    {
        super.onResume();
        Log.v(b, (new StringBuilder()).append(b).append(" onResume").toString());
        e = InstaBeautyApplication.e;
        if (InstaBeautyApplication.e == null)
        {
            Log.v(b, (new StringBuilder()).append(b).append(" onResume selectedInfo is null").toString());
        }
        FotoAdFactory.createAdBanner(this, findViewById(0x1020002));
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (e == null)
        {
            return;
        } else
        {
            bundle.putInt(azn.a, e.resId);
            bundle.putString(azn.b, e.version);
            bundle.putInt(azn.c, e.imageCount);
            bundle.putString(azn.d, e.previewUrl);
            bundle.putInt(azn.c, e.imageCount);
            bundle.putString(azn.e, e.otherAppStoreId);
            bundle.putBoolean(azn.f, e.needReviewing);
            bundle.putString(azn.g, e.zipUrl);
            return;
        }
    }

    protected void onStart()
    {
        super.onStart();
    }

    public void onStop()
    {
        super.onStop();
        if (l)
        {
            l = false;
            apq.c().d().asynArchive();
        }
    }
}
