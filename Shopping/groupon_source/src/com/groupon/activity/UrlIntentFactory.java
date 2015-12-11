// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import com.groupon.Channel;
import com.groupon.abtest.NewCartAbTestHelper;
import com.groupon.abtest.SearchAbTestHelper;
import com.groupon.deeplink.DeepLinkData;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.deeplink.Endpoint;
import com.groupon.deeplink.imp.AppLaunchDeepLink;
import com.groupon.models.country.Country;
import com.groupon.service.ShoppingCartService;
import com.groupon.service.core.StaticSupportInfoService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.GeoPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            IntentFactory

public class UrlIntentFactory
{

    public static final String CATEGORIES_PARAM = "topcategory|category|category2|category3->%s";
    public static final String CATEGORY = "category";
    public static final String CATEGORY2 = "category2:%s";
    public static final String CATEGORY3 = "category3:%s";
    public static final Pattern COLLECTION_CARD_SOURCE = Pattern.compile("collection.*");
    public static final String CONTEXT = "context";
    public static final String DEAL_TYPE = "deal_type:%s";
    public static final String DEAL_TYPE_PARAM = "deal_type->%s";
    public static final String DISPLAY_COACH_MARK = "displayCoachMark";
    public static final Pattern FINDER_CARD_SOURCE = Pattern.compile("finder.*");
    public static final String IS_FROM_COLLECTION_CARD = "isFromCollectionCard";
    public static final String IS_FROM_FINDER_OR_COLLECTION_CARD = "isFromFinderOrCollectionCard";
    public static final String MERCHANT = "merchant";
    public static final String NEEDS_AUTH = "needsAuth";
    public static final String PARAM_CATEGORY = "category";
    public static final String PARAM_CATEGORY2 = "category2";
    public static final String PARAM_CATEGORY3 = "category3";
    public static final String PARAM_CHANNEL = "channel";
    public static final String PARAM_DEAL_ID = "deal_id";
    public static final String PARAM_INTEREST = "interest";
    public static final String PARAM_LAT = "lat";
    public static final String PARAM_LNG = "lng";
    public static final String PARAM_NEEDS_LOCATION = "needsLocation";
    public static final String PARAM_NEEDS_X_COOKIES = "needsXCookies";
    public static final String PARAM_OPTION_ID = "option_id";
    public static final String PARAM_QUERY = "q";
    public static final String PARAM_SEARCH_RESULTS_ONLY = "search_results_only";
    public static final String PARAM_SHOW_DEAL_DETAIL = "showDealDetail";
    public static final String PARAM_URL = "url";
    public static final String PROFILE_TRACK = "track";
    public static final String RAPI_FILTER = "filter";
    public static final String RAPI_QUERY = "query";
    public static final String RAPI_SOURCE = "x_client_consumed_source";
    public static final String X_CLIENT_CONSUMED_PREFIX = "x_client_consumed";
    public static final String X_CLIENT_CONSUMED_TITLE = "x_client_consumed_title";
    private NewCartAbTestHelper cartAbTestHelper;
    private CurrentCountryManager currentCountryManager;
    private DeepLinkUtil deepLinkUtil;
    protected IntentFactory intentFactory;
    private SearchAbTestHelper searchAbTestHelper;
    private ShoppingCartService shoppingCartService;
    private StaticSupportInfoService staticSupportInfoService;

    public UrlIntentFactory(IntentFactory intentfactory)
    {
        intentFactory = intentfactory;
    }

