// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;


// Referenced classes of package com.helpshift:
//            t

public static final class it> extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c d[];

    public static it> valueOf(String s)
    {
        return (it>)Enum.valueOf(com/helpshift/t$a, s);
    }

    public static ueOf[] values()
    {
        return (ueOf[])d.clone();
    }

    static 
    {
        a = new <init>("ALWAYS", 0);
        b = new <init>("NEVER", 1);
        c = new <init>("AFTER_VIEWING_FAQS", 2);
        d = (new d[] {
            a, b, c
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
