// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            an, ab, at, al, 
//            ag

static final class b
    implements Runnable
{

    final ab a;
    final ag b;

    public final void run()
    {
        if (a == null || a.c == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        a.c.requestFailed(a.d(), b);
        return;
        Exception exception;
        exception;
        al.a("MMSDK", "Exception raised in your RequestListener: ", exception);
        return;
    }

    (ab ab1, ag ag)
    {
        a = ab1;
        b = ag;
        super();
    }
}
