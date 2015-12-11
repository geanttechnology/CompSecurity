// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            KiangApplicationInformation, KiangApplicationInstanceInformation, KiangPushInformation

public class KiangRegisterRequest
{

    private KiangApplicationInformation applicationInformation;
    private KiangApplicationInstanceInformation applicationInstanceInformation;
    private KiangPushInformation pushInformation;

    public KiangRegisterRequest()
    {
    }

    public KiangApplicationInformation getApplicationInformation()
    {
        return applicationInformation;
    }

    public KiangApplicationInstanceInformation getApplicationInstanceInformation()
    {
        return applicationInstanceInformation;
    }

    public KiangPushInformation getPushInformation()
    {
        return pushInformation;
    }

    public void setApplicationInformation(KiangApplicationInformation kiangapplicationinformation)
    {
        applicationInformation = kiangapplicationinformation;
    }

    public void setApplicationInstanceInformation(KiangApplicationInstanceInformation kiangapplicationinstanceinformation)
    {
        applicationInstanceInformation = kiangapplicationinstanceinformation;
    }

    public void setPushInformation(KiangPushInformation kiangpushinformation)
    {
        pushInformation = kiangpushinformation;
    }
}
