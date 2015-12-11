// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.countryanddivision;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;

// Referenced classes of package com.groupon.service.countryanddivision:
//            CountriesService

private class put extends HashMap
{

    final CountriesService this$0;

    public (Context context)
    {
        this$0 = CountriesService.this;
        super();
        put((new StringBuilder()).append(CountriesService.access$200(CountriesService.this).getString("base_url_eu", context.getString(0x7f0804c1))).append("/countries").toString(), com.groupon.rvice);
        put((new StringBuilder()).append(CountriesService.access$200(CountriesService.this).getString("base_url_as", context.getString(0x7f0804bd)).replace("http", "https")).append("/countries").toString(), com.groupon.rvice);
        put((new StringBuilder()).append(CountriesService.access$200(CountriesService.this).getString("base_url_cl", context.getString(0x7f0804bf)).replace("http", "https")).append("/countries").toString(), com.groupon.rvice);
        put((new StringBuilder()).append(CountriesService.access$200(CountriesService.this).getString("base_url_in", context.getString(0x7f0804c3)).replace("http", "https")).append("/countries").toString(), com.groupon.rvice);
        put((new StringBuilder()).append(CountriesService.access$200(CountriesService.this).getString("base_url_jp", context.getString(0x7f0804c4)).replace("http", "https")).append("/countries").toString(), com.groupon.rvice);
        put((new StringBuilder()).append(CountriesService.access$200(CountriesService.this).getString("base_url_ru", context.getString(0x7f0804c7)).replace("http", "https")).append("/countries").toString(), com.groupon.rvice);
    }
}
