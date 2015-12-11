// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.custom;

import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVDocumentVariant;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class NetverifyCountry
{

    private Map documentTypes;
    private String isoCode;

    public NetverifyCountry(String s, Map map)
    {
        isoCode = s;
        documentTypes = map;
    }

    public final Set getDocumentTypes()
    {
        return documentTypes.keySet();
    }

    public final Set getDocumentVariants(NVDocumentType nvdocumenttype)
    {
        HashSet hashset = new HashSet();
        hashset.add(NVDocumentVariant.PLASTIC);
        if (((Boolean)documentTypes.get(nvdocumenttype)).booleanValue())
        {
            hashset.add(NVDocumentVariant.PAPER);
        }
        return hashset;
    }

    public final String getIsoCode()
    {
        return isoCode;
    }
}
