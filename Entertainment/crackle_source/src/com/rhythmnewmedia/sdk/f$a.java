// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            f

public static final class ation extends Enum
{

    public static final g a;
    public static final g b;
    public static final g c;
    public static final g d;
    public static final g e;
    public static final g f;
    public static final g g;
    private static final g h[];

    static Animation a(ation ation)
    {
        switch (a[ation.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F);

        case 2: // '\002'
            return new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1F, 2, 0.0F);

        case 3: // '\003'
            return new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);

        case 4: // '\004'
            return new TranslateAnimation(2, -1F, 2, 0.0F, 2, 0.0F, 2, 0.0F);

        case 5: // '\005'
            return new AlphaAnimation(0.0F, 1.0F);
        }
    }

    static Animation b(aAnimation aanimation)
    {
        switch (a[aanimation.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 0.0F, 2, -1F);

        case 2: // '\002'
            return new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 0.0F, 2, 1.0F);

        case 3: // '\003'
            return new TranslateAnimation(2, 0.0F, 2, -1F, 2, 0.0F, 2, 0.0F);

        case 4: // '\004'
            return new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);

        case 5: // '\005'
            return new AlphaAnimation(1.0F, 0.0F);
        }
    }

    public static aAnimation valueOf(String s)
    {
        return (aAnimation)Enum.valueOf(com/rhythmnewmedia/sdk/f$a, s);
    }

    public static aAnimation[] values()
    {
        return (aAnimation[])h.clone();
    }

    static 
    {
        a = new <init>("system", 0);
        b = new <init>("none", 1);
        c = new <init>("slideUp", 2);
        d = new <init>("slideDown", 3);
        e = new <init>("slideLeft", 4);
        f = new <init>("slideRight", 5);
        g = new <init>("fade", 6);
        h = (new h[] {
            a, b, c, d, e, f, g
        });
    }

    private ation(String s, int i)
    {
        super(s, i);
    }
}
