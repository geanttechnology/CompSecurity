// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;


public abstract class <init> extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/flurry/UsageOfAccessoryFeatureEvent$FeatureName, s);
    }

    public static <init>[] values()
    {
        return (<init>[])e.clone();
    }

    public abstract String a();

    static 
    {
        a = new UsageOfAccessoryFeatureEvent.FeatureName("Earrings", 0) {

            public String a()
            {
                return "Earrings";
            }

        };
        b = new UsageOfAccessoryFeatureEvent.FeatureName("HairBand", 1) {

            public String a()
            {
                return "Hair Band";
            }

        };
        c = new UsageOfAccessoryFeatureEvent.FeatureName("Necklace", 2) {

            public String a()
            {
                return "Necklace";
            }

        };
        d = new UsageOfAccessoryFeatureEvent.FeatureName("EyeWear", 3) {

            public String a()
            {
                return "Eye Wear";
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
