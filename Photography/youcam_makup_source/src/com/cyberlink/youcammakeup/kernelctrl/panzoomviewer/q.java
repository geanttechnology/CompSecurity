// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.graphics.PointF;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            s, t, r, ImageViewer, 
//            o

public class q
{

    public long a;
    public int b;
    public int c;
    public UIImageOrientation d;
    public int e;
    public int f;
    public DevelopSetting g;
    public s h;
    public List i;
    public int j;
    public Map k;
    public Map l;
    public Map m;
    public com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets n;
    public boolean o;
    public int p;
    public t q;
    public r r;
    public r s;
    final ImageViewer t;

    public q(ImageViewer imageviewer)
    {
        t = imageviewer;
        super();
        a = -1L;
        b = -1;
        c = -1;
        d = UIImageOrientation.b;
        e = -1;
        f = -1;
        g = null;
        h = new s(this);
        i = null;
        j = -2;
        k = null;
        l = null;
        m = null;
        o = false;
        p = 255;
        q = new t(this);
        r = new r(this, t.c);
        s = new r(this, t.b);
    }

    public q(ImageViewer imageviewer, q q1)
    {
        t = imageviewer;
        super();
        a = -1L;
        b = -1;
        c = -1;
        d = UIImageOrientation.b;
        e = -1;
        f = -1;
        g = null;
        h = new s(this);
        i = null;
        j = -2;
        k = null;
        l = null;
        m = null;
        o = false;
        p = 255;
        q = new t(this);
        r = new r(this, t.c);
        s = new r(this, t.b);
        a = q1.a;
        b = q1.b;
        c = q1.c;
        d = q1.d;
        e = q1.e;
        f = q1.f;
        q = new t(this, q1.q);
        r = new r(this, q1.r);
        s = new r(this, q1.s);
        g = q1.g;
        h = new s(this, q1.h);
        i = new ArrayList();
        if (q1.i == null)
        {
            i = null;
        } else
        {
            Iterator iterator = q1.i.iterator();
            while (iterator.hasNext()) 
            {
                ar ar1 = (ar)iterator.next();
                i.add(new ar(ar1));
            }
        }
        if (q1.k == null)
        {
            k = null;
        } else
        {
            k = new HashMap();
            Iterator iterator1 = q1.k.entrySet().iterator();
            while (iterator1.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                o o1 = new o(imageviewer);
                o1.b = ((o)entry.getValue()).b;
                o1.a = new PointF(((o)entry.getValue()).a.x, ((o)entry.getValue()).a.y);
                k.put(entry.getKey(), o1);
            }
        }
        if (q1.l == null)
        {
            l = null;
        } else
        {
            l = new HashMap();
            l.putAll(q1.l);
        }
        if (q1.m == null)
        {
            m = null;
        } else
        {
            m = new HashMap();
            m.putAll(q1.m);
        }
        j = q1.j;
        n = q1.n;
        o = q1.o;
        p = q1.p;
    }

    public void a(long l1)
    {
        a = l1;
        b = -1;
        c = -1;
        d = UIImageOrientation.b;
        e = -1;
        f = -1;
        q = new t(this);
        r = new r(this, t.c);
        s = new r(this, t.b);
        h = new s(this);
        i = null;
        j = -2;
        k = null;
        l = null;
        m = null;
        p = 255;
    }
}
