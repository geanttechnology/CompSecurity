// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.net;


// Referenced classes of package com.sessionm.net:
//            Request

public static final class fu extends Enum
{

    public static final fs fj;
    public static final fs fk;
    public static final fs fl;
    public static final fs fm;
    public static final fs fn;
    public static final fs fo;
    public static final fs fp;
    public static final fs fq;
    public static final fs fr;
    public static final fs fs;
    private static final fs fv[];
    private final d em;
    private final String ft;
    private final int fu;

    static d a(fu fu1)
    {
        return fu1.em;
    }

    public static em valueOf(String s)
    {
        return (em)Enum.valueOf(com/sessionm/net/Request$Type, s);
    }

    public static em[] values()
    {
        return (em[])fv.clone();
    }

    d aN()
    {
        return em;
    }

    String getPath()
    {
        return ft;
    }

    int getTimeout()
    {
        return fu;
    }

    static 
    {
        fj = new <init>("SESSION_START", 0, "/v%s/apps/%s/session.json", d.eU, 30000);
        fk = new <init>("ACTION", 1, "/v%s/events.json", d.eU);
        fl = new <init>("SESSION_END", 2, "/v%s/session.json", d.eU, 5000);
        fm = new <init>("CONTENT", 3, "", d.eV);
        fn = new <init>("ERROR", 4, "/v%s/apps/%s/errors.json", d.eU);
        fo = new <init>("DELIVERED", 5, "/v%s/apps/%s/bugs/delivered.json", d.eV);
        fp = new <init>("CLAIM", 6, "/v%s/apps/%s/awards/%s/ads", d.eV);
        fq = new <init>("GENERIC", 7, "", d.eY);
        fr = new <init>("OPT_IN_OUT", 8, "/optout.json", d.eX);
        fs = new <init>("CPI", 9, "/transactions", d.eU);
        fv = (new fv[] {
            fj, fk, fl, fm, fn, fo, fp, fq, fr, fs
        });
    }

    private d(String s, int i, String s1, d d)
    {
        super(s, i);
        ft = s1;
        em = d;
        fu = -1;
    }

    private d(String s, int i, String s1, d d, int j)
    {
        super(s, i);
        ft = s1;
        em = d;
        fu = j;
    }
}
