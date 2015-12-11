// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ctn extends Enum
{

    public static final ctn a;
    private static ctn c;
    private static ctn d;
    private static ctn e;
    private static final ctn f[];
    public final String b;

    private ctn(String s, int i, String s1)
    {
        super(s, i);
        b = s1;
    }

    public static ctn a(int i)
    {
        if (i < 0 || i >= values().length)
        {
            return a;
        } else
        {
            return values()[i];
        }
    }

    public static ctn valueOf(String s)
    {
        return (ctn)Enum.valueOf(ctn, s);
    }

    public static ctn[] values()
    {
        return (ctn[])f.clone();
    }

    static 
    {
        a = new ctn("NO_FEATURE", 0, null);
        c = new ctn("EXTERNAL_URL", 1, "external");
        d = new ctn("MY_UPLOADS", 2, "upl");
        e = new ctn("REMOTE_QUEUE", 3, "remote_queue");
        f = (new ctn[] {
            a, c, d, e
        });
    }
}
