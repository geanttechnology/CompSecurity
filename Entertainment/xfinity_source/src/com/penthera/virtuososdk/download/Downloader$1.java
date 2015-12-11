// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.download;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.penthera.virtuososdk.download:
//            Downloader

class topReason extends Handler
{

    private void handleCheckPermissions(Message message)
    {
        message = (Downloader)message.obj;
        if (((Downloader) (message)).iDownloadInfo.iDownloading && !((Downloader) (message)).iDownloadStop.isSet())
        {
            boolean flag = false;
            ownloadPermission ownloadpermission = message.getDownloadPermission();
            if (ownloadpermission != ownloadPermission.EDownloadAllowed)
            {
                com.penthera.virtuososdk.utility.g.i(Downloader.access$0(), (new StringBuilder("Downloads not permitted: ")).append(ownloadpermission).toString());
                ((Downloader) (message)).iDownloadStop.iPermission = ownloadpermission;
                ((Downloader) (message)).iDownloadStop.iReason = topReason.EBlocked;
                ((Downloader) (message)).iDownloadStop.stop(true);
                flag = true;
            }
            if (((Downloader) (message)).iDownloadInfo.iDownloading && !flag)
            {
                message.requestPermissionChecks(message);
                return;
            }
        }
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            com.penthera.virtuososdk.utility.g.e(Downloader.access$0(), (new StringBuilder("c[] Wrong message ")).append(message.what).toString());
            return;

        case 1: // '\001'
            handleCheckPermissions(message);
            break;
        }
    }

    topReason()
    {
    }
}
