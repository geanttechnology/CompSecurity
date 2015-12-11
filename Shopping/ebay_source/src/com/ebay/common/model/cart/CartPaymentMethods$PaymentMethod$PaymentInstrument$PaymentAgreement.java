// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import com.ebay.nautilus.domain.data.NamedParameter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.common.model.cart:
//            CartPaymentMethods, ActionUrl

public static class AcceptanceDetails
    implements Serializable
{
    public static class AcceptanceDetails
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


        public AcceptanceDetails()
        {
        }
    }


    private static final long serialVersionUID = 1L;
    private AcceptanceDetails acceptanceDetails;
    private String acceptanceStatus;
    private boolean recurring;
    private String referenceNumber;
    private String type;

    public String getSepaButtonText()
    {
label0:
        {
            if (acceptanceDetails.actionUrls == null)
            {
                break label0;
            }
            Iterator iterator = acceptanceDetails.actionUrls.iterator();
            ActionUrl actionurl;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                actionurl = (ActionUrl)iterator.next();
            } while (!"PaymentAgreementMandate".equals(actionurl.action));
            return actionurl.urlText;
        }
        return null;
    }

    public String getSepaMandateUrl()
    {
label0:
        {
            if (acceptanceDetails.actionUrls == null)
            {
                break label0;
            }
            Iterator iterator = acceptanceDetails.actionUrls.iterator();
            ActionUrl actionurl;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                actionurl = (ActionUrl)iterator.next();
            } while (!"PaymentAgreementMandate".equals(actionurl.action));
            return actionurl.value;
        }
        return null;
    }

    public String getSepaText()
    {
        if (acceptanceDetails != null)
        {
            return acceptanceDetails.getAttribute("PLAIN");
        } else
        {
            return null;
        }
    }

    public boolean isAccepted()
    {
        return "ACCEPTED".equals(acceptanceStatus);
    }

    public AcceptanceDetails()
    {
    }
}
