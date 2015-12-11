// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;


// Referenced classes of package com.helpshift:
//            l

public static final class it> extends Enum
{

    public static final f a;
    public static final f b;
    public static final f c;
    public static final f d;
    public static final f e;
    public static final f f;
    private static final f g[];

    public static it> valueOf(String s)
    {
        return (it>)Enum.valueOf(com/helpshift/l$a, s);
    }

    public static ueOf[] values()
    {
        return (ueOf[])g.clone();
    }

    static 
    {
        a = new <init>("CSAT_NOT_APPLICABLE", 0);
        b = new <init>("CSAT_APPLICABLE", 1);
        c = new <init>("CSAT_REQUESTED", 2);
        d = new <init>("CSAT_INPROGRESS", 3);
        e = new <init>("CSAT_DONE", 4);
        f = new <init>("CSAT_RETRYING", 5);
        g = (new g[] {
            a, b, c, d, e, f
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
