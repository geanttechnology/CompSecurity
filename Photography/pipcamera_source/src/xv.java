// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.wantu.piprender.renderengine.filters.BaseImageFilter;
import com.wantu.piprender.renderengine.filters.BlendMode;
import com.wantu.piprender.renderengine.filters.ImageFilterFactory;
import java.util.HashMap;

public class xv extends BaseImageFilter
{

    private xu a;
    private ya b;
    private xh c;
    private wz o;
    private wz p;
    private wg q;

    public xv()
    {
        a("Sketch");
    }

    public void a()
    {
        super.a();
        a.a();
        b.a();
        c.a();
        o.a();
        p.a();
        if (q != null)
        {
            q.c();
            q = null;
        }
    }

    public void a(float f, float f1)
    {
        super.a(f, f1);
        a.a(f, f1);
        b.a(f, f1);
        c.a(f, f1);
        o.a(f, f1);
        p.a(f, f1);
        if (q != null)
        {
            q.c();
            q = null;
        }
        q = wf.b((int)f, (int)f1);
    }

    protected void a(int i)
    {
    }

    public void a(int i, int j)
    {
        j = b.c(j);
        a.a(q.a(), j);
        o.d(q.b());
        j = c.c(j);
        j = o.c(j);
        if (d.b(j) == i)
        {
            int k = d.a(j);
            a.a(k, j);
            p.a(i, d.c(k));
            return;
        } else
        {
            p.a(i, j);
            return;
        }
    }

    public void a(Context context, HashMap hashmap)
    {
        a = (xu)ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SIMPLE, hashmap);
        b = new ya();
        b.a(context, hashmap);
        c = (xh)ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.GAUSSIANBLUR, hashmap);
        hashmap = new HashMap();
        hashmap.put("blendMode", Integer.valueOf(BlendMode.COLORBURN.ordinal()));
        hashmap.put("blendSrcLocation", Integer.valueOf(0));
        hashmap.put("opacity", Float.valueOf(0.9F));
        o = (wz)ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND, hashmap);
        hashmap = new HashMap();
        hashmap.put("blendMode", Integer.valueOf(BlendMode.DARKEN.ordinal()));
        hashmap.put("blendImagePath", "filterRes/sketchpattern.jpg");
        hashmap.put("opacity", Float.valueOf(0.6F));
        p = (wz)ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND, hashmap);
    }

    public void a(wf wf1)
    {
        super.a(wf1);
        a.a(wf1);
        b.a(wf1);
        c.a(wf1);
        o.a(wf1);
        p.a(wf1);
    }

    public void b(int i)
    {
        a(0, i);
    }
}
