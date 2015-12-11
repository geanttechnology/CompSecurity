// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.Executor;
import org.apache.http.client.HttpClient;

public final class cxh extends cod
    implements cxn
{

    private final bid a = a(20);
    private final crb g;
    private final crb h;
    private final crb i;

    public cxh(Executor executor, HttpClient httpclient, bns bns, String s, bmi bmi)
    {
        super(executor, httpclient, bns, s, bmi);
        executor = new cxj();
        bns = a(20);
        httpclient = a(executor, executor);
        executor = httpclient;
        if (d != null)
        {
            executor = a(c(), httpclient, 0x240c8400L);
        }
        g = a(bns, a(executor), 0x6ddd00L);
        executor = new cxo(f);
        httpclient = a(executor, executor);
        executor = httpclient;
        if (d != null)
        {
            executor = a(c(), httpclient, 0x240c8400L);
        }
        executor = a(executor);
        h = a(a, executor, 0x6ddd00L);
        a(a(new cxo(f), new coq()));
        executor = a(new cxi(f));
        i = a(a, executor, 0x6ddd00L);
    }

    public final void a(cxu cxu1, bhv bhv)
    {
        b.a(cxu1);
        b.a(cxu1.d);
        if (cxu1.f != null)
        {
            i.a(cxu1, bhv);
            return;
        } else
        {
            h.a(cxu1, bhv);
            return;
        }
    }

    public final void a(String s, bhv bhv)
    {
        b.a(s);
        bhv = new cxk(bhv);
        g.a(s, bhv);
    }
}
