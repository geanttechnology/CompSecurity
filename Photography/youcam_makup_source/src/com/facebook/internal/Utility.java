// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Settings;
import com.facebook.model.GraphObject;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.facebook.internal:
//            ImageDownloader, Validate, AttributionIdentifiers

public final class Utility
{

    private static final String APPLICATION_FIELDS = "fields";
    private static final String APP_SETTING_FIELDS[] = {
        "supports_attribution", "supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled"
    };
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
    private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a1";
    private static final String HASH_ALGORITHM_MD5 = "MD5";
    private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
    static final String LOG_TAG = "FacebookSDK";
    private static final String NUX_CONTENT = "gdpv4_nux_content";
    private static final String NUX_ENABLED = "gdpv4_nux_enabled";
    private static final String SUPPORTS_ATTRIBUTION = "supports_attribution";
    private static final String SUPPORTS_IMPLICIT_SDK_LOGGING = "supports_implicit_sdk_logging";
    private static final String URL_SCHEME = "https";
    private static Map fetchedAppSettings = new ConcurrentHashMap();

    public Utility()
    {
    }

    public static boolean areObjectsEqual(Object obj, Object obj1)
    {
        if (obj == null)
        {
            return obj1 == null;
        } else
        {
            return obj.equals(obj1);
        }
    }

    public static transient ArrayList arrayList(Object aobj[])
    {
        ArrayList arraylist = new ArrayList(aobj.length);
        int j = aobj.length;
        for (int i = 0; i < j; i++)
        {
            arraylist.add(aobj[i]);
        }

        return arraylist;
    }

    public static transient List asListNoNulls(Object aobj[])
    {
        ArrayList arraylist = new ArrayList();
        int j = aobj.length;
        for (int i = 0; i < j; i++)
        {
            Object obj = aobj[i];
            if (obj != null)
            {
                arraylist.add(obj);
            }
        }

        return arraylist;
    }

    public static Uri buildUri(String s, String s1, Bundle bundle)
    {
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        builder.scheme("https");
        builder.authority(s);
        builder.path(s1);
        s = bundle.keySet().iterator();
        do
        {
            if (!s.hasNext())
            {
                break;
            }
            s1 = (String)s.next();
            Object obj = bundle.get(s1);
            if (obj instanceof String)
            {
                builder.appendQueryParameter(s1, (String)obj);
            }
        } while (true);
        return builder.build();
    }

    public static void clearCaches(Context context)
    {
        ImageDownloader.clearCache(context);
    }

    private static void clearCookiesForDomain(Context context, String s)
    {
        CookieSyncManager.createInstance(context).sync();
        context = CookieManager.getInstance();
        String s1 = context.getCookie(s);
        if (s1 == null)
        {
            return;
        }
        String as[] = s1.split(";");
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String as1[] = as[i].split("=");
            if (as1.length > 0)
            {
                context.setCookie(s, (new StringBuilder()).append(as1[0].trim()).append("=;expires=Sat, 1 Jan 2000 00:00:01 UTC;").toString());
            }
        }

