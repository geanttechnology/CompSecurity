// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package io.presage.services:
//            AbstractPresageService

private final class a extends Handler
{

    final AbstractPresageService a;

    public final void handleMessage(Message message)
    {
        AbstractPresageService abstractpresageservice = a;
        message = ((Message) (message.obj));
        abstractpresageservice.d();
    }

    public (AbstractPresageService abstractpresageservice, Looper looper)
    {
        a = abstractpresageservice;
        super(looper);
    }
}
