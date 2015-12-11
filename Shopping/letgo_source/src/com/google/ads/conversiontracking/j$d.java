// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.conversiontracking;


// Referenced classes of package com.google.ads.conversiontracking:
//            j

public static final class  extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];

    public static [] a()
    {
        return ([])e.clone();
    }

    static 
    {
        a = new <init>("DOUBLECLICK_AUDIENCE", 0);
        b = new <init>("DOUBLECLICK_CONVERSION", 1);
        c = new <init>("GOOGLE_CONVERSION", 2);
        d = new <init>("IAP_CONVERSION", 3);
        e = (new e[] {
            a, b, c, d
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
