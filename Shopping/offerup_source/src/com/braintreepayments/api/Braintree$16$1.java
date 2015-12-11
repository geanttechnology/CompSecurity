// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api;


class Listener
    implements Runnable
{

    final l.throwable this$1;
    final Listener val$listener;

    public void run()
    {
        val$listener.onUnrecoverableError(throwable);
    }

    Listener()
    {
        this$1 = final_listener1;
        val$listener = Listener.this;
        super();
    }
}
