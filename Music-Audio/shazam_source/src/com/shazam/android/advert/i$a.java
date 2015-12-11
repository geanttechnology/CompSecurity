// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert;


// Referenced classes of package com.shazam.android.advert:
//            i

protected static final class  extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/shazam/android/advert/i$a, s);
    }

    public static [] values()
    {
        return ([])e.clone();
    }

    static 
    {
        a = new <init>("IDLE", 0);
        b = new <init>("TAGGING", 1);
        c = new <init>("DEFAULT", 2);
        d = new <init>("DEFAULT_FACEBOOK", 3);
        e = (new e[] {
            a, b, c, d
        });
    }

    private (String s, int j)
    {
        super(s, j);
    }
}
