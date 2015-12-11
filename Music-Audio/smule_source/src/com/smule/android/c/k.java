// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;


// Referenced classes of package com.smule.android.c:
//            b

public final class k extends Enum
    implements b
{

    public static final k a;
    public static final k b;
    public static final k c;
    public static final k d;
    private static final k f[];
    private String e;

    private k(String s, int i, String s1)
    {
        super(s, i);
        e = s1;
    }

    public static k valueOf(String s)
    {
        return (k)Enum.valueOf(com/smule/android/c/k, s);
    }

    public static k[] values()
    {
        return (k[])f.clone();
    }

    public String a()
    {
        return e;
    }

    static 
    {
        a = new k("EMAIL", 0, "email");
        b = new k("FACEBOOK", 1, "fb");
        c = new k("DEVICE_FOUND", 2, "device_found");
        d = new k("GPLUS", 3, "gplus");
        f = (new k[] {
            a, b, c, d
        });
    }
}
