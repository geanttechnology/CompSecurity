// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Comparator;

// Referenced classes of package com.flurry.sdk:
//            ke, lz, kg

public class kd
    implements Comparator
{

    private static final String a = com/flurry/sdk/kd.getSimpleName();

    public kd()
    {
    }

    private int a(Runnable runnable)
    {
label0:
        {
            int i = 0x7fffffff;
            if (runnable != null)
            {
                if (!(runnable instanceof ke))
                {
                    break label0;
                }
                runnable = (lz)((ke)runnable).a();
                if (runnable != null)
                {
                    i = runnable.n();
                } else
                {
                    i = 0x7fffffff;
                }
            }
            return i;
        }
        if (runnable instanceof lz)
        {
            return ((lz)runnable).n();
        } else
        {
            kg.a(6, a, (new StringBuilder()).append("Unknown runnable class: ").append(runnable.getClass().getName()).toString());
            return 0x7fffffff;
        }
    }

    public int a(Runnable runnable, Runnable runnable1)
    {
        int i = a(runnable);
        int j = a(runnable1);
        if (i < j)
        {
            return -1;
        }
        return i <= j ? 0 : 1;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((Runnable)obj, (Runnable)obj1);
    }

}
