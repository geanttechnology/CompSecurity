// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Base64;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class baf extends axi
{

    public baf(Context context)
    {
        super(context);
    }

    static String a(byte abyte0[])
    {
        return Base64.encodeToString(abyte0, 11);
    }

    static String b(String s)
    {
        return Base64.encodeToString((new StringBuilder("ERROR : ")).append(s).toString().getBytes(), 11);
    }

    protected final IInterface a(IBinder ibinder)
    {
        return bar.a(ibinder);
    }

    public final ayg a(String s)
    {
        Object obj = new LinkedBlockingQueue();
        s = new bag(this, s, ((LinkedBlockingQueue) (obj)));
        bah bah1 = new bah(this, ((LinkedBlockingQueue) (obj)));
        super.c.a(new axl(s));
        super.c.a(bah1);
        a();
        try
        {
            obj = (ayg)((LinkedBlockingQueue) (obj)).poll(30000L, TimeUnit.MILLISECONDS);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return new bai(s.toString());
        }
        s = ((String) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        s = new bai("Timeout: 30000ms.");
        return s;
    }

    protected final void a(aya aya1, axm axm)
    {
        aya1.h(axm, 0x5e3530, super.a.getPackageName(), new Bundle());
    }

    protected final String e()
    {
        return "com.google.android.gms.droidguard.service.START";
    }

    protected final String f()
    {
        return "com.google.android.gms.droidguard.internal.IDroidGuardService";
    }
}
