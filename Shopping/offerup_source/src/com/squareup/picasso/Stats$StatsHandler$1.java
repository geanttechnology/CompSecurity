// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.os.Message;

class val.msg
    implements Runnable
{

    final val.msg this$0;
    final Message val$msg;

    public void run()
    {
        throw new AssertionError((new StringBuilder("Unhandled stats message.")).append(val$msg.what).toString());
    }

    ()
    {
        this$0 = final_;
        val$msg = Message.this;
        super();
    }
}
