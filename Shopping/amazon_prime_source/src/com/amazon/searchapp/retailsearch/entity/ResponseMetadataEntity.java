// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.ResponseMetadata;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class ResponseMetadataEntity extends RetailSearchEntity
    implements ResponseMetadata
{

    private String dataVersion;

    public ResponseMetadataEntity()
    {
    }

    public String getDataVersion()
    {
        return dataVersion;
    }

    public void setDataVersion(String s)
    {
        dataVersion = s;
    }
}
