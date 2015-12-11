// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.application.PMApplication;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.controllers.GlobalPartiesController;
import com.poshmark.controllers.UserStateSummaryController;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.data_model.models.SuggestedSearchItem;
import com.poshmark.data_model.models.UserStateSummary;
import com.poshmark.db.DbApi;
import com.poshmark.ui.fragments.BrandFragment;
import com.poshmark.ui.fragments.BrandsMetaItemListViewFragment;
import com.poshmark.ui.fragments.ClosetFragment;
import com.poshmark.ui.fragments.FindPeopleFragment;
import com.poshmark.ui.fragments.ListingDetailsFragment;
import com.poshmark.ui.fragments.MappPageFragment;
import com.poshmark.ui.fragments.MyLikesFragment;
import com.poshmark.ui.fragments.PartyFragment;
import com.poshmark.ui.fragments.PartyInviteFragment;
import com.poshmark.ui.fragments.SearchResultsFragment;
import com.poshmark.ui.fragments.ShowroomFragment;
import com.poshmark.ui.fragments.UserSharesFragment;
import com.poshmark.ui.fragments.ViewBundleFragment;
import com.poshmark.utils.meta_data.BrandsMetaItemPickerInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.poshmark.utils:
//            SearchFilterModel, FbDeferredDeepLinkManager, DeferredDeepLinkManager, DeepLinkLaunchInfo

public class DeepLinkUtils
{
    public static final class DEEPLINK_DESTINATION extends Enum
    {

        private static final DEEPLINK_DESTINATION $VALUES[];
        public static final DEEPLINK_DESTINATION ACCOUNT;
        public static final DEEPLINK_DESTINATION BRAND_PAGE;
        public static final DEEPLINK_DESTINATION BRAND_PICKER;
        public static final DEEPLINK_DESTINATION CLOSET;
        public static final DEEPLINK_DESTINATION EXPANDED_MIFU;
        public static final DEEPLINK_DESTINATION FIND_PEOPLE;
        public static final DEEPLINK_DESTINATION INVALID;
        public static final DEEPLINK_DESTINATION LISTING_DETAILS;
        public static final DEEPLINK_DESTINATION MAPP_PAGE;
        public static final DEEPLINK_DESTINATION MYBUNDLES;
        public static final DEEPLINK_DESTINATION MYLIKES;
        public static final DEEPLINK_DESTINATION NEWS;
        public static final DEEPLINK_DESTINATION PARTIES;
        public static final DEEPLINK_DESTINATION PARTY;
        public static final DEEPLINK_DESTINATION SEARCH_BRAND;
        public static final DEEPLINK_DESTINATION SEARCH_CATEGORY;
        public static final DEEPLINK_DESTINATION SEARCH_KEYWORD;
        public static final DEEPLINK_DESTINATION SELL;
        public static final DEEPLINK_DESTINATION SHARES;
        public static final DEEPLINK_DESTINATION SHOP;
        public static final DEEPLINK_DESTINATION SHOWROOM;

        public static DEEPLINK_DESTINATION valueOf(String s)
        {
            return (DEEPLINK_DESTINATION)Enum.valueOf(com/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION, s);
        }

        public static DEEPLINK_DESTINATION[] values()
        {
            return (DEEPLINK_DESTINATION[])$VALUES.clone();
        }

