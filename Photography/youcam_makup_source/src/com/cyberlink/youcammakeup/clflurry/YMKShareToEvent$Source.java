// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;


public abstract class <init> extends Enum
{

    public static final b a;
    public static final b b;
    private static final b c[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKShareToEvent$Source, s);
    }

    public static <init>[] values()
    {
        return (<init>[])c.clone();
    }

    public abstract String a();

    static 
    {
        a = new YMKShareToEvent.Source("BeforeAfter", 0) {

            public String a()
            {
                return "B_A";
            }

        };
        b = new YMKShareToEvent.Source("ResultPage", 1) {

            public String a()
            {
                return "result_page";
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

    _cls2(String s, int i, _cls2 _pcls2)
    {
        this(s, i);
    }
}
