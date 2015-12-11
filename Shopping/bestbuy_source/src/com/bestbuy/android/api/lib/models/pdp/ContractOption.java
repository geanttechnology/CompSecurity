// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import gu;
import java.io.Serializable;

public class ContractOption
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String contractConditionCode;
    private String format;
    private String learnMoreLink;
    private String price;
    private String productId;
    private String sku;
    private String type;

    public ContractOption()
    {
    }

    public String getContractConditionCode()
    {
        return contractConditionCode;
    }

    public String getFormat()
    {
        return format;
    }

    public String getLearnMoreLink()
    {
        return learnMoreLink;
    }

    public String getPrice()
    {
        return price;
    }

    public String getProductId()
    {
        return productId;
    }

    public String getSku()
    {
        return sku;
    }

    public String getType()
    {
        return type;
    }

    public void setContractConditionCode(String s)
    {
        contractConditionCode = s;
    }

    public void setFormat(String s)
    {
        format = s;
    }

    public void setLearnMoreLink(String s)
    {
        learnMoreLink = s;
    }

    public void setPrice(String s)
    {
        price = s;
    }

    public void setProductId(String s)
    {
        productId = s;
    }

    public void setSku(String s)
    {
        sku = s;
    }

    public void setType(String s)
    {
        type = s;
    }
}
