// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bolts;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package bolts:
//            AppLink, WebViewAppLinkResolver, AppLinkResolver, Task, 
//            MeasurementEvent, Continuation

public class AppLinkNavigation
{

    private static final String KEY_NAME_REFERER_APP_LINK = "referer_app_link";
    private static final String KEY_NAME_REFERER_APP_LINK_APP_NAME = "app_name";
    private static final String KEY_NAME_REFERER_APP_LINK_PACKAGE = "package";
    private static final String KEY_NAME_USER_AGENT = "user_agent";
    private static final String KEY_NAME_VERSION = "version";
    private static final String VERSION = "1.0";
    private static AppLinkResolver defaultResolver;
    private final AppLink appLink;
    private final Bundle appLinkData;
    private final Bundle extras;

    public AppLinkNavigation(AppLink applink, Bundle bundle, Bundle bundle1)
    {
        if (applink == null)
        {
            throw new IllegalArgumentException("appLink must not be null.");
        }
        Bundle bundle2 = bundle;
        if (bundle == null)
        {
            bundle2 = new Bundle();
        }
        bundle = bundle1;
        if (bundle1 == null)
        {
            bundle = new Bundle();
        }
        appLink = applink;
        extras = bundle2;
        appLinkData = bundle;
    }

    private Bundle buildAppLinkDataForNavigation(Context context)
    {
        Bundle bundle = new Bundle();
        Bundle bundle1 = new Bundle();
        if (context != null)
        {
            Object obj = context.getPackageName();
            if (obj != null)
            {
                bundle1.putString("package", ((String) (obj)));
            }
            obj = context.getApplicationInfo();
            if (obj != null)
            {
                context = context.getString(((ApplicationInfo) (obj)).labelRes);
                if (context != null)
                {
                    bundle1.putString("app_name", context);
                }
            }
        }
        bundle.putAll(getAppLinkData());
        bundle.putString("target_url", getAppLink().getSourceUrl().toString());
        bundle.putString("version", "1.0");
        bundle.putString("user_agent", "Bolts Android 1.2.0");
        bundle.putBundle("referer_app_link", bundle1);
        bundle.putBundle("extras", getExtras());
        return bundle;
    }

    public static AppLinkResolver getDefaultResolver()
    {
        return defaultResolver;
    }

