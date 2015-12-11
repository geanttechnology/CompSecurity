// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            KiangApplicationState, KiangSecurity

public class KiangUpdateRequest
{

    private KiangApplicationState applicationState;
    private KiangSecurity security;

    public KiangUpdateRequest()
    {
    }

    public KiangApplicationState getApplicationState()
    {
        return applicationState;
    }

    public KiangSecurity getSecurity()
    {
        return security;
    }

    public void setApplicationState(KiangApplicationState kiangapplicationstate)
    {
        applicationState = kiangapplicationstate;
    }

    public void setSecurity(KiangSecurity kiangsecurity)
    {
        security = kiangsecurity;
    }
}
