// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tremorvideo.sdk.android.a.b;
import com.tremorvideo.sdk.android.adapter.TremorAdapterCalls;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            l, ad, i, j, 
//            au, k, m

public class Playvideo extends Activity
{

    l a;
    String b;
    int c;

    public Playvideo()
    {
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0 && a != null)
        {
            float f = motionevent.getRawX();
            float f2 = motionevent.getRawY();
            a.a(f, f2, 0);
        }
        if (motionevent.getAction() == 1 && a != null)
        {
            float f1 = motionevent.getRawX();
            float f3 = motionevent.getRawY();
            a.a(f1, f3, 1);
        }
        return super.dispatchTouchEvent(motionevent);
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        ad.d("activity returned");
        a.a(i1, j1, intent);
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        a.a(configuration);
    }

    public void onCreate(Bundle bundle)
    {
        ad.d("TremorDebug: Playvideo activity on create");
        b = getIntent().getStringExtra("tremorVideoType");
        if (b.compareTo("buyitnow") == 0)
        {
            setTheme(0x1030011);
        }
        super.onCreate(bundle);
        ad.d("Playvideo - onCreate");
        if (b.compareTo("ad") != 0) goto _L2; else goto _L1
_L1:
        a = new i();
_L3:
        c = getIntent().getIntExtra("curEventID", -1);
        if (c > -1)
        {
            Intent intent = new Intent();
            intent.putExtra("endEventId", c);
            setResult(-1, intent);
        }
        a.a(bundle, this);
_L4:
        ad.d("Playvideo - Activity Created");
        return;
_L2:
        if (b.compareTo("adProgress") != 0)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        a = new j();
          goto _L3
        bundle;
        ad.a(bundle);
        if (b.compareTo("ad") == 0)
        {
            ad.A().h();
        }
        finish();
        TremorAdapterCalls.onAdFinished();
          goto _L4
label0:
        {
            if (b.compareTo("coupon") != 0)
            {
                break label0;
            }
            a = new k();
        }
          goto _L3
label1:
        {
            if (b.compareTo("webview") != 0)
            {
                break label1;
            }
            a = new m();
        }
          goto _L3
label2:
        {
            if (b.compareTo("buyitnow") != 0)
            {
                break label2;
            }
            a = new b();
        }
          goto _L3
        if (b.compareTo("movieboard") != 0) goto _L6; else goto _L5
_L5:
        a = new com.tremorvideo.sdk.android.b.b();
          goto _L3
_L6:
        if (b.compareTo("genericwebview") != 0) goto _L3; else goto _L7
_L7:
        a = new com.tremorvideo.sdk.android.richmedia.a.b();
          goto _L3
    }

    protected void onDestroy()
    {
        ad.d("Playvideo - onDestroy");
        super.onDestroy();
        try
        {
            ad.a();
            a.f();
        }
        catch (Exception exception)
        {
            ad.a(exception);
        }
        System.gc();
        ad.a();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (a.a(i1, keyevent))
        {
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    protected void onPause()
    {
        super.onPause();
        ad.d("Playvideo - onPause");
        a.b();
    }

    protected void onResume()
    {
        super.onResume();
        ad.d("Playvideo - onResume");
        a.c();
    }

    public boolean onSearchRequested()
    {
        return a.d();
    }

    public void onStart()
    {
        super.onStart();
        ad.d("Playvideo - onStart");
        try
        {
            a.a();
            return;
        }
        catch (Exception exception)
        {
            ad.a(exception);
        }
        if (b.compareTo("ad") == 0)
        {
            ad.A().h();
        }
        finish();
        TremorAdapterCalls.onAdFinished();
    }

    protected void onStop()
    {
        super.onStop();
        ad.d("Playvideo - onStop");
        try
        {
            a.e();
            return;
        }
        catch (Exception exception)
        {
            ad.a(exception);
        }
    }
}
