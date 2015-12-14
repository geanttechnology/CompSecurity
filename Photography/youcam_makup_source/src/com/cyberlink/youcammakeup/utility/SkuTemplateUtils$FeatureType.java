// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;


public final class  extends Enum
{

    public static final j a;
    public static final j b;
    public static final j c;
    public static final j d;
    public static final j e;
    public static final j f;
    public static final j g;
    public static final j h;
    public static final j i;
    public static final j j;
    private static final j k[];

    public static final String a( )
    {
        if ( == a)
        {
            return "lipstick";
        }
        if ( == b)
        {
            return "eye_shadow";
        }
        if ( == c)
        {
            return "eye_contact";
        }
        if ( == d)
        {
            return "eye_brow";
        }
        if ( == e)
        {
            return "eye_line";
        }
        if ( == f)
        {
            return "eye_lash";
        }
        if ( == g)
        {
            return "blush";
        }
        if ( == h)
        {
            return "skin_toner";
        }
        if ( == i)
        {
            return "wig";
        }
        if ( == j)
        {
            return "hair_dye";
        } else
        {
            return "lipstick";
        }
    }

    public static j valueOf(String s)
    {
        return (j)Enum.valueOf(com/cyberlink/youcammakeup/utility/SkuTemplateUtils$FeatureType, s);
    }

    public static j[] values()
    {
        return (j[])k.clone();
    }

    static 
    {
        a = new <init>("LIPSTICK", 0);
        b = new <init>("EYE_SHADOW", 1);
        c = new <init>("EYE_CONTACT", 2);
        d = new <init>("EYE_BROW", 3);
        e = new <init>("EYE_LINE", 4);
        f = new <init>("EYE_LASH", 5);
        g = new <init>("BLUSH", 6);
        h = new <init>("SKIN_TONE", 7);
        i = new <init>("WIG", 8);
        j = new <init>("HAIR_DYE", 9);
        k = (new k[] {
            a, b, c, d, e, f, g, h, i, j
        });
    }

    private (String s, int l)
    {
        super(s, l);
    }
}
