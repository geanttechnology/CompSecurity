// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.asyncnet;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.parsers.IStreamParser;
import com.socialin.android.apiv3.util.Utils;
import com.socialin.android.util.s;
import java.util.Locale;

// Referenced classes of package com.socialin.asyncnet:
//            Request

public final class a extends Request
{

    private static String l = "";
    private static String m = "";
    private static String n = "us";
    private static String o = "en";
    private static String p = "";
    private static String q = "";

    public a(String s1, IStreamParser istreamparser, String s2)
    {
        this(s1, istreamparser, s2, 5);
    }

    public a(String s1, IStreamParser istreamparser, String s2, int i)
    {
        super(s1, istreamparser, s2, i);
        c("User-Agent", "Picsart/3.0");
        d("Accept", "application/picsart-3.0+json");
        c("versionCode", l);
        c("Host", "api.picsart.com");
        c("platform", "android");
        c("deviceid", m);
        c("Country-Code", n);
        c("Language-Code", o);
        c("network", s.a());
        c("app", p);
        SocialinV3.getInstance();
        c("market", SocialinV3.market);
        c("os-version", q);
    }

    static 
    {
        try
        {
            m = SocialinV3.getInstance().getDeviceId();
            l = String.valueOf(SocialinV3.getInstance().getContext().getPackageManager().getPackageInfo(SocialinV3.getInstance().getContext().getPackageName(), 128).versionCode);
            n = Utils.getCountryCode(SocialinV3.getInstance().getContext());
            o = String.valueOf(SocialinV3.getInstance().getContext().getResources().getConfiguration().locale.getLanguage());
            p = SocialinV3.getInstance().getContext().getPackageName();
            q = android.os.Build.VERSION.RELEASE;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
        }
    }
}
