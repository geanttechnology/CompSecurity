// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.categoryBrowse;

import android.net.Uri;
import android.text.TextUtils;
import com.amazon.retailsearch.android.api.init.RetailSearchInitSettings;
import com.amazon.retailsearch.android.api.init.RetailSearchInitializer;
import com.amazon.searchapp.retailsearch.client.SearchConfiguration;
import com.amazon.searchapp.retailsearch.client.SearchRealm;
import com.amazon.searchapp.retailsearch.model.Department;
import com.amazon.searchapp.retailsearch.model.RefinementLink;
import com.amazon.searchapp.retailsearch.model.Refinements;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CategoryBrowseController
{

    private static final String AIV_DE_NODE = "3010075031";
    private static final String AIV_UK_NODE = "3010085031";
    private static final String AIV_US_NODE = "2858778011";
    private static final String APPSTORE_AU_NODE = "2544160051";
    private static final String APPSTORE_BR_NODE = "6446175011";
    private static final String APPSTORE_CA_NODE = "6386371011";
    private static final String APPSTORE_DE_NODE = "1661648031";
    private static final String APPSTORE_ES_NODE = "1661649031";
    private static final String APPSTORE_FR_NODE = "1661654031";
    private static final String APPSTORE_IT_NODE = "1661660031";
    private static final String APPSTORE_JP_NODE = "2381130051";
    private static final String APPSTORE_UK_NODE = "1661657031";
    private static final String APPSTORE_US_NODE = "2350149011";
    private static final String APP_ACTION_PARAM = "app-action";
    private static final String BANJO_DE_NODE = "6369057031";
    private static final String BANJO_FR_NODE = "6369051031";
    private static final String BANJO_UK_NODE = "6369063031";
    private static final String BANJO_US_NODE = "11350978011";
    private static final String BROWSE_APP_ACTION = "browse";
    public static final String BROWSE_APS = "/s/browse?node=aps";
    public static final String BROWSE_BASE = "/s/browse?node=";
    private static final String COUNTRY_CODE_AU = "AU";
    private static final String COUNTRY_CODE_BR = "BR";
    private static final String COUNTRY_CODE_CA = "CA";
    private static final String COUNTRY_CODE_ES = "ES";
    private static final String DATA_PARAM = "data-url";
    private static final String HEADER_ID = "sx-amzn-app";
    private static final String HEADER_VALUE = "type=phone";
    private static final String NODE_ID_PARAM = "node-id";
    private static final String NODE_PARAM = "node";
    private static final String STORE_ID_PARAM = "store-id";
    public static final Map WEBVIEW_HEADER;

    public CategoryBrowseController()
    {
    }

    public static String buildCategoryBrowseLink(Uri uri)
    {
        String s;
        String s1;
        s1 = SearchConfiguration.getConfiguration().getRealm().getSecureSearchServiceUrl();
        s = "/s/browse?node=aps";
        if (uri == null || TextUtils.isEmpty(uri.toString()))
        {
            return (new StringBuilder()).append(s1).append("/s/browse?node=aps").toString();
        }
        if (!"browse".equals(uri.getQueryParameter("app-action")) || TextUtils.isEmpty(uri.getQueryParameter("data-url"))) goto _L2; else goto _L1
_L1:
        s = uri.getQueryParameter("data-url");
_L4:
        return (new StringBuilder()).append(s1).append(s).toString();
_L2:
        if ("browse".equals(uri.getQueryParameter("app-action")) && !TextUtils.isEmpty(uri.getQueryParameter("node")))
        {
            s = (new StringBuilder()).append("/s/browse?node=").append(uri.getQueryParameter("node")).toString();
        } else
        if ("browse".equals(uri.getQueryParameter("app-action")) && !TextUtils.isEmpty(uri.getQueryParameter("node-id")))
        {
            s = (new StringBuilder()).append("/s/browse?node=").append(uri.getQueryParameter("node-id")).toString();
        } else
        if ("browse".equals(uri.getQueryParameter("app-action")) && !TextUtils.isEmpty(uri.getQueryParameter("store-id")))
        {
            s = (new StringBuilder()).append("/s/browse?node=").append(uri.getQueryParameter("store-id")).toString();
        } else
        if (uri.toString().indexOf('/') != -1)
        {
            s = getPathFromUri(uri);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static RefinementLink getCurrentRefinement(Refinements refinements)
    {
        if (refinements != null && refinements.getDepartments() != null && refinements.getDepartments().getAncestry() != null && !refinements.getDepartments().getAncestry().isEmpty())
        {
            return (RefinementLink)refinements.getDepartments().getAncestry().get(refinements.getDepartments().getAncestry().size() - 1);
        } else
        {
            return null;
        }
    }

    private static String getPathFromUri(Uri uri)
    {
        String s;
        try
        {
            s = (new URL(uri.toString())).getFile();
        }
        catch (MalformedURLException malformedurlexception)
        {
            return uri.toString().substring(uri.toString().indexOf('/'));
        }
        return s;
    }

    public static boolean shouldLaunchAIVBrowse(String s)
    {
        Object obj = RetailSearchInitializer.getInstance().getSettings();
        if (obj != null && ((RetailSearchInitSettings) (obj)).isAppStoreEnabled())
        {
            if (((Locale) (obj = Locale.getDefault())).equals(Locale.US) && "2858778011".equals(s) || ((Locale) (obj)).equals(Locale.UK) && "3010085031".equals(s) || ((Locale) (obj)).equals(Locale.GERMANY) && "3010075031".equals(s))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean shouldLaunchAppStoreBrowse(String s)
    {
        Object obj = RetailSearchInitializer.getInstance().getSettings();
        if (obj != null && ((RetailSearchInitSettings) (obj)).isAppStoreEnabled())
        {
            if (((Locale) (obj = Locale.getDefault())).equals(Locale.US) && "2350149011".equals(s) || ((Locale) (obj)).equals(Locale.UK) && "1661657031".equals(s) || ((Locale) (obj)).equals(Locale.GERMANY) && "1661648031".equals(s) || ((Locale) (obj)).equals(Locale.JAPAN) && "2381130051".equals(s) || ((Locale) (obj)).equals(Locale.FRANCE) && "1661654031".equals(s) || ((Locale) (obj)).equals(Locale.ITALY) && "1661660031".equals(s) || "ES".equals(((Locale) (obj)).getCountry()) && "1661649031".equals(s) || "CA".equals(((Locale) (obj)).getCountry()) && "6386371011".equals(s) || "AU".equals(((Locale) (obj)).getCountry()) && "2544160051".equals(s) || "BR".equals(((Locale) (obj)).getCountry()) && "6446175011".equals(s))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean shouldLaunchBanjoBrowse(String s)
    {
        Object obj = RetailSearchInitializer.getInstance().getSettings();
        if (obj != null && ((RetailSearchInitSettings) (obj)).isAppStoreEnabled())
        {
            if (((Locale) (obj = Locale.getDefault())).equals(Locale.US) && "11350978011".equals(s) || ((Locale) (obj)).equals(Locale.UK) && "6369063031".equals(s) || ((Locale) (obj)).equals(Locale.GERMANY) && "6369057031".equals(s) || ((Locale) (obj)).equals(Locale.FRANCE) && "6369051031".equals(s))
            {
                return true;
            }
        }
        return false;
    }

    static 
    {
        WEBVIEW_HEADER = new ConcurrentHashMap();
        WEBVIEW_HEADER.put("sx-amzn-app", "type=phone");
    }
}
