// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Executor;

// Referenced classes of package com.urbanairship:
//            ChannelCapture

class <init> extends BroadcastReceiver
{

    final ChannelCapture this$0;

    public void onReceive(Context context, Intent intent)
    {
        class _cls1
            implements Runnable
        {

            final ChannelCapture._cls1 this$1;

            public void run()
            {
                ChannelCapture.access$000(this$0);
            }

            _cls1()
            {
                this$1 = ChannelCapture._cls1.this;
                super();
            }
        }

        executor.execute(new _cls1());
    }

    _cls1()
    {
        this$0 = ChannelCapture.this;
        super();
    }
}
