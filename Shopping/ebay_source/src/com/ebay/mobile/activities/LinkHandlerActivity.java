// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.ebay.common.Preferences;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.categorybrowser.BrowseCategoriesActivity;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.events.EventItemsActivity;
import com.ebay.mobile.experimentation.ExperimentationUtil;
import com.ebay.mobile.search.FollowQaDeepLinkUtil;
import com.ebay.mobile.search.SearchDeepLinkUtil;
import com.ebay.mobile.sellsmartbox.SmartboxActivity;
import com.ebay.mobile.user.symban.SymbanActivity;
import com.ebay.mobile.util.QueryParam;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.mobile.viewitem.ItemViewPhotoGalleryActivity;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.experimentation.ExperimentationDataManager;
import com.ebay.server_requests.InstallTracking;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity, eBay, SignInActivity, SignInModalActivity, 
//            FeedActivity, MyEbayLandingActivity, MessagesActivity, PreferencesActivity, 
//            UserDetailActivity, ViewFeedbackActivity, SignInDeepLinkActivity, DealsActivity, 
//            WebviewDeepLinkUtil

public final class LinkHandlerActivity extends BaseActivity
{
    private static class SiteMapper
        implements ShowWebViewActivity.UrlRewriter
    {

        public String rewriteUri(String s)
        {
            Object obj;
            Object obj1;
            Object obj2;
            Uri uri;
            List list;
            boolean flag;
            boolean flag1;
            obj2 = new HashSet();
            do
            {
                uri = Uri.parse(s);
                uri.getQueryParameterNames();
                ((Set) (obj2)).clear();
                for (Iterator iterator = uri.getQueryParameterNames().iterator(); iterator.hasNext(); ((Set) (obj2)).add(((String)iterator.next()).toLowerCase(Locale.getDefault()))) { }
                if ("market".equals(uri.getScheme()) && ((Set) (obj2)).contains("url"))
                {
                    return uri.getQueryParameter("url");
                }
            } while (false);
            list = uri.getPathSegments();
            if (list.size() > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                obj = (String)list.get(0);
            } else
            {
                obj = "";
            }
            if (flag)
            {
                obj1 = (String)list.get(list.size() - 1);
            } else
            {
                obj1 = "";
            }
            flag1 = "eBayISAPI.dll".equalsIgnoreCase(((String) (obj1)));
            if ((!flag1 || !((Set) (obj2)).contains("viewitem")) && !((Set) (obj2)).contains("binconfirm") && !"itm".equalsIgnoreCase(((String) (obj)))) goto _L2; else goto _L1
_L1:
            obj1 = null;
            if (!"itm".equalsIgnoreCase(((String) (obj)))) goto _L4; else goto _L3
_L3:
            obj2 = (String)list.get(list.size() - 1);
            obj = obj1;
            if (TextUtils.isDigitsOnly(((CharSequence) (obj2))))
            {
                obj = obj2;
            }
_L6:
            if (obj != null)
            {
                obj1 = obj;
                if (12 < ((String) (obj)).length())
                {
                    obj1 = ((String) (obj)).substring(0, Math.min(((String) (obj)).length(), 12));
                }
                if (!TextUtils.isEmpty(((CharSequence) (obj1))))
                {
                    return LinkHandlerActivity.buildItemViewLink(((String) (obj1)));
                }
            }
            break; /* Loop/switch isn't completed */
_L4:
            obj = obj1;
            if (flag1)
            {
                obj = uri.getQueryParameter("item");
            }
            if (true) goto _L6; else goto _L5
_L2:
            if (!flag1 || !((Set) (obj2)).contains("managebestoffers")) goto _L8; else goto _L7
_L7:
            obj = uri.getQueryParameter("itemid");
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                return LinkHandlerActivity.buildItemViewLink(((String) (obj)));
            }
              goto _L5
_L8:
            if (flag1 && ((Set) (obj2)).contains("buyhub"))
            {
                return LinkHandlerActivity.buildHomeLink();
            }
            if ((!flag1 || !((Set) (obj2)).contains("myebay")) && !"myebay".equalsIgnoreCase(((String) (obj))) && !"myb".equalsIgnoreCase(((String) (obj)))) goto _L10; else goto _L9
_L9:
            s = "user.myebay";
            obj = uri.getQueryParameter("actionName");
            obj2 = uri.getQueryParameter("CurrentPage");
            if (!"WATCHING".equals(obj) && !"WatchList".equalsIgnoreCase(((String) (obj1)))) goto _L12; else goto _L11
_L11:
            s = "user.watching";
_L13:
            return LinkHandlerActivity.buildDeepLink(s, new Pair[0]);
_L12:
            if ("BUY_OVERVIEW".equals(obj) || "MyeBayBidding".equals(obj2) || "MyeBayWon".equals(obj2))
            {
                s = "user.buying";
            } else
            if ("SELL_OVERVIEW".equals(obj) || "MyeBayAllSelling".equals(obj2))
            {
                s = "user.selling";
            }
            if (true) goto _L13; else goto _L10
_L10:
            if (uri.getHost().endsWith("feedback.ebay.com") && flag1 && ((Set) (obj2)).contains("viewfeedback"))
            {
                obj = uri.getQueryParameter("userid");
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    return LinkHandlerActivity.buildViewUserFeedbackLink(((String) (obj)));
                }
            } else
            {
                String s2 = uri.getHost().toLowerCase(Locale.getDefault());
                Object obj3 = null;
                if (EbaySite.getInstanceFromDomain(s2) != null)
                {
                    if (!flag)
                    {
                        return LinkHandlerActivity.buildHomeLink();
                    }
                    if ("seller".equalsIgnoreCase(((String) (obj))))
                    {
                        obj = uri.getQueryParameter("sid");
                        if (!TextUtils.isEmpty(((CharSequence) (obj))))
                        {
                            return LinkHandlerActivity.buildViewUserDetailsLink(((String) (obj)));
                        }
                    } else
                    if ("usr".equalsIgnoreCase(((String) (obj))))
                    {
                        obj = obj3;
                        if (list.size() >= 2)
                        {
                            obj = (String)list.get(1);
                        }
                        if (!TextUtils.isEmpty(((CharSequence) (obj))))
                        {
                            return LinkHandlerActivity.buildViewUserDetailsLink(((String) (obj)));
                        }
                    } else
                    {
                        if ("syi".equalsIgnoreCase(((String) (obj))) || "csr.ebay.com".equalsIgnoreCase(s2) && ("sell.jsf".equals(obj1) || "start.jsf".equals(obj1)) || flag1 && "SellHub3".equalsIgnoreCase(uri.getQueryParameter("MfcISAPICommand")))
                        {
                            return LinkHandlerActivity.buildDeepLink("user.sell", new Pair[0]);
                        }
                        if ("myworld.ebay.com".equalsIgnoreCase(s2))
                        {
                            String s1 = (String)uri.getPathSegments().get(0);
                            if (!TextUtils.isEmpty(s1))
                            {
                                return LinkHandlerActivity.buildViewUserDetailsLink(s1);
                            }
                        }
                    }
                }
            }
_L5:
            return s;
        }

        private SiteMapper()
        {
        }

    }


    public static final String EXTRA_APP_INDEXING_REFERRER_NAME = "android.intent.extra.REFERRER_NAME";
    private static final String EXTRA_SUPPRESS_SIGNIN = "noSignIn";
    private static final String LINK_BROWSE_CATEGORIES = "item.browse";
    private static final String LINK_BROWSE_DEALS = "item.deals";
    private static final String LINK_BUY_LIST = "user.buying";
    private static final String LINK_CHECKOUT = "user.xo";
    private static final String LINK_DETAILS = "user.details";
    private static final String LINK_EP_OPTIN = "ep.opt.in";
    private static final String LINK_EP_OPTOUT = "ep.opt.out";
    private static final String LINK_EP_OPT_RESET = "ep.opt.reset";
    private static final String LINK_EP_OPT_RESET_ALL = "ep.opt.reset.all";
    private static final String LINK_EP_PREFIX = "ep.";
    private static final String LINK_EP_REQUALIFY = "ep.requalify";
    private static final String LINK_EVENT = "item.events";
    private static final String LINK_FEED = "user.feed";
    private static final String LINK_FOLLOW_QA = "user.follow.qa";
    private static final String LINK_HOME = "home";
    private static final String LINK_ITEM = "item.";
    private static final String LINK_MESSAGES = "user.messages";
    private static final String LINK_MYEBAY = "user.myebay";
    private static final String LINK_PHOTO_GALLERY = "photo.gallery";
    private static final String LINK_REMINDERS = "user.reminders";
    private static final String LINK_RTM = "user.rtm";
    private static final String LINK_SAVED_SEARCHES = "user.saved_searches";
    private static final String LINK_SEARCH = "item.query";
    private static final String LINK_SELL = "user.sell";
    private static final String LINK_SELL_LIST = "user.selling";
    private static final String LINK_SETTINGS = "user.settings";
    private static final String LINK_SIGNIN = "user.signin";
    private static final String LINK_USER_BID = "user.bid";
    private static final String LINK_USER_PREFIX = "user.";
    private static final String LINK_USER_VIEW = "user.view";
    private static final String LINK_VIEW = "item.view";
    private static final String LINK_VIEW_FEEDBACK = "user.feedback";
    private static final String LINK_WATCH_LIST = "user.watching";
    private static final String LINK_WEBVIEW = "webview";
    public static ShowWebViewActivity.UrlRewriter SITE_MAPPER = new SiteMapper();
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo fwLogLinkHandler = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("fwLogLinkHandler", 3, "Deep Link Warnings");
    private Intent homeIntent;

    public LinkHandlerActivity()
    {
    }

    private static Intent addLinkIntentFlags(Intent intent, Intent intent1)
    {
        if (intent != null) goto _L2; else goto _L1
_L1:
        Intent intent2 = null;
_L4:
        return intent2;
_L2:
        if (intent1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        intent2 = intent;
        if (intent1.getBooleanExtra("inAppLink", false)) goto _L4; else goto _L3
_L3:
        intent1 = new ComponentName("com.ebay.mobile", com/ebay/mobile/activities/eBay.getName());
        intent.setFlags(0x4000000);
        intent.putExtra("com.ebay.mobile.menu.NAVIGATE_UP", intent1);
        return intent;
    }

    public static transient String buildDeepLink(String s, Pair apair[])
    {
        s = Uri.parse(String.format("ebay://link/?nav=%s", new Object[] {
            s
        })).buildUpon();
        if (apair != null)
        {
            int j = apair.length;
            for (int i = 0; i < j; i++)
            {
                Pair pair = apair[i];
                s.appendQueryParameter((String)pair.first, (String)pair.second);
            }

        }
        return s.build().toString();
    }

    public static String buildHomeLink()
    {
        return buildDeepLink("home", new Pair[0]);
    }

    public static String buildItemViewLink(String s)
    {
        return buildDeepLink("item.view", new Pair[] {
            new Pair("id", s)
        });
    }

    public static String buildViewUserDetailsLink(String s)
    {
        return buildDeepLink("user.details", new Pair[] {
            new Pair("user", s)
        });
    }

    public static String buildViewUserFeedbackLink(String s)
    {
        return buildDeepLink("user.feedback", new Pair[] {
            new Pair("user", s)
        });
    }

    private static Uri convertOldLinks(Uri uri)
    {
        if (uri == null)
        {
            return uri;
        }
        Uri uri1 = Uri.parse(uri.toString().replace("+", "%20"));
        Object obj = null;
        Object obj1 = uri1.getScheme();
        if ("http".equals(obj1))
        {
            uri = obj;
            if ("pages.ebay.com".equalsIgnoreCase(uri1.getHost()))
            {
                obj1 = uri1.getPathSegments();
                uri = obj;
                if (obj1 != null)
                {
                    uri = obj;
                    if (((List) (obj1)).size() == 3)
                    {
                        uri = obj;
                        if ("android".equalsIgnoreCase((String)((List) (obj1)).get(0)))
                        {
                            uri = obj;
                            if ("item".equalsIgnoreCase((String)((List) (obj1)).get(1)))
                            {
                                uri = (String)((List) (obj1)).get(2);
                            }
                        }
                    }
                }
            }
        } else
        {
            uri = obj;
            if ("ebay".equals(obj1))
            {
                uri = obj;
                if ("item".equalsIgnoreCase(uri1.getHost()))
                {
                    List list = uri1.getPathSegments();
                    uri = obj;
                    if (list != null)
                    {
                        uri = obj;
                        if (list.size() == 1)
                        {
                            uri = (String)list.get(0);
                        }
                    }
                }
            }
        }
        if (uri != null && ("query".equalsIgnoreCase(uri) || "view".equalsIgnoreCase(uri)))
        {
            return uri1.buildUpon().appendQueryParameter("nav", (new StringBuilder()).append("item.").append(uri).toString()).build();
        } else
        {
            return uri1;
        }
    }

    private void directAndClose(Intent intent)
    {
        Object obj = intent.getAction();
        if (!"android.intent.action.VIEW".equals(obj) && !"android.nfc.action.NDEF_DISCOVERED".equals(obj)) goto _L2; else goto _L1
_L1:
        Uri uri1 = getEffectiveUri(convertOldLinks(intent.getData()));
        if (uri1 == null) goto _L2; else goto _L3
_L3:
        String s = uri1.getQueryParameter("referrer");
        if (!TextUtils.isEmpty(s))
        {
            if (Log.isLoggable("ebay3pLinking", 3))
            {
                Log.d("ebay3pLinking", (new StringBuilder()).append("Linked to app with referrer \"").append(s).append("\". Tracking event.").toString());
            }
            TrackingData trackingdata = new TrackingData("Referral", TrackingType.EVENT);
            Uri uri = Uri.parse(s);
            obj = uri;
            if (DeviceConfiguration.getAsync().get(DcsBoolean.appIndexingReferrerTracking))
            {
                String s1 = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                obj = uri;
                if (!TextUtils.isEmpty(s1))
                {
                    obj = uri.buildUpon().appendQueryParameter("mpvl", s1).build();
                }
            }
            InstallTracking.processReferralTrackingEvent(trackingdata, ((Uri) (obj)));
            trackingdata.send(this);
            obj = s;
        } else
        {
            obj = intent.getStringExtra("com.ebay.mobile.tracking.Referrer");
        }
        InstallTracking.testFirstRun(this);
        obj = getDeepLinkIntent(this, uri1, ((String) (obj)), intent);
        intent = uri1.getQueryParameter("nav");
        if (TextUtils.isEmpty(intent) || !intent.startsWith("user.") || MyApp.getPrefs().isSignedIn() || ((Intent) (obj)).getBooleanExtra("noSignIn", false)) goto _L5; else goto _L4
_L4:
        if (getResources().getBoolean(0x7f0b0006))
        {
            intent = new Intent(this, com/ebay/mobile/activities/SignInActivity);
        } else
        {
            intent = SignInModalActivity.getIntentForSignIn(null, this);
        }
        intent.putParcelableArrayListExtra("redirect_intents", new ArrayList(Arrays.asList(new Intent[] {
            obj
        })));
        startActivityForResult(intent, 65);
_L2:
        finish();
        return;
_L5:
        if (homeIntent.filterEquals(((Intent) (obj))) || networkAvailable())
        {
            ((Intent) (obj)).removeExtra("noSignIn");
            startActivity(((Intent) (obj)));
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    private Intent getDeepLinkIntent(Context context, Uri uri, String s, Intent intent)
    {
        Object obj;
        String s1;
        String s2;
        DcsHelper dcshelper;
        DeviceConfiguration deviceconfiguration;
        obj = null;
        s1 = null;
        s2 = uri.getQueryParameter("nav");
        dcshelper = MyApp.getDeviceConfiguration();
        deviceconfiguration = dcshelper.getConfig();
        if (s2 != null) goto _L2; else goto _L1
_L1:
        obj = homeIntent;
_L9:
        context = ((Context) (obj));
        if (obj == null)
        {
            context = homeIntent;
        }
        return context;
_L2:
        if ("user.feed".equals(s2))
        {
            obj = newLinkIntent(context, com/ebay/mobile/activities/FeedActivity, intent);
            continue; /* Loop/switch isn't completed */
        }
        if ("home".equals(s2))
        {
            obj = homeIntent;
            continue; /* Loop/switch isn't completed */
        }
        if ("user.myebay".equals(s2))
        {
            obj = newLinkIntent(context, com/ebay/mobile/activities/eBay, intent);
            ((Intent) (obj)).putExtra("HomeStartChannelTab", ChannelEnum.ACTIVITY);
            continue; /* Loop/switch isn't completed */
        }
        if ("user.buying".equals(s2))
        {
            obj = addLinkIntentFlags(MyEbayLandingActivity.getBuyingActivityIntent(context), intent);
            continue; /* Loop/switch isn't completed */
        }
        if ("user.selling".equals(s2))
        {
            obj = newLinkIntent(context, com/ebay/mobile/activities/eBay, intent);
            ((Intent) (obj)).putExtra("HomeStartChannelTab", ChannelEnum.SELL);
            continue; /* Loop/switch isn't completed */
        }
        if ("user.watching".equals(s2))
        {
            obj = addLinkIntentFlags(MyEbayLandingActivity.getWatchingActivityIntent(context), intent);
            continue; /* Loop/switch isn't completed */
        }
        if ("user.messages".equals(s2))
        {
            context = newLinkIntent(context, com/ebay/mobile/activities/MessagesActivity, intent);
            uri = uri.getQueryParameter("msg");
            obj = context;
            if (!TextUtils.isEmpty(uri))
            {
                context.putExtra("message_id", uri);
                obj = context;
            }
            continue; /* Loop/switch isn't completed */
        }
        if ("user.reminders".equals(s2) && deviceconfiguration.get(DcsBoolean.Symban))
        {
            obj = newLinkIntent(context, com/ebay/mobile/user/symban/SymbanActivity, intent);
            continue; /* Loop/switch isn't completed */
        }
        if ("user.saved_searches".equals(s2))
        {
            obj = addLinkIntentFlags(ActivityStarter.getSavedSearchIntent(context, getEbayContext(), null, null), intent);
            ((Intent) (obj)).putExtra("saved_search_from_notification", true);
            continue; /* Loop/switch isn't completed */
        }
        if (s2.startsWith("user.follow.qa"))
        {
            obj = addLinkIntentFlags(FollowQaDeepLinkUtil.parseDeepLink(context, getEbayContext(), s2, uri), intent);
            continue; /* Loop/switch isn't completed */
        }
        if ("user.sell".equals(s2) && dcshelper.isSellingEnabled())
        {
            if (!Boolean.parseBoolean(uri.getQueryParameter("startNew")))
            {
                context = newLinkIntent(context, com/ebay/mobile/activities/eBay, intent);
                context.setFlags(0x24000000);
                context.putExtra("HomeStartChannelTab", ChannelEnum.SELL);
                uri = uri.getQueryParameter("listing");
                obj = context;
                if (!TextUtils.isEmpty(uri))
                {
                    context.putExtra("RedirectDraftId", uri);
                    obj = context;
                }
            } else
            {
                obj = newLinkIntent(context, com/ebay/mobile/sellsmartbox/SmartboxActivity, intent);
            }
            continue; /* Loop/switch isn't completed */
        }
        if ("user.settings".equals(s2))
        {
            obj = newLinkIntent(context, com/ebay/mobile/activities/PreferencesActivity, intent);
            ((Intent) (obj)).putExtra("noSignIn", true);
            continue; /* Loop/switch isn't completed */
        }
        if ("user.details".equals(s2) || "user.view".equals(s2))
        {
            s = newLinkIntent(context, com/ebay/mobile/activities/UserDetailActivity, intent);
            obj = uri.getQueryParameter("user");
            intent = MyApp.getPrefs().getCurrentUser();
            context = ((Context) (obj));
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                context = intent;
            }
            obj = s;
            if (!TextUtils.isEmpty(context))
            {
                boolean flag3;
                boolean flag5;
                if (!context.equals(intent) && "1".equals(uri.getQueryParameter("buyer")))
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                flag5 = "1".equals(uri.getQueryParameter("seller"));
                s.putExtra("user_id", context);
                s.putExtra("isBuyer", flag3);
                s.putExtra("isSeller", flag5);
                obj = s;
                if (!context.equals(intent))
                {
                    s.putExtra("noSignIn", true);
                    obj = s;
                }
            }
            continue; /* Loop/switch isn't completed */
        }
        if (!"user.feedback".equals(s2)) goto _L4; else goto _L3
_L3:
        boolean flag;
        s = uri.getQueryParameter("user");
        obj = MyApp.getPrefs().getCurrentUser();
        context = s;
        if (TextUtils.isEmpty(s))
        {
            context = ((Context) (obj));
        }
        boolean flag4 = "1".equals(uri.getQueryParameter("buying"));
        if (!flag4 && "1".equals(uri.getQueryParameter("selling")))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = addLinkIntentFlags(ViewFeedbackActivity.getIntent(context, null), intent);
        if (!flag4) goto _L6; else goto _L5
_L5:
        ((Intent) (obj)).putExtra("feedbackTabMode", 1);
_L7:
        ((Intent) (obj)).putExtra("noSignIn", true);
        continue; /* Loop/switch isn't completed */
_L6:
        if (flag)
        {
            ((Intent) (obj)).putExtra("feedbackTabMode", 0);
        }
        if (true) goto _L7; else goto _L4
_L4:
        if ("user.xo".equals(s2))
        {
            s1 = uri.getQueryParameter("id");
            s = ((String) (obj));
            if (!TextUtils.isEmpty(s1))
            {
                s = ((String) (obj));
                if (TextUtils.isDigitsOnly(s1))
                {
                    s = newLinkIntent(context, com/ebay/mobile/viewitem/ItemViewActivity, intent);
                    s.putExtra("item_view_id", Long.parseLong(s1));
                    s.putExtra("item_view_kind", com.ebay.common.ConstantsCommon.ItemKind.Won.toString());
                }
            }
            context = uri.getQueryParameter("variations");
            obj = s;
            if (!TextUtils.isEmpty(context))
            {
                uri = context.split(",");
                context = new ArrayList();
                int j = uri.length;
                int i = 0;
                while (i < j) 
                {
                    intent = uri[i].split(":");
                    if (intent.length == 2)
                    {
                        context.add(new NameValue(intent[0].trim(), intent[1].trim()));
                    }
                    i++;
                }
                obj = s;
                if (context.size() > 0)
                {
                    s.putParcelableArrayListExtra("param_variation_values", context);
                    s.putExtra("user_action", com.ebay.mobile.viewitem.ItemViewActivity.UserAction.BUY_IT_NOW.ordinal());
                    obj = s;
                }
            }
        } else
        if ("user.signin".equals(s2))
        {
            context = new Intent(context, com/ebay/mobile/activities/SignInDeepLinkActivity);
            context.setFlags(0x4000000);
            context.putExtra("noSignIn", true);
            uri = uri.getQueryParameter("user");
            if (!TextUtils.isEmpty(uri))
            {
                context.putExtra("user", uri);
            }
            obj = context;
            if (MyApp.getPrefs().isSignedIn())
            {
                context.putExtra("prevUser", MyApp.getPrefs().getCurrentUser());
                obj = context;
            }
        } else
        if ("user.bid".equals(s2))
        {
            uri = uri.getQueryParameter("id");
            obj = s1;
            if (isItemId(uri))
            {
                obj = newLinkIntent(context, com/ebay/mobile/viewitem/ItemViewActivity, intent);
                ((Intent) (obj)).putExtra("item_view_id", Long.parseLong(uri));
                if (s != null)
                {
                    ((Intent) (obj)).putExtra("com.ebay.mobile.tracking.Referrer", s);
                }
                ((Intent) (obj)).putExtra("item_view_kind", com.ebay.common.ConstantsCommon.ItemKind.Found.toString());
            }
        } else
        if (s2.startsWith("item."))
        {
            if ("item.query".equals(s2))
            {
                context = addLinkIntentFlags(SearchDeepLinkUtil.parseDeepLink(context, s2, uri), intent);
                obj = s1;
                if (context != null)
                {
                    obj = context;
                    ((Intent) (obj)).putExtra("com.ebay.mobile.tracking.Referrer", s);
                }
            } else
            if ("item.view".equals(s2))
            {
                s2 = uri.getQueryParameter("id");
                obj = s1;
                if (isItemId(s2))
                {
                    boolean flag1 = false;
                    obj = newLinkIntent(context, com/ebay/mobile/viewitem/ItemViewActivity, intent);
                    ((Intent) (obj)).putExtra("item_view_id", Long.parseLong(s2));
                    if (s != null)
                    {
                        ((Intent) (obj)).putExtra("com.ebay.mobile.tracking.Referrer", s);
                    }
                    context = uri.getQueryParameter("iid");
                    if (context != null)
                    {
                        ((Intent) (obj)).putExtra("feed_interest_id", context);
                    }
                    context = parseItemCurrency(uri.getQueryParameter("orc"), uri.getQueryParameter("orp"));
                    if (context != null)
                    {
                        flag1 = true;
                        ((Intent) (obj)).putExtra("item_view_original_retail_price", context);
                    }
                    context = parseSavingsRate(uri.getQueryParameter("sr"));
                    if (context != null)
                    {
                        flag1 = true;
                        ((Intent) (obj)).putExtra("item_view_savings_rate", context.intValue());
                    }
                    context = uri.getQueryParameter("pt");
                    if (context != null)
                    {
                        flag1 = true;
                        ((Intent) (obj)).putExtra("item_view_pricing_treatment", context);
                    }
                    if (flag1)
                    {
                        context = com.ebay.common.ConstantsCommon.ItemKind.Deals.toString();
                    } else
                    {
                        context = com.ebay.common.ConstantsCommon.ItemKind.Found.toString();
                    }
                    ((Intent) (obj)).putExtra("item_view_kind", context);
                }
            } else
            if ("item.browse".equals(s2))
            {
                obj = newLinkIntent(context, com/ebay/mobile/categorybrowser/BrowseCategoriesActivity, intent);
            } else
            if ("item.deals".equals(s2) && deviceconfiguration.get(DcsBoolean.Deals))
            {
                uri = uri.getQueryParameter("mskuItemTitle");
                if (uri != null)
                {
                    obj = newLinkIntent(context, com/ebay/mobile/activities/DealsActivity, intent);
                    ((Intent) (obj)).putExtra("mskuItemTitle", uri);
                } else
                {
                    obj = addLinkIntentFlags(DealsActivity.getStartingIntent(this, MyApp.getPrefs().getAuthentication()), intent);
                }
            } else
            {
                obj = s1;
                if ("item.events".equals(s2))
                {
                    uri = uri.getQueryParameter("eventname");
                    obj = s1;
                    if (!TextUtils.isEmpty(uri))
                    {
                        obj = newLinkIntent(context, com/ebay/mobile/events/EventItemsActivity, intent);
                        ((Intent) (obj)).putExtra("eventSeoName", uri);
                    }
                }
            }
        } else
        if ("photo.gallery".equals(s2))
        {
            obj = s1;
            if (intent.hasExtra("photo.gallery.urls"))
            {
                context = newLinkIntent(context, com/ebay/mobile/viewitem/ItemViewPhotoGalleryActivity, intent);
                context.putExtra("photo.gallery.urls", intent.getStringArrayListExtra("photo.gallery.urls"));
                if (intent.hasExtra("photo.gallery.position"))
                {
                    context.putExtra("photo.gallery.position", intent.getIntExtra("photo.gallery.position", 0));
                }
                if (intent.hasExtra("photo.gallery.autoscroll"))
                {
                    context.putExtra("photo.gallery.autoscroll", intent.getBooleanExtra("photo.gallery.autoscroll", false));
                }
                if (intent.hasExtra("photo.gallery.title"))
                {
                    context.putExtra("photo.gallery.title", intent.getStringExtra("photo.gallery.title"));
                }
                obj = context;
                if (intent.hasExtra("photo.gallery.show.small.gallery"))
                {
                    context.putExtra("photo.gallery.show.small.gallery", intent.getBooleanExtra("photo.gallery.show.small.gallery", false));
                    obj = context;
                }
            }
        } else
        if (s2.equals("webview"))
        {
            obj = addLinkIntentFlags(WebviewDeepLinkUtil.parseDeepLink(context, s2, uri), intent);
        } else
        if (s2.equals("user.rtm"))
        {
            uri = uri.getQueryParameter("campaignSelector");
            obj = s1;
            if (!TextUtils.isEmpty(uri))
            {
                obj = newLinkIntent(context, com/ebay/mobile/activities/eBay, intent);
                ((Intent) (obj)).putExtra("rtmCampaignSelector", uri);
                ((Intent) (obj)).putExtra("noSignIn", true);
            }
        } else
        {
            obj = s1;
            if (s2.startsWith("ep."))
            {
                context = ExperimentationUtil.getManager(getEbayContext());
                obj = s1;
                if (context != null)
                {
                    obj = s1;
                    if (context.isQAModeEnabled())
                    {
                        boolean flag2 = true;
                        if (s2.equals("ep.opt.in"))
                        {
                            context.optIn(uri.getQueryParameter("id"));
                        } else
                        if (s2.equals("ep.opt.out"))
                        {
                            context.optOut(uri.getQueryParameter("id"));
                        } else
                        if (s2.equals("ep.opt.reset"))
                        {
                            uri = uri.getQueryParameter("id");
                            context.resetOptIn(uri);
                            context.resetOptOut(uri);
                        } else
                        if (s2.equals("ep.opt.reset.all"))
                        {
                            context.resetAllOptInOut();
                        } else
                        if (s2.equals("ep.requalify"))
                        {
                            context.requalify(true);
                        } else
                        {
                            flag2 = false;
                        }
                        obj = s1;
                        if (flag2)
                        {
                            context.requalify(true);
                            obj = s1;
                        }
                    }
                }
            }
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static Uri getEffectiveUri(Uri uri)
    {
        Object obj = QueryParam.fromQueryString(uri.getEncodedQuery());
        if (((List) (obj)).isEmpty())
        {
            return uri;
        }
        ArrayList arraylist = new ArrayList();
        QueryParam queryparam = QueryParam.getByKey(((List) (obj)), "nav_andr");
        int j;
        if (queryparam != null)
        {
            try
            {
                arraylist.addAll(QueryParam.fromQueryString(URLDecoder.decode(queryparam.value, "UTF-8")));
            }
            catch (UnsupportedEncodingException unsupportedencodingexception) { }
        }
        queryparam = QueryParam.getByKey(((List) (obj)), "alt_andr");
        if (queryparam != null)
        {
            arraylist.add(new QueryParam("alt", queryparam.value));
        }
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            QueryParam queryparam1 = (QueryParam)((Iterator) (obj)).next();
            if (!queryparam1.key.startsWith("nav_") && !queryparam1.key.startsWith("alt_") && QueryParam.getByKey(arraylist, queryparam1.key) == null)
            {
                arraylist.add(queryparam1);
            }
        } while (true);
        uri = uri.toString();
        j = uri.indexOf("?");
        obj = new StringBuilder();
        for (int i = 0; i < arraylist.size(); i++)
        {
            QueryParam queryparam2 = (QueryParam)arraylist.get(i);
            if (i > 0)
            {
                ((StringBuilder) (obj)).append("&");
            }
            ((StringBuilder) (obj)).append(queryparam2.toString());
        }

        return Uri.parse((new StringBuilder()).append(uri.substring(0, j)).append("?").append(((StringBuilder) (obj)).toString()).toString());
    }

    private static boolean isItemId(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            String s1 = s.trim();
            int i = s1.length();
            if (i >= 10 && i <= 19)
            {
                try
                {
                    Long.parseLong(s);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return false;
                }
                return TextUtils.isDigitsOnly(s1);
            }
        }
        return false;
    }

    private static Intent newLinkIntent(Context context, Class class1, Intent intent)
    {
        return addLinkIntentFlags(new Intent(context, class1), intent);
    }

    private ItemCurrency parseItemCurrency(String s, String s1)
    {
        ItemCurrency itemcurrency = null;
        if (!TextUtils.isEmpty(s))
        {
            try
            {
                Double.valueOf(s1);
                itemcurrency = new ItemCurrency(s, s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
        }
        return itemcurrency;
    }

    private Integer parseSavingsRate(String s)
    {
        String s1 = null;
        int i;
        try
        {
            s = Integer.valueOf(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return s1;
        }
        s1 = s;
        if (s.intValue() < 1)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        s1 = s;
        i = s.intValue();
        if (i <= 99)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        s = null;
        return s;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        homeIntent = new Intent(this, com/ebay/mobile/activities/eBay);
        homeIntent.setFlags(0x4000000);
        if (bundle != null)
        {
            return;
        } else
        {
            directAndClose(getIntent());
            return;
        }
    }

}
