// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import java.lang.ref.WeakReference;

class val.rtncontent
    implements Runnable
{

    final val.rtncontent this$1;
    final String val$rtncontent;

    public void run()
    {
        if (callbackWeakRef.get() == null)
        {
            return;
        }
        if (val$rtncontent == null)
        {
            Error error = new Error("error");
            ((estCallback)callbackWeakRef.get()).onRequestError(error);
            return;
        } else
        {
            ((estCallback)callbackWeakRef.get()).onRequestSuccess(val$rtncontent);
            return;
        }
    }

    estCallback()
    {
        this$1 = final_estcallback;
        val$rtncontent = String.this;
        super();
    }
}
