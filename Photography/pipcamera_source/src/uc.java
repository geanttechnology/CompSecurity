// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.pipcamera.application.PIPCameraApplication;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class uc
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
    public static String o = "http://fotorus.fotoable.com/fotorus/index.php?m=ZineMaterial&a=getUpdateList";
    public static String p = "http://fotorus.fotoable.com/fotorus/index.php?m=ZineMaterial&a=getMaterials";
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
        try
        {
            s = String.format("%d", new Object[] {
                Integer.valueOf(android.os.Build.VERSION.SDK_INT)
            });
            s1 = PIPCameraApplication.a.getPackageManager().getPackageInfo("com.pipcamera.activity", 0).versionName;
            obj = Locale.getDefault();
            s2 = ((Locale) (obj)).getLanguage();
            obj = ((Locale) (obj)).getCountry();
            stringbuilder.append((new StringBuilder()).append("os=").append("android").toString());
            s3 = yn.a(((WifiManager)PIPCameraApplication.b().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress());
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            return "os=android&appid=pipcam";
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        stringbuilder.append((new StringBuilder()).append("&osver=").append(s).toString());
        if ("pipcam" == null)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        stringbuilder.append((new StringBuilder()).append("&appid=").append("pipcam").toString());
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        stringbuilder.append((new StringBuilder()).append("&countrycode=").append(((String) (obj))).toString());
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        stringbuilder.append((new StringBuilder()).append("&langcode=").append(s2).toString());
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_255;
        }
        stringbuilder.append((new StringBuilder()).append("&prelang=").append(s2).toString());
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        stringbuilder.append((new StringBuilder()).append("&ver=").append(s1).toString());
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_321;
        }
        if (s3.length() > 0)
        {
            stringbuilder.append((new StringBuilder()).append("&openuuid=").append(s3).toString());
        }
        return stringbuilder.toString();
    }

    public static String a(String s, String s1)
    {
        if (b(s, s1))
        {
            return s1;
        } else
        {
            return s;
        }
    }

    public static boolean a(Context context)
    {
        NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo == null || !networkinfo.isConnectedOrConnecting())
        {
            Toast.makeText(context, context.getResources().getString(0x7f060041), 1).show();
            return false;
        } else
        {
            return true;
        }
    }

    public static String b()
    {
        String s = String.format("%d", new Object[] {
            Integer.valueOf(android.os.Build.VERSION.SDK_INT)
        });
        String s2 = et.c(PIPCameraApplication.a);
        String s3 = ew.i(PIPCameraApplication.a).trim();
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
            jsonobject.put("devicetest", et.a(PIPCameraApplication.a));
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

    public static boolean b(String s, String s1)
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

}
