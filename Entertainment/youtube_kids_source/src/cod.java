// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.Executor;
import org.apache.http.client.HttpClient;

public abstract class cod
{

    private HttpClient a;
    public final Executor b;
    public final bmi c;
    public final String d;
    public final cpc e;
    public final bns f;

    public cod(Executor executor, HttpClient httpclient)
    {
        b = (Executor)b.b(executor, "executor can't be null");
        a = (HttpClient)b.b(httpclient, "httpClient can't be null");
        e = new cpc(bkf.a);
        f = null;
        d = null;
        c = null;
    }

    public cod(Executor executor, HttpClient httpclient, bmi bmi1)
    {
        b = (Executor)b.b(executor, "executor can't be null");
        a = (HttpClient)b.b(httpclient, "httpClient can't be null");
        c = (bmi)b.b(bmi1, "clock can't be null");
        e = new cpc(bkf.a);
        f = null;
        d = null;
    }

    public cod(Executor executor, HttpClient httpclient, bns bns1, bmi bmi1)
    {
        b = (Executor)b.b(executor, "executor can't be null");
        a = (HttpClient)b.b(httpclient, "httpClient can't be null");
        f = (bns)b.b(bns1, "xmlParser cannot be null");
        c = (bmi)b.b(bmi1, "clock cannot be null");
        e = new cpc(bkf.a);
        d = null;
    }

    public cod(Executor executor, HttpClient httpclient, bns bns1, String s, bmi bmi1)
    {
        b = (Executor)b.b(executor, "executor can't be null");
        a = (HttpClient)b.b(httpclient, "httpClient can't be null");
        f = (bns)b.b(bns1, "xmlParser can't be null");
        d = (String)b.b(s, "cachePath can't be null");
        c = (bmi)b.b(bmi1, "clock can't be null");
        e = new cpc(bkf.a);
    }

    public cod(Executor executor, HttpClient httpclient, String s, bmi bmi1)
    {
        b = (Executor)b.b(executor, "executor can't be null");
        a = (HttpClient)b.b(httpclient, "httpClient can't be null");
        c = (bmi)b.b(bmi1, "clock can't be null");
        d = s;
        e = new cpc(bkf.a);
        f = null;
    }

    public static bie a(int i)
    {
        return new bie(i);
    }

    public static cqp a(bjo bjo, bid bid, crb crb)
    {
        return new cqp(bjo, bid, crb);
    }

    public final coa a(bid bid, crb crb, long l)
    {
        b.b(c, "this instance does not contain a clock");
        return coa.a(bid, crb, c, l);
    }

    public final cqg a(crb crb)
    {
        return cqg.a(b, crb);
    }

    public final cqv a(cot cot, coo coo)
    {
        return new cqv(a, cot, coo);
    }

    public final big c()
    {
        b.b(d, "this instance does not support persistent caching");
        bim bim1 = new bim(d);
        Executor executor = b;
        b.a(executor);
        bim1.e = true;
        executor.execute(new bil(bim1));
        return bim1;
    }
}
