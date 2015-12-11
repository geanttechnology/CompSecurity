// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import atr;
import atu;
import atz;
import auj;
import com.google.android.gms.wearable.Asset;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;
import pp;
import qm;
import qq;

// Referenced classes of package com.adobe.mobile:
//            StaticMethods

class WearableDataResponse
{

    protected boolean success;

    WearableDataResponse()
    {
        success = false;
    }

    protected static WearableDataResponse createResponseFromDataMap(atz atz1, qm qm1)
    {
        if (atz1.a("Type"))
        {
            if (atz1.f("Type").equals("POST"))
            {
                return new PostResponse(atz1);
            }
            if (atz1.f("Type").equals("GET"))
            {
                return new GetResponse(atz1);
            }
            if (atz1.f("Type").equals("Config"))
            {
                return new ShareConfigResponse(atz1);
            }
            if (atz1.f("Type").equals("File"))
            {
                return new CacheResponse(atz1, qm1);
            }
            if (atz1.f("Type").equals("ThirdParty"))
            {
                return new ThirdPartyResponse(atz1);
            }
        }
        return null;
    }

    private static void saveFileFromAsset(Asset asset, String s, qm qm1)
    {
_L2:
        return;
        if (asset == null || qm1 == null || !qm1.a(15000L, TimeUnit.MILLISECONDS).b()) goto _L2; else goto _L1
_L1:
        InputStream inputstream;
        inputstream = ((atu)auj.a.a(qm1, asset).b()).c();
        qm1.c();
        if (inputstream == null) goto _L2; else goto _L3
_L3:
        s = new File(s);
        asset = null;
        s = new FileOutputStream(s);
        asset = s;
        qm1 = new byte[8192];
_L5:
        asset = s;
        int i = inputstream.read(qm1);
        if (i == -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        asset = s;
        s.write(qm1, 0, i);
        if (true) goto _L5; else goto _L4
_L4:
        asset;
_L12:
        asset = s;
        StaticMethods.logErrorFormat("Wearable - Failed to save cache file", new Object[0]);
        if (s == null) goto _L2; else goto _L6
_L6:
        try
        {
            s.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Asset asset)
        {
            StaticMethods.logDebugFormat("Wearable - Failed to close file output stream", new Object[0]);
        }
        return;
        if (s == null) goto _L2; else goto _L7
_L7:
        try
        {
            s.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Asset asset)
        {
            StaticMethods.logDebugFormat("Wearable - Failed to close file output stream", new Object[0]);
        }
        return;
        asset;
        s = null;
_L11:
        asset = s;
        StaticMethods.logErrorFormat("Wearable - Failed to save cache file", new Object[0]);
        if (s == null) goto _L2; else goto _L8
_L8:
        try
        {
            s.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Asset asset)
        {
            StaticMethods.logDebugFormat("Wearable - Failed to close file output stream", new Object[0]);
        }
        return;
        qm1;
        s = asset;
        asset = qm1;
_L10:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                StaticMethods.logDebugFormat("Wearable - Failed to close file output stream", new Object[0]);
            }
        }
        throw asset;
        qm1;
        s = asset;
        asset = qm1;
        if (true) goto _L10; else goto _L9
_L9:
        asset;
          goto _L11
        asset;
        s = null;
          goto _L12
    }

    protected boolean isSuccess()
    {
        return success;
    }


    private class PostResponse extends WearableDataResponse
    {

        protected PostResponse(atz atz1)
        {
            success = atz1.c("Result");
        }
    }


    private class GetResponse extends WearableDataResponse
    {

        protected byte result[];

        protected byte[] getResult()
        {
            return result;
        }

        protected GetResponse(atz atz1)
        {
            result = atz1.h("Result");
            if (result != null)
            {
                success = true;
            }
        }
    }


    private class ShareConfigResponse extends WearableDataResponse
    {

        final atz result;

        protected atz getResult()
        {
            return result;
        }

        protected ShareConfigResponse(atz atz1)
        {
            result = atz1;
        }
    }


    private class CacheResponse extends WearableDataResponse
    {

        final boolean result;

        protected boolean getResult()
        {
            return result;
        }

        protected CacheResponse(atz atz1, qm qm1)
        {
            if (!atz1.c("FileFound"))
            {
                RemoteDownload.deleteFilesInDirectory("adbdownloadcache");
                result = false;
            } else
            {
                result = atz1.c("Updated");
                if (result)
                {
                    RemoteDownload.deleteCachedDataForURL(atz1.f("URL"), "adbdownloadcache");
                    Asset asset = atz1.g("FileContent");
                    atz1 = atz1.f("FileName");
                    File file = RemoteDownload.getDownloadCacheDirectory("adbdownloadcache");
                    if (file != null)
                    {
                        WearableDataResponse.saveFileFromAsset(asset, (new StringBuilder()).append(file.getPath()).append(File.separator).append(atz1).toString(), qm1);
                        return;
                    }
                }
            }
        }
    }


    private class ThirdPartyResponse extends WearableDataResponse
    {

        protected ThirdPartyResponse(atz atz1)
        {
            success = atz1.c("Result");
        }
    }

}
