// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter;

import com.cyberlink.youcammakeup.clflurry.YMKApplyEvent;
import com.cyberlink.youcammakeup.clflurry.ar;
import com.cyberlink.youcammakeup.clflurry.at;
import com.cyberlink.youcammakeup.database.more.b.a;
import com.cyberlink.youcammakeup.database.more.b.b;
import com.cyberlink.youcammakeup.h;
import java.util.List;

public class j
{

    private com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName a;
    private String b;
    private String c;
    private com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask d;

    j(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName featurename)
    {
        a = null;
        b = null;
        c = null;
        d = null;
        a = featurename;
    }

    j(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName featurename, String s, String s1, com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask mask)
    {
        a = null;
        b = null;
        c = null;
        d = null;
        a = featurename;
        b = s;
        c = s1;
        if (mask != null)
        {
            d = new com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask(mask);
        }
    }

    private final String f()
    {
        Object obj1 = null;
        Object obj;
        if (b() != null)
        {
            obj = b().C();
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            obj = h.i().a(((String) (obj)));
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            obj1 = new String[((List) (obj)).size()];
            for (int i = 0; i < ((List) (obj)).size(); i++)
            {
                obj1[i] = ((a)((List) (obj)).get(i)).b();
            }

            obj1 = YMKApplyEvent.b(((String []) (obj1)));
        }
        return ((String) (obj1));
    }

    public final String a()
    {
        return b;
    }

    public final void a(ar ar1)
    {
        ar1.a(a);
        ar1.e(b);
        ar1.b(c);
        ar1.d(f());
        ar1.a(null);
    }

    public final void a(com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask mask)
    {
        d = mask;
    }

    public final void a(String s)
    {
        c = s;
    }

    public final com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask b()
    {
        return d;
    }

    public final String c()
    {
        return c;
    }

    public final at d()
    {
        at at1 = new at(a);
        at1.f(b);
        at1.b(c);
        at1.d(f());
        return at1;
    }

    public final YMKApplyEvent e()
    {
        YMKApplyEvent ymkapplyevent = new YMKApplyEvent(a);
        ymkapplyevent.f(b);
        ymkapplyevent.b(c);
        ymkapplyevent.d(f());
        return ymkapplyevent;
    }
}
