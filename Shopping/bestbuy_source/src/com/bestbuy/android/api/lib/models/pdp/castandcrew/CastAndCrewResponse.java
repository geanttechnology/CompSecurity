// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.castandcrew;

import com.bestbuy.android.api.lib.models.home.Names;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Properties;
import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdp.castandcrew:
//            CastAndCrew

public class CastAndCrewResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private CastAndCrew castAndCrew;
    private Names names;
    private String productType;
    private Properties properties;
    private String skuId;

    public CastAndCrewResponse()
    {
    }

    public CastAndCrew getCastAndCrew()
    {
        return castAndCrew;
    }

    public Names getNames()
    {
        return names;
    }

    public String getProductType()
    {
        return productType;
    }

    public Properties getProperties()
    {
        return properties;
    }

    public String getSkuid()
    {
        return skuId;
    }

    public void setCastAndCrew(CastAndCrew castandcrew)
    {
        castAndCrew = castandcrew;
    }

    public void setNames(Names names1)
    {
        names = names1;
    }

    public void setProductType(String s)
    {
        productType = s;
    }

    public void setProperties(Properties properties1)
    {
        properties = properties1;
    }

    public void setSkuid(String s)
    {
        skuId = s;
    }
}
