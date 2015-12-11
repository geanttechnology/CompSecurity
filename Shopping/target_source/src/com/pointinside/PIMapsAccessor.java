// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import com.pointinside.internal.utils.AndroidUtils;
import com.pointinside.internal.utils.BuildUtils;
import com.pointinside.internal.utils.LogUtils;
import com.pointinside.internal.utils.StringUtils;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package com.pointinside:
//            LibAnalyticsRequestor

public class PIMapsAccessor
{

    public static final String API_KEY_MANIFEST_PROPERTY = "com.pointinside.android.API_KEY";
    private static final int DEFAULT_SAMPLING_SIZE = 1;
    private static final String SHARED_PREFERENCES_FILE = "PIMapsAccessor";
    private static final String TAG = LogUtils.makeLogTag(com/pointinside/PIMapsAccessor.getSimpleName());
    private static String sApiKey;
    private static String sBaseUrl;
    private static PIMapsAccessor sInstance;
    private final WeakReference mContext;
    private int mMultiSamplingSampleSize;

    private PIMapsAccessor(Context context, Uri uri)
    {
        mContext = new WeakReference(context.getApplicationContext());
        sBaseUrl = uri.toString();
        BuildUtils.getFriendlyAppName(context);
        BuildUtils.getAppVersionLabel(context);
    }

    private static void executeLibAnalytics()
    {
        InitializationAnalyticsData.Builder builder = (new InitializationAnalyticsData.Builder()).appName(BuildUtils.sAppName).appVersion(BuildUtils.sAppVersionLabel).devModel(Build.MODEL).libName("PIMapsLib").libVersion("4.2.10").osVersion(String.valueOf(android.os.Build.VERSION.SDK_INT));
        (new LibAnalyticsRequestor()).sendLibAnalytics(builder.build(), (Context)sInstance.mContext.get());
    }

    public static PIMapsAccessor getInstance()
    {
        if (sInstance == null)
        {
            throw new IllegalStateException("Must call init first");
        } else
        {
            return sInstance;
        }
    }

    public static void init(Context context, Uri uri)
        throws IllegalStateException
    {
        init(context, uri, BuildUtils.getMetadataApiKey(context));
    }

    private static void init(Context context, Uri uri, String s)
        throws IllegalStateException
    {
        if (context == null)
        {
            throw new IllegalArgumentException("context must not be null");
        }
        if (sInstance != null)
        {
            throw new IllegalStateException("Environment has already been initialized");
        }
        sInstance = new PIMapsAccessor(context.getApplicationContext(), uri);
        sApiKey = s;
        if (!sameEnvironmentAsBefore(context))
        {
            LogUtils.logI(TAG, "New environment detected, wiping all previously cached data...");
            AndroidUtils.clearCacheDir(context);
        }
        executeLibAnalytics();
    }

    public static void init(Context context, String s)
        throws IllegalStateException
    {
        init(context, Uri.parse(s));
    }

    public static void init(Context context, String s, String s1)
        throws IllegalStateException
    {
        init(context, Uri.parse(s), s1);
    }

    public static boolean isInitialized()
        throws IllegalStateException
    {
        return sInstance != null;
    }

    private static boolean sameEnvironmentAsBefore(Context context)
    {
        context = context.getSharedPreferences("PIMapsAccessor", 0);
        Object obj = new StringBuilder();
        if (sBaseUrl != null)
        {
            ((StringBuilder) (obj)).append(sBaseUrl);
        }
        ((StringBuilder) (obj)).append(sApiKey);
        String s;
        try
        {
            obj = StringUtils.encodeHexString(MessageDigest.getInstance("MD5").digest(((StringBuilder) (obj)).toString().getBytes()));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException(context);
        }
        s = context.getString("env_hash", null);
        context.edit().putString("env_hash", ((String) (obj))).commit();
        return ((String) (obj)).equals(s);
    }

    public String getApiKey()
    {
        if (sApiKey == null || sApiKey.isEmpty())
        {
            throw new RuntimeException(((Context)mContext.get()).getString(R.string.metadata_api_key_not_found));
        } else
        {
            return sApiKey;
        }
    }

    public String getBaseUrl()
    {
        return sBaseUrl;
    }

    public Context getContext()
    {
        return (Context)mContext.get();
    }

    public int getMultiSamplingSampleSize()
    {
        return mMultiSamplingSampleSize;
    }

    public void setApiKey(String s)
    {
        sApiKey = s;
    }

    public void setBaseUrl(String s)
    {
        sBaseUrl = s;
        executeLibAnalytics();
        AndroidUtils.clearCacheDir(getInstance().getContext());
    }

    public void setMapViewMultiSamplingEnabled(int i)
    {
        if (i == 2 || i == 4)
        {
            mMultiSamplingSampleSize = i;
            return;
        } else
        {
            mMultiSamplingSampleSize = 1;
            return;
        }
    }

}
