// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.wantu.piprender.renderengine.filters.BaseImageFilter;
import com.wantu.piprender.renderengine.filters.BlendMode;
import com.wantu.piprender.renderengine.filters.ImageFilterFactory;
import java.util.HashMap;

public class bmc extends BaseImageFilter
{

    private bmi a;
    private bmn b;

    public bmc()
    {
        a("Autumn");
    }

    public void a()
    {
        super.a();
        a.a();
        b.a();
    }

    public void a(float f, float f1)
    {
        super.a(f, f1);
        a.a(f, f1);
        b.a(f, f1);
    }

    protected void a(int i)
    {
    }

    public void a(int i, int j)
    {
        b.d(j);
        j = a.c(j);
        b.a(i, j);
    }

    public void a(Context context, HashMap hashmap)
    {
        a = (bmi)ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP, hashmap);
        hashmap = new HashMap();
        hashmap.put("blendMode", Integer.valueOf(BlendMode.LIGHTEN.ordinal()));
        hashmap.put("blendSrcLocation", Integer.valueOf(1));
        b = (bmn)ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND, hashmap);
    }

    public void a(blu blu)
    {
        super.a(blu);
        a.a(blu);
        b.a(blu);
    }

    public void b(int i)
    {
        a(0, i);
    }
}
