// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.event;

import android.os.Bundle;

public class PushReceivedEvent
{

    private Bundle payload;

    public PushReceivedEvent(Bundle bundle)
    {
        payload = bundle;
    }

    public Bundle getPayload()
    {
        return payload;
    }

    public void setPayload(Bundle bundle)
    {
        payload = bundle;
    }
}
