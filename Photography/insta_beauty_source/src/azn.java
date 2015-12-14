// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import com.instabeauty.application.InstaBeautyApplication;
import java.util.Locale;

public class azn
{

    public static String a = "SaveInstaceString_rid";
    public static String b = "SaveInstaceString_version";
    public static String c = "SaveInstaceString_imageCount";
    public static String d = "SaveInstaceString_previewUrl";
    public static String e = "SaveInstaceString_otherAppId";
    public static String f = "SaveInstaceString_needReviewing";
    public static String g = "SaveInstaceString_zipUrl";

    public static String a()
    {
        String s = "cdn.api.fotoable.net";
        if (axw.d().equalsIgnoreCase("CN"))
        {
            s = "cdn.api.fotoable.com";
        }
        String s1;
        if (if.a(InstaBeautyApplication.a))
        {
            s = (new StringBuilder()).append("&fotouuid=").append(if.i(InstaBeautyApplication.a)).toString();
            s = (new StringBuilder()).append("http://%s/home/ZineMaterial/getMaterials/?os=android&appid=beautycam&ver=%s&countrycode=%s&langcode=%s&prelang=%s").append(s).toString();
            s1 = "api.fotoable.com";
        } else
        {
            s1 = s;
            s = "http://%s/home/ZineMaterial/getMaterials/?os=android&appid=beautycam&ver=%s&countrycode=%s&langcode=%s&prelang=%s";
        }
        return String.format(s, new Object[] {
            s1, if.e(InstaBeautyApplication.a().getApplicationContext()), if.b(), if.c(), if.d()
        });
    }

    public static boolean a(Context context)
    {
        boolean flag = true;
        if (InstaBeautyApplication.d())
        {
            flag = false;
        }
        new DisplayMetrics();
        context = InstaBeautyApplication.a().getApplicationContext().getResources().getDisplayMetrics();
        int i = ((DisplayMetrics) (context)).heightPixels;
        if (((DisplayMetrics) (context)).widthPixels + i < 1280)
        {
            return false;
        } else
        {
            return flag;
        }
    }

    public static String b()
    {
        String s = "cdn.api.fotoable.net";
        if (axw.d().equalsIgnoreCase("CN"))
        {
            s = "cdn.api.fotoable.com";
        }
        String s1;
        if (if.a(InstaBeautyApplication.a))
        {
            s = (new StringBuilder()).append("&fotouuid=").append(if.i(InstaBeautyApplication.a)).toString();
            s = (new StringBuilder()).append("http://%s/home/ZineMaterial/getMaterials/?recommendation=1&os=android&appid=beautycam&ver=%s&countrycode=%s&langcode=%s&prelang=%s").append(s).toString();
            s1 = "api.fotoable.com";
        } else
        {
            s1 = s;
            s = "http://%s/home/ZineMaterial/getMaterials/?recommendation=1&os=android&appid=beautycam&ver=%s&countrycode=%s&langcode=%s&prelang=%s";
        }
        return String.format(s, new Object[] {
            s1, if.e(InstaBeautyApplication.a), if.b(), if.c(), if.d()
        });
    }

    public static String c()
    {
        String s = "cdn.api.fotoable.net";
        if (axw.d().equalsIgnoreCase("CN"))
        {
            s = "cdn.api.fotoable.com";
        }
        s = String.format("http://%s/home/ZineMaterial/getLocalTags/?os=android&appid=beautycam&ver=%s&countrycode=%s&prelang=%s", new Object[] {
            s, if.e(InstaBeautyApplication.a().getApplicationContext()), if.b(), if.d()
        });
        Log.v("tag", (new StringBuilder()).append("tag ").append(s).toString());
        return s;
    }

    public static int d()
    {
        int i = ik.a();
        int j = ik.b();
        if (i == 1)
        {
            if (j < 300)
            {
                return 300;
            }
            return j >= 600 ? 640 : 640;
        }
        if (j < 900)
        {
            return 800;
        }
        return j >= 1200 ? 1280 : 960;
    }

    public static String e()
    {
        if (InstaBeautyApplication.a.getResources().getConfiguration().locale.getCountry().compareToIgnoreCase("cn") == 0)
        {
            return "http://cdn.dl.fotoable.com";
        } else
        {
            return "http://cdn.dl.fotoable.net";
        }
    }

    public static String f()
    {
        if (InstaBeautyApplication.a.getResources().getConfiguration().locale.getCountry().compareToIgnoreCase("cn") == 0)
        {
            return "cdn.api.fotoable.com";
        } else
        {
            return "cdn.api.fotoable.net";
        }
    }

    public static String g()
    {
        String s1 = f();
        String s = "http://%s/home/PasterMaterial/getMaterialList/?os=android&appid=wantu&ver=%s&countrycode=%s&langcode=%s&prelang=%s";
        if (if.a(InstaBeautyApplication.a))
        {
            s1 = "api.fotoable.com";
            s = (new StringBuilder()).append("&fotouuid=").append(if.i(InstaBeautyApplication.a)).toString();
            s = (new StringBuilder()).append("http://%s/home/PasterMaterial/getMaterialList/?os=android&appid=wantu&ver=%s&countrycode=%s&langcode=%s&prelang=%s").append(s).toString();
        }
        return String.format(s, new Object[] {
            s1, if.e(InstaBeautyApplication.a().getApplicationContext()), if.b(), if.c(), if.d()
        });
    }

}
