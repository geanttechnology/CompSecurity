// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.dnm;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DNMProduct
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private boolean availablemostflag;
    private double clearancePrice;
    private boolean comingsoonflag;
    private double currentPrice;
    private double customerRating;
    private double distance;
    private String dnmType;
    private String documentType;
    private String expressBuy;
    private boolean freeShipping;
    private String icrMapPriceValue;
    private String inStoreAvailMsg;
    private String instoreavailid;
    private boolean instorenaflag;
    private boolean instorenotavailflag;
    private boolean isICRPrice;
    private boolean isICRStrike;
    private String largeImageAlternateTag;
    private double largeImageHeight;
    private String largeImageURL;
    private double largeImageWidth;
    private double listPrice;
    private String lpn;
    private boolean mapFlag;
    private String mediumImageAlternateTag;
    private double msrp;
    private int noOfStoresItemAvlbl;
    private boolean notavailablilityflag;
    private String numberOfReviews;
    private boolean onSale;
    private boolean onlineOnly;
    private String openBoxCondition;
    private String openBoxDamageLocation;
    private String openBoxDamageType;
    private ArrayList openBoxMissingAccessories;
    private double openBoxRegularPrice;
    private String orderCode;
    private boolean preorderflag;
    private String priceEvent;
    private String productId;
    private double rebateAmt;
    private double regularPrice;
    private double saveAmt;
    private boolean shipsoldoutflag;
    private String shortDescription;
    private String skuDisplayable;
    private String skuId;
    private double skuPermRegPrice;
    private String skuShortLabel;
    private String skuTitle;
    private String skuType;
    private String skuTypeCode;
    private String smallImageAlternateTag;
    private double smallImageHeight;
    private String smallImageURL;
    private double smallImageWidth;
    private boolean specialOffers;
    private boolean specialOrderFlag;
    private String specialOrderHelpText;
    private String storeAddress1;
    private String storeAddress2;
    private String storeCity;
    private String storeId;
    private String storeLocation;
    private String storeMobileSpStoreInd;
    private String storeName;
    private String storePhoneNumber;
    private String storeState;
    private String storeZipCode;

    public DNMProduct()
    {
    }

    private static DNMProduct loadDNMProductData(JSONObject jsonobject)
    {
        DNMProduct dnmproduct;
        Object obj;
        Object obj1;
        int i = 0;
        dnmproduct = new DNMProduct();
        dnmproduct.inStoreAvailMsg = jsonobject.optString("inStoreAvailMsg");
        dnmproduct.lpn = jsonobject.optString("lpn");
        dnmproduct.orderCode = jsonobject.optString("orderCode");
        dnmproduct.storeMobileSpStoreInd = jsonobject.optString("storeMobileSpStoreInd");
        dnmproduct.largeImageURL = jsonobject.optString("largeImageURL");
        dnmproduct.skuType = jsonobject.optString("skuType");
        dnmproduct.skuTypeCode = jsonobject.optString("skuTypeCode");
        dnmproduct.storeCity = jsonobject.optString("storeCity");
        dnmproduct.storeAddress1 = jsonobject.optString("storeAddress1");
        dnmproduct.storeAddress2 = jsonobject.optString("storeAddress2");
        dnmproduct.shortDescription = jsonobject.optString("shortDescription");
        dnmproduct.openBoxDamageType = jsonobject.optString("openBoxDamageType");
        dnmproduct.openBoxDamageLocation = jsonobject.optString("openBoxDamageLocation");
        dnmproduct.distance = jsonobject.optInt("distance");
        dnmproduct.priceEvent = jsonobject.optString("priceEvent");
        dnmproduct.numberOfReviews = jsonobject.optString("numberOfReviews");
        dnmproduct.skuDisplayable = jsonobject.optString("skuDisplayable");
        dnmproduct.icrMapPriceValue = jsonobject.optString("icrMapPriceValue");
        dnmproduct.skuTitle = jsonobject.optString("skuTitle");
        dnmproduct.documentType = jsonobject.optString("documentType");
        dnmproduct.storePhoneNumber = jsonobject.optString("storePhoneNumber");
        dnmproduct.openBoxRegularPrice = jsonobject.optDouble("openBoxRegularPrice");
        dnmproduct.skuId = jsonobject.optString("skuId");
        dnmproduct.largeImageAlternateTag = jsonobject.optString("largeImageAlternateTag");
        dnmproduct.smallImageURL = jsonobject.optString("smallImageURL");
        dnmproduct.specialOffers = jsonobject.optBoolean("specialOffers");
        dnmproduct.specialOrderHelpText = jsonobject.optString("specialOrderHelpText");
        dnmproduct.storeId = jsonobject.optString("storeId");
        dnmproduct.storeState = jsonobject.optString("storeState");
        dnmproduct.instoreavailid = jsonobject.optString("instoreavailid");
        dnmproduct.dnmType = jsonobject.optString("dnmType");
        dnmproduct.onlineOnly = jsonobject.optBoolean("onlineOnly");
        dnmproduct.storeZipCode = jsonobject.optString("storeZipCode");
        dnmproduct.storeLocation = jsonobject.optString("storeLocation");
        dnmproduct.skuShortLabel = jsonobject.optString("skuShortLabel");
        dnmproduct.storeName = jsonobject.optString("storeName");
        dnmproduct.expressBuy = jsonobject.optString("expressBuy");
        dnmproduct.openBoxCondition = jsonobject.optString("openBoxCondition");
        dnmproduct.onSale = jsonobject.optBoolean("onSale");
        dnmproduct.productId = jsonobject.optString("productId");
        dnmproduct.smallImageAlternateTag = jsonobject.optString("smallImageAlternateTag");
        dnmproduct.noOfStoresItemAvlbl = jsonobject.optInt("noOfStoresItemAvlbl");
        if (jsonobject.optJSONArray("openBoxMissingAccessories") != null)
        {
            dnmproduct.openBoxMissingAccessories = new ArrayList();
            while (i < jsonobject.optJSONArray("openBoxMissingAccessories").length()) 
            {
                try
                {
                    dnmproduct.openBoxMissingAccessories.add(jsonobject.optJSONArray("openBoxMissingAccessories").getString(i));
                }
                catch (JSONException jsonexception)
                {
                    jsonexception.printStackTrace();
                }
                i++;
            }
        }
        if (jsonobject.optString("comingsoonflag") != null && !jsonobject.optString("comingsoonflag").isEmpty())
        {
            dnmproduct.comingsoonflag = Boolean.valueOf(jsonobject.optString("comingsoonflag")).booleanValue();
        }
        if (jsonobject.optString("instorenaflag") != null && !jsonobject.optString("instorenaflag").isEmpty())
        {
            dnmproduct.instorenaflag = Boolean.valueOf(jsonobject.optString("instorenaflag")).booleanValue();
        }
        if (jsonobject.optString("shipsoldoutflag") != null && !jsonobject.optString("shipsoldoutflag").isEmpty())
        {
            dnmproduct.shipsoldoutflag = Boolean.valueOf(jsonobject.optString("shipsoldoutflag")).booleanValue();
        }
        if (jsonobject.optString("notavailablilityflag") != null && !jsonobject.optString("notavailablilityflag").isEmpty())
        {
            dnmproduct.notavailablilityflag = Boolean.valueOf(jsonobject.optString("notavailablilityflag")).booleanValue();
        }
        if (jsonobject.optString("freeShipping") != null && !jsonobject.optString("freeShipping").isEmpty())
        {
            dnmproduct.freeShipping = Boolean.valueOf(jsonobject.optString("freeShipping")).booleanValue();
        }
        if (jsonobject.optString("specialOrderFlag") != null && !jsonobject.optString("specialOrderFlag").isEmpty())
        {
            dnmproduct.specialOrderFlag = Boolean.valueOf(jsonobject.optString("specialOrderFlag")).booleanValue();
        }
        if (jsonobject.optString("availablemostflag") != null && !jsonobject.optString("availablemostflag").isEmpty())
        {
            dnmproduct.availablemostflag = Boolean.valueOf(jsonobject.optString("availablemostflag")).booleanValue();
        }
        if (jsonobject.optString("instorenotavailflag") != null && !jsonobject.optString("instorenotavailflag").isEmpty())
        {
            dnmproduct.instorenotavailflag = Boolean.valueOf(jsonobject.optString("instorenotavailflag")).booleanValue();
        }
        if (jsonobject.optString("mapFlag") != null && !jsonobject.optString("mapFlag").isEmpty())
        {
            dnmproduct.mapFlag = Boolean.valueOf(jsonobject.optString("mapFlag")).booleanValue();
        }
        if (jsonobject.optString("preorderflag") != null && !jsonobject.optString("preorderflag").isEmpty())
        {
            dnmproduct.preorderflag = Boolean.valueOf(jsonobject.optString("preorderflag")).booleanValue();
        }
        if (jsonobject.optString("saveAmt") != null && !jsonobject.optString("saveAmt").isEmpty())
        {
            dnmproduct.saveAmt = Double.parseDouble(jsonobject.optString("saveAmt"));
        }
        if (jsonobject.optString("clearancePrice") != null && !jsonobject.optString("clearancePrice").isEmpty())
        {
            dnmproduct.clearancePrice = Double.parseDouble(jsonobject.optString("clearancePrice"));
        }
        if (jsonobject.optString("skuPermRegPrice") != null && !jsonobject.optString("skuPermRegPrice").isEmpty())
        {
            dnmproduct.skuPermRegPrice = Double.parseDouble(jsonobject.optString("skuPermRegPrice"));
        }
        if (jsonobject.optString("msrp") != null && !jsonobject.optString("msrp").isEmpty())
        {
            dnmproduct.msrp = Double.parseDouble(jsonobject.optString("msrp"));
        }
        if (jsonobject.optString("largeImageWidth") != null && !jsonobject.optString("largeImageWidth").isEmpty())
        {
            dnmproduct.largeImageWidth = Double.parseDouble(jsonobject.optString("largeImageWidth"));
        }
        if (jsonobject.optString("smallImageWidth") != null && !jsonobject.optString("smallImageWidth").isEmpty())
        {
            dnmproduct.smallImageWidth = Double.parseDouble(jsonobject.optString("smallImageWidth"));
        }
        if (jsonobject.optString("listPrice") != null && !jsonobject.optString("listPrice").isEmpty())
        {
            dnmproduct.listPrice = Double.parseDouble(jsonobject.optString("listPrice"));
        }
        if (jsonobject.optString("customerRating") != null && !jsonobject.optString("customerRating").isEmpty())
        {
            dnmproduct.customerRating = Double.parseDouble(jsonobject.optString("customerRating"));
        }
        if (jsonobject.optString("regularPrice") != null && !jsonobject.optString("regularPrice").isEmpty())
        {
            dnmproduct.regularPrice = Double.parseDouble(jsonobject.optString("regularPrice"));
        }
        if (jsonobject.optString("largeImageHeight") != null && !jsonobject.optString("largeImageHeight").isEmpty())
        {
            dnmproduct.largeImageHeight = Double.parseDouble(jsonobject.optString("largeImageHeight"));
        }
        if (jsonobject.optString("smallImageHeight") != null && !jsonobject.optString("smallImageHeight").isEmpty())
        {
            dnmproduct.smallImageHeight = Double.parseDouble(jsonobject.optString("smallImageHeight"));
        }
        if (jsonobject.optString("currentPrice") != null && !jsonobject.optString("currentPrice").isEmpty())
        {
            dnmproduct.currentPrice = Double.parseDouble(jsonobject.optString("currentPrice"));
        }
        obj = jsonobject.optString("icrMapPriceStartDate");
        obj1 = jsonobject.optString("icrMapPriceEndDate");
        if (!dnmproduct.icrMapPriceValue.equals("1") || obj == null || obj1 == null || ((String) (obj)).equals("null") || ((String) (obj1)).equals("null")) goto _L2; else goto _L1
_L1:
        dnmproduct.isICRPrice = true;
_L4:
        if (obj != null && obj1 != null && !((String) (obj)).equals("null") && !((String) (obj1)).equals("null"))
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            try
            {
                jsonobject = simpledateformat.parse(((String) (obj)));
                obj = simpledateformat.parse(((String) (obj1)));
                obj1 = new Date();
                if (((Date) (obj1)).after(((Date) (obj))) || ((Date) (obj1)).before(jsonobject))
                {
                    dnmproduct.isICRPrice = false;
                    dnmproduct.isICRStrike = false;
                    dnmproduct.mapFlag = false;
                }
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                jsonobject.printStackTrace();
                return dnmproduct;
            }
        }
        return dnmproduct;
