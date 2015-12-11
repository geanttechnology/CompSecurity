// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.data;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import com.igexin.sdk.Consts;
import com.igexin.sdk.SdkService;
import com.igexin.sdk.db.DBHelper;
import com.igexin.sdk.encrypt.RC4Carder;
import com.igexin.sdk.util.StringUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

// Referenced classes of package com.igexin.sdk.data:
//            PhoneInfo

public class BasicDataManager
{

    public static String SDcardVersion = "v01";
    private static final char chars[] = {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
        'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', 
        '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 
        'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 
        'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 
        'Y', 'Z'
    };
    public static String checkSDcardnumber = "0";
    private static DBHelper dbHelper;
    private static String deviceIdPath;
    public static String dirName;
    public static String internalBroadcastAccessToken;
    public static long lastBindAppTime;
    public static String lastCidLists;
    public static long lastGetConfigTime;
    public static String lastPhoneInfo;
    public static PhoneInfo phoneInfo;
    public static Map pushMessageMap;
    public static String regId;
    public static String vcid = "";

    public BasicDataManager()
    {
    }

    private static String generateUUID(Context context)
    {
        String s = getStringFromDataStore(context, "UUID");
        if (s != null && !"".equals(s))
        {
            return s;
        } else
        {
            String s1 = UUID.randomUUID().toString().replace("-", "");
            Random random = new Random();
            random.setSeed((new Date()).getTime());
            int i = random.nextInt(s1.length() - 15);
            s1 = s1.subSequence(i, i + 15).toString().toLowerCase();
            putStringToDataStore(context, "UUID", s1);
            return s1;
        }
    }

