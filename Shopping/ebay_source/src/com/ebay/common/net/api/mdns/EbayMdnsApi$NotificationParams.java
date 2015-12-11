// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.mdns;

import com.ebay.common.model.mdns.DeviceHandle;
import com.ebay.nautilus.domain.EbaySite;
import java.util.ArrayList;

// Referenced classes of package com.ebay.common.net.api.mdns:
//            EbayMdnsApi

public static final class A
{

    public String clientId;
    public String deviceType;
    public String iafToken;
    public String language;
    public String metaCategories;
    public ArrayList prefs;
    public String quietTimeStart;
    public String quietTimeStop;
    public String registrationId;
    public EbaySite site;
    public String userId;

    public DeviceHandle getDeviceHandle()
    {
        return new DeviceHandle(registrationId, deviceType, clientId);
    }

    public A()
    {
    }
}
