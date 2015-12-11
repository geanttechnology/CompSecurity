// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import org.apache.http.client.HttpClient;

public final class ql
{

    protected ql()
    {
    }

    public ql(bzl bzl, HttpClient httpclient, Executor executor, List list, bnx bnx, bng bng, bns bns)
    {
        b.a(bzl);
        b.a(httpclient);
        b.a(executor);
        b.a(list);
        b.a(bnx);
        b.a(bng);
        b.a(bns);
        for (bzl = list.iterator(); bzl.hasNext();)
        {
            if ((crc)bzl.next() instanceof qm)
            {
                throw new IllegalArgumentException("IdentityClient must not have an authentication header decorator");
            }
        }

        bzl = new bzk(bkf.a, list, bng, bzj.a);
        new cqv(httpclient, bzl, new qd(bns));
        new cqv(httpclient, bzl, new cbl(bns));
    }
}
