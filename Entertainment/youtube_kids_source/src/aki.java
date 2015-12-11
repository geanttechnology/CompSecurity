// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class aki extends Enum
{

    public static final aki a;
    public static final aki b;
    public static final aki c;
    public static final aki d;
    private static final aki e[];

    private aki(String s, int i)
    {
        super(s, i);
    }

    public static aki valueOf(String s)
    {
        return (aki)Enum.valueOf(aki, s);
    }

    public static aki[] values()
    {
        return (aki[])e.clone();
    }

    static 
    {
        a = new aki("CREATED", 0);
        b = new aki("CONNECTING", 1);
        c = new aki("CONNECTED", 2);
        d = new aki("DISCONNECTED", 3);
        e = (new aki[] {
            a, b, c, d
        });
    }
}
