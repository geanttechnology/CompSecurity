// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


// Referenced classes of package a.a:
//            az, cm, ci, cx

public final class ax extends Enum
{

    public static final ax a;
    public static final ax b;
    public static final ax c;
    public static final ax d;
    public static final ax e;
    public static final ax f;
    public static final ax g;
    public static final ax h;
    public static final ax i;
    public static final ax j;
    public static final ax k;
    private static final ax r[];
    private String l;
    private int m;
    private int n;
    private az o;
    private cx p;
    private String q;

    private ax(String s, int i1, String s1, int j1, int k1, az az1, cx cx, 
            String s2)
    {
        super(s, i1);
        l = s1;
        m = j1;
        n = k1;
        o = az1;
        p = cx;
        q = s2;
    }

    public static ax valueOf(String s)
    {
        return (ax)Enum.valueOf(a/a/ax, s);
    }

    public static ax[] values()
    {
        return (ax[])r.clone();
    }

    public final String a()
    {
        return l;
    }

    public final int b()
    {
        return m;
    }

    public final az c()
    {
        return o;
    }

    public final cx d()
    {
        return p;
    }

    public final int e()
    {
        return n;
    }

    public final String f()
    {
        return q;
    }

    static 
    {
        a = new ax("APP_LOADS", 0, "app_loads_2", 10, 0x7fffffff, new az(0), new cm(), null);
        b = new ax("HAND_EXCS", 1, "exceptions", 5, 50, new az(0), new cm(), "exceptions");
        c = new ax("INTERNAL_EXCS", 2, "internal_excs", 3, 3, new az(0), new cm(), "exceptions");
        d = new ax("NDK_CRASHES", 3, "ndk_crashes", 5, 0x7fffffff, new az(0), new cm(), "crashes");
        e = new ax("SDK_CRASHES", 4, "sdk_crashes", 5, 0x7fffffff, new az(0), new cm(), "crashes");
        f = new ax("CURR_BCS", 5, "current_bcs", 50, 0x7fffffff, new az(1), new ci(), null);
        g = new ax("NW_BCS", 6, "network_bcs", 10, 0x7fffffff, new az(0), new ci(), null);
        h = new ax("PREV_BCS", 7, "previous_bcs", 50, 0x7fffffff, new az(0), new ci(), null);
        i = new ax("STARTED_TXNS", 8, "started_txns", 50, 0x7fffffff, new az(0), new ci(), null);
        j = new ax("FINISHED_TXNS", 9, "finished_txns", 0x7fffffff, 0x7fffffff, new az(0), new ci(), null);
        k = new ax("SYSTEM_BCS", 10, "system_bcs", 100, 0x7fffffff, new az(0), new ci(), null);
        r = (new ax[] {
            a, b, c, d, e, f, g, h, i, j, 
            k
        });
    }
}
