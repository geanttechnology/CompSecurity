// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.instabeauty.application.InstaBeautyApplication;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class bgx
{

    public static String a = "http://wantu.mobi:8088/wantuServer/servlet/GetPictureFilterTable";
    public static String b = "http://wantu.mobi:8088/wantuServer/servlet/GetPictureFilter";
    public static String c = "http://fotorus.fotoable.com/fotorus/index.php?m=Material&a=GetStyleTable";
    public static String d = "http://fotorus.fotoable.com/fotorus/index.php?m=Material&a=GetStyleItem";
    public static String e = "http://fotorus.fotoable.com/fotorus/index.php?m=Material&a=GetLightTable";
    public static String f = "http://fotorus.fotoable.com/fotorus/index.php?m=Material&a=GetLightItem";
    public static String g = "http://fotorus.fotoable.com/fotorus/index.php?m=Material&a=GetPipTable";
    public static String h = "http://fotorus.fotoable.com/fotorus/index.php?m=Material&a=GetPipItem";
    public static String i = "http://fotorus.fotoable.com/fotorus/index.php?m=Material&a=GetFrameTable";
    public static String j = "http://fotorus.fotoable.com/fotorus/index.php?m=Material&a=GetFrameItem";
    public static String k = "http://fotorus.fotoable.com/fotorus/index.php?m=Material&a=GetMaterialType";
    public static String l = "http://fotorus.fotoable.com/fotorus/index.php?m=Material&a=GetTable";
    public static String m = "http://fotorus.fotoable.com/fotorus/index.php?m=Material&a=GetItem";
    public static String n = "http://fotorus.fotoable.com/fotorus/index.php?m=Material&a=GetMaterial2Update";
    public static String o = "http://fotorus.fotoable.com/fotorus/index.php?m=ZineMaterial&a=GetMaterialUpdate";
    public static String p = "http://fotorus.fotoable.com/fotorus/index.php?m=ZineMaterial&a=GetList";
    public static String q = "http://fotorus.fotoable.com/fotorus/index.php?m=ZineMaterial&a=getMaterialByID";
    public static String r = "http://fotorus.fotoable.com/fotorus/index.php?m=ZineMaterial&a=getRecommendationList";

    public static String a()
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        String s1;
        String s2;
        Object obj;
        String s3;
        Object obj1;
        try
        {
            s = String.format("%d", new Object[] {
                Integer.valueOf(android.os.Build.VERSION.SDK_INT)
            });
            s1 = InstaBeautyApplication.a().getApplicationContext().getPackageManager().getPackageInfo("com.fotoable.fotobeauty", 0).versionName;
            obj = Locale.getDefault();
            s2 = ((Locale) (obj)).getLanguage();
            obj = ((Locale) (obj)).getCountry();
            obj1 = (TelephonyManager)InstaBeautyApplication.a().getApplicationContext().getSystemService("phone");
            s3 = (new StringBuilder()).append("").append(((TelephonyManager) (obj1)).getDeviceId()).toString();
            obj1 = (new StringBuilder()).append("").append(((TelephonyManager) (obj1)).getSimSerialNumber()).toString();
            s3 = (new UUID((new StringBuilder()).append("").append(android.provider.Settings.Secure.getString(InstaBeautyApplication.a().getApplicationContext().getContentResolver(), "android_id")).toString().hashCode(), (long)s3.hashCode() << 32 | (long)((String) (obj1)).hashCode())).toString();
            obj1 = bpa.a(((WifiManager)InstaBeautyApplication.a().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress());
            stringbuilder.append((new StringBuilder()).append("os=").append("android").toString());
        }
        catch (Exception exception)
        {
            return "os=android&appid=instabeauty";
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        stringbuilder.append((new StringBuilder()).append("&osver=").append(s).toString());
        if ("instabeauty" == null)
        {
            break MISSING_BLOCK_LABEL_302;
        }
        stringbuilder.append((new StringBuilder()).append("&appid=").append("instabeauty").toString());
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_332;
        }
        stringbuilder.append((new StringBuilder()).append("&countrycode=").append(((String) (obj))).toString());
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_360;
        }
        stringbuilder.append((new StringBuilder()).append("&langcode=").append(s2).toString());
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_388;
        }
        stringbuilder.append((new StringBuilder()).append("&prelang=").append(s2).toString());
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_416;
        }
        stringbuilder.append((new StringBuilder()).append("&ver=").append(s1).toString());
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_446;
        }
        stringbuilder.append((new StringBuilder()).append("&uuid=").append(s3).toString());
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_484;
        }
        if (((String) (obj1)).length() > 0)
        {
            stringbuilder.append((new StringBuilder()).append("&openuuid=").append(((String) (obj1))).toString());
        }
        return stringbuilder.toString();
    }

    public static boolean a(String s, String s1)
    {
        boolean flag = false;
        String as[] = new String[20];
        as = new String[20];
        s = s.split("\\.");
        s1 = s1.split("\\.");
        int l1 = Math.max(s.length, s1.length);
        ArrayList arraylist = new ArrayList(Collections.nCopies(l1, Integer.valueOf(0)));
        ArrayList arraylist1 = new ArrayList(Collections.nCopies(l1, Integer.valueOf(0)));
        for (int i1 = 0; i1 < s.length; i1++)
        {
            arraylist.add(i1, Integer.valueOf(s[i1]));
        }

        for (int j1 = 0; j1 < s1.length; j1++)
        {
            arraylist1.add(j1, Integer.valueOf(s1[j1]));
        }

        for (int k1 = 0; k1 < l1;)
        {
            int i2 = ((Integer)arraylist1.get(k1)).intValue();
            int j2 = ((Integer)arraylist.get(k1)).intValue();
            if (i2 == j2)
            {
                k1++;
            } else
            {
                if (i2 > j2)
                {
                    flag = true;
                }
                return flag;
            }
        }

        return true;
    }

    public static String b()
    {
        String s = String.format("%d", new Object[] {
            Integer.valueOf(android.os.Build.VERSION.SDK_INT)
        });
        String s2 = if.d(InstaBeautyApplication.a);
        String s3 = yp.h(InstaBeautyApplication.a).trim();
        Object obj = Locale.getDefault();
        String s4 = ((Locale) (obj)).getLanguage();
        obj = ((Locale) (obj)).getCountry();
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("os", "android");
            jsonobject.put("osver", s);
            jsonobject.put("appid", s2);
            jsonobject.put("appver", s3);
            jsonobject.put("countrycode", obj);
            jsonobject.put("langcode", s4);
            jsonobject.put("prelang", "");
            jsonobject.put("devicename", "");
            jsonobject.put("devicetest", if.a(InstaBeautyApplication.a));
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return "";
        }
        if (jsonobject != null)
        {
            String s1;
            try
            {
                s1 = jsonobject.toString();
            }
            catch (Exception exception)
            {
                return "";
            }
            return s1;
        } else
        {
            return "";
        }
    }

    public static String b(String s, String s1)
    {
        if (a(s, s1))
        {
            return s1;
        } else
        {
            return s;
        }
    }

}
