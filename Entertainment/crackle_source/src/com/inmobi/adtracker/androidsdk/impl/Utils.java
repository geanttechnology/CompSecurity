// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.adtracker.androidsdk.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.inmobi.adtracker.androidsdk.impl.net.IMAdTrackerNetworkInterface;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.security.MessageDigest;

// Referenced classes of package com.inmobi.adtracker.androidsdk.impl:
//            IMAdTrackerAnalyticsConstants, EventList

public class Utils
{

    private static Context mAppContext;

    public Utils()
    {
    }

    public static boolean checkNetworkAvailibility()
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)getAppContext().getSystemService("connectivity");
        if (connectivitymanager.getActiveNetworkInfo() == null)
        {
            return false;
        } else
        {
            return connectivitymanager.getActiveNetworkInfo().isConnectedOrConnecting();
        }
    }

    public static boolean checkPermManifest()
    {
        int i = getAppContext().checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE");
        int j = getAppContext().checkCallingOrSelfPermission("android.permission.INTERNET");
        return i == 0 && j == 0;
    }

    public static String getAndroidId()
    {
        String s;
        if (getAppContext() == null)
        {
            s = null;
        } else
        {
            String s1 = android.provider.Settings.Secure.getString(getAppContext().getContentResolver(), "android_id");
            s = s1;
            if (s1 == null)
            {
                return android.provider.Settings.System.getString(getAppContext().getContentResolver(), "android_id");
            }
        }
        return s;
    }

    public static Context getAppContext()
    {
        return mAppContext;
    }

    public static String getODIN1()
    {
        byte abyte0[];
        Object obj;
        int i;
        try
        {
            String s = getAndroidId();
            obj = MessageDigest.getInstance("SHA-1");
            ((MessageDigest) (obj)).update(s.getBytes());
            abyte0 = ((MessageDigest) (obj)).digest();
            obj = new StringBuffer();
        }
        catch (Exception exception)
        {
            if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
            {
                Log.d(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Exception in getting ODIN-1", exception);
            }
            return null;
        }
        i = 0;
        if (i >= abyte0.length)
        {
            return ((StringBuffer) (obj)).toString();
        }
        ((StringBuffer) (obj)).append(Integer.toString((abyte0[i] & 0xff) + 256, 16).substring(1));
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_33;
        }
    }

    public static String getODIN1MD5()
    {
        byte abyte0[];
        Object obj;
        int i;
        try
        {
            String s = getODIN1();
            obj = MessageDigest.getInstance("MD5");
            ((MessageDigest) (obj)).update(s.getBytes());
            abyte0 = ((MessageDigest) (obj)).digest();
            obj = new StringBuffer();
        }
        catch (Exception exception)
        {
            if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
            {
                Log.d(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Exception in getting MD5 ODIN-1", exception);
            }
            return null;
        }
        i = 0;
        if (i >= abyte0.length)
        {
            return ((StringBuffer) (obj)).toString();
        }
        ((StringBuffer) (obj)).append(Integer.toString((abyte0[i] & 0xff) + 256, 16).substring(1));
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_33;
        }
    }

    public static String getPreferences(String s)
    {
        if (getAppContext() == null)
        {
            if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
            {
                Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Failed to get preferences..App context NULL");
            }
            return null;
        } else
        {
            return getAppContext().getSharedPreferences(IMAdTrackerAnalyticsConstants.IMAdTracker_LOG_FILE, 0).getString(s, null);
        }
    }

    public static Object readFromFile()
    {
        if (getAppContext() != null) goto _L2; else goto _L1
_L1:
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
        {
            Log.d(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Cannot read map application context NULL");
        }
_L4:
        return null;
_L2:
        Object obj = new File(getAppContext().getDir("data", 0), "eventlog");
        try
        {
            obj = new FileInputStream(((File) (obj)));
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
            {
                Log.d(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Event log File doesnot exist");
            }
            return null;
        }
        try
        {
            obj = new ObjectInputStream(((java.io.InputStream) (obj)));
        }
        catch (StreamCorruptedException streamcorruptedexception)
        {
            if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
            {
                Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Event log File corrupted");
                streamcorruptedexception.printStackTrace();
            }
            return null;
        }
        catch (IOException ioexception)
        {
            if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
            {
                Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Event log File IO Exception");
                ioexception.printStackTrace();
            }
            return null;
        }
        obj = ((ObjectInputStream) (obj)).readObject();
        return obj;
        Object obj1;
        obj1;
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
        {
            Log.d(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "End of file");
            return null;
        }
        continue; /* Loop/switch isn't completed */
        obj1;
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
        {
            Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Error reading Event log file");
            ((Exception) (obj1)).printStackTrace();
        }
        return null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static boolean resetStatus()
    {
        if (getAppContext() == null)
        {
            return false;
        } else
        {
            IMAdTrackerNetworkInterface.goalEventList.addEvent("install");
            android.content.SharedPreferences.Editor editor = getAppContext().getSharedPreferences(IMAdTrackerAnalyticsConstants.IMAdTracker_LOG_FILE, 0).edit();
            editor.putBoolean(IMAdTrackerAnalyticsConstants.IMAdTracker_INSTALL_STATUS, false);
            editor.commit();
            return true;
        }
    }

    public static void saveToFile(Object obj)
    {
        if (getAppContext() != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj1 = new File(getAppContext().getDir("data", 0), "eventlog");
        obj1 = new ObjectOutputStream(new FileOutputStream(((File) (obj1)), false));
        ((ObjectOutputStream) (obj1)).writeObject(obj);
        ((ObjectOutputStream) (obj1)).flush();
        try
        {
            ((ObjectOutputStream) (obj1)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
        {
            Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Log File Close Exception");
            ((IOException) (obj)).printStackTrace();
            return;
        }
        if (true) goto _L4; else goto _L3
_L4:
        continue; /* Loop/switch isn't completed */
_L3:
        obj;
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
        {
            Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Log File Not found");
            return;
        }
        continue; /* Loop/switch isn't completed */
        obj;
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
        {
            Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Log File IO Exception");
            ((IOException) (obj)).printStackTrace();
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
        obj;
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
        {
            Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Log File IO Exception write ERROR");
            ((IOException) (obj)).printStackTrace();
            return;
        }
        if (true) goto _L7; else goto _L6
_L7:
        continue; /* Loop/switch isn't completed */
_L6:
        obj;
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
        {
            Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Log File IO Exception");
            ((IOException) (obj)).printStackTrace();
            return;
        }
        if (true) goto _L1; else goto _L8
_L8:
    }

    public static void setAppContext(Context context)
    {
        mAppContext = context;
    }

    public static boolean setPreferences(String s, String s1)
    {
        if (getAppContext() == null)
        {
            if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
            {
                Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Failed to set preferences..App context NULL");
            }
            return false;
        } else
        {
            android.content.SharedPreferences.Editor editor = getAppContext().getSharedPreferences(IMAdTrackerAnalyticsConstants.IMAdTracker_LOG_FILE, 0).edit();
            editor.putString(s, s1);
            editor.commit();
            return true;
        }
    }

    public static boolean updateStatus()
    {
        if (getAppContext() == null)
        {
            return false;
        } else
        {
            IMAdTrackerNetworkInterface.goalEventList.removeEvent("install", 1);
            android.content.SharedPreferences.Editor editor = getAppContext().getSharedPreferences(IMAdTrackerAnalyticsConstants.IMAdTracker_LOG_FILE, 0).edit();
            editor.putBoolean(IMAdTrackerAnalyticsConstants.IMAdTracker_INSTALL_STATUS, true);
            editor.commit();
            return true;
        }
    }
}
