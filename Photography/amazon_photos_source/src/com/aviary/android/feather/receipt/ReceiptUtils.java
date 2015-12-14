// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.receipt;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.HandlerThread;
import android.util.Log;
import com.aviary.android.feather.common.utils.PackageManagerUtils;
import it.sephiroth.android.library.ab.AB;
import java.io.IOException;
import java.util.Locale;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

final class ReceiptUtils
{

    private static final String LOG_TAG = "ReceiptsUtils";
    private static Locale sLocale;

    private ReceiptUtils()
    {
    }

    static int clamp(int i, int j, int k)
    {
        return Math.min(k, Math.max(i, j));
    }

    public static int getBinaryVersion(Context context)
    {
        context = PackageManagerUtils.getPackageInfo(context);
        if (context != null)
        {
            return ((PackageInfo) (context)).versionCode;
        } else
        {
            return 0;
        }
    }

    public static String getCountry()
    {
        return getLocale().getCountry();
    }

    static HandlerThread getHandlerThread(String s)
    {
        s = new HandlerThread(s, 19);
        s.start();
        return s;
    }

    public static String getLanguage()
    {
        return getLocale().getLanguage();
    }

    private static Locale getLocale()
    {
        if (sLocale == null)
        {
            sLocale = Locale.getDefault();
        }
        return sLocale;
    }

    public static String getUserUUID(Context context)
    {
        return AB.getInstance(context).getUUID();
    }

    public static int upload(String s, String s1)
        throws IOException
    {
        Log.i("ReceiptsUtils", String.format("upload: %s", new Object[] {
            s
        }));
        Log.i("ReceiptsUtils", String.format("data=%s", new Object[] {
            s1
        }));
        Object obj = new DefaultHttpClient();
        s = new HttpPost(s);
        s1 = new StringEntity(s1);
        s.setHeader("Accept", "application/json");
        s.setHeader("Content-Type", "application/json");
        s.setEntity(s1);
        int i;
        try
        {
            s1 = ((HttpClient) (obj)).execute(s);
            i = s1.getStatusLine().getStatusCode();
            obj = s1.getStatusLine().getReasonPhrase();
            Log.d("ReceiptsUtils", (new StringBuilder()).append("code: ").append(i).toString());
            Log.d("ReceiptsUtils", (new StringBuilder()).append("reason: ").append(((String) (obj))).toString());
            Log.d("ReceiptsUtils", (new StringBuilder()).append("response: ").append(EntityUtils.toString(s1.getEntity())).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            s.abort();
            throw s1;
        }
        return i;
    }
}
