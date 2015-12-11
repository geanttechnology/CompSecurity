// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

public final class bzl
{

    public final bzm a;
    public final int b;

    public bzl(bzm bzm1, int i, cpx cpx, String s)
    {
label0:
        {
            boolean flag1 = false;
            super();
            b.a(true, "gdataHostnameProvider must be provided");
            boolean flag;
            if (i > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            b.a(flag, "resultsPerPage must be > 0");
            if (!TextUtils.isEmpty(s))
            {
                flag = flag1;
                if (s.length() != 2)
                {
                    break label0;
                }
            }
            flag = true;
        }
        cpx = String.valueOf("countryCodeRestrict must be empty or a two letter country code (given: ");
        b.a(flag, (new StringBuilder(String.valueOf(cpx).length() + 1 + String.valueOf(s).length())).append(cpx).append(s).append(")").toString());
        a = bzm1;
        b = i;
        if (!TextUtils.isEmpty(s))
        {
            s.toUpperCase(Locale.US);
        }
    }

    public static bzi a(Uri uri)
    {
        b.a(uri);
        Uri uri1 = uri;
        if (!"true".equals(uri.getQueryParameter("inline")))
        {
            uri1 = uri.buildUpon().appendQueryParameter("inline", "true").build();
        }
        return bzi.a(uri1);
    }

    public static void a(android.net.Uri.Builder builder, int i, int j)
    {
        builder.appendQueryParameter("start-index", Integer.toString(1));
        builder.appendQueryParameter("max-results", Integer.toString(j));
    }

    public final bzi a(String s)
    {
        b.a(s);
        return bzi.a(a.b().buildUpon().path("feeds/api/videos").build().buildUpon().appendPath(s).build());
    }

    static 
    {
        new HashSet(Arrays.asList(new String[] {
            "zh-TW", "cs-CZ", "nl-NL", "en-GB", "en-US", "fr-FR", "de-DE", "it-IT", "ja-JP", "ko-KR", 
            "pl-PL", "pt-BR", "ru-RU", "es-ES", "es-MX", "sv-SE"
        }));
        new HashSet(Arrays.asList(new String[] {
            "AR", "AU", "BE", "BR", "CA", "CL", "CO", "CZ", "EG", "FR", 
            "DE", "GB", "HK", "HU", "IN", "IE", "IL", "IT", "JP", "JO", 
            "MY", "MX", "MA", "NL", "NZ", "PE", "PH", "PL", "RU", "SA", 
            "SG", "ZA", "KR", "ES", "SE", "TW", "AE", "US"
        }));
    }
}
