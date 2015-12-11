// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.content.Context;
import java.util.Map;

// Referenced classes of package com.google.android.gms.b:
//            d, da, cg

public class cc
{

    public static final a a = new _cls1();
    private static da b;
    private static final Object c = new Object();

    public cc(Context context)
    {
        b = a(context);
    }

    private static da a(Context context)
    {
        synchronized (c)
        {
            if (b == null)
            {
                b = d.a(context.getApplicationContext());
            }
            context = b;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public cg a(String s, Map map)
    {
    /* block-local class not found */
    class b {}

        b b1 = new b(null);
        s = new _cls3(s, b1, new _cls2(s, b1), map);
        b.a(s);
        return b1;
    }


    // Unreferenced inner class com/google/android/gms/b/cc$a
    /* block-local class not found */
    class a {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}

}
