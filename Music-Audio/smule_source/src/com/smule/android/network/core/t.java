// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.core;

import com.smule.android.c.aa;
import com.smule.android.f.e;

// Referenced classes of package com.smule.android.network.core:
//            o

public abstract class t
{

    private static final String b = com/smule/android/network/core/t.getName();
    public o a;

    public t()
    {
    }

    public static t a(o o1, Class class1)
    {
        if (o1 == null)
        {
            aa.e(b, (new StringBuilder()).append("createFromNetworkResponse - got null networkResponse for class: ").append(class1.getName()).toString());
        }
        if (o1 == null || !o1.a()) goto _L2; else goto _L1
_L1:
        class1 = (t)e.a(o1.j, class1);
_L4:
        class1.a = o1;
        return class1;
_L2:
        try
        {
            class1 = (t)class1.newInstance();
        }
        // Misplaced declaration of an exception variable
        catch (o o1)
        {
            o1.printStackTrace();
            throw new RuntimeException(o1);
        }
        // Misplaced declaration of an exception variable
        catch (o o1)
        {
            o1.printStackTrace();
            throw new RuntimeException(o1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean a()
    {
        return a.a();
    }

}
