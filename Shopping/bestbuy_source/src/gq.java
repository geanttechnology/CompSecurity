// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bestbuy.android.api.lib.models.SIResponse;
import com.bestbuy.android.api.lib.models.blueshirt.AppoinmentRequest;
import com.bestbuy.android.api.lib.models.blueshirt.FeatureFlagResponse;
import com.bestbuy.android.api.lib.models.blueshirt.TimeSlotResponse;
import com.bestbuy.android.api.lib.models.blueshirt.UpdateAppointmentRequest;
import com.bestbuy.android.api.lib.models.browse.Category;
import com.bestbuy.android.api.lib.models.browse.UberCategoryList;
import com.bestbuy.android.api.lib.models.home.HomeFragmentResponse;
import com.bestbuy.android.api.lib.models.home.Recommendation;
import com.bestbuy.android.api.lib.models.home.pageconfiguration.PageConfiguation;
import com.bestbuy.android.api.lib.models.home.pageconfiguration.PageConfigurationInnerResponse;
import com.bestbuy.android.api.lib.models.home.pageconfiguration.PageConfigurationResponse;
import com.bestbuy.android.api.lib.models.home.pageconfiguration.SIPageConfiguration;
import com.bestbuy.android.api.lib.models.home.pageconfiguration.Widget;
import com.bestbuy.android.api.lib.models.home.recentlyviewed.RecentlyViewedAlsoViewedResponse;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.PDPOverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.PDPOverviewResponseRoot;
import com.bestbuy.android.api.lib.models.pdp.Requirement;
import com.bestbuy.android.api.lib.models.pdp.SIPDPOverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.SoftWareDetails;
import com.bestbuy.android.api.lib.models.pdp.Specification;
import com.bestbuy.android.api.lib.models.pdp.castandcrew.CastAndCrewParent;
import com.bestbuy.android.api.lib.models.pdp.episodes.PDPEpisodesParent;
import com.bestbuy.android.api.lib.models.pdp.games.GameDetails;
import com.bestbuy.android.api.lib.models.pdpaccessories.AccessoriesResponse;
import com.bestbuy.android.api.lib.models.pdpaccessories.PDPAccessoriesParent;
import com.bestbuy.android.api.lib.models.pdpaccessories.SIAccessories;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.BuyingOptionsResponse;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.PDPBuyingOptionsParent;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.SIBuyingOptions;
import com.bestbuy.android.api.lib.models.pdpfeaturereviews.FeatureReviewsResponse;
import com.bestbuy.android.api.lib.models.pdpfeaturereviews.PDPFeaturesParent;
import com.bestbuy.android.api.lib.models.pdpfeaturereviews.SIFeatureReviews;
import com.bestbuy.android.api.lib.models.pdpmovies.MoviesResponse;
import com.bestbuy.android.api.lib.models.pdpmovies.PDPMoviesParent;
import com.bestbuy.android.api.lib.models.pdpmovies.SIMovies;
import com.bestbuy.android.api.lib.models.pdpmusic.MusicResponse;
import com.bestbuy.android.api.lib.models.pdpmusic.PDPMusicParent;
import com.bestbuy.android.api.lib.models.pdpmusic.SIMusic;
import com.bestbuy.android.api.lib.models.pdpreviews.PDPReviewsParent;
import com.bestbuy.android.api.lib.models.pdpreviews.ReviewsResponse;
import com.bestbuy.android.api.lib.models.pdpreviews.SIReviews;
import com.bestbuy.android.api.lib.models.releasemgt.SupportedVersionsResponse;
import com.bestbuy.android.api.lib.models.remix.StoreList;
import com.bestbuy.android.api.lib.models.search.AppliedFacets;
import com.bestbuy.android.api.lib.models.search.CategoryFacets;
import com.bestbuy.android.api.lib.models.search.Documents;
import com.bestbuy.android.api.lib.models.search.FacetValues;
import com.bestbuy.android.api.lib.models.search.Facets;
import com.bestbuy.android.api.lib.models.search.RequestInfo;
import com.bestbuy.android.api.lib.models.search.SearchApi;
import com.bestbuy.android.api.lib.models.search.Si;
import com.bestbuy.android.api.lib.models.search.SiSearch;
import com.bestbuy.android.api.lib.models.search.SuggestedSearch;
import com.bestbuy.android.api.lib.models.solr.SolrResponse;
import com.bestbuy.android.api.lib.models.store.StoresResponse;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Recommendations;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Response;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.SI;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.SummariesPriceBlockResponse;
import com.google.gson.Gson;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

public class gq
{

    private static final String a = gq.getName();
    private static gr b;

    public gq()
    {
    }

    public static FeatureFlagResponse a(Activity activity, String s, String s1)
    {
        activity = a();
        activity = (new StringBuilder()).append(((gr) (activity)).f).append("/si/featureFlags/blueAssist").toString();
        List list = a(false);
        ArrayList arraylist = new ArrayList();
        if (s != null && s1 != null)
        {
            arraylist.add(new BasicNameValuePair("lat", s));
            arraylist.add(new BasicNameValuePair("lon", s1));
        }
        activity = gw.a(activity, arraylist, list, null, true);
        s = new SIResponse();
        activity = (SIResponse)(new gy()).a(activity, s);
        if (activity != null && activity.getSi() != null)
        {
            s = activity.getSi();
            if (s != null && s.getResponse() != null)
            {
                activity = new FeatureFlagResponse();
                s = s.getResponse();
                activity.setBookABlueShirtStores(s.getBookABlueShirtStores());
                activity.setBookABlueShirt(s.isBookABlueShirt());
                activity.setChat(s.isChat());
                return activity;
            }
        }
        return null;
    }

    public static HomeFragmentResponse a(Context context)
    {
        Object obj = a();
        obj = gw.a((new StringBuilder()).append(((gr) (obj)).f).append("/si/homeScreen/bbyApp").toString(), null, b(true), null, true);
        if (obj != null)
        {
            return b(((String) (obj)), context);
        } else
        {
            throw new Exception();
        }
    }

