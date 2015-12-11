// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.offers;

import android.text.Html;
import android.util.Log;
import com.bestbuy.android.api.lib.models.product.Product;
import gv;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class Offer extends Product
    implements Serializable
{

    public static final String CATEGORY_PATH_KEYS = "category_path_keys";
    public static final String CHANNEL_KEYS = "channel_keys";
    public static final String END_DATE = "end";
    public static final String GAMING_CHANNEL = "bby-mobile-game-tradein";
    public static final String IMAGE_URL = "image_url";
    public static final String KEY = "key";
    public static final String REMIX_DATA = "remix_data";
    private static final String TAG = com/bestbuy/android/api/lib/models/offers/Offer.getSimpleName();
    private static final long serialVersionUID = 0x67bc3d213e4a3ff1L;
    private Date beginDate;
    private String categoryId;
    private ArrayList categoryPathKeys;
    private ArrayList channelKeys;
    private String couponCode;
    private ArrayList couponSkus;
    private Date created;
    private Date endDate;
    private String imageUrl;
    private boolean inStoreOnly;
    private double insertPageNumber;
    private String key;
    private String legal;
    private String legalCopy;
    private int localImageUrl;
    private String manufacturer;
    private String marketingCopy;
    private String modified;
    private String offersDescription;
    private String price;
    private double priority;
    private String productKey;
    private String promoSlot;
    private String regularPrice;
    private String remixDataString;
    private ArrayList rzLevels;
    private String searchFacet;
    private String shortMarketingCopy;
    private ArrayList skus;
    private String title;
    private String url;

    public Offer()
    {
        productKey = "";
    }

    public static ArrayList loadData(JSONArray jsonarray)
    {
        int j = 1;
        ArrayList arraylist = new ArrayList();
        Object obj;
        Offer offer;
        Object obj1;
        Exception exception;
        int i;
        if (jsonarray != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (jsonarray.length() <= 0)
        {
            j = 0;
        }
        if (!((i & j) != 0)) goto _L2; else goto _L1
_L1:
        i = 0;
_L10:
        if (i >= jsonarray.length()) goto _L2; else goto _L3
_L3:
        obj = jsonarray.getJSONObject(i);
        offer = new Offer();
        offer.inStoreOnly = ((JSONObject) (obj)).optBoolean("in_store_only");
        obj1 = ((JSONObject) (obj)).optString("begin");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        if (((String) (obj1)).compareTo("") != 0)
        {
            offer.beginDate = gv.a.parse(((String) (obj1)));
        }
        obj1 = ((JSONObject) (obj)).optString("end");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        if (((String) (obj1)).compareTo("") != 0)
        {
            offer.endDate = gv.a.parse(((String) (obj1)));
        }
_L7:
        offer.title = ((JSONObject) (obj)).optString("title");
        obj1 = ((JSONObject) (obj)).optJSONArray("skus");
        if (obj1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (((JSONArray) (obj1)).length() <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        offer.skus = new ArrayList();
        j = 0;
_L5:
        if (j >= ((JSONArray) (obj1)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        offer.skus.add(((JSONArray) (obj1)).get(j).toString());
        j++;
        if (true) goto _L5; else goto _L4
_L4:
        break; /* Loop/switch isn't completed */
        exception;
        Log.w(TAG, (new StringBuilder()).append("Could not parse date fields: ").append(exception.getLocalizedMessage()).toString());
        if (true) goto _L7; else goto _L6
_L8:
        i++;
        continue; /* Loop/switch isn't completed */
_L6:
        try
        {
            offer.key = ((JSONObject) (obj)).optString("key");
            offer.manufacturer = ((JSONObject) (obj)).optString("manufacturer");
            offer.imageUrl = ((JSONObject) (obj)).optString("image_url");
            offer.promoSlot = ((JSONObject) (obj)).optString("promo_slot");
            offer.priority = ((JSONObject) (obj)).optDouble("priority");
            offer.searchFacet = ((JSONObject) (obj)).optString("search_facet");
            offer.categoryId = ((JSONObject) (obj)).optString("category_id");
            arraylist.add(offer);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.w(TAG, (new StringBuilder()).append("Error parsing Offer, skipping offer: ").append(((Exception) (obj)).getLocalizedMessage()).toString());
        }
        if (true) goto _L8; else goto _L2
_L2:
        return arraylist;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static ArrayList loadOffersData(String s)
    {
        int j = 1;
        ArrayList arraylist = new ArrayList();
        s = (new JSONObject(s)).getJSONObject("data").getJSONArray("offers");
        int i;
        if (s != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (s.length() <= 0)
        {
            j = 0;
        }
        if ((i & j) != 0)
        {
            for (i = 0; i < s.length(); i++)
            {
                Object obj = s.getJSONObject(i);
                Offer offer = new Offer();
                offer.skus = new ArrayList();
                Object obj1 = ((JSONObject) (obj)).getJSONArray("skus");
                for (j = 0; j < ((JSONArray) (obj1)).length(); j++)
                {
                    offer.skus.add(((JSONArray) (obj1)).getString(i));
                }

                obj1 = ((JSONObject) (obj)).optJSONArray("category_path_keys");
                offer.categoryPathKeys = new ArrayList();
                if (obj1 != null)
                {
                    for (int k = 0; k < ((JSONArray) (obj1)).length(); k++)
                    {
                        offer.categoryPathKeys.add((String)((JSONArray) (obj1)).opt(i));
                    }

                }
                obj1 = ((JSONObject) (obj)).optJSONArray("channel_keys");
                offer.channelKeys = new ArrayList();
                if (obj1 != null)
                {
                    for (int l = 0; l < ((JSONArray) (obj1)).length(); l++)
                    {
                        offer.channelKeys.add((String)((JSONArray) (obj1)).opt(i));
                    }

                }
                obj1 = ((JSONObject) (obj)).optJSONObject("remix_data");
                if (obj1 != null)
                {
                    offer.remixDataString = ((JSONObject) (obj1)).toString();
                    loadBBYOpenData(new JSONObject(offer.remixDataString));
                    if (offer.skus.size() == 0)
                    {
                        offer.skus.add(((JSONObject) (obj1)).getString("sku"));
                    }
                    offer.customerReviewAverage = ((JSONObject) (obj1)).getDouble("customerReviewAverage");
                }
                com.bestbuy.android.api.lib.models.product.Product.ProductImages.loadImageData(((JSONObject) (obj)));
                offer.imageUrl = ((JSONObject) (obj)).optString("image_url");
                offer.productKey = ((JSONObject) (obj)).optString("key", "");
                offer.title = ((JSONObject) (obj)).optString("title", "No title for this offer.");
                offer.url = ((JSONObject) (obj)).optString("url", "null");
                offer.title = replaceXMLCharacters(offer.title);
                offer.price = ((JSONObject) (obj)).optString("price", "0.0");
                obj1 = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                String s1 = ((JSONObject) (obj)).optString("end");
                if (!s1.equalsIgnoreCase(""))
                {
                    offer.endDate = ((SimpleDateFormat) (obj1)).parse(s1);
                }
                if (offer.price.equals("null"))
                {
                    offer.price = "0.0";
                }
                obj = ((JSONObject) (obj)).optJSONArray("rz_levels");
                offer.rzLevels = new ArrayList();
                if (obj != null && ((JSONArray) (obj)).length() > 0)
                {
                    for (int i1 = 0; i1 < ((JSONArray) (obj)).length(); i1++)
                    {
                        offer.rzLevels.add(((JSONArray) (obj)).getString(i));
                    }

                }
                arraylist.add(offer);
            }

        }
        return arraylist;
    }

    public static String replaceXMLCharacters(String s)
    {
        String s1 = s;
        if (s != null)
        {
            s1 = Html.fromHtml(s).toString();
        }
        return s1;
    }

    public boolean equals(Object obj)
    {
        if (obj != null)
        {
            if (obj == this)
            {
                return true;
            }
            if (obj.getClass() == getClass())
            {
                obj = (Offer)obj;
                if (title != null && hashCode() == ((Offer) (obj)).hashCode())
                {
                    return true;
                }
            }
        }
        return false;
    }

    public Date getBeginDate()
    {
        return beginDate;
    }

    public String getCategoryId()
    {
        return categoryId;
    }

    public ArrayList getCategoryPathKeys()
    {
        return categoryPathKeys;
    }

    public ArrayList getChannelKeys()
    {
        return channelKeys;
    }

    public String getCouponCode()
    {
        return couponCode;
    }

    public ArrayList getCouponSkus()
    {
        return couponSkus;
    }

    public Date getCreated()
    {
        return created;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public double getInsertPageNumber()
    {
        return insertPageNumber;
    }

    public String getKey()
    {
        return key;
    }

    public String getLegal()
    {
        return legal;
    }

    public String getLegalCopy()
    {
        return legalCopy;
    }

    public int getLocalImageUrl()
    {
        return localImageUrl;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public String getMarketingCopy()
    {
        return marketingCopy;
    }

    public String getModified()
    {
        return modified;
    }

    public String getOffersDescription()
    {
        return offersDescription;
    }

    public String getOffersMarketingCopy()
    {
        if (marketingCopy.length() > 200)
        {
            return (new StringBuilder()).append(marketingCopy.substring(0, 200)).append("...").toString();
        } else
        {
            return marketingCopy;
        }
    }

    public String getPrice()
    {
        return price;
    }

    public double getPriority()
    {
        return priority;
    }

    public String getPromoSlot()
    {
        return promoSlot;
    }

    public String getRegularPrice()
    {
        return regularPrice;
    }

    public ArrayList getRzLevels()
    {
        return rzLevels;
    }

    public String getSearchFacet()
    {
        return searchFacet;
    }

    public String getShortMarketingCopy()
    {
        return shortMarketingCopy;
    }

    public ArrayList getSkus()
    {
        return skus;
    }

    public String getTitle()
    {
        return title;
    }

    public String getUrl()
    {
        return url;
    }

    public int hashCode()
    {
        return getTitle().hashCode();
    }

    public boolean isInStoreOnly()
    {
        return inStoreOnly;
    }

    public void setLocalImageUrl(int i)
    {
        localImageUrl = i;
    }

}
