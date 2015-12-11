// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cts extends Enum
{

    public static final cts a;
    public static final cts b;
    public static final cts c;
    public static final cts d;
    public static final cts e;
    public static final cts f;
    private static final cts g[];

    private cts(String s, int i)
    {
        super(s, i);
    }

    public static cts valueOf(String s)
    {
        return (cts)Enum.valueOf(cts, s);
    }

    public static cts[] values()
    {
        return (cts[])g.clone();
    }

    public final boolean a(cts cts1)
    {
        return ordinal() >= cts1.ordinal();
    }

    public final transient boolean a(cts acts[])
    {
        boolean flag1 = false;
        int j = acts.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (this != acts[i])
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    static 
    {
        a = new cts("NEW", 0);
        b = new cts("VIDEO_LOADING", 1);
        c = new cts("VIDEO_PLAYBACK_ERROR", 2);
        d = new cts("VIDEO_PLAYBACK_LOADED", 3);
        e = new cts("VIDEO_WATCH_LOADED", 4);
        f = new cts("SEQUENCE_EMPTY", 5);
        g = (new cts[] {
            a, b, c, d, e, f
        });
    }
}
