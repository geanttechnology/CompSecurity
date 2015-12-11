// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            StartUpWaiter, AmazonOOAdRegistration, AmazonOOAdRegistrationListener

private static class listener extends StartUpWaiter
{

    private final AmazonOOAdRegistrationListener listener;

    protected void startUpFailed()
    {
        listener.onRegistrationInfoReady(Info.getAmazonOOAdRegistrationInfo());
    }

    protected void startUpReady()
    {
        listener.onRegistrationInfoReady(Info.getAmazonOOAdRegistrationInfo());
    }

    public Info(AmazonOOAdRegistrationListener amazonooadregistrationlistener)
    {
        listener = amazonooadregistrationlistener;
    }
}
