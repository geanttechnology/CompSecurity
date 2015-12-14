// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;


public abstract class <init> extends Enum
{

    public static final h a;
    public static final h b;
    public static final h c;
    public static final h d;
    public static final h e;
    public static final h f;
    public static final h g;
    public static final h h;
    private static final h i[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKTemplateStoreEvent$Feature, s);
    }

    public static <init>[] values()
    {
        return (<init>[])i.clone();
    }

    public abstract String a();

    static 
    {
        a = new YMKTemplateStoreEvent.Feature("NaturalMakeup", 0) {

            public String a()
            {
                return "natural_makeup";
            }

        };
        b = new YMKTemplateStoreEvent.Feature("Costume", 1) {

            public String a()
            {
                return "costume";
            }

        };
        c = new YMKTemplateStoreEvent.Feature("Eyeliner", 2) {

            public String a()
            {
                return "eyeliner";
            }

        };
        d = new YMKTemplateStoreEvent.Feature("Eyeshadow", 3) {

            public String a()
            {
                return "eyeshadow";
            }

        };
        e = new YMKTemplateStoreEvent.Feature("Hair", 4) {

            public String a()
            {
                return "hair";
            }

        };
        f = new YMKTemplateStoreEvent.Feature("Eyelash", 5) {

            public String a()
            {
                return "eyelash";
            }

        };
        g = new YMKTemplateStoreEvent.Feature("Accessory", 6) {

            public String a()
            {
                return "accessory";
            }

        };
        h = new YMKTemplateStoreEvent.Feature("Glasses", 7) {

            public String a()
            {
                return "glasses";
            }

        };
        i = (new i[] {
            a, b, c, d, e, f, g, h
        });
    }

    private _cls8(String s, int j)
    {
        super(s, j);
    }

    _cls8(String s, int j, _cls8 _pcls8)
    {
        this(s, j);
    }
}