    private void addCategoriesInterestDeepLinkParam(DeepLinkData deeplinkdata, Intent intent)
    {
        Object obj = deeplinkdata.getParam("category");
        String s1 = deeplinkdata.getParam("category2");
        String s2 = deeplinkdata.getParam("category3");
        String s = deeplinkdata.getParam("interest");
        if (Strings.notEmpty(obj))
        {
            intent.putExtra("category", ((String) (obj)));
        }
        if (Strings.notEmpty(s))
        {
            intent.putExtra("interest", s);
        }
        obj = new StringBuilder();
        if (Strings.notEmpty(s1))
        {
            if (Strings.notEmpty(s2))
            {
                deeplinkdata = getFormattedSecondAndThirdLevelParamValuePairs("category2:%s", "category3:%s", s1.split(Pattern.quote(",")), getDeepLinkParamValueAsListOfStringArrays(s2));
                int i;
                if (Strings.notEmpty(deeplinkdata))
                {
                    deeplinkdata = (new StringBuilder()).append(String.format("topcategory|category|category2|category3->%s", new Object[] {
                        deeplinkdata
                    })).append(";").toString();
                } else
                {
                    deeplinkdata = "";
                }
                ((StringBuilder) (obj)).append(deeplinkdata);
            } else
            {
                deeplinkdata = getFormattedParamValuePairs("category2:%s", s1.split(Pattern.quote(",")));
                if (Strings.notEmpty(deeplinkdata))
                {
                    deeplinkdata = (new StringBuilder()).append(String.format("topcategory|category|category2|category3->%s", new Object[] {
                        deeplinkdata
                    })).append(";").toString();
                } else
                {
                    deeplinkdata = "";
                }
                ((StringBuilder) (obj)).append(deeplinkdata);
            }
        } else
        if (Strings.notEmpty(s2))
        {
            deeplinkdata = getFormattedParamValuePairs("category3:%s", s2.split(Pattern.quote(",")));
            if (Strings.notEmpty(deeplinkdata))
            {
                deeplinkdata = (new StringBuilder()).append(String.format("topcategory|category|category2|category3->%s", new Object[] {
                    deeplinkdata
                })).append(";").toString();
            } else
            {
                deeplinkdata = "";
            }
            ((StringBuilder) (obj)).append(deeplinkdata);
        }
        if (Strings.notEmpty(s))
        {
            deeplinkdata = getFormattedParamValuePairs("deal_type:%s", s.split(Pattern.quote(",")));
            if (Strings.notEmpty(deeplinkdata))
            {
                deeplinkdata = (new StringBuilder()).append(String.format("deal_type->%s", new Object[] {
                    deeplinkdata
                })).append(";").toString();
            } else
            {
                deeplinkdata = "";
            }
            ((StringBuilder) (obj)).append(deeplinkdata);
        }
        i = ((StringBuilder) (obj)).length();
        if (i > 0)
        {
            deeplinkdata = ((StringBuilder) (obj)).replace(i - 1, i, "").toString();
            if (Strings.notEmpty(deeplinkdata))
            {
                intent.putExtra("facet_group_filters", deeplinkdata);
            }
        }
    }

    private Intent getCouponsIntentFromDeeplink(DeepLinkData deeplinkdata)
    {
        String s = deeplinkdata.getContentId();
        if (Strings.isEmpty(deeplinkdata.getContentId()))
        {
            return intentFactory.newCarouselChannelIntent(Channel.COUPONS, new String[0]);
        }
        deeplinkdata = deeplinkdata.getSpecialId();
        if (s.equals("merchant"))
        {
            return intentFactory.newCouponCategoryOrMerchantFilterPageIntent(com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_MERCHANT, CouponInstoreOnlinePage.PageType.INSTORE, "", deeplinkdata, "").putExtra("isDeepLinked", true);
        }
        if (s.equals("category"))
        {
            return intentFactory.newCouponCategoryOrMerchantFilterPageIntent(com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_CATEGORY, CouponInstoreOnlinePage.PageType.INSTORE, "", deeplinkdata, "").putExtra("isDeepLinked", true);
        } else
        {
            return intentFactory.newCouponDetailsIntent(s, Channel.COUPONS);
        }
    }

    private String getFormattedParamValuePairs(String s, String as[])
    {
        Object obj = null;
        String s1 = obj;
        if (as != null)
        {
            s1 = obj;
            if (as.length > 0)
            {
                StringBuilder stringbuilder = new StringBuilder("(");
                int j = as.length;
                for (int i = 0; i < j; i++)
                {
                    s1 = as[i];
                    if (Strings.notEmpty(s1))
                    {
                        stringbuilder.append(String.format(s, new Object[] {
                            s1
                        })).append("|");
                    }
                }

                stringbuilder.setCharAt(stringbuilder.length() - 1, ')');
                s1 = obj;
                if (stringbuilder.length() > 1)
                {
                    s1 = stringbuilder.toString();
                }
            }
        }
        return s1;
    }

    private String getFormattedSecondAndThirdLevelParamValuePairs(String s, String s1, String as[], List list)
    {
        StringBuilder stringbuilder = new StringBuilder("(");
        int j = as.length;
        int i = 0;
        while (i < j) 
        {
            String s2 = as[i];
            if (Strings.notEmpty(s2) && i < list.size())
            {
                String as1[] = (String[])list.get(i);
                if (as1 != null)
                {
                    String s3 = getFormattedParamValuePairs(s1, as1);
                    if (Strings.notEmpty(s3))
                    {
                        stringbuilder.append(String.format("(%s)", new Object[] {
                            String.format(s, new Object[] {
                                (new StringBuilder()).append(s2).append(",").append(s3).toString()
                            })
                        }));
                    } else
                    {
                        stringbuilder.append(String.format(s, new Object[] {
                            s2
                        }));
                    }
                } else
                {
                    stringbuilder.append(String.format(s, new Object[] {
                        s2
                    }));
                }
            } else
            {
                stringbuilder.append(String.format(s, new Object[] {
                    s2
                }));
            }
            stringbuilder.append("|");
            i++;
        }
        stringbuilder.setCharAt(stringbuilder.length() - 1, ')');
        if (stringbuilder.length() > 1)
        {
            return stringbuilder.toString();
        } else
        {
            return null;
        }
    }

