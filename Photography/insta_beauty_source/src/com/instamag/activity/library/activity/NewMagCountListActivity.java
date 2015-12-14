// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.library.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import apc;
import apq;
import aqn;
import axw;
import azn;
import bbs;
import bcd;
import bce;
import bcf;
import bcg;
import bch;
import bcy;
import bda;
import bdb;
import bdz;
import bgv;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.comlib.util.ImageCache;
import com.fotoable.fotobeauty.FullscreenActivity;
import com.instabeauty.application.InstaBeautyApplication;
import com.instamag.activity.library.view.waterfall.WaterFall;
import com.instamag.common.CollageType;
import com.loopj.android.http.AsyncHttpClient;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import zr;

public class NewMagCountListActivity extends FullscreenActivity
{

    private apc a;
    private RelativeLayout b;
    private Button c;
    private FrameLayout d;
    private WaterFall e;
    private ArrayList f;
    private bda g;
    private bdz h;
    private BroadcastReceiver i;
    private bdb j;
    private int k;
    private CollageType l;
    private boolean m;

    public NewMagCountListActivity()
    {
        f = new ArrayList();
        g = null;
        k = 1;
        l = CollageType.COLLAGE_MAGZINE;
        m = false;
    }

    public static void a(NewMagCountListActivity newmagcountlistactivity)
    {
        newmagcountlistactivity.e();
    }

    public static void a(NewMagCountListActivity newmagcountlistactivity, TPhotoComposeInfo tphotocomposeinfo)
    {
        newmagcountlistactivity.a(tphotocomposeinfo);
    }

    private void a(TPhotoComposeInfo tphotocomposeinfo)
    {
        e();
        Intent intent = new Intent("ACTION_MATERIAL_ADDED");
        intent.putExtra("TYPE_MATERIAL", bgv.getStringByResType(EOnlineResType.MAG_MASK_INFO));
        intent.putExtra("INSTAMAG_TYPE", TPhotoComposeInfo.getInstaMagType(tphotocomposeinfo).ordinal());
        intent.putExtra("INSTAMAG_RESID", tphotocomposeinfo.resId);
        intent.putExtra("INSTAMAG_IMAGE_COUNT", tphotocomposeinfo.imageCount);
        InstaBeautyApplication.a.sendBroadcast(intent);
    }

    public static boolean a(NewMagCountListActivity newmagcountlistactivity, JSONObject jsonobject)
    {
        return newmagcountlistactivity.a(jsonobject);
    }

    public static boolean a(NewMagCountListActivity newmagcountlistactivity, boolean flag)
    {
        newmagcountlistactivity.m = flag;
        return flag;
    }

    private boolean a(JSONObject jsonobject)
    {
        boolean flag;
        boolean flag1;
        flag1 = true;
        flag = flag1;
        if (!(jsonobject instanceof JSONObject)) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (jsonobject.length() <= 0) goto _L2; else goto _L3
_L3:
        jsonobject = aqn.b(jsonobject, "data");
        flag = flag1;
        if (jsonobject == null) goto _L2; else goto _L4
_L4:
        flag = flag1;
        if (jsonobject.length() <= 0) goto _L2; else goto _L5
_L5:
        int i1 = 0;
_L6:
        flag = flag1;
        Object obj;
        if (i1 >= jsonobject.length())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = aqn.a(jsonobject, i1);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        if (!(obj instanceof JSONObject))
        {
            break MISSING_BLOCK_LABEL_150;
        }
        obj = bcy.a(((JSONObject) (obj)));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        flag = apq.c().d().isExistedByResId(((TPhotoComposeInfo) (obj)).resId);
        if (((TPhotoComposeInfo) (obj)).imageCount != k || flag)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        if (!apq.c().d().getDeleteAndHideInfoIds().contains(((TPhotoComposeInfo) (obj)).getDeleteTag()))
        {
            f.add(obj);
        }
        i1++;
        if (true) goto _L6; else goto _L2
        jsonobject;
        flag = false;
_L2:
        return flag;
    }

    public static apc b(NewMagCountListActivity newmagcountlistactivity)
    {
        return newmagcountlistactivity.a;
    }

    private bdz c()
    {
        if (h == null)
        {
            h = new bcf(this);
        }
        return h;
    }

    public static void c(NewMagCountListActivity newmagcountlistactivity)
    {
        newmagcountlistactivity.g();
    }

