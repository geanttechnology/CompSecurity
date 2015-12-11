// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import atz;
import java.io.File;
import qm;

// Referenced classes of package com.adobe.mobile:
//            WearableDataResponse, RemoteDownload

class ctory extends WearableDataResponse
{

    final boolean result;

    protected boolean getResult()
    {
        return result;
    }

    protected _cls9(atz atz1, qm qm)
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
                com.google.android.gms.wearable.Asset asset = atz1.g("FileContent");
                atz1 = atz1.f("FileName");
                File file = RemoteDownload.getDownloadCacheDirectory("adbdownloadcache");
                if (file != null)
                {
                    WearableDataResponse.access$000(asset, (new StringBuilder()).append(file.getPath()).append(File.separator).append(atz1).toString(), qm);
                    return;
                }
            }
        }
    }
}
