// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import android.text.TextUtils;
import android.text.format.DateUtils;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.NamedParameter;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
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

public static class Type.altName
    implements Serializable
{
    public static class PlanStep
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public String id;
        public List planOptionsList;

        public PlanStep()
        {
        }
    }

    public static class PlanStep.PlanOption
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

        public PlanStep.PlanOption()
        {
        }
    }

    public static class PlanStep.PlanOption.DeliveryEstimate
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

        public PlanStep.PlanOption.DeliveryEstimate()
        {
        }
    }

    public static class PlanStep.PlanOption.TotalCostWithSavings
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

        public PlanStep.PlanOption.TotalCostWithSavings()
        {
        }
    }

    public static final class PlanStep.PlanOption.TotalCostWithSavings.AddtionalCharges
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public ArrayList additionalCharge;

        public PlanStep.PlanOption.TotalCostWithSavings.AddtionalCharges()
        {
        }
    }

    public static final class PlanStep.PlanOption.TotalCostWithSavings.Adjustment
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public PlanStep.PlanOption.TotalCostWithSavings.AddtionalCharges additionalCharges;

        public PlanStep.PlanOption.TotalCostWithSavings.Adjustment()
        {
        }
    }

    public static final class PlanStep.PlanOption.TotalCostWithSavings.ChargeInfo
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public ArrayList attribute;
        public CurrencyAmount cost;
        public String type;

        public PlanStep.PlanOption.TotalCostWithSavings.ChargeInfo()
        {
        }
    }

    public static final class PlanStep.PlanOption.TotalCostWithSavings.ChargeInfoAttribute
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

        public PlanStep.PlanOption.TotalCostWithSavings.ChargeInfoAttribute()
        {
        }
    }

    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type EBAY_NOW;
        public static final Type GLOBAL_SHIPPING;
        public static final Type ISPU;
        public static final Type PUDO;
        public static final Type SHIP_TO_HOME;
        public static final Type UNKNOWN;
        public final String altName;
        public final String longName;

        public static Type fromOrdinal(int i)
        {
            Type atype[] = values();
            int k = atype.length;
            for (int j = 0; j < k; j++)
            {
                Type type1 = atype[j];
                if (type1.ordinal() == i)
                {
                    return type1;
                }
            }

            return UNKNOWN;
        }

        public static final Type fromToken(String s)
        {
            Type atype[] = values();
            int j = atype.length;
            for (int i = 0; i < j; i++)
            {
                Type type1 = atype[i];
                if (TextUtils.equals(s, type1.longName) || TextUtils.equals(s, type1.altName))
                {
                    return type1;
                }
            }

            return UNKNOWN;
        }

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/ebay/common/model/cart/LogisticsPlans$LogisticsPlan$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new Type("UNKNOWN", 0, "Unknown");
            SHIP_TO_HOME = new Type("SHIP_TO_HOME", 1, "ShipToHome");
            EBAY_NOW = new Type("EBAY_NOW", 2, "ValetService");
            ISPU = new Type("ISPU", 3, "InStorePickup");
            GLOBAL_SHIPPING = new Type("GLOBAL_SHIPPING", 4, "GlobalShipping");
            PUDO = new Type("PUDO", 5, "PickupAndDropoff", "PickUpDropOff");
            $VALUES = (new Type[] {
                UNKNOWN, SHIP_TO_HOME, EBAY_NOW, ISPU, GLOBAL_SHIPPING, PUDO
            });
        }

        private Type(String s, int i, String s1)
        {
         