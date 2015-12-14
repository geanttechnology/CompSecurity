// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;


public abstract class <init> extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKLooksCategoryEvent$Operation, s);
    }

    public static <init>[] values()
    {
        return (<init>[])e.clone();
    }

    public abstract String a();

    static 
    {
        a = new YMKLooksCategoryEvent.Operation("Show", 0) {

            public String a()
            {
                return "show";
            }

        };
        b = new YMKLooksCategoryEvent.Operation("LookShow", 1) {

            public String a()
            {
                return "lookshow";
            }

        };
        c = new YMKLooksCategoryEvent.Operation("Download", 2) {

            public String a()
            {
                return "download";
            }

        };
        d = new YMKLooksCategoryEvent.Operation("Use", 3) {

            public String a()
            {
                return "use";
            }

        };
        e = (new e[] {
            a, b, c, d
        });
    }

    private _cls4(String s, int i)
    {
        super(s, i);
    }

    _cls4(String s, int i, _cls4 _pcls4)
    {
        this(s, i);
    }
}
