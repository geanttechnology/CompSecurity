// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.pipcamera.application.PIPCameraApplication;

public class kb
{

    public static String a()
    {
        String s = "cdn.api.fotoable.net";
        if (et.b().equalsIgnoreCase("CN"))
        {
            s = "cdn.api.fotoable.com";
        }
        String s1;
        if (et.a(PIPCameraApplication.a))
        {
            s = (new StringBuilder()).append("&fotouuid=").append(et.h(PIPCameraApplication.a)).toString();
            s = (new StringBuilder()).append("http://%s/home/PipMaterial/getMaterialList/?os=android&appid=pipcam&ver=%s&countrycode=%s&langcode=%s&prelang=%s").append(s).toString();
            s1 = "api.fotoable.com";
        } else
        {
            s1 = s;
            s = "http://%s/home/PipMaterial/getMaterialList/?os=android&appid=pipcam&ver=%s&countrycode=%s&langcode=%s&prelang=%s";
        }
        return String.format(s, new Object[] {
            s1, et.d(PIPCameraApplication.b().getApplicationContext()), et.b(), et.c(), et.d()
        });
    }
}
