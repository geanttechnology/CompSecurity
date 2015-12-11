// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import android.text.TextUtils;
import android.text.format.DateUtils;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.NamedParameter;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

// Referenced classes of package com.ebay.common.model.cart:
//            LogisticsPlans

public static class PlanOption
    implements Serializable
{
    public static class PlanOption
        implements Serializable
    {

        public static final String EBAY_PLUS_OPTION = "eBayPlus";
        private static final long serialVersionUID = 1L;
        public NamedParameter addressId;
        private transient Map attributeMap;
        public List attributes;
        public DeliveryEstimate deliveryEstimate;
        public String logisticsOptionIdentifier;
        public String name;
        public String nameSuperscript;
        public String provider;
        public boolean selected;
        public String serviceCategory;
        public String token;
        public TotalCostWithSavings totalCostWithSavings;
        public String type;

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

        public CurrencyAmount getBaseLogisticsCost()
        {
            if (totalCostWithSavings != null)
            {
                return totalCostWithSavings.baseCost;
            } else
            {
                return null;
            }
        }

        public Date getDeliveryDateMax()
        {
            if (deliveryEstimate != null)
            {
                return deliveryEstimate.deliveryDateMax;
            } else
            {
                return null;
            }
        }

        public Date getDeliveryDateMin()
        {
            if (deliveryEstimate != null)
            {
                return deliveryEstimate.deliveryDateMin;
            } else
            {
                return null;
            }
        }

        public String getEbayNowServiceId()
        {
            return (String)getAttributeMap().get("ExternalServiceToken");
        }

        public String getEbayPlusCutOffTime(boolean flag)
        {
            String s = (String)getAttributeMap().get("CutOffTime");
            Date date = EbayDateUtils.parse(s);
            if (!DateUtils.isToday(date.getTime()))
            {
                return null;
            }
            SimpleDateFormat simpledateformat;
            try
            {
                Calendar.getInstance().setTime(date);
            }
            catch (ParseException parseexception)
            {
                return null;
            }
            if (!flag) goto _L2; else goto _L1
_L1:
            simpledateformat = new SimpleDateFormat("HH:mm", Locale.getDefault());
_L4:
            simpledateformat.setTimeZone(TimeZone.getDefault());
            return simpledateformat.format(date).toUpperCase(Locale.US);
_L2:
            simpledateformat = new SimpleDateFormat("h:mma", Locale.US);
            if (true) goto _L4; else goto _L3
_L3:
        }

        public Date getEstimatedPickupTime()
        {
            Date date = null;
            if (deliveryEstimate != null)
            {
                date = deliveryEstimate.estimatedPickupTime;
            }
            return date;
        }

        public CurrencyAmount getLogisticsCost()
        {
            if (totalCostWithSavings != null)
            {
                return totalCostWithSavings.subTotal;
            } else
            {
                return null;
            }
        }

        public String getName()
        {
            return name;
        }

        public boolean isLocalPickup()
        {
            return "LocalPickup".equals(serviceCategory);
        }

        public void setName(String s)
        {
            if (!TextUtils.isEmpty(s) && s.equals("Selbstabholung"))
            {
                name = "Abholung";
                return;
            } else
            {
                name = s;
                return;
            }
        }

        public PlanOption()
        {
        }
    }

    public static class PlanOption.DeliveryEstimate
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public Date deliveryDateMax;
        public Date deliveryDateMin;
        public int deliveryDaysMax;
        public int deliveryDaysMin;
        public Date estimatedPickupTime;

        public void setDeliveryDaysMax(String s)
        {
            deliveryDaysMin = Integer.parseInt(s);
        }

        public void setDeliveryDaysMin(String s)
        {
            deliveryDaysMin = Integer.parseInt(s);
        }

        public PlanOption.DeliveryEstimate()
        {
        }
    }

    public static class PlanOption.TotalCostWithSavings
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public Adjustment adjustment;
        public CurrencyAmount baseCost;
        public CurrencyAmount subTotal;
        public CurrencyAmount totalCost;

        private CurrencyAmount getAmountForChargeByNameAndAttribute(String s, String s1)
        {
label0:
            {
                ChargeInfo chargeinfo;
label1:
                {
                    if (adjustment == null || adjustment.additionalCharges == null || adjustment.additionalCharges.additionalCharge == null)
                    {
                        break label0;
                    }
                    Object obj = adjustment.additionalCharges.additionalCharge.iterator();
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break label0;
                        }
                        chargeinfo = (ChargeInfo)((Iterator) (obj)).next();
                    } while (chargeinfo == null || !s.equals(chargeinfo.type));
                    if (s1 == null || chargeinfo.attribute == null)
                    {
                        break label1;
                    }
                    s = chargeinfo.attribute.iterator();
                    do
                    {
                        if (!s.hasNext())
                        {
                            break label1;
                        }
                        obj = (ChargeInfoAttribute)s.next();
                    } while (obj == null || !s1.equals(((ChargeInfoAttribute) (obj)).name));
                    return ((ChargeInfoAttribute) (obj)).getAmount();
                }
                return chargeinfo.cost;
            }
            return null;
        }

        public CurrencyAmount getConvienceCharge()
        {
            return getAmountForChargeByNameAndAttribute("ConvenienceCharge", null);
        }

        public CurrencyAmount getImportCharge()
        {
            return getAmountForChargeByNameAndAttribute("ImportCharge", null);
        }

        public CurrencyAmount getMinimumOrderAmount()
        {
            return getAmountForChargeByNameAndAttribute("ConvenienceCharge", "MinimumOrderAmountToWaiveCharge");
        }

        public PlanOption.TotalCostWithSavings()
        {
        }
    }

    public static final class PlanOption.TotalCostWithSavings.AddtionalCharges
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public ArrayList additionalCharge;

        public PlanOption.TotalCostWithSavings.AddtionalCharges()
        {
        }
    }

    public static final class PlanOption.TotalCostWithSavings.Adjustment
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public PlanOption.TotalCostWithSavings.AddtionalCharges additionalCharges;

        public PlanOption.TotalCostWithSavings.Adjustment()
        {
        }
    }

    public static final class PlanOption.TotalCostWithSavings.ChargeInfo
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public ArrayList attribute;
        public CurrencyAmount cost;
        public String type;

        public PlanOption.TotalCostWithSavings.ChargeInfo()
        {
        }
    }

    public static final class PlanOption.TotalCostWithSavings.ChargeInfoAttribute
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public String currencyId;
        public String currencyValue;
        public String format;
        public String name;

        public CurrencyAmount getAmount()
        {
            return new CurrencyAmount(currencyValue, currencyId);
        }

        public PlanOption.TotalCostWithSavings.ChargeInfoAttribute()
        {
        }
    }


    private static final long serialVersionUID = 1L;
    public String id;
    public List planOptionsList;

    public PlanOption()
    {
    }
}