    public static FrameLayout d(NewMagCountListActivity newmagcountlistactivity)
    {
        return newmagcountlistactivity.d;
    }

    private bda d()
    {
        if (g == null)
        {
            zr zr1 = new zr(this, ImageCache.b);
            zr1.g = true;
            zr1.d = android.graphics.Bitmap.CompressFormat.JPEG;
            zr1.a(0.05F);
            g = new bda(this, 320);
            g.a(getSupportFragmentManager(), zr1);
        }
        return g;
    }

    private void e()
    {
        if (m)
        {
            m = false;
            apq.c().d().asynArchive();
        }
        finish();
        overridePendingTransition(0x7f040025, 0x7f04002f);
    }

    private void f()
    {
        boolean flag1 = true;
        if (!axw.k(this))
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle(getResources().getString(0x7f0602ae));
            builder.setMessage(getResources().getString(0x7f060186));
            builder.setPositiveButton(getResources().getString(0x7f060055), new bcg(this));
            builder.show();
        } else
        {
            JSONObject jsonobject = a.b("json_newMagLibrary_count");
            boolean flag = flag1;
            if (jsonobject != null)
            {
                Log.v("NewMagCountListActivity", "NewMagCountListActivityget data from Cache");
                flag = flag1;
                if (a(jsonobject))
                {
                    g();
                    flag = false;
                }
            }
            if (flag)
            {
                Log.v("NewMagCountListActivity", "NewMagCountListActivityget data from server");
                String s = azn.a();
                d.setVisibility(0);
                AsyncHttpClient asynchttpclient = new AsyncHttpClient();
                asynchttpclient.setConnectTimeout(20000);
                asynchttpclient.setTimeout(20000);
                asynchttpclient.get(s, null, new bch(this));
                return;
            }
        }
    }

    private void g()
    {
        if (f != null && f.size() > 0 && j != null && e != null)
        {
            j.c();
        }
    }

    protected void a()
    {
        if (i == null)
        {
            i = new bce(this);
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("ACTION_MAG_MATERIAL_SHARETOWECHAT");
            registerReceiver(i, intentfilter);
        }
    }

    public void b()
    {
        if (i != null)
        {
            unregisterReceiver(i);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030023);
        if (bundle != null)
        {
            k = bundle.getInt("initalInstaMagCount");
            if (bundle.containsKey("initalInstaMagCollageType"))
            {
                if (bundle.getInt("initalInstaMagCollageType", 0) == 0)
                {
                    l = CollageType.COLLAGE_MAGZINE;
                } else
                {
                    l = CollageType.COLLAGE_COMIC;
                }
            }
        }
        if (getIntent() != null)
        {
            k = getIntent().getIntExtra("initalInstaMagCount", 1);
            if (getIntent().hasExtra("initalInstaMagCollageType"))
            {
                if (getIntent().getIntExtra("initalInstaMagCollageType", 0) == 0)
                {
                    l = CollageType.COLLAGE_MAGZINE;
                } else
                {
                    l = CollageType.COLLAGE_COMIC;
                }
            }
        }
        b = (RelativeLayout)findViewById(0x7f0d00b0);
        if (!azn.a(this))
        {
            b.setVisibility(8);
        }
        c = (Button)findViewById(0x7f0d00ae);
        c.setOnClickListener(new bcd(this));
        a();
        h = c();
        j = new bdb(this, f, d(), h);
        d = (FrameLayout)findViewById(0x7f0d00b1);
        e = (WaterFall)findViewById(0x7f0d00af);
        e.setColumn(3);
        e.setMarginWidth(bbs.a());
        e.setAdapter(j);
        a = apc.a(this);
        f();
    }

    public void onDestroy()
    {
        b();
        super.onDestroy();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && keyevent.getRepeatCount() == 0)
        {
            e();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public void onPause()
    {
        Log.v("NewMagCountListActivity", "NewMagCountListActivity onPause");
        super.onPause();
        if (g != null)
        {
            g.a(true);
        }
    }

    public void onResume()
    {
        Log.v("NewMagCountListActivity", "NewMagCountListActivity onresume");
        super.onResume();
        if (g != null)
        {
            g.a(false);
        }
        if (azn.a(this))
        {
            FotoAdFactory.createAdBanner(this, b);
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("initalInstaMagCount", k);
        bundle.putInt("initalInstaMagCollageType", l.ordinal());
    }
}