        static 
        {
            INVALID = new DEEPLINK_DESTINATION("INVALID", 0);
            SHOP = new DEEPLINK_DESTINATION("SHOP", 1);
            PARTIES = new DEEPLINK_DESTINATION("PARTIES", 2);
            SELL = new DEEPLINK_DESTINATION("SELL", 3);
            NEWS = new DEEPLINK_DESTINATION("NEWS", 4);
            ACCOUNT = new DEEPLINK_DESTINATION("ACCOUNT", 5);
            CLOSET = new DEEPLINK_DESTINATION("CLOSET", 6);
            LISTING_DETAILS = new DEEPLINK_DESTINATION("LISTING_DETAILS", 7);
            PARTY = new DEEPLINK_DESTINATION("PARTY", 8);
            SHOWROOM = new DEEPLINK_DESTINATION("SHOWROOM", 9);
            SHARES = new DEEPLINK_DESTINATION("SHARES", 10);
            MYLIKES = new DEEPLINK_DESTINATION("MYLIKES", 11);
            MYBUNDLES = new DEEPLINK_DESTINATION("MYBUNDLES", 12);
            EXPANDED_MIFU = new DEEPLINK_DESTINATION("EXPANDED_MIFU", 13);
            SEARCH_KEYWORD = new DEEPLINK_DESTINATION("SEARCH_KEYWORD", 14);
            SEARCH_CATEGORY = new DEEPLINK_DESTINATION("SEARCH_CATEGORY", 15);
            SEARCH_BRAND = new DEEPLINK_DESTINATION("SEARCH_BRAND", 16);
            MAPP_PAGE = new DEEPLINK_DESTINATION("MAPP_PAGE", 17);
            BRAND_PICKER = new DEEPLINK_DESTINATION("BRAND_PICKER", 18);
            BRAND_PAGE = new DEEPLINK_DESTINATION("BRAND_PAGE", 19);
            FIND_PEOPLE = new DEEPLINK_DESTINATION("FIND_PEOPLE", 20);
            $VALUES = (new DEEPLINK_DESTINATION[] {
                INVALID, SHOP, PARTIES, SELL, NEWS, ACCOUNT, CLOSET, LISTING_DETAILS, PARTY, SHOWROOM, 
                SHARES, MYLIKES, MYBUNDLES, EXPANDED_MIFU, SEARCH_KEYWORD, SEARCH_CATEGORY, SEARCH_BRAND, MAPP_PAGE, BRAND_PICKER, BRAND_PAGE, 
                FIND_PEOPLE
            });
        }

        private DEEPLINK_DESTINATION(String s, int i)
        {
            super(s, i);
        }
    }

    public static class DeepLinkWrapper
    {

        public String url;

        public DeepLinkWrapper()
        {
        }
    }


    public DeepLinkUtils()
    {
    }

    public static String constructMappDestinationUrl(Uri uri)
    {
        Object obj = null;
        String s = new String("");
        if (uri != null)
        {
            String s2 = uri.getPath();
            obj = uri.getQueryParameterNames();
            Object obj1 = s;
            if (obj != null)
            {
                Iterator iterator = ((Set) (obj)).iterator();
                obj = s;
                if (iterator.hasNext())
                {
                    obj = (new StringBuilder()).append(s).append("?").toString();
                }
                do
                {
                    obj1 = obj;
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    String s1 = (String)iterator.next();
                    obj = (new StringBuilder()).append(((String) (obj))).append(s1).toString();
                    obj = (new StringBuilder()).append(((String) (obj))).append("=").toString();
                    s1 = (new StringBuilder()).append(((String) (obj))).append(uri.getQueryParameter(s1)).toString();
                    obj = s1;
                    if (iterator.hasNext())
                    {
                        obj = (new StringBuilder()).append(s1).append("&").toString();
                    }
                } while (true);
            }
            obj = (new StringBuilder()).append("https://www.poshmark.com/mapp").append(s2).append(((String) (obj1))).toString();
        }
        return ((String) (obj));
    }