        context.removeExpiredCookie();
    }

    public static void clearFacebookCookies(Context context)
    {
        clearCookiesForDomain(context, "facebook.com");
        clearCookiesForDomain(context, ".facebook.com");
        clearCookiesForDomain(context, "https://facebook.com");
        clearCookiesForDomain(context, "https://.facebook.com");
    }

    public static void closeQuietly(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
    }

    static Map convertJSONObjectToHashMap(JSONObject jsonobject)
    {
        HashMap hashmap;
        JSONArray jsonarray;
        int i;
        hashmap = new HashMap();
        jsonarray = jsonobject.names();
        i = 0;
_L3:
        if (i >= jsonarray.length()) goto _L2; else goto _L1
_L1:
        Object obj1;
        String s;
        s = jsonarray.getString(i);
        obj1 = jsonobject.get(s);
        Object obj = obj1;
        try
        {
            if (obj1 instanceof JSONObject)
            {
                obj = convertJSONObjectToHashMap((JSONObject)obj1);
            }
            hashmap.put(s, obj);
        }
        catch (JSONException jsonexception) { }
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        return hashmap;
    }

    public static void deleteDirectory(File file)
    {
        if (!file.exists())
        {
            return;
        }
        if (file.isDirectory())
        {
            File afile[] = file.listFiles();
            int j = afile.length;
            for (int i = 0; i < j; i++)
            {
                deleteDirectory(afile[i]);
            }

        }
        file.delete();
    }

    public static void disconnectQuietly(URLConnection urlconnection)
    {
        if (urlconnection instanceof HttpURLConnection)
        {
            ((HttpURLConnection)urlconnection).disconnect();
        }
    }

    public static String getActivityName(Context context)
    {
        if (context == null)
        {
            return "null";
        }
        if (context == context.getApplicationContext())
        {
            return "unknown";
        } else
        {
            return context.getClass().getSimpleName();
        }
    }

    public static String getHashedDeviceAndAppID(Context context, String s)
    {
        context = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (context == null)
        {
            return null;
        } else
        {
            return sha1hash((new StringBuilder()).append(context).append(s).toString());
        }
    }

    public static String getMetadataApplicationId(Context context)
    {
        Validate.notNull(context, "context");
        Settings.loadDefaultsFromMetadata(context);
        return Settings.getApplicationId();
    }

    public static transient Method getMethodQuietly(Class class1, String s, Class aclass[])
    {
        try
        {
            class1 = class1.getMethod(s, aclass);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        return class1;
    }

    public static transient Method getMethodQuietly(String s, String s1, Class aclass[])
    {
        try
        {
            s = getMethodQuietly(Class.forName(s), s1, aclass);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static Object getStringPropertyAsJSON(JSONObject jsonobject, String s, String s1)
    {
        jsonobject = ((JSONObject) (jsonobject.opt(s)));
        if (jsonobject != null && (jsonobject instanceof String))
        {
            jsonobject = ((JSONObject) ((new JSONTokener((String)jsonobject)).nextValue()));
        }
        if (jsonobject != null && !(jsonobject instanceof JSONObject) && !(jsonobject instanceof JSONArray))
        {
            if (s1 != null)
            {
                s = new JSONObject();
                s.putOpt(s1, jsonobject);
                return s;
            } else
            {
                throw new FacebookException("Got an unexpected non-JSON object.");
            }
        } else
        {
            return jsonobject;
        }
    }

    private static String hashBytes(MessageDigest messagedigest, byte abyte0[])
    {
        messagedigest.update(abyte0);
        messagedigest = messagedigest.digest();
        abyte0 = new StringBuilder();
        int j = messagedigest.length;
        for (int i = 0; i < j; i++)
        {
            byte byte0 = messagedigest[i];
            abyte0.append(Integer.toHexString(byte0 >> 4 & 0xf));
            abyte0.append(Integer.toHexString(byte0 >> 0 & 0xf));
        }

        return abyte0.toString();
    }

    private static String hashWithAlgorithm(String s, String s1)
    {
        return hashWithAlgorithm(s, s1.getBytes());
    }

    private static String hashWithAlgorithm(String s, byte abyte0[])
    {
        try
        {
            s = MessageDigest.getInstance(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return hashBytes(s, abyte0);
    }

    public static transient Object invokeMethodQuietly(Object obj, Method method, Object aobj[])
    {
        try
        {
            obj = method.invoke(obj, aobj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        return obj;
    }

    public static boolean isNullOrEmpty(String s)
    {
        return s == null || s.length() == 0;
    }

    public static boolean isNullOrEmpty(Collection collection)
    {
        return collection == null || collection.size() == 0;
    }

    public static boolean isSubset(Collection collection, Collection collection1)
    {
        boolean flag = false;
        if (collection1 == null || collection1.size() == 0)
        {
            if (collection == null || collection.size() == 0)
            {
                flag = true;
            }
            return flag;
        }
        collection1 = new HashSet(collection1);
        for (collection = collection.iterator(); collection.hasNext();)
        {
            if (!collection1.contains(collection.next()))
            {
                return false;
            }
        }

        return true;
    }

    public static void logd(String s, Exception exception)
    {
        if (Settings.isLoggingEnabled() && s != null && exception != null)
        {
            Log.d(s, (new StringBuilder()).append(exception.getClass().getSimpleName()).append(": ").append(exception.getMessage()).toString());
        }
    }

    public static void logd(String s, String s1)
    {
        if (Settings.isLoggingEnabled() && s != null && s1 != null)
        {
            Log.d(s, s1);
        }
    }

    static String md5hash(String s)
    {
        return hashWithAlgorithm("MD5", s);
    }

    public static void putObjectInBundle(Bundle bundle, String s, Object obj)
    {
        if (obj instanceof String)
        {
            bundle.putString(s, (String)obj);
            return;
        }
        if (obj instanceof Parcelable)
        {
            bundle.putParcelable(s, (Parcelable)obj);
            return;
        }
        if (obj instanceof byte[])
        {
            bundle.putByteArray(s, (byte[])(byte[])obj);
            return;
        } else
        {
            throw new FacebookException("attempted to add unsupported type to Bundle");
        }
    }

    public static FetchedAppSettings queryAppSettings(String s, boolean flag)
    {
        if (!flag && fetchedAppSettings.containsKey(s))
        {
            return (FetchedAppSettings)fetchedAppSettings.get(s);
        } else
        {
            Object obj = new Bundle();
            ((Bundle) (obj)).putString("fields", TextUtils.join(",", APP_SETTING_FIELDS));
            Request request = Request.newGraphPathRequest(null, s, null);
            request.setParameters(((Bundle) (obj)));
            obj = request.executeAndWait().getGraphObject();
            obj = new FetchedAppSettings(safeGetBooleanFromResponse(((GraphObject) (obj)), "supports_attribution"), safeGetBooleanFromResponse(((GraphObject) (obj)), "supports_implicit_sdk_logging"), safeGetStringFromResponse(((GraphObject) (obj)), "gdpv4_nux_content"), safeGetBooleanFromResponse(((GraphObject) (obj)), "gdpv4_nux_enabled"));
            fetchedAppSettings.put(s, obj);
            return ((FetchedAppSettings) (obj));
        }
    }

    public static String readStreamToString(InputStream inputstream)
    {
        Object obj = null;
        inputstream = new BufferedInputStream(inputstream);
        InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
        char ac[];
        obj = new StringBuilder();
        ac = new char[2048];
_L3:
        int i = inputstreamreader.read(ac);
        if (i == -1) goto _L2; else goto _L1
_L1:
        ((StringBuilder) (obj)).append(ac, 0, i);
          goto _L3
        Exception exception;
        exception;
        obj = inputstream;
        inputstream = exception;
_L5:
        closeQuietly(((Closeable) (obj)));
        closeQuietly(inputstreamreader);
        throw inputstream;
_L2:
        obj = ((StringBuilder) (obj)).toString();
        closeQuietly(inputstream);
        closeQuietly(inputstreamreader);
        return ((String) (obj));
        inputstream;
        inputstreamreader = null;
        continue; /* Loop/switch isn't completed */
        exception;
        inputstreamreader = null;
        obj = inputstream;
        inputstream = exception;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static boolean safeGetBooleanFromResponse(GraphObject graphobject, String s)
    {
        Object obj = Boolean.valueOf(false);
        if (graphobject != null)
        {
            obj = graphobject.getProperty(s);
        }
        graphobject = ((GraphObject) (obj));
        if (!(obj instanceof Boolean))
        {
            graphobject = Boolean.valueOf(false);
        }
        return ((Boolean)graphobject).booleanValue();
    }

    private static String safeGetStringFromResponse(GraphObject graphobject, String s)
    {
        Object obj = "";
        if (graphobject != null)
        {
            obj = graphobject.getProperty(s);
        }
        graphobject = ((GraphObject) (obj));
        if (!(obj instanceof String))
        {
            graphobject = "";
        }
        return (String)graphobject;
    }

    public static void setAppEventAttributionParameters(GraphObject graphobject, AttributionIdentifiers attributionidentifiers, String s, boolean flag)
    {
        boolean flag2 = true;
        if (attributionidentifiers != null && attributionidentifiers.getAttributionId() != null)
        {
            graphobject.setProperty("attribution", attributionidentifiers.getAttributionId());
        }
        if (attributionidentifiers != null && attributionidentifiers.getAndroidAdvertiserId() != null)
        {
            graphobject.setProperty("advertiser_id", attributionidentifiers.getAndroidAdvertiserId());
            boolean flag1;
            if (!attributionidentifiers.isTrackingLimited())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            graphobject.setProperty("advertiser_tracking_enabled", Boolean.valueOf(flag1));
        } else
        if (s != null)
        {
            graphobject.setProperty("advertiser_id", s);
        }
        if (!flag)
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        graphobject.setProperty("application_tracking_enabled", Boolean.valueOf(flag));
    }

    public static void setAppEventExtendedDeviceInfoParameters(GraphObject graphobject, Context context)
    {
        String s;
        JSONArray jsonarray;
        String s1;
        int i;
        int j;
        jsonarray = new JSONArray();
        jsonarray.put("a1");
        s1 = context.getPackageName();
        j = -1;
        s = "";
        i = j;
        context = context.getPackageManager().getPackageInfo(s1, 0);
        i = j;
        j = ((PackageInfo) (context)).versionCode;
        i = j;
        context = ((PackageInfo) (context)).versionName;
        i = j;
_L2:
        jsonarray.put(s1);
        jsonarray.put(i);
        jsonarray.put(context);
        graphobject.setProperty("extinfo", jsonarray.toString());
        return;
        context;
        context = s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static String sha1hash(String s)
    {
        return hashWithAlgorithm("SHA-1", s);
    }

    static String sha1hash(byte abyte0[])
    {
        return hashWithAlgorithm("SHA-1", abyte0);
    }

    public static boolean stringsEqualOrEmpty(String s, String s1)
    {
        boolean flag = TextUtils.isEmpty(s);
        boolean flag1 = TextUtils.isEmpty(s1);
        if (flag && flag1)
        {
            return true;
        }
        if (!flag && !flag1)
        {
            return s.equals(s1);
        } else
        {
            return false;
        }
    }

    public static transient Collection unmodifiableCollection(Object aobj[])
    {
        return Collections.unmodifiableCollection(Arrays.asList(aobj));
    }


    private class FetchedAppSettings
    {

        private String nuxContent;
        private boolean nuxEnabled;
        private boolean supportsAttribution;
        private boolean supportsImplicitLogging;

        public String getNuxContent()
        {
            return nuxContent;
        }

        public boolean getNuxEnabled()
        {
            return nuxEnabled;
        }

        public boolean supportsAttribution()
        {
            return supportsAttribution;
        }

        public boolean supportsImplicitLogging()
        {
            return supportsImplicitLogging;
        }

        private FetchedAppSettings(boolean flag, boolean flag1, String s, boolean flag2)
        {
            supportsAttribution = flag;
            supportsImplicitLogging = flag1;
            nuxContent = s;
            nuxEnabled = flag2;
        }

    }

}
