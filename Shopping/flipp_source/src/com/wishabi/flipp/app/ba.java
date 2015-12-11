// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.util.Base64;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.wishabi.flipp.app:
//            FlippApplication

final class ba extends AsyncTask
{

    final URL a;
    final FlippApplication b;

    ba(FlippApplication flippapplication, URL url)
    {
        b = flippapplication;
        a = url;
        super();
    }

    private transient Void a()
    {
        Object obj;
        HttpURLConnection httpurlconnection;
        String s;
        try
        {
            httpurlconnection = (HttpURLConnection)a.openConnection();
            httpurlconnection.setDoInput(true);
            httpurlconnection.setUseCaches(false);
            httpurlconnection.setRequestMethod("PUT");
            httpurlconnection.setRequestProperty("Platform", "Android");
            obj = b.getPackageManager();
            s = b.getPackageName();
        }
        catch (IOException ioexception)
        {
            return null;
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = ((PackageManager) (obj)).getPackageInfo(s, 0).versionName;
_L4:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        httpurlconnection.setRequestProperty("App-Version", ((String) (obj)));
        if (!"".isEmpty())
        {
            httpurlconnection.addRequestProperty("Authorization", (new StringBuilder("Basic ")).append(Base64.encodeToString("".getBytes(), 2)).toString());
        }
        httpurlconnection.getResponseCode();
        return null;
        obj;
_L2:
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }
}
