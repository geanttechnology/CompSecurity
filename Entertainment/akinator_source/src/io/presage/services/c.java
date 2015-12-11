// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package io.presage.services:
//            AbstractPresageService

final class c extends Handler
{

    final AbstractPresageService a;

    c(AbstractPresageService abstractpresageservice, Looper looper)
    {
        a = abstractpresageservice;
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        AbstractPresageService.d(a);
        a.d = false;
    }
}
