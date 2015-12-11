// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.helpshift:
//            l

class  extends Handler
{

    final l a;

    public void handleMessage(Message message)
    {
        a.v();
        message = new Intent("com.helpshift.failedMessageRequest");
        l.c(a).sendBroadcast(message);
    }

    (l l1)
    {
        a = l1;
        super();
    }
}
