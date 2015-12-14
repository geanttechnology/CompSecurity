// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;


public abstract class <init> extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    private static final e f[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKADFromFeatureRoomUsageEvent$ButtonName, s);
    }

    public static <init>[] values()
    {
        return (<init>[])f.clone();
    }

    public abstract String a();

    static 
    {
        a = new YMKADFromFeatureRoomUsageEvent.ButtonName("Consult", 0) {

            public String a()
            {
                return "Consult";
            }

        };
        b = new YMKADFromFeatureRoomUsageEvent.ButtonName("Shopping", 1) {

            public String a()
            {
                return "Shopping";
            }

        };
        c = new YMKADFromFeatureRoomUsageEvent.ButtonName("MoreInfo", 2) {

            public String a()
            {
                return "MoreInfo";
            }

        };
        d = new YMKADFromFeatureRoomUsageEvent.ButtonName("FreeSample", 3) {

            public String a()
            {
                return "FreeSample";
            }

        };
        e = new YMKADFromFeatureRoomUsageEvent.ButtonName("Back", 4) {

            public String a()
            {
                return "Back";
            }

        };
        f = (new f[] {
            a, b, c, d, e
        });
    }

    private _cls5(String s, int i)
    {
        super(s, i);
    }

    _cls5(String s, int i, _cls5 _pcls5)
    {
        this(s, i);
    }
}
