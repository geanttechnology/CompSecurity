// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.NamedParameter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.common.model.cart:
//            CartPaymentMethods

public static class StrategyChoice
    implements Serializable
{
    public static class StrategyChoice
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        private FundingSource fundingSource;
        private String fundingStrategyChoiceId;
        private boolean selected;

        public FundingSource getFundingSource()
        {
            return fundingSource;
        }

        public String getStrategyChoiceId()
        {
            return fundingStrategyChoiceId;
        }

        public boolean isSelected()
        {
            return selected;
        }

        public StrategyChoice()
        {
        }
    }

    public static class StrategyChoice.FundingSource
        implements Serializable
    {

        private static final String INCENTIVE_CODE = "IncentiveCode";
        private static final String INCENTIVE_TYPE = "IncentiveType";
        private static final String MASK = "MaskedIdentifier";
        private static final String MODE = "FundingMode";
        public static final String MODE_INSTANT = "INSTANT_TRANSFER";
        public static final String MODE_MANUAL_TRANSFER = "MANUAL_BANK_TRANSFER";
        private static final String SUBTYPE = "FundingSourceSubType";
        public static final String SUBTYPE_AMEX = "AMEX";
        public static final String SUBTYPE_DINERS = "DINERS";
        public static final String SUBTYPE_DISCOVER = "DISCOVER";
        public static final String SUBTYPE_MASTERCARD = "MASTERCARD";
        public static final String SUBTYPE_VISA = "VISA";
        private static final String TYPE = "FundingSourceType";
        public static final String TYPE_BALANCE = "BALANCE";
        public static final String TYPE_BANK = "BANK_ACCOUNT";
        public static final String TYPE_CARD = "PAYMENT_CARD";
        public static final String TYPE_CREDIT = "CREDIT";
        public static final String TYPE_INCENTIVE = "INCENTIVE";
        private static final long serialVersionUID = 1L;
        private CurrencyAmount amount;
        private transient Map attributeMap;
        private List attributes;
        StrategyChoice.FundingSource backupSource;
        public CurrencyConversionInfo conversionInfo;

        private String getAttribute(String s)
        {
            return (String)getAttributeMap().get(s);
        }

        public CurrencyAmount getAmount()
        {
            return amount;
        }

        public Map getAttributeMap()
        {
            if (attributeMap == null)
            {
                attributeMap = new HashMap();
                if (attributes != null)
                {
                    NamedParameter.addParameterListToMap(attributes, attributeMap);
                }
            }
            return attributeMap;
        }

        public StrategyChoice.FundingSource getBackupSource()
        {
            return backupSource;
        }

        public String getMaskedId()
        {
            return getAttribute("MaskedIdentifier");
        }

        public String getMode()
        {
            return getAttribute("FundingMode");
        }

        public String getSubtype()
        {
            if ("INCENTIVE".equals(getType()))
            {
                return getAttribute("IncentiveType");
            } else
            {
                return getAttribute("FundingSourceSubType");
            }
        }

        public String getType()
        {
            return getAttribute("FundingSourceType");
        }

        public boolean hasBackupSource()
        {
            return backupSource != null;
        }

        public StrategyChoice.FundingSource()
        {
        }
    }

    public static class StrategyChoice.FundingSource.CurrencyConversionInfo
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public CurrencyAmount basis;
        public Date conversionDate;
        public CurrencyAmount converted;
        private String exchangeRateProvider;

        public StrategyChoice.FundingSource.CurrencyConversionInfo()
        {
        }
    }


    private static final long serialVersionUID = 1L;
    private List fixedStrategyComponents;
    private boolean selected;
    private List strategyChoices;

    private List getFixedComponents()
    {
        ArrayList arraylist = new ArrayList();
        if (fixedStrategyComponents != null)
        {
            Iterator iterator = fixedStrategyComponents.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                t t = (t)iterator.next();
                if (t != null)
                {
                    StrategyChoice.FundingSource fundingsource = t.getFundingSource();
                    if (fundingsource != null && !"INCENTIVE".equals(fundingsource.getType()))
                    {
                        arraylist.add(t);
                    }
                }
            } while (true);
        }
        return arraylist;
    }

    public StrategyChoice getSelectedStrategyChoice()
    {
        if (strategyChoices == null)
        {
            return null;
        }
        for (Iterator iterator = strategyChoices.iterator(); iterator.hasNext();)
        {
            StrategyChoice strategychoice = (StrategyChoice)iterator.next();
            if (strategychoice.isSelected())
            {
                return strategychoice;
            }
        }

        return null;
    }

    public int getStrategyChoiceCount()
    {
        if (strategyChoices != null)
        {
            return strategyChoices.size();
        } else
        {
            return 0;
        }
    }

    public List getStrategyChoices()
    {
        return strategyChoices;
    }

    public boolean isSelected()
    {
        return selected;
    }


    public StrategyChoice()
    {
    }
}
