// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Intent;
import java.util.concurrent.Semaphore;

// Referenced classes of package com.parse:
//            PushRouter

static final class 
    implements Runnable
{

    final Semaphore val$done;
    final Intent val$intent;

    public void run()
    {
        PushRouter.access$000().handleGcmPush(val$intent);
        val$done.release();
    }

    maphore(Intent intent1, Semaphore semaphore)
    {
        val$intent = intent1;
        val$done = semaphore;
        super();
    }
}
