// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.paypal.android.sdk:
//            ch, cp, bm

public final class co
    implements ch
{

    private cp a;

    public co(cp cp1)
    {
        a = cp1;
    }

    public static List d()
    {
        ArrayList arraylist = new ArrayList();
        cp acp[] = cp.values();
        int j = acp.length;
        for (int i = 0; i < j; i++)
        {
            arraylist.add(new co(acp[i]));
        }

        return arraylist;
    }

    public final String a()
    {
        return a.name();
    }

    public final bm b()
    {
        return a.a();
    }

    public final String c()
    {
        return a.b();
    }
}
