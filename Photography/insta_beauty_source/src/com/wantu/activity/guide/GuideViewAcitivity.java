// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.guide;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import apq;
import bij;
import bik;
import bil;
import com.flurry.android.FlurryAgent;
import com.fotoable.fotobeauty.FullscreenActivity;
import com.fotoable.fotobeauty.WantuActivity;
import ie;
import java.util.ArrayList;
import java.util.List;
import yp;

// Referenced classes of package com.wantu.activity.guide:
//            GuideView, GuideViewPager

public class GuideViewAcitivity extends FullscreenActivity
    implements android.support.v4.view.ViewPager.OnPageChangeListener, android.view.View.OnClickListener, bij
{

    public static Activity a;
    private static final int g[] = {
        0x7f02031d, 0x7f02031e, 0x7f02031f, 0x7f020320
    };
    private ViewPager b;
    private GuideViewPager c;
    private List d;
    private boolean e;
    private String f;
    private ImageView h[];
    private int i;

    public GuideViewAcitivity()
    {
        e = true;
        f = "";
    }

    private void a(int j)
    {
        if (j < 0 || j >= g.length)
        {
            return;
        } else
        {
            b.setCurrentItem(j);
            return;
        }
    }

    private Dialog b(Context context)
    {
        context = new android.app.AlertDialog.Builder(context);
        context.setIcon(0x7f02034c);
        context.setTitle(getResources().getString(0x7f0602ae));
        context.setMessage(getResources().getString(0x7f0600f9));
        context.setPositiveButton(getResources().getString(0x7f0602fd), new bik(this));
        context.setNegativeButton(getResources().getString(0x7f06018e), new bil(this));
        return context.create();
    }

    private void b()
    {
        LinearLayout linearlayout = (LinearLayout)findViewById(0x7f0d02f7);
        h = new ImageView[d.size()];
        int j = 0;
        while (j < g.length) 
        {
            if (j >= d.size())
            {
                ((ImageView)linearlayout.getChildAt(j)).setVisibility(8);
            } else
            {
                h[j] = (ImageView)linearlayout.getChildAt(j);
                h[j].setEnabled(true);
                h[j].setOnClickListener(this);
                h[j].setTag(Integer.valueOf(j));
            }
            j++;
        }
        i = 0;
        h[i].setEnabled(false);
    }

    private void b(int j)
    {
        if (j < 0 || j > g.length - 1 || i == j)
        {
            return;
        } else
        {
            h[j].setEnabled(false);
            h[i].setEnabled(true);
            i = j;
            return;
        }
    }

    public void a()
    {
        if (apq.a() || yp.a(this, ie.i)) goto _L2; else goto _L1
_L1:
        if (!a(((Context) (this)))) goto _L4; else goto _L3
_L3:
        FlurryAgent.logEvent("ib_guide_app_showed");
        if (!e)
        {
            FlurryAgent.logEvent("ib_guide_select_changed");
        }
_L2:
        Object obj = (new StringBuilder()).append("isGuideNeedDownloadApp_");
        apq.c();
        obj = getSharedPreferences(((StringBuilder) (obj)).append(apq.a).toString(), 0).edit();
        ((android.content.SharedPreferences.Editor) (obj)).putString("activity", "GuideViewActivity");
        ((android.content.SharedPreferences.Editor) (obj)).putBoolean("isNeedDownloadApp", e);
        ((android.content.SharedPreferences.Editor) (obj)).putString("appName", f);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        startActivity(new Intent(this, com/fotoable/fotobeauty/WantuActivity));
        overridePendingTransition(0x7f040041, 0x7f040043);
        return;
_L4:
        FlurryAgent.logEvent("ib_guide_app_showed_noWifi");
        if (e)
        {
            FlurryAgent.logEvent("ib_guide_select_changed_noWifi");
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void a(boolean flag)
    {
        e = flag;
    }

    public boolean a(Context context)
    {
        if (context != null)
        {
            context = ((ConnectivityManager)context.getSystemService("connectivity")).getNetworkInfo(1);
            if (context != null)
            {
                return context.isConnected();
            }
        }
        return false;
    }

    public void finish()
    {
        super.finish();
    }

    public void onClick(View view)
    {
        int j = ((Integer)view.getTag()).intValue();
        a(j);
        b(j);
    }

    public void onCreate(Bundle bundle)
    {
        int j;
        super.onCreate(bundle);
        setContentView(0x7f0300b7);
        a = this;
        d = new ArrayList();
        new android.widget.LinearLayout.LayoutParams(-2, -2);
        j = 0;
_L9:
        if (j >= g.length) goto _L2; else goto _L1
_L1:
        bundle = new GuideView(this, null);
        bundle.setLisener(this);
        try
        {
            bundle.setBgImageView(g[j]);
        }
        catch (Exception exception) { }
        if (j != g.length - 1) goto _L4; else goto _L3
_L3:
        bundle.setButtonVisible();
_L7:
        d.add(bundle);
_L6:
        j++;
        continue; /* Loop/switch isn't completed */
_L4:
        if (j != g.length - 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        f = ie.i;
        if (apq.a() || yp.a(this, ie.i)) goto _L6; else goto _L5
_L5:
        e = a(this);
        bundle.setCheckViewVisible(e);
        if (true) goto _L7; else goto _L2
_L2:
        b = (ViewPager)findViewById(0x7f0d02f6);
        c = new GuideViewPager(d);
        b.setAdapter(c);
        b.setOnPageChangeListener(this);
        b();
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected void onDestroy()
    {
        super.onDestroy();
        c.a();
    }

    public boolean onKeyDown(int j, KeyEvent keyevent)
    {
        if (j == 4 && keyevent.getRepeatCount() == 0)
        {
            b(this).show();
            return true;
        } else
        {
            return super.onKeyDown(j, keyevent);
        }
    }

    public void onPageScrollStateChanged(int j)
    {
    }

    public void onPageScrolled(int j, float f1, int k)
    {
    }

    public void onPageSelected(int j)
    {
        b(j);
    }

}
