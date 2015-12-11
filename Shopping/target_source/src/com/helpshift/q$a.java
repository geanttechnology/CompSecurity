// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;


// Referenced classes of package com.helpshift:
//            q

public static final class it> extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c d[];

    public static it> valueOf(String s)
    {
        return (it>)Enum.valueOf(com/helpshift/q$a, s);
    }

    public static ueOf[] values()
    {
        return (ueOf[])d.clone();
    }

    static 
    {
        a = new <init>("FULL_SEARCH", 0);
        b = new <init>("METAPHONE_SEARCH", 1);
        c = new <init>("KEYWORD_SEARCH", 2);
        d = (new d[] {
            a, b, c
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
