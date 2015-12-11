// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.supersonicads.sdk.utils:
//            Logger

public class SDKUtils
{

    private static final String TAG = com/supersonicads/sdk/utils/SDKUtils.getSimpleName();
    private static String mAdvertisingId;
    private static boolean mIsLimitedTrackingEnabled = true;

    public SDKUtils()
    {
    }

    public static int convertDpToPx(int i)
    {
        return (int)TypedValue.applyDimension(0, i, Resources.getSystem().getDisplayMetrics());
    }

    public static int convertPxToDp(int i)
    {
        return (int)TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics());
    }

    public static String convertStreamToString(InputStream inputstream, boolean flag, String s, String s1)
        throws IOException
    {
        Object obj;
        String s2;
        BufferedWriter bufferedwriter;
        obj = inputstream;
        if (flag)
        {
            obj = new GZIPInputStream(inputstream);
        }
        s2 = null;
        bufferedwriter = new BufferedWriter(new FileWriter(new File(s, s1)));
        s = new BufferedReader(new InputStreamReader(((InputStream) (obj)), "UTF-8"));
        s1 = new StringBuilder();
_L3:
        s2 = s.readLine();
        if (s2 == null) goto _L2; else goto _L1
_L1:
        s1.append(s2);
        s1.append("\n");
          goto _L3
        s1;
_L5:
        if (s != null)
        {
            s.close();
        }
        ((InputStream) (obj)).close();
        if (flag)
        {
            inputstream.close();
        }
        bufferedwriter.close();
        throw s1;
_L2:
        bufferedwriter.write(s1.toString());
        s1 = s1.toString();
        if (s != null)
        {
            s.close();
        }
        ((InputStream) (obj)).close();
        if (flag)
        {
            inputstream.close();
        }
        bufferedwriter.close();
        return s1;
        s1;
        s = s2;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static String createErrorMessage(String s, String s1)
    {
        return String.format("%s Failure occurred during initiation at: %s", new Object[] {
            s, s1
        });
    }

    public static int dpToPx(long l)
    {
        DisplayMetrics displaymetrics = Resources.getSystem().getDisplayMetrics();
        return (int)((float)l * displaymetrics.density + 0.5F);
    }

    public static String encodeString(String s)
    {
        try
        {
            s = URLEncoder.encode(s, "UTF-8").replace("+", "%20");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        return s;
    }

    public static byte[] encrypt(String s)
    {
        MessageDigest messagedigest;
        MessageDigest messagedigest1;
        messagedigest1 = null;
        messagedigest = null;
        MessageDigest messagedigest2 = MessageDigest.getInstance("SHA-1");
        messagedigest = messagedigest2;
        messagedigest1 = messagedigest2;
        messagedigest2.reset();
        messagedigest = messagedigest2;
        messagedigest1 = messagedigest2;
        messagedigest2.update(s.getBytes("UTF-8"));
        messagedigest = messagedigest2;
_L1:
        if (messagedigest != null)
        {
            return messagedigest.digest();
        } else
        {
            return null;
        }
        s;
        s.printStackTrace();
          goto _L1
        s;
        s.printStackTrace();
        messagedigest = messagedigest1;
          goto _L1
    }

    public static String getAdvertiserId()
    {
        return mAdvertisingId;
    }

    private static String getAndroidID(Context context)
    {
        return android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static int getApplicationRotation(Context context)
    {
        return ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    public static long getAvailableSpaceInMB(Context context, String s)
    {
        context = new StatFs(s);
        return ((long)context.getAvailableBlocks() * (long)context.getBlockSize()) / 0x100000L;
    }

    public static String getConnectionType(Context context)
    {
        StringBuilder stringbuilder = new StringBuilder();
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (context != null && context.isConnected())
        {
            String s = context.getTypeName();
            context.getSubtypeName();
            int i = context.getType();
            if (i == 0)
            {
                stringbuilder.append("3g");
            } else
            if (i == 1)
            {
                stringbuilder.append("wifi");
            } else
            {
                stringbuilder.append(s);
            }
        }
        return stringbuilder.toString();
    }

    public static Long getCurrentTimeMillis()
    {
        return Long.valueOf(System.currentTimeMillis());
    }

    public static int getDeviceDefaultOrientation(Context context)
    {
        WindowManager windowmanager = (WindowManager)context.getSystemService("window");
        context = context.getResources().getConfiguration();
        int i = windowmanager.getDefaultDisplay().getRotation();
        return (i != 0 && i != 2 || ((Configuration) (context)).orientation != 2) && (i != 1 && i != 3 || ((Configuration) (context)).orientation != 1) ? 1 : 2;
    }

    public static int getDeviceHeight()
    {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static float getDeviceScale()
    {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static int getDeviceWidth()
    {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static String getFileName(String s)
    {
        s = s.split(File.separator);
        s = s[s.length - 1].split("\\?")[0];
        try
        {
            s = URLEncoder.encode(s, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    public static Object getIInAppBillingServiceClass(IBinder ibinder)
    {
        Object obj = null;
        ibinder = ((IBinder) (Class.forName("com.android.vending.billing.IInAppBillingService$Stub").getMethod("asInterface", new Class[] {
            android/os/IBinder
        }).invoke(null, new Object[] {
            ibinder
        })));
        if (false)
        {
            throw new NullPointerException();
        }
_L2:
        return ibinder;
        Object obj1;
        obj1;
        ibinder = obj;
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        if (((Exception) (obj1)).getMessage() != null)
        {
            Logger.i(TAG, (new StringBuilder()).append(obj1.getClass().getSimpleName()).append(": ").append(((Exception) (obj1)).getMessage()).toString());
        }
        ibinder = obj;
        if (((Exception) (obj1)).getCause() == null) goto _L2; else goto _L3
_L3:
        Logger.i(TAG, (new StringBuilder()).append(obj1.getClass().getSimpleName()).append(": ").append(((Exception) (obj1)).getCause()).toString());
        return null;
        obj1;
        ibinder = obj;
        if (obj1 == null) goto _L2; else goto _L4
_L4:
        if (((Exception) (obj1)).getMessage() != null)
        {
            Logger.i(TAG, (new StringBuilder()).append(obj1.getClass().getSimpleName()).append(": ").append(((Exception) (obj1)).getMessage()).toString());
        }
        ibinder = obj;
        if (((Exception) (obj1)).getCause() == null) goto _L2; else goto _L5
_L5:
        Logger.i(TAG, (new StringBuilder()).append(obj1.getClass().getSimpleName()).append(": ").append(((Exception) (obj1)).getCause()).toString());
        return null;
        obj1;
        ibinder = obj;
        if (obj1 == null) goto _L2; else goto _L6
_L6:
        if (((Exception) (obj1)).getMessage() != null)
        {
            Logger.i(TAG, (new StringBuilder()).append(obj1.getClass().getSimpleName()).append(": ").append(((Exception) (obj1)).getMessage()).toString());
        }
        ibinder = obj;
        if (((Exception) (obj1)).getCause() == null) goto _L2; else goto _L7
_L7:
        Logger.i(TAG, (new StringBuilder()).append(obj1.getClass().getSimpleName()).append(": ").append(((Exception) (obj1)).getCause()).toString());
        return null;
        obj1;
        ibinder = obj;
        if (obj1 == null) goto _L2; else goto _L8
_L8:
        if (((Exception) (obj1)).getMessage() != null)
        {
            Logger.i(TAG, (new StringBuilder()).append(obj1.getClass().getSimpleName()).append(": ").append(((Exception) (obj1)).getMessage()).toString());
        }
        ibinder = obj;
        if (((Exception) (obj1)).getCause() == null) goto _L2; else goto _L9
_L9:
        Logger.i(TAG, (new StringBuilder()).append(obj1.getClass().getSimpleName()).append(": ").append(((Exception) (obj1)).getCause()).toString());
        return null;
        obj1;
        ibinder = obj;
        if (obj1 == null) goto _L2; else goto _L10
_L10:
        if (((Exception) (obj1)).getMessage() != null)
        {
            Logger.i(TAG, (new StringBuilder()).append(obj1.getClass().getSimpleName()).append(": ").append(((Exception) (obj1)).getMessage()).toString());
        }
        ibinder = obj;
        if (((Exception) (obj1)).getCause() == null) goto _L2; else goto _L11
_L11:
        Logger.i(TAG, (new StringBuilder()).append(obj1.getClass().getSimpleName()).append(": ").append(((Exception) (obj1)).getCause()).toString());
        return null;
        ibinder;
        if (false)
        {
            throw new NullPointerException();
        } else
        {
            throw ibinder;
        }
    }

    public static String getMD5(String s)
    {
        try
        {
            for (s = (new BigInteger(1, MessageDigest.getInstance("MD5").digest(s.getBytes()))).toString(16); s.length() < 32; s = (new StringBuilder()).append("0").append(s).toString()) { }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    public static JSONObject getOrientation(Context context)
    {
        int i = context.getResources().getConfiguration().orientation;
        context = "portrait";
        if (i == 2)
        {
            context = "landscape";
        }
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("orientation", context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return jsonobject;
        }
        return jsonobject;
    }

    public static JSONObject getOrientationNew(Context context)
    {
        int j;
        j = getDeviceDefaultOrientation(context);
        int i = getApplicationRotation(context);
        context = "portrait";
        if (i == 1 || i == 3)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (!i) goto _L2; else goto _L1
_L1:
        if (j == 1)
        {
            context = "landscape";
        }
_L4:
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("orientation", context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return jsonobject;
        }
        return jsonobject;
_L2:
        if (j == 2)
        {
            context = "landscape";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String getPackageName(Context context)
    {
        return context.getPackageName();
    }

    public static int getRotation(Context context)
    {
        return ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    public static String getSDKVersion()
    {
        return "5.14";
    }

    public static boolean isApplicationVisible(Context context)
    {
        String s = context.getPackageName();
        for (context = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses().iterator(); context.hasNext();)
        {
            android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)context.next();
            if (runningappprocessinfo.processName.equalsIgnoreCase(s) && runningappprocessinfo.importance == 100)
            {
                return true;
            }
        }

        return false;
    }

    public static boolean isConnectingToInternet(Context context)
    {
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context != null)
        {
            context = context.getAllNetworkInfo();
            if (context != null)
            {
                for (int i = 0; i < context.length; i++)
                {
                    if (context[i].getState() == android.net.NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public static boolean isLimitAdTrackingEnabled()
    {
        return mIsLimitedTrackingEnabled;
    }

    public static boolean isOnline(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return context != null && context.isConnected();
    }

    public static boolean isPermissionGranted(Context context, String s)
    {
        return context.checkCallingOrSelfPermission(s) == 0;
    }

    public static void loadGoogleAdvertiserInfo(Context context)
    {
        Object obj = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[] {
            android/content/Context
        }).invoke(null, new Object[] {
            context
        });
        context = obj.getClass().getMethod("getId", new Class[0]);
        Method method = obj.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]);
        mAdvertisingId = context.invoke(obj, new Object[0]).toString();
        mIsLimitedTrackingEnabled = ((Boolean)method.invoke(obj, new Object[0])).booleanValue();
        if (false)
        {
            throw new NullPointerException();
        }
_L2:
        return;
        context;
        if (context == null) goto _L2; else goto _L1
_L1:
        if (context.getMessage() != null)
        {
            Logger.i(TAG, (new StringBuilder()).append(context.getClass().getSimpleName()).append(": ").append(context.getMessage()).toString());
        }
        if (context.getCause() == null) goto _L2; else goto _L3
_L3:
        Logger.i(TAG, (new StringBuilder()).append(context.getClass().getSimpleName()).append(": ").append(context.getCause()).toString());
        return;
        context;
        if (context == null) goto _L2; else goto _L4
_L4:
        if (context.getMessage() != null)
        {
            Logger.i(TAG, (new StringBuilder()).append(context.getClass().getSimpleName()).append(": ").append(context.getMessage()).toString());
        }
        if (context.getCause() == null) goto _L2; else goto _L5
_L5:
        Logger.i(TAG, (new StringBuilder()).append(context.getClass().getSimpleName()).append(": ").append(context.getCause()).toString());
        return;
        context;
        if (context == null) goto _L2; else goto _L6
_L6:
        if (context.getMessage() != null)
        {
            Logger.i(TAG, (new StringBuilder()).append(context.getClass().getSimpleName()).append(": ").append(context.getMessage()).toString());
        }
        if (context.getCause() == null) goto _L2; else goto _L7
_L7:
        Logger.i(TAG, (new StringBuilder()).append(context.getClass().getSimpleName()).append(": ").append(context.getCause()).toString());
        return;
        context;
        if (context == null) goto _L2; else goto _L8
_L8:
        if (context.getMessage() != null)
        {
            Logger.i(TAG, (new StringBuilder()).append(context.getClass().getSimpleName()).append(": ").append(context.getMessage()).toString());
        }
        if (context.getCause() == null) goto _L2; else goto _L9
_L9:
        Logger.i(TAG, (new StringBuilder()).append(context.getClass().getSimpleName()).append(": ").append(context.getCause()).toString());
        return;
        context;
        if (context == null) goto _L2; else goto _L10
_L10:
        if (context.getMessage() != null)
        {
            Logger.i(TAG, (new StringBuilder()).append(context.getClass().getSimpleName()).append(": ").append(context.getMessage()).toString());
        }
        if (context.getCause() == null) goto _L2; else goto _L11
_L11:
        Logger.i(TAG, (new StringBuilder()).append(context.getClass().getSimpleName()).append(": ").append(context.getCause()).toString());
        return;
        context;
        if (false)
        {
            throw new NullPointerException();
        } else
        {
            throw context;
        }
    }

    public static int pxToDp(long l)
    {
        DisplayMetrics displaymetrics = Resources.getSystem().getDisplayMetrics();
        return (int)((float)l / displaymetrics.density + 0.5F);
    }

    public static String queryingPurchasedItems(Object obj, String s)
    {
        JSONArray jsonarray = new JSONArray();
        Object obj1;
        Object obj2 = obj.getClass().getMethod("getPurchases", new Class[] {
            Integer.TYPE, java/lang/String, java/lang/String, java/lang/String
        }).invoke(obj, new Object[] {
            Integer.valueOf(3), s, "inapp", null
        });
        obj = obj2.getClass().getMethod("getInt", new Class[] {
            java/lang/String
        });
        obj1 = obj2.getClass().getMethod("getStringArrayList", new Class[] {
            java/lang/String
        });
        Method method = obj2.getClass().getMethod("getString", new Class[] {
            java/lang/String
        });
        if (((Integer)((Method) (obj)).invoke(obj2, new Object[] {
    "RESPONSE_CODE"
})).intValue() != 0)
        {
            break MISSING_BLOCK_LABEL_372;
        }
        s = (ArrayList)((Method) (obj1)).invoke(obj2, new Object[] {
            "INAPP_PURCHASE_ITEM_LIST"
        });
        obj = (ArrayList)((Method) (obj1)).invoke(obj2, new Object[] {
            "INAPP_PURCHASE_DATA_LIST"
        });
        obj1 = (ArrayList)((Method) (obj1)).invoke(obj2, new Object[] {
            "INAPP_DATA_SIGNATURE_LIST"
        });
        obj2 = (String)method.invoke(obj2, new Object[] {
            "INAPP_CONTINUATION_TOKEN"
        });
        int i = 0;
_L1:
        String s1;
        Object obj3;
        if (i >= ((ArrayList) (obj)).size())
        {
            break MISSING_BLOCK_LABEL_372;
        }
        s1 = (String)((ArrayList) (obj)).get(i);
        obj3 = (String)((ArrayList) (obj1)).get(i);
        String s2 = (String)s.get(i);
        Logger.i(TAG, s1);
        Logger.i(TAG, ((String) (obj3)));
        Logger.i(TAG, s2);
        obj3 = new JSONObject();
        try
        {
            ((JSONObject) (obj3)).put("purchaseData", s1);
            ((JSONObject) (obj3)).put("signature", s1);
            ((JSONObject) (obj3)).put("sku", s1);
            jsonarray.put(obj3);
        }
        catch (JSONException jsonexception) { }
        i++;
          goto _L1
        if (false)
        {
            throw new NullPointerException();
        }
_L3:
        return jsonarray.toString();
        obj;
        if (obj != null)
        {
            if (((Exception) (obj)).getMessage() != null)
            {
                Logger.i(TAG, (new StringBuilder()).append(obj.getClass().getSimpleName()).append(": ").append(((Exception) (obj)).getMessage()).toString());
            }
            if (((Exception) (obj)).getCause() != null)
            {
                Logger.i(TAG, (new StringBuilder()).append(obj.getClass().getSimpleName()).append(": ").append(((Exception) (obj)).getCause()).toString());
            }
        }
        continue; /* Loop/switch isn't completed */
        obj;
        if (obj != null)
        {
            if (((Exception) (obj)).getMessage() != null)
            {
                Logger.i(TAG, (new StringBuilder()).append(obj.getClass().getSimpleName()).append(": ").append(((Exception) (obj)).getMessage()).toString());
            }
            if (((Exception) (obj)).getCause() != null)
            {
                Logger.i(TAG, (new StringBuilder()).append(obj.getClass().getSimpleName()).append(": ").append(((Exception) (obj)).getCause()).toString());
            }
        }
        continue; /* Loop/switch isn't completed */
        obj;
        if (obj != null)
        {
            if (((Exception) (obj)).getMessage() != null)
            {
                Logger.i(TAG, (new StringBuilder()).append(obj.getClass().getSimpleName()).append(": ").append(((Exception) (obj)).getMessage()).toString());
            }
            if (((Exception) (obj)).getCause() != null)
            {
                Logger.i(TAG, (new StringBuilder()).append(obj.getClass().getSimpleName()).append(": ").append(((Exception) (obj)).getCause()).toString());
            }
        }
        continue; /* Loop/switch isn't completed */
        obj;
        if (obj != null)
        {
            if (((Exception) (obj)).getMessage() != null)
            {
                Logger.i(TAG, (new StringBuilder()).append(obj.getClass().getSimpleName()).append(": ").append(((Exception) (obj)).getMessage()).toString());
            }
            if (((Exception) (obj)).getCause() != null)
            {
                Logger.i(TAG, (new StringBuilder()).append(obj.getClass().getSimpleName()).append(": ").append(((Exception) (obj)).getCause()).toString());
            }
        }
        if (true) goto _L3; else goto _L2
_L2:
        obj;
        if (false)
        {
            throw new NullPointerException();
        } else
        {
            throw obj;
        }
    }

    public static void showNoInternetDialog(Context context)
    {
        (new android.app.AlertDialog.Builder(context)).setMessage("No Internet Connection").setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

        }).show();
    }

}
