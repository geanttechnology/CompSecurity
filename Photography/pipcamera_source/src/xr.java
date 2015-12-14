// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.util.HashMap;

public class xr extends xk
{

    private xz e;
    private xz f;
    private float g;

    public xr()
    {
        g = 1.0F;
        a("simple");
    }

    public void a(float f1, float f2)
    {
        e.c(g / f1);
        e.b(0.0F);
        f.c(0.0F);
        f.b(g / f2);
        super.a(f1, f2);
    }

    public void a(Context context, HashMap hashmap)
    {
        super.a(context, hashmap);
        e = new xz();
        e.a(context, null);
        f = new xz();
        f.a(context, null);
        if (hashmap.containsKey("threshold"))
        {
            float f1 = ((Float)hashmap.get("threshold")).floatValue();
            e.a(f1);
            f.a(f1);
        }
        if (hashmap.containsKey("blurSize"))
        {
            g = ((Float)hashmap.get("blurSize")).floatValue();
        }
        a(((xj) (e)));
        a(((xj) (f)));
    }
}
