// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.omniata.android.sdk;


class entStatus
{

    static final int $SwitchMap$com$omniata$android$sdk$OmniataEventWorker$EventStatus[];

    static 
    {
        $SwitchMap$com$omniata$android$sdk$OmniataEventWorker$EventStatus = new int[entStatus.values().length];
        try
        {
            $SwitchMap$com$omniata$android$sdk$OmniataEventWorker$EventStatus[entStatus.RETRY.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$omniata$android$sdk$OmniataEventWorker$EventStatus[entStatus.SUCCESS.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$omniata$android$sdk$OmniataEventWorker$EventStatus[entStatus.DISCARD.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
