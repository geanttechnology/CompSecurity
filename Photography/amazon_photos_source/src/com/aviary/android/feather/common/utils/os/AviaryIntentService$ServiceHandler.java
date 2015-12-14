// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.utils.os;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.aviary.android.feather.common.utils.os:
//            AviaryIntentService

private final class this._cls0 extends Handler
{

    final AviaryIntentService this$0;

    public void handleMessage(Message message)
    {
        onHandleIntent((Intent)message.obj);
        stopSelf(message.arg1);
    }

    public (Looper looper)
    {
        this$0 = AviaryIntentService.this;
        super(looper);
    }
}
