// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpmusic;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdpmusic:
//            MusicDetails, MusicNames

public class MusicResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private MusicDetails musicDetails;
    private MusicNames names;
    private String productType;
    private String skuId;

    public MusicResponse()
    {
    }

    public MusicDetails getMusicDetails()
    {
        return musicDetails;
    }

    public MusicNames getNames()
    {
        return names;
    }

    public String getProductType()
    {
        return productType;
    }

    public String getSkuId()
    {
        return skuId;
    }

    public void setMusicDetails(MusicDetails musicdetails)
    {
        musicDetails = musicdetails;
    }

    public void setNames(MusicNames musicnames)
    {
        names = musicnames;
    }

    public void setProductType(String s)
    {
        productType = s;
    }

    public void setSkuId(String s)
    {
        skuId = s;
    }
}
