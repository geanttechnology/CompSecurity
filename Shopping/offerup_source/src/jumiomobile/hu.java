// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


public final class hu extends Enum
{

    public static final hu a;
    public static final hu b;
    public static final hu c;
    public static final hu d;
    public static final hu e;
    public static final hu f;
    public static final hu g;
    public static final hu h;
    public static final hu i;
    public static final hu j;
    public static final hu k;
    public static final hu l;
    public static final hu m;
    public static final hu n;
    public static final hu o;
    public static final hu p;
    public static final hu q;
    public static final hu r;
    public static final hu s;
    public static final hu t;
    public static final hu u;
    public static final hu v;
    private static final hu w[];

    private hu(String s1, int i1)
    {
        super(s1, i1);
    }

    public static hu valueOf(String s1)
    {
        return (hu)Enum.valueOf(jumiomobile/hu, s1);
    }

    public static hu[] values()
    {
        return (hu[])w.clone();
    }

    static 
    {
        a = new hu("DISCONNECTED", 0);
        b = new hu("SETTINGS_CALL_PENDING", 1);
        c = new hu("SETTINGS_CALL_FINISHED", 2);
        d = new hu("SETTINGS_CALL_ERROR", 3);
        e = new hu("INITIATE_CALL_PENDING", 4);
        f = new hu("INITIATE_CALL_FINISHED", 5);
        g = new hu("INITIATE_CALL_ERROR", 6);
        h = new hu("START_ATTEMPT_CALL_PENDING", 7);
        i = new hu("START_ATTEMPT_CALL_FINISHED", 8);
        j = new hu("START_ATTEMPT_CALL_ERROR", 9);
        k = new hu("EXTRACT_DATA_CALL_PENDING", 10);
        l = new hu("EXTRACT_DATA_CALL_FINISHED", 11);
        m = new hu("EXTRACT_DATA_CALL_ERROR", 12);
        n = new hu("DATA_CALL_PENDING", 13);
        o = new hu("DATA_CALL_FINISHED", 14);
        p = new hu("DATA_CALL_ERROR", 15);
        q = new hu("ADD_CALL_PENDING", 16);
        r = new hu("ADD_CALL_FINISHED", 17);
        s = new hu("ADD_CALL_ERROR", 18);
        t = new hu("FINALIZE_CALL_PENDING", 19);
        u = new hu("FINALIZE_CALL_FINISHED", 20);
        v = new hu("FINALIZE_CALL_ERROR", 21);
        w = (new hu[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v
        });
    }
}
