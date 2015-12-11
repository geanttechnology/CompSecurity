// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.mdns;

import com.ebay.common.model.mdns.DeviceHandle;
import com.ebay.nautilus.domain.EbaySite;
import org.xmlpull.v1.XmlSerializer;

public final class DeactivateUserOnDeviceRequest extends EbayMdnsApi.MdnsRequest
{

    private static final String OPERATION_NAME = "deactivateUserOnDevice";

    protected DeactivateUserOnDeviceRequest(String s, String s1, String s2, String s3, DeviceHandle devicehandle, EbaySite ebaysite)
    {
        super("deactivateUserOnDevice", s, s1, s2, s3, devicehandle, ebaysite);
    }

    protected void buildSpecificXmlRequest(XmlSerializer xmlserializer)
    {
    }
}
