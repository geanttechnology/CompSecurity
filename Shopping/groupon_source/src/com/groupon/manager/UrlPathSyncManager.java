// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import android.net.Uri;
import com.groupon.cookies.CookieFactory;
import com.groupon.db.models.Relevance;
import com.groupon.deeplink.DeepLinkData;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.deeplink.Endpoint;
import com.groupon.deeplink.InvalidDeepLinkException;
import com.groupon.http.NameValuePair;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.service.DeepLinkManager;
import com.groupon.service.LocationService;
import com.groupon.service.LoginService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ExecutorManager;
import com.groupon.util.GeoPoint;
import com.groupon.util.HttpUtil;
import com.groupon.util.LoggingUtils;
import com.groupon.util.PausableThreadPoolExecutor;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.manager:
//            AnyChannelSyncManager, SearchResultsDeepLinkParameterProcessor

public class UrlPathSyncManager extends AnyChannelSyncManager
{

    protected static final Set EXCLUDE_SERVER_PARAM_SET = new HashSet(Arrays.asList(new String[] {
        "metadata", "secure_assets", "client_id", "client_version_id"
    }));
    protected static final Set OVERRIDE_PARAM_SET = new HashSet(Arrays.asList(new String[] {
        "limit", "offset", "lang", "show"
    }));
    private static String STRIP_VERSION_PATTERN = "^(/v[0-9]+/)";
    private CookieFactory cookieFactory;
    private DeepLinkManager deepLinkManager;
    private DeepLinkUtil deepLinkUtil;
    private boolean isSearchDeepLink;
    private LocationService locationService;
    private LoginService loginService;
    private String originatingChannel;
    private String urlPath;
    private String widgetRequestId;
    private String widgetScenarioId;
    private String widgetTreatment;

    public UrlPathSyncManager(Context context)
    {
        super(context, "unconfigured");
    }