    public static String extractIdFromString(String s)
    {
        int i;
        int j;
        byte byte0;
        i = s.lastIndexOf("_");
        j = s.lastIndexOf("-");
        byte0 = -1;
        if (i == -1 || j == -1) goto _L2; else goto _L1
_L1:
        String s1;
        if (i <= j)
        {
            i = j;
        }
_L4:
        if (i != -1)
        {
            s1 = s.substring(i + 1);
            if (s1 != null)
            {
                break; /* Loop/switch isn't completed */
            }
        }
        return s;
_L2:
        if (i != -1)
        {
            j = i;
            s.substring(i + 1);
            i = j;
        } else
        {
            i = byte0;
            if (j != -1)
            {
                i = j;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        return s1;
    }

    public static void fixCategorySubCategoryInfoInModel(SearchFilterModel searchfiltermodel)
    {
        if (searchfiltermodel != null)
        {
            Object obj = null;
            String s = searchfiltermodel.getCategory();
            if (s != null)
            {
                MetaItem metaitem = DbApi.getCurrentCategoryFromId(s);
                obj = metaitem;
                if (metaitem == null)
                {
                    obj = DbApi.getCurrentCategoryFromLabel(s);
                }
            }
            if (obj != null)
            {
                searchfiltermodel.setCategory(((MetaItem) (obj)).getId());
                obj = searchfiltermodel.getSubCategories();
                if (obj != null && !((List) (obj)).isEmpty())
                {
                    Object obj1 = (String)((List) (obj)).get(0);
                    MetaItem metaitem1 = DbApi.getSubCategoryFromLabel(((String) (obj1)));
                    if (metaitem1 != null)
                    {
                        obj1 = new ArrayList();
                        ((List) (obj1)).add(metaitem1.getId());
                        for (int i = 1; i < ((List) (obj)).size(); i++)
                        {
                            MetaItem metaitem2 = DbApi.getSubCategoryFromLabel((String)((List) (obj)).get(i));
                            if (metaitem2 != null)
                            {
                                ((List) (obj1)).add(metaitem2.getId());
                            }
                        }

                        searchfiltermodel.clearSubCategories();
                        searchfiltermodel.setSubCategoryList(((List) (obj1)));
                    } else
                    {
                        obj1 = DbApi.getSubCategoryFromId(((String) (obj1)));
                        if (obj1 != null)
                        {
                            ArrayList arraylist = new ArrayList();
                            arraylist.add(((MetaItem) (obj1)).getId());
                            for (int j = 1; j < ((List) (obj)).size(); j++)
                            {
                                MetaItem metaitem3 = DbApi.getSubCategoryFromId((String)((List) (obj)).get(j));
                                if (metaitem3 != null)
                                {
                                    arraylist.add(metaitem3.getId());
                                }
                            }

                            searchfiltermodel.clearSubCategories();
                            searchfiltermodel.setSubCategoryList(arraylist);
                            return;
                        }
                    }
                }
            }
        }
    }

    public static DEEPLINK_DESTINATION getDeepLinkDestination(Uri uri)
    {
        String s = uri.getHost();
        uri = uri.getPathSegments();
        if (s.equalsIgnoreCase(getStringResource(0x7f0600a5)) || s.equalsIgnoreCase(getStringResource(0x7f0600a6)))
        {
            return DEEPLINK_DESTINATION.LISTING_DETAILS;
        }
        if (s.equalsIgnoreCase(getStringResource(0x7f0600ad)))
        {
            return DEEPLINK_DESTINATION.PARTY;
        }
        if (s.equalsIgnoreCase(getStringResource(0x7f0600ab)))
        {
            return DEEPLINK_DESTINATION.PARTIES;
        }
        if (s.equalsIgnoreCase(getStringResource(0x7f0600ac)))
        {
            if (uri.size() == 0)
            {
                return DEEPLINK_DESTINATION.PARTIES;
            } else
            {
                return DEEPLINK_DESTINATION.PARTY;
            }
        }
        if (s.equalsIgnoreCase(getStringResource(0x7f0600b3)))
        {
            return DEEPLINK_DESTINATION.SHOP;
        }
        if (s.equalsIgnoreCase(getStringResource(0x7f0600a4)))
        {
            return DEEPLINK_DESTINATION.CLOSET;
        }
        if (s.equalsIgnoreCase(getStringResource(0x7f0602ba)))
        {
            if (uri.size() == 1)
            {
                return DEEPLINK_DESTINATION.CLOSET;
            }
            if (uri.size() == 2)
            {
                if (((String)uri.get(1)).equalsIgnoreCase(getStringResource(0x7f060218)))
                {
                    return DEEPLINK_DESTINATION.CLOSET;
                }
                if (((String)uri.get(1)).equalsIgnoreCase(getStringResource(0x7f06025b)))
                {
                    return DEEPLINK_DESTINATION.SHARES;
                }
            }
        } else
        {
            if (s.equalsIgnoreCase(getStringResource(0x7f0600aa)))
            {
                return DEEPLINK_DESTINATION.NEWS;
            }
            if (s.equalsIgnoreCase(getStringResource(0x7f0600b4)))
            {
                return DEEPLINK_DESTINATION.SHOWROOM;
            }
            if (s.equalsIgnoreCase(getStringResource(0x7f0600b5)))
            {
                if (uri.size() == 1)
                {
                    return DEEPLINK_DESTINATION.SHOWROOM;
                }
            } else
            {
                if (s.equalsIgnoreCase(getStringResource(0x7f0600b2)))
                {
                    return DEEPLINK_DESTINATION.SEARCH_KEYWORD;
                }
                if (s.equalsIgnoreCase(getStringResource(0x7f0600b0)))
                {
                    return DEEPLINK_DESTINATION.BRAND_PAGE;
                }
                if (s.equalsIgnoreCase(getStringResource(0x7f0600b1)))
                {
                    return DEEPLINK_DESTINATION.SEARCH_CATEGORY;
                }
                if (s.equalsIgnoreCase(getStringResource(0x7f0600a3)))
                {
                    if (uri.size() >= 1)
                    {
                        return DEEPLINK_DESTINATION.BRAND_PAGE;
                    } else
                    {
                        return DEEPLINK_DESTINATION.BRAND_PICKER;
                    }
                }
                if (s.equalsIgnoreCase(getStringResource(0x7f0600ae)))
                {
                    if (uri.size() == 1 && ((String)uri.get(0)).equalsIgnoreCase(getStringResource(0x7f0600af)))
                    {
                        return DEEPLINK_DESTINATION.FIND_PEOPLE;
                    }
                } else
                {
                    if (s.equalsIgnoreCase(getStringResource(0x7f0600a7)))
                    {
                        return DEEPLINK_DESTINATION.MAPP_PAGE;
                    }
                    if (s.equalsIgnoreCase(getStringResource(0x7f0600a9)))
                    {
                        return DEEPLINK_DESTINATION.MYLIKES;
                    }
                    if (s.equalsIgnoreCase(getStringResource(0x7f0600a8)))
                    {
                        return DEEPLINK_DESTINATION.MYBUNDLES;
                    }
                }
            }
        }
        return DEEPLINK_DESTINATION.INVALID;
    }

    public static Map getDeepLinkHash()
    {
        HashMap hashmap = new HashMap();
        if (FbDeferredDeepLinkManager.INSTANCE.getCurrentDeepLinkProcessingState() != FbDeferredDeepLinkManager.DL_STATE.DL_EXPIRED)
        {
            String s = FbDeferredDeepLinkManager.INSTANCE.getDeepLinkUrl();
            if (s != null)
            {
                hashmap.put("fbdl", s);
            }
        }
        if (DeferredDeepLinkManager.INSTANCE.getCurrentDeepLinkProcessingState() != DeferredDeepLinkManager.DL_STATE.DL_EXPIRED)
        {
            String s1 = DeferredDeepLinkManager.INSTANCE.getBranchDeepLinkJson();
            if (s1 != null)
            {
                hashmap.put("brhdl", s1);
            }
        }
        if (DeferredDeepLinkManager.INSTANCE.getCurrentDeepLinkProcessingState() != DeferredDeepLinkManager.DL_STATE.DL_EXPIRED)
        {
            String s2 = DeferredDeepLinkManager.INSTANCE.getDirectDeepLinkJson();
            if (s2 != null)
            {
                hashmap.put("drct", s2);
            }
        }
        return hashmap;
    }

    public static DeepLinkLaunchInfo getDeepLinkLaunchInfo(Uri uri)
    {
        Object obj;
        Object obj2;
        obj2 = null;
        obj = null;
        if (!uri.getScheme().toString().equalsIgnoreCase(PMApplication.getContext().getString(0x7f0600b6))) goto _L2; else goto _L1
_L1:
        List list;
        DEEPLINK_DESTINATION deeplink_destination;
        list = uri.getPathSegments();
        deeplink_destination = getDeepLinkDestination(uri);
        static class _cls1
        {

            static final int $SwitchMap$com$poshmark$utils$DeepLinkUtils$DEEPLINK_DESTINATION[];

            static 
            {
                $SwitchMap$com$poshmark$utils$DeepLinkUtils$DEEPLINK_DESTINATION = new int[DEEPLINK_DESTINATION.values().length];
                try
                {
                    $SwitchMap$com$poshmark$utils$DeepLinkUtils$DEEPLINK_DESTINATION[DEEPLINK_DESTINATION.LISTING_DETAILS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$DeepLinkUtils$DEEPLINK_DESTINATION[DEEPLINK_DESTINATION.PARTY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$DeepLinkUtils$DEEPLINK_DESTINATION[DEEPLINK_DESTINATION.PARTIES.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$DeepLinkUtils$DEEPLINK_DESTINATION[DEEPLINK_DESTINATION.SHOP.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$DeepLinkUtils$DEEPLINK_DESTINATION[DEEPLINK_DESTINATION.CLOSET.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$DeepLinkUtils$DEEPLINK_DESTINATION[DEEPLINK_DESTINATION.NEWS.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$DeepLinkUtils$DEEPLINK_DESTINATION[DEEPLINK_DESTINATION.SHOWROOM.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$DeepLinkUtils$DEEPLINK_DESTINATION[DEEPLINK_DESTINATION.SHARES.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$DeepLinkUtils$DEEPLINK_DESTINATION[DEEPLINK_DESTINATION.SEARCH_KEYWORD.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$DeepLinkUtils$DEEPLINK_DESTINATION[DEEPLINK_DESTINATION.SEARCH_BRAND.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$DeepLinkUtils$DEEPLINK_DESTINATION[DEEPLINK_DESTINATION.SEARCH_CATEGORY.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$DeepLinkUtils$DEEPLINK_DESTINATION[DEEPLINK_DESTINATION.MAPP_PAGE.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$DeepLinkUtils$DEEPLINK_DESTINATION[DEEPLINK_DESTINATION.MYLIKES.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$DeepLinkUtils$DEEPLINK_DESTINATION[DEEPLINK_DESTINATION.BRAND_PICKER.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$DeepLinkUtils$DEEPLINK_DESTINATION[DEEPLINK_DESTINATION.MYBUNDLES.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$DeepLinkUtils$DEEPLINK_DESTINATION[DEEPLINK_DESTINATION.BRAND_PAGE.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$DeepLinkUtils$DEEPLINK_DESTINATION[DEEPLINK_DESTINATION.FIND_PEOPLE.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.poshmark.utils.DeepLinkUtils.DEEPLINK_DESTINATION[deeplink_destination.ordinal()];
        JVM INSTR tableswitch 1 17: default 128
    //                   1 130
    //                   2 199
    //                   3 280
    //                   4 295
    //                   5 310
    //                   6 354
    //                   7 369
    //                   8 466
    //                   9 515
    //                   10 621
    //                   11 762
    //                   12 908
    //                   13 946
    //                   14 1030
    //                   15 1104
    //                   16 1192
    //                   17 1366;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19
_L2:
        return null;
_L3:
        obj = (String)list.get(0);
        uri = uri.getQueryParameter("banner");
        if (obj != null)
        {
            obj = extractIdFromString(((String) (obj)));
            obj2 = new Bundle();
            ((Bundle) (obj2)).putString("ID", ((String) (obj)));
            if (uri != null)
            {
                ((Bundle) (obj2)).putString("banner_json", uri);
            }
            return new DeepLinkLaunchInfo(((Bundle) (obj2)), com/poshmark/ui/fragments/ListingDetailsFragment, null);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L4:
        uri = (String)list.get(0);
        if (uri != null)
        {
            uri = extractIdFromString(uri);
            obj = GlobalPartiesController.getGlobalPartiesController().getParty(uri);
            if (obj != null)
            {
                obj2 = new Bundle();
                ((Bundle) (obj2)).putString("ID", uri);
                if (((PartyEvent) (obj)).isFutureEvent())
                {
                    return new DeepLinkLaunchInfo(((Bundle) (obj2)), com/poshmark/ui/fragments/PartyInviteFragment, obj);
                } else
                {
                    return new DeepLinkLaunchInfo(((Bundle) (obj2)), com/poshmark/ui/fragments/PartyFragment, obj);
                }
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
        uri = new DeepLinkLaunchInfo();
        uri.setTabSwitch(1);
        return uri;
_L6:
        uri = new DeepLinkLaunchInfo();
        uri.setTabSwitch(1);
        return uri;
_L7:
        uri = (String)list.get(0);
        if (uri != null)
        {
            obj = new Bundle();
            ((Bundle) (obj)).putString("NAME", uri);
            return new DeepLinkLaunchInfo(((Bundle) (obj)), com/poshmark/ui/fragments/ClosetFragment, null);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L8:
        uri = new DeepLinkLaunchInfo();
        uri.setTabSwitch(3);
        return uri;
_L9:
        obj2 = uri.getQueryParameter("request");
        uri = ((Uri) (obj));
        if (obj2 != null)
        {
            uri = handleSearchJSON(((String) (obj2)));
            fixCategorySubCategoryInfoInModel(uri);
        }
        if (uri != null)
        {
            uri.setFacet("brand");
            uri.setFacet("category_v2");
            uri.setFacet("size");
        }
        obj = (String)list.get(0);
        if (obj != null)
        {
            obj = extractIdFromString(((String) (obj)));
            obj2 = new Bundle();
            ((Bundle) (obj2)).putString("ID", ((String) (obj)));
            return new DeepLinkLaunchInfo(((Bundle) (obj2)), com/poshmark/ui/fragments/ShowroomFragment, uri);
        }
        if (true) goto _L2; else goto _L10
_L10:
        uri = (String)list.get(0);
        if (uri != null)
        {
            uri = extractIdFromString(uri);
            Bundle bundle = new Bundle();
            bundle.putString("NAME", uri);
            return new DeepLinkLaunchInfo(bundle, com/poshmark/ui/fragments/UserSharesFragment, null);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L11:
        uri = uri.getQueryParameter("request");
        if (uri != null)
        {
            uri = handleSearchJSON(uri);
            fixCategorySubCategoryInfoInModel(uri);
            if (uri != null)
            {
                Bundle bundle1 = new Bundle();
                bundle1.putString("SEARCH_TRIGGER", "sl");
                bundle1.putString("KEYWORD_SOURCE", "dl");
                if (uri.getQueryText() != null)
                {
                    obj2 = new SuggestedSearchItem();
                    obj2.kw = uri.getQueryText();
                    GlobalDbController.getGlobalDbController().addNewSearchToSavedSearches(((SuggestedSearchItem) (obj2)).kw);
                }
                uri = new DeepLinkLaunchInfo(bundle1, com/poshmark/ui/fragments/SearchResultsFragment, uri);
                uri.setTabSwitch(1);
                return uri;
            }
        }
        if (true) goto _L2; else goto _L12
_L12:
        uri = uri.getQueryParameter("request");
        if (uri != null)
        {
            uri = handleSearchJSON(uri);
            fixCategorySubCategoryInfoInModel(uri);
        } else
        {
            uri = new SearchFilterModel();
            uri.setAvailability("available");
        }
        if (uri != null)
        {
            uri.setSearchTrigger("br");
            uri.setFacet("category_v2");
            uri.setFacet("size");
            String s = (String)list.get(0);
            obj2 = new ArrayList();
            ((List) (obj2)).add(s);
            uri.clearBrand();
            uri.setBrand(((List) (obj2)));
            uri.getFilters().clearBrandList();
            s = Uri.decode(s);
            obj2 = new Bundle();
            ((Bundle) (obj2)).putString("NAME", s);
            return new DeepLinkLaunchInfo(((Bundle) (obj2)), com/poshmark/ui/fragments/BrandFragment, uri);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L13:
        uri = uri.getQueryParameter("request");
        if (uri != null)
        {
            uri = handleSearchJSON(uri);
        } else
        {
            uri = new SearchFilterModel();
            uri.setAvailability("available");
        }
        if (uri != null)
        {
            uri.setSearchTrigger("ct");
            uri.setFacet("brand");
            uri.setFacet("size");
            Object obj1 = (String)list.get(0);
            obj2 = DbApi.getCurrentCategoryFromLabel(((String) (obj1)));
            if (obj2 != null)
            {
                uri.clearCategory();
                uri.setCategory(((MetaItem) (obj2)).getId());
            } else
            {
                uri.clearCategory();
                uri.setCategory(((String) (obj1)));
            }
            fixCategorySubCategoryInfoInModel(uri);
            obj1 = new Bundle();
            ((Bundle) (obj1)).putString("SEARCH_TRIGGER", "ct");
            uri = new DeepLinkLaunchInfo(((Bundle) (obj1)), com/poshmark/ui/fragments/SearchResultsFragment, uri);
            uri.setTabSwitch(1);
            return uri;
        }
        if (true) goto _L2; else goto _L14
_L14:
        uri = constructMappDestinationUrl(uri);
        if (uri != null)
        {
            Bundle bundle2 = new Bundle();
            bundle2.putString("URL", uri);
            return new DeepLinkLaunchInfo(bundle2, com/poshmark/ui/fragments/MappPageFragment, null);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L15:
        uri = uri.getQueryParameter("request");
        if (uri != null)
        {
            uri = handleSearchJSON(uri);
            fixCategorySubCategoryInfoInModel(uri);
        } else
        {
            uri = new SearchFilterModel();
            uri.setAvailability("available");
        }
        if (uri != null)
        {
            uri.setFacet("category_v2");
            uri.setFacet("size");
            uri.setFacet("brand");
            uri.setSearchTrigger("mlk");
            return new DeepLinkLaunchInfo(null, com/poshmark/ui/fragments/MyLikesFragment, uri);
        }
        if (true) goto _L2; else goto _L16
_L16:
        uri = new BrandsMetaItemPickerInfo();
        ((BrandsMetaItemPickerInfo) (uri)).allItems.addAll(GlobalDbController.getGlobalDbController().getAllBrands());
        Bundle bundle3 = new Bundle();
        bundle3.putBoolean("SHOW_ALL", false);
        bundle3.putInt("META_ITEM_MODE", com.poshmark.ui.fragments.MetaItemListViewFragment.META_ITEM_MODES.BRAND_MODE.ordinal());
        bundle3.putBoolean("SEARCH_ENABLED", true);
        return new DeepLinkLaunchInfo(bundle3, com/poshmark/ui/fragments/BrandsMetaItemListViewFragment, uri);
_L17:
        if (list.size() == 2)
        {
            uri = (String)list.get(1);
            if (uri != null)
            {
                Bundle bundle4 = new Bundle();
                bundle4.putString("ID", uri);
                return new DeepLinkLaunchInfo(bundle4, com/poshmark/ui/fragments/ViewBundleFragment, null);
            }
        } else
        {
            uri = new Bundle();
            uri.putString("MODE", com.poshmark.ui.fragments.MyLikesFragment.MODE.BUNDLES.name());
            return new DeepLinkLaunchInfo(uri, com/poshmark/ui/fragments/MyLikesFragment, null);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L18:
        String s1 = uri.getQueryParameter("request");
        uri = ((Uri) (obj2));
        if (s1 != null)
        {
            uri = handleSearchJSON(s1);
            fixCategorySubCategoryInfoInModel(uri);
        }
        if (uri != null)
        {
            uri.setSearchTrigger("br");
            uri.setFacet("category_v2");
            uri.setFacet("size");
            String s2 = (String)list.get(0);
            Object obj3 = new ArrayList();
            ((List) (obj3)).add(s2);
            uri.clearBrand();
            uri.setBrand(((List) (obj3)));
            uri.getFilters().clearBrandList();
            s2 = Uri.decode(s2);
            obj3 = new Bundle();
            ((Bundle) (obj3)).putString("NAME", s2);
            return new DeepLinkLaunchInfo(((Bundle) (obj3)), com/poshmark/ui/fragments/BrandFragment, uri);
        }
        uri = (String)list.get(0);
        if (uri != null)
        {
            uri = Uri.decode(uri);
            Bundle bundle5 = new Bundle();
            bundle5.putString("NAME", uri);
            return new DeepLinkLaunchInfo(bundle5, com/poshmark/ui/fragments/BrandFragment, null);
        }
        if (true) goto _L2; else goto _L19
_L19:
        return new DeepLinkLaunchInfo(null, com/poshmark/ui/fragments/FindPeopleFragment, null);
    }

    public static String getStringResource(int i)
    {
        return PMApplication.getContext().getResources().getString(i);
    }

    public static FbDeferredDeepLinkManager.DeferredDeepLinkInfo handleFbDeferredDeepLinkJSON(String s)
    {
        String s1 = s;
        try
        {
            if (s.charAt(s.length() - 1) == '/')
            {
                s1 = s.substring(0, s.length() - 1);
            }
            s = new Gson();
            if (!(s instanceof Gson))
            {
                s = ((String) (s.fromJson(s1, com/poshmark/utils/FbDeferredDeepLinkManager$DeferredDeepLinkInfo)));
            } else
            {
                s = ((String) (GsonInstrumentation.fromJson((Gson)s, s1, com/poshmark/utils/FbDeferredDeepLinkManager$DeferredDeepLinkInfo)));
            }
            return (FbDeferredDeepLinkManager.DeferredDeepLinkInfo)s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
    }

    public static SearchFilterModel handleSearchJSON(String s)
    {
        Object obj = s;
        if (s.charAt(s.length() - 1) == '/')
        {
            obj = s.substring(0, s.length() - 1);
        }
        s = new Gson();
        if (s instanceof Gson) goto _L2; else goto _L1
_L1:
        s = ((String) (s.fromJson(((String) (obj)), com/poshmark/utils/SearchFilterModel)));
_L13:
        s = (SearchFilterModel)s;
        obj = s.getCondition();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        if (!((String) (obj)).equals("nwt") && !((String) (obj)).equals("ret"))
        {
            s.clearCondition();
        }
        obj = s.getAvailability();
        if (obj == null) goto _L4; else goto _L3
_L3:
        if (!((String) (obj)).equals("all")) goto _L6; else goto _L5
_L5:
        s.clearAvailability();
_L11:
        obj = UserStateSummaryController.getGlobalInteractionsController().getUserStateSummary();
        if (obj == null) goto _L8; else goto _L7
_L7:
        if (!((UserStateSummary) (obj)).user_info.isMySizeAvailable()) goto _L8; else goto _L9
_L9:
        s.enableMySizeFilter(true);
        return s;
_L2:
        try
        {
            s = ((String) (GsonInstrumentation.fromJson((Gson)s, ((String) (obj)), com/poshmark/utils/SearchFilterModel)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (((String) (obj)).equals("available") || ((String) (obj)).equals("sold_out") || ((String) (obj)).equals("all")) goto _L11; else goto _L10
_L10:
        s.setAvailability("available");
          goto _L11
_L4:
        s.setAvailability("available");
          goto _L11
_L8:
        return s;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public static boolean isValidDeepLink(Uri uri)
    {
        return uri.getScheme().toString().equalsIgnoreCase(PMApplication.getContext().getResources().getString(0x7f0600b6));
    }
}
