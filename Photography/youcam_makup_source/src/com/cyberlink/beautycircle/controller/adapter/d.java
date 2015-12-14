// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.app.Activity;
import android.view.ViewGroup;
import com.cyberlink.beautycircle.model.network.o;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.j;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            c, n

public class d extends c
{

    private Long d;

    public d(Activity activity, ViewGroup viewgroup, long l, int i, n n)
    {
        super(activity, viewgroup, l, i, n);
        d = null;
    }

    public void a(long l)
    {
        d = Long.valueOf(l);
    }

    protected com.cyberlink.beautycircle.model.network.d b(int i, int k)
    {
        com.cyberlink.beautycircle.model.network.d d1;
        try
        {
            d1 = (com.cyberlink.beautycircle.model.network.d)o.b(d.longValue(), AccountManager.c().longValue(), i, k).d();
        }
        catch (CancellationException cancellationexception)
        {
            cancellationexception.printStackTrace();
            return null;
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
            return null;
        }
        catch (ExecutionException executionexception)
        {
            executionexception.printStackTrace();
            return null;
        }
        return d1;
    }
}
