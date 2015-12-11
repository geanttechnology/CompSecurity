// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateUtils;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.NamedParameter;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
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

public class LogisticsPlans extends BaseDataMapped
    implements Parcelable, Serializable
{
    public static class LogisticsPlan
        implements Serializable
    {

        public static final String TREATMENT_EBAY_NOW_NEXT_DAY = "EBAY_NOW_NEXT_DAY";
        private static final long serialVersionUID = 1L;
        public List planSteps;
        public Type type;

        public String getDeliveryInstructions()
        {
            if (isEbayNow())
            {
                PlanStep.PlanOption planoption = getSelectedPlanOption();
                if (planoption != null)
                {
                    return (String)planoption.getAttributeMap().get("DeliveryInstructions");
                }
            }
            return null;
        }

        public String getEbayPlusCutOffTime(boolean flag)
        {
            if (isEbayPlus())
            {
                PlanStep.PlanOption planoption = getSelectedPlanOption();
                if (planoption != null)
                {
                    return planoption.getEbayPlusCutOffTime(flag);
                }
            }
            return null;
        }

        public String getEbnStoreId()
        {
            PlanStep.PlanOption planoption = getFirstPlanOption();
            if (planoption != null)
            {
                return (String)planoption.getAttributeMap().get("LocationId");
            } else
            {
                return null;
            }
        }

        public String getEbnZoneId()
        {
            PlanStep.PlanOption planoption = getFirstPlanOption();
            if (planoption != null)
            {
                return (String)planoption.getAttributeMap().get("LocationZoneId");
            } else
            {
                return null;
            }
        }

        public String getExternalServiceToken()
        {
            if (isInStorePickup())
            {
                PlanStep.PlanOption planoption = getSelectedPlanOption();
                if (planoption != null)
                {
                    return (String)planoption.getAttributeMap().get("ExternalServiceToken");
                }
            }
            return null;
        }

        public PlanStep.PlanOption getFirstPlanOption()
        {
            if (planSteps != null)
            {
                Object obj = (PlanStep)planSteps.get(0);
                if (obj != null && ((PlanStep) (obj)).planOptionsList != null)
                {
                    obj = ((PlanStep) (obj)).planOptionsList.iterator();
                    if (((Iterator) (obj)).hasNext())
                    {
                        return (PlanStep.PlanOption)((Iterator) (obj)).next();
                    }
                }
            }
            return null;
        }

        public String getName()
        {
            PlanStep.PlanOption planoption = getSelectedPlanOption();
            if (planoption != null)
            {
                return planoption.name;
            } else
            {
                return null;
            }
        }

        public String getPickupLocationId()
        {
            String s;
label0:
            {
                Object obj = null;
                if (!isInStorePickup())
                {
                    s = obj;
                    if (!isPickupAndDropoff())
                    {
                        break label0;
                    }
                }
                PlanStep.PlanOption planoption = getSelectedPlanOption();
                s = obj;
                if (planoption != null)
                {
                    s = (String)planoption.getAttributeMap().get("LocationId");
                }
            }
            return s;
        }

        public String getPickupStoreId()
        {
            if (isInStorePickup() || isPickupAndDropoff())
            {
                PlanStep.PlanOption planoption = getSelectedPlanOption();
                if (planoption != null)
                {
                    return (String)planoption.getAttributeMap().get("StoreId");
                }
            }
            return null;
        }

        public int getPlanOptionCount()
        {
            boolean flag = false;
            int i = ((flag) ? 1 : 0);
            if (planSteps != null)
            {
                PlanStep planstep = (PlanStep)planSteps.get(0);
                i = ((flag) ? 1 : 0);
                if (planstep != null)
                {
                    i = ((flag) ? 1 : 0);
                    if (planstep.planOptionsList != null)
                    {
                        i = planstep.planOptionsList.size();
                    }
                }
            }
            return i;
        }

        public List getPlanOptions()
        {
            ArrayList arraylist = new ArrayList();
            if (planSteps != null)
            {
                Object obj = (PlanStep)planSteps.get(0);
                if (obj != null && ((PlanStep) (obj)).planOptionsList != null)
                {
                    for (obj = ((PlanStep) (obj)).planOptionsList.iterator(); ((Iterator) (obj)).hasNext(); arraylist.add((PlanStep.PlanOption)((Iterator) (obj)).next())) { }
                }
            }
            if (arraylist.size() > 0)
            {
                return arraylist;
            } else
            {
                return null;
            }
        }

        public String getReservationToken()
        {
            if (isEbayNow())
            {
                PlanStep.PlanOption planoption = getSelectedPlanOption();
                if (planoption != null)
                {
                    return (String)planoption.getAttributeMap().get("ReservationToken");
                }
            }
            return null;
        }

        public PlanStep.PlanOption getSelectedPlanOption()
        {
label0:
            {
                if (planSteps == null)
                {
                    break label0;
                }
                Object obj = (PlanStep)planSteps.get(0);
                if (obj == null || ((PlanStep) (obj)).planOptionsList == null)
                {
                    break label0;
                }
                obj = ((PlanStep) (obj)).planOptionsList.iterator();
                PlanStep.PlanOption planoption;
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break label0;
                    }
                    planoption = (PlanStep.PlanOption)((Iterator) (obj)).next();
                } while (!planoption.selected);
                return planoption;
            }
            return null;
        }

        public CurrencyAmount getTotalCost()
        {
            PlanStep.PlanOption planoption = getSelectedPlanOption();
            if (planoption != null)
            {
                return planoption.getLogisticsCost();
            } else
            {
                return null;
            }
        }

        public boolean isEbayNow()
        {
            return Type.EBAY_NOW.equals(type);
        }

        public boolean isEbayPlus()
        {
            PlanStep.PlanOption planoption = getSelectedPlanOption();
            if (planoption != null)
            {
                return "eBayPlus".equals(planoption.getName());
            } else
            {
                return false;
            }
        }

        public boolean isFastAndFree()
        {
            PlanStep.PlanOption planoption = getSelectedPlanOption();
            if (planoption != null)
            {
                return "FAST_AND_FREE".equals(planoption.getAttributeMap().get("DeliveryEstimateTreatment"));
            } else
            {
                return false;
            }
        }

        public boolean isGlobalShipping()
        {
            return Type.GLOBAL_SHIPPING.equals(type);
        }

        public boolean isInStorePickup()
        {
            return Type.ISPU.equals(type);
        }

        public boolean isLocalPickup()
        {
            PlanStep.PlanOption planoption = getSelectedPlanOption();
            if (planoption != null)
            {
                return planoption.isLocalPickup();
            } else
            {
                return false;
            }
        }

        public boolean isPhoneNumberRequired()
        {
            PlanStep.PlanOption planoption = getSelectedPlanOption();
            if (planoption != null)
            {
                return "true".equals(planoption.getAttributeMap().get("PhoneNumberRequired"));
            } else
            {
                return false;
            }
        }

        public boolean isPickupAndDropoff()
        {
            return Type.PUDO.equals(type);
        }

        public boolean isSelected()
        {
            boolean flag;
label0:
            {
                boolean flag1 = false;
                flag = flag1;
                if (planSteps == null)
                {
                    break label0;
                }
                Object obj = (PlanStep)planSteps.get(0);
                flag = flag1;
                if (obj == null)
                {
                    break label0;
                }
                flag = flag1;
                if (((PlanStep) (obj)).planOptionsList == null)
                {
                    break label0;
                }
                obj = ((PlanStep) (obj)).planOptionsList.iterator();
                do
                {
                    flag = flag1;
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break label0;
                    }
                } while (!((PlanStep.PlanOption)((Iterator) (obj)).next()).selected);
                flag = true;
            }
            return flag;
        }

        public boolean isShipToHome()
        {
            return Type.SHIP_TO_HOME.equals(type);
        }

        public boolean isTimeZoneBasedEstimate()
        {
            PlanStep.PlanOption planoption = getSelectedPlanOption();
            if (planoption != null)
            {
                return "true".equals(planoption.getAttributeMap().get("TimeZoneBasedEstimate"));
            } else
            {
                return false;
            }
        }

        public LogisticsPlan()
        {
        }
    }

    public static class LogisticsPlan.PlanStep
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public String id;
        public List planOptionsList;

        public LogisticsPlan.PlanStep()
        {
        }
    }

    public static class LogisticsPlan.PlanStep.PlanOption
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

        public LogisticsPlan.PlanStep.PlanOption()
        {
        }
    }

    public static class LogisticsPlan.PlanStep.PlanOption.DeliveryEstimate
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

        public LogisticsPlan.PlanStep.PlanOption.DeliveryEstimate()
        {
        }
    }

    public static class LogisticsPlan.PlanStep.PlanOption.TotalCostWithSavings
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

        public LogisticsPlan.PlanStep.PlanOption.TotalCostWithSavings()
        {
        }
    }

    public static final class LogisticsPlan.PlanStep.PlanOption.TotalCostWithSavings.AddtionalCharges
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public ArrayList additionalCharge;

        public LogisticsPlan.PlanStep.PlanOption.TotalCostWithSavings.AddtionalCharges()
        {
        }
    }

    public static final class LogisticsPlan.PlanStep.PlanOption.TotalCostWithSavings.Adjustment
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public LogisticsPlan.PlanStep.PlanOption.TotalCostWithSavings.AddtionalCharges additionalCharges;

        public LogisticsPlan.PlanStep.PlanOption.TotalCostWithSavings.Adjustment()
        {
        }
    }

    public static final class LogisticsPlan.PlanStep.PlanOption.TotalCostWithSavings.ChargeInfo
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public ArrayList attribute;
        public CurrencyAmount cost;
        public String type;

        public LogisticsPlan.PlanStep.PlanOption.TotalCostWithSavings.ChargeInfo()
        {
        }
    }

    public static final class LogisticsPlan.PlanStep.PlanOption.TotalCostWithSavings.ChargeInfoAttribute
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

        public LogisticsPlan.PlanStep.PlanOption.TotalCostWithSavings.ChargeInfoAttribute()
        {
        }
    }

    public static final class LogisticsPlan.Type extends Enum
    {

        private static final LogisticsPlan.Type $VALUES[];
        public static final LogisticsPlan.Type EBAY_NOW;
        public static final LogisticsPlan.Type GLOBAL_SHIPPING;
        public static final LogisticsPlan.Type ISPU;
        public static final LogisticsPlan.Type PUDO;
        public static final LogisticsPlan.Type SHIP_TO_HOME;
        public static final LogisticsPlan.Type UNKNOWN;
        public final String altName;
        public final String longName;

        public static LogisticsPlan.Type fromOrdinal(int i)
        {
            LogisticsPlan.Type atype[] = values();
            int k = atype.length;
            for (int j = 0; j < k; j++)
            {
                LogisticsPlan.Type type = atype[j];
                if (type.ordinal() == i)
                {
                    return type;
                }
            }

            return UNKNOWN;
        }

        public static final LogisticsPlan.Type fromToken(String s)
        {
            LogisticsPlan.Type atype[] = values();
            int j = atype.length;
            for (int i = 0; i < j; i++)
            {
                LogisticsPlan.Type type = atype[i];
                if (TextUtils.equals(s, type.longName) || TextUtils.equals(s, type.altName))
                {
                    return type;
                }
            }

            return UNKNOWN;
        }

        public static LogisticsPlan.Type valueOf(String s)
        {
            return (LogisticsPlan.Type)Enum.valueOf(com/ebay/common/model/cart/LogisticsPlans$LogisticsPlan$Type, s);
        }

        public static LogisticsPlan.Type[] values()
        {
            return (LogisticsPlan.Type[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new LogisticsPlan.Type("UNKNOWN", 0, "Unknown");
            SHIP_TO_HOME = new LogisticsPlan.Type("SHIP_TO_HOME", 1, "ShipToHome");
            EBAY_NOW = new LogisticsPlan.Type("EBAY_NOW", 2, "ValetService");
            ISPU = new LogisticsPlan.Type("ISPU", 3, "InStorePickup");
            GLOBAL_SHIPPING = new LogisticsPlan.Type("GLOBAL_SHIPPING", 4, "GlobalShipping");
            PUDO = new LogisticsPlan.Type("PUDO", 5, "PickupAndDropoff", "PickUpDropOff");
            $VALUES = (new LogisticsPlan.Type[] {
                UNKNOWN, SHIP_TO_HOME, EBAY_NOW, ISPU, GLOBAL_SHIPPING, PUDO
            });
        }

        private LogisticsPlan.Type(String s, int i, String s1)
        {
            super(s, i);
            longName = s1;
            altName = s1;
        }

        private LogisticsPlan.Type(String s, int i, String s1, String s2)
        {
            super(s, i);
            longName = s1;
            altName = s2;
        }
    }

    public static class LogisticsPlan.Type.Deserializer
        implements JsonDeserializer
    {

        public LogisticsPlan.Type deserialize(JsonElement jsonelement, java.lang.reflect.Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            return LogisticsPlan.Type.fromToken(jsonelement.getAsString());
        }

        public volatile Object deserialize(JsonElement jsonelement, java.lang.reflect.Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            return deserialize(jsonelement, type, jsondeserializationcontext);
        }

        public LogisticsPlan.Type.Deserializer()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public LogisticsPlans createFromParcel(Parcel parcel)
        {
            return (LogisticsPlans)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/cart/LogisticsPlans);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public LogisticsPlans[] newArray(int i)
        {
            return new LogisticsPlans[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final long serialVersionUID = 1L;
    public List logisticsPlanList;

    public LogisticsPlans()
    {
    }

}
