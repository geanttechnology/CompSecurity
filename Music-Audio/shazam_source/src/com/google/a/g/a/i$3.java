// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.g.a;

import java.util.concurrent.ExecutionException;

// Referenced classes of package com.google.a.g.a:
//            i, r, h, j

static final class t>
    implements Runnable
{

    final j a;
    final h b;

    public final void run()
    {
        Object obj;
        try
        {
            obj = r.a(a);
        }
        catch (ExecutionException executionexception)
        {
            b.onFailure(executionexception.getCause());
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            b.onFailure(runtimeexception);
            return;
        }
        catch (Error error)
        {
            b.onFailure(error);
            return;
        }
        b.onSuccess(obj);
    }

    ption(j j, h h1)
    {
        a = j;
        b = h1;
        super();
    }
}