    public static String getClientid(String s)
    {
        String s2;
        long l;
        long l1;
        l1 = 0L;
        s2 = getSessionFromFile(s);
        l = l1;
        if (s2 == null) goto _L2; else goto _L1
_L1:
        String s1 = null;
        if (s2.indexOf("null") < 0 || s2.length() < 7 || !checkSDcardnumber.equals(s2.substring(0, 7))) goto _L4; else goto _L3
_L3:
        s = s2.substring(7);
_L6:
        l = l1;
        if (s != null)
        {
            int i = s.indexOf("|");
            s1 = s;
            if (i >= 0)
            {
                s1 = s.substring(0, i);
            }
            long l2 = Long.parseLong(s1);
            l = l1;
            if (l2 != 0L)
            {
                l = l2;
            }
        }
_L2:
        return StringUtils.getMD5Str(String.valueOf(l));
_L4:
        s = s1;
        if (s2.length() >= 20)
        {
            s = s1;
            if (checkSDcardnumber.equals(s2.substring(0, 20)))
            {
                s = s2.substring(20);
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static String getDeviceIdFromFile()
    {
        if ((new File(dirName)).exists()) goto _L2; else goto _L1
_L1:
        return "";
_L2:
        Object obj1;
        Object obj2;
        Object obj3;
        Exception exception1;
        Object obj4;
        byte abyte0[];
        if (!(new File(deviceIdPath)).exists())
        {
            return "";
        }
        obj2 = null;
        obj4 = null;
        obj1 = null;
        exception1 = null;
        obj3 = null;
        abyte0 = new byte[1024];
        Object obj = new FileInputStream(deviceIdPath);
        obj1 = new ByteArrayOutputStream();
_L5:
        int i = ((FileInputStream) (obj)).read(abyte0);
        if (i == -1) goto _L4; else goto _L3
_L3:
        ((ByteArrayOutputStream) (obj1)).write(abyte0, 0, i);
          goto _L5
        exception1;
        obj3 = obj1;
_L9:
        obj1 = obj3;
        obj2 = obj;
        exception1.printStackTrace();
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
            }
        }
        if (obj3 == null) goto _L1; else goto _L6
_L6:
        try
        {
            ((ByteArrayOutputStream) (obj3)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return "";
        }
        return "";
_L4:
        obj2 = new String(((ByteArrayOutputStream) (obj1)).toByteArray(), "utf-8");
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
            }
        }
        Exception exception;
        if (obj1 != null)
        {
            try
            {
                ((ByteArrayOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
                return ((String) (obj2));
            }
            return ((String) (obj2));
        } else
        {
            return ((String) (obj2));
        }
        obj;
_L8:
        if (obj2 != null)
        {
            try
            {
                ((FileInputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj2)
            {
                ((Exception) (obj2)).printStackTrace();
            }
        }
        if (obj1 != null)
        {
            try
            {
                ((ByteArrayOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                ((Exception) (obj1)).printStackTrace();
            }
        }
        throw obj;
        exception;
        obj1 = exception1;
        obj2 = obj;
        obj = exception;
        continue; /* Loop/switch isn't completed */
        exception;
        obj2 = obj;
        obj = exception;
        if (true) goto _L8; else goto _L7
_L7:
        exception1;
        obj = obj4;
          goto _L9
        exception1;
          goto _L9
    }

    private static String getExtraConfigFileName()
    {
        return (new StringBuilder()).append("/data/data/").append(SdkService.pkgName).append("/files/").append(SdkService.pkgName).append(".properties").toString();
    }

    public static String getLibsPath()
    {
        String s = null;
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            s = Environment.getExternalStorageDirectory().getAbsolutePath();
            s = (new StringBuilder()).append(s).append("/libs/").toString();
        }
        return s;
    }

    public static String getLocalMacAddress(Context context)
    {
        return ((WifiManager)context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
    }

    private static String getMD5Key()
    {
        String s;
        if (phoneInfo.getImei() == null)
        {
            s = "cantgetimei";
        } else
        {
            s = phoneInfo.getImei();
        }
        return StringUtils.getMD5Str(s);
    }

    private static String getRandomString(int i)
    {
        int j = i;
        if (i < 0)
        {
            j = 100;
        }
        i = j;
        if (j > 100)
        {
            i = 10;
        }
        Random random = new Random();
        char ac[] = new char[i];
        for (int k = 0; k < i; k++)
        {
            ac[k] = chars[random.nextInt(chars.length)];
        }

        return new String(ac);
    }

    private static String getSessionFromFile(String s)
    {
        Object obj;
        Exception exception1;
        obj = null;
        Object obj2 = null;
        Object obj1 = null;
        exception1 = null;
        byte abyte0[] = new byte[1024];
        int i;
        try
        {
            s = new FileInputStream((new StringBuilder()).append(getLibsPath()).append(s).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            obj = exception1;
            s = obj2;
            continue; /* Loop/switch isn't completed */
        }
        finally { }
        obj = new ByteArrayOutputStream();
_L3:
        i = s.read(abyte0);
        if (i == -1) goto _L2; else goto _L1
_L1:
        ((ByteArrayOutputStream) (obj)).write(abyte0, 0, i);
          goto _L3
        obj1;
_L7:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }
        if (obj != null)
        {
            try
            {
                ((ByteArrayOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }
        return null;
_L2:
        obj1 = new String(RC4Carder.Dencrypt(((ByteArrayOutputStream) (obj)).toByteArray(), getMD5Key()));
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }
        if (obj != null)
        {
            try
            {
                ((ByteArrayOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }
        return ((String) (obj1));
_L5:
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
            }
        }
        if (obj1 != null)
        {
            try
            {
                ((ByteArrayOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
            }
        }
        throw s;
        exception1;
        obj = s;
        s = exception1;
        continue; /* Loop/switch isn't completed */
        exception1;
        obj1 = obj;
        obj = s;
        s = exception1;
        if (true) goto _L5; else goto _L4
_L4:
        break MISSING_BLOCK_LABEL_44;
        Exception exception;
        exception;
        exception = exception1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private static String getStringFromDataStore(Context context, String s)
    {
        return context.getSharedPreferences("GETUI_DATA_STORE", 0).getString(s, null);
    }

    private static String getVcidFromFile()
    {
        Object obj = getLibsPath();
        if (obj != null) goto _L2; else goto _L1
_L1:
        return "";
_L2:
        Object obj1;
        Object obj2;
        Object obj3;
        Exception exception1;
        Object obj4;
        byte abyte0[];
        obj = (new StringBuilder()).append(((String) (obj))).append(SdkService.pkgName).append(".slave.db").toString();
        if (!(new File(((String) (obj)))).exists())
        {
            return "";
        }
        obj1 = null;
        exception1 = null;
        obj3 = null;
        obj2 = null;
        obj4 = null;
        abyte0 = new byte[1024];
        obj = new FileInputStream(((String) (obj)));
        obj1 = new ByteArrayOutputStream();
_L5:
        int i = ((FileInputStream) (obj)).read(abyte0);
        if (i == -1) goto _L4; else goto _L3
_L3:
        ((ByteArrayOutputStream) (obj1)).write(abyte0, 0, i);
          goto _L5
        exception1;
        obj3 = obj1;
_L9:
        obj1 = obj3;
        obj2 = obj;
        exception1.printStackTrace();
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
            }
        }
        if (obj3 == null) goto _L1; else goto _L6
_L6:
        try
        {
            ((ByteArrayOutputStream) (obj3)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return "";
        }
        return "";
_L4:
        obj2 = new String(RC4Carder.Dencrypt(((ByteArrayOutputStream) (obj1)).toByteArray(), getMD5Key()));
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
            }
        }
        Exception exception;
        if (obj1 != null)
        {
            try
            {
                ((ByteArrayOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
                return ((String) (obj2));
            }
            return ((String) (obj2));
        } else
        {
            return ((String) (obj2));
        }
        obj;
_L8:
        if (obj2 != null)
        {
            try
            {
                ((FileInputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj2)
            {
                ((Exception) (obj2)).printStackTrace();
            }
        }
        if (obj1 != null)
        {
            try
            {
                ((ByteArrayOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                ((Exception) (obj1)).printStackTrace();
            }
        }
        throw obj;
        exception;
        obj1 = exception1;
        obj2 = obj;
        obj = exception;
        continue; /* Loop/switch isn't completed */
        exception;
        obj2 = obj;
        obj = exception;
        if (true) goto _L8; else goto _L7
_L7:
        exception1;
        obj = obj4;
          goto _L9
        exception1;
          goto _L9
    }

    public static void init(Context context)
    {
        Object obj = (TelephonyManager)context.getSystemService("phone");
        phoneInfo = new PhoneInfo();
        phoneInfo.setModel(Build.MODEL);
        phoneInfo.setVersion("v1.0.0");
        phoneInfo.setSystem_version(android.os.Build.VERSION.RELEASE);
        phoneInfo.setImei(((TelephonyManager) (obj)).getDeviceId());
        phoneInfo.setType("ANDROID");
        phoneInfo.setDeviceid(getDeviceIdFromFile());
        phoneInfo.setChannelid("GW");
        phoneInfo.setUuid(generateUUID(context));
        obj = "00:00:00:00:00:00";
        if (getLocalMacAddress(context) != null)
        {
            obj = getLocalMacAddress(context);
        }
        checkSDcardnumber = (new StringBuilder()).append(SDcardVersion).append(((String) (obj))).toString();
        dbHelper = SdkService.getInstance().getDBHelper();
        read();
        internalBroadcastAccessToken = getRandomString(32);
        pushMessageMap = new HashMap();
    }

    public static void loadConfigFile(InputStream inputstream)
    {
        inputstream = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"));
_L2:
        String s = inputstream.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        if (s.startsWith("#")) goto _L2; else goto _L1
_L1:
        String as[] = s.split("=");
        if (as.length >= 2)
        {
            s = as[0].trim();
            String s1 = as[1].trim();
            if (!s.equals("sdk.phone_service_address"))
            {
                break MISSING_BLOCK_LABEL_130;
            }
            Consts.PS_URL = (new StringBuilder()).append(s1).append(Consts.PS_SUB_URL).toString();
            System.out.println((new StringBuilder()).append("final phone service address:").append(Consts.PS_URL).toString());
        }
          goto _L2
        try
        {
            if (!s.equals("sdk.debug"));
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return;
        }
          goto _L2
        inputstream.close();
        return;
    }

    public static void loadConfigFromFile()
    {
        if (!(new File(getExtraConfigFileName())).exists()) goto _L2; else goto _L1
_L1:
        Object obj1;
        Object obj2;
        obj1 = null;
        obj2 = null;
        Object obj = new FileInputStream(getExtraConfigFileName());
        loadConfigFile(((InputStream) (obj)));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        ((FileInputStream) (obj)).close();
_L4:
        return;
        obj;
        ((Exception) (obj)).printStackTrace();
        return;
        obj;
        obj = obj2;
_L7:
        if (obj == null) goto _L4; else goto _L3
_L3:
        try
        {
            ((FileInputStream) (obj)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
        }
        return;
        obj;
_L6:
        if (obj1 != null)
        {
            try
            {
                ((FileInputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                ((Exception) (obj1)).printStackTrace();
            }
        }
        throw obj;
_L2:
        AssetManager assetmanager;
        obj2 = (new StringBuilder()).append(SdkService.pkgName).append(".properties").toString();
        assetmanager = SdkService.getInstance().getResources().getAssets();
        obj1 = null;
        obj = null;
        obj2 = assetmanager.open(((String) (obj2)));
        obj = obj2;
        obj1 = obj2;
        loadConfigFile(((InputStream) (obj2)));
        if (obj2 != null)
        {
            try
            {
                ((InputStream) (obj2)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
            }
            return;
        }
          goto _L4
        obj1;
        if (obj == null) goto _L4; else goto _L5
_L5:
        try
        {
            ((InputStream) (obj)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
        }
        return;
        obj;
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                ((Exception) (obj1)).printStackTrace();
            }
        }
        throw obj;
        Exception exception1;
        exception1;
        obj1 = obj;
        obj = exception1;
          goto _L6
        Exception exception;
        exception;
          goto _L7
    }

    private static void putStringToDataStore(Context context, String s, String s1)
    {
        context = context.getSharedPreferences("GETUI_DATA_STORE", 0).edit();
        context.putString(s, s1);
        context.commit();
    }

    private static void read()
    {
        Cursor cursor = dbHelper.getReadableDatabase().rawQuery("select id, value from runtime order by id", null);
        if (cursor == null) goto _L2; else goto _L1
_L1:
        if (cursor.moveToNext())
        {
            int i = 0 + 1;
            int j = cursor.getInt(0);
            String s = null;
            byte abyte0[] = null;
            if (j == 1)
            {
                abyte0 = cursor.getBlob(i);
            } else
            {
                s = cursor.getString(i);
            }
            switch (j)
            {
            case 1: // '\001'
                vcid = new String(RC4Carder.Dencrypt(abyte0, getMD5Key()));
                break;

            case 2: // '\002'
                String s1 = s;
                if (s.equals("null"))
                {
                    s1 = null;
                }
                regId = s1;
                break;

            case 3: // '\003'
                String s2 = s;
                if (s.equals("null"))
                {
                    s2 = "0";
                }
                lastBindAppTime = Long.parseLong(s2);
                break;

            case 4: // '\004'
                String s3 = s;
                if (s.equals("null"))
                {
                    s3 = "0";
                }
                lastGetConfigTime = Long.parseLong(s3);
                break;

            case 5: // '\005'
                String s4 = s;
                if (s.equals("null"))
                {
                    s4 = null;
                }
                lastCidLists = s4;
                break;

            case 6: // '\006'
                String s5 = s;
                if (s.equals("null"))
                {
                    s5 = null;
                }
                lastPhoneInfo = s5;
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
        cursor.close();
_L2:
        if (regId == null)
        {
            regId = (new StringBuilder()).append("A-").append(phoneInfo.getUuid()).append("-").append(System.currentTimeMillis()).toString();
        }
        if (vcid.equals(""))
        {
            vcid = getVcidFromFile();
        }
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static void saveVcidToFile(String s)
    {
        Object obj = getLibsPath();
        if (obj == null)
        {
            return;
        }
        obj = new File((new StringBuilder()).append(((String) (obj))).append(SdkService.pkgName).append(".slave.db").toString());
        if (((File) (obj)).exists())
        {
            ((File) (obj)).delete();
        }
        try
        {
            ((File) (obj)).createNewFile();
            s = RC4Carder.Encrypt(s.getBytes(), getMD5Key());
            obj = new FileOutputStream(((File) (obj)));
            ((FileOutputStream) (obj)).write(s);
            ((FileOutputStream) (obj)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public static void updateDBValue(int i, String s, String s1)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("id", Integer.valueOf(i));
        contentvalues.put("name", s);
        contentvalues.put("value", s1);
        dbHelper.getWritableDatabase().replace("runtime", null, contentvalues);
    }

    public static void updateDBValue(int i, String s, byte abyte0[])
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("id", Integer.valueOf(i));
        contentvalues.put("name", s);
        contentvalues.put("value", abyte0);
        dbHelper.getWritableDatabase().replace("runtime", null, contentvalues);
    }

    public static void updateVcidValue(int i, String s, String s1)
    {
        String s2 = getMD5Key();
        updateDBValue(i, s, RC4Carder.Encrypt(s1.getBytes(), s2));
    }

    static 
    {
        dirName = "/sdcard/libs/";
        deviceIdPath = (new StringBuilder()).append(dirName).append("/com.igexin.sdk.deviceId.db").toString();
    }
}
