// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.widget.ViewPagerIndicator;

// Referenced classes of package com.wishabi.flipp.app:
//            cg, do, FlippApplication, ci, 
//            cn, cj, ck, cl, 
//            cv

public class HelpActivity extends Activity
{

    private cn a;
    private String b;
    private boolean c;
    private View d[];
    private ViewPager e;
    private final cv f = new cg(this);

    public HelpActivity()
    {
    }

    static cn a(HelpActivity helpactivity, cn cn1)
    {
        helpactivity.a = cn1;
        return cn1;
    }

    static String a(HelpActivity helpactivity, String s)
    {
        helpactivity.b = s;
        return s;
    }

    static boolean a(HelpActivity helpactivity, boolean flag)
    {
        helpactivity.c = flag;
        return flag;
    }

    static View[] a(HelpActivity helpactivity)
    {
        return helpactivity.d;
    }

    static cv b(HelpActivity helpactivity)
    {
        return helpactivity.f;
    }

    static cn c(HelpActivity helpactivity)
    {
        return helpactivity.a;
    }

    static String d(HelpActivity helpactivity)
    {
        return helpactivity.b;
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        return c || super.dispatchTouchEvent(motionevent);
    }

    public void onCreate(Bundle bundle)
    {
        Object obj;
        android.content.Context context;
        super.onCreate(bundle);
        setContentView(0x7f030002);
        obj = com.wishabi.flipp.app.do.a;
        context = FlippApplication.b();
        if (context != null) goto _L2; else goto _L1
_L1:
        obj = new View[0];
_L4:
        d = ((View []) (obj));
        obj = (Button)findViewById(0x7f0b0021);
        ((Button) (obj)).setOnClickListener(new ci(this));
        int j = com.wishabi.flipp.app.do.a.a();
        if (j != 3)
        {
            ((Button) (obj)).setVisibility(4);
        }
        if (bundle != null)
        {
            a = (cn)getFragmentManager().getFragment(bundle, "postal_code_fragment");
            if (a != null)
            {
                a.a = f;
            }
        }
        e = (ViewPager)findViewById(0x7f0b001f);
        e.setAdapter(new cj(this, getFragmentManager()));
        bundle = e;
        View aview[];
        LayoutInflater layoutinflater;
        int ai[];
        int i;
        if (j != 3)
        {
            i = 0;
        } else
        {
            i = d.length;
        }
        bundle.setCurrentItem(i);
        bundle = (ViewPagerIndicator)findViewById(0x7f0b0020);
        bundle.setViewPager(e);
        e.setOnPageChangeListener(new ck(this, bundle));
        if (j == 0)
        {
            (new cl(this, this)).a();
        }
        return;
_L2:
        layoutinflater = LayoutInflater.from(context);
        ai = ((do) (obj)).b();
        aview = new View[ai.length];
        j = aview.length;
        i = 0;
_L5:
        obj = aview;
        if (i >= j) goto _L4; else goto _L3
_L3:
        aview[i] = layoutinflater.inflate(ai[i], null);
        i++;
          goto _L5
    }

    public void onResume()
    {
        super.onResume();
        a.a.a((new StringBuilder("TutorialScreen")).append(e.getCurrentItem()).toString());
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (a != null)
        {
            getFragmentManager().putFragment(bundle, "postal_code_fragment", a);
        }
    }
}
