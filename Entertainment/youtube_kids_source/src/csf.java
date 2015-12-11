// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class csf extends Enum
{

    public static final csf a;
    public static final csf b;
    public static final csf c;
    public static final csf d;
    public static final csf e;
    public static final csf f;
    public static final csf g;
    public static final csf h;
    public static final csf i;
    public static final csf j;
    public static final csf k;
    private static final csf l[];

    private csf(String s, int i1)
    {
        super(s, i1);
    }

    public static csf valueOf(String s)
    {
        return (csf)Enum.valueOf(csf, s);
    }

    public static csf[] values()
    {
        return (csf[])l.clone();
    }

    public final transient boolean a(csf acsf[])
    {
        boolean flag1 = false;
        int j1 = acsf.length;
        int i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < j1)
                {
                    if (this != acsf[i1])
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    static 
    {
        a = new csf("UNKNOWN", 0);
        b = new csf("VIDEO_ERROR", 1);
        c = new csf("UNPLAYABLE", 2);
        d = new csf("REQUEST_FAILED", 3);
        e = new csf("USER_CHECK_FAILED", 4);
        f = new csf("LICENSE_SERVER_ERROR", 5);
        g = new csf("LICENSE_SERVER_CONCURRENT_PLAYBACK_ERROR", 6);
        h = new csf("PLAYER_ERROR", 7);
        i = new csf("NO_STREAMS", 8);
        j = new csf("WATCH_NEXT_ERROR", 9);
        k = new csf("UNPLAYABLE_IN_BACKGROUND", 10);
        l = (new csf[] {
            a, b, c, d, e, f, g, h, i, j, 
            k
        });
    }
}
