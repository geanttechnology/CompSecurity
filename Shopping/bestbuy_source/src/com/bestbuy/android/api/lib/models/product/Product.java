// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.product;

import com.bestbuy.android.api.lib.models.offers.Offer;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import gs;
import gv;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.bestbuy.android.api.lib.models.product:
//            PriceBlock, Review, ProductBlock

public class Product
    implements Serializable
{

    public static final String ACCESSORIES_IMAGE = "accessoriesImage";
    public static final String ACTIVE = "active";
    public static final String ADVERTISED_PRICE_RESTRICTION = "advertisedPriceRestriction";
    public static final String ALTERNATE_VIEWS_IMAGE = "alternateViewsImage";
    public static final String ANGLE_IMAGE = "angleImage";
    public static final String ARTIST_NAME = "artistName";
    public static final String BACKVIEW_IMAGE = "backViewImage";
    public static final String BUYBACK_PLANS = "buybackPlans";
    public static final String BUYBACK_PLANS_SKU = "buybackPlans.sku";
    public static final String CATEGORY_PATH = "categoryPath";
    public static final String CUSTOMER_REVIEW_AVERAGE = "customerReviewAverage";
    public static final String CUSTOMER_REVIEW_COUNT = "customerReviewCount";
    public static final String DEPARTMENT_ID = "departmentId";
    public static final String DESCRIPTION = "description";
    public static final String DETAILS = "details";
    public static final String ESRB_RATING = "esrbRating";
    public static final String FORMAT = "format";
    public static final String FREQUENTLY_PURCHASED_WITH = "frequentlyPurchasedWith";
    public static final String FRIENDS_AND_FAMILY_PICKUP = "friendsAndFamilyPickup";
    public static final String HOME_DELIVERY = "homeDelivery";
    public static final String IMAGE = "image";
    public static final String IN_STORE_AVAILABILITY = "inStoreAvailability";
    public static final String IN_STORE_PICKUP = "inStorePickup";
    public static final String LARGE_FRONT_IMAGE = "largeFrontImage";
    public static final String LARGE_IMAGE = "largeImage";
    public static final String LEFTVIEW_IMAGE = "leftViewImage";
    public static final String LONG_DESCRIPTION = "longDescription";
    public static final String MANUFACTURER = "manufacturer";
    public static final String MARKETING_COPY = "marketing_copy";
    public static final String MARKET_PLACE_ITEMS = "marketplace";
    public static final String MEDIUM_IMAGE = "mediumImage";
    public static final String MODEL_NUMBER = "modelNumber";
    public static final String NAME = "name";
    public static final String ONLINE_AVAILABILITY = "onlineAvailability";
    public static final String ON_SALE = "onSale";
    public static final String ORDERABLE = "orderable";
    public static final String PLAN_PRICE = "planPrice";
    public static final String PLATFORM = "platform";
    public static final String PLOT = "plot";
    public static final String PREOWNED = "preowned";
    public static final String PRICE = "price";
    public static final String PRICE_RESTRICTION = "priceRestriction";
    public static final String PRODUCT_ID = "productId";
    public static final String PROTECTION_PLANS = "protectionPlans";
    public static final String PROTECTION_PLANS_SKU = "protectionPlans.sku";
    public static final String PROTECTION_PLAN_TERM = "protectionPlanTerm";
    public static final String PROTECTION_PLAN_TYPE = "protectionPlanType";
    public static final String REGULAR_PRICE = "regularPrice";
    public static final String RELEASE_DATE = "releaseDate";
    public static final String REMOTE_CONTROL_IMAGE = "remoteControlImage";
    public static final String RESTRICTED_SALE_PRICE = "restrictedSalePrice";
    public static final String RIGHTVIEW_IMAGE = "rightViewImage";
    public static final String RZ_LEVELS = "rz_levels";
    public static final String SALE_PRICE = "salePrice";
    public static final String SHORT_DESCRIPTION = "shortDescription";
    public static final String SKU = "sku";
    public static final String SKUS = "skus";
    public static final String SPECIAL_ORDER = "specialOrder";
    private static String TAG = com/bestbuy/android/api/lib/models/product/Product.getSimpleName();
    public static final String THUMBNAIL_IMAGE = "thumbnailImage";
    public static final String TITLE = "title";
    public static final String TOPVIEW_IMAGE = "topViewImage";
    public static final String TRADE_IN_VALUE = "tradeInValue";
    public static final String TYPE = "type";
    public static final String URL = "url";
    public static final String VALUE = "value";
    private static ArrayList frequentlyPurchasedWith;
    private static final long serialVersionUID = 0x56584c78b2ebae9eL;
    private ArrayList accessories;
    private boolean active;
    private Date activeUpdateDate;
    private ArrayList additionalFeatures;
    private String addtoCartUrl;
    private String affiliateAddToCartUrl;
    private String affilliateUrl;
    private String albumLabel;
    private String albumTitle;
    private ArrayList alternateSkus;
    private String artistName;
    private String aspectRatio;
    private String availableStoreId;
    public BBYProduct bbyProduct;
    private double bestBuyItemId;
    private int bestSellingRank;
    private String brandLabel;
    private String brandName;
    private ArrayList breadcrumb;
    private int bundleItemCount;
    private ArrayList bundledIn;
    private ArrayList buybackPlans;
    private ArrayList cast;
    private ArrayList categories;
    private String categoryID;
    private String chatType;
    private String cjAffiliateAddToCartUrl;
    private String cjAffiliateUrl;
    private boolean clearance;
    private String colorId;
    private String colorName;
    private ArrayList colorOptions;
    private String condition;
    private ArrayList contractOptions;
    private ArrayList crew;
    public double customerReviewAverage;
    private int customerReviewCount;
    private String department;
    private int departmentId;
    private String depth;
    private String description;
    private ArrayList details;
    private boolean digital;
    private boolean energyStarCompatible;
    private String epValue;
    private String erbRating;
    private ArrayList features;
    private String fileSize;
    private String format;
    private ArrayList formatOptions;
    private boolean freeShipping;
    private String freeShippingCode;
    private boolean friendsAndFamilyPickup;
    private String fulfilledBy;
    private boolean geekSquadCertified;
    private String genre;
    private String height;
    private boolean homeDelivery;
    private ProductImages images;
    private boolean inStoreAvailability;
    private String inStoreAvailabilityText;
    private String inStoreAvailabilityTextHtml;
    private Date inStoreAvailabilityUpdateDate;
    private boolean inStorePickup;
    private ArrayList includedItemList;
    private boolean isActiveSku;
    private boolean isContractProduct;
    private Date itemUpdateDate;
    private String keywords;
    private String label;
    private int lengthInMinutes;
    private String listingId;
    private String longDescription;
    private String longDescriptionHtml;
    private boolean lowPriceGuarantee;
    private boolean lowPriceGuaranteedProduct;
    private ArrayList mAccessoriesList;
    private ArrayList mFreeBonusContentList;
    private SoftwareORGameDetails mSoftwareORGameDetails;
    private String manufacturer;
    private boolean marketPlace;
    private String mediaType;
    private ArrayList members;
    private String mobileUrl;
    private String modelNumber;
    private String monoStereo;
    private CastAndCrew movieCastCrewList;
    private ArrayList movieDetailsList;
    private String movieRating;
    private String movieUrl;
    private String mpaaRating;
    private ArrayList musicDetailsList;
    private String name;
    private boolean newProduct;
    private String numberOfPlayers;
    private ArrayList offers;
    private boolean onlineAvailability;
    private String onlineAvailabilityText;
    private String onlineAvailabilityTextHtml;
    private Date onlineAvailabilityUpdateDate;
    private boolean onlineOnly;
    private boolean onlinePlay;
    private String orderable;
    private Date originalReleaseDate;
    private boolean outletCenter;
    private boolean parentalAdvisory;
    private String platform;
    private String plot;
    private String plotHtml;
    private boolean preowned;
    private PriceBlock priceBlock;
    private ProductBlock prodBlock;
    private String productClass;
    private int productClassId;
    private ArrayList productFeatures;
    private String productId;
    private String productOptionType;
    public Summary productSummary;
    private String productTemplate;
    private String productType;
    private ArrayList productVideos;
    private ArrayList protectionPlanDetails;
    private double protectionPlanHighPrice;
    private double protectionPlanLowPrice;
    private String protectionPlanName;
    private double protectionPlanPrice;
    private ProtectionServices protectionPlans;
    private String publisher;
    private int quantityLimit;
    private boolean refurbished;
    private ArrayList relatedProducts;
    private String releaseDate;
    private Review review;
    private int salesRankLongTerm;
    private int salesRankMediumTerm;
    private int salesRankShortTerm;
    private boolean secondaryMarket;
    private String sellerId;
    private double shippingCost;
    private String shippingRestrictions;
    private String shippingWeight;
    private double shipping_ground;
    private double shipping_nextDay;
    private double shipping_secondDay;
    private double shipping_vendorDelivery;
    private String shortDescription;
    private String shortDescriptionHtml;
    private String sku;
    private boolean smartCapable;
    private String softwareAge;
    private String softwareGrade;
    private String softwareNumberOfPlayers;
    private ArrayList songsTrackList;
    private String source;
    private ArrayList specialFeatures;
    private boolean specialOrder;
    private ArrayList specifications;
    private Date startDate;
    private String studio;
    private String studioLive;
    private String subClass;
    private int subClassId;
    private ArrayList subtitleLanguages;
    private String synopsis;
    private ArrayList tabs;
    private Date theatricalReleaseDate;
    private String title;
    private double tradeInValue;
    private String type;
    private String upc;
    private String url;
    private String vendor;
    private ArrayList videoLanguages;
    private boolean wallMountable;
    private String warrantyLabor;
    private String warrantyParts;
    private String weight;
    private String width;

    public Product()
    {
        epValue = "";
        description = "";
        shortDescription = "";
        shortDescriptionHtml = "";
        longDescription = "";
        longDescriptionHtml = "";
        categoryID = "";
        protectionPlans = null;
        songsTrackList = new ArrayList();
        refurbished = false;
        isActiveSku = true;
        bundleItemCount = 0;
    }

    public static ArrayList getFrequentlyPurchasedWith()
    {
        return frequentlyPurchasedWith;
    }

    public static Product loadBBYOpenData(JSONObject jsonobject)
    {
        Product product;
        product = new Product();
        product.sku = jsonobject.optString("sku");
        product.name = jsonobject.optString("name");
        product.upc = jsonobject.optString("upc");
        product.productId = jsonobject.optString("productId");
        product.modelNumber = jsonobject.optString("modelNumber");
        product.bestBuyItemId = jsonobject.optDouble("bestBuyItemId");
        product.priceBlock = PriceBlock.loadData(jsonobject);
        product.description = jsonobject.optString("description");
        product.shortDescription = jsonobject.optString("shortDescription");
        product.shortDescriptionHtml = jsonobject.optString("shortDescriptionHtml");
        product.longDescription = jsonobject.optString("longDescription");
        product.longDescriptionHtml = jsonobject.optString("longDescriptionHtml");
        JSONArray jsonarray = jsonobject.optJSONArray("details");
        if (jsonarray == null) goto _L2; else goto _L1
_L1:
        if (jsonarray.length() <= 0) goto _L2; else goto _L3
_L3:
        int i = 0;
_L4:
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj1 = jsonarray.optJSONObject(i);
        obj1 = new BasicNameValuePair(((JSONObject) (obj1)).getString("name"), ((JSONObject) (obj1)).getString("value"));
        if (product.details == null)
        {
            product.details = new ArrayList();
        }
        product.details.add(obj1);
        i++;
        if (true) goto _L4; else goto _L2
        Exception exception;
        exception;
        gs.d(TAG, (new StringBuilder()).append("Could not parse details data: ").append(exception.getLocalizedMessage()).toString());
_L2:
        exception = jsonobject.optJSONArray("features");
        if (exception == null) goto _L6; else goto _L5
_L5:
        if (exception.length() <= 0) goto _L6; else goto _L7
_L7:
        i = 0;
_L8:
        if (i >= exception.length())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject1 = exception.optJSONObject(i);
        if (product.features == null)
        {
            product.features = new ArrayList();
        }
        product.features.add(jsonobject1.getString("feature"));
        i++;
        if (true) goto _L8; else goto _L6
        exception;
        gs.d(TAG, (new StringBuilder()).append("Could not parse features data: ").append(exception.getLocalizedMessage()).toString());
_L6:
        exception = jsonobject.optJSONArray("frequentlyPurchasedWith");
        if (exception == null) goto _L10; else goto _L9
_L9:
        if (exception.length() == 0) goto _L10; else goto _L11
_L11:
        frequentlyPurchasedWith = new ArrayList();
        i = 0;
_L12:
        if (i >= exception.length())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject2 = (JSONObject)exception.get(i);
        frequentlyPurchasedWith.add(jsonobject2.optString("sku"));
        i++;
        if (true) goto _L12; else goto _L10
        exception;
        gs.d(TAG, (new StringBuilder()).append("Could not parse frequentlyPurchasedWith data:  ").append(exception.getLocalizedMessage()).toString());
_L10:
        try
        {
            product.offers = Offer.loadData(jsonobject.optJSONArray("offers"));
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            gs.d(TAG, (new StringBuilder()).append("Could not parse Offer data: ").append(exception.getLocalizedMessage()).toString());
        }
        exception = jsonobject.optJSONArray("bundledIn");
        if (exception == null) goto _L14; else goto _L13
_L13:
        if (exception.length() <= 0) goto _L14; else goto _L15
_L15:
        i = 0;
_L16:
        if (i >= exception.length())
        {
            break; /* Loop/switch isn't completed */
        }
        product.bundledIn.add(exception.getJSONObject(i).optString("sku"));
        i++;
        if (true) goto _L16; else goto _L14
        exception;
        gs.d(TAG, (new StringBuilder()).append("Could not parse bundled array. ").append(exception.getLocalizedMessage()).toString());
_L14:
        exception = jsonobject.optJSONArray("categoryPath");
        if (exception == null) goto _L18; else goto _L17
_L17:
        if (exception.length() <= 0) goto _L18; else goto _L19
_L19:
        if (product.categories == null)
        {
            product.categories = new ArrayList();
        }
          goto _L20
_L23:
        if (i >= exception.length()) goto _L18; else goto _L21
_L21:
        Object obj2 = exception.optJSONObject(i);
        String s = ((JSONObject) (obj2)).optString("name");
        obj2 = ((JSONObject) (obj2)).optString("id");
        product.categories.add(new BasicNameValuePair(((String) (obj2)), s));
        i++;
        continue; /* Loop/switch isn't completed */
        exception;
        gs.d(TAG, (new StringBuilder()).append("Could not parse category. ").append(exception.getLocalizedMessage()).toString());
_L18:
        product.accessories = loadKeyValue(jsonobject.optJSONArray("accessories"), "sku");
        product.includedItemList = loadKeyValue(jsonobject.optJSONArray("includedItemList"), "includedItem");
        product.relatedProducts = loadKeyValue(jsonobject.optJSONArray("relatedProducts"), "sku");
        product.protectionPlanHighPrice = jsonobject.optDouble("protectionPlanHighPrice");
        product.protectionPlanLowPrice = jsonobject.optDouble("protectionPlanLowPrice");
        product.images = ProductImages.loadImageData(jsonobject);
        product.bestSellingRank = jsonobject.optInt("bestSellingRank");
        product.salesRankLongTerm = jsonobject.optInt("salesRankLongTerm");
        product.salesRankMediumTerm = jsonobject.optInt("salesRankMediumTerm");
        product.salesRankShortTerm = jsonobject.optInt("salesRankShortTerm");
        product.customerReviewAverage = jsonobject.optDouble("customerReviewAverage");
        product.customerReviewCount = jsonobject.optInt("customerReviewCount");
        product.department = jsonobject.optString("department");
        product.type = jsonobject.optString("type");
        product.condition = jsonobject.optString("condition");
        product.departmentId = jsonobject.optInt("departmentId");
        product.format = jsonobject.optString("format");
        product.manufacturer = jsonobject.optString("manufacturer");
        product.subClass = jsonobject.optString("subClass");
        product.subClassId = jsonobject.optInt("subClassId");
        product.productTemplate = jsonobject.optString("productTemplate");
        product.productClass = jsonobject.optString("productClass");
        product.productClassId = jsonobject.optInt("productClassId");
        product.newProduct = jsonobject.optBoolean("newProduct");
        product.preowned = jsonobject.optBoolean("preowned");
        product.digital = jsonobject.optBoolean("digital");
        product.active = jsonobject.optBoolean("active");
        Object obj;
        try
        {
            product.activeUpdateDate = gv.a.parse(jsonobject.optString("activeUpdateDate"));
        }
        catch (Exception exception1)
        {
            gs.d(TAG, (new StringBuilder()).append("Could not parse activeUpdateDate: ").append(exception1.getLocalizedMessage()).toString());
        }
        try
        {
            product.itemUpdateDate = gv.a.parse(jsonobject.optString("itemUpdateDate"));
        }
        catch (Exception exception2)
        {
            gs.d(TAG, (new StringBuilder()).append("Could not parse itemUpdateDate: ").append(exception2.getLocalizedMessage()).toString());
        }
        product.quantityLimit = jsonobject.optInt("quantityLimit");
        try
        {
            product.startDate = gv.a.parse(jsonobject.optString("startDate"));
        }
        catch (Exception exception3)
        {
            gs.d(TAG, (new StringBuilder()).append("Could not parse startDate: ").append(exception3.getLocalizedMessage()).toString());
        }
        try
        {
            product.releaseDate = jsonobject.optString("releaseDate");
        }
        catch (Exception exception4)
        {
            gs.d(TAG, (new StringBuilder()).append("Could not parse releaseDate: ").append(exception4.getLocalizedMessage()).toString());
        }
        product.colorName = jsonobject.optString("color");
        product.depth = jsonobject.optString("depth");
        product.height = jsonobject.optString("height");
        product.width = jsonobject.optString("width");
        product.weight = jsonobject.optString("weight");
        product.inStoreAvailability = jsonobject.optBoolean("inStoreAvailability");
        product.onlineAvailability = jsonobject.optBoolean("onlineAvailability");
        product.inStorePickup = jsonobject.optBoolean("inStorePickup");
        product.homeDelivery = jsonobject.optBoolean("homeDelivery");
        product.friendsAndFamilyPickup = jsonobject.optBoolean("friendsAndFamilyPickup");
        product.specialOrder = jsonobject.optBoolean("specialOrder");
        try
        {
            product.inStoreAvailabilityUpdateDate = gv.c.parse(jsonobject.optString("inStoreAvailabilityUpdateDate"));
        }
        catch (Exception exception5)
        {
            gs.d(TAG, (new StringBuilder()).append("Could not parse inStoreAvailablityUpdateDate: ").append(exception5.getLocalizedMessage()).toString());
        }
        product.inStoreAvailabilityText = jsonobject.optString("inStoreAvailabilityText");
        product.inStoreAvailabilityTextHtml = jsonobject.optString("inStoreAvailabilityTextHtml");
        try
        {
            product.onlineAvailabilityUpdateDate = gv.c.parse(jsonobject.optString("onlineAvailabilityUpdateDate"));
        }
        catch (Exception exception6)
        {
            gs.d(TAG, (new StringBuilder()).append("Could not parse onlineAvailabilityUpdateDate: ").append(exception6.getLocalizedMessage()).toString());
        }
        product.onlineAvailabilityText = jsonobject.optString("onlineAvailabilityText");
        product.onlineAvailabilityTextHtml = jsonobject.optString("onlineAvailabilityTextHtml");
        product.shippingWeight = jsonobject.optString("shippingWeight");
        product.shippingRestrictions = jsonobject.optString("shippingRestrictions");
        product.shippingCost = jsonobject.optDouble("shippingCost");
        obj = jsonobject.optJSONArray("shipping");
        if (obj != null && ((JSONArray) (obj)).length() > 0)
        {
            try
            {
                obj = ((JSONArray) (obj)).getJSONObject(0);
                product.shipping_nextDay = ((JSONObject) (obj)).optDouble("nextDay");
                product.shipping_secondDay = ((JSONObject) (obj)).optDouble("secondDay");
                product.shipping_vendorDelivery = ((JSONObject) (obj)).optDouble("VendorDelivery");
                product.shipping_ground = ((JSONObject) (obj)).optDouble("ground");
            }
            catch (Exception exception7)
            {
                gs.d(TAG, (new StringBuilder()).append("Could not parse Shipping data: ").append(exception7.getLocalizedMessage()).toString());
            }
        }
        product.secondaryMarket = jsonobject.optBoolean("secondaryMarket");
        product.sellerId = jsonobject.optString("sellerId");
        product.source = jsonobject.optString("source");
        product.listingId = jsonobject.optString("listingId");
        product.fulfilledBy = jsonobject.optString("fulfilledBy");
        product.warrantyParts = jsonobject.optString("warrantyParts");
        product.warrantyLabor = jsonobject.optString("warrantyLabor");
        product.url = jsonobject.optString("url");
        product.affilliateUrl = jsonobject.optString("affilliateUrl");
        product.cjAffiliateUrl = jsonobject.optString("cjAffiliateUrl");
        product.cjAffiliateAddToCartUrl = jsonobject.optString("cjAffiliateAddToCartUrl");
        product.addtoCartUrl = jsonobject.optString("addtoCartUrl");
        product.affiliateAddToCartUrl = jsonobject.optString("affiliateAddToCartUrl");
        product.mobileUrl = jsonobject.optString("mobileUrl");
        product.albumLabel = jsonobject.optString("albumLabel");
        product.albumTitle = jsonobject.optString("albumTitle");
        product.artistName = jsonobject.optString("artistName");
        product.genre = jsonobject.optString("genre");
        try
        {
            product.originalReleaseDate = gv.a.parse(jsonobject.optString("originalReleaseDate"));
        }
        catch (Exception exception8)
        {
            gs.d(TAG, (new StringBuilder()).append("Could not parse originalReleaseDate: ").append(exception8.getLocalizedMessage()).toString());
        }
        product.parentalAdvisory = jsonobject.optBoolean("parentalAdvisory");
        product.studioLive = jsonobject.optString("studioLive");
        product.monoStereo = jsonobject.optString("monoStereo");
        product.aspectRatio = jsonobject.optString("aspectRatio");
        product.lengthInMinutes = jsonobject.optInt("lengthInMinutes");
        product.mpaaRating = jsonobject.optString("mpaaRating");
        product.plot = jsonobject.optString("plot");
        product.plotHtml = jsonobject.optString("plotHtml");
        product.studio = jsonobject.optString("studio");
        try
        {
            product.theatricalReleaseDate = gv.a.parse(jsonobject.optString("theatricalReleaseDate"));
        }
        catch (Exception exception9)
        {
            gs.d(TAG, (new StringBuilder()).append("Could not parse theatricalReleaseDate: ").append(exception9.getLocalizedMessage()).toString());
        }
        obj = jsonobject.optJSONArray("subtitleLanguages");
        if (obj != null && ((JSONArray) (obj)).length() > 0)
        {
            product.subtitleLanguages = loadKeyValue(((JSONArray) (obj)), "language");
        }
        obj = jsonobject.optJSONArray("videoLanguages");
        if (obj != null && ((JSONArray) (obj)).length() > 0)
        {
            product.videoLanguages = loadKeyValue(((JSONArray) (obj)), "language");
        }
        obj = jsonobject.optJSONArray("additionalFeatures");
        if (obj != null && ((JSONArray) (obj)).length() > 0)
        {
            product.additionalFeatures = loadKeyValue(((JSONArray) (obj)), "feature");
        }
        product.onlinePlay = jsonobject.optBoolean("onlinePlay");
        product.softwareGrade = jsonobject.optString("softwareGrade");
        product.softwareNumberOfPlayers = jsonobject.optString("softwareNumberOfPlayers");
        product.softwareAge = jsonobject.optString("softwareAge");
        product.platform = jsonobject.optString("platform");
        product.erbRating = jsonobject.optString("erbRating");
        product.numberOfPlayers = jsonobject.optString("numberOfPlayers");
        product.tradeInValue = jsonobject.optDouble("tradeInValue");
        return product;
_L20:
        i = 0;
        if (true) goto _L23; else goto _L22
_L22:
    }

    public static Product loadCBProductAggregateData(JSONObject jsonobject)
    {
        boolean flag = false;
        JSONObject jsonobject1 = jsonobject.optJSONObject("sku");
        Product product = new Product();
        if (jsonobject.has("errorMessage") && jsonobject.has("errorCode") && jsonobject.optString("errorCode").equals("PRODUCT_SKU_INACTIVE"))
        {
            product.isActiveSku = false;
        }
        product.productId = jsonobject1.optString("productId", "");
        product.url = jsonobject1.optString("url", "");
        product.upc = jsonobject1.optString("upc", "");
        product.productType = jsonobject1.optString("productType", "");
        product.sku = jsonobject1.optString("skuId");
        product.active = jsonobject1.optBoolean("active", false);
        if (jsonobject1.optJSONObject("esrbRating") != null)
        {
            product.erbRating = jsonobject1.optJSONObject("esrbRating").optString("rating");
        }
        if (jsonobject1.optJSONObject("movieRatings") != null)
        {
            product.movieRating = jsonobject1.optJSONObject("movieRatings").optString("rating");
            if (jsonobject1.optJSONObject("movieRatings").optJSONObject("link") != null)
            {
                product.movieUrl = jsonobject1.optJSONObject("movieRatings").optJSONObject("link").optString("url");
            }
        }
        if (jsonobject1.optJSONObject("color") != null)
        {
            product.colorName = jsonobject1.optJSONObject("color").optString("displayName", "");
            product.colorId = jsonobject1.optJSONObject("color").optString("id", "");
        }
        if (jsonobject1.optJSONObject("manufacturerId") != null)
        {
            product.modelNumber = jsonobject1.optJSONObject("manufacturerId").optString("modelNumber");
        }
        if (jsonobject1.optJSONObject("names") != null)
        {
            product.name = jsonobject1.optJSONObject("names").optString("short");
        }
        if (product.productType.equals("bundle"))
        {
            jsonobject = jsonobject1.optJSONArray("bundleItems");
            if (jsonobject != null && jsonobject.length() > 0)
            {
                product.bundledIn = new ArrayList();
                for (int i = 0; i < jsonobject.length(); i++)
                {
                    product.bundledIn.add(jsonobject.getJSONObject(i).optString("sku"));
                }

            }
        }
        if (jsonobject1.optJSONObject("department") != null)
        {
            product.department = jsonobject1.optJSONObject("department").optString("displayName", "");
            product.departmentId = Integer.parseInt(jsonobject1.optJSONObject("department").optString("id", "0"));
        }
        if (jsonobject1.optJSONObject("class") != null)
        {
            product.productClass = jsonobject1.optJSONObject("class").optString("displayName", "");
            product.productClassId = Integer.parseInt(jsonobject1.optJSONObject("class").optString("id", "0"));
        }
        if (jsonobject1.optJSONObject("subclass") != null)
        {
            product.subClass = jsonobject1.optJSONObject("subclass").optString("displayName", "");
            product.subClassId = Integer.parseInt(jsonobject1.optJSONObject("subclass").optString("id", "0"));
        }
        product.includedItemList = loadKeyValue(jsonobject1.optJSONArray("includedItems"), "name");
        product.condition = jsonobject1.optString("condition");
        if (product.condition != null && !product.condition.isEmpty())
        {
            int j;
            if (product.condition.equals("refurbished"))
            {
                product.refurbished = true;
            } else
            {
                product.refurbished = false;
            }
            product.condition = (new StringBuilder()).append(product.condition.substring(0, 1).toUpperCase()).append(product.condition.substring(1).toLowerCase()).toString();
        }
        if (jsonobject1.optJSONObject("attributes") != null)
        {
            product.energyStarCompatible = jsonobject1.optJSONObject("attributes").optBoolean("energyStarCompatible", false);
            product.lowPriceGuaranteedProduct = jsonobject1.optJSONObject("attributes").optBoolean("lowPriceGuaranteedProduct", false);
            product.smartCapable = jsonobject1.optJSONObject("attributes").optBoolean("smartCapable", false);
            product.wallMountable = jsonobject1.optJSONObject("attributes").optBoolean("wallMountable", false);
            product.newProduct = jsonobject1.optJSONObject("attributes").optBoolean("newProduct", false);
            product.marketPlace = jsonobject1.optJSONObject("attributes").optBoolean("marketplaceProduct", false);
            product.parentalAdvisory = jsonobject1.optJSONObject("attributes").optBoolean("parentalAdvisory", false);
        }
        if (jsonobject1.optJSONObject("meta") != null)
        {
            product.description = jsonobject1.optJSONObject("meta").optString("description", "");
            product.title = jsonobject1.optJSONObject("meta").optString("title", "");
            product.keywords = jsonobject1.optJSONObject("meta").optString("keywords", "");
        }
        if (jsonobject1.optJSONObject("descriptions") != null)
        {
            product.shortDescription = jsonobject1.optJSONObject("descriptions").optString("short");
            product.longDescription = jsonobject1.optJSONObject("descriptions").optString("long");
            product.synopsis = jsonobject1.optJSONObject("descriptions").optString("synopsis");
        }
        if (jsonobject1.optJSONObject("brand") != null)
        {
            product.brandLabel = jsonobject1.optJSONObject("brand").optString("label", "");
            product.brandName = jsonobject1.optJSONObject("brand").optString("brand", "");
            product.vendor = jsonobject1.optJSONObject("brand").optString("vendor", "");
            product.publisher = jsonobject1.optJSONObject("brand").optString("publisher", "");
            product.label = jsonobject1.optJSONObject("brand").optString("label", "");
        }
        if (jsonobject1.optJSONArray("features") != null)
        {
            product.productFeatures = Feature.loadFeaturesData(jsonobject1.optJSONArray("features"));
        }
        if (jsonobject1.optJSONObject("dates") != null)
        {
            product.releaseDate = jsonobject1.optJSONObject("dates").optString("streetDate");
        }
        if (jsonobject1.optJSONArray("productFamily") != null)
        {
            product.productOptionType = "Color";
            jsonobject = jsonobject1.optJSONArray("productFamily").optJSONObject(0).optJSONArray("options");
            if (jsonobject != null)
            {
                product.colorOptions = AlternateSKU.loadAlternateSKUData(jsonobject);
            }
        }
        if (jsonobject1.optJSONObject("productOptions") != null)
        {
            jsonobject1.optJSONObject("productOptions").optJSONArray("multipleSellers");
            product.productOptionType = "Format";
            jsonobject = jsonobject1.optJSONObject("productOptions").optJSONArray("alternateProducts");
            if (jsonobject != null)
            {
                product.formatOptions = AlternateSKU.loadAlternateSKUData(jsonobject);
            }
            jsonobject = jsonobject1.optJSONObject("productOptions").optJSONArray("contractOptions");
            if (jsonobject != null)
            {
                product.contractOptions = AlternateSKU.loadAlternateSKUData(jsonobject);
            }
        }
        if (jsonobject1.optJSONObject("properties") != null)
        {
            product.fileSize = jsonobject1.optJSONObject("properties").optString("fileSize", "");
            product.chatType = jsonobject1.optJSONObject("properties").optString("chatType", "");
            product.format = jsonobject1.optJSONObject("properties").optString("format", "");
            product.freeShippingCode = jsonobject1.optJSONObject("properties").optString("freeShippingCode", "");
            jsonobject = jsonobject1.optJSONObject("properties").optString("contractCondition", "");
            if (jsonobject.equals("2_YEARS_NEW") || jsonobject.equals("2_YEARS_UPGRADE"))
            {
                product.isContractProduct = true;
            }
            jsonobject = jsonobject1.optJSONObject("properties").optJSONArray("primaryArtist");
            product.mediaType = jsonobject1.optJSONObject("properties").optString("mediaType", "");
            if (jsonobject != null)
            {
                product.artistName = jsonobject.optJSONObject(0).optString("displayName", "");
            }
        }
        if (jsonobject1.optJSONArray("specifications") != null)
        {
            product.specifications = Specification.loadProductSpecificationData(jsonobject1.optJSONArray("specifications"));
        }
        if (jsonobject1.optJSONArray("breadcrumb") != null)
        {
            product.breadcrumb = BreadCrumb.loadBreadCrumbDetails(jsonobject1.optJSONArray("breadcrumb"));
        }
        jsonobject = jsonobject1.optJSONObject("customerRatings");
        if (jsonobject != null)
        {
            product.review = Review.loadReviewData(jsonobject);
            if (jsonobject.optJSONObject("averageRating") != null)
            {
                product.customerReviewAverage = jsonobject.optJSONObject("averageRating").optDouble("score");
                product.customerReviewCount = jsonobject.optInt("totalCount");
            } else
            {
                product.customerReviewAverage = 0.0D;
                product.customerReviewCount = 0;
            }
        }
        product.images = ProductImages.loadCBAPIImageData(jsonobject1.optJSONObject("media"));
        if (jsonobject1.optJSONObject("media") != null)
        {
            product.productVideos = ProductVideos.loadProductVideos(jsonobject1.optJSONObject("media"));
        }
        jsonobject = jsonobject1.optJSONArray("tabs");
        product.tabs = new ArrayList();
        if (jsonobject != null)
        {
            for (j = 0; j < jsonobject.length(); j++)
            {
                product.tabs.add(jsonobject.optJSONObject(j).optString("id"));
            }

        }
        jsonobject = jsonobject1.optJSONArray("specialFeatures");
        product.specialFeatures = new ArrayList();
        if (jsonobject != null)
        {
            for (int k = 0; k < jsonobject.length(); k++)
            {
                product.specialFeatures.add(jsonobject.optJSONObject(k).optString("value"));
            }

        }
        if (jsonobject1.optJSONObject("protectionPlan") != null)
        {
            product.protectionPlanName = jsonobject1.optJSONObject("protectionPlan").optString("displayName", "");
            product.protectionPlanPrice = jsonobject1.optJSONObject("protectionPlan").optDouble("currentPrice");
        }
        if (jsonobject1.optJSONArray("bundleItems") != null)
        {
            jsonobject = jsonobject1.optJSONArray("bundleItems");
            for (int l = 0; l < jsonobject.length(); l++)
            {
                JSONObject jsonobject2 = jsonobject.optJSONObject(l);
                product.bundledIn.add(jsonobject2.optString("skuId"));
            }

        }
        if (jsonobject1.optJSONObject("services") != null && jsonobject1.optJSONObject("services").has("blackTieProtection"))
        {
            product.geekSquadCertified = jsonobject1.optJSONObject("services").optJSONObject("blackTieProtection").optBoolean("linkToBlackTieProtectionPdpTab");
        }
        if (jsonobject1.optJSONArray("trackInfo") != null)
        {
            jsonobject = jsonobject1.optJSONArray("trackInfo").getJSONObject(0).getJSONArray("tracks");
            if (jsonobject != null)
            {
                for (int i1 = ((flag) ? 1 : 0); i1 < jsonobject.length(); i1++)
                {
                    JSONObject jsonobject3 = jsonobject.optJSONObject(i1);
                    product.songsTrackList.add(new BasicNameValuePair(jsonobject3.optString("displayName"), jsonobject3.optString("playURL")));
                }

            }
        }
        if (jsonobject1.optJSONObject("softwareDetails") != null)
        {
            product.mSoftwareORGameDetails = SoftwareORGameDetails.getSoftwareORGameDetailsData(jsonobject1.optJSONObject("softwareDetails"));
        }
        if (jsonobject1.optJSONObject("gameDetails") != null)
        {
            product.mSoftwareORGameDetails = SoftwareORGameDetails.getSoftwareORGameDetailsData(jsonobject1.optJSONObject("gameDetails"));
        }
        if (jsonobject1.optJSONArray("bonusContent") != null)
        {
            product.mFreeBonusContentList = BonusContent.loadFreeBonusContent(jsonobject1.optJSONArray("bonusContent"));
        }
        return product;
    }

    public static Product loadEPData(JSONObject jsonobject)
    {
        Product product;
        product = new Product();
        product.sku = jsonobject.optString("id");
        product.name = jsonobject.optString("name");
        product.upc = jsonobject.optString("upc");
        product.productId = jsonobject.optString("productId");
        product.modelNumber = jsonobject.optString("modelNumber");
        product.shortDescription = jsonobject.optString("shortDescription");
        product.url = jsonobject.optString("url");
        product.addtoCartUrl = jsonobject.optString("addToCartUrl");
        product.mobileUrl = jsonobject.optString("mobileUrl");
        product.images = ProductImages.loadImageData(jsonobject);
        JSONArray jsonarray = jsonobject.optJSONArray("categoryPath");
        if (jsonarray == null) goto _L2; else goto _L1
_L1:
        if (jsonarray.length() <= 0) goto _L2; else goto _L3
_L3:
        if (product.categories == null)
        {
            product.categories = new ArrayList();
        }
          goto _L4
_L7:
        int i;
        if (i >= jsonarray.length()) goto _L2; else goto _L5
_L5:
        Object obj = jsonarray.optJSONObject(i);
        String s = ((JSONObject) (obj)).optString("name");
        obj = ((JSONObject) (obj)).optString("id");
        product.categories.add(new BasicNameValuePair(((String) (obj)), s));
        i++;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        gs.d(TAG, (new StringBuilder()).append("Could not parse category. ").append(exception.getLocalizedMessage()).toString());
_L2:
        product.priceBlock = PriceBlock.loadData(jsonobject);
        product.customerReviewAverage = jsonobject.optDouble("customerReviewAverage");
        product.customerReviewCount = jsonobject.optInt("customerReviewCount");
        product.active = jsonobject.optBoolean("active");
        return product;
_L4:
        i = 0;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private static ArrayList loadKeyValue(JSONArray jsonarray, String s)
    {
        ArrayList arraylist = new ArrayList();
        if (jsonarray != null && jsonarray.length() > 0)
        {
            for (int i = 0; i < jsonarray.length(); i++)
            {
                arraylist.add(jsonarray.optJSONObject(i).optString(s));
            }

        }
        return arraylist;
    }

    public static Product loadPandaData(JSONObject jsonobject)
    {
        Product product = new Product();
        product.sku = jsonobject.optString("skuId");
        product.url = jsonobject.optString("url", "");
        product.name = jsonobject.optJSONObject("names").optString("short");
        product.productId = jsonobject.optString("productId", "");
        product.productType = jsonobject.optString("productType", "");
        if (jsonobject.optJSONObject("descriptions") != null)
        {
            product.shortDescription = jsonobject.optJSONObject("descriptions").optString("short");
            product.longDescription = jsonobject.optJSONObject("descriptions").optString("long");
            product.synopsis = jsonobject.optJSONObject("descriptions").optString("synopsis");
        }
        if (jsonobject.optJSONObject("meta") != null)
        {
            product.description = jsonobject.optJSONObject("meta").optString("description", "");
            product.title = jsonobject.optJSONObject("meta").optString("title", "");
            product.keywords = jsonobject.optJSONObject("meta").optString("keywords", "");
        }
        Object obj = jsonobject.optJSONObject("customerRatings");
        if (obj != null && ((JSONObject) (obj)).optJSONObject("averageRating") != null)
        {
            product.customerReviewAverage = ((JSONObject) (obj)).optJSONObject("averageRating").optDouble("score");
            product.customerReviewCount = ((JSONObject) (obj)).optInt("totalCount");
        } else
        {
            product.customerReviewAverage = 0.0D;
            product.customerReviewCount = 0;
        }
        if (jsonobject.optJSONObject("properties") != null)
        {
            obj = jsonobject.optJSONObject("properties").optString("contractCondition", "");
            if (((String) (obj)).equals("2_YEARS_NEW") || ((String) (obj)).equals("2_YEARS_UPGRADE"))
            {
                product.isContractProduct = true;
            }
            product.freeShippingCode = jsonobject.optJSONObject("properties").optString("freeShippingCode", "");
        }
        obj = jsonobject.optJSONObject("attributes");
        if (obj != null)
        {
            product.marketPlace = ((JSONObject) (obj)).optBoolean("marketplaceProduct", false);
            product.outletCenter = ((JSONObject) (obj)).optBoolean("outletCenterProduct", false);
            product.lowPriceGuarantee = ((JSONObject) (obj)).optBoolean("lowPriceGuaranteedProduct", false);
            product.onlineOnly = ((JSONObject) (obj)).optBoolean("onlineOnly", false);
            product.smartCapable = ((JSONObject) (obj)).optBoolean("smartCapable", false);
        }
        if (jsonobject.has("condition"))
        {
            if (jsonobject.optString("condition").equals("refurbished"))
            {
                product.refurbished = true;
            } else
            {
                product.refurbished = false;
            }
        }
        product.images = ProductImages.loadPandaAPIImageData(jsonobject.optJSONObject("media"));
        return product;
    }

    public static Product loadSolrData(JSONObject jsonobject)
    {
        Product product = new Product();
        product.sku = jsonobject.optString("skuid");
        product.name = jsonobject.optString("title");
        product.images = ProductImages.loadImageData(jsonobject);
        product.customerReviewAverage = jsonobject.optDouble("customerrating");
        product.customerReviewCount = jsonobject.optInt("numberofreviews");
        return product;
    }

    public ArrayList getAccessories()
    {
        return accessories;
    }

    public ArrayList getAccessoriesList()
    {
        return mAccessoriesList;
    }

    public Date getActiveUpdateDate()
    {
        return activeUpdateDate;
    }

    public ArrayList getAdditionalFeatures()
    {
        return additionalFeatures;
    }

    public String getAddtoCartUrl()
    {
        return addtoCartUrl;
    }

    public String getAffiliateAddToCartUrl()
    {
        return affiliateAddToCartUrl;
    }

    public String getAffilliateUrl()
    {
        return affilliateUrl;
    }

    public String getAlbumLabel()
    {
        return albumLabel;
    }

    public String getAlbumTitle()
    {
        return albumTitle;
    }

    public ArrayList getAlternateSkus()
    {
        return alternateSkus;
    }

    public String getArtistName()
    {
        return artistName;
    }

    public String getAspectRatio()
    {
        return aspectRatio;
    }

    public String getAvailableStoreId()
    {
        return availableStoreId;
    }

    public BBYProduct getBbyProduct()
    {
        return bbyProduct;
    }

    public double getBestBuyItemId()
    {
        return bestBuyItemId;
    }

    public int getBestSellingRank()
    {
        return bestSellingRank;
    }

    public String getBrandLabel()
    {
        return brandLabel;
    }

    public String getBrandName()
    {
        return brandName;
    }

    public ArrayList getBreadcrumb()
    {
        return breadcrumb;
    }

    public int getBundleItemCount()
    {
        return bundleItemCount;
    }

    public ArrayList getBundledIn()
    {
        return bundledIn;
    }

    public ArrayList getBuybackPlans()
    {
        return buybackPlans;
    }

    public ArrayList getCast()
    {
        return cast;
    }

    public ArrayList getCategories()
    {
        return categories;
    }

    public String getCategoryID()
    {
        return categoryID;
    }

    public String getChatType()
    {
        return chatType;
    }

    public String getCjAffiliateAddToCartUrl()
    {
        return cjAffiliateAddToCartUrl;
    }

    public String getCjAffiliateUrl()
    {
        return cjAffiliateUrl;
    }

    public String getColor()
    {
        return colorName;
    }

    public String getColorId()
    {
        return colorId;
    }

    public String getColorName()
    {
        return colorName;
    }

    public ArrayList getColorOptions()
    {
        return colorOptions;
    }

    public String getCondition()
    {
        return condition;
    }

    public ArrayList getContractOptions()
    {
        return contractOptions;
    }

    public ArrayList getCrew()
    {
        return crew;
    }

    public double getCustomerReviewAverage()
    {
        return customerReviewAverage;
    }

    public int getCustomerReviewCount()
    {
        return customerReviewCount;
    }

    public String getDepartment()
    {
        return department;
    }

    public int getDepartmentId()
    {
        return departmentId;
    }

    public String getDepth()
    {
        return depth;
    }

    public String getDescription()
    {
        return description;
    }

    public ArrayList getDetails()
    {
        return details;
    }

    public String getEpValue()
    {
        return epValue;
    }

    public String getErbRating()
    {
        return erbRating;
    }

    public ArrayList getFeatures()
    {
        return features;
    }

    public String getFileSize()
    {
        return fileSize;
    }

    public String getFormat()
    {
        return format;
    }

    public ArrayList getFormatOptions()
    {
        return formatOptions;
    }

    public ArrayList getFreeBonusContentList()
    {
        if (mFreeBonusContentList != null)
        {
            return mFreeBonusContentList;
        } else
        {
            ArrayList arraylist = new ArrayList();
            mFreeBonusContentList = arraylist;
            return arraylist;
        }
    }

    public String getFreeShippingCode()
    {
        return freeShippingCode;
    }

    public String getFulfilledBy()
    {
        return fulfilledBy;
    }

    public String getGenre()
    {
        return genre;
    }

    public String getHeight()
    {
        return height;
    }

    public ProductImages getImages()
    {
        return images;
    }

    public String getInStoreAvailabilityText()
    {
        return inStoreAvailabilityText;
    }

    public String getInStoreAvailabilityTextHtml()
    {
        return inStoreAvailabilityTextHtml;
    }

    public Date getInStoreAvailabilityUpdateDate()
    {
        return inStoreAvailabilityUpdateDate;
    }

    public ArrayList getIncludedItemList()
    {
        return includedItemList;
    }

    public Date getItemUpdateDate()
    {
        return itemUpdateDate;
    }

    public String getKeywords()
    {
        return keywords;
    }

    public String getLabel()
    {
        return label;
    }

    public int getLengthInMinutes()
    {
        return lengthInMinutes;
    }

    public String getListingId()
    {
        return listingId;
    }

    public String getLongDescription()
    {
        return longDescription;
    }

    public String getLongDescriptionHtml()
    {
        return longDescriptionHtml;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public String getMediaType()
    {
        return mediaType;
    }

    public ArrayList getMembers()
    {
        return members;
    }

    public String getMobileUrl()
    {
        return mobileUrl;
    }

    public String getModelNumber()
    {
        return modelNumber;
    }

    public String getMonoStereo()
    {
        return monoStereo;
    }

    public CastAndCrew getMovieCastCrewList()
    {
        return movieCastCrewList;
    }

    public ArrayList getMovieDetailsList()
    {
        return movieDetailsList;
    }

    public String getMovieRating()
    {
        return movieRating;
    }

    public String getMovieUrl()
    {
        return movieUrl;
    }

    public String getMpaaRating()
    {
        return mpaaRating;
    }

    public ArrayList getMusicDetailsList()
    {
        return musicDetailsList;
    }

    public String getName()
    {
        return name;
    }

    public String getNumberOfPlayers()
    {
        return numberOfPlayers;
    }

    public ArrayList getOffers()
    {
        return offers;
    }

    public String getOnlineAvailabilityText()
    {
        return onlineAvailabilityText;
    }

    public String getOnlineAvailabilityTextHtml()
    {
        return onlineAvailabilityTextHtml;
    }

    public Date getOnlineAvailabilityUpdateDate()
    {
        return onlineAvailabilityUpdateDate;
    }

    public String getOrderable()
    {
        return orderable;
    }

    public Date getOriginalReleaseDate()
    {
        return originalReleaseDate;
    }

    public String getPlatform()
    {
        return platform;
    }

    public String getPlot()
    {
        return plot;
    }

    public String getPlotHtml()
    {
        return plotHtml;
    }

    public PriceBlock getPriceBlock()
    {
        return priceBlock;
    }

    public ProductBlock getProdBlock()
    {
        return prodBlock;
    }

    public String getProductClass()
    {
        return productClass;
    }

    public int getProductClassId()
    {
        return productClassId;
    }

    public ArrayList getProductFeatures()
    {
        return productFeatures;
    }

    public String getProductId()
    {
        return productId;
    }

    public String getProductOptionType()
    {
        return productOptionType;
    }

    public Summary getProductSummary()
    {
        return productSummary;
    }

    public String getProductTemplate()
    {
        return productTemplate;
    }

    public String getProductType()
    {
        return productType;
    }

    public ArrayList getProductVideos()
    {
        return productVideos;
    }

    public ArrayList getProtectionPlanDetails()
    {
        return protectionPlanDetails;
    }

    public double getProtectionPlanHighPrice()
    {
        return protectionPlanHighPrice;
    }

    public double getProtectionPlanLowPrice()
    {
        return protectionPlanLowPrice;
    }

    public String getProtectionPlanName()
    {
        return protectionPlanName;
    }

    public double getProtectionPlanPrice()
    {
        return protectionPlanPrice;
    }

    public ProtectionServices getProtectionPlans()
    {
        return protectionPlans;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public int getQuantityLimit()
    {
        return quantityLimit;
    }

    public ArrayList getRelatedProducts()
    {
        return relatedProducts;
    }

    public String getReleaseDate()
    {
        return releaseDate;
    }

    public Review getReview()
    {
        return review;
    }

    public int getSalesRankLongTerm()
    {
        return salesRankLongTerm;
    }

    public int getSalesRankMediumTerm()
    {
        return salesRankMediumTerm;
    }

    public int getSalesRankShortTerm()
    {
        return salesRankShortTerm;
    }

    public String getSellerId()
    {
        return sellerId;
    }

    public double getShippingCost()
    {
        return shippingCost;
    }

    public String getShippingRestrictions()
    {
        return shippingRestrictions;
    }

    public String getShippingWeight()
    {
        return shippingWeight;
    }

    public double getShipping_ground()
    {
        return shipping_ground;
    }

    public double getShipping_nextDay()
    {
        return shipping_nextDay;
    }

    public double getShipping_secondDay()
    {
        return shipping_secondDay;
    }

    public double getShipping_vendorDelivery()
    {
        return shipping_vendorDelivery;
    }

    public String getShortDescription()
    {
        return shortDescription;
    }

    public String getShortDescriptionHtml()
    {
        return shortDescriptionHtml;
    }

    public String getSku()
    {
        return sku;
    }

    public String getSoftwareAge()
    {
        return softwareAge;
    }

    public String getSoftwareGrade()
    {
        return softwareGrade;
    }

    public String getSoftwareNumberOfPlayers()
    {
        return softwareNumberOfPlayers;
    }

    public SoftwareORGameDetails getSoftwareORGameDetails()
    {
        return mSoftwareORGameDetails;
    }

    public ArrayList getSongsTrackList()
    {
        return songsTrackList;
    }

    public String getSource()
    {
        return source;
    }

    public ArrayList getSpecialFeatures()
    {
        return specialFeatures;
    }

    public ArrayList getSpecifications()
    {
        return specifications;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public String getStudio()
    {
        return studio;
    }

    public String getStudioLive()
    {
        return studioLive;
    }

    public String getSubClass()
    {
        return subClass;
    }

    public int getSubClassId()
    {
        return subClassId;
    }

    public ArrayList getSubtitleLanguages()
    {
        return subtitleLanguages;
    }

    public String getSynopsis()
    {
        return synopsis;
    }

    public ArrayList getTabs()
    {
        return tabs;
    }

    public Date getTheatricalReleaseDate()
    {
        return theatricalReleaseDate;
    }

    public String getTitle()
    {
        return title;
    }

    public double getTradeInValue()
    {
        return tradeInValue;
    }

    public String getType()
    {
        return type;
    }

    public String getUpc()
    {
        return upc;
    }

    public String getUrl()
    {
        return url;
    }

    public String getVendor()
    {
        return vendor;
    }

    public ArrayList getVideoLanguages()
    {
        return videoLanguages;
    }

    public String getWarrantyLabor()
    {
        return warrantyLabor;
    }

    public String getWarrantyParts()
    {
        return warrantyParts;
    }

    public String getWeight()
    {
        return weight;
    }

    public String getWidth()
    {
        return width;
    }

    public ArrayList getmAccessoriesList()
    {
        return mAccessoriesList;
    }

    public SoftwareORGameDetails getmSoftwareORGameDetails()
    {
        return mSoftwareORGameDetails;
    }

    public boolean isActive()
    {
        return active;
    }

    public boolean isActiveSku()
    {
        return isActiveSku;
    }

    public boolean isClearance()
    {
        return clearance;
    }

    public boolean isContractProduct()
    {
        return isContractProduct;
    }

    public boolean isDigital()
    {
        return digital;
    }

    public boolean isEnergyStarCompatible()
    {
        return energyStarCompatible;
    }

    public boolean isFreeShipping()
    {
        return freeShipping;
    }

    public boolean isFriendsAndFamilyPickup()
    {
        return friendsAndFamilyPickup;
    }

    public boolean isGeekSquadCertified()
    {
        return geekSquadCertified;
    }

    public boolean isHomeDelivery()
    {
        return homeDelivery;
    }

    public boolean isInStoreAvailability()
    {
        return inStoreAvailability;
    }

    public boolean isInStorePickup()
    {
        return inStorePickup;
    }

    public boolean isLowPriceGuarantee()
    {
        return lowPriceGuarantee;
    }

    public boolean isLowPriceGuaranteedProduct()
    {
        return lowPriceGuaranteedProduct;
    }

    public boolean isMarketPlace()
    {
        return marketPlace;
    }

    public boolean isNewProduct()
    {
        return newProduct;
    }

    public boolean isOnlineAvailability()
    {
        return onlineAvailability;
    }

    public boolean isOnlineOnly()
    {
        return onlineOnly;
    }

    public boolean isOnlinePlay()
    {
        return onlinePlay;
    }

    public boolean isOutletCenter()
    {
        return outletCenter;
    }

    public boolean isParentalAdvisory()
    {
        return parentalAdvisory;
    }

    public boolean isPreowned()
    {
        return preowned;
    }

    public boolean isRefurbished()
    {
        return refurbished;
    }

    public boolean isSecondaryMarket()
    {
        return secondaryMarket;
    }

    public boolean isSmartCapable()
    {
        return smartCapable;
    }

    public boolean isSpecialOrder()
    {
        return specialOrder;
    }

    public boolean isWallMountable()
    {
        return wallMountable;
    }

    public void setAccessoriesList(ArrayList arraylist)
    {
        mAccessoriesList = arraylist;
    }

    public void setActiveSku(boolean flag)
    {
        isActiveSku = flag;
    }

    public void setAvailableStoreId(String s)
    {
        availableStoreId = s;
    }

    public void setBbyProduct(BBYProduct bbyproduct)
    {
        bbyProduct = bbyproduct;
    }

    public void setBreadcrumb(ArrayList arraylist)
    {
        breadcrumb = arraylist;
    }

    public void setBundleItemCount(int i)
    {
        bundleItemCount = i;
    }

    public void setCategoryID(String s)
    {
        categoryID = s;
    }

    public void setEpValue(String s)
    {
        epValue = s;
    }

    public void setFormatOptions(ArrayList arraylist)
    {
        formatOptions = arraylist;
    }

    public void setMovieCastCrewList(CastAndCrew castandcrew)
    {
        movieCastCrewList = castandcrew;
    }

    public void setMovieDetailsList(ArrayList arraylist)
    {
        movieDetailsList = arraylist;
    }

    public void setMusicDetailsList(ArrayList arraylist)
    {
        musicDetailsList = arraylist;
    }

    public void setPriceBlock(PriceBlock priceblock)
    {
        priceBlock = priceblock;
    }

    public void setProdBlock(ProductBlock productblock)
    {
        prodBlock = productblock;
    }

    public void setProtectionPlans(ProtectionServices protectionservices)
    {
        protectionPlans = protectionservices;
    }



/*
    static String access$002(Product product, String s)
    {
        product.sku = s;
        return s;
    }

*/


/*
    static String access$102(Product product, String s)
    {
        product.productId = s;
        return s;
    }

*/


/*
    static String access$202(Product product, String s)
    {
        product.name = s;
        return s;
    }

*/


/*
    static ProductImages access$502(Product product, ProductImages productimages)
    {
        product.images = productimages;
        return productimages;
    }

*/



/*
    static int access$602(Product product, int i)
    {
        product.customerReviewCount = i;
        return i;
    }

*/

    private class ProductImages
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        private String accessoriesImage;
        private String alternateViewsImage;
        private String angleImage;
        private String backViewImage;
        private String carrierLogoImage;
        private String energyGuideImage;
        private ArrayList galleryImages;
        private String image;
        private String largeFrontImage;
        private String largeImage;
        private String leftViewImage;
        private String mediumImage;
        private String primaryImage;
        private String remoteControlImage;
        private String rightViewImage;
        private String spin360Url;
        private String thumbnailImage;
        private String topViewImage;

        public static ProductImages loadCBAPIImageData(JSONObject jsonobject)
        {
            ProductImages productimages;
label0:
            {
label1:
                {
                    productimages = new ProductImages();
                    if (jsonobject == null)
                    {
                        break label0;
                    }
                    JSONObject jsonobject1 = jsonobject.optJSONObject("primaryImage");
                    if (jsonobject1 != null)
                    {
                        productimages.primaryImage = jsonobject1.optString("url", "");
                    }
                    jsonobject1 = jsonobject.optJSONObject("energyGuideImage");
                    if (jsonobject1 != null)
                    {
                        productimages.energyGuideImage = jsonobject1.optString("url", "");
                    }
                    jsonobject1 = jsonobject.optJSONObject("backImage");
                    if (jsonobject1 != null)
                    {
                        productimages.backViewImage = jsonobject1.optString("url", "");
                    }
                    JSONArray jsonarray = jsonobject.optJSONArray("galleryImages");
                    productimages.galleryImages = new ArrayList();
                    if (jsonarray == null)
                    {
                        break label1;
                    }
                    for (int i = 0; i < jsonarray.length(); i++)
                    {
                        String s;
label2:
                        {
                            JSONObject jsonobject3 = jsonarray.optJSONObject(i);
                            String s1 = jsonobject3.optString("url", "");
                            if (s1 != null)
                            {
                                s = s1;
                                if (!s1.isEmpty())
                                {
                                    break label2;
                                }
                            }
                            s1 = jsonobject3.optString("height", "");
                            s = s1;
                            if (Integer.parseInt(s1) > 500)
                            {
                                s = "500";
                            }
                            String s2 = jsonobject3.optString("width", "");
                            s1 = s2;
                            if (Integer.parseInt(s2) > 500)
                            {
                                s1 = "500";
                            }
                            s = (new StringBuilder()).append("http://pisces.bbystatic.com/image2/").append(jsonobject3.optString("path", "")).append(";canvasHeight=").append(s).append(";canvasWidth=").append(s1).toString();
                        }
                        productimages.galleryImages.add(s);
                    }

                }
                JSONObject jsonobject2 = jsonobject.optJSONObject("alternateLogoImage");
                if (jsonobject2 != null)
                {
                    productimages.alternateViewsImage = jsonobject2.optString("url", "");
                }
                jsonobject = jsonobject.optJSONObject("carrierLogoImage");
                if (jsonobject != null)
                {
                    productimages.carrierLogoImage = jsonobject.optString("url", "");
                }
            }
            return productimages;
        }

        public static ProductImages loadImageData(JSONObject jsonobject)
        {
            ProductImages productimages = new ProductImages();
            productimages.image = jsonobject.optString("image");
            productimages.thumbnailImage = jsonobject.optString("thumbnailImage");
            productimages.largeImage = jsonobject.optString("largeImage");
            productimages.mediumImage = jsonobject.optString("mediumImage");
            productimages.largeFrontImage = jsonobject.optString("largeFrontImage");
            productimages.topViewImage = jsonobject.optString("topViewImage");
            productimages.rightViewImage = jsonobject.optString("rightViewImage");
            productimages.leftViewImage = jsonobject.optString("leftViewImage");
            productimages.backViewImage = jsonobject.optString("backViewImage");
            productimages.angleImage = jsonobject.optString("angleImage");
            productimages.alternateViewsImage = jsonobject.optString("alternateViewsImage");
            productimages.accessoriesImage = jsonobject.optString("accessoriesImage");
            productimages.energyGuideImage = jsonobject.optString("energyGuideImage");
            productimages.remoteControlImage = jsonobject.optString("remoteControlImage");
            productimages.spin360Url = jsonobject.optString("spin360Url");
            return productimages;
        }

        public static ProductImages loadPandaAPIImageData(JSONObject jsonobject)
        {
            ProductImages productimages = new ProductImages();
            if (jsonobject == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            JSONObject jsonobject1;
            try
            {
                jsonobject1 = jsonobject.optJSONObject("primaryImage");
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                jsonobject.printStackTrace();
                return productimages;
            }
            if (jsonobject1 == null)
            {
                break MISSING_BLOCK_LABEL_35;
            }
            productimages.primaryImage = jsonobject1.optString("url", "");
            jsonobject = jsonobject.optJSONObject("listImage");
            if (jsonobject == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            productimages.thumbnailImage = jsonobject.optString("url", "");
            return productimages;
        }

        public String getAccessoriesImage()
        {
            return accessoriesImage;
        }

        public String getAlternateViewsImage()
        {
            return alternateViewsImage;
        }

        public String getAngleImage()
        {
            return angleImage;
        }

        public String getBackViewImage()
        {
            return backViewImage;
        }

        public String getCarrierLogoImage()
        {
            return carrierLogoImage;
        }

        public String getEnergyGuideImage()
        {
            return energyGuideImage;
        }

        public ArrayList getGalleryImages()
        {
            return galleryImages;
        }

        public String getImage()
        {
            return image;
        }

        public String getLargeFrontImage()
        {
            return largeFrontImage;
        }

        public String getLargeImage()
        {
            return largeImage;
        }

        public String getLeftViewImage()
        {
            return leftViewImage;
        }

        public String getMediumImage()
        {
            return mediumImage;
        }

        public String getPrimaryImage()
        {
            return primaryImage;
        }

        public String getRemoteControlImage()
        {
            return remoteControlImage;
        }

        public String getRightViewImage()
        {
            return rightViewImage;
        }

        public String getSpin360Url()
        {
            return spin360Url;
        }

        public String getThumbnailImage()
        {
            return thumbnailImage;
        }

        public String getTopViewImage()
        {
            return topViewImage;
        }


/*
        static String access$302(ProductImages productimages, String s)
        {
            productimages.image = s;
            return s;
        }

*/


/*
        static String access$402(ProductImages productimages, String s)
        {
            productimages.primaryImage = s;
            return s;
        }

*/

        public ProductImages()
        {
            image = "";
            thumbnailImage = "";
            largeImage = "";
            mediumImage = "";
            largeFrontImage = "";
            topViewImage = "";
            rightViewImage = "";
            leftViewImage = "";
            backViewImage = "";
            angleImage = "";
            alternateViewsImage = "";
            accessoriesImage = "";
            energyGuideImage = "";
            remoteControlImage = "";
            spin360Url = "";
            primaryImage = "";
            carrierLogoImage = "";
        }
    }


    private class Feature
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        private String description;
        private String title;

        public static ArrayList loadFeaturesData(JSONArray jsonarray)
        {
            ArrayList arraylist = new ArrayList();
            for (int i = 0; i < jsonarray.length(); i++)
            {
                Feature feature = new Feature();
                JSONObject jsonobject = jsonarray.optJSONObject(i);
                if (jsonobject != null)
                {
                    feature.description = jsonobject.optString("description");
                    feature.title = jsonobject.optString("title");
                }
                arraylist.add(feature);
            }

            return arraylist;
        }

        public String getDescription()
        {
            return description;
        }

        public String getTitle()
        {
            return title;
        }

        public Feature()
        {
        }
    }


    private class AlternateSKU
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        private String color;
        private String format;
        private String price;
        private String productId;
        private String sku;
        private String state;
        private String url;

        public static ArrayList loadAlternateSKUData(JSONArray jsonarray)
        {
            ArrayList arraylist = new ArrayList();
            int i = 0;
            while (i < jsonarray.length()) 
            {
                JSONObject jsonobject = jsonarray.optJSONObject(i);
                if (jsonobject != null)
                {
                    AlternateSKU alternatesku = new AlternateSKU();
                    alternatesku.sku = jsonobject.optString("sku");
                    if (alternatesku.sku == null || alternatesku.sku.isEmpty())
                    {
                        alternatesku.sku = jsonobject.optString("skuId");
                    }
                    alternatesku.color = jsonobject.optString("displayName");
                    alternatesku.state = jsonobject.optString("state");
                    alternatesku.productId = jsonobject.optString("productId");
                    alternatesku.format = jsonobject.optString("format");
                    if (alternatesku.format != null && !alternatesku.format.isEmpty())
                    {
                        alternatesku.format = (new StringBuilder()).append(alternatesku.format.substring(0, 1).toUpperCase()).append(alternatesku.format.substring(1).toLowerCase()).toString();
                    } else
                    {
                        alternatesku.price = jsonobject.optString("price");
                        alternatesku.format = jsonobject.optString("type");
                    }
                    arraylist.add(alternatesku);
                }
                i++;
            }
            return arraylist;
        }

        public String getColor()
        {
            return color;
        }

        public String getFormat()
        {
            return format;
        }

        public String getPrice()
        {
            return price;
        }

        public String getProductId()
        {
            return productId;
        }

        public String getSku()
        {
            return sku;
        }

        public String getState()
        {
            return state;
        }

        public String getUrl()
        {
            return url;
        }

        public void setColor(String s)
        {
            color = s;
        }

        public void setFormat(String s)
        {
            format = s;
        }

        public void setProductId(String s)
        {
            productId = s;
        }

        public void setSku(String s)
        {
            sku = s;
        }

        public void setState(String s)
        {
            state = s;
        }

        public void setUrl(String s)
        {
            url = s;
        }

        public AlternateSKU()
        {
        }
    }


    private class Specification
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        private String definition;
        private String displayName;
        private String value;

        public static ArrayList loadProductSpecificationData(JSONArray jsonarray)
        {
            ArrayList arraylist = new ArrayList();
            for (int i = 0; i < jsonarray.length(); i++)
            {
                Specification specification = new Specification();
                JSONObject jsonobject = jsonarray.optJSONObject(i);
                if (jsonobject != null)
                {
                    specification.definition = jsonobject.optString("definition", "");
                    specification.displayName = jsonobject.optString("displayName", "");
                    specification.value = jsonobject.optString("value", "");
                }
                arraylist.add(specification);
            }

            return arraylist;
        }

        public String getDefinition()
        {
            return definition;
        }

        public String getDisplayName()
        {
            return displayName;
        }

        public String getValue()
        {
            return value;
        }

        public Specification()
        {
        }
    }


    private class BreadCrumb
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        private String categoryId;
        private String displayName;

        public static ArrayList loadBreadCrumbDetails(JSONArray jsonarray)
        {
            ArrayList arraylist = new ArrayList();
            if (jsonarray != null)
            {
                for (int i = 0; i < jsonarray.length(); i++)
                {
                    JSONObject jsonobject = jsonarray.optJSONObject(i);
                    BreadCrumb breadcrumb1 = new BreadCrumb();
                    if (jsonobject != null)
                    {
                        breadcrumb1.categoryId = jsonobject.optString("categoryId");
                        breadcrumb1.displayName = jsonobject.optString("displayName");
                    }
                    arraylist.add(breadcrumb1);
                }

            }
            return arraylist;
        }

        public String getCategoryId()
        {
            return categoryId;
        }

        public String getDisplayName()
        {
            return displayName;
        }

        public void setCategoryId(String s)
        {
            categoryId = s;
        }

        public void setDisplayName(String s)
        {
            displayName = s;
        }

        public BreadCrumb()
        {
        }
    }


    private class ProductVideos
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        private String clipId;
        private String displayName;
        private String stillImage;
        private ArrayList videos;

        public static ArrayList loadProductVideos(JSONObject jsonobject)
        {
            ArrayList arraylist = new ArrayList();
            jsonobject = jsonobject.optJSONArray("videoFiles");
            if (jsonobject != null)
            {
                for (int i = 0; i < jsonobject.length(); i++)
                {
                    JSONObject jsonobject1 = jsonobject.optJSONObject(i);
                    if (jsonobject1 == null)
                    {
                        continue;
                    }
                    ProductVideos productvideos = new ProductVideos();
                    productvideos.clipId = jsonobject1.optString("clipId");
                    productvideos.displayName = jsonobject1.optString("displayName");
                    JSONObject jsonobject2 = jsonobject1.optJSONObject("stillImage");
                    if (jsonobject2 != null)
                    {
                        productvideos.stillImage = jsonobject2.optString("url");
                    }
                    productvideos.videos = Video.loadVideoDetails(jsonobject1.optJSONArray("sizes"));
                    arraylist.add(productvideos);
                }

            }
            return arraylist;
        }

        public String getClipId()
        {
            return clipId;
        }

        public String getDisplayName()
        {
            return displayName;
        }

        public String getStillImage()
        {
            return stillImage;
        }

        public ArrayList getVideos()
        {
            return videos;
        }

        public ProductVideos()
        {
        }

        private class Video
            implements Serializable
        {

            private static final long serialVersionUID = 1L;
            private String encoding;
            private int height;
            private String url;
            private int width;

            public static ArrayList loadVideoDetails(JSONArray jsonarray)
            {
                ArrayList arraylist = new ArrayList();
                for (int i = 0; i < jsonarray.length(); i++)
                {
                    Object obj = jsonarray.optJSONObject(i);
                    Video video = new Video();
                    video.height = ((JSONObject) (obj)).optInt("height");
                    video.width = ((JSONObject) (obj)).optInt("width");
                    obj = ((JSONObject) (obj)).optJSONArray("formats");
                    if (obj == null)
                    {
                        continue;
                    }
                    obj = ((JSONArray) (obj)).optJSONObject(0);
                    if (obj != null)
                    {
                        video.encoding = ((JSONObject) (obj)).optString("encoding");
                        video.url = ((JSONObject) (obj)).optString("url");
                        arraylist.add(video);
                    }
                }

                return arraylist;
            }

            public String getEncoding()
            {
                return encoding;
            }

            public int getHeight()
            {
                return height;
            }

            public String getUrl()
            {
                return url;
            }

            public int getWidth()
            {
                return width;
            }

            public Video()
            {
            }
        }

    }


    private class SoftwareORGameDetails
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        private ArrayList softwareORGameDetailsList;

        public static SoftwareORGameDetails getSoftwareORGameDetailsData(JSONObject jsonobject)
        {
            boolean flag = false;
            SoftwareORGameDetails softwareorgamedetails = new SoftwareORGameDetails();
            softwareorgamedetails.softwareORGameDetailsList = new ArrayList();
            Object obj = jsonobject.optJSONObject("requirements");
            if (obj != null)
            {
                JSONArray jsonarray = ((JSONObject) (obj)).optJSONArray("mac");
                if (jsonarray != null)
                {
                    Details details2 = new Details("Mac Requirements", "");
                    softwareorgamedetails.softwareORGameDetailsList.add(details2);
                    for (int i = 0; i < jsonarray.length(); i++)
                    {
                        Object obj3 = jsonarray.optJSONObject(i);
                        if (obj3 != null)
                        {
                            obj3 = new Details(((JSONObject) (obj3)).optString("displayName"), ((JSONObject) (obj3)).optString("value"));
                            softwareorgamedetails.softwareORGameDetailsList.add(obj3);
                        }
                    }

                }
                jsonarray = ((JSONObject) (obj)).optJSONArray("pc");
                if (jsonarray != null)
                {
                    Details details3 = new Details("PC Requirements", "");
                    softwareorgamedetails.softwareORGameDetailsList.add(details3);
                    for (int j = 0; j < jsonarray.length(); j++)
                    {
                        Object obj4 = jsonarray.optJSONObject(j);
                        if (obj4 != null)
                        {
                            obj4 = new Details(((JSONObject) (obj4)).optString("displayName"), ((JSONObject) (obj4)).optString("value"));
                            softwareorgamedetails.softwareORGameDetailsList.add(obj4);
                        }
                    }

                }
                jsonarray = ((JSONObject) (obj)).optJSONArray("download");
                if (jsonarray != null)
                {
                    Details details4 = new Details("Download Requirements", "");
                    softwareorgamedetails.softwareORGameDetailsList.add(details4);
                    for (int k = 0; k < jsonarray.length(); k++)
                    {
                        Object obj5 = jsonarray.optJSONObject(k);
                        if (obj5 != null)
                        {
                            obj5 = new Details(((JSONObject) (obj5)).optString("displayName"), ((JSONObject) (obj5)).optString("value"));
                            softwareorgamedetails.softwareORGameDetailsList.add(obj5);
                        }
                    }

                }
                obj = ((JSONObject) (obj)).optJSONArray("system");
                if (obj != null)
                {
                    Details details1 = new Details("System Requirements", "");
                    softwareorgamedetails.softwareORGameDetailsList.add(details1);
                    for (int l = 0; l < ((JSONArray) (obj)).length(); l++)
                    {
                        Object obj2 = ((JSONArray) (obj)).optJSONObject(l);
                        if (obj2 != null)
                        {
                            obj2 = new Details(((JSONObject) (obj2)).optString("displayName"), ((JSONObject) (obj2)).optString("value"));
                            softwareorgamedetails.softwareORGameDetailsList.add(obj2);
                        }
                    }

                }
            }
            jsonobject = jsonobject.optJSONArray("specifications");
            if (jsonobject != null)
            {
                for (int i1 = ((flag) ? 1 : 0); i1 < jsonobject.length(); i1++)
                {
                    Object obj1 = jsonobject.optJSONObject(i1);
                    if (obj1 != null)
                    {
                        obj1 = new Details(((JSONObject) (obj1)).optString("displayName"), ((JSONObject) (obj1)).optString("value"));
                        softwareorgamedetails.softwareORGameDetailsList.add(obj1);
                    }
                }

            }
            return softwareorgamedetails;
        }

        public ArrayList getSoftwareORGameDetailsList()
        {
            return softwareORGameDetailsList;
        }

        public SoftwareORGameDetails()
        {
        }

        private class Details
            implements Serializable
        {

            private static final long serialVersionUID = 1L;
            private String link;
            private String name;
            private String value;

            public static ArrayList getDetailsList(JSONArray jsonarray)
            {
                ArrayList arraylist = new ArrayList();
                for (int i = 0; i < jsonarray.length(); i++)
                {
                    Details details1 = new Details();
                    JSONObject jsonobject = jsonarray.optJSONObject(i);
                    if (jsonobject != null)
                    {
                        details1.name = jsonobject.optString("displayName");
                        details1.value = jsonobject.optString("value");
                        if (jsonobject.optJSONObject("link") != null)
                        {
                            details1.link = jsonobject.optJSONObject("link").optString("url");
                        }
                    }
                    arraylist.add(details1);
                }

                return arraylist;
            }

            public String getDisplayName()
            {
                return name;
            }

            public String getLink()
            {
                return link;
            }

            public String getValue()
            {
                return value;
            }

            public Details()
            {
                link = "";
            }

            public Details(String s, String s1)
            {
                link = "";
                name = s;
                value = s1;
            }
        }

    }


    private class BonusContent
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        private String availability;
        private String description;
        private String displayName;
        private String imageUrl;

        public static ArrayList loadFreeBonusContent(JSONArray jsonarray)
        {
            ArrayList arraylist = new ArrayList();
            for (int i = 0; i < jsonarray.length(); i++)
            {
                JSONObject jsonobject = jsonarray.optJSONObject(i);
                if (jsonobject == null)
                {
                    continue;
                }
                BonusContent bonuscontent = new BonusContent();
                bonuscontent.displayName = jsonobject.optString("displayName");
                bonuscontent.description = jsonobject.optString("description");
                bonuscontent.availability = jsonobject.optString("availabilityMessage");
                jsonobject = jsonobject.optJSONObject("primaryImage");
                if (jsonobject != null)
                {
                    bonuscontent.imageUrl = jsonobject.optString("url");
                }
                arraylist.add(bonuscontent);
            }

            return arraylist;
        }

        public String getAvailability()
        {
            return availability;
        }

        public String getDescription()
        {
            return description;
        }

        public String getDisplayName()
        {
            return displayName;
        }

        public String getImageUrl()
        {
            return imageUrl;
        }

        public BonusContent()
        {
        }
    }

}