    public UrlPathSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor, ExecutorManager executormanager)
    {
        super(context, pausablethreadpoolexecutor, executormanager, "unconfigured");
    }

    protected Object[] addExtraNstNameValueParams(Object aobj[])
    {
        int i = aobj.length;
        Object aobj1[] = new Object[i + 2];
        System.arraycopy(((Object) (aobj)), 0, ((Object) (aobj1)), 0, i);
        aobj1[i] = "andcon_extra";
        aobj1[i + 1] = Uri.encode(urlPath.split("\\?")[0]);
        return aobj1;
    }

    public void configure(String s, String s1, String s2, String s3, String s4, String s5)
    {
        urlPath = normalizePath(s);
        channel = s1;
        originatingChannel = s2;
        widgetRequestId = s3;
        widgetScenarioId = s4;
        widgetTreatment = s5;
    }

    protected volatile void doSync(Object obj, int i, int j)
        throws Exception
    {
        doSync((Void)obj, i, j);
    }

    protected void doSync(Void void1, int i, int j)
        throws Exception
    {
        if (Strings.notEmpty(urlPath))
        {
            super.doSync(void1, i, j);
        }
    }

    protected SyncHttp getSyncHttp(int i, int j)
        throws Exception
    {
        List list = getNameValueParams(i, j);
        list.addAll(Arrays.asList(new Serializable[] {
            "offset", Integer.valueOf(i), "limit", Integer.valueOf(j)
        }));
        List list1 = HttpUtil.extractNameValuePairs(new URI(urlPath));
        if (isSearchDeepLink)
        {
            list = mergeDeepLinkParams(urlPath, list);
        } else
        {
            list = mergeParams(list1, list);
        }
        return new SyncHttp(context, java/io/InputStream, getUrl(i, j), list.toArray());
    }

    protected String getUrl(int i, int j)
    {
        String s;
        try
        {
            s = String.format("https:%s", new Object[] {
                (new URI(urlPath)).getPath()
            });
        }
        catch (URISyntaxException urisyntaxexception)
        {
            throw new RuntimeException(urisyntaxexception);
        }
        return s;
    }

    protected void logDealSearch(String s, String s1, Object aobj[], String s2, String s3, Relevance relevance, int i)
    {
        s1 = ((String) (addExtraNstNameValueParams(aobj)));
        aobj = originatingChannel;
        s2 = ((LoggingUtils)loggingUtils.get()).getLogger().encodeAsCSV(new String[] {
            widgetRequestId, widgetTreatment
        });
        super.logDealSearch(s, ((String) (aobj)), s1, widgetScenarioId, s2, relevance, i);
    }

    protected List mergeDeepLinkParams(String s, List list)
    {
        GeoPoint geopoint = locationService.getBestGuessForLocation();
        list.addAll(Arrays.asList(new Serializable[] {
            "other_deals", Boolean.valueOf(false), "lat", Float.valueOf(geopoint.getLatitudeDegrees()), "lng", Float.valueOf(geopoint.getLongitudeDegrees())
        }));
        if (loginService.isLoggedIn())
        {
            list.addAll(Arrays.asList(new String[] {
                "email_address", loginService.getEmail()
            }));
        } else
        {
            list.addAll(Arrays.asList(new String[] {
                "visitor_id", cookieFactory.getBrowserCookie()
            }));
        }
        return (new SearchResultsDeepLinkParameterProcessor(s, list)).process();
    }

    protected List mergeParams(List list, List list1)
    {
        ArrayList arraylist = new ArrayList();
        HashMap hashmap = new HashMap();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            NameValuePair namevaluepair = (NameValuePair)list.next();
            if (!EXCLUDE_SERVER_PARAM_SET.contains(namevaluepair.name))
            {
                hashmap.put(namevaluepair.name, namevaluepair.value);
            }
        } while (true);
        if (list1.size() % 2 != 0)
        {
            throw new RuntimeException((new StringBuilder()).append("Invalid URL name/value pairs: ").append(Strings.toString(list1)).toString());
        }
        for (list = list1.iterator(); list.hasNext();)
        {
            list1 = Strings.toString(list.next());
            if (!hashmap.containsKey(list1) || OVERRIDE_PARAM_SET.contains(list1))
            {
                hashmap.put(list1, Strings.toString(list.next()));
            } else
            {
                list.next();
            }
        }

        for (list = hashmap.entrySet().iterator(); list.hasNext(); arraylist.add(list1.getValue()))
        {
            list1 = (java.util.Map.Entry)list.next();
            arraylist.add(list1.getKey());
        }

        return arraylist;
    }

    protected String normalizePath(String s)
    {
        String s1;
        String s2;
        s1 = s;
        if (!deepLinkUtil.isDeepLink(s))
        {
            break MISSING_BLOCK_LABEL_127;
        }
        s2 = s;
        Object obj = deepLinkUtil.getDeepLink(s);
        s1 = s;
        s2 = s;
        if (!deepLinkManager.isDirectlyFollowable(((DeepLinkData) (obj))))
        {
            break MISSING_BLOCK_LABEL_127;
        }
        s1 = s;
        s2 = s;
        if (!((DeepLinkData) (obj)).getEndpoint().equals(Endpoint.SEARCH_RESULTS))
        {
            break MISSING_BLOCK_LABEL_127;
        }
        s2 = s;
        isSearchDeepLink = true;
        s = "/deals/search";
        s2 = s;
        obj = Uri.parse(((DeepLinkData) (obj)).toString()).getEncodedQuery();
        s1 = s;
        s2 = s;
        if (Strings.notEmpty(obj))
        {
            s2 = s;
            try
            {
                s1 = (new StringBuilder()).append("/deals/search").append("?").append(((String) (obj))).toString();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s1 = s2;
            }
        }
        return s1.replaceAll(STRIP_VERSION_PATTERN, "/");
    }

    protected boolean requiresRedirectLogging()
    {
        return false;
    }

    protected boolean shouldAddChannelParam()
    {
        return false;
    }

    protected boolean showSmuggledDeals()
    {
        return false;
    }

}
