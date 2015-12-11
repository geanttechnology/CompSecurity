// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.TreeMap;

// Referenced classes of package com.localytics.android:
//            BaseUploadThread, JsonHelper, Constants, BaseHandler, 
//            LocalyticsDao, MarketingMessage

final class MarketingDownloader extends BaseUploadThread
{

    private static final String MARKETING_URL_HTTP = "http://%s/api/v2/applications/%s/amp";
    private static final String MARKETING_URL_HTTPS = "https://%s/api/v2/applications/%s/amp";

    MarketingDownloader(BaseHandler basehandler, TreeMap treemap, String s, LocalyticsDao localyticsdao)
    {
        super(basehandler, treemap, s, localyticsdao);
    }

    static String downloadFile(String s, String s1, boolean flag, Proxy proxy)
    {
        File file = new File(s1);
        if (!file.exists() || flag) goto _L2; else goto _L1
_L1:
        Localytics.Log.w(String.format("The file %s does exist and overwrite is turned off.", new Object[] {
            file.getAbsolutePath()
        }));
_L5:
        return s1;
_L2:
        File file1 = file.getParentFile();
        if (!file1.mkdirs() && !file1.isDirectory())
        {
            Localytics.Log.w(String.format("Could not create the directory %s for saving file.", new Object[] {
                file1.getAbsolutePath()
            }));
            return null;
        }
        File file2;
        byte abyte0[];
        file2 = new File(String.format("%s_temp", new Object[] {
            s1
        }));
        file2.createNewFile();
        s = new BufferedInputStream(BaseUploadThread.createURLConnection(new URL(s), proxy).getInputStream(), 16384);
        proxy = new FileOutputStream(file2.getPath());
        abyte0 = new byte[8192];
_L3:
        int i = s.read(abyte0);
label0:
        {
            if (i == -1)
            {
                break label0;
            }
            try
            {
                proxy.write(abyte0, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Localytics.Log.w("In-app campaign not found. Creating a new one.");
                return null;
            }
        }
          goto _L3
        proxy.close();
        if (file2.renameTo(file)) goto _L5; else goto _L4
_L4:
        file2.delete();
        return null;
    }

    static String getLocalFileURL(long l, boolean flag, Context context, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(getMarketingDataDirectory(context, s));
        stringbuilder.append(File.separator);
        if (flag)
        {
            stringbuilder.append(String.format("amp_rule_%d.zip", new Object[] {
                Long.valueOf(l)
            }));
        } else
        {
            stringbuilder.append(String.format("marketing_rule_%d", new Object[] {
                Long.valueOf(l)
            }));
            context = new File(stringbuilder.toString());
            if ((!context.exists() || !context.isDirectory()) && !context.mkdirs())
            {
                Localytics.Log.w(String.format("Could not create the directory %s for saving the HTML file.", new Object[] {
                    context.getAbsolutePath()
                }));
                return null;
            }
            stringbuilder.append(File.separator);
            stringbuilder.append("index.html");
        }
        return stringbuilder.toString();
    }

    static String getMarketingDataDirectory(Context context, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(context.getFilesDir().getAbsolutePath());
        stringbuilder.append(File.separator);
        stringbuilder.append(".localytics");
        stringbuilder.append(File.separator);
        stringbuilder.append(s);
        return stringbuilder.toString();
    }

    static String getRemoteFileURL(MarketingMessage marketingmessage)
    {
        String s1 = JsonHelper.getSafeStringFromMap(marketingmessage, "phone_location");
        String s2 = JsonHelper.getSafeStringFromMap(marketingmessage, "devices");
        String s = s1;
        if (s2 != null)
        {
            if (s2.equals("tablet"))
            {
                s = JsonHelper.getSafeStringFromMap(marketingmessage, "tablet_location");
            } else
            {
                s = s1;
                if (s2.equals("both"))
                {
                    return JsonHelper.getSafeStringFromMap(marketingmessage, "phone_location");
                }
            }
        }
        return s;
    }

    final int uploadData()
    {
        String s1 = getApiKey();
        BaseUploadThread.UploadType uploadtype = BaseUploadThread.UploadType.MARKETING;
        String s;
        if (Constants.USE_HTTPS)
        {
            s = "https://%s/api/v2/applications/%s/amp";
        } else
        {
            s = "http://%s/api/v2/applications/%s/amp";
        }
        upload(uploadtype, String.format(s, new Object[] {
            Constants.MARKETING_HOST, s1
        }), "", 0);
        return 1;
    }
}
