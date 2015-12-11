// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class cty
    implements Runnable
{

    private String a;
    private byte b[];
    private String c;
    private String d;
    private int e;
    private int f;
    private bhv g;
    private ctx h;

    cty(ctx ctx1, String s, byte abyte0[], String s1, String s2, int i, int j, 
            bhv bhv)
    {
        h = ctx1;
        a = s;
        b = abyte0;
        c = s1;
        d = s2;
        e = i;
        f = j;
        g = bhv;
        super();
    }

    public final void run()
    {
        try
        {
            bxb bxb1 = (bxb)h.a(a, b, c, d, e, f).get(ctx.b, TimeUnit.MILLISECONDS);
            ctx.a(h, g, bxb1);
            return;
        }
        catch (TimeoutException timeoutexception)
        {
            ctx.a(h, g, timeoutexception);
            return;
        }
        catch (ExecutionException executionexception)
        {
            ctx.a(h, g, executionexception);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            ctx.a(h, g, interruptedexception);
        }
    }
}
