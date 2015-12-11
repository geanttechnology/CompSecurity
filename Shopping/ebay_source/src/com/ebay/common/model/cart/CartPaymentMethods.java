// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.NamedParameter;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.common.model.cart:
//            ActionUrl, PaymentInstruction

public class CartPaymentMethods extends BaseDataMapped
    implements Parcelable, Serializable
{
    public static class PaymentMethod
        implements Serializable
    {

        public static final String CASH_ON_PICKUP = "CashOnPickup";
        public static final String CREDIT_CARD = "CreditCard";
        public static final String DIRECT_DEBIT = "DirectDebit";
        public static final String MONEY_XFER_ACCEPTED_IN_CHECKOUT = "MoneyXferAcceptedInCheckout";
        public static final String PAYPAL = "PayPal";
        public static final String PAY_UPON_INVOICE = "PayUponInvoice";
        private static final String PLACE_HOLDER_LDP_DISPLAY = "\\{idpDisplay\\}";
        private static final String PLACE_HOLDER_RETURN_URL = "\\{ru\\}";
        private static final String PLACE_HOLDER_RETURN_URL_ALT = "\\{redirect_uri\\}";
        private static final String PROX_LDP_DISPLAY_VALUE = "3";
        public static final String PROX_RETURN_URL = "http://prox.ebay.com/";
        private static final long serialVersionUID = 1L;
        private List actionUrls;
        private boolean applicable;
        private transient Map attributeMap;
        private List attributes;
        private boolean isRecommendedSelection;
        private String name;
        private PaymentInstrument.PaymentAgreement paymentAgreement;
        private List paymentInstruction;
        private PaymentInstrument paymentInstrument;
        private boolean selected;

        private PaymentInstrument.FundingStrategy getSelectedFundingStrategy()
        {
            PaymentInstrument paymentinstrument;
            if (isPayPal())
            {
                if ((paymentinstrument = getPaymentInstrument()) != null)
                {
                    return paymentinstrument.getSelectedFundingStrategy();
                }
            }
            return null;
        }

        public static String substitutePlaceHolders(ActionUrl actionurl)
        {
            if (actionurl.value == null)
            {
                break MISSING_BLOCK_LABEL_46;
            }
            String s = URLEncoder.encode("http://prox.ebay.com/", "UTF-8");
            actionurl = actionurl.value.replaceAll("\\{idpDisplay\\}", "3").replaceAll("\\{ru\\}", s).replaceAll("\\{redirect_uri\\}", s);
            return actionurl;
            actionurl;
            actionurl.printStackTrace();
            return null;
        }

        public String getActionUrlForAction(String s)
        {
label0:
            {
                if (actionUrls == null)
                {
                    break label0;
                }
                Iterator iterator = actionUrls.iterator();
                ActionUrl actionurl;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    actionurl = (ActionUrl)iterator.next();
                } while (!actionurl.action.equals(s));
                return substitutePlaceHolders(actionurl);
            }
            return null;
        }

        public String getAttribute(String s)
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

        public Calendar getDateOfBirth()
        {
            if (!isPui())
            {
                return null;
            }
            String s = getAttribute("DateOfBirth");
            if (s == null || s.length() == 0)
            {
                return null;
            }
            GregorianCalendar gregoriancalendar;
            try
            {
                gregoriancalendar = new GregorianCalendar();
                gregoriancalendar.setTime(EbayDateUtils.parseIso8601DateTime(s));
            }
            catch (ParseException parseexception)
            {
                return null;
            }
            return gregoriancalendar;
        }

        public List getFixedFundingComponents()
        {
            PaymentInstrument.FundingStrategy fundingstrategy = getSelectedFundingStrategy();
            if (fundingstrategy != null)
            {
                return fundingstrategy.getFixedComponents();
            } else
            {
                return Collections.emptyList();
            }
        }

        public String getName()
        {
            return name;
        }

        public PaymentInstrument.PaymentAgreement getPaymentAgreement()
        {
            PaymentInstrument paymentinstrument = getPaymentInstrument();
            if (paymentinstrument != null)
            {
                return paymentinstrument.paymentAgreement;
            } else
            {
                return null;
            }
        }

        public PaymentInstruction getPaymentInstruction()
        {
            if (paymentInstruction == null)
            {
                return null;
            } else
            {
                return (PaymentInstruction)paymentInstruction.get(0);
            }
        }

        public PaymentInstrument getPaymentInstrument()
        {
            return paymentInstrument;
        }

        public PaymentInstrument.FundingStrategy.StrategyChoice.FundingSource getSelectedFundingSource()
        {
            Object obj = getSelectedFundingStrategy();
            if (obj != null)
            {
                obj = ((PaymentInstrument.FundingStrategy) (obj)).getSelectedStrategyChoice();
                if (obj != null)
                {
                    return ((PaymentInstrument.FundingStrategy.StrategyChoice) (obj)).getFundingSource();
                }
            }
            return null;
        }

        public List getStrategyChoices()
        {
            PaymentInstrument.FundingStrategy fundingstrategy = getSelectedFundingStrategy();
            if (fundingstrategy != null)
            {
                return fundingstrategy.getStrategyChoices();
            } else
            {
                return null;
            }
        }

        public boolean hasSelectedFundingSource()
        {
            return getSelectedFundingSource() != null;
        }

        public boolean isApplicable()
        {
            return applicable;
        }

        public boolean isCashOnPickup()
        {
            return "CashOnPickup".equals(name);
        }

        public boolean isCreditCard()
        {
            return "CreditCard".equals(name);
        }

        public boolean isDirectDebit()
        {
            return "DirectDebit".equals(name);
        }

        public boolean isEft()
        {
            return "MoneyXferAcceptedInCheckout".equals(name);
        }

        public boolean isPayPal()
        {
            return "PayPal".equals(name);
        }

        public boolean isPui()
        {
            return "PayUponInvoice".equals(name);
        }

        public boolean isSelected()
        {
            return selected;
        }

        public boolean paidCompletelyByPayPalBalance()
        {
            PaymentInstrument.FundingStrategy fundingstrategy = getSelectedFundingStrategy();
            if (fundingstrategy != null && fundingstrategy.getStrategyChoiceCount() == 1)
            {
                PaymentInstrument.FundingStrategy.StrategyChoice.FundingSource fundingsource = getSelectedFundingSource();
                if (fundingsource != null)
                {
                    return "BALANCE".equals(fundingsource.getType());
                }
            }
            return false;
        }


/*
        static boolean access$002(PaymentMethod paymentmethod, boolean flag)
        {
            paymentmethod.selected = flag;
            return flag;
        }

*/

        public PaymentMethod()
        {
        }
    }

    public static class PaymentMethod.PaymentInstrument
        implements Serializable
    {

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

        public com.ebay.nautilus.domain.data.CreditCard.Type getCreditCardType()
        {
            if (!"CREDIT_CARD".equals(getAttribute("PaymentInstrumentType")))
            {
                return com.ebay.nautilus.domain.data.CreditCard.Type.UNKNOWN;
            }
            String s = getAttribute("CreditCard_Type");
            if (s != null)
            {
                if ("Visa".equals(s))
                {
                    return com.ebay.nautilus.domain.data.CreditCard.Type.VISA;
                }
                if ("MasterCard".equals(s))
                {
                    return com.ebay.nautilus.domain.data.CreditCard.Type.MASTERCARD;
                }
                if ("Discover".equals(s))
                {
                    return com.ebay.nautilus.domain.data.CreditCard.Type.DISCOVER;
                }
                if ("American Express".equals(s))
                {
                    return com.ebay.nautilus.domain.data.CreditCard.Type.AMERICANEXPRESS;
                }
            }
            return com.ebay.nautilus.domain.data.CreditCard.Type.UNKNOWN;
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


        public PaymentMethod.PaymentInstrument()
        {
        }
    }

    public static class PaymentMethod.PaymentInstrument.FundingStrategy
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
                    PaymentMethod.PaymentInstrument.StrategyComponent strategycomponent = (PaymentMethod.PaymentInstrument.StrategyComponent)iterator.next();
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


        public PaymentMethod.PaymentInstrument.FundingStrategy()
        {
        }
    }

    public static class PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice
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

        public PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice()
        {
        }
    }

    public static class PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice.FundingSource
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
        PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice.FundingSource backupSource;
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

        public PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice.FundingSource getBackupSource()
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

        public PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice.FundingSource()
        {
        }
    }

    public static class PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice.FundingSource.CurrencyConversionInfo
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public CurrencyAmount basis;
        public Date conversionDate;
        public CurrencyAmount converted;
        private String exchangeRateProvider;

        public PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice.FundingSource.CurrencyConversionInfo()
        {
        }
    }

    public static class PaymentMethod.PaymentInstrument.PaymentAgreement
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

        public PaymentMethod.PaymentInstrument.PaymentAgreement()
        {
        }
    }

    public static class PaymentMethod.PaymentInstrument.PaymentAgreement.AcceptanceDetails
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


        public PaymentMethod.PaymentInstrument.PaymentAgreement.AcceptanceDetails()
        {
        }
    }

    public static class PaymentMethod.PaymentInstrument.PaymentInstrumentRefId
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        private String key;
        private String owner;

        public String getKey()
        {
            return key;
        }


        public PaymentMethod.PaymentInstrument.PaymentInstrumentRefId()
        {
        }
    }

    public static class PaymentMethod.PaymentInstrument.StrategyComponent extends PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice
    {

        private static final long serialVersionUID = 1L;

        public PaymentMethod.PaymentInstrument.StrategyComponent()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CartPaymentMethods createFromParcel(Parcel parcel)
        {
            return (CartPaymentMethods)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/cart/CartPaymentMethods);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public CartPaymentMethods[] newArray(int i)
        {
            return new CartPaymentMethods[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final long serialVersionUID = 1L;
    public List paymentMethodList;

    public CartPaymentMethods()
    {
    }

    public final List getAllPaymentMethods()
    {
        return getPaymentMethodsOfName(null);
    }

    public final List getPaymentMethodsOfName(String s)
    {
        ArrayList arraylist = new ArrayList();
        if (paymentMethodList != null)
        {
            Iterator iterator = paymentMethodList.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                PaymentMethod paymentmethod = (PaymentMethod)iterator.next();
                if (s == null || s.equals(paymentmethod.getName()) && paymentmethod.isApplicable())
                {
                    arraylist.add(paymentmethod);
                }
            } while (true);
        }
        if (arraylist.size() > 0)
        {
            return arraylist;
        } else
        {
            return null;
        }
    }

    public final PaymentMethod getSelectedPaymentMethod()
    {
        if (paymentMethodList == null)
        {
            return null;
        }
        for (Iterator iterator = paymentMethodList.iterator(); iterator.hasNext();)
        {
            PaymentMethod paymentmethod = (PaymentMethod)iterator.next();
            if (paymentmethod != null && paymentmethod.isSelected())
            {
                return paymentmethod;
            }
        }

        return null;
    }

    public boolean isPaymentMethodAvailable(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        Object obj;
        return false;
_L2:
        if ((obj = getPaymentMethodsOfName(s)) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ((List) (obj)).iterator();
        PaymentMethod paymentmethod;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            paymentmethod = (PaymentMethod)((Iterator) (obj)).next();
        } while (!paymentmethod.isApplicable() || !s.equals(paymentmethod.getName()));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public final void unselectPaymentMethod()
    {
        if (paymentMethodList != null)
        {
            Iterator iterator = paymentMethodList.iterator();
            while (iterator.hasNext()) 
            {
                PaymentMethod paymentmethod = (PaymentMethod)iterator.next();
                if (paymentmethod != null && paymentmethod.isSelected())
                {
                    paymentmethod.selected = false;
                }
            }
        }
    }

}
