// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.bba.common.util;

import android.content.Context;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.bba.common.security.AESUtil;
import com.baidu.android.bba.common.security.Base64;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

// Referenced classes of package com.baidu.android.bba.common.util:
//            Util

public final class DeviceId
{

    private static final String AES_KEY = "30212102dicudiab";
    private static final boolean DEBUG = false;
    private static final String EXT_FILE = "baidu/.cuid";
    private static final String KEY_DEVICE_ID = "com.baidu.deviceid";
    private static final String KEY_IMEI = "bd_setting_i";
    private static final String TAG = "DeviceId";

    private DeviceId()
    {
    }

    private static void checkPermission(Context context, String s)
    {
        boolean flag;
        if (context.checkCallingOrSelfPermission(s) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new SecurityException((new StringBuilder()).append("Permission Denial: requires permission ").append(s).toString());
        } else
        {
            return;
        }
    }

    public static String getAndroidId(Context context)
    {
        String s = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        context = s;
        if (TextUtils.isEmpty(s))
        {
            context = "";
        }
        return context;
    }

    public static String getDeviceID(Context context)
    {
        Object obj;
        boolean flag;
        checkPermission(context, "android.permission.WRITE_SETTINGS");
        checkPermission(context, "android.permission.READ_PHONE_STATE");
        checkPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        flag = false;
        obj = "";
        Object obj1 = android.provider.Settings.System.getString(context.getContentResolver(), "bd_setting_i");
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        obj = obj1;
        obj1 = getIMEI(context);
        obj = obj1;
_L10:
        android.provider.Settings.System.putString(context.getContentResolver(), "bd_setting_i", ((String) (obj)));
        Object obj2 = obj;
_L5:
        String s1 = getAndroidId(context);
        if (!flag) goto _L4; else goto _L3
_L3:
        obj = Util.toMd5((new StringBuilder()).append("com.baidu").append(s1).toString().getBytes(), true);
_L7:
        return ((String) (obj));
        obj1;
_L8:
        Log.e("DeviceId", "Settings.System.getString or putString failed", ((Throwable) (obj1)));
        flag = true;
        obj2 = obj;
          goto _L5
_L4:
        Object obj3;
        obj3 = null;
        obj1 = android.provider.Settings.System.getString(context.getContentResolver(), "com.baidu.deviceid");
        obj = obj1;
        if (TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            obj1 = Util.toMd5((new StringBuilder()).append("com.baidu").append(((String) (obj2))).append(s1).toString().getBytes(), true);
            String s = android.provider.Settings.System.getString(context.getContentResolver(), ((String) (obj1)));
            obj3 = obj1;
            obj = s;
            if (!TextUtils.isEmpty(s))
            {
                android.provider.Settings.System.putString(context.getContentResolver(), "com.baidu.deviceid", s);
                setExternalDeviceId(((String) (obj2)), s);
                obj = s;
                obj3 = obj1;
            }
        }
        obj1 = obj;
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            obj = getExternalDeviceId(((String) (obj2)));
            obj1 = obj;
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                android.provider.Settings.System.putString(context.getContentResolver(), ((String) (obj3)), ((String) (obj)));
                android.provider.Settings.System.putString(context.getContentResolver(), "com.baidu.deviceid", ((String) (obj)));
                obj1 = obj;
            }
        }
        obj = obj1;
        if (!TextUtils.isEmpty(((CharSequence) (obj1)))) goto _L7; else goto _L6
_L6:
        obj = UUID.randomUUID().toString();
        obj = Util.toMd5((new StringBuilder()).append(((String) (obj2))).append(s1).append(((String) (obj))).toString().getBytes(), true);
        android.provider.Settings.System.putString(context.getContentResolver(), ((String) (obj3)), ((String) (obj)));
        android.provider.Settings.System.putString(context.getContentResolver(), "com.baidu.deviceid", ((String) (obj)));
        setExternalDeviceId(((String) (obj2)), ((String) (obj)));
        return ((String) (obj));
        obj1;
          goto _L8
_L2:
        obj = obj1;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private static String getExternalDeviceId(String s)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return "";
_L2:
        Object obj = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        StringBuilder stringbuilder;
        obj = new BufferedReader(new FileReader(((File) (obj))));
        stringbuilder = new StringBuilder();
_L3:
        String s1 = ((BufferedReader) (obj)).readLine();
label0:
        {
            if (s1 == null)
            {
                break label0;
            }
            String as[];
            try
            {
                stringbuilder.append(s1);
                stringbuilder.append("\r\n");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return "";
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return "";
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return "";
            }
        }
          goto _L3
        ((BufferedReader) (obj)).close();
        as = (new String(AESUtil.decrypt("30212102dicudiab", "30212102dicudiab", Base64.decode(stringbuilder.toString().getBytes())))).split("=");
        if (as == null) goto _L1; else goto _L4
_L4:
        if (as.length != 2 || !s.equals(as[0])) goto _L1; else goto _L5
_L5:
        s = as[1];
        return s;
    }

    public static String getIMEI(Context context)
    {
        context = (TelephonyManager)context.getSystemService("phone");
        if (context != null)
        {
            String s = context.getDeviceId();
            context = s;
            if (TextUtils.isEmpty(s))
            {
                context = "";
            }
            return context;
        } else
        {
            return "";
        }
    }

    private static void setExternalDeviceId(String s, String s1)
    {
        if (TextUtils.isEmpty(s))
        {
            return;
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(s);
        stringbuilder.append("=");
        stringbuilder.append(s1);
        s = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        try
        {
            (new File(s.getParent())).mkdirs();
            s = new FileWriter(s, false);
            s.write(Base64.encode(AESUtil.encrypt("30212102dicudiab", "30212102dicudiab", stringbuilder.toString().getBytes()), "utf-8"));
            s.flush();
            s.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }
}
