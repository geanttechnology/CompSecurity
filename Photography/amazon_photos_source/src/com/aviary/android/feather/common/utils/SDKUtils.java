// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Referenced classes of package com.aviary.android.feather.common.utils:
//            PackageManagerUtils, IOUtils

public final class SDKUtils
{
    private static final class ApiKeyReader
    {

        private static final int API_BILLING_INDEX = 2;
        private static final int API_KEY_INDEX = 0;
        private static final int API_SECRET_INDEX = 1;
        private static final String METADATA_API_KEY = "com.aviary.android.feather.v1.API_KEY";
        private static final String METADATA_CDS_DEBUG = "com.aviary.android.feather.v1.CDS_DEBUG";
        private static final String METADATA_LOCALYTICS_API_KEY = "com.aviary.android.feather.v1.LOCALYTICS_API_KEY";
        static final Object M_API_KEY_LOCK = new Object();
        private static final List M_KEYS = new ArrayList();
        static String mTrackingApiKey;

        static String getApiKey(Context context)
        {
            if (M_KEYS.isEmpty())
            {
                synchronized (M_API_KEY_LOCK)
                {
                    if (M_KEYS.isEmpty())
                    {
                        initializeKeys(context, M_KEYS);
                    }
                }
            }
            return getKeyAt(0, "");
            context;
            obj;
            JVM INSTR monitorexit ;
            throw context;
        }

        static String getApiSecret(Context context)
        {
            if (M_KEYS.isEmpty())
            {
                synchronized (M_API_KEY_LOCK)
                {
                    if (M_KEYS.isEmpty())
                    {
                        initializeKeys(context, M_KEYS);
                    }
                }
            }
            return getKeyAt(1, "");
            context;
            obj;
            JVM INSTR monitorexit ;
            throw context;
        }

        static String getBillingKey(Context context)
        {
            if (M_KEYS.isEmpty())
            {
                synchronized (M_API_KEY_LOCK)
                {
                    if (M_KEYS.isEmpty())
                    {
                        initializeKeys(context, M_KEYS);
                    }
                }
            }
            return getKeyAt(2, "");
            context;
            obj;
            JVM INSTR monitorexit ;
            throw context;
        }

        static boolean getCdsDebug(Context context)
        {
            return readCdsDebugInfoFromMetadata(context, false);
        }

        static String getKeyAt(int i, String s)
        {
            Object obj = M_API_KEY_LOCK;
            obj;
            JVM INSTR monitorenter ;
            if (M_KEYS.size() <= i)
            {
                break MISSING_BLOCK_LABEL_35;
            }
            s = (String)M_KEYS.get(i);
            return s;
            obj;
            JVM INSTR monitorexit ;
            return s;
            s;
            obj;
            JVM INSTR monitorexit ;
            throw s;
        }

        static String[] getKeys(Context context)
        {
            return (new String[] {
                getApiKey(context), getApiSecret(context), getBillingKey(context)
            });
        }

        static String getTrackingApiKey(Context context)
        {
            if (mTrackingApiKey == null)
            {
                synchronized (M_API_KEY_LOCK)
                {
                    if (mTrackingApiKey == null)
                    {
                        mTrackingApiKey = readLocalyticsApiKey(context);
                    }
                }
            }
            return mTrackingApiKey;
            context;
            obj;
            JVM INSTR monitorexit ;
            throw context;
        }

        private static void initializeKeys(Context context, List list)
        {
            String s1;
            String s2;
            String as[];
label0:
            {
                s2 = "";
                String s3 = "";
                as = readExtraKeys(context);
                s1 = s2;
                String s = s3;
                if (PackageManagerUtils.isStandalone(context))
                {
                    ArrayList arraylist = new ArrayList();
                    readApiKeyFromContentProvider(context, arraylist);
                    s1 = s2;
                    s = s3;
                    if (arraylist.size() >= 2)
                    {
                        s1 = (String)arraylist.get(0);
                        s = (String)arraylist.get(1);
                    }
                }
                if (!TextUtils.isEmpty(s1))
                {
                    s2 = s1;
                    s1 = s;
                    if (!TextUtils.isEmpty(s))
                    {
                        break label0;
                    }
                }
                Log.d("SDKUtils", "using standalone api/secret");
                s2 = readApiKeyFromMetadata(context);
                s1 = as[0];
            }
            context = as[1];
            list.add(s2);
            list.add(s1);
            list.add(context);
        }

