// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.wantu.piprender.renderengine.filters.BaseImageFilter;
import com.wantu.piprender.renderengine.filters.BlendMode;
import com.wantu.piprender.renderengine.filters.ImageFilterFactory;
import java.util.HashMap;

public class bmq extends BaseImageFilter
{

    private bno a;
    private bmn b;
    private bmn c;

    public bmq()
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
        a = new bno();
        a.a(context, hashmap);
        hashmap = new HashMap();
        hashmap.put("blendMode", Integer.valueOf(BlendMode.SCREEN.ordinal()));
        hashmap.put("blendSrcLocation", Integer.valueOf(1));
        hashmap.put("opacity", Float.valueOf(0.66F));
        b = (bmn)ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND, hashmap);
        hashmap = new HashMap();
        hashmap.put("blendMode", Integer.valueOf(BlendMode.SOFTLIGHT.ordinal()));
        hashmap.put("blendImagePath", "filterRes/fantasy_res.jpg");
        hashmap.put("opacity", Float.valueOf(0.55F));
        c = (bmn)ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND, hashmap);
    }

    public void a(blu blu)
    {
        super.a(blu);
        a.a(blu);
        b.a(blu);
        c.a(blu);
    }

    public void b(int i)
    {
        a(0, i);
    }
}
