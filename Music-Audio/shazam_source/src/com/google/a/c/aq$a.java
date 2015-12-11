// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.c;

// Referenced classes of package com.google.a.c:
//            aq

private static abstract class <init> extends Enum
    implements c
{

    public static final b a;
    public static final b b;
    private static final b c[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/google/a/c/aq$a, s);
    }

    public static Of[] values()
    {
        return (Of[])c.clone();
    }

    static 
    {
        a = new aq.a("KEY") {

            public final Object a(Object obj)
            {
                return ((java.util.Map.Entry)obj).getKey();
            }

        };
        b = new aq.a("VALUE") {

            public final Object a(Object obj)
            {
                return ((java.util.Map.Entry)obj).getValue();
            }

        };
        c = (new c[] {
            a, b
        });
    }

    private _cls2(String s, int i)
    {
        super(s, i);
    }

    >(String s, int i, byte byte0)
    {
        this(s, i);
    }
}