        private static void readApiKeyFromContentProvider(Context context, List list)
        {
            context = context.getContentResolver().query(Uri.parse("content://com.aviary.android.providers.devicedefault/v1/getkeys"), new String[] {
                "ak"
            }, null, null, null);
            if (context == null)
            {
                return;
            }
            if (context.moveToFirst() && context.getColumnCount() == 2)
            {
                String s = context.getString(0);
                String s1 = context.getString(1);
                Log.d("SDKUtils", "from content provider");
                if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1))
                {
                    break MISSING_BLOCK_LABEL_108;
                }
                list.add(s);
                list.add(s1);
            }
_L2:
            IOUtils.closeSilently(context);
            return;
            Log.w("SDKUtils", "content provider returned invalid key/secret");
            if (true) goto _L2; else goto _L1
_L1:
            list;
            IOUtils.closeSilently(context);
            throw list;
        }

        private static String readApiKeyFromMetadata(Context context)
        {
            context = PackageManagerUtils.getApplicationInfo(context).metaData;
            if (context != null && context.containsKey("com.aviary.android.feather.v1.API_KEY"))
            {
                return context.getString("com.aviary.android.feather.v1.API_KEY");
            } else
            {
                return null;
            }
        }

        private static boolean readCdsDebugInfoFromMetadata(Context context, boolean flag)
        {
            context = PackageManagerUtils.getApplicationInfo(context).metaData;
            boolean flag1 = flag;
            if (context != null)
            {
                flag1 = context.getBoolean("com.aviary.android.feather.v1.CDS_DEBUG", flag);
            }
            return flag1;
        }

        private static String[] readExtraKeys(Context context)
        {
            String as[] = new String[2];
            as[0] = "";
            as[1] = "";
            String s;
            String s1;
            try
            {
                context = new Scanner(context.getAssets().open("aviary/aviary.txt"), "UTF-8");
                s = context.nextLine();
                s1 = context.nextLine();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                return as;
            }
            as[0] = s;
            as[1] = s1;
            IOUtils.closeSilently(context);
            return as;
        }

        private static String readLocalyticsApiKey(Context context)
        {
            context = PackageManagerUtils.getApplicationInfo(context).metaData;
            if (context == null)
            {
                return "ff159f6cc04d5010ac6461e-fc511f5e-b6ff-11e0-049a-007f58cb3154";
            }
            if (context.containsKey("com.aviary.android.feather.v1.LOCALYTICS_API_KEY"))
            {
                return context.getString("com.aviary.android.feather.v1.LOCALYTICS_API_KEY");
            } else
            {
                return "ff159f6cc04d5010ac6461e-fc511f5e-b6ff-11e0-049a-007f58cb3154";
            }
        }


        private ApiKeyReader()
        {
        }
    }


    public static final int IAP_RELEASE_VERSION = 212;
    private static final String LOCALYTICS_SDK_API_KEY = "ff159f6cc04d5010ac6461e-fc511f5e-b6ff-11e0-049a-007f58cb3154";
    static final String LOG_TAG = "SDKUtils";
    public static final String MISSING_APIKEY_MESSAGE = "API-KEY is missing. Did you forget to add the <meta-data android:name='com.aviary.android.feather.v1.API_KEY' android:value='your-api-key' /> inside the <application /> tag of your AndroidManifest.xml file?";
    public static final String SDK_BUILD_TYPE = "release";
    public static final String SDK_FLAVOR = "production";
    public static final String SDK_PACKAGE_NAME = "com.aviary.android.feather.sdk";
    public static final int SDK_VERSION_CODE = 380;
    public static final String SDK_VERSION_NAME = "3.6.2";
    private static int sCdsDebug = -1;

    private SDKUtils()
    {
    }

    public static String getApiKey(Context context)
    {
        return ApiKeyReader.getApiKey(context);
    }

    public static boolean getCDSDebug(Context context)
    {
        if (sCdsDebug == -1)
        {
            int i;
            if (ApiKeyReader.getCdsDebug(context))
            {
                i = 1;
            } else
            {
                i = 0;
            }
            sCdsDebug = i;
        }
        return sCdsDebug == 1;
    }

    public static String[] getKeys(Context context)
    {
        return ApiKeyReader.getKeys(context);
    }

    public static String getTrackerApiKey(Context context)
    {
        return ApiKeyReader.getTrackingApiKey(context);
    }

}
