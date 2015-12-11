// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;


// Referenced classes of package com.helpshift:
//            a

protected static final class it> extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];

    public static it> valueOf(String s)
    {
        return (it>)Enum.valueOf(com/helpshift/a$a, s);
    }

    public static ueOf[] values()
    {
        return (ueOf[])e.clone();
    }

    static 
    {
        a = new <init>("ACTION_BAR", 0);
        b = new <init>("SEARCH_FOOTER", 1);
        c = new <init>("QUESTION_FOOTER", 2);
        d = new <init>("QUESTION_ACTION_BAR", 3);
        e = (new e[] {
            a, b, c, d
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
