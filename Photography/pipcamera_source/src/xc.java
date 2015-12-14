// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.wantu.piprender.renderengine.filters.BaseImageFilter;
import com.wantu.piprender.renderengine.filters.BlendMode;
import com.wantu.piprender.renderengine.filters.ImageFilterFactory;
import java.util.HashMap;

public class xc extends BaseImageFilter
{

    private xy a;
    private wz b;
    private wz c;

    public xc()
    {
        a("Fantasy");
    }

    public void a()
    {
        super.a();
        a.a();
        b.a();
        c.a();
    }

    public void a(float f, float f1)
    {
        super.a(f, f1);
        a.a(f, f1);
        b.a(f, f1);
        c.a(f, f1);
    }

    protected void a(int i)
    {
    }

    public void a(int i, int j)
    {
        int k = a.c(j);
        b.d(j);
        j = b.c(k);
        c.a(i, j);
    }

    public void a(Context context, HashMap hashmap)
    {
        a = new xy();
        a.a(context, hashmap);
        hashmap = new HashMap();
        hashmap.put("blendMode", Integer.valueOf(BlendMode.SCREEN.ordinal()));
        hashmap.put("blendSrcLocation", Integer.valueOf(1));
        hashmap.put("opacity", Float.valueOf(0.66F));
        b = (wz)ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND, hashmap);
        hashmap = new HashMap();
        hashmap.put("blendMode", Integer.valueOf(BlendMode.SOFTLIGHT.ordinal()));
        hashmap.put("blendImagePath", "filterRes/fantasy_res.png");
        hashmap.put("opacity", Float.valueOf(0.55F));
        c = (wz)ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND, hashmap);
    }

    public void a(wf wf)
    {
        super.a(wf);
        a.a(wf);
        b.a(wf);
        c.a(wf);
    }

    public void b(int i)
    {
        a(0, i);
    }
}