_L2:
        if (dnmproduct.icrMapPriceValue.equals("2") && obj != null && obj1 != null && !((String) (obj)).equals("null") && !((String) (obj1)).equals("null"))
        {
            dnmproduct.isICRStrike = true;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static ArrayList loadDNMProducts(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            JSONObject jsonobject = jsonarray.optJSONObject(i);
            if (jsonobject != null)
            {
                arraylist.add(loadDNMProductData(jsonobject));
            }
        }

        return arraylist;
    }

    public double getClearancePrice()
    {
        return clearancePrice;
    }

    public double getCurrentPrice()
    {
        return currentPrice;
    }

    public double getCustomerRating()
    {
        return customerRating;
    }

    public double getDistance()
    {
        return distance;
    }

    public String getDnmType()
    {
        return dnmType;
    }

    public String getDocumentType()
    {
        return documentType;
    }

    public String getExpressBuy()
    {
        return expressBuy;
    }

    public String getIcrMapPriceValue()
    {
        return icrMapPriceValue;
    }

    public String getInStoreAvailMsg()
    {
        return inStoreAvailMsg;
    }

    public String getInstoreavailid()
    {
        return instoreavailid;
    }

    public String getLargeImageAlternateTag()
    {
        return largeImageAlternateTag;
    }

    public double getLargeImageHeight()
    {
        return largeImageHeight;
    }

    public String getLargeImageURL()
    {
        return largeImageURL;
    }

    public double getLargeImageWidth()
    {
        return largeImageWidth;
    }

    public double getListPrice()
    {
        return listPrice;
    }

    public String getLpn()
    {
        return lpn;
    }

    public String getMediumImageAlternateTag()
    {
        return mediumImageAlternateTag;
    }

    public double getMsrp()
    {
        return msrp;
    }

    public int getNoOfStoresItemAvlbl()
    {
        return noOfStoresItemAvlbl;
    }

    public String getNumberOfReviews()
    {
        return numberOfReviews;
    }

    public String getOpenBoxCondition()
    {
        return openBoxCondition;
    }

    public String getOpenBoxDamageLocation()
    {
        return openBoxDamageLocation;
    }

    public String getOpenBoxDamageType()
    {
        return openBoxDamageType;
    }

    public ArrayList getOpenBoxMissingAccessories()
    {
        return openBoxMissingAccessories;
    }

    public double getOpenBoxRegularPrice()
    {
        return openBoxRegularPrice;
    }

    public String getOrderCode()
    {
        return orderCode;
    }

    public String getPriceEvent()
    {
        return priceEvent;
    }

    public String getProductId()
    {
        return productId;
    }

    public double getRebateAmt()
    {
        return rebateAmt;
    }

    public double getRegularPrice()
    {
        return regularPrice;
    }

    public double getSaveAmt()
    {
        return saveAmt;
    }

    public String getShortDescription()
    {
        return shortDescription;
    }

    public String getSkuDisplayable()
    {
        return skuDisplayable;
    }

    public String getSkuId()
    {
        return skuId;
    }

    public double getSkuPermRegPrice()
    {
        return skuPermRegPrice;
    }

    public String getSkuShortLabel()
    {
        return skuShortLabel;
    }

    public String getSkuTitle()
    {
        return skuTitle;
    }

    public String getSkuType()
    {
        return skuType;
    }

    public String getSkuTypeCode()
    {
        return skuTypeCode;
    }

    public String getSmallImageAlternateTag()
    {
        return smallImageAlternateTag;
    }

    public double getSmallImageHeight()
    {
        return smallImageHeight;
    }

    public String getSmallImageURL()
    {
        return smallImageURL;
    }

    public double getSmallImageWidth()
    {
        return smallImageWidth;
    }

    public String getSpecialOrderHelpText()
    {
        return specialOrderHelpText;
    }

    public String getStoreAddress1()
    {
        return storeAddress1;
    }

    public String getStoreAddress2()
    {
        return storeAddress2;
    }

    public String getStoreCity()
    {
        return storeCity;
    }

    public String getStoreId()
    {
        return storeId;
    }

    public String getStoreLocation()
    {
        return storeLocation;
    }

    public String getStoreMobileSpStoreInd()
    {
        return storeMobileSpStoreInd;
    }

    public String getStoreName()
    {
        return storeName;
    }

    public String getStorePhoneNumber()
    {
        return storePhoneNumber;
    }

    public String getStoreState()
    {
        return storeState;
    }

    public String getStoreZipCode()
    {
        return storeZipCode;
    }

    public boolean isAvailablemostflag()
    {
        return availablemostflag;
    }

    public boolean isComingsoonflag()
    {
        return comingsoonflag;
    }

    public boolean isFreeShipping()
    {
        return freeShipping;
    }

    public boolean isICRPrice()
    {
        return isICRPrice;
    }

    public boolean isICRStrike()
    {
        return isICRStrike;
    }

    public boolean isInstorenaflag()
    {
        return instorenaflag;
    }

    public boolean isInstorenotavailflag()
    {
        return instorenotavailflag;
    }

    public boolean isMapFlag()
    {
        return mapFlag;
    }

    public boolean isNotavailablilityflag()
    {
        return notavailablilityflag;
    }

    public boolean isOnSale()
    {
        return onSale;
    }

    public boolean isOnlineOnly()
    {
        return onlineOnly;
    }

    public boolean isPreorderflag()
    {
        return preorderflag;
    }

    public boolean isShipsoldoutflag()
    {
        return shipsoldoutflag;
    }

    public boolean isSpecialOffers()
    {
        return specialOffers;
    }

    public boolean isSpecialOrderFlag()
    {
        return specialOrderFlag;
    }
}
