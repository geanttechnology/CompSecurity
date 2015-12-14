// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;


public abstract class <init> extends Enum
{

    public static final g a;
    public static final g b;
    public static final g c;
    public static final g d;
    public static final g e;
    public static final g f;
    public static final g g;
    private static final g h[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKTemplateStoreTypeClicksEvent$TypeName, s);
    }

    public static <init>[] values()
    {
        return (<init>[])h.clone();
    }

    public abstract String a();

    static 
    {
        a = new YMKTemplateStoreTypeClicksEvent.TypeName("NaturalLooks", 0) {

            public String a()
            {
                return "Natural Looks";
            }

        };
        b = new YMKTemplateStoreTypeClicksEvent.TypeName("CostumeLooks", 1) {

            public String a()
            {
                return "Costume Looks";
            }

        };
        c = new YMKTemplateStoreTypeClicksEvent.TypeName("EyeShadow", 2) {

            public String a()
            {
                return "Eye Shadow";
            }

        };
        d = new YMKTemplateStoreTypeClicksEvent.TypeName("EyeLiner", 3) {

            public String a()
            {
                return "Eye Liner";
            }

        };
        e = new YMKTemplateStoreTypeClicksEvent.TypeName("EyeLashes", 4) {

            public String a()
            {
                return "Eye Lashes";
            }

        };
        f = new YMKTemplateStoreTypeClicksEvent.TypeName("EyeWear", 5) {

            public String a()
            {
                return "Eye Wear";
            }

        };
        g = new YMKTemplateStoreTypeClicksEvent.TypeName("Accessory", 6) {

            public String a()
            {
                return "Accessory";
            }

        };
        h = (new h[] {
            a, b, c, d, e, f, g
        });
    }

    private _cls7(String s, int i)
    {
        super(s, i);
    }

    _cls7(String s, int i, _cls7 _pcls7)
    {
        this(s, i);
    }
}
