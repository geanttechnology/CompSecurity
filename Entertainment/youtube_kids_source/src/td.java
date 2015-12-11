// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;

public final class td extends Enum
{

    private static td a;
    private static td b;
    private static td c;
    private static td d;
    private static td e;
    private static td f;
    private static td g;
    private static final td k[];
    private final int h;
    private final tg i;
    private Typeface j;

    private td(String s, int l, int i1, int j1, tg tg1)
    {
        super(s, l);
        h = j1;
        i = tg1;
    }

    public static int a()
    {
        return values()[3].h;
    }

    private static Typeface a(int l, AssetManager assetmanager)
    {
        td atd[] = values();
        for (int i1 = 0; i1 < atd.length; i1++)
        {
            if (atd[i1].h == l)
            {
                if (atd[i1].j == null)
                {
                    atd[i1].j = atd[i1].i.a(assetmanager);
                }
                return atd[i1].j;
            }
        }

        return null;
    }

    public static Typeface a(Context context, cyi cyi1)
    {
        if (cyi1.f != 7)
        {
            return a(cyi1.f, context.getAssets());
        }
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            return ((CaptioningManager)context.getSystemService("captioning")).getUserStyle().getTypeface();
        } else
        {
            return a(3, context.getAssets());
        }
    }

    private static tg a(Typeface typeface)
    {
        return new tf(typeface);
    }

    private static tg a(String s)
    {
        return new te(s);
    }

    public static td valueOf(String s)
    {
        return (td)Enum.valueOf(td, s);
    }

    public static td[] values()
    {
        return (td[])k.clone();
    }

    static 
    {
        a = new td("MONOSPACED_SERIF", 0, 0x7f0b00cd, 0, a("fonts/MonoSerif-Regular.ttf"));
        b = new td("PROPORTIONAL_SERIF", 1, 0x7f0b00ce, 1, a(Typeface.SERIF));
        c = new td("MONOSPACED_SANS_SERIF", 2, 0x7f0b00cf, 2, a(Typeface.MONOSPACE));
        d = new td("PROPORTIONAL_SANS_SERIF", 3, 0x7f0b00d0, 3, a(Typeface.SANS_SERIF));
        e = new td("CASUAL", 4, 0x7f0b00d1, 4, a("fonts/ComingSoon-Regular.ttf"));
        f = new td("CURSIVE", 5, 0x7f0b00d2, 5, a("fonts/DancingScript-Regular.ttf"));
        g = new td("SMALL_CAPITALS", 6, 0x7f0b00d3, 6, a("fonts/CarroisGothicSC-Regular.ttf"));
        k = (new td[] {
            a, b, c, d, e, f, g
        });
    }
}