    private Intent getGlobalSearchIntent(DeepLinkData deeplinkdata, boolean flag, String s)
    {
        if (!flag && !searchAbTestHelper.isSearchEnabled())
        {
            return intentFactory.newCarouselIntent();
        }
        s = Channel.safeValueOf(s);
        Object obj = intentFactory;
        String s1;
        if (s == null)
        {
            s = Channel.FEATURED;
        }
        s = ((IntentFactory) (obj)).newGlobalSearchIntent(s);
        obj = deeplinkdata.getParam("q");
        s1 = deeplinkdata.getParam("search_results_only");
        if (Strings.notEmpty(s1))
        {
            s.putExtra("search_results_only", Boolean.parseBoolean(s1));
        }
        if (Strings.notEmpty(obj))
        {
            s.putExtra("global_search_query", ((String) (obj)));
        }
        addSearchGeopointDeepLinkParam(deeplinkdata, s);
        addCategoriesInterestDeepLinkParam(deeplinkdata, s);
        return s;
    }

    private Intent selectIntent(DeepLinkData deeplinkdata, boolean flag)
    {
        Object obj;
        obj = new Country();
        String s1 = deeplinkdata.getCountryCode();
        obj.isoName = s1;
        obj.shortName = s1;
        if (!deepLinkUtil.hasWildCardCountryCode(deeplinkdata) && !staticSupportInfoService.isCountrySupported(((Country) (obj))))
        {
            return null;
        }
        if (deepLinkUtil.isBaseUrl(deeplinkdata) || (deeplinkdata instanceof AppLaunchDeepLink))
        {
            return intentFactory.newCarouselIntent();
        }
        obj = deeplinkdata.getSpecifier();
        static class _cls1
        {

            static final int $SwitchMap$com$groupon$deeplink$Endpoint[];

            static 
            {
                $SwitchMap$com$groupon$deeplink$Endpoint = new int[Endpoint.values().length];
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.CHANNEL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.DEAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.PURCHASE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.PROFILE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.SEARCH.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.SHOPPING_CART.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.WIDGETS.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.SEARCH_RESULTS.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.BUSINESS.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.SEARCH_RESULTS_WITH_UI.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.FREEBIE.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.FREEBIE_CATEGORY.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.FREEBIE_MERCHANT.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.SURVEY.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.WEBVIEW.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.SIKR3TADMIN.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.CARDSEARCH.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.groupon.deeplink.Endpoint[deeplinkdata.getEndpoint().ordinal()];
        JVM INSTR tableswitch 1 17: default 921
    //                   1 176
    //                   2 281
    //                   3 302
    //                   4 378
    //                   5 546
    //                   6 554
    //                   7 580
    //                   8 604
    //                   9 628
    //                   10 660
    //                   11 684
    //                   12 711
    //                   13 744
    //                   14 777
    //                   15 803
    //                   16 882
    //                   17 890;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L2:
        Channel channel = Channel.safeValueOf(((String) (obj)));
        if (channel != null) goto _L20; else goto _L19
_L19:
        return intentFactory.newCarouselIntent();
_L20:
        if (!Strings.notEmpty(deeplinkdata.getParam("category")) && !Strings.notEmpty(deeplinkdata.getParam("interest"))) goto _L22; else goto _L21
_L21:
        if (!channel.supportsCategories()) goto _L24; else goto _L23
_L23:
        if (channel == Channel.GOODS)
        {
            return getGlobalSearchIntent(deeplinkdata, flag, ((String) (obj)));
        }
        obj = getChannelIntent(deeplinkdata, channel);
        addCategoriesInterestDeepLinkParam(deeplinkdata, ((Intent) (obj)));
        return ((Intent) (obj));
_L24:
        return getGlobalSearchIntent(deeplinkdata, flag, channel.name());
_L22:
        return getChannelIntent(deeplinkdata, Channel.safeValueOf(((String) (obj))));
_L3:
        deeplinkdata = deeplinkdata.getParam("channel");
        return intentFactory.newDealIntent(((String) (obj)), Channel.safeValueOf(deeplinkdata), true);
_L4:
        if (Strings.isEmpty(deeplinkdata.getParam("showDealDetail")))
        {
            return intentFactory.newPurchaseLoginIntent(((String) (obj)), deeplinkdata.getParam("option_id"), Channel.safeValueOf(deeplinkdata.getParam("channel")), true).putExtra("is_wearable_preview_purchase", true);
        } else
        {
            return intentFactory.createDealIntent(((String) (obj)), deeplinkdata.getParam("option_id"), Channel.safeValueOf(deeplinkdata.getParam("channel")), true).putExtra("should_launch_purchase_page", true);
        }
_L5:
        if (((String) (obj)).isEmpty())
        {
            return intentFactory.newCarouselIntentOpenNavigationDrawer();
        }
        if (((String) (obj)).equals("subscriptions"))
        {
            return intentFactory.newEmailSubscriptionsIntent();
        }
        if (((String) (obj)).equals("groupons"))
        {
            obj = deeplinkdata.getContentId();
            if (Strings.isEmpty(obj))
            {
                return intentFactory.newMyGrouponsIntent();
            }
            if (deeplinkdata.getSpecialId().equalsIgnoreCase("track"))
            {
                deeplinkdata = deeplinkdata.getParam("url");
                if (Strings.notEmpty(deeplinkdata))
                {
                    return intentFactory.newGrouponWebViewIntent(deeplinkdata, true, true, false, true, false);
                }
            }
            return intentFactory.newGrouponIntent(((String) (obj)), false, -1);
        }
        if (((String) (obj)).equals("dealtypes"))
        {
            return intentFactory.newFavoriteDealTypesIntent();
        }
        if (((String) (obj)).equals("about"))
        {
            return intentFactory.newAboutGrouponIntent();
        }
        if (((String) (obj)).equals("settings"))
        {
            return intentFactory.newSettingsIntent();
        }
_L6:
        return getGlobalSearchIntent(deeplinkdata, flag, null);
_L7:
        if (cartAbTestHelper.isShoppingCartEnabled())
        {
            return shoppingCartService.getOpenCartIntent();
        } else
        {
            return intentFactory.newCarouselIntent();
        }
_L8:
        if (clientSupportsWidgetsDeepLink())
        {
            return intentFactory.newDealSubsetIntent(deeplinkdata);
        } else
        {
            return intentFactory.newCarouselIntent();
        }
_L9:
        if (clientSupportsSearchResultsDeepLink())
        {
            return intentFactory.newDealSubsetIntent(deeplinkdata);
        } else
        {
            return intentFactory.newCarouselIntent();
        }
_L10:
        if (!deeplinkdata.getSpecialId().isEmpty())
        {
            return intentFactory.newDeepLinkSpecialIntent(deeplinkdata.getSpecialId(), ((String) (obj)));
        } else
        {
            return intentFactory.newMerchantPageIntent(((String) (obj)));
        }
_L11:
        if (clientSupportsSearchResultsDeepLink())
        {
            return intentFactory.newGlobalSearchResultIntent(deeplinkdata);
        } else
        {
            return intentFactory.newCarouselIntent();
        }
_L12:
        if (Strings.isEmpty(obj))
        {
            return intentFactory.newCouponIntent();
        } else
        {
            return intentFactory.newCouponDetailsIntent(((String) (obj)), Channel.COUPONS);
        }
_L13:
        if (Strings.notEmpty(obj))
        {
            return intentFactory.newCouponCategoryOrMerchantFilterPageIntent(com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_CATEGORY, CouponInstoreOnlinePage.PageType.INSTORE, "", ((String) (obj)), "").putExtra("isDeepLinked", true);
        }
_L14:
        if (Strings.notEmpty(obj))
        {
            return intentFactory.newCouponCategoryOrMerchantFilterPageIntent(com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_MERCHANT, CouponInstoreOnlinePage.PageType.INSTORE, "", ((String) (obj)), "").putExtra("isDeepLinked", true);
        }
_L15:
        if (Strings.notEmpty(obj))
        {
            return intentFactory.newPoGWebView(((String) (obj)), deeplinkdata);
        } else
        {
            return intentFactory.newPoGSearch(deeplinkdata);
        }
_L16:
        String s = deeplinkdata.getParam("url");
        if (Strings.notEmpty(s) && s.contains("groupon.com"))
        {
            return intentFactory.newGrouponWebViewIntent(s, Boolean.parseBoolean(deeplinkdata.getParam("needsAuth")), Boolean.parseBoolean(deeplinkdata.getParam("needsLocation")), Boolean.parseBoolean(deeplinkdata.getParam("needsXCookies")), Boolean.parseBoolean(deeplinkdata.getParam("hide_header")), true);
        } else
        {
            return intentFactory.newCarouselIntent();
        }
_L17:
        return intentFactory.newSecretAdminSettingsWithOktaAuthenticationIntent();
_L18:
        if (clientSupportsSearchResultsDeepLink())
        {
            return getCardSearchResultIntentFromDeepLink(deeplinkdata);
        }
        deeplinkdata = intentFactory.newCarouselIntent();
        return deeplinkdata;
        deeplinkdata;
        Ln.e(deeplinkdata);
        return null;
_L1:
        return null;
    }

    protected Intent addDeepLinkingExtra(Intent intent)
    {
        if (intent != null)
        {
            intent.putExtra("isDeepLinked", true);
        }
        return intent;
    }

    protected Intent addSearchGeopointDeepLinkParam(DeepLinkData deeplinkdata, Intent intent)
    {
        String s = deeplinkdata.getParam("lat");
        deeplinkdata = deeplinkdata.getParam("lng");
        if (Strings.notEmpty(s) && Strings.notEmpty(deeplinkdata))
        {
            try
            {
                double d = Double.valueOf(s).doubleValue();
                double d1 = Double.valueOf(deeplinkdata).doubleValue();
                intent.putExtra("global_search_geopoint", new GeoPoint((int)(1000000D * d), (int)(1000000D * d1)));
            }
            // Misplaced declaration of an exception variable
            catch (DeepLinkData deeplinkdata)
            {
                Ln.w("Invalid lat/lng from search deeplink.", new Object[0]);
                return intent;
            }
        }
        return intent;
    }

    protected boolean clientSupportsSearchResultsDeepLink()
    {
        return currentCountryManager.getCurrentCountry().isUSACompatible() || currentCountryManager.getCurrentCountry().isSearchEnabledCountry();
    }

    protected boolean clientSupportsWidgetsDeepLink()
    {
        return currentCountryManager.getCurrentCountry().isMegamindEnabledCountry();
    }

    protected Intent getCardSearchResultIntentFromDeepLink(DeepLinkData deeplinkdata)
    {
        Intent intent = intentFactory.newGlobalSearchResultIntent(deeplinkdata);
        String s = deeplinkdata.getParam("x_client_consumed_source");
        if (Strings.notEmpty(s))
        {
            intent.putExtra("searchOrigin", s);
            boolean flag = COLLECTION_CARD_SOURCE.matcher(s).matches();
            intent.putExtra("isFromCollectionCard", flag);
            if (FINDER_CARD_SOURCE.matcher(s).matches() || flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            intent.putExtra("isFromFinderOrCollectionCard", flag);
        }
        s = deeplinkdata.getParam("filter");
        if (Strings.notEmpty(s))
        {
            intent.putExtra("searchFilter", s);
        }
        s = deeplinkdata.getParam("query");
        if (Strings.notEmpty(s))
        {
            intent.putExtra("search_term", s);
        }
        addSearchGeopointDeepLinkParam(deeplinkdata, intent);
        return intent;
    }

    protected Intent getChannelIntent(DeepLinkData deeplinkdata, Channel channel)
    {
        if (channel.equals(Channel.COUPONS))
        {
            return getCouponsIntentFromDeeplink(deeplinkdata);
        } else
        {
            deeplinkdata = deeplinkdata.getParam("deal_id");
            return intentFactory.newCarouselChannelIntentWithDealSmuggling(channel, new String[] {
                deeplinkdata
            });
        }
    }

    public List getDeepLinkParamValueAsListOfStringArrays(String s)
    {
        ArrayList arraylist = new ArrayList();
        if (s.startsWith("(") && s.endsWith(")"))
        {
            s = s.substring(1, s.length() - 1).split(Pattern.quote("),("));
            int j = s.length;
            for (int i = 0; i < j; i++)
            {
                arraylist.add(s[i].split(","));
            }

        } else
        {
            arraylist.add(s.split(","));
        }
        return arraylist;
    }

    public Intent getIntent(DeepLinkData deeplinkdata, boolean flag, boolean flag1)
    {
        Intent intent = selectIntent(deeplinkdata, flag);
        deeplinkdata = intent;
        if (flag1)
        {
            deeplinkdata = addDeepLinkingExtra(intent);
        }
        return deeplinkdata;
    }

}
