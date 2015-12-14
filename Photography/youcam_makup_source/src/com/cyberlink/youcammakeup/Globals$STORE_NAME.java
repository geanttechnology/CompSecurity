// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup;


public abstract class <init> extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/Globals$STORE_NAME, s);
    }

    public static <init>[] values()
    {
        return (<init>[])e.clone();
    }

    public abstract String a();

    public abstract boolean b();

    public abstract boolean c();

    static 
    {
        a = new Globals.STORE_NAME("Google", 0) {

            public String a()
            {
                return "Google";
            }

            public boolean b()
            {
                return true;
            }

            public boolean c()
            {
                return false;
            }

        };
        b = new Globals.STORE_NAME("China", 1) {

            public String a()
            {
                return "China";
            }

            public boolean b()
            {
                return false;
            }

            public boolean c()
            {
                return true;
            }

        };
        c = new Globals.STORE_NAME("Baidu", 2) {

            public String a()
            {
                return "Baidu";
            }

            public boolean b()
            {
                return false;
            }

            public boolean c()
            {
                return true;
            }

        };
        d = new Globals.STORE_NAME("Huawei", 3) {

            public String a()
            {
                return "Huawei";
            }

            public boolean b()
            {
                return false;
            }

            public boolean c()
            {
                return true;
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
