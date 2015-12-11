// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.mediation;

import android.os.AsyncTask;
import android.webkit.URLUtil;
import com.sponsorpay.utils.GetRemoteFileContentTask;
import com.sponsorpay.utils.SponsorPayLogger;
import com.sponsorpay.utils.StringUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class SPMediationConfigurationFiles
{

    private static final String TAG = "SPMediationConfigurationFiles";
    private static SPMediationConfigurationFiles instance = new SPMediationConfigurationFiles();
    private String adaptersConfig;
    private String adaptersConfigLocation;
    private String adaptersInfo;
    private String adaptersInfoLocation;

    private SPMediationConfigurationFiles()
    {
        adaptersConfigLocation = "/adapters.config";
        adaptersInfoLocation = "/adapters.info";
        adaptersConfig = null;
        adaptersInfo = null;
    }

    public static String getAdapterInfo()
    {
        if (StringUtils.notNullNorEmpty(instance.adaptersInfo))
        {
            return instance.adaptersInfo;
        } else
        {
            return instance.getContent(instance.adaptersInfoLocation);
        }
    }

    public static String getAdaptersConfig()
    {
        if (StringUtils.notNullNorEmpty(instance.adaptersConfig))
        {
            return instance.adaptersConfig;
        } else
        {
            return instance.getContent(instance.adaptersConfigLocation);
        }
    }

    private String getContent(String s)
    {
        if (!URLUtil.isNetworkUrl(s)) goto _L2; else goto _L1
_L1:
        s = (String)(new GetRemoteFileContentTask()).execute(new String[] {
            s
        }).get();
        return s;
        s;
        SponsorPayLogger.e("SPMediationConfigurationFiles", "Error occurred", s);
_L4:
        return "";
        s;
        SponsorPayLogger.e("SPMediationConfigurationFiles", "Error occurred", s);
        continue; /* Loop/switch isn't completed */
_L2:
        s = readFile(s);
        return s;
        s;
        SponsorPayLogger.e("SPMediationConfigurationFiles", "Error occurred", s);
        continue; /* Loop/switch isn't completed */
        s;
        SponsorPayLogger.e("SPMediationConfigurationFiles", "Error occurred", s);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private String readFile(String s)
    {
        StringBuilder stringbuilder = null;
        java.io.InputStream inputstream = getClass().getResourceAsStream(s);
        Object obj = inputstream;
        if (inputstream == null)
        {
            try
            {
                obj = URI.create(s).toURL().openStream();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                obj = inputstream;
            }
        }
        s = stringbuilder;
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = new BufferedReader(new InputStreamReader(((java.io.InputStream) (obj))));
        stringbuilder = new StringBuilder();
        s = ((BufferedReader) (obj)).readLine();
_L6:
        if (s != null) goto _L4; else goto _L3
_L3:
        s = stringbuilder.toString();
        ((BufferedReader) (obj)).close();
_L2:
        return s;
_L4:
        stringbuilder.append((new StringBuilder(String.valueOf(s))).append('\n').toString());
        s = ((BufferedReader) (obj)).readLine();
        if (true) goto _L6; else goto _L5
_L5:
        s;
        ((BufferedReader) (obj)).close();
        throw s;
    }

    public static void setAdaptersConfig(String s)
    {
        instance.adaptersConfig = s;
    }

    public static void setAdaptersConfigLocation(String s)
    {
        if (StringUtils.notNullNorEmpty(s))
        {
            instance.adaptersConfigLocation = s;
        }
    }

    public static void setAdaptersInfo(String s)
    {
        instance.adaptersInfo = s;
    }

    public static void setAdaptersInfoLocation(String s)
    {
        if (StringUtils.notNullNorEmpty(s))
        {
            instance.adaptersInfoLocation = s;
        }
    }

}
