// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.product;

import android.text.Html;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

public class Availability
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private boolean availabilityForPickup;
    private boolean availableToDeliver;
    private boolean availableToDownload;
    private boolean availableToShip;
    private String checkStoresLink;
    private String deliveryDisplayMessage;
    private String deliveryURL;
    private String downloadDisplayMessage;
    private boolean energyStarCompatible;
    private int height;
    private String inStoreAvailabilityUpdateDate;
    private boolean inStoreOnly;
    private boolean inStoreOnlyOption;
    private boolean isDeliveryAnOption;
    private boolean isDownloadAnOption;
    private boolean isPickupAnOption;
    private boolean isPickupJsonFound;
    private boolean isShipAnOption;
    private String longStoreName;
    private boolean lowPriceGuaranteedProduct;
    private String pickupDisplayMessage;
    private String pickupMessage;
    private String productType;
    private String seller;
    private String shipDisplayMessage;
    private String shippingUrl;
    private String shortName;
    private boolean signatureRequired;
    private String sku;
    private boolean smartCapable;
    private boolean specialOrderDelivery;
    private String storeName;
    private String target;
    private String url;
    private boolean wallMountable;
    private int width;

    public Availability()
    {
        seller = "";
        productType = "";
        shortName = "";
        sku = "";
        url = "";
        isPickupAnOption = false;
        availabilityForPickup = false;
        pickupMessage = "";
        storeName = "";
        checkStoresLink = "";
        pickupDisplayMessage = "";
        longStoreName = "";
        inStoreAvailabilityUpdateDate = "";
        isPickupJsonFound = true;
        inStoreOnlyOption = false;
        isShipAnOption = false;
        width = 0;
        height = 0;
        target = "";
        shippingUrl = "";
        availableToShip = false;
        shipDisplayMessage = "";
        signatureRequired = false;
        isDeliveryAnOption = false;
        deliveryURL = "";
        availableToDeliver = false;
        deliveryDisplayMessage = "";
        isDownloadAnOption = false;
        availableToDownload = false;
        downloadDisplayMessage = "";
        wallMountable = false;
        lowPriceGuaranteedProduct = false;
        smartCapable = false;
        energyStarCompatible = false;
        specialOrderDelivery = false;
        inStoreOnly = false;
    }

    public static Availability loadAvailabilityData(JSONObject jsonobject)
    {
        Availability availability = new Availability();
        if (jsonobject.optJSONObject("sku") != null)
        {
            JSONObject jsonobject1 = jsonobject.optJSONObject("sku");
            availability.productType = jsonobject1.optString("productType");
            availability.sku = jsonobject1.optString("skuId");
            if (jsonobject1.optJSONObject("availability") != null)
            {
                JSONObject jsonobject2 = jsonobject1.optJSONObject("availability");
                if (jsonobject2.optJSONObject("pickup") != null)
                {
                    availability.isPickupAnOption = true;
                    JSONObject jsonobject3 = jsonobject2.optJSONObject("pickup");
                    availability.availabilityForPickup = jsonobject3.optBoolean("available");
                    availability.pickupDisplayMessage = jsonobject3.optString("displayMessage");
                    if (availability.pickupDisplayMessage.equals("<b>Store Pickup:</b>"))
                    {
                        availability.pickupDisplayMessage = Html.fromHtml(availability.pickupDisplayMessage).toString();
                    }
                    if (jsonobject3.optJSONObject("checkStoresLink") != null)
                    {
                        availability.url = jsonobject3.optJSONObject("checkStoresLink").optString("url");
                    }
                    if (jsonobject3.optJSONObject("inStoreAvailability") != null)
                    {
                        jsonobject3 = jsonobject3.optJSONObject("inStoreAvailability");
                        availability.pickupMessage = jsonobject3.optString("pickupMessage");
                        availability.storeName = jsonobject3.optString("storeName");
                    }
                } else
                {
                    availability.isPickupJsonFound = false;
                }
                if (jsonobject2.optJSONObject("inStoreOnly") != null)
                {
                    availability.inStoreOnlyOption = true;
                    JSONObject jsonobject4 = jsonobject2.optJSONObject("inStoreOnly");
                    availability.inStoreOnlyOption = jsonobject4.optBoolean("available");
                    JSONObject jsonobject5 = jsonobject2.optJSONObject("pickup");
                    if (jsonobject5 != null)
                    {
                        availability.availabilityForPickup = jsonobject5.optBoolean("available");
                    }
                    if (jsonobject4.optJSONObject("checkStoresLink") != null)
                    {
                        availability.url = jsonobject4.optJSONObject("checkStoresLink").optString("url");
                    }
                    if (jsonobject4.optJSONObject("inStoreAvailability") != null)
                    {
                        jsonobject4 = jsonobject4.optJSONObject("inStoreAvailability");
                        availability.pickupMessage = jsonobject4.optString("pickupMessage");
                        availability.storeName = jsonobject4.optString("storeName");
                    }
                }
                if (jsonobject2.optJSONObject("ship") != null)
                {
                    availability.isShipAnOption = true;
                    Object obj = jsonobject2.optJSONObject("ship");
                    if (((JSONObject) (obj)).optJSONObject("checkLink") != null)
                    {
                        JSONObject jsonobject6 = ((JSONObject) (obj)).optJSONObject("checkLink");
                        availability.width = jsonobject6.optInt("width");
                        availability.height = jsonobject6.optInt("height");
                        availability.target = jsonobject6.optString("target");
                        availability.shippingUrl = jsonobject6.optString("url");
                    }
                    availability.availableToShip = ((JSONObject) (obj)).optBoolean("available");
                    availability.signatureRequired = ((JSONObject) (obj)).optBoolean("signatureRequired");
                    availability.shipDisplayMessage = ((JSONObject) (obj)).optString("displayMessage");
                    if (!availability.shipDisplayMessage.isEmpty())
                    {
                        if (availability.shipDisplayMessage.contains("<b>Shipping:</b> "))
                        {
                            availability.shipDisplayMessage = availability.shipDisplayMessage.replace("<b>Shipping:</b> ", "");
                        } else
                        if (availability.shipDisplayMessage.contains("<b>Shipping</b>: "))
                        {
                            availability.shipDisplayMessage = availability.shipDisplayMessage.replace("<b>Shipping</b>: ", "");
                        } else
                        {
                            availability.shipDisplayMessage = availability.shipDisplayMessage.replace("Shipping:", "");
                        }
                    }
                }
                if (jsonobject2.optJSONObject("stores") != null)
                {
                    obj = jsonobject2.optJSONArray("stores");
                    if (((JSONArray) (obj)).get(0) instanceof JSONObject)
                    {
                        obj = (JSONObject)((JSONArray) (obj)).get(0);
                        availability.longStoreName = ((JSONObject) (obj)).optString("longName");
                        obj = ((JSONObject) (obj)).optJSONArray("products");
                        if (((JSONArray) (obj)).get(0) instanceof JSONObject)
                        {
                            availability.inStoreAvailabilityUpdateDate = ((JSONObject)((JSONArray) (obj)).get(0)).optString("inStoreAvailabilityUpdateDate");
                        }
                    }
                }
                if (jsonobject2.optJSONObject("delivery") != null)
                {
                    availability.isDeliveryAnOption = true;
                    obj = jsonobject2.optJSONObject("delivery");
                    if (((JSONObject) (obj)).optJSONObject("checkLink") != null)
                    {
                        availability.deliveryURL = ((JSONObject) (obj)).optJSONObject("checkLink").optString("url");
                    }
                    availability.availableToDeliver = ((JSONObject) (obj)).optBoolean("available");
                    availability.deliveryDisplayMessage = ((JSONObject) (obj)).optString("displayMessage");
                }
                if (jsonobject2.optJSONObject("download") != null)
                {
                    availability.isDownloadAnOption = true;
                    jsonobject2 = jsonobject2.optJSONObject("download");
                    availability.availableToDownload = jsonobject2.optBoolean("available");
                    availability.downloadDisplayMessage = jsonobject2.optString("displayMessage", "");
                    if (!availability.downloadDisplayMessage.isEmpty())
                    {
                        availability.downloadDisplayMessage = availability.downloadDisplayMessage.replace("<b>Download:</b> ", "");
                    }
                }
            }
            if (jsonobject1.optJSONObject("names") != null)
            {
                availability.shortName = jsonobject.optString("short");
            }
            if (jsonobject1.optJSONObject("sellerInfo") != null)
            {
                availability.seller = jsonobject.optString("seller");
            }
            if (jsonobject1.optJSONObject("attributes") != null)
            {
                jsonobject = jsonobject1.optJSONObject("attributes");
                availability.wallMountable = jsonobject.optBoolean("wallMountable");
                availability.lowPriceGuaranteedProduct = jsonobject.optBoolean("lowPriceGuaranteedProduct");
                availability.smartCapable = jsonobject.optBoolean("smartCapable");
                availability.energyStarCompatible = jsonobject.optBoolean("energyStarCompatible");
                availability.specialOrderDelivery = jsonobject.optBoolean("specialOrderDelivery");
            }
        }
        return availability;
    }

    public String getCheckStoresLink()
    {
        return checkStoresLink;
    }

    public String getDeliveryDisplayMessage()
    {
        return deliveryDisplayMessage;
    }

    public String getDeliveryURL()
    {
        return deliveryURL;
    }

    public String getDownloadDisplayMessage()
    {
        return downloadDisplayMessage;
    }

    public int getHeight()
    {
        return height;
    }

    public String getInStoreAvailabilityUpdateDate()
    {
        return inStoreAvailabilityUpdateDate;
    }

    public String getLongStoreName()
    {
        return longStoreName;
    }

    public String getPickupDisplayMessage()
    {
        return pickupDisplayMessage;
    }

    public String getPickupMessage()
    {
        return pickupMessage;
    }

    public String getProductType()
    {
        return productType;
    }

    public String getSeller()
    {
        return seller;
    }

    public String getShipDisplayMessage()
    {
        return shipDisplayMessage;
    }

    public String getShippingUrl()
    {
        return shippingUrl;
    }

    public String getShortName()
    {
        return shortName;
    }

    public String getSku()
    {
        return sku;
    }

    public String getStoreName()
    {
        return storeName;
    }

    public String getTarget()
    {
        return target;
    }

    public String getUrl()
    {
        return url;
    }

    public int getWidth()
    {
        return width;
    }

    public boolean isAvailabilityForPickup()
    {
        return availabilityForPickup;
    }

    public boolean isAvailableToDeliver()
    {
        return availableToDeliver;
    }

    public boolean isAvailableToDownload()
    {
        return availableToDownload;
    }

    public boolean isAvailableToShip()
    {
        return availableToShip;
    }

    public boolean isDeliveryAnOption()
    {
        return isDeliveryAnOption;
    }

    public boolean isDownloadAnOption()
    {
        return isDownloadAnOption;
    }

    public boolean isEnergyStarCompatible()
    {
        return energyStarCompatible;
    }

    public boolean isInStoreOnly()
    {
        return inStoreOnly;
    }

    public boolean isInStoreOnlyOption()
    {
        return inStoreOnlyOption;
    }

    public boolean isLowPriceGuaranteedProduct()
    {
        return lowPriceGuaranteedProduct;
    }

    public boolean isPickupAnOption()
    {
        return isPickupAnOption;
    }

    public boolean isPickupJsonFound()
    {
        return isPickupJsonFound;
    }

    public boolean isShipAnOption()
    {
        return isShipAnOption;
    }

    public boolean isSignatureRequired()
    {
        return signatureRequired;
    }

    public boolean isSmartCapable()
    {
        return smartCapable;
    }

    public boolean isSpecialOrderDelivery()
    {
        return specialOrderDelivery;
    }

    public boolean isWallMountable()
    {
        return wallMountable;
    }
}
