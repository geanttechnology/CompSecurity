// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import android.text.TextUtils;
import com.ebay.common.model.local.AvailabilityIdentifier;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.EnergyEfficiencyRating;
import com.ebay.nautilus.domain.datamapping.gson.EbayDateAdapter;
import com.ebay.nautilus.domain.datamapping.gson.WrappedListAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.model.cart:
//            JsonModel, CartPaymentMethods, CartAddress, IncentiveType, 
//            LogisticsPlans

public class Cart extends JsonModel
    implements Serializable
{
    public static final class Adjustment
        implements Serializable
    {

        public final CurrencyAmount amount;
        public final String description;

        Adjustment(JSONObject jsonobject)
            throws JSONException
        {
            description = JsonModel.getString(jsonobject, "adjustmentDescription");
            amount = JsonModel.getCurrencyAmount(jsonobject, "adjustmentAmount");
        }
    }

    public static final class AppliedIncentive extends IncentiveType
        implements Serializable
    {

        public final String code;
        public final String message;
        public CurrencyAmount redeemedAmount;

        AppliedIncentive(JSONObject jsonobject)
            throws JSONException
        {
            super(jsonobject.getString("incentiveType"));
            code = jsonobject.getString("incentiveCode");
            redeemedAmount = JsonModel.toCurrencyAmount(jsonobject.getJSONObject("redeemedAmount"));
            message = jsonobject.optString("incentiveMessage");
        }
    }

    public static final class ComponentInfo extends JsonModel
        implements Serializable
    {

        public final HashMap attrs = new HashMap();
        public final String ebayItemId;
        public final CurrencyAmount fullPrice;
        public final boolean isDeposit;
        public final String itemImageUrl;
        public final String itemTitle;
        public final String itemTranslatedTitle;
        public final String itemUrl;
        public final CurrencyAmount price;
        public final List promotions = new ArrayList();
        public final int quantity;
        public String transactionId;
        public String variationId;

        public int getQuantityAvailable()
        {
            if (attrs.containsKey("QuantityAvailable"))
            {
                int i;
                try
                {
                    i = Integer.parseInt((String)attrs.get("QuantityAvailable"));
                }
                catch (NumberFormatException numberformatexception)
                {
                    return 0;
                }
                return i;
            } else
            {
                return 0;
            }
        }

        public boolean isPOBoxAddressExcluded()
        {
            return TextUtils.equals("true", (CharSequence)attrs.get("POBoxAddressExcluded"));
        }

        public boolean isPhoneNumberRequired()
        {
            return TextUtils.equals("true", (CharSequence)attrs.get("PhoneNumberRequired"));
        }

        public boolean isTransacted()
        {
            return !TextUtils.isEmpty(transactionId);
        }

        ComponentInfo(JSONObject jsonobject)
            throws JSONException
        {
            Object obj = jsonobject.getJSONObject("componentIdentifier");
            if (((JSONObject) (obj)).has("baseIdentifier"))
            {
                Object obj1 = new JSONObject(((JSONObject) (obj)).getString("baseIdentifier"));
                Object obj2;
                int i;
                if (((JSONObject) (obj1)).has("ItemId"))
                {
                    ebayItemId = ((JSONObject) (obj1)).getString("ItemId");
                } else
                {
                    ebayItemId = null;
                }
            } else
            {
                ebayItemId = null;
            }
            if (((JSONObject) (obj)).has("extendedIdentifier"))
            {
                obj = new JSONObject(((JSONObject) (obj)).getString("extendedIdentifier"));
                if (((JSONObject) (obj)).has("TransactionId"))
                {
                    transactionId = ((JSONObject) (obj)).getString("TransactionId");
                } else
                {
                    transactionId = null;
                }
                if (((JSONObject) (obj)).has("VariationId"))
                {
                    variationId = ((JSONObject) (obj)).getString("VariationId");
                } else
                {
                    variationId = null;
                }
            }
            if (jsonobject.has("lineItemTitle"))
            {
                obj = jsonobject.getJSONObject("lineItemTitle");
                if (((JSONObject) (obj)).has("@basis"))
                {
                    itemTitle = ((JSONObject) (obj)).getString("@basis");
                    itemTranslatedTitle = ((JSONObject) (obj)).getString("__value__");
                } else
                {
                    itemTitle = ((JSONObject) (obj)).getString("__value__");
                    itemTranslatedTitle = null;
                }
            } else
            {
                itemTitle = null;
                itemTranslatedTitle = null;
            }
            quantity = jsonobject.getInt("quantity");
            if (jsonobject.has("price"))
            {
                obj = toCurrencyAmount(jsonobject.getJSONObject("price"));
            } else
            {
                obj = null;
            }
            price = ((CurrencyAmount) (obj));
            if (price != null)
            {
                obj = jsonobject.getJSONObject("price").optString("@type");
                boolean flag;
                if (!TextUtils.isEmpty(((CharSequence) (obj))) && ((String) (obj)).equalsIgnoreCase("deposit"))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                isDeposit = flag;
            } else
            {
                isDeposit = false;
            }
            if (jsonobject.has("fullPrice"))
            {
                obj = toCurrencyAmount(jsonobject.getJSONObject("fullPrice"));
            } else
            {
                obj = null;
            }
            fullPrice = ((CurrencyAmount) (obj));
            itemImageUrl = getString(jsonobject, "imageURL");
            itemUrl = getString(jsonobject, "itemURL");
            if (jsonobject.has("attribute"))
            {
                obj = jsonobject.getJSONArray("attribute");
                for (i = 0; i < ((JSONArray) (obj)).length(); i++)
                {
                    obj2 = ((JSONArray) (obj)).getJSONObject(i);
                    obj1 = getString(((JSONObject) (obj2)), "@name");
                    obj2 = getString(((JSONObject) (obj2)), "__value__");
                    if (!TextUtils.isEmpty(((CharSequence) (obj1))) && !TextUtils.isEmpty(((CharSequence) (obj2))))
                    {
                        attrs.put(obj1, obj2);
                    }
                }

            }
            if (jsonobject.has("promotion"))
            {
                jsonobject = jsonobject.getJSONArray("promotion");
                for (int j = 0; j < jsonobject.length(); j++)
                {
                    promotions.add(new Promotion(jsonobject.getJSONObject(j)));
                }

            }
        }
    }

    public static final class DonationHelper
    {

        public static final String getDonationAmountAsString(Cart cart)
        {
            if (cart.donationAmount != null && cart.donationAmount.isGreaterThanZero())
            {
                return (new DecimalFormat("#.##")).format(cart.donationAmount.getValueAsDouble());
            } else
            {
                return null;
            }
        }

        public static final String getDonationCurrencyCode(Cart cart)
        {
            if (cart != null && cart.total != null)
            {
                return cart.total.getCurrencyCode();
            } else
            {
                return null;
            }
        }

        private static LineItem getDonationLineItem(Cart cart)
        {
            cart = cart.getDonationLineItems();
            if (cart != null)
            {
                return (LineItem)cart.get(0);
            } else
            {
                return null;
            }
        }

        public static final String getDonationLineItemId(Cart cart)
        {
            cart = getDonationLineItem(cart);
            if (cart == null)
            {
                return null;
            } else
            {
                return ((LineItem) (cart)).cartLineItemId;
            }
        }

        public static final String getDonationName(Cart cart)
        {
            cart = getDonationLineItem(cart);
            if (cart == null)
            {
                return null;
            } else
            {
                return ((LineItem) (cart)).itemTitle;
            }
        }

        public static final String getDonationNonprofitId(Cart cart)
        {
            cart = getDonationLineItem(cart);
            if (cart == null)
            {
                return null;
            } else
            {
                return ((LineItem) (cart)).nonprofitId;
            }
        }

        public DonationHelper()
        {
        }
    }

    public static final class LineItem
        implements Serializable
    {

        public final List adjustments;
        public final HashMap attrs;
        public final String cartLineItemId;
        public final Long ebayItemId;
        public String gspError;
        public final List incentives;
        public final boolean isDeposit;
        public String itemImageUrl;
        private HashMap itemSpecifics;
        public final String itemTitle;
        public final String itemTranslatedTitle;
        public String itemUrl;
        public String lineItemErrorCode;
        public final String lockId;
        public LogisticsPlans logisticsPlans;
        public final String nonprofitId;
        public final String note;
        public final List orderComponents;
        public final String orderId;
        public final String paidStatus;
        public final List paymentMethods;
        public String postPurchaseTransactionId;
        public final CurrencyAmount price;
        public final List problemStatus;
        public final List promotions;
        public final String purchaseId;
        public final String purchaseStatus;
        public final int quantity;
        public final SalesTax salesTax;
        public String transactionId;
        public String variationId;

        private EnergyEfficiencyRating getEekValueFromItemSpecifics(String s, EbaySite ebaysite)
        {
            EnergyEfficiencyRating energyefficiencyrating;
label0:
            {
                energyefficiencyrating = EnergyEfficiencyRating.getInstanceForLangauge(s);
                String s1 = (String)attrs.get("EnergyEfficiencyRating");
                if (s1 != null)
                {
                    s = s1;
                    if (s1.length() != 0)
                    {
                        break label0;
                    }
                }
                s = (String)itemSpecifics.get(EnergyEfficiencyRating.getItemSpecificsValueKey(ebaysite));
            }
            if (s == null || s.length() == 0)
            {
                return null;
            } else
            {
                return new EnergyEfficiencyRating(energyefficiencyrating.name, energyefficiencyrating.abbreviatedName, new com.ebay.nautilus.domain.data.BaseCommonType.Text(s));
            }
        }

        public AvailabilityIdentifier getAvailabilityIdentifier(String s, String s1, String s2)
        {
            if (getSellerProductId() == null)
            {
                return null;
            } else
            {
                return new AvailabilityIdentifier(s, s1, s2, getSellerProductId(), quantity);
            }
        }

        public EnergyEfficiencyRating getEek()
        {
            if (!attrs.containsKey("ListingSiteId"))
            {
                return null;
            }
            EbaySite ebaysite = EbaySite.getInstanceFromId((String)attrs.get("ListingSiteId"));
            if (ebaysite == null)
            {
                return null;
            } else
            {
                return getEekValueFromItemSpecifics(Locale.getDefault().getLanguage(), ebaysite);
            }
        }

        public String getListingSiteId()
        {
            String s = null;
            if (attrs.containsKey("ListingSiteId"))
            {
                s = (String)attrs.get("ListingSiteId");
            }
            return s;
        }

        public LogisticsPlans.LogisticsPlan getLogisticsPlanOfType(LogisticsPlans.LogisticsPlan.Type type)
        {
label0:
            {
                if (logisticsPlans == null)
                {
                    break label0;
                }
                Object obj = logisticsPlans.logisticsPlanList;
                if (obj == null)
                {
                    break label0;
                }
                obj = ((List) (obj)).iterator();
                LogisticsPlans.LogisticsPlan logisticsplan;
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break label0;
                    }
                    logisticsplan = (LogisticsPlans.LogisticsPlan)((Iterator) (obj)).next();
                } while (!logisticsplan.type.equals(type));
                return logisticsplan;
            }
            return null;
        }

        public String getPickupLocationId()
        {
            LogisticsPlans.LogisticsPlan logisticsplan = getSelectedLogisticsPlan();
            if (logisticsplan != null)
            {
                return logisticsplan.getPickupLocationId();
            } else
            {
                return null;
            }
        }

        public String getPickupStoreId()
        {
            LogisticsPlans.LogisticsPlan logisticsplan = getSelectedLogisticsPlan();
            if (logisticsplan != null)
            {
                return logisticsplan.getPickupStoreId();
            } else
            {
                return null;
            }
        }

        public int getQuantityAvailable()
        {
            if (attrs.containsKey("QuantityAvailable"))
            {
                int i;
                try
                {
                    i = Integer.parseInt((String)attrs.get("QuantityAvailable"));
                }
                catch (NumberFormatException numberformatexception)
                {
                    return 0;
                }
                return i;
            } else
            {
                return 0;
            }
        }

        public LogisticsPlans.LogisticsPlan getSelectedLogisticsPlan()
        {
label0:
            {
                if (logisticsPlans == null)
                {
                    break label0;
                }
                Object obj = logisticsPlans.logisticsPlanList;
                if (obj == null)
                {
                    break label0;
                }
                obj = ((List) (obj)).iterator();
                LogisticsPlans.LogisticsPlan logisticsplan;
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break label0;
                    }
                    logisticsplan = (LogisticsPlans.LogisticsPlan)((Iterator) (obj)).next();
                } while (!logisticsplan.isSelected());
                return logisticsplan;
            }
            return null;
        }

        public String getSellerProductId()
        {
            if (attrs.containsKey("SellerProductId"))
            {
                return (String)attrs.get("SellerProductId");
            } else
            {
                return null;
            }
        }

        public String getTitle(boolean flag)
        {
            if (flag && !TextUtils.isEmpty(itemTranslatedTitle))
            {
                return itemTranslatedTitle;
            } else
            {
                return itemTitle;
            }
        }

        public boolean hasEbayBuyerGuarantee()
        {
            return TextUtils.equals("true", (CharSequence)attrs.get("HasEbayBuyerGuarantee"));
        }

        public boolean isBuyerProtectionEligible()
        {
            return attrs.containsKey("IsBuyerProtectionEligible") && ((String)attrs.get("IsBuyerProtectionEligible")).equals("true");
        }

        public boolean isDonation()
        {
            return nonprofitId != null;
        }

        public boolean isEbayNowAvailable()
        {
label0:
            {
                if (logisticsPlans == null)
                {
                    break label0;
                }
                Object obj = logisticsPlans.logisticsPlanList;
                if (obj == null)
                {
                    break label0;
                }
                obj = ((List) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break label0;
                    }
                } while (!((LogisticsPlans.LogisticsPlan)((Iterator) (obj)).next()).isEbayNow());
                return true;
            }
            return false;
        }

        public boolean isEbayNowSelected()
        {
            LogisticsPlans.LogisticsPlan logisticsplan = getSelectedLogisticsPlan();
            return logisticsplan != null && logisticsplan.isEbayNow();
        }

        public boolean isEbayPlusSelected()
        {
            LogisticsPlans.LogisticsPlan logisticsplan = getSelectedLogisticsPlan();
            return logisticsplan != null && logisticsplan.isEbayPlus();
        }

        public boolean isImmediatePay()
        {
            return attrs.containsKey("IsImmediatePay") && ((String)attrs.get("IsImmediatePay")).equals("true");
        }

        public boolean isInStorePickupAvailable()
        {
label0:
            {
                if (logisticsPlans == null)
                {
                    break label0;
                }
                Object obj = logisticsPlans.logisticsPlanList;
                if (obj == null)
                {
                    break label0;
                }
                obj = ((List) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break label0;
                    }
                } while (!((LogisticsPlans.LogisticsPlan)((Iterator) (obj)).next()).isInStorePickup());
                return true;
            }
            return false;
        }

        public boolean isInStorePickupOnly()
        {
label0:
            {
                if (logisticsPlans != null)
                {
                    Object obj = logisticsPlans.logisticsPlanList;
                    if (obj == null)
                    {
                        break label0;
                    }
                    obj = ((List) (obj)).iterator();
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break label0;
                        }
                    } while (((LogisticsPlans.LogisticsPlan)((Iterator) (obj)).next()).isInStorePickup());
                }
                return false;
            }
            return true;
        }

        public boolean isInStorePickupSelected()
        {
            LogisticsPlans.LogisticsPlan logisticsplan = getSelectedLogisticsPlan();
            return logisticsplan != null && logisticsplan.isInStorePickup();
        }

        public boolean isInvoiced()
        {
            return attrs.containsKey("IsInvoiced") && ((String)attrs.get("IsInvoiced")).equals("true");
        }

        public boolean isLocalPickupAvailable()
        {
label0:
            {
                if (logisticsPlans == null)
                {
                    break label0;
                }
                Object obj = logisticsPlans.logisticsPlanList;
                if (obj == null)
                {
                    break label0;
                }
                obj = ((List) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break label0;
                    }
                } while (!((LogisticsPlans.LogisticsPlan)((Iterator) (obj)).next()).isLocalPickup());
                return true;
            }
            return false;
        }

        public boolean isLocalPickupSelected()
        {
            LogisticsPlans.LogisticsPlan logisticsplan = getSelectedLogisticsPlan();
            return logisticsplan != null && logisticsplan.isLocalPickup();
        }

        public boolean isPOBoxAddressExcluded()
        {
            return TextUtils.equals("true", (CharSequence)attrs.get("POBoxAddressExcluded"));
        }

        public boolean isPhoneNumberRequired()
        {
label0:
            {
                if (TextUtils.equals("true", (CharSequence)attrs.get("PhoneNumberRequired")))
                {
                    return true;
                }
                Object obj = getSelectedLogisticsPlan();
                if (obj != null)
                {
                    return ((LogisticsPlans.LogisticsPlan) (obj)).isPhoneNumberRequired();
                }
                if (orderComponents.size() <= 0)
                {
                    break label0;
                }
                obj = orderComponents.iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break label0;
                    }
                } while (!((ComponentInfo)((Iterator) (obj)).next()).isPhoneNumberRequired());
                return true;
            }
            return false;
        }

        public boolean isPickupAndDropoffAvailable()
        {
label0:
            {
                if (logisticsPlans == null)
                {
                    break label0;
                }
                Object obj = logisticsPlans.logisticsPlanList;
                if (obj == null)
                {
                    break label0;
                }
                obj = ((List) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break label0;
                    }
                } while (!((LogisticsPlans.LogisticsPlan)((Iterator) (obj)).next()).isPickupAndDropoff());
                return true;
            }
            return false;
        }

        public boolean isPickupAndDropoffSelected()
        {
            LogisticsPlans.LogisticsPlan logisticsplan = getSelectedLogisticsPlan();
            return logisticsplan != null && logisticsplan.isPickupAndDropoff();
        }

        public boolean isShipToHomeAvailable()
        {
label0:
            {
                if (logisticsPlans == null)
                {
                    break label0;
                }
                Object obj = logisticsPlans.logisticsPlanList;
                if (obj == null)
                {
                    break label0;
                }
                obj = ((List) (obj)).iterator();
                LogisticsPlans.LogisticsPlan logisticsplan;
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break label0;
                    }
                    logisticsplan = (LogisticsPlans.LogisticsPlan)((Iterator) (obj)).next();
                } while (!logisticsplan.isShipToHome() && !logisticsplan.isGlobalShipping());
                return true;
            }
            return false;
        }

        public boolean isShipToHomeSelected()
        {
            LogisticsPlans.LogisticsPlan logisticsplan = getSelectedLogisticsPlan();
            return logisticsplan != null && (logisticsplan.isShipToHome() || logisticsplan.isGlobalShipping());
        }

        public boolean isShippable(Address address)
        {
            if (!isInStorePickupSelected()) goto _L2; else goto _L1
_L1:
            return true;
_L2:
            if (problemStatus == null || problemStatus.size() <= 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            Iterator iterator = problemStatus.iterator();
            ProblemStatus problemstatus;
            do
            {
                if (!iterator.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                problemstatus = (ProblemStatus)iterator.next();
            } while (problemstatus.status == null || !problemstatus.status.equals("ShippingNotCalculated") && !problemstatus.status.equals("ShippingNotCalculable"));
            return false;
            if (address == null || !isShipToHomeSelected()) goto _L1; else goto _L3
_L3:
            if (isPOBoxAddressExcluded() && address.isPOBox())
            {
                return false;
            }
            if (isPhoneNumberRequired() && TextUtils.isEmpty(address.addressFields.getPhone()))
            {
                return false;
            }
            if (orderComponents.size() <= 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            Iterator iterator1 = orderComponents.iterator();
            ComponentInfo componentinfo;
            do
            {
                if (!iterator1.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                componentinfo = (ComponentInfo)iterator1.next();
                if (componentinfo.isPOBoxAddressExcluded() && address.isPOBox())
                {
                    return false;
                }
            } while (!componentinfo.isPhoneNumberRequired() || !TextUtils.isEmpty(address.addressFields.getPhone()));
            break; /* Loop/switch isn't completed */
            if (true) goto _L1; else goto _L4
_L4:
            return false;
        }

        public boolean isTransacted()
        {
            if (orderComponents.size() <= 0) goto _L2; else goto _L1
_L1:
            Iterator iterator = orderComponents.iterator();
_L5:
            if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
            if (!((ComponentInfo)iterator.next()).isTransacted()) goto _L5; else goto _L4
_L4:
            return true;
_L2:
            if (TextUtils.isEmpty(transactionId))
            {
                return false;
            }
            if (true) goto _L4; else goto _L6
_L6:
        }

        LineItem(JSONObject jsonobject)
            throws JSONException
        {
            cartLineItemId = jsonobject.getString("cartLineItemIdentifier");
            Object obj = jsonobject.getJSONObject("lineItemIdentifier");
            String s = ((JSONObject) (obj)).getString("baseIdentifier");
            if (!TextUtils.isEmpty(s))
            {
                Object obj5;
                int i;
                if (s.contains("ItemId="))
                {
                    ebayItemId = Long.valueOf(Long.parseLong(s.substring("ItemId=".length())));
                } else
                {
                    ebayItemId = null;
                }
                if (s.contains("OrderId="))
                {
                    orderId = s.substring("OrderId=".length());
                } else
                {
                    orderId = null;
                }
                if (s.contains("NonprofitId"))
                {
                    nonprofitId = (new JSONObject(s)).getString("NonprofitId");
                } else
                {
                    nonprofitId = null;
                }
            } else
            {
                ebayItemId = null;
                orderId = null;
                nonprofitId = null;
            }
            if (((JSONObject) (obj)).has("extendedIdentifier"))
            {
                obj = ((JSONObject) (obj)).getString("extendedIdentifier");
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    if (((String) (obj)).contains("TransactionId="))
                    {
                        transactionId = ((String) (obj)).substring("TransactionId=".length());
                    } else
                    {
                        transactionId = null;
                    }
                    if (((String) (obj)).contains("VariationId="))
                    {
                        variationId = ((String) (obj)).substring("VariationId=".length());
                    } else
                    {
                        variationId = null;
                    }
                }
            }
            if (jsonobject.has("lineItemTitle"))
            {
                obj = jsonobject.getJSONObject("lineItemTitle");
                if (((JSONObject) (obj)).has("@basis"))
                {
                    itemTitle = ((JSONObject) (obj)).getString("@basis");
                    itemTranslatedTitle = ((JSONObject) (obj)).getString("__value__");
                } else
                {
                    itemTitle = ((JSONObject) (obj)).getString("__value__");
                    itemTranslatedTitle = null;
                }
            } else
            {
                itemTitle = null;
                itemTranslatedTitle = null;
            }
            quantity = jsonobject.getInt("quantity");
            if (jsonobject.has("price"))
            {
                obj = JsonModel.toCurrencyAmount(jsonobject.getJSONObject("price"));
            } else
            {
                obj = null;
            }
            price = ((CurrencyAmount) (obj));
            if (price != null)
            {
                obj = jsonobject.getJSONObject("price").optString("@type");
                boolean flag;
                if (!TextUtils.isEmpty(((CharSequence) (obj))) && ((String) (obj)).equalsIgnoreCase("deposit"))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                isDeposit = flag;
            } else
            {
                isDeposit = false;
            }
            if (!jsonobject.isNull("pictureURLs"))
            {
                obj = jsonobject.getJSONObject("pictureURLs");
                if (((JSONObject) (obj)).has("pictureURL"))
                {
                    obj = ((JSONObject) (obj)).getJSONArray("pictureURL");
                    for (i = 0; i < ((JSONArray) (obj)).length(); i++)
                    {
                        obj5 = ((JSONArray) (obj)).getJSONObject(i);
                        s = JsonModel.getString(((JSONObject) (obj5)), "@name");
                        obj5 = JsonModel.getString(((JSONObject) (obj5)), "__value__");
                        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(((CharSequence) (obj5))) && "FullSize".equals(s))
                        {
                            itemImageUrl = ((String) (obj5));
                        }
                    }

                } else
                {
                    itemImageUrl = null;
                }
            } else
            {
                itemImageUrl = null;
            }
            if (!jsonobject.isNull("itemURLs"))
            {
                Object obj1 = jsonobject.getJSONObject("itemURLs");
                if (((JSONObject) (obj1)).has("itemURL"))
                {
                    obj1 = ((JSONObject) (obj1)).getJSONArray("itemURL");
                    for (int j = 0; j < ((JSONArray) (obj1)).length(); j++)
                    {
                        Object obj6 = ((JSONArray) (obj1)).getJSONObject(j);
                        String s1 = JsonModel.getString(((JSONObject) (obj6)), "@type");
                        obj6 = JsonModel.getString(((JSONObject) (obj6)), "__value__");
                        if (!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(((CharSequence) (obj6))) && "ItemURL".equals(s1))
                        {
                            itemUrl = ((String) (obj6));
                        }
                    }

                }
            } else
            {
                itemUrl = null;
            }
            attrs = new HashMap();
            itemSpecifics = new HashMap();
            if (!jsonobject.has("attribute")) goto _L2; else goto _L1
_L1:
            JSONArray jsonarray;
            int k;
            jsonarray = jsonobject.getJSONArray("attribute");
            k = 0;
_L9:
            if (k >= jsonarray.length()) goto _L2; else goto _L3
_L3:
            Object obj4;
            Object obj7;
            obj7 = jsonarray.getJSONObject(k);
            obj4 = JsonModel.getString(((JSONObject) (obj7)), "@name");
            obj7 = JsonModel.getString(((JSONObject) (obj7)), "__value__");
            if (TextUtils.isEmpty(((CharSequence) (obj4))) || TextUtils.isEmpty(((CharSequence) (obj7)))) goto _L5; else goto _L4
_L4:
            if (!"ItemSpecifics".equals(obj4)) goto _L7; else goto _L6
_L6:
            obj4 = (JsonObject)(new Gson()).fromJson(((String) (obj7)), com/google/gson/JsonObject);
            if (obj4 != null)
            {
                try
                {
                    if (!((JsonObject) (obj4)).isJsonNull())
                    {
                        itemSpecifics = new HashMap();
                        Object obj8;
                        for (obj4 = ((JsonObject) (obj4)).entrySet().iterator(); ((Iterator) (obj4)).hasNext(); itemSpecifics.put(obj7, obj8))
                        {
                            obj8 = (java.util.Map.Entry)((Iterator) (obj4)).next();
                            obj7 = (String)((java.util.Map.Entry) (obj8)).getKey();
                            obj8 = ((JsonPrimitive)((java.util.Map.Entry) (obj8)).getValue()).getAsString();
                        }

                    }
                }
                // Misplaced declaration of an exception variable
                catch (Object obj4) { }
            }
_L5:
            k++;
            continue; /* Loop/switch isn't completed */
_L7:
            attrs.put(obj4, obj7);
            if (true) goto _L5; else goto _L2
_L2:
            purchaseStatus = JsonModel.getString(jsonobject, "lineItemPurchaseStatus");
            Object obj2;
            if (jsonobject.has("tax"))
            {
                obj2 = new SalesTax(jsonobject.getJSONObject("tax"));
            } else
            {
                obj2 = null;
            }
            salesTax = ((SalesTax) (obj2));
            promotions = new ArrayList();
            if (jsonobject.has("promotion"))
            {
                obj2 = jsonobject.getJSONArray("promotion");
                for (int l = 0; l < ((JSONArray) (obj2)).length(); l++)
                {
                    promotions.add(new Promotion(((JSONArray) (obj2)).getJSONObject(l)));
                }

            }
            paymentMethods = new ArrayList();
            if (jsonobject.has("availablePaymentMethod"))
            {
                JSONArray jsonarray1 = jsonobject.getJSONArray("availablePaymentMethod");
                for (int i1 = 0; i1 < jsonarray1.length(); i1++)
                {
                    paymentMethods.add(jsonarray1.getJSONObject(i1).getString("paymentMethodName"));
                }

            }
            if (jsonobject.has("logisticsPlans") && !jsonobject.isNull("logisticsPlans"))
            {
                Object obj3 = jsonobject.getJSONObject("logisticsPlans");
                if (obj3 != null)
                {
                    obj3 = ((JSONObject) (obj3)).toString();
                    logisticsPlans = (LogisticsPlans)Cart.MAPPER.fromJson(((String) (obj3)), com/ebay/common/model/cart/LogisticsPlans);
                }
            } else
            {
                logisticsPlans = null;
            }
            incentives = new ArrayList();
            if (jsonobject.has("incentive"))
            {
                JSONArray jsonarray2 = jsonobject.getJSONArray("incentive");
                for (int j1 = 0; j1 < jsonarray2.length(); j1++)
                {
                    incentives.add(new AppliedIncentive(jsonarray2.getJSONObject(j1)));
                }

            }
            adjustments = new ArrayList();
            if (jsonobject.has("adjustments"))
            {
                JSONArray jsonarray3 = jsonobject.getJSONArray("adjustments");
                for (int k1 = 0; k1 < jsonarray3.length(); k1++)
                {
                    adjustments.add(new Adjustment(jsonarray3.getJSONObject(k1)));
                }

            }
            paidStatus = JsonModel.getString(jsonobject, "lineItemPaidStatus");
            problemStatus = new ArrayList();
            if (jsonobject.has("problemStatus"))
            {
                JSONArray jsonarray4 = jsonobject.getJSONArray("problemStatus");
                for (int l1 = 0; l1 < jsonarray4.length(); l1++)
                {
                    problemStatus.add(new ProblemStatus(jsonarray4.getJSONObject(l1)));
                }

            }
            note = JsonModel.getString(jsonobject, "note");
            purchaseId = JsonModel.getString(jsonobject, "purchaseId");
            lockId = JsonModel.getString(jsonobject, "lockId");
            if (jsonobject.has("purchaseId"))
            {
                JSONObject jsonobject1 = new JSONObject(jsonobject.getString("purchaseId"));
                if (jsonobject1.has("TransactionId"))
                {
                    postPurchaseTransactionId = jsonobject1.getString("TransactionId");
                }
            }
            lineItemErrorCode = null;
            orderComponents = new ArrayList();
            if (jsonobject.has("component"))
            {
                jsonobject = jsonobject.getJSONArray("component");
                for (int i2 = 0; i2 < jsonobject.length(); i2++)
                {
                    orderComponents.add(new ComponentInfo(jsonobject.getJSONObject(i2)));
                }

            }
            return;
            if (true) goto _L9; else goto _L8
_L8:
        }
    }

    public static final class ProblemStatus
        implements Serializable
    {

        public final String details;
        public final String status;
        public final String summary;
        public final String systemId;

        ProblemStatus(JSONObject jsonobject)
            throws JSONException
        {
            status = jsonobject.getString("status");
            summary = JsonModel.getString(jsonobject, "summary");
            details = JsonModel.getString(jsonobject, "details");
            systemId = JsonModel.getString(jsonobject, "systemId");
        }
    }

    public static final class Promotion
        implements Serializable
    {

        public final String appliedStatus;
        public final Map attributeMap = new HashMap();
        public final List attributes = new ArrayList();
        public final String code;
        public final boolean isApplied;
        public final String message;
        public final CurrencyAmount savingsAmount;
        public final String type;

        Promotion(JSONObject jsonobject)
            throws JSONException
        {
            appliedStatus = JsonModel.getString(jsonobject, "promotionAppliedStatus");
            code = JsonModel.getString(jsonobject, "promotionCode");
            message = JsonModel.getString(jsonobject, "promotionMessage");
            type = JsonModel.getString(jsonobject, "promotionType");
            savingsAmount = JsonModel.getCurrencyAmount(jsonobject, "promotionSavingsAmount");
            jsonobject = jsonobject.optJSONArray("promotionAttribute");
            if (jsonobject != null)
            {
                for (int i = 0; i < jsonobject.length(); i++)
                {
                    Property property = new Property(jsonobject.getJSONObject(i));
                    attributes.add(property);
                    attributeMap.put(property.name, property.value);
                }

            }
            isApplied = TextUtils.equals(appliedStatus, "APPLIED");
        }
    }

    public static class Property
        implements Serializable
    {

        public final String name;
        public final String value;

        public Property(JSONObject jsonobject)
            throws JSONException
        {
            name = JsonModel.getString(jsonobject, "@name");
            value = JsonModel.getString(jsonobject, "__value__");
        }
    }

    public static final class SalesTax
        implements Serializable
    {

        public final CurrencyAmount amount;
        public final Double percent;
        public final Boolean shippingIncluded;
        public final String stateOrProvince;

        SalesTax(JSONObject jsonobject)
            throws JSONException
        {
            amount = JsonModel.getCurrencyAmount(jsonobject, "salesTaxAmount");
            percent = JsonModel.getDouble(jsonobject, "salesTaxPercent");
            stateOrProvince = JsonModel.getString(jsonobject, "salesTaxState");
            shippingIncluded = JsonModel.getBoolean(jsonobject, "shippingIncludedInTax");
        }
    }

    public static final class Seller
        implements Serializable
    {

        final Map attributes = new HashMap();
        public final List cartLineItemIds = new ArrayList();
        public String note;
        public final String userIdentifier;

        public boolean acceptsNotesToSeller()
        {
            return !attributes.containsKey("DoesNotAcceptNotesToSeller") || !((String)attributes.get("DoesNotAcceptNotesToSeller")).equalsIgnoreCase("true");
        }

        public void addCartLineItem(String s)
        {
            if (!cartLineItemIds.contains(s))
            {
                cartLineItemIds.add(s);
            }
        }

        public String getId()
        {
            return (String)attributes.get("Id");
        }

        public int getLineItemCount()
        {
            return cartLineItemIds.size();
        }

        Seller(JSONObject jsonobject)
            throws JSONException
        {
            userIdentifier = jsonobject.getString("userIdentifier");
            note = null;
            jsonobject = jsonobject.optJSONArray("userAttribute");
            if (jsonobject != null)
            {
                for (int i = 0; i < jsonobject.length(); i++)
                {
                    Property property = new Property(jsonobject.getJSONObject(i));
                    attributes.put(property.name, property.value);
                }

            }
        }
    }


    private static final String CART_ADDRESS_TYPE_SHIPPING = "BuyerShippingAddress";
    private static final Gson MAPPER = (new GsonBuilder()).excludeFieldsWithModifiers(new int[] {
        8, 128, 64
    }).registerTypeAdapter(java/util/Date, new EbayDateAdapter()).registerTypeAdapter((new TypeToken() {

    }).getType(), new WrappedListAdapter("url")).registerTypeAdapter((new TypeToken() {

    }).getType(), new WrappedListAdapter("strategyChoice")).registerTypeAdapter((new TypeToken() {

    }).getType(), new WrappedListAdapter("strategyComponent")).registerTypeAdapter(com/ebay/common/model/cart/LogisticsPlans$LogisticsPlan$Type, new LogisticsPlans.LogisticsPlan.Type.Deserializer()).create();
    public static final String TAG = "Cart";
    public final CurrencyAmount adjustmentsSubtotal;
    private final boolean buyFailedAll;
    private final boolean buyFailedPartial;
    private final boolean buyInitiated;
    private final boolean buySucceeded;
    private final Map cartAddresses;
    public final String cartId;
    public final CartPaymentMethods cartPaymentMethods;
    public CurrencyAmount convenienceCharge;
    public CurrencyAmount deliverySubtotal;
    public final CurrencyAmount donationAmount;
    public final CurrencyAmount handlingSubtotal;
    public CurrencyAmount importCharges;
    public final CurrencyAmount incentiveSubtotal;
    public final Map incentives;
    public final CurrencyAmount insuranceSubtotal;
    public final List lineItems;
    public final CurrencyAmount logisticsDiscountsSubtotal;
    public final CurrencyAmount logisticsSubtotal;
    public final String orderId;
    public final CurrencyAmount otherFeesSubtotal;
    private boolean paymentInstrumentSelected;
    public CurrencyAmount priceSubtotal;
    public final CurrencyAmount promotionSavingsTotal;
    public final CurrencyAmount savingsAmount;
    public final Map sellers;
    public CurrencyAmount shippingSubtotal;
    public boolean shouldRememberCreditCardSwitch;
    public boolean shouldRememberDirectDebitSwitch;
    public boolean shouldRememberPayPalSwitch;
    public final CurrencyAmount taxSubtotal;
    public final CurrencyAmount total;
    public final String updateVersion;

    public Cart(JSONObject jsonobject)
        throws JSONException
    {
        super(jsonobject);
        incentives = new HashMap();
        sellers = new HashMap();
        lineItems = new ArrayList();
        if (!jsonobject.has("cart")) goto _L2; else goto _L1
_L1:
        Object obj = jsonobject.getJSONObject("cart");
        cartId = getString(((JSONObject) (obj)), "cartIdentifier");
        updateVersion = getString(((JSONObject) (obj)), "cartUpdateVersion");
        if (((JSONObject) (obj)).has("cartPaymentMethods") && !((JSONObject) (obj)).isNull("cartPaymentMethods"))
        {
            jsonobject = ((JSONObject) (obj)).getJSONObject("cartPaymentMethods").toString();
            cartPaymentMethods = (CartPaymentMethods)MAPPER.fromJson(jsonobject, com/ebay/common/model/cart/CartPaymentMethods);
        } else
        {
            cartPaymentMethods = null;
        }
        if (((JSONObject) (obj)).has("buyer"))
        {
            jsonobject = ((JSONObject) (obj)).getJSONObject("buyer");
            if (jsonobject.has("userPreference"))
            {
                jsonobject = jsonobject.optJSONArray("userPreference").getJSONObject(0).getJSONArray("attribute");
                boolean flag = false;
                for (int i = 0; i < jsonobject.length(); i++)
                {
                    Property property = new Property(jsonobject.getJSONObject(i));
                    if ("defaultRememberPaymentInstrumentOption".equals(property.name))
                    {
                        flag = Boolean.valueOf(property.value).booleanValue();
                    }
                }

                shouldRememberPayPalSwitch = flag;
                shouldRememberCreditCardSwitch = flag;
                shouldRememberDirectDebitSwitch = flag;
                for (int j = 0; j < jsonobject.length(); j++)
                {
                    Property property1 = new Property(jsonobject.getJSONObject(j));
                    if ("shouldOfferRememberCCOption".equals(property1.name))
                    {
                        shouldRememberCreditCardSwitch = Boolean.valueOf(property1.value).booleanValue();
                    }
                    if ("shouldOfferRememberDDOption".equals(property1.name))
                    {
                        shouldRememberDirectDebitSwitch = Boolean.valueOf(property1.value).booleanValue();
                    }
                    if ("shouldOfferRememberPPOption".equals(property1.name))
                    {
                        shouldRememberPayPalSwitch = Boolean.valueOf(property1.value).booleanValue();
                    }
                }

            }
        }
        boolean flag11 = false;
        boolean flag3 = false;
        boolean flag12 = false;
        boolean flag2 = false;
        boolean flag13 = false;
        boolean flag4 = false;
        boolean flag14 = false;
        boolean flag5 = false;
        boolean flag15 = false;
        boolean flag1 = false;
        boolean flag6 = flag14;
        boolean flag7 = flag13;
        boolean flag8 = flag11;
        boolean flag9 = flag12;
        boolean flag10 = flag15;
        if (((JSONObject) (obj)).has("progressFlags"))
        {
            jsonobject = ((JSONObject) (obj)).getJSONObject("progressFlags");
            flag6 = flag14;
            flag7 = flag13;
            flag8 = flag11;
            flag9 = flag12;
            flag10 = flag15;
            if (jsonobject.has("flag"))
            {
                jsonobject = jsonobject.getJSONArray("flag");
                flag6 = flag14;
                flag7 = flag13;
                flag8 = flag11;
                flag9 = flag12;
                flag10 = flag15;
                if (jsonobject.length() > 0)
                {
                    int k = 0;
                    do
                    {
                        flag6 = flag5;
                        flag7 = flag4;
                        flag8 = flag3;
                        flag9 = flag2;
                        flag10 = flag1;
                        if (k >= jsonobject.length())
                        {
                            break;
                        }
                        String s = jsonobject.getString(k);
                        flag6 = flag5;
                        flag7 = flag4;
                        flag8 = flag3;
                        flag9 = flag2;
                        flag10 = flag1;
                        if (!TextUtils.isEmpty(s))
                        {
                            if (s.equals("BuyInitiated"))
                            {
                                flag8 = true;
                                flag10 = flag1;
                                flag9 = flag2;
                                flag7 = flag4;
                                flag6 = flag5;
                            } else
                            if (s.equals("BuySucceeded"))
                            {
                                flag9 = true;
                                flag6 = flag5;
                                flag7 = flag4;
                                flag8 = flag3;
                                flag10 = flag1;
                            } else
                            if (s.equals("BuyFailedPartial"))
                            {
                                flag7 = true;
                                flag6 = flag5;
                                flag8 = flag3;
                                flag9 = flag2;
                                flag10 = flag1;
                            } else
                            if (s.equals("BuyFailedAll"))
                            {
                                flag6 = true;
                                flag7 = flag4;
                                flag8 = flag3;
                                flag9 = flag2;
                                flag10 = flag1;
                            } else
                            {
                                flag6 = flag5;
                                flag7 = flag4;
                                flag8 = flag3;
                                flag9 = flag2;
                                flag10 = flag1;
                                if (s.equals("PaymentInstrumentSelected"))
                                {
                                    flag10 = true;
                                    flag6 = flag5;
                                    flag7 = flag4;
                                    flag8 = flag3;
                                    flag9 = flag2;
                                }
                            }
                        }
                        k++;
                        flag5 = flag6;
                        flag4 = flag7;
                        flag3 = flag8;
                        flag2 = flag9;
                        flag1 = flag10;
                    } while (true);
                }
            }
        }
        buyInitiated = flag8;
        buySucceeded = flag9;
        buyFailedPartial = flag7;
        buyFailedAll = flag6;
        paymentInstrumentSelected = flag10;
        if (((JSONObject) (obj)).has("group"))
        {
            JSONArray jsonarray = ((JSONObject) (obj)).getJSONArray("group");
            if (jsonarray.length() > 0)
            {
                for (int l = 0; l < jsonarray.length(); l++)
                {
                    JSONObject jsonobject1 = jsonarray.getJSONObject(l);
                    jsonobject = new Seller(jsonobject1.getJSONObject("seller"));
                    Object obj3 = ((Seller) (jsonobject)).userIdentifier;
                    if (sellers.containsKey(((Seller) (jsonobject)).userIdentifier))
                    {
                        jsonobject = (Seller)sellers.get(obj3);
                    } else
                    {
                        sellers.put(obj3, jsonobject);
                    }
                    if (jsonobject1.has("lineItem"))
                    {
                        obj3 = jsonarray.getJSONObject(l).getJSONArray("lineItem");
                        for (int k1 = 0; k1 < ((JSONArray) (obj3)).length(); k1++)
                        {
                            LineItem lineitem1 = new LineItem(((JSONArray) (obj3)).getJSONObject(k1));
                            lineItems.add(lineitem1);
                            if (!lineitem1.isDonation())
                            {
                                jsonobject.addCartLineItem(lineitem1.cartLineItemId);
                            }
                        }

                    }
                    if (!jsonobject1.has("incentive"))
                    {
                        continue;
                    }
                    jsonobject = jsonobject1.getJSONArray("incentive");
                    for (int l1 = 0; l1 < jsonobject.length(); l1++)
                    {
                        addOrMergeAppliedIncentiveToList(new AppliedIncentive(jsonobject.getJSONObject(l1)));
                    }

                }

            }
        }
        if (((JSONObject) (obj)).has("notes"))
        {
            jsonobject = ((JSONObject) (obj)).getJSONObject("notes");
            if (jsonobject.has("sellerNote"))
            {
                jsonobject = jsonobject.getJSONArray("sellerNote");
                if (jsonobject.length() > 0)
                {
                    for (int i1 = 0; i1 < jsonobject.length(); i1++)
                    {
                        Object obj1 = jsonobject.getJSONObject(i1);
                        String s1 = ((JSONObject) (obj1)).getString("sellerIdentifier");
                        obj1 = ((JSONObject) (obj1)).getString("note");
                        if (sellers.containsKey(s1))
                        {
                            ((Seller)sellers.get(s1)).note = ((String) (obj1));
                        }
                    }

                }
            }
        }
        if (((JSONObject) (obj)).has("cartAddresses"))
        {
            jsonobject = ((JSONObject) (obj)).getJSONObject("cartAddresses");
            if (jsonobject.has("cartAddressInfo"))
            {
                JSONArray jsonarray1 = jsonobject.getJSONArray("cartAddressInfo");
                if (jsonarray1.length() > 0)
                {
                    cartAddresses = new HashMap();
                    int j1 = 0;
                    while (j1 < jsonarray1.length()) 
                    {
                        jsonobject = jsonarray1.getJSONObject(j1);
                        Object obj2 = jsonobject.getJSONObject("address").toString();
                        obj2 = (CartAddress)MAPPER.fromJson(((String) (obj2)), com/ebay/common/model/cart/CartAddress);
                        if (jsonobject.has("cartAddressIdentifier"))
                        {
                            String s2 = jsonobject.getJSONObject("cartAddressIdentifier").getString("@type");
                            if ("BuyerShippingAddress".equals(s2))
                            {
                                obj2.addressType = "Shipping";
                            }
                            if (!cartAddresses.containsKey(s2))
                            {
                                jsonobject = new ArrayList();
                                cartAddresses.put(s2, jsonobject);
                            } else
                            {
                                jsonobject = (ArrayList)cartAddresses.get(s2);
                            }
                            jsonobject.add(((CartAddress) (obj2)).asAddress());
                        }
                        j1++;
                    }
                } else
                {
                    cartAddresses = null;
                }
            } else
            {
                cartAddresses = null;
            }
        } else
        {
            cartAddresses = null;
        }
        jsonobject = getObject(((JSONObject) (obj)), new String[] {
            "totalSummary"
        });
        total = getCurrencyAmount(jsonobject, "total");
        taxSubtotal = getCurrencyAmount(jsonobject, "taxSubtotal");
        logisticsSubtotal = getCurrencyAmount(jsonobject, "logisticsSubtotal");
        logisticsDiscountsSubtotal = getCurrencyAmount(jsonobject, "logisticsDiscountsSubtotal");
        priceSubtotal = getCurrencyAmount(jsonobject, "priceSubtotal");
        insuranceSubtotal = getCurrencyAmount(jsonobject, "insuranceSubtotal");
        otherFeesSubtotal = getCurrencyAmount(jsonobject, "otherFeesSubtotal");
        adjustmentsSubtotal = getCurrencyAmount(jsonobject, "adjustmentsSubtotal");
        handlingSubtotal = getCurrencyAmount(jsonobject, "handlingSubtotal");
        incentiveSubtotal = getCurrencyAmount(jsonobject, "incentiveTotal");
        savingsAmount = getCurrencyAmount(jsonobject, "savingsAmount");
        promotionSavingsTotal = getCurrencyAmount(jsonobject, "promotionSavingsTotal");
        if (((JSONObject) (obj)).has("purchaseId"))
        {
            jsonobject = new JSONObject(((JSONObject) (obj)).getString("purchaseId"));
            if (jsonobject.has("PurchaseOrderId"))
            {
                orderId = jsonobject.getString("PurchaseOrderId");
            } else
            {
                orderId = null;
            }
        } else
        {
            orderId = null;
        }
        for (jsonobject = lineItems.iterator(); jsonobject.hasNext();)
        {
            obj = ((LineItem)jsonobject.next()).incentives.iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                addOrMergeAppliedIncentiveToList((AppliedIncentive)((Iterator) (obj)).next());
            }
        }

        jsonobject = null;
        obj = lineItems.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            LineItem lineitem = (LineItem)((Iterator) (obj)).next();
            if (lineitem.isDonation())
            {
                if (jsonobject == null)
                {
                    jsonobject = lineitem.price;
                } else
                {
                    jsonobject = jsonobject.add(lineitem.price);
                }
            }
        } while (true);
        donationAmount = jsonobject;
        if (donationAmount != null && priceSubtotal != null)
        {
            priceSubtotal = priceSubtotal.subtract(donationAmount);
        }
