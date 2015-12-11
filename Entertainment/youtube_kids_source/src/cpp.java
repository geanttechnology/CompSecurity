// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.net.Uri;
import java.util.concurrent.Executor;
import org.apache.http.client.HttpClient;

public final class cpp extends cod
    implements blu
{

    private final Executor a;
    private final int g;
    private final int h;
    private final crb i;
    private final crb j;

    public cpp(Executor executor, Executor executor1, Context context, HttpClient httpclient, String s, bmi bmi, cps cps1, 
            int k, int l)
    {
        super(executor, httpclient, s, bmi);
        a = (Executor)b.a(executor1);
        g = k;
        h = l;
        executor = new coq();
        httpclient = a(g);
        executor1 = a(e, executor);
        executor = executor1;
        if (d != null)
        {
            executor = a(c(), executor1, 0x240c8400L);
        }
        i = a(httpclient, new cqr(new cqm(context.getContentResolver(), executor)), 0x6ddd00L);
        a(i);
        executor = new cpo();
        j = a(new bin(h), a(cqn.a(i, executor, a)), 0x6ddd00L);
        a(cps1.a, true, cps1.d);
        a(cps1.b, true, cps1.e);
        a(cps1.c, false, null);
    }

    private crb a(int k, boolean flag, android.graphics.Bitmap.Config config)
    {
        config = new cpo(k, flag, config);
        config = a(cqn.a(i, config, a));
        return a(((bid) (a(h))), ((crb) (config)), 0x6ddd00L);
    }

    public final void a(Uri uri, bhv bhv)
    {
        j.a(uri, bhv);
    }
}
