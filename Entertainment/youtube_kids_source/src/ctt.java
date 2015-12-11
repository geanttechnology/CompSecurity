// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ctt extends Enum
{

    public static final ctt a;
    public static final ctt b;
    public static final ctt c;
    public static final ctt d;
    public static final ctt e;
    public static final ctt f;
    public static final ctt g;
    public static final ctt h;
    public static final ctt i;
    public static final ctt j;
    private static final ctt k[];

    private ctt(String s, int l)
    {
        super(s, l);
    }

    public static ctt valueOf(String s)
    {
        return (ctt)Enum.valueOf(ctt, s);
    }

    public static ctt[] values()
    {
        return (ctt[])k.clone();
    }

    public final boolean a()
    {
        return a(new ctt[] {
            d, e, f
        });
    }

    public final boolean a(ctt ctt1)
    {
        return ordinal() >= ctt1.ordinal();
    }

    public final transient boolean a(ctt actt[])
    {
        boolean flag1 = false;
        int i1 = actt.length;
        int l = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (l < i1)
                {
                    if (this != actt[l])
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            l++;
        } while (true);
    }

    public final boolean b()
    {
        return a(new ctt[] {
            c, e, h
        });
    }

    public final boolean c()
    {
        return a(new ctt[] {
            e, f, h, i
        });
    }

    public final boolean d()
    {
        return a(new ctt[] {
            e, f
        });
    }

    public final boolean e()
    {
        return a(new ctt[] {
            h, i
        });
    }

    static 
    {
        a = new ctt("NEW", 0);
        b = new ctt("PLAYBACK_LOADED", 1);
        c = new ctt("AD_LOADING", 2);
        d = new ctt("AD_LOADED", 3);
        e = new ctt("MEDIA_AD_PLAY_REQUESTED", 4);
        f = new ctt("MEDIA_PLAYING_AD", 5);
        g = new ctt("READY", 6);
        h = new ctt("MEDIA_VIDEO_PLAY_REQUESTED", 7);
        i = new ctt("MEDIA_PLAYING_VIDEO", 8);
        j = new ctt("ENDED", 9);
        k = (new ctt[] {
            a, b, c, d, e, f, g, h, i, j
        });
    }
}
