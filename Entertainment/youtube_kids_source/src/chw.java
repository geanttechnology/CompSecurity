// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Handler;
import java.util.concurrent.ExecutorService;
import org.chromium.net.HttpUrlRequestFactory;

public final class chw
{

    public static final atf a = new atf();
    public final Context b;
    public final asa c = new asa();
    public final asa d = new asa();
    public final ary e;
    public final String f;
    public final bkn g;
    public final bmh h;
    public final ExecutorService i;
    public final cnb j;
    public final bmi k;
    public final ckv l;
    public final cna m = new cna();
    public final clv n = new clv();
    private final bjp o;
    private HttpUrlRequestFactory p;
    private boolean q;
    private boolean r;
    private cmh s;

    public chw(Context context, Handler handler, String s1, bkn bkn1, bmh bmh1, ExecutorService executorservice, cnb cnb1, 
            bjp bjp1, bmi bmi1, ckt ckt1, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        b = context;
        e = new ary((Handler)b.a(handler), c);
        new ary(handler, d);
        f = (String)b.a(s1);
        g = (bkn)b.a(bkn1);
        h = (bmh)b.a(bmh1);
        i = executorservice;
        j = (cnb)b.a(cnb1);
        o = (bjp)b.a(bjp1);
        k = (bmi)b.a(bmi1);
        char c1;
        if (!flag)
        {
            c1 = '\u01E0';
        } else
        if (!flag1)
        {
            c1 = '\u02D0';
        } else
        if (!flag2)
        {
            c1 = '\u0438';
        } else
        if (!flag3)
        {
            c1 = '\u05A0';
        } else
        {
            c1 = '\u0870';
        }
        l = new cje((ckt)b.a(ckt1), bkn1, e, cnb1, c1);
    }

    static bjp a(chw chw1)
    {
        return chw1.o;
    }

    static cmh a(chw chw1, cmh cmh)
    {
        chw1.s = cmh;
        return cmh;
    }

    static HttpUrlRequestFactory a(chw chw1, HttpUrlRequestFactory httpurlrequestfactory)
    {
        chw1.p = httpurlrequestfactory;
        return httpurlrequestfactory;
    }

    static boolean a(chw chw1, boolean flag)
    {
        chw1.q = flag;
        return flag;
    }

    static String b(chw chw1)
    {
        return chw1.f;
    }

    static boolean b(chw chw1, boolean flag)
    {
        chw1.r = flag;
        return flag;
    }

    static boolean c(chw chw1)
    {
        return chw1.q;
    }

    static boolean d(chw chw1)
    {
        return chw1.r;
    }

    static HttpUrlRequestFactory e(chw chw1)
    {
        return chw1.p;
    }

    static Context f(chw chw1)
    {
        return chw1.b;
    }

    static cmh g(chw chw1)
    {
        return chw1.s;
    }

    static clv h(chw chw1)
    {
        return chw1.n;
    }

    static bmi i(chw chw1)
    {
        return chw1.k;
    }

    static cnb j(chw chw1)
    {
        return chw1.j;
    }

    public final bjp a()
    {
        return new chy(this, e, true);
    }

}
