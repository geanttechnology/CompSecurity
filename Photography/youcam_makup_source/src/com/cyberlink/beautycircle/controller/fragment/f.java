// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.controller.adapter.m;
import com.cyberlink.beautycircle.i;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            g, BottomBarFragment

public class f extends Fragment
{

    public boolean a;
    public View b;
    public TextView c;
    public boolean d;
    public boolean e;
    public boolean f;
    private boolean g;
    private int h;

    public f()
    {
        g = false;
        a = false;
        b = null;
        c = null;
        d = false;
        e = false;
        f = false;
    }

    public void a(int j)
    {
        h = j;
        if (isResumed())
        {
            b(j);
            return;
        } else
        {
            g = true;
            return;
        }
    }

    public void a(BottomBarFragment bottombarfragment)
    {
    }

    public boolean a(MotionEvent motionevent)
    {
        return false;
    }

    public void b()
    {
        Object obj = getActivity();
        if (obj instanceof MainActivity)
        {
            obj = ((MainActivity)obj).u();
            if (obj != null)
            {
                a(((BottomBarFragment) (obj)));
            }
        }
    }

    public void b(int j)
    {
        a = true;
    }

    public void b(BottomBarFragment bottombarfragment)
    {
    }

    public void c()
    {
        Object obj = getActivity();
        if (obj instanceof MainActivity)
        {
            obj = ((MainActivity)obj).u();
            if (obj != null)
            {
                b(((BottomBarFragment) (obj)));
            }
        }
    }

    public void d()
    {
        Object obj = getActivity();
        View view;
        if (obj != null)
        {
            if ((view = getView()) != null && (obj = (InputMethodManager)((Activity) (obj)).getSystemService("input_method")) != null)
            {
                ((InputMethodManager) (obj)).hideSoftInputFromWindow(view.getWindowToken(), 0);
                return;
            }
        }
    }

    public void e()
    {
        if (c != null && d)
        {
            c.setText(Globals.c());
            if (Globals.c() == "PRODUCTION")
            {
                c.setBackgroundResource(i.bc_general_radius_production_background);
                if (e.a)
                {
                    c.setVisibility(0);
                    return;
                } else
                {
                    c.setVisibility(8);
                    return;
                }
            } else
            {
                c.setBackgroundResource(i.bc_general_radius_demoex_background);
                c.setVisibility(0);
                return;
            }
        } else
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "mDemoText = null"
            });
            return;
        }
    }

    public void f()
    {
        a = false;
    }

    public void g()
    {
        if (this instanceof g)
        {
            m m1 = ((g)this).h;
            if (m1 != null)
            {
                m1.g = true;
            }
        }
    }

    public void onDestroyView()
    {
        c();
        super.onDestroyView();
    }

    public void onResume()
    {
        super.onResume();
        if (g)
        {
            g = false;
            b(h);
        }
    }
}
