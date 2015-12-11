// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.techsupport;

import com.bestbuy.android.api.lib.models.home.Names;
import com.bestbuy.android.api.lib.models.pdp.Requirement;
import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdp.techsupport:
//            Rights

public class TechSupportDetails
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private Names names;
    private String productType;
    private Requirement requirements;
    private Rights rights;
    private String skuId;

    public TechSupportDetails()
    {
    }

    public Names getNames()
    {
        return names;
    }

    public String getProductType()
    {
        return productType;
    }

    public Requirement getRequirements()
    {
        return requirements;
    }

    public Rights getRights()
    {
        return rights;
    }

    public String getSkuId()
    {
        return skuId;
    }

    public void setNames(Names names1)
    {
        names = names1;
    }

    public void setProductType(String s)
    {
        productType = s;
    }

    public void setRequirements(Requirement requirement)
    {
        requirements = requirement;
    }

    public void setRights(Rights rights1)
    {
        rights = rights1;
    }

    public void setSkuId(String s)
    {
        skuId = s;
    }
}
