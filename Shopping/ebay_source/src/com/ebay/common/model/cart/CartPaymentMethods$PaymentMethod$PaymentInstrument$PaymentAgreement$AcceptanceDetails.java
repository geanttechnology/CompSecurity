// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import com.ebay.nautilus.domain.data.NamedParameter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.common.model.cart:
//            CartPaymentMethods

public static class 
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private List actionUrls;
    private String legalText;
    private transient Map legalTextComponentMap;
    private List legalTextComponents;

    public String getAttribute(String s)
    {
        return (String)getAttributeMap().get(s);
    }

    public Map getAttributeMap()
    {
        if (legalTextComponentMap == null)
        {
            legalTextComponentMap = new HashMap();
            if (legalTextComponents != null)
            {
                NamedParameter.addParameterListToMap(legalTextComponents, legalTextComponentMap);
            }
        }
        return legalTextComponentMap;
    }


    public ()
    {
    }
}
