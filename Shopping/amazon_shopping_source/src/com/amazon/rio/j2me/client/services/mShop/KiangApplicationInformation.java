// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            KiangDeviceUniqueId

public class KiangApplicationInformation
{

    private String applicationIdentifier;
    private String applicationVersion;
    private String associateTag;
    private KiangDeviceUniqueId deviceUniqueId;
    private String hardwareIdentifier;
    private String osIdentifier;
    private String osVersion;
    private String ubid;

    public KiangApplicationInformation()
    {
    }

    public String getApplicationIdentifier()
    {
        return applicationIdentifier;
    }

    public String getApplicationVersion()
    {
        return applicationVersion;
    }

    public String getAssociateTag()
    {
        return associateTag;
    }

    public KiangDeviceUniqueId getDeviceUniqueId()
    {
        return deviceUniqueId;
    }

    public String getHardwareIdentifier()
    {
        return hardwareIdentifier;
    }

    public String getOsIdentifier()
    {
        return osIdentifier;
    }

    public String getOsVersion()
    {
        return osVersion;
    }

    public String getUbid()
    {
        return ubid;
    }

    public void setApplicationIdentifier(String s)
    {
        applicationIdentifier = s;
    }

    public void setApplicationVersion(String s)
    {
        applicationVersion = s;
    }

    public void setAssociateTag(String s)
    {
        associateTag = s;
    }

    public void setDeviceUniqueId(KiangDeviceUniqueId kiangdeviceuniqueid)
    {
        deviceUniqueId = kiangdeviceuniqueid;
    }

    public void setHardwareIdentifier(String s)
    {
        hardwareIdentifier = s;
    }

    public void setOsIdentifier(String s)
    {
        osIdentifier = s;
    }

    public void setOsVersion(String s)
    {
        osVersion = s;
    }

    public void setUbid(String s)
    {
        ubid = s;
    }
}
