// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.downloads;

import java.util.Date;
import java.util.List;

public class TitaniumTicket
{

    private Date assetExpirationDate;
    private String key;
    private Date licenseExpirationDate;
    private boolean persistent;
    private String releasePid;
    private String signature;
    private String signatureKey;
    private List signedFields;
    private Date timestamp;

    public TitaniumTicket()
    {
    }

    public Date getAssetExpirationDate()
    {
        return assetExpirationDate;
    }

    public String getKey()
    {
        return key;
    }

    public Date getLicenseExpirationDate()
    {
        return licenseExpirationDate;
    }

    public String getReleasePid()
    {
        return releasePid;
    }

    public String getSignature()
    {
        return signature;
    }

    public String getSignatureKey()
    {
        return signatureKey;
    }

    public List getSignedFields()
    {
        return signedFields;
    }

    public Date getTimestamp()
    {
        return timestamp;
    }

    public boolean isPersistent()
    {
        return persistent;
    }
}
