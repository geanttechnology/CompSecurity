// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal;


// Referenced classes of package com.facebook.ads.internal:
//            f

public static final class  extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    private static final e f[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/facebook/ads/internal/f$c, s);
    }

    public static [] values()
    {
        return ([])f.clone();
    }

    static 
    {
        a = new <init>("SHARED_PREFS", 0);
        b = new <init>("FB4A", 1);
        c = new <init>("DIRECT", 2);
        d = new <init>("REFLECTION", 3);
        e = new <init>("SERVICE", 4);
        f = (new f[] {
            a, b, c, d, e
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
