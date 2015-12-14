// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.guide;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.pipcamera.activity.FullscreenActivity;
import com.pipcamera.activity.PIPCameraActivity;
import es;
import java.util.ArrayList;
import java.util.List;
import kf;
import pb;
import sk;

// Referenced classes of package com.pipcamera.activity.guide:
//            GuideView, GuideViewPager

public class GuideViewAcitivity extends FullscreenActivity
    implements android.support.v4.view.ViewPager.OnPageChangeListener, android.view.View.OnClickListener, sk
{

    public static Activity a;
    private static final int g[] = {
        0x7f0201da, 0x7f0201db, 0x7f0201dd, 0x7f0201de
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
        context.setIcon(0x7f0201fb);
        context.setTitle(getResources().getString(0x7f060277));
        context.setMessage(getResources().getString(0x7f0600e8));
        context.setPositiveButton(getResources().getString(0x7f0602b7), new android.content.DialogInterface.OnClickListener() {

            final GuideViewAcitivity a;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                dialoginterface = a.getSharedPreferences((new StringBuilder()).append("isNeedGotoGuideView_").append(kf.a).toString(), 0).edit();
                dialoginterface.putBoolean("isGotoGuideView", true);
                dialoginterface.commit();
                a.finish();
            }

            
            {
                a = GuideViewAcitivity.this;
                super();
            }
        });
        context.setNegativeButton(getResources().getString(0x7f06016e), new android.content.DialogInterface.OnClickListener() {

            final GuideViewAcitivity a;

            public void onClick(DialogInterface dialoginterface, int j)
            {
            }

            
            {
                a = GuideViewAcitivity.this;
                super();
            }
        });
        return context.create();
    }

    private void b()
    {
        LinearLayout linearlayout = (LinearLayout)findViewById(0x7f0c0222);
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
        if (!kf.a() && !pb.a(this, es.h))
        {
            FlurryAgent.logEvent("guide_app_test_select_showed");
            if (!e)
            {
                FlurryAgent.logEvent("guide_app_unselect");
            }
        }
        Object obj = (new StringBuilder()).append("isGuideNeedInstallApp_");
        kf.c();
        obj = getSharedPreferences(((StringBuilder) (obj)).append(kf.a).toString(), 0).edit();
        ((android.content.SharedPreferences.Editor) (obj)).putString("activity", "GuideViewActivity");
        ((android.content.SharedPreferences.Editor) (obj)).putString("PresentAppName", f);
        ((android.content.SharedPreferences.Editor) (obj)).putBoolean("isNeedDownloadApp", e);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        startActivity(new Intent(this, com/pipcamera/activity/PIPCameraActivity));
        overridePendingTransition(0x7f04002c, 0x7f04002f);
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
        setContentView(0x7f030078);
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
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
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
        f = es.i;
        if (!kf.a() && !pb.a(this, es.i))
        {
            break MISSING_BLOCK_LABEL_185;
        }
        f = es.a;
        if (!kf.a() && !pb.a(this, es.a))
        {
            break; /* Loop/switch isn't completed */
        }
        f = "";
        if (true) goto _L6; else goto _L5
_L5:
        bundle.setBgImageView(0x7f0201dc);
        e = a(this);
        bundle.setCheckViewVisible(e);
        if (true) goto _L7; else goto _L2
_L2:
        b = (ViewPager)findViewById(0x7f0c0155);
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

    protected void onStart()
    {
        super.onStart();
    }

    protected void onStop()
    {
        super.onStop();
    }

}
