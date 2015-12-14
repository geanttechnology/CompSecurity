// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.j;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            MainActivity

class a extends j
{

    final MainActivity a;

    protected Boolean a(Boolean boolean1)
    {
        if (boolean1.booleanValue())
        {
            try
            {
                AccountManager.a(false, true, Globals.c()).d();
            }
            catch (CancellationException cancellationexception)
            {
                cancellationexception.printStackTrace();
                return boolean1;
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
                return boolean1;
            }
            catch (ExecutionException executionexception)
            {
                executionexception.printStackTrace();
                return boolean1;
            }
        }
        return boolean1;
    }

    protected volatile Object a(Object obj)
    {
        return a((Boolean)obj);
    }

    (MainActivity mainactivity)
    {
        a = mainactivity;
        super();
    }
}