_L4:
        setComputedCartFields();
        return;
_L2:
        cartId = null;
        updateVersion = null;
        orderId = null;
        logisticsDiscountsSubtotal = null;
        logisticsSubtotal = null;
        total = null;
        donationAmount = null;
        promotionSavingsTotal = null;
        savingsAmount = null;
        incentiveSubtotal = null;
        handlingSubtotal = null;
        adjustmentsSubtotal = null;
        otherFeesSubtotal = null;
        taxSubtotal = null;
        insuranceSubtotal = null;
        priceSubtotal = null;
        paymentInstrumentSelected = false;
        buyFailedAll = false;
        buyFailedPartial = false;
        buySucceeded = false;
        buyInitiated = false;
        cartAddresses = null;
        cartPaymentMethods = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void addOrMergeAppliedIncentiveToList(AppliedIncentive appliedincentive)
    {
        if (incentives.containsKey(appliedincentive.code))
        {
            AppliedIncentive appliedincentive1 = (AppliedIncentive)incentives.get(appliedincentive.code);
            appliedincentive.redeemedAmount = appliedincentive.redeemedAmount.add(appliedincentive1.redeemedAmount);
        }
        incentives.put(appliedincentive.code, appliedincentive);
    }

    private List getPickupAddressList()
    {
        if (cartAddresses != null)
        {
            return (List)cartAddresses.get("PickupAddress");
        } else
        {
            return null;
        }
    }

    private void setComputedCartFields()
    {
        Object obj4 = null;
        Object obj = null;
        CurrencyAmount currencyamount2 = null;
        CurrencyAmount currencyamount1 = null;
        Object obj2 = null;
        Object obj1 = null;
        Object obj3 = null;
        CurrencyAmount currencyamount = null;
        if (lineItems != null)
        {
            Iterator iterator = lineItems.iterator();
            do
            {
                obj2 = obj1;
                currencyamount2 = currencyamount1;
                obj3 = currencyamount;
                obj4 = obj;
                if (!iterator.hasNext())
                {
                    break;
                }
                obj2 = ((LineItem)iterator.next()).getSelectedLogisticsPlan();
                if (obj2 != null)
                {
                    obj3 = ((LogisticsPlans.LogisticsPlan) (obj2)).getSelectedPlanOption();
                    if (obj3 != null && ((LogisticsPlans.LogisticsPlan.PlanStep.PlanOption) (obj3)).totalCostWithSavings != null)
                    {
                        if (((LogisticsPlans.LogisticsPlan) (obj2)).isEbayNow())
                        {
                            currencyamount2 = ((LogisticsPlans.LogisticsPlan.PlanStep.PlanOption) (obj3)).totalCostWithSavings.getConvienceCharge();
                            obj2 = obj1;
                            if (currencyamount2 != null)
                            {
                                if (obj1 == null)
                                {
                                    obj2 = currencyamount2;
                                } else
                                {
                                    obj2 = ((CurrencyAmount) (obj1)).add(currencyamount2);
                                }
                            }
                            currencyamount2 = ((LogisticsPlans.LogisticsPlan.PlanStep.PlanOption) (obj3)).getLogisticsCost();
                            obj1 = obj2;
                            if (currencyamount2 != null)
                            {
                                if (currencyamount1 == null)
                                {
                                    currencyamount1 = currencyamount2;
                                    obj1 = obj2;
                                } else
                                {
                                    currencyamount1 = currencyamount1.add(currencyamount2);
                                    obj1 = obj2;
                                }
                            }
                        } else
                        if (((LogisticsPlans.LogisticsPlan) (obj2)).isShipToHome() || ((LogisticsPlans.LogisticsPlan) (obj2)).isGlobalShipping())
                        {
                            currencyamount2 = ((LogisticsPlans.LogisticsPlan.PlanStep.PlanOption) (obj3)).getLogisticsCost();
                            obj2 = obj;
                            if (currencyamount2 != null)
                            {
                                if (obj == null)
                                {
                                    obj2 = currencyamount2;
                                } else
                                {
                                    obj2 = ((CurrencyAmount) (obj)).add(currencyamount2);
                                }
                            }
                            currencyamount2 = ((LogisticsPlans.LogisticsPlan.PlanStep.PlanOption) (obj3)).totalCostWithSavings.getImportCharge();
                            obj = obj2;
                            if (currencyamount2 != null)
                            {
                                if (currencyamount == null)
                                {
                                    currencyamount = currencyamount2;
                                    obj = obj2;
                                } else
                                {
                                    currencyamount = currencyamount.add(currencyamount2);
                                    obj = obj2;
                                }
                            }
                        }
                    }
                }
            } while (true);
        }
        shippingSubtotal = ((CurrencyAmount) (obj4));
        deliverySubtotal = currencyamount2;
        convenienceCharge = ((CurrencyAmount) (obj2));
        importCharges = ((CurrencyAmount) (obj3));
    }

    public boolean areAllBopisItemsInStock()
    {
label0:
        {
            if (lineItems == null)
            {
                break label0;
            }
            Iterator iterator = lineItems.iterator();
            LineItem lineitem;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                lineitem = (LineItem)iterator.next();
            } while (!lineitem.isInStorePickupSelected() || lineitem.lineItemErrorCode == null);
            return false;
        }
        return true;
    }

    public boolean buyIndicatesCheckBackLater()
    {
        return buyInitiated && !buySucceeded && !buyFailedPartial && !buyFailedAll;
    }

    public boolean buyIndicatesPartialSuccess()
    {
        return buyInitiated && buyFailedPartial;
    }

    public boolean buyIndicatesSuccess()
    {
        return buyInitiated && buySucceeded && !buyFailedPartial && !buyFailedAll;
    }

    public boolean doesContainBopisItem()
    {
label0:
        {
            if (lineItems == null || lineItems.size() <= 0)
            {
                break label0;
            }
            Iterator iterator = lineItems.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!((LineItem)iterator.next()).isInStorePickupSelected());
            return true;
        }
        return false;
    }

    public boolean doesContainEbnItem()
    {
label0:
        {
            if (lineItems == null || lineItems.size() <= 0)
            {
                break label0;
            }
            Iterator iterator = lineItems.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!((LineItem)iterator.next()).isEbayNowSelected());
            return true;
        }
        return false;
    }

    public boolean doesContainPudoItem()
    {
        boolean flag1 = false;
        boolean flag = false;
        if (lineItems != null)
        {
            Iterator iterator = lineItems.iterator();
            do
            {
                flag1 = flag;
                if (!iterator.hasNext())
                {
                    break;
                }
                if (((LineItem)iterator.next()).isPickupAndDropoffSelected())
                {
                    flag = true;
                }
            } while (true);
        }
        return flag1;
    }

    public Set getAvailabilityIdentifiers(String s, String s1)
    {
        HashSet hashset = new HashSet();
        if (lineItems != null)
        {
            Iterator iterator = lineItems.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (LineItem)iterator.next();
                obj = ((LineItem) (obj)).getAvailabilityIdentifier(s, s1, getSellerUserIdFromLineItem(((LineItem) (obj)).cartLineItemId));
                if (obj != null)
                {
                    hashset.add(obj);
                }
            } while (true);
        }
        if (hashset.size() > 0)
        {
            return hashset;
        } else
        {
            return null;
        }
    }

    public Address getBuyerShippingAddress()
    {
        if (cartAddresses != null)
        {
            List list = (List)cartAddresses.get("BuyerShippingAddress");
            if (list != null && list.size() > 0)
            {
                return (Address)list.get(0);
            }
        }
        return null;
    }

    public List getDonationLineItems()
    {
        ArrayList arraylist = new ArrayList();
        if (lineItems != null)
        {
            Iterator iterator = lineItems.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                LineItem lineitem = (LineItem)iterator.next();
                if (lineitem.isDonation())
                {
                    arraylist.add(lineitem);
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

    public List getIncentives()
    {
        ArrayList arraylist = new ArrayList();
        String s;
        for (Iterator iterator = incentives.keySet().iterator(); iterator.hasNext(); arraylist.add(incentives.get(s)))
        {
            s = (String)iterator.next();
        }

        return arraylist;
    }

    public long[] getItemIds()
    {
        if (lineItems != null && !lineItems.isEmpty()) goto _L2; else goto _L1
_L1:
        long al[] = new long[0];
_L4:
        return al;
_L2:
        long al1[] = new long[lineItems.size()];
        int i = 0;
        do
        {
            al = al1;
            if (i >= al1.length)
            {
                continue;
            }
            LineItem lineitem = (LineItem)lineItems.get(i);
            if (lineitem.ebayItemId != null)
            {
                al1[i] = lineitem.ebayItemId.longValue();
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public LineItem getLineItemByCartLineItemId(String s)
    {
        for (Iterator iterator = lineItems.iterator(); iterator.hasNext();)
        {
            LineItem lineitem = (LineItem)iterator.next();
            if (lineitem.cartLineItemId.equals(s))
            {
                return lineitem;
            }
        }

        return null;
    }

    public Address getPickupAddressForStoreId(String s)
    {
        if (s == null)
        {
            return null;
        }
        Object obj = getPickupAddressList();
        if (obj == null)
        {
            return null;
        }
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            Address address = (Address)((Iterator) (obj)).next();
            if (s.equals(address.getPickupStoreId()))
            {
                return address;
            }
        }

        return null;
    }

    public String getSellerUserIdFromLineItem(String s)
    {
        Iterator iterator = sellers.keySet().iterator();
_L2:
        Object obj;
        Iterator iterator1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_91;
        }
        obj = (String)iterator.next();
        obj = (Seller)sellers.get(obj);
        iterator1 = ((Seller) (obj)).cartLineItemIds.iterator();
_L4:
        if (!iterator1.hasNext()) goto _L2; else goto _L1
_L1:
        if (!((String)iterator1.next()).equals(s)) goto _L4; else goto _L3
_L3:
        return ((Seller) (obj)).userIdentifier;
        return null;
    }

    public boolean hasDonation()
    {
        return donationAmount != null && donationAmount.isGreaterThanZero();
    }

    public boolean hasEbayBuyerGuarantee()
    {
        int j = 0;
        int i = 0;
        if (lineItems != null)
        {
            Iterator iterator = lineItems.iterator();
            do
            {
                j = i;
                if (!iterator.hasNext())
                {
                    break;
                }
                if (((LineItem)iterator.next()).hasEbayBuyerGuarantee())
                {
                    i++;
                }
            } while (true);
        }
        return j > 0 && lineItems.size() == j;
    }

    public boolean hasEbayNowAvailable()
    {
label0:
        {
            if (lineItems == null)
            {
                break label0;
            }
            Iterator iterator = lineItems.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!((LineItem)iterator.next()).isEbayNowAvailable());
            return true;
        }
        return false;
    }

    public boolean hasEbayNowDeliveryTimeSlots()
    {
label0:
        {
            if (lineItems == null)
            {
                break label0;
            }
            Iterator iterator = lineItems.iterator();
            LogisticsPlans.LogisticsPlan logisticsplan;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                logisticsplan = ((LineItem)iterator.next()).getSelectedLogisticsPlan();
            } while (logisticsplan == null || !logisticsplan.isEbayNow() || logisticsplan.getReservationToken() == null);
            return true;
        }
        return false;
    }

    public boolean hasEbayNowItem()
    {
label0:
        {
            if (lineItems == null)
            {
                break label0;
            }
            Iterator iterator = lineItems.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!((LineItem)iterator.next()).isEbayNowSelected());
            return true;
        }
        return false;
    }

    public boolean hasEbayPlusItem()
    {
label0:
        {
            if (lineItems == null)
            {
                break label0;
            }
            Iterator iterator = lineItems.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!((LineItem)iterator.next()).isEbayPlusSelected());
            return true;
        }
        return false;
    }

    public boolean hasFreeShipping()
    {
        return logisticsSubtotal != null && logisticsSubtotal.isZero();
    }

    public boolean hasOnlyPickupSelectedItems()
    {
label0:
        {
            if (lineItems == null)
            {
                break label0;
            }
            Iterator iterator = lineItems.iterator();
            LineItem lineitem;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                lineitem = (LineItem)iterator.next();
            } while (lineitem.isInStorePickupSelected() || lineitem.isPickupAndDropoffSelected());
            return false;
        }
        return true;
    }

    public boolean hasPudoItem()
    {
label0:
        {
            if (lineItems == null)
            {
                break label0;
            }
            Iterator iterator = lineItems.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!((LineItem)iterator.next()).isPickupAndDropoffSelected());
            return true;
        }
        return false;
    }

    public boolean hasTransactedItem()
    {
label0:
        {
            if (lineItems == null)
            {
                break label0;
            }
            Iterator iterator = lineItems.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!((LineItem)iterator.next()).isTransacted());
            return true;
        }
        return false;
    }

    public boolean isCopAvailable()
    {
label0:
        {
            if (isProx() && !hasEbayPlusItem())
            {
                return cartPaymentMethods.isPaymentMethodAvailable("CashOnPickup");
            }
            if (lineItems == null)
            {
                break label0;
            }
            Iterator iterator = lineItems.iterator();
            LineItem lineitem;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                lineitem = (LineItem)iterator.next();
            } while (lineitem.paymentMethods == null || !lineitem.paymentMethods.contains("CashOnPickup"));
            return true;
        }
        return false;
    }

    public boolean isCreditCardAvailable()
    {
        if (isProx())
        {
            return cartPaymentMethods.isPaymentMethodAvailable("CreditCard");
        } else
        {
            return false;
        }
    }

    public boolean isDirectDebitAvailable()
    {
        if (isProx())
        {
            return cartPaymentMethods.isPaymentMethodAvailable("DirectDebit");
        } else
        {
            return false;
        }
    }

    public boolean isEftAvailable()
    {
label0:
        {
            if (isProx() && !hasEbayPlusItem())
            {
                return cartPaymentMethods.isPaymentMethodAvailable("MoneyXferAcceptedInCheckout");
            }
            if (lineItems == null)
            {
                break label0;
            }
            Iterator iterator = lineItems.iterator();
            LineItem lineitem;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                lineitem = (LineItem)iterator.next();
            } while (lineitem.paymentMethods == null || !lineitem.paymentMethods.contains("MoneyXferAcceptedInCheckout"));
            return true;
        }
        return false;
    }

    public boolean isPayPalAvailable()
    {
label0:
        {
            if (isProx())
            {
                return cartPaymentMethods.isPaymentMethodAvailable("PayPal");
            }
            if (lineItems == null)
            {
                break label0;
            }
            Iterator iterator = lineItems.iterator();
            LineItem lineitem;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                lineitem = (LineItem)iterator.next();
            } while (lineitem.paymentMethods == null || !lineitem.paymentMethods.contains("PayPal"));
            return true;
        }
        return false;
    }

    public boolean isPaymentInstrumentSelected()
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (!isProx()) goto _L2; else goto _L1
_L1:
        if (!paymentInstrumentSelected) goto _L4; else goto _L3
