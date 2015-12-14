// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.pipcamera.application.PIPCameraApplication;
import java.util.Locale;

public class tc
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
        if (PIPCameraApplication.a.getResources().getConfiguration().locale.getCountry().compareToIgnoreCase("cn") == 0)
        {
            return "cdn.api.fotoable.com";
        } else
        {
            return "cdn.api.fotoable.net";
        }
    }

    public static String b()
    {
        String s1 = a();
        String s = "http://%s/home/PasterMaterial/getMaterialList/?os=android&appid=%s&ver=%s&countrycode=%s&langcode=%s&prelang=%s";
        if (et.a(PIPCameraApplication.a))
        {
            s1 = "api.fotoable.com";
            s = (new StringBuilder()).append("&fotouuid=").append(et.h(PIPCameraApplication.a)).toString();
            s = (new StringBuilder()).append("http://%s/home/PasterMaterial/getMaterialList/?os=android&appid=%s&ver=%s&countrycode=%s&langcode=%s&prelang=%s").append(s).toString();
        }
        return String.format(s, new Object[] {
            s1, "pipcam", et.d(PIPCameraApplication.b().getApplicationContext()), et.b(), et.c(), et.d()
        });
    }

}
