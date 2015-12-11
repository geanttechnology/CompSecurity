// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;


// Referenced classes of package com.mopub.common:
//            m

public static final class 
{

    private static volatile boolean a = false;

    public static boolean a(Object obj)
    {
        return m.a(obj, a, "Object can not be null.", new Object[] {
            ""
        });
    }

    public static boolean a(Object obj, String s)
    {
        return m.a(obj, a, s, new Object[] {
            ""
        });
    }

    public static boolean a(boolean flag)
    {
        return m.a(flag, a, "Illegal argument", new Object[] {
            ""
        });
    }

}
