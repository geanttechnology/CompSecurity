// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.categoryBrowse;

import android.net.Uri;
import android.text.TextUtils;
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
    private static final String APPSTORE_DE_NODE = "1661648031";
    private static final String APPSTORE_UK_NODE = "1661657031";
    private static final String APPSTORE_US_NODE = "2350149011";
    private static final String APP_ACTION_PARAM = "app-action";
    private static final String BROWSE_APP_ACTION = "browse";
    public static final String BROWSE_APS = "/s/browse?node=aps";
    public static final String BROWSE_BASE = "/s/browse?node=";
    private static final String DATA_PARAM = "data-url";
    private static final String HEADER_ID = "sx-amzn-app";
    private static final String HEADER_VALUE = "type=phone";
    private static final String NODE_PARAM = "node";
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
        Locale locale = Locale.getDefault();
        return locale.equals(Locale.US) && "2858778011".equals(s) || locale.equals(Locale.UK) && "3010085031".equals(s) || locale.equals(Locale.GERMANY) && "3010075031".equals(s);
    }

    public static boolean shouldLaunchAppStoreBrowse(String s)
    {
        Locale locale = Locale.getDefault();
        return locale.equals(Locale.US) && "2350149011".equals(s) || locale.equals(Locale.UK) && "1661657031".equals(s) || locale.equals(Locale.GERMANY) && "1661648031".equals(s);
    }

    static 
    {
        WEBVIEW_HEADER = new ConcurrentHashMap();
        WEBVIEW_HEADER.put("sx-amzn-app", "type=phone");
    }
}
