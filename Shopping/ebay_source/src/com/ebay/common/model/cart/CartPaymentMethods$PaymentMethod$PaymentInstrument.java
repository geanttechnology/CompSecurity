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
//            CartPaymentMethods, ActionUrl

public static class StrategyComponent
    implements Serializable
{
    public static class FundingStrategy
        implements Serializable
    {

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
                    StrategyComponent strategycomponent = (StrategyComponent)iterator.next();
                    if (strategycomponent != null)
                    {
                        StrategyChoice.FundingSource fundingsource = strategycomponent.getFundingSource();
                        if (fundingsource != null && !"INCENTIVE".equals(fundingsource.getType()))
                        {
                            arraylist.add(strategycomponent);
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


        public FundingStrategy()
        {
        }
    }

    public static class FundingStrategy.StrategyChoice
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

        public FundingStrategy.StrategyChoice()
        {
        }
    }

    public static class FundingStrategy.StrategyChoice.FundingSource
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
        FundingStrategy.StrategyChoice.FundingSource backupSource;
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

        public FundingStrategy.StrategyChoice.FundingSource getBackupSource()
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

        public FundingStrategy.StrategyChoice.FundingSource()
        {
        }
    }

    public static class FundingStrategy.StrategyChoice.FundingSource.CurrencyConversionInfo
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public CurrencyAmount basis;
        public Date conversionDate;
        public CurrencyAmount converted;
        private String exchangeRateProvider;

        public FundingStrategy.StrategyChoice.FundingSource.CurrencyConversionInfo()
        {
        }
    }

    public static class PaymentAgreement
        implements Serializable
    {

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

        public PaymentAgreement()
        {
        }
    }

    public static class PaymentAgreement.AcceptanceDetails
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


        public PaymentAgreement.AcceptanceDetails()
        {
        }
    }

    public static class PaymentInstrumentRefId
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        private String key;
        private String owner;

        public String getKey()
        {
            return key;
        }


        public PaymentInstrumentRefId()
        {
        }
    }

    public static class StrategyComponent extends FundingStrategy.StrategyChoice
    {

        private static final long serialVersionUID = 1L;

        public StrategyComponent()
        {
        }
    }


    private static final String BANK_BBAN_LAST_FOUR_DIGITS = "Bank_Bban_AccountNumberLastFour";
    private static final String BANK_IBAN_LAST_FOUR_DIGITS = "Bank_Iban_AccountNumberLastFour";
    private static final String CREDIT_CARD_LAST_FOUR_DIGITS = "CreditCard_CardNumberLastFour";
    private static final String CREDIT_CARD_TYPE = "CreditCard_Type";
    private static final String IS_WALLET_INSTRUMENT = "IsWalletInstrument";
    private static final String PAYPAL_ACCOUNT = "PayPal_AccountHolder";
    private static final String TYPE = "PaymentInstrumentType";
    public static final String TYPE_CREDIT_CARD = "CREDIT_CARD";
    public static final String TYPE_DIRECT_DEBIT = "BANK_ACCOUNT";
    public static final String TYPE_PAYPAL = "PAYPAL_ACCOUNT";
    private static final long serialVersionUID = 1L;
    private transient Map attributeMap;
    private List attributes;
    private List fundingStrategyList;
    private PaymentAgreement paymentAgreement;
    private PaymentInstrumentRefId paymentInstrumentRefId;
    private boolean selected;
    private boolean shouldRememberPaymentInstrument;

    private String getAttribute(String s)
    {
        return (String)getAttributeMap().get(s);
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

    public String getBankLastFourDigits()
    {
        String s = null;
        if ("BANK_ACCOUNT".equals(getAttribute("PaymentInstrumentType")))
        {
            s = getAttribute("Bank_Iban_AccountNumberLastFour");
        }
        if (s != null)
        {
            return s;
        } else
        {
            return getAttribute("Bank_Bban_AccountNumberLastFour");
        }
    }

    public String getCreditCardLastFourDigits()
    {
        if ("CREDIT_CARD".equals(getAttribute("PaymentInstrumentType")))
        {
            return getAttribute("CreditCard_CardNumberLastFour");
        } else
        {
            return null;
        }
    }

    public com.ebay.nautilus.domain.data.Attribute getCreditCardType()
    {
        if (!"CREDIT_CARD".equals(getAttribute("PaymentInstrumentType")))
        {
            return com.ebay.nautilus.domain.data.Attribute;
        }
        String s = getAttribute("CreditCard_Type");
        if (s != null)
        {
            if ("Visa".equals(s))
            {
                return com.ebay.nautilus.domain.data.Attribute;
            }
            if ("MasterCard".equals(s))
            {
                return com.ebay.nautilus.domain.data.Attribute;
            }
            if ("Discover".equals(s))
            {
                return com.ebay.nautilus.domain.data.Attribute;
            }
            if ("American Express".equals(s))
            {
                return com.ebay.nautilus.domain.data.Attribute;
            }
        }
        return com.ebay.nautilus.domain.data.Attribute;
    }

    public String getFundingStrategyChoiceId()
    {
        Object obj = getSelectedFundingStrategy();
        if (obj != null)
        {
            obj = ((FundingStrategy) (obj)).getSelectedStrategyChoice();
            if (obj != null)
            {
                return ((FundingStrategy.StrategyChoice) (obj)).getStrategyChoiceId();
            }
        }
        return null;
    }

    public String getPayPalAccount()
    {
        if ("PAYPAL_ACCOUNT".equals(getAttribute("PaymentInstrumentType")))
        {
            return getAttribute("PayPal_AccountHolder");
        } else
        {
            return null;
        }
    }

    public String getPaymentInstrumentRefId()
    {
        if (paymentInstrumentRefId != null)
        {
            return paymentInstrumentRefId.key;
        } else
        {
            return null;
        }
    }

    public FundingStrategy getSelectedFundingStrategy()
    {
        if (fundingStrategyList == null)
        {
            return null;
        }
        for (Iterator iterator = fundingStrategyList.iterator(); iterator.hasNext();)
        {
            FundingStrategy fundingstrategy = (FundingStrategy)iterator.next();
            if (fundingstrategy.isSelected())
            {
                return fundingstrategy;
            }
        }

        return null;
    }

    public String getType()
    {
        return getAttribute("PaymentInstrumentType");
    }

    public boolean isSelected()
    {
        return selected;
    }

    public boolean shouldRememeber()
    {
        return shouldRememberPaymentInstrument;
    }


    public StrategyComponent()
    {
    }
}