    private JSONObject getJSONForBundle(Bundle bundle)
    {
        JSONObject jsonobject = new JSONObject();
        String s;
        for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); jsonobject.put(s, getJSONValue(bundle.get(s))))
        {
            s = (String)iterator.next();
        }

        return jsonobject;
    }

    private Object getJSONValue(Object obj)
    {
        int i = 0;
        int j2 = 0;
        int j4 = 0;
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag5 = false;
        boolean flag6 = false;
        Object obj1;
        if (obj instanceof Bundle)
        {
            obj1 = getJSONForBundle((Bundle)obj);
        } else
        {
            if (obj instanceof CharSequence)
            {
                return obj.toString();
            }
            if (obj instanceof List)
            {
                obj1 = new JSONArray();
                for (obj = ((List)obj).iterator(); ((Iterator) (obj)).hasNext(); ((JSONArray) (obj1)).put(getJSONValue(((Iterator) (obj)).next()))) { }
                return obj1;
            }
            if (obj instanceof SparseArray)
            {
                obj1 = new JSONArray();
                obj = (SparseArray)obj;
                for (i = ((flag6) ? 1 : 0); i < ((SparseArray) (obj)).size(); i++)
                {
                    ((JSONArray) (obj1)).put(((SparseArray) (obj)).keyAt(i), getJSONValue(((SparseArray) (obj)).valueAt(i)));
                }

                return obj1;
            }
            if (obj instanceof Character)
            {
                return obj.toString();
            }
            obj1 = obj;
            if (!(obj instanceof Boolean))
            {
                if (obj instanceof Number)
                {
                    if ((obj instanceof Double) || (obj instanceof Float))
                    {
                        return Double.valueOf(((Number)obj).doubleValue());
                    } else
                    {
                        return Long.valueOf(((Number)obj).longValue());
                    }
                }
                if (obj instanceof boolean[])
                {
                    JSONArray jsonarray = new JSONArray();
                    obj = (boolean[])(boolean[])obj;
                    for (j2 = obj.length; i < j2; i++)
                    {
                        jsonarray.put(getJSONValue(Boolean.valueOf(obj[i])));
                    }

                    return jsonarray;
                }
                if (obj instanceof char[])
                {
                    JSONArray jsonarray1 = new JSONArray();
                    obj = (char[])(char[])obj;
                    j4 = obj.length;
                    for (int j = j2; j < j4; j++)
                    {
                        jsonarray1.put(getJSONValue(Character.valueOf(obj[j])));
                    }

                    return jsonarray1;
                }
                if (obj instanceof CharSequence[])
                {
                    JSONArray jsonarray2 = new JSONArray();
                    obj = (CharSequence[])(CharSequence[])obj;
                    int k2 = obj.length;
                    for (int k = j4; k < k2; k++)
                    {
                        jsonarray2.put(getJSONValue(obj[k]));
                    }

                    return jsonarray2;
                }
                if (obj instanceof double[])
                {
                    JSONArray jsonarray3 = new JSONArray();
                    obj = (double[])(double[])obj;
                    int l2 = obj.length;
                    for (int l = ((flag) ? 1 : 0); l < l2; l++)
                    {
                        jsonarray3.put(getJSONValue(Double.valueOf(obj[l])));
                    }

                    return jsonarray3;
                }
                if (obj instanceof float[])
                {
                    JSONArray jsonarray4 = new JSONArray();
                    obj = (float[])(float[])obj;
                    int i3 = obj.length;
                    for (int i1 = ((flag1) ? 1 : 0); i1 < i3; i1++)
                    {
                        jsonarray4.put(getJSONValue(Float.valueOf(obj[i1])));
                    }

                    return jsonarray4;
                }
                if (obj instanceof int[])
                {
                    JSONArray jsonarray5 = new JSONArray();
                    obj = (int[])(int[])obj;
                    int j3 = obj.length;
                    for (int j1 = ((flag2) ? 1 : 0); j1 < j3; j1++)
                    {
                        jsonarray5.put(getJSONValue(Integer.valueOf(obj[j1])));
                    }

                    return jsonarray5;
                }
                if (obj instanceof long[])
                {
                    JSONArray jsonarray6 = new JSONArray();
                    obj = (long[])(long[])obj;
                    int k3 = obj.length;
                    for (int k1 = ((flag3) ? 1 : 0); k1 < k3; k1++)
                    {
                        jsonarray6.put(getJSONValue(Long.valueOf(obj[k1])));
                    }

                    return jsonarray6;
                }
                if (obj instanceof short[])
                {
                    JSONArray jsonarray7 = new JSONArray();
                    obj = (short[])(short[])obj;
                    int l3 = obj.length;
                    for (int l1 = ((flag4) ? 1 : 0); l1 < l3; l1++)
                    {
                        jsonarray7.put(getJSONValue(Short.valueOf(obj[l1])));
                    }

                    return jsonarray7;
                }
                if (obj instanceof String[])
                {
                    JSONArray jsonarray8 = new JSONArray();
                    obj = (String[])(String[])obj;
                    int i4 = obj.length;
                    for (int i2 = ((flag5) ? 1 : 0); i2 < i4; i2++)
                    {
                        jsonarray8.put(getJSONValue(obj[i2]));
                    }

                    return jsonarray8;
                } else
                {
                    return null;
                }
            }
        }
        return obj1;
    }

    private static AppLinkResolver getResolver(Context context)
    {
        if (getDefaultResolver() != null)
        {
            return getDefaultResolver();
        } else
        {
            return new WebViewAppLinkResolver(context);
        }
    }

    public static NavigationResult navigate(Context context, AppLink applink)
    {
        return (new AppLinkNavigation(applink, null, null)).navigate(context);
    }

    public static Task navigateInBackground(Context context, Uri uri)
    {
        return navigateInBackground(context, uri, getResolver(context));
    }

    public static Task navigateInBackground(final Context context, Uri uri, AppLinkResolver applinkresolver)
    {
        return applinkresolver.getAppLinkFromUrlInBackground(uri).onSuccess(new Continuation() {

            final Context val$context;

            public NavigationResult then(Task task)
            {
                return AppLinkNavigation.navigate(context, (AppLink)task.getResult());
            }

            public volatile Object then(Task task)
            {
                return then(task);
            }

            
            {
                context = context1;
                super();
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    public static Task navigateInBackground(Context context, String s)
    {
        return navigateInBackground(context, s, getResolver(context));
    }

    public static Task navigateInBackground(Context context, String s, AppLinkResolver applinkresolver)
    {
        return navigateInBackground(context, Uri.parse(s), applinkresolver);
    }

    public static Task navigateInBackground(Context context, URL url)
    {
        return navigateInBackground(context, url, getResolver(context));
    }

    public static Task navigateInBackground(Context context, URL url, AppLinkResolver applinkresolver)
    {
        return navigateInBackground(context, Uri.parse(url.toString()), applinkresolver);
    }

    private void sendAppLinkNavigateEventBroadcast(Context context, Intent intent, NavigationResult navigationresult, JSONException jsonexception)
    {
        HashMap hashmap = new HashMap();
        if (jsonexception != null)
        {
            hashmap.put("error", jsonexception.getLocalizedMessage());
        }
        if (navigationresult.isSucceeded())
        {
            jsonexception = "1";
        } else
        {
            jsonexception = "0";
        }
        hashmap.put("success", jsonexception);
        hashmap.put("type", navigationresult.getCode());
        MeasurementEvent.sendBroadcastEvent(context, "al_nav_out", intent, hashmap);
    }

    public static void setDefaultResolver(AppLinkResolver applinkresolver)
    {
        defaultResolver = applinkresolver;
    }

    public AppLink getAppLink()
    {
        return appLink;
    }

    public Bundle getAppLinkData()
    {
        return appLinkData;
    }

    public Bundle getExtras()
    {
        return extras;
    }

    public NavigationResult navigate(Context context)
    {
        PackageManager packagemanager;
        Object obj2;
        Iterator iterator;
        packagemanager = context.getPackageManager();
        obj2 = buildAppLinkDataForNavigation(context);
        iterator = getAppLink().getTargets().iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj;
        AppLink.Target target = (AppLink.Target)iterator.next();
        obj = new Intent("android.intent.action.VIEW");
        if (target.getUrl() != null)
        {
            ((Intent) (obj)).setData(target.getUrl());
        } else
        {
            ((Intent) (obj)).setData(appLink.getSourceUrl());
        }
        ((Intent) (obj)).setPackage(target.getPackageName());
        if (target.getClassName() != null)
        {
            ((Intent) (obj)).setClassName(target.getPackageName(), target.getClassName());
        }
        ((Intent) (obj)).putExtra("al_applink_data", ((Bundle) (obj2)));
        if (packagemanager.resolveActivity(((Intent) (obj)), 0x10000) == null) goto _L4; else goto _L3
_L3:
        Object obj1 = NavigationResult.FAILED;
        if (obj != null)
        {
            obj2 = NavigationResult.APP;
            obj1 = obj;
            obj = obj2;
        } else
        {
            Uri uri = getAppLink().getWebUrl();
            if (uri != null)
            {
                try
                {
                    obj1 = getJSONForBundle(((Bundle) (obj2)));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    sendAppLinkNavigateEventBroadcast(context, ((Intent) (obj)), NavigationResult.FAILED, ((JSONException) (obj1)));
                    throw new RuntimeException(((Throwable) (obj1)));
                }
                obj1 = new Intent("android.intent.action.VIEW", uri.buildUpon().appendQueryParameter("al_applink_data", ((JSONObject) (obj1)).toString()).build());
                obj = NavigationResult.WEB;
            } else
            {
                obj = obj1;
                obj1 = null;
            }
        }
        sendAppLinkNavigateEventBroadcast(context, ((Intent) (obj1)), ((NavigationResult) (obj)), null);
        if (obj1 != null)
        {
            context.startActivity(((Intent) (obj1)));
        }
        return ((NavigationResult) (obj));
_L2:
        obj = null;
        if (true) goto _L3; else goto _L5
_L5:
    }

    private class NavigationResult extends Enum
    {

        private static final NavigationResult $VALUES[];
        public static final NavigationResult APP;
        public static final NavigationResult FAILED;
        public static final NavigationResult WEB;
        private String code;
        private boolean succeeded;

        public static NavigationResult valueOf(String s)
        {
            return (NavigationResult)Enum.valueOf(bolts/AppLinkNavigation$NavigationResult, s);
        }

        public static NavigationResult[] values()
        {
            return (NavigationResult[])$VALUES.clone();
        }

        public String getCode()
        {
            return code;
        }

        public boolean isSucceeded()
        {
            return succeeded;
        }

        static 
        {
            FAILED = new NavigationResult("FAILED", 0, "failed", false);
            WEB = new NavigationResult("WEB", 1, "web", true);
            APP = new NavigationResult("APP", 2, "app", true);
            $VALUES = (new NavigationResult[] {
                FAILED, WEB, APP
            });
        }

        private NavigationResult(String s, int i, String s1, boolean flag)
        {
            super(s, i);
            code = s1;
            succeeded = flag;
        }
    }

}
