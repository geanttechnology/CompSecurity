// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class alu extends Enum
{

    public static final alu a;
    public static final alu b;
    public static final alu c;
    public static final alu d;
    public static final alu e;
    public static final alu f;
    public static final alu g;
    public static final alu h;
    public static final alu i;
    private static final alu l[];
    public final int j;
    public final boolean k;

    private alu(String s, int i1, int j1, boolean flag)
    {
        super(s, i1);
        j = j1;
        k = flag;
    }

    public static alu valueOf(String s)
    {
        return (alu)Enum.valueOf(alu, s);
    }

    public static alu[] values()
    {
        return (alu[])l.clone();
    }

    public final String toString()
    {
        String s = String.valueOf(name());
        boolean flag = k;
        return (new StringBuilder(String.valueOf(s).length() + 35)).append("RemoteError [name=").append(s).append(", canRetry=").append(flag).append("]").toString();
    }

    static 
    {
        a = new alu("LAUNCH_CAST_FAIL_TIMEOUT", 0, 0x7f0b0048, false);
        b = new alu("LAUNCH_FAIL_DEVICE_BUSY", 1, 0x7f0b0049, true);
        c = new alu("LAUNCH_FAIL_NEEDS_INSTALL", 2, 0x7f0b004b, false);
        d = new alu("LAUNCH_FAIL_TIMEOUT", 3, 0x7f0b0048, true);
        e = new alu("LOUNGE_SERVER_CONNECTION_ERROR", 4, 0x7f0b0048, true);
        f = new alu("NETWORK", 5, 0x7f0b004c, true);
        g = new alu("SCREEN_NOT_FOUND", 6, 0x7f0b004a, false);
        h = new alu("UNPLAYABLE", 7, 0x7f0b004e, true);
        i = new alu("UNKNOWN", 8, 0x7f0b004d, false);
        l = (new alu[] {
            a, b, c, d, e, f, g, h, i
        });
    }
}
