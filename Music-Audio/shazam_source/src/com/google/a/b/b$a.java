// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;


// Referenced classes of package com.google.a.b:
//            k, b

static final class t> extends Enum
    implements k
{

    public static final a a;
    private static final a b[];

    public static t> valueOf(String s)
    {
        return (t>)Enum.valueOf(com/google/a/b/b$a, s);
    }

    public static eOf[] values()
    {
        return (eOf[])b.clone();
    }

    static 
    {
        a = new <init>("INSTANCE");
        b = (new b[] {
            a
        });
    }

    private (String s)
    {
        super(s, 0);
    }
}
