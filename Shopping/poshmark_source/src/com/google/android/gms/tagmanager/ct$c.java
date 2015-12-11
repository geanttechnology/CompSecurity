// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.tagmanager:
//            ct

private static class 
{

    private final Set WP = new HashSet();
    private final Map WZ = new HashMap();
    private final Map Xa = new HashMap();
    private final Map Xb = new HashMap();
    private final Map Xc = new HashMap();
    private Xd Xd;

    public void a( ,  1)
    {
        List list = (List)WZ.get();
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            WZ.put(, obj);
        }
        ((List) (obj)).add(1);
    }

    public void a(WZ wz, String s)
    {
        List list = (List)Xb.get(wz);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            Xb.put(wz, obj);
        }
        ((List) (obj)).add(s);
    }

    public void b(Xb xb)
    {
        WP.add(xb);
    }

    public void b(WP wp, WP wp1)
    {
        List list = (List)Xa.get(wp);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            Xa.put(wp, obj);
        }
        ((List) (obj)).add(wp1);
    }

    public void b(Xa xa, String s)
    {
        List list = (List)Xc.get(xa);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            Xc.put(xa, obj);
        }
        ((List) (obj)).add(s);
    }

    public void i(Xc xc)
    {
        Xd = xc;
    }

    public Set kb()
    {
        return WP;
    }

    public Map kc()
    {
        return WZ;
    }

    public Map kd()
    {
        return Xb;
    }

    public Map ke()
    {
        return Xc;
    }

    public Map kf()
    {
        return Xa;
    }

    public Xa kg()
    {
        return Xd;
    }

    public ()
    {
    }
}
