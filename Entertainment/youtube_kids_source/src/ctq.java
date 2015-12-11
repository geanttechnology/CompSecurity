// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ctq extends Enum
{

    public static final ctq a;
    public static final ctq b;
    public static final ctq c;
    private static final ctq d[];

    private ctq(String s, int i)
    {
        super(s, i);
    }

    public static ctq valueOf(String s)
    {
        return (ctq)Enum.valueOf(ctq, s);
    }

    public static ctq[] values()
    {
        return (ctq[])d.clone();
    }

    static 
    {
        a = new ctq("SINGLE_VIDEO", 0);
        b = new ctq("PLAYLIST", 1);
        c = new ctq("VIDEO_LIST", 2);
        d = (new ctq[] {
            a, b, c
        });
    }
}