_L3:
        flag = true;
_L2:
        return flag;
_L4:
        flag = flag1;
        if (cartPaymentMethods == null) goto _L2; else goto _L5
_L5:
        CartPaymentMethods.PaymentMethod paymentmethod;
        paymentmethod = cartPaymentMethods.getSelectedPaymentMethod();
        flag = flag1;
        if (paymentmethod == null) goto _L2; else goto _L6
_L6:
        if (!paymentmethod.isPayPal())
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!paymentmethod.hasSelectedFundingSource()) goto _L2; else goto _L7
_L7:
        return true;
    }

    public boolean isPhoneNumberRequired()
    {
label0:
        {
            if (lineItems == null)
            {
                break label0;
            }
            Iterator iterator = lineItems.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!((LineItem)iterator.next()).isPhoneNumberRequired());
            return true;
        }
        return false;
    }

    public boolean isProx()
    {
        return cartPaymentMethods != null && cartPaymentMethods.paymentMethodList != null && cartPaymentMethods.paymentMethodList.size() > 0;
    }

    public boolean isPuiAvailable()
    {
        if (isProx())
        {
            return cartPaymentMethods.isPaymentMethodAvailable("PayUponInvoice");
        } else
        {
            return false;
        }
    }

    public boolean isShippable(Address address)
    {
label0:
        {
            if (lineItems == null)
            {
                break label0;
            }
            Iterator iterator = lineItems.iterator();
            LineItem lineitem;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                lineitem = (LineItem)iterator.next();
            } while (lineitem.isShippable(address) || lineitem.isInStorePickupSelected());
            return false;
        }
        return true;
    }

    public boolean isTotalZero()
    {
        return total == null || total.isZero();
    }

    public int numberOfItems()
    {
        int j = 0;
        int i = 0;
        if (lineItems != null)
        {
            Iterator iterator = lineItems.iterator();
            do
            {
                j = i;
                if (!iterator.hasNext())
                {
                    break;
                }
                if (!((LineItem)iterator.next()).isDonation())
                {
                    i++;
                }
            } while (true);
        }
        return j;
    }

    public final void unselectPaymentMethod()
    {
        if (cartPaymentMethods != null)
        {
            cartPaymentMethods.unselectPaymentMethod();
        }
        paymentInstrumentSelected = false;
    }


}
