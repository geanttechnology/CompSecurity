// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.download;

import android.os.Handler;
import android.os.Message;
import com.penthera.virtuososdk.database.impl.provider.SettingsInstance;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.penthera.virtuososdk.download:
//            DownloadEngineClientManager, Downloader

class  extends Handler
{

    private void handleCheckStorage(Message message)
    {
        message = (Downloader)message.obj;
        ientStorageInfo ientstorageinfo = (ientStorageInfo)DownloadEngineClientManager.access$1().get(((Downloader) (message)).iClientAuthority);
        SettingsInstance settingsinstance = (SettingsInstance)DownloadEngineClientManager.access$2().get(((Downloader) (message)).iClientAuthority);
        if (ientstorageinfo == null)
        {
            return;
        }
        ientstorageinfo.update(settingsinstance);
        if (ientstorageinfo.iAvailable > 0.0D)
        {
            message.RetryOnStorageChange();
            return;
        } else
        {
            DownloadEngineClientManager.requestDiskCheck(message);
            return;
        }
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            com.penthera.virtuososdk.utility.(DownloadEngineClientManager.access$0(), (new StringBuilder("c[] Wrong message ")).append(message.what).toString());
            return;

        case 1: // '\001'
            handleCheckStorage(message);
            break;
        }
    }

    ()
    {
    }
}
