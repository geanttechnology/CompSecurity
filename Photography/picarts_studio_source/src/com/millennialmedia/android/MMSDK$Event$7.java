// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            MMAdImpl, RequestListener, MMLog, MMException

final class b
    implements Runnable
{

    private MMAdImpl a;
    private MMException b;

    public final void run()
    {
        if (a == null || a.b == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        a.b.requestFailed(a.d(), b);
        return;
        Exception exception;
        exception;
        MMLog.a("MMSDK", "Exception raised in your RequestListener: ", exception);
        return;
    }

    r(MMAdImpl mmadimpl, MMException mmexception)
    {
        a = mmadimpl;
        b = mmexception;
        super();
    }
}