    public static RecentlyViewedAlsoViewedResponse a(String s, Recommendation recommendation)
    {
        gr gr1 = a();
        List list = b(true);
        if (recommendation != null)
        {
            s = (new StringBuilder()).append(gr1.f).append(recommendation.getUrl().replace("{context_id}", s)).toString();
        } else
        {
            s = (new StringBuilder()).append(gr1.f).append("/si/recommendations/recentlyViewedAlsoViewed/").append(s).append("/9?datasetVersion=").toString();
        }
        recommendation = new ArrayList();
        try
        {
            s = gw.a(s, recommendation, list, null, true);
            recommendation = new RecentlyViewedAlsoViewedResponse();
            s = (RecentlyViewedAlsoViewedResponse)(new gy()).a(s, recommendation);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        return s;
    }

    public static PDPOverviewResponseRoot a(String s, String s1)
    {
        Object obj;
        List list;
        ArrayList arraylist;
        obj = null;
        gr gr1 = a();
        list = b(true);
        String s2 = "";
        arraylist = new ArrayList();
        if (s1 != null)
        {
            arraylist.add(new BasicNameValuePair("storeId", (new StringBuilder()).append("").append(s1).toString()));
        }
        s1 = s2;
        if (s != null)
        {
            s1 = s2;
            if (!s.isEmpty())
            {
                s1 = (new StringBuilder()).append(gr1.f).append("/si/pdp/overview/").append(s).toString();
            }
        }
        Object obj1;
        if (s1.isEmpty())
        {
            break MISSING_BLOCK_LABEL_325;
        }
        obj1 = new PDPOverviewResponseRoot();
        s1 = gw.a(s1, arraylist, list, null, true);
        s1 = (PDPOverviewResponseRoot)(new gy()).a(s1, ((gu) (obj1)));
        obj1 = b(s);
        s = ((String) (obj));
        if (obj1 != null)
        {
            s = ((String) (obj));
            try
            {
                if (((SI) (obj1)).getResponse() != null)
                {
                    s = ((SI) (obj1)).getResponse().getPriceBlock();
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw s;
            }
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_320;
        }
        if (s1.getSi() != null && s1.getSi().getResponse() != null && s1.getSi().getResponse().getOverview() != null)
        {
            if (s1.getSi().getResponse().getOverview().getSoftwareDetails() != null)
            {
                obj = s1.getSi().getResponse().getOverview().getSoftwareDetails();
                obj1 = ((SoftWareDetails) (obj)).getSpecifications();
                ((SoftWareDetails) (obj)).setSpecifications(a(((SoftWareDetails) (obj)).getRequirements(), ((ArrayList) (obj1))));
            }
            if (s1.getSi().getResponse().getOverview().getGameDetails() != null)
            {
                obj = s1.getSi().getResponse().getOverview().getGameDetails();
                obj1 = ((GameDetails) (obj)).getSpecifications();
                ((GameDetails) (obj)).setSpecifications(a(((GameDetails) (obj)).getRequirements(), ((ArrayList) (obj1))));
            }
            s1.getSi().getResponse().getOverview().setRestrictedPriceBlock(s);
        }
        return s1;
        return null;
    }

    public static FeatureReviewsResponse a(String s, String s1, int i1, String s2)
    {
        gr gr1 = a();
        List list = a(true);
        ArrayList arraylist = new ArrayList();
        String s3 = "";
        if (s != null && i1 == 0)
        {
            s = (new StringBuilder()).append(gr1.f).append("/si/reviews/").append(s).toString();
            arraylist.add(new BasicNameValuePair("feature", URLEncoder.encode(s1, "UTF-8")));
            arraylist.add(new BasicNameValuePair("page", Integer.toString(i1)));
        } else
        {
            s = s3;
            if (s2 != null)
            {
                s = s3;
                if (!s2.isEmpty())
                {
                    s = (new StringBuilder()).append(gr1.f).append(s2).toString();
                }
            }
        }
        try
        {
            s = gw.a(s, arraylist, list, null, true);
            s1 = new PDPFeaturesParent();
            s = ((PDPFeaturesParent)(new gy()).a(s, s1)).getSi().getResponse();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        return s;
    }

    public static ReviewsResponse a(String s, int i1, int j1, String s1)
    {
        Object obj = a();
        List list = a(true);
        s = (new StringBuilder()).append(((gr) (obj)).a()).append("/si/pdp/reviewDetails/").append(s).toString();
        obj = new ArrayList();
        ((List) (obj)).add(new BasicNameValuePair("start", Integer.toString(i1)));
        ((List) (obj)).add(new BasicNameValuePair("limit", Integer.toString(j1)));
        ((List) (obj)).add(new BasicNameValuePair("sort", s1));
        s1 = new PDPReviewsParent();
        try
        {
            s = gw.a(s, ((List) (obj)), list, null, true);
            s = (PDPReviewsParent)(new gy()).a(s, s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            gs.d(a, (new StringBuilder()).append("Error making GET request: ").append(s.getLocalizedMessage()).toString());
            throw s;
        }
        return s.getSi().getResponse();
    }

    private static SupportedVersionsResponse a(SupportedVersionsResponse supportedversionsresponse)
    {
        supportedversionsresponse.setType(100);
        supportedversionsresponse.setStoreLink("market://details?id=com.bestbuy.android");
        supportedversionsresponse.setStoreButtonTitle("Install");
        supportedversionsresponse.setCancelButtonTitle("Later");
        supportedversionsresponse.setFeedbackButtonTitle("Feedback");
        supportedversionsresponse.setUpdateButtonTitle("Get the Update");
        return supportedversionsresponse;
    }

    public static SupportedVersionsResponse a(ft ft1, Context context)
    {
        ft1 = a();
        ft1 = gw.a((new StringBuilder()).append(((gr) (ft1)).f).append("/si/supportedVersions/bby-android-app").toString(), null, a(false), null, true);
        if (ft1 != null)
        {
            return a(((String) (ft1)), context);
        } else
        {
            throw new Exception();
        }
    }

    private static SupportedVersionsResponse a(String s, Context context)
    {
        new gy();
        context = (SupportedVersionsResponse)(new Gson()).fromJson(s, com/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse);
        s = context;
        if (context != null)
        {
            s = a(((SupportedVersionsResponse) (context)));
        }
        return s;
    }

    public static StoreList a(String s, String s1, int i1, int j1)
    {
        Object obj = a();
        s = (new StringBuilder()).append(((gr) (obj)).f).append("/si/stores/").append(s).toString();
        obj = a(false);
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("start", (new StringBuilder()).append("").append(i1).toString()));
        arraylist.add(new BasicNameValuePair("limit", (new StringBuilder()).append("").append(j1).toString()));
        if (s1 != null && !s1.isEmpty())
        {
            arraylist.add(new BasicNameValuePair("skuId", s1));
        }
        return f(gw.a(s, arraylist, ((List) (obj)), null, true));
    }

    public static SearchApi a(String s, String s1, int i1)
    {
        gr gr1 = a();
        List list = b(false);
        String s2 = "";
        s = (new StringBuilder()).append(gr1.f).append(s).append("&page=").append(i1).append("&sort=").append(s1).toString();
        try
        {
            s = gw.a(s, null, list, null, true);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = s2;
        }
        return h(s);
    }

    public static SearchApi a(String s, String s1, String s2, Map map, String s3, boolean flag, boolean flag1, int i1, 
            int j1)
    {
        Object obj;
        SearchApi searchapi;
        obj = new ArrayList();
        searchapi = new SearchApi();
        Object obj1 = a();
        List list = b(true);
        ArrayList arraylist = new ArrayList();
        obj1 = (new StringBuilder()).append(((gr) (obj1)).f).append("/si/products/search/www?").toString();
        HashMap hashmap = new HashMap();
        if (s != null)
        {
            if (!s.contains("sort"));
        }
        if (s3 != null && !s3.isEmpty())
        {
            hashmap.put("sort", s3);
        } else
        if (s != null && s.contains("si/products/search/www"))
        {
            hashmap.put("sort", "Best-Selling");
        } else
        if (s3 == null || s3.isEmpty())
        {
            hashmap.put("sort", "Best-Match");
        }
        hashmap.put("enableRedirect", "false");
        hashmap.put("page", (new StringBuilder()).append("").append(j1).toString());
        hashmap.put("rows", (new StringBuilder()).append("").append(i1).toString());
        if (s != null)
        {
            if (s.contains("si/products/search/www"))
            {
                s3 = TextUtils.split(TextUtils.split(s, Pattern.quote("?"))[1], Pattern.quote("&"));
                for (i1 = 0; i1 < s3.length; i1++)
                {
                    String as[] = TextUtils.split(s3[i1], Pattern.quote("="));
                    arraylist.add(new BasicNameValuePair(as[0], as[1]));
                }

            } else
            {
                hashmap.put("query", s);
            }
        }
        if (map != null && !map.isEmpty())
        {
            hashmap.putAll(map);
        }
        new StringBuffer();
        if (hashmap != null)
        {
            map = hashmap.entrySet().iterator();
            do
            {
                if (!map.hasNext())
                {
                    break;
                }
                s3 = (java.util.Map.Entry)map.next();
                Object obj2 = (String)s3.getValue();
                if (obj2 != null && !((String) (obj2)).isEmpty() && !((String) (obj2)).equals("null"))
                {
                    if (((String) (obj2)).contains("|"))
                    {
                        obj2 = new ArrayList(Arrays.asList(((String) (obj2)).split("\\|")));
                        i1 = 0;
                        while (i1 < ((ArrayList) (obj2)).size()) 
                        {
                            String s4 = (String)((ArrayList) (obj2)).get(i1);
                            if (!arraylist.contains(new BasicNameValuePair((String)s3.getKey(), URLEncoder.encode(s4, "UTF-8"))))
                            {
                                arraylist.add(new BasicNameValuePair((String)s3.getKey(), URLEncoder.encode(s4, "UTF-8")));
                            }
                            i1++;
                        }
                    } else
                    if (!arraylist.contains(new BasicNameValuePair((String)s3.getKey(), URLEncoder.encode((String)s3.getValue(), "UTF-8"))))
                    {
                        arraylist.add(new BasicNameValuePair((String)s3.getKey(), URLEncoder.encode((String)s3.getValue(), "UTF-8")));
                    }
                }
            } while (true);
        }
        arraylist.add(new BasicNameValuePair("searchType", s1));
        arraylist.add(new BasicNameValuePair("facetsOnly", Boolean.toString(flag)));
        if (s2 != null && !s2.isEmpty())
        {
            arraylist.add(new BasicNameValuePair("storeId", s2));
        }
        try
        {
            s1 = gw.a(((String) (obj1)), arraylist, list, null, true);
            s2 = new SiSearch();
            s1 = (SiSearch)(new gy()).a(s1, s2);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            gs.d(a, (new StringBuilder()).append("Error making GET request: ").append(s.getLocalizedMessage()).toString());
            throw s;
        }
        if (s1 == null) goto _L2; else goto _L1
_L1:
        if (s1.getSi() == null || s1.getSi().getResponse() == null || s1.getSi().getResponse().getSearchApi() == null) goto _L2; else goto _L3
_L3:
        s2 = s1.getSi().getResponse().getSearchApi();
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_892;
        }
        i1 = 0;
_L5:
        if (i1 >= s2.getDocuments().size())
        {
            break; /* Loop/switch isn't completed */
        }
        ((ArrayList) (obj)).add(((Documents)s2.getDocuments().get(i1)).getSkuid());
        i1++;
        if (true) goto _L5; else goto _L4
_L4:
        s2.setSkuList(((ArrayList) (obj)));
        s2.setSkuDetails(a(((ArrayList) (obj))));
        s1 = new ArrayList();
        if (s2.getFacets() == null) goto _L7; else goto _L6
_L6:
        i1 = 0;
_L21:
        if (i1 >= s2.getFacets().size()) goto _L9; else goto _L8
_L8:
        if (!((Facets)s2.getFacets().get(i1)).getSystemName().equals("Features Dynamic - Hidden") && !((Facets)s2.getFacets().get(i1)).getSystemName().equals("Features (Hidden) DO NOT UNHIDE") && !((Facets)s2.getFacets().get(i1)).getFacetField().equals("subclassid_facet") && !((Facets)s2.getFacets().get(i1)).isDisplayContext().equals("No")) goto _L11; else goto _L10
_L11:
        s1.add(s2.getFacets().get(i1));
        map = ((Facets)s2.getFacets().get(i1)).getValues();
        if (map == null) goto _L10; else goto _L12
_L12:
        j1 = 0;
_L22:
        if (j1 >= map.size()) goto _L10; else goto _L13
_L13:
        if (((FacetValues)map.get(j1)).getCategoryPath() != null && !((FacetValues)map.get(j1)).getCategoryPath().isEmpty())
        {
            s2.getCategoryMap().put(((FacetValues)map.get(j1)).getValue(), ((FacetValues)map.get(j1)).getCategoryPath());
        }
          goto _L14
_L9:
        s2.setFacets(s1);
_L7:
        map = new HashMap();
        i1 = 0;
_L23:
        if (i1 >= s2.getRequestInfo().getAppliedFacets().size())
        {
            break MISSING_BLOCK_LABEL_1464;
        }
        s1 = (AppliedFacets)s2.getRequestInfo().getAppliedFacets().get(i1);
        s3 = s1.getId();
        if (s3.equals("category_facet")) goto _L16; else goto _L15
_L15:
        s1 = s1.getValues();
        map.put(s3, s1);
        if (s1.size() <= 1) goto _L18; else goto _L17
_L17:
        map.put(s3, s1);
_L16:
        s1 = s2.getRequestInfo().getCategoryFacet();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_1492;
        }
        if (s1.getCategoryPath() != null && !s1.getCategoryPath().isEmpty() && !s.contains(s1.getCategoryPath()))
        {
            s3 = new ArrayList();
            s3.add(s1.getCategoryName());
            map.put("category_facet", s3);
        }
        break MISSING_BLOCK_LABEL_1492;
_L18:
        obj = ((String)s1.get(0)).replace("[", "").replace("]", "").replace("\\", "");
        if (!((String) (obj)).contains("|"))
        {
            break MISSING_BLOCK_LABEL_1446;
        }
        s1 = new ArrayList(Arrays.asList(((String) (obj)).split("\\|")));
        j1 = 0;
_L20:
        if (j1 >= s1.size())
        {
            break; /* Loop/switch isn't completed */
        }
        s1.set(j1, (String)s1.get(j1));
        j1++;
        if (true) goto _L20; else goto _L19
_L19:
        map.put(s3, s1);
          goto _L16
        s1 = new ArrayList();
        s1.add(obj);
          goto _L19
        s2.setRequestedFacets(map);
        return s2;
_L2:
        return searchapi;
_L10:
        i1++;
          goto _L21
_L14:
        j1++;
          goto _L22
        i1++;
          goto _L23
    }

    public static SolrResponse a(String s, Context context, String s1, String s2, String s3, int i1, int j1, boolean flag)
    {
        return a(s, context, ((ArrayList) (null)), s1, s2, s3, i1, j1, flag);
    }

    public static SolrResponse a(String s, Context context, ArrayList arraylist, String s1, String s2, String s3, int i1, int j1, 
            boolean flag)
    {
        String s4;
        SolrResponse solrresponse;
        ArrayList arraylist1;
        ArrayList arraylist2;
        ArrayList arraylist3;
        gr gr1;
        List list;
        ArrayList arraylist4;
        solrresponse = new SolrResponse();
        gr1 = a();
        s4 = "";
        list = b(true);
        arraylist4 = new ArrayList();
        arraylist1 = new ArrayList();
        arraylist2 = new ArrayList();
        arraylist3 = new ArrayList();
        if (!s.equals("RecentlyRemoved") && !s.equals("BundleItems") && !s.equals("PLP") && !s.equals("Best-Match")) goto _L2; else goto _L1
_L1:
        solrresponse.setTotalCount(arraylist.size());
        if (arraylist.size() > j1)
        {
            int j2 = (i1 - 1) * j1;
            int i2 = j2 + j1;
            int k1 = i2;
            if (i2 > arraylist.size())
            {
                k1 = arraylist.size();
            }
            arraylist1.addAll(arraylist.subList(j2, k1));
        } else
        {
            arraylist1.addAll(arraylist);
        }
_L12:
        if (!s.equals("MostPopular") && !s.equals("RecenltyViewed") && !s.equals("CustomerAlsoBought") && !s.equals("CustomerAlsoViewed") && !s.equals("Trending"))
        {
            break MISSING_BLOCK_LABEL_936;
        }
        if (i1 <= 1 || j1 != 50) goto _L4; else goto _L3
_L3:
        s = new ArrayList();
        if (arraylist1 != null && arraylist1.size() > 24 && arraylist1.size() <= j1)
        {
            int l1;
            for (i1 = 25; i1 < arraylist1.size(); i1++)
            {
                s.add(arraylist1.get(i1));
            }

            solrresponse.setBbyProducts(a(((ArrayList) (s))));
        }
          goto _L5
_L2:
        if (!s.equals("BestSelling")) goto _L7; else goto _L6
_L6:
label0:
        {
            if (s3 != null)
            {
                context = s3;
                if (!s3.isEmpty())
                {
                    break label0;
                }
            }
            context = "all";
        }
        context = (new StringBuilder()).append("/api/category/").append(s1).append("/store/").append(context).append("/items/purchased").toString();
_L11:
        try
        {
            context = (new JSONObject(gw.a((new StringBuilder()).append(gr1.f).append(context).toString(), arraylist4, list, null, true))).optJSONObject("si").optJSONObject("response").optJSONObject("recommendations").optJSONArray("skus");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            gs.d(a, (new StringBuilder()).append("Could not get Most Popular Products Data: ").append(s.getLocalizedMessage()).toString());
            throw s;
        }
        if (context == null)
        {
            break; /* Loop/switch isn't completed */
        }
        l1 = 0;
_L9:
        if (l1 >= context.length())
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist = context.optJSONObject(l1);
        arraylist1.add(arraylist.optString("skuId"));
        arraylist2.add(arraylist.optString("ep"));
        arraylist3.add(arraylist.optJSONObject("summary").optJSONObject("parentCategory").optString("categoryId"));
        l1++;
        if (true) goto _L9; else goto _L8
_L8:
        break; /* Loop/switch isn't completed */
_L7:
        if (s.equals("Trending"))
        {
            context = (new StringBuilder()).append("/si/recommendations/trendingMostPopular/cat00000/").append(j1).toString();
        } else
        if (s.equals("RecenltyViewed"))
        {
            if (!gf.a(context))
            {
                arraylist = gg.b();
                gf.a(context, arraylist);
                context = arraylist;
            } else
            {
                context = gf.b(context);
            }
            context = (new StringBuilder()).append("/si/recommendations/recentlyViewed/").append(context).append("/").append(j1).toString();
        } else
        if (s.equals("Recommended"))
        {
            context = gf.b(context);
            context = (new StringBuilder()).append("/api/context/").append(context).append("/items/recommended.json").toString();
        } else
        if (s.equals("CustomerAlsoBought"))
        {
            context = (new StringBuilder()).append("/si/recommendations/alsoBought/").append(s2).append("/").append(j1).toString();
        } else
        if (s.equals("CustomerAlsoViewed"))
        {
            context = (new StringBuilder()).append("/si/recommendations/alsoViewed/").append(s2).append("/").append(j1).toString();
        } else
        if (s.equals("MostPopular"))
        {
            context = (new StringBuilder()).append("/si/recommendations/mostPopular/").append(s1).append("/").append(j1).toString();
        } else
        {
            context = s4;
            if (s.equals("Similar"))
            {
                context = (new StringBuilder()).append("/api/item/").append(s2).append("/similarproducts.json").toString();
            }
        }
        if (true) goto _L11; else goto _L10
_L10:
        solrresponse.setTotalCount(arraylist1.size());
        solrresponse.setSkuList(arraylist1);
          goto _L12
_L5:
        return solrresponse;
_L4:
        if (i1 != 1) goto _L5; else goto _L13
_L13:
        solrresponse.setBbyProducts(a(arraylist1));
        return solrresponse;
        solrresponse.setBbyProducts(a(arraylist1));
        return solrresponse;
    }

    public static gr a()
    {
        return b;
    }

    public static String a(String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        Object obj = null;
        Object obj1 = a();
        s = (new StringBuilder()).append(((gr) (obj1)).f).append("/si/d/scheduling/stores/").append(s).append("/appointments").toString();
        obj1 = a(false);
        AppoinmentRequest appoinmentrequest = new AppoinmentRequest();
        appoinmentrequest.setDate(s1);
        appoinmentrequest.setTime(s2);
        appoinmentrequest.setFirstName(s3);
        appoinmentrequest.setLastName(s4);
        appoinmentrequest.setEmailAddress(s5);
        appoinmentrequest.setPhoneNumber(s6);
        appoinmentrequest.setSendEmail(true);
        s1 = new JSONObject(gw.b(s, null, ((List) (obj1)), (new gy()).a(appoinmentrequest), "application/json"));
        s = obj;
        if (s1 != null)
        {
            s1 = s1.optJSONObject("si");
            s = obj;
            if (s1 != null)
            {
                s1 = s1.optJSONObject("response");
                s = obj;
                if (s1 != null)
                {
                    s = s1.optString("appointmentId");
                }
            }
        }
        return s;
    }

    public static ArrayList a(Recommendation recommendation)
    {
        Object obj1 = a();
        Object obj = b(true);
        if (recommendation == null)
        {
            recommendation = (new StringBuilder()).append(((gr) (obj1)).f).append("/si/recommendations/trendingMostPopular/cat00000/10").toString();
        } else
        {
            recommendation = (new StringBuilder()).append(((gr) (obj1)).f).append(recommendation.getUrl()).toString();
        }
        obj1 = new ArrayList();
        try
        {
            recommendation = gw.a(recommendation, ((List) (obj1)), ((List) (obj)), null, true);
            obj = new SummariesPriceBlockResponse();
            recommendation = (SummariesPriceBlockResponse)(new gy()).a(recommendation, ((gu) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Recommendation recommendation)
        {
            gs.d(a, (new StringBuilder()).append("Could not get Trending Products Data: ").append(recommendation.getLocalizedMessage()).toString());
            throw recommendation;
        }
        if (recommendation == null)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        if (recommendation.getSi() == null || recommendation.getSi().getResponse() == null || recommendation.getSi().getResponse().getRecommendations() == null || recommendation.getSi().getResponse().getRecommendations().getSkuList() == null)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        recommendation = recommendation.getSi().getResponse().getRecommendations().getSkuList();
        return recommendation;
        return null;
    }

    private static ArrayList a(PageConfigurationResponse pageconfigurationresponse)
    {
        pageconfigurationresponse = pageconfigurationresponse.getSi().getResponse().getPageConfiguration().getWidgets();
        ArrayList arraylist = new ArrayList();
        if (pageconfigurationresponse != null)
        {
            for (int i1 = 0; i1 < pageconfigurationresponse.size(); i1++)
            {
                if (((Widget)pageconfigurationresponse.get(i1)).getOffers() == null || ((Widget)pageconfigurationresponse.get(i1)).getOffers().size() <= 0)
                {
                    continue;
                }
                for (int j1 = 0; j1 < ((Widget)pageconfigurationresponse.get(i1)).getOffers().size(); j1++)
                {
                    arraylist.add(((Widget)pageconfigurationresponse.get(i1)).getOffers().get(j1));
                }

            }

        }
        return arraylist;
    }

    private static ArrayList a(Requirement requirement, ArrayList arraylist)
    {
        if (arraylist != null && !arraylist.isEmpty())
        {
            Specification specification = new Specification();
            specification.setDisplayName("Specifications");
            specification.setValue("");
            arraylist.add(0, specification);
        } else
        {
            arraylist = new ArrayList();
        }
        if (requirement != null)
        {
            if (requirement.getMacSpecifications() != null)
            {
                Specification specification1 = new Specification();
                specification1.setDisplayName("Mac Requirements");
                specification1.setValue("");
                arraylist.add(specification1);
                arraylist.addAll(requirement.getMacSpecifications());
            }
            if (requirement.getPcSpecifications() != null)
            {
                Specification specification2 = new Specification();
                specification2.setDisplayName("PC Requirements");
                specification2.setValue("");
                arraylist.add(specification2);
                arraylist.addAll(requirement.getPcSpecifications());
            }
            if (requirement.getDownload() != null)
            {
                Specification specification3 = new Specification();
                specification3.setDisplayName("Download Requirements");
                specification3.setValue("");
                arraylist.add(specification3);
                arraylist.addAll(requirement.getDownload());
            }
            if (requirement.getSystem() != null)
            {
                Specification specification4 = new Specification();
                specification4.setDisplayName("System Requirements");
                specification4.setValue("");
                arraylist.add(specification4);
                arraylist.addAll(requirement.getSystem());
            }
        }
        return arraylist;
    }

    public static ArrayList a(ft ft1, String s)
    {
        ft1 = a();
        ft1 = (new StringBuilder()).append(((gr) (ft1)).f).append("/si/search/suggest/www?").toString();
        List list = a(false);
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("query", URLEncoder.encode(s, "UTF-8")));
        return SuggestedSearch.getSuggestionsList((new JSONObject(gw.a(ft1, arraylist, list, null, true))).optJSONObject("si").optJSONObject("response").optJSONArray("suggestions"));
    }

    public static ArrayList a(String s, int i1, int j1, boolean flag)
    {
        gr gr1 = a();
        return p((new StringBuilder()).append(gr1.f).append("/si/recommendations/mostPopular/").append(s).append("/").append(j1).toString());
    }

    public static ArrayList a(ArrayList arraylist)
    {
        gq;
        JVM INSTR monitorenter ;
        Object obj = a();
        if (!arraylist.isEmpty()) goto _L2; else goto _L1
_L1:
        arraylist = new ArrayList();
_L3:
        gq;
        JVM INSTR monitorexit ;
        return arraylist;
_L2:
        StringBuilder stringbuilder = new StringBuilder();
        int i1 = 0;
_L4:
        String s;
        if (i1 >= arraylist.size())
        {
            break MISSING_BLOCK_LABEL_104;
        }
        s = (String)arraylist.get(i1);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        if (!s.isEmpty())
        {
            stringbuilder.append((String)arraylist.get(i1));
            if (i1 != arraylist.size() - 1)
            {
                stringbuilder.append(",");
            }
        }
        break MISSING_BLOCK_LABEL_272;
        arraylist = stringbuilder.toString();
        arraylist = (new StringBuilder()).append(((gr) (obj)).f).append("/si/products/pricesAndSummaries?").append("skus=").append(arraylist).toString();
        obj = c(true);
        arraylist = gw.a(arraylist, null, ((List) (obj)), null, true);
        obj = new SummariesPriceBlockResponse();
        arraylist = (SummariesPriceBlockResponse)(new gy()).a(arraylist, ((gu) (obj)));
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_229;
        }
        if (arraylist.getSi() == null || arraylist.getSi().getResponse() == null || arraylist.getSi().getResponse().getSkuList() == null)
        {
            break MISSING_BLOCK_LABEL_229;
        }
        arraylist = arraylist.getSi().getResponse().getSkuList();
          goto _L3
        arraylist = null;
          goto _L3
        arraylist;
        gs.d(a, (new StringBuilder()).append("Error making GET request: ").append(arraylist.getLocalizedMessage()).toString());
        throw arraylist;
        arraylist;
        gq;
        JVM INSTR monitorexit ;
        throw arraylist;
        i1++;
          goto _L4
    }

    private static ArrayList a(List list, String s)
    {
        ArrayList arraylist = new ArrayList();
        try
        {
            list = gw.a(s, arraylist, list, null, true);
            s = new SummariesPriceBlockResponse();
            list = (SummariesPriceBlockResponse)(new gy()).a(list, s);
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            gs.d(a, (new StringBuilder()).append("Could not get Also Viewed Products Data: ").append(list.getLocalizedMessage()).toString());
            throw list;
        }
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        if (list.getSi() == null || list.getSi().getResponse() == null || list.getSi().getResponse().getRecommendations() == null || list.getSi().getResponse().getRecommendations().getSkuList() == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        list = list.getSi().getResponse().getRecommendations().getSkuList();
        return list;
        return null;
    }

    private static List a(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        for (int i1 = 0; i1 < jsonarray.length(); i1++)
        {
            Object obj = jsonarray.optJSONObject(i1);
            Category category = new Category();
            category.setWidgetType(((JSONObject) (obj)).optString("widgetType", ""));
            category.setName(((JSONObject) (obj)).optString("name", ""));
            category.setCategoryId(((JSONObject) (obj)).optString("categoryId", ""));
            category.setDisplayOnly(((JSONObject) (obj)).optString("displayOnly", ""));
            category.setSearchPath(((JSONObject) (obj)).optString("searchPath", ""));
            if (category.getSearchPath() == null || category.getSearchPath() != null && category.getSearchPath().isEmpty())
            {
                obj = ((JSONObject) (obj)).optJSONArray("groups");
                if (obj != null && ((JSONArray) (obj)).length() > 0)
                {
                    category.setGroups(a(((JSONArray) (obj))));
                }
            }
            if (category.getName() != null && !category.getName().isEmpty())
            {
                arraylist.add(category);
            }
        }

        return arraylist;
    }

    private static List a(boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("Content-type", "application/json"));
        arraylist.add(new BasicNameValuePair("Accept", "application/json"));
        arraylist.add(new BasicNameValuePair("X-SI-API-VERSION", "1.0"));
        if (flag)
        {
            String s = fr.b();
            if (s != null && !s.isEmpty())
            {
                arraylist.add(new BasicNameValuePair("X-SI-USER-UUID", fr.d()));
                arraylist.add(new BasicNameValuePair("access_token", s));
            }
        }
        return arraylist;
    }

    public static void a(ft ft1)
    {
        if (ft1 == ft.a)
        {
            b = gr.a;
            return;
        }
        if (ft1 == ft.f)
        {
            b = gr.b;
            return;
        }
        if (ft1 == ft.h)
        {
            b = gr.c;
            return;
        }
        if (ft1 == ft.d)
        {
            b = gr.d;
            return;
        }
        if (ft1 == ft.l)
        {
            b = gr.e;
            return;
        } else
        {
            b = gr.a;
            return;
        }
    }

    public static void a(String s)
    {
        gr.a("CUSTOM").f = s;
    }

    public static void a(String s, String s1, String s2)
    {
        gr gr1 = a();
        s = (new StringBuilder()).append(gr1.f).append("/si/d/scheduling/stores/").append(s).append("/appointments/").append(s2).toString();
        s2 = a(false);
        s2.add(new BasicNameValuePair("emailAddress", s1));
        gw.c(s, null, s2, null, false);
    }

    public static void a(String s, String s1, String s2, String s3)
    {
        Object obj = fr.d();
        String s4 = fr.b();
        gr gr1 = a();
        List list = a(false);
        if (s4 != null && !s4.isEmpty())
        {
            list.add(new BasicNameValuePair("access_token", s4));
        }
        if (obj != null && !((String) (obj)).isEmpty())
        {
            s4 = (new StringBuilder()).append(gr1.f).append("/si/users/").append(((String) (obj))).append("/devices").toString();
            list.add(new BasicNameValuePair("uuid", ((String) (obj))));
        } else
        {
            s4 = (new StringBuilder()).append(gr1.f).append("/si/devices").toString();
        }
        obj = new JSONObject();
        ((JSONObject) (obj)).put("device-token", s);
        ((JSONObject) (obj)).put("operating-system", s2);
        ((JSONObject) (obj)).put("manufacturer", s1);
        ((JSONObject) (obj)).put("model", s3);
        gw.b(s4, null, list, ((JSONObject) (obj)).toString(), "application/json");
    }

    public static void a(String s, String s1, String s2, String s3, String s4)
    {
        Object obj = a();
        s = (new StringBuilder()).append(((gr) (obj)).f).append("/si/d/scheduling/stores/").append(s).append("/appointments/").append(s4).toString();
        s4 = a(false);
        obj = new UpdateAppointmentRequest();
        ((UpdateAppointmentRequest) (obj)).setDate(s1);
        ((UpdateAppointmentRequest) (obj)).setTime(s2);
        s1 = (new gy()).a(((gu) (obj)));
        s4.add(new BasicNameValuePair("emailAddress", s3));
        gw.b(s, null, s4, s1, false);
    }

    public static UberCategoryList b()
    {
        Object obj = a();
        List list = b(false);
        obj = (new StringBuilder()).append(((gr) (obj)).f).append("/si/catalog").toString();
        ArrayList arraylist = new ArrayList();
        UberCategoryList ubercategorylist = new UberCategoryList();
        try
        {
            ubercategorylist.setHeader(a((new JSONObject(gw.a(((String) (obj)), arraylist, list, null, true))).getJSONObject("si").getJSONObject("response").optJSONArray("groups")));
        }
        catch (Exception exception)
        {
            gs.d(a, (new StringBuilder()).append("getListData error : ").append(exception.getLocalizedMessage()).toString());
            throw exception;
        }
        return ubercategorylist;
    }

    private static HomeFragmentResponse b(String s, Context context)
    {
        return (HomeFragmentResponse)(new gy()).a(s, new HomeFragmentResponse());
    }

    public static SI b(String s)
    {
        Object obj1 = a();
        Object obj = a(false);
        s = (new StringBuilder()).append(((gr) (obj1)).f).append("/si/products/restrictedPriceBlock/").append(s).toString();
        obj1 = new ArrayList();
        try
        {
            s = gw.a(s, ((List) (obj1)), ((List) (obj)), null, true);
            obj = new SummariesPriceBlockResponse();
            s = (SummariesPriceBlockResponse)(new gy()).a(s, ((gu) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            gs.d(a, (new StringBuilder()).append("Could not get Restricted Price Block: ").append(s.getLocalizedMessage()).toString());
            throw s;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        if (s.getSi() == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        s = s.getSi();
        return s;
        return null;
    }

    public static ArrayList b(String s, String s1, String s2)
    {
        Object obj = a();
        s = (new StringBuilder()).append(((gr) (obj)).f).append("/si/d/scheduling/stores/").append(s).append("/slots").toString();
        obj = a(false);
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("startDate", s1));
        if (s2 != null && !s2.isEmpty())
        {
            arraylist.add(new BasicNameValuePair("endDate", s2));
        }
        s = gw.a(s, arraylist, ((List) (obj)), null);
        s1 = new TimeSlotResponse();
        s = (TimeSlotResponse)(new gy()).a(s, s1);
        if (s != null && s.getSi() != null)
        {
            s = s.getSi();
            if (s.getResponse() != null)
            {
                return s.getResponse().getAppointmentSlots();
            }
        }
        return null;
    }

    private static List b(boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("Content-type", "application/json"));
        arraylist.add(new BasicNameValuePair("Accept", "application/json"));
        arraylist.add(new BasicNameValuePair("X-SI-API-VERSION", "2.0"));
        if (flag)
        {
            String s = fr.b();
            if (s != null && !s.isEmpty())
            {
                arraylist.add(new BasicNameValuePair("X-SI-USER-UUID", fr.d()));
                arraylist.add(new BasicNameValuePair("access_token", s));
            }
        }
        return arraylist;
    }

    public static ArrayList c(String s)
    {
        gr gr1 = a();
        return p((new StringBuilder()).append(gr1.f).append("/si/recommendations/recentlyViewed/").append(s).append("/10").toString());
    }

    private static List c(boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("Content-type", "application/json"));
        arraylist.add(new BasicNameValuePair("Accept", "application/json"));
        arraylist.add(new BasicNameValuePair("X-SI-API-VERSION", "3.0"));
        if (flag)
        {
            String s = fr.b();
            if (s != null && !s.isEmpty())
            {
                arraylist.add(new BasicNameValuePair("X-SI-USER-UUID", fr.d()));
                arraylist.add(new BasicNameValuePair("access_token", s));
            }
        }
        return arraylist;
    }

    public static ArrayList d(String s)
    {
        gr gr1 = a();
        return p((new StringBuilder()).append(gr1.f).append("/si/recommendations/alsoViewed/").append(s).append("/10").toString());
    }

    public static ArrayList e(String s)
    {
        gr gr1 = a();
        return p((new StringBuilder()).append(gr1.f).append("/si/recommendations/alsoBought/").append(s).append("/10").toString());
    }

    public static StoreList f(String s)
    {
label0:
        {
            Object obj = new ArrayList();
            Object obj1 = new StoresResponse();
            obj1 = (StoresResponse)(new gy()).a(s, ((gu) (obj1)));
            s = new StoreList();
            if (obj1 != null && ((StoresResponse) (obj1)).getSi() != null && ((StoresResponse) (obj1)).getSi().getResponse() != null)
            {
                obj1 = ((StoresResponse) (obj1)).getSi().getResponse();
                ((ArrayList) (obj)).addAll(Arrays.asList(((com.bestbuy.android.api.lib.models.store.Response) (obj1)).getStores()));
                s.setStores(((ArrayList) (obj)));
                obj = ((com.bestbuy.android.api.lib.models.store.Response) (obj1)).getNext();
                if (obj == null || ((String) (obj)).isEmpty())
                {
                    break label0;
                }
                s.setHasNext(true);
            }
            return s;
        }
        s.setHasNext(false);
        return s;
    }

    public static ArrayList g(String s)
    {
        gr gr1 = a();
        return a(b(true), (new StringBuilder()).append(gr1.f).append(s).toString());
    }

    public static SearchApi h(String s)
    {
        SearchApi searchapi = new SearchApi();
        SiSearch sisearch = new SiSearch();
        s = (SiSearch)(new gy()).a(s, sisearch);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        s = s.getSi();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        s = s.getResponse();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        s = s.getSearchApi();
        return s;
        s;
        gs.d(a, (new StringBuilder()).append("Couldn't parse custom offer deals data").append(s.getLocalizedMessage()).toString());
        return searchapi;
    }

    public static ArrayList i(String s)
    {
        gq;
        JVM INSTR monitorenter ;
        Object obj;
        obj = a();
        new ArrayList();
        s = (new StringBuilder()).append(((gr) (obj)).f).append(s).toString();
        obj = b(true);
        s = gw.a(s, null, ((List) (obj)), null, true);
        obj = new PageConfigurationResponse();
        s = a((PageConfigurationResponse)(new gy()).a(s, ((gu) (obj))));
        gq;
        JVM INSTR monitorexit ;
        return s;
        s;
        gs.d(a, (new StringBuilder()).append("Error making GET request: ").append(s.getLocalizedMessage()).toString());
        throw s;
        s;
        gq;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static BuyingOptionsResponse j(String s)
    {
        Object obj = a();
        s = (new StringBuilder()).append(((gr) (obj)).a()).append("/si/pdp/buyingOptions/").append(s).toString();
        obj = a(true);
        try
        {
            s = gw.a(s, null, ((List) (obj)), null, true);
            obj = new PDPBuyingOptionsParent();
            s = (PDPBuyingOptionsParent)(new gy()).a(s, ((gu) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            gs.d(a, (new StringBuilder()).append("Error making GET request: ").append(s.getLocalizedMessage()).toString());
            throw s;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        s = s.getSi().getResponse();
        return s;
        return null;
    }

    public static CastAndCrewParent k(String s)
    {
        gr gr1 = a();
        List list = a(true);
        Object obj = "";
        if (s != null)
        {
            obj = (new StringBuilder()).append(gr1.f).append("/si/pdp/castAndCrew/").append(s).toString();
        }
        s = new ArrayList();
        try
        {
            s = gw.a(((String) (obj)), s, list, null, true);
            obj = new CastAndCrewParent();
            s = (CastAndCrewParent)(new gy()).a(s, ((gu) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        return s;
    }

    public static PDPEpisodesParent l(String s)
    {
        gr gr1 = a();
        List list = a(true);
        Object obj = "";
        if (s != null)
        {
            obj = (new StringBuilder()).append(gr1.f).append("/si/pdp/episodes/").append(s).toString();
        }
        s = new ArrayList();
        try
        {
            s = gw.a(((String) (obj)), s, list, null, true);
            obj = new PDPEpisodesParent();
            s = (PDPEpisodesParent)(new gy()).a(s, ((gu) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        return s;
    }

    public static MoviesResponse m(String s)
    {
        gr gr1 = a();
        List list = a(true);
        Object obj = "";
        if (s != null)
        {
            obj = (new StringBuilder()).append(gr1.f).append("/si/pdp/movieDetails/").append(s).toString();
        }
        s = new ArrayList();
        try
        {
            s = gw.a(((String) (obj)), s, list, null, true);
            obj = new PDPMoviesParent();
            s = ((PDPMoviesParent)(new gy()).a(s, ((gu) (obj)))).getSi().getResponse();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        return s;
    }

    public static MusicResponse n(String s)
    {
        gr gr1 = a();
        List list = a(true);
        Object obj = "";
        if (s != null)
        {
            obj = (new StringBuilder()).append(gr1.f).append("/si/pdp/musicDetails/").append(s).toString();
        }
        s = new ArrayList();
        try
        {
            s = gw.a(((String) (obj)), s, list, null, true);
            obj = new PDPMusicParent();
            s = ((PDPMusicParent)(new gy()).a(s, ((gu) (obj)))).getSi().getResponse();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        return s;
    }

    public static AccessoriesResponse o(String s)
    {
        gr gr1 = a();
        List list = a(true);
        Object obj = "";
        if (s != null)
        {
            obj = (new StringBuilder()).append(gr1.f).append("/si/pdp/accessories/").append(s).toString();
        }
        s = new ArrayList();
        try
        {
            s = gw.a(((String) (obj)), s, list, null, true);
            obj = new PDPAccessoriesParent();
            s = ((PDPAccessoriesParent)(new gy()).a(s, ((gu) (obj)))).getSi().getResponse();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        return s;
    }

    private static ArrayList p(String s)
    {
        Object obj;
        obj = b(true);
        Object obj1;
        JSONObject jsonobject;
        int i1;
        try
        {
            obj1 = gw.a(s, null, ((List) (obj)), null, true);
            obj = new ArrayList();
            s = new ArrayList();
            obj1 = (new JSONObject(((String) (obj1)))).optJSONObject("si").optJSONObject("response").optJSONObject("recommendations").optJSONArray("skus");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            gs.d(a, (new StringBuilder()).append("Could not get Trending Products Data: ").append(s.getLocalizedMessage()).toString());
            throw s;
        }
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        i1 = 0;
_L3:
        if (i1 >= ((JSONArray) (obj1)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        jsonobject = ((JSONArray) (obj1)).optJSONObject(i1);
        ((ArrayList) (obj)).add(jsonobject.optString("skuId"));
        s.add(jsonobject.optString("ep"));
        i1++;
        if (true) goto _L3; else goto _L2
_L2:
        obj = a(((ArrayList) (obj)));
        i1 = 0;
_L5:
        if (i1 >= ((ArrayList) (obj)).size())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = (String)s.get(i1);
        ((BBYProduct)((ArrayList) (obj)).get(i1)).setEp(((String) (obj1)));
        i1++;
        if (true) goto _L5; else goto _L4
_L4:
        return ((ArrayList) (obj));
    }

    static 
    {
        b = gr.a;
    }
}
