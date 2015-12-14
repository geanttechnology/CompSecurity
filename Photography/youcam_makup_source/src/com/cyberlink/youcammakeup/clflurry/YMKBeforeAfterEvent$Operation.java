// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;


public abstract class <init> extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c d[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKBeforeAfterEvent$Operation, s);
    }

    public static <init>[] values()
    {
        return (<init>[])d.clone();
    }

    public abstract String a();

    static 
    {
        a = new YMKBeforeAfterEvent.Operation("Show", 0) {

            public String a()
            {
                return "show";
            }

        };
        b = new YMKBeforeAfterEvent.Operation("Back", 1) {

            public String a()
            {
                return "back";
            }

        };
        c = new YMKBeforeAfterEvent.Operation("Share", 2) {

            public String a()
            {
                return "share";
            }

        };
        d = (new d[] {
            a, b, c
        });
    }

    private _cls3(String s, int i)
    {
        super(s, i);
    }

    _cls3(String s, int i, _cls3 _pcls3)
    {
        this(s, i);
    }
}
