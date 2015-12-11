// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.msgpack.Packer;

public class MobileDeviceHeader
{

    public String appVersion;
    public String bcookie;
    public String clientID;
    public String consumerId;
    public String countryCode;
    public String deviceID;
    public String idfa;
    public String locale;
    public String macAddress;
    public String platform;
    public String userAgent;
    public String userPermalink;

    public MobileDeviceHeader()
    {
    }

    public void pack(Packer packer)
        throws IOException
    {
        packer.packArray(12);
        packer.pack(platform);
        packer.pack(appVersion);
        packer.pack(clientID);
        packer.pack(deviceID);
        packer.pack(bcookie);
        packer.pack(userAgent);
        packer.pack(locale);
        packer.pack(countryCode);
        packer.pack(userPermalink);
        packer.pack(idfa);
        packer.pack(macAddress);
        packer.pack(consumerId);
    }

    public final byte[] pack()
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        pack(new Packer(bytearrayoutputstream));
        return bytearrayoutputstream.toByteArray();
    }
}
