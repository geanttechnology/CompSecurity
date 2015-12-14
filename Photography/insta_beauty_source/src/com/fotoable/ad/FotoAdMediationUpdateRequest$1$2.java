// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;


class val.error
    implements Runnable
{

    final val.error this$1;
    final Error val$error;

    public void run()
    {
        callback.onRequestError(val$error);
    }

    estCallback()
    {
        this$1 = final_estcallback;
        val$error = Error.this;
        super();
    }
}
