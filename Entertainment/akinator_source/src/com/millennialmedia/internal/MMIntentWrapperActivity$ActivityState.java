// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.content.Intent;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.millennialmedia.internal:
//            MMIntentWrapperActivity

private static class rListener
{

    rListener intentWrapperListener;
    CountDownLatch onCreateLatch;
    Intent wrappedIntent;

    private rListener(rListener rlistener, Intent intent)
    {
        onCreateLatch = new CountDownLatch(1);
        intentWrapperListener = rlistener;
        wrappedIntent = intent;
    }

    rListener(rListener rlistener, Intent intent, rListener rlistener1)
    {
        this(rlistener, intent);
    }
}
