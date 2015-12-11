// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.downloads;

import com.penthera.virtuososdk.client.IEngineObserver;
import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.cim.downloads:
//            DownloadServiceManager

class this._cls0
    implements IEngineObserver
{

    final DownloadServiceManager this$0;

    public void downloadEngineStatusDidChange(IVirtuosoDownloadEngineStatus ivirtuosodownloadenginestatus)
    {
        DownloadServiceManager.access$000().debug((new StringBuilder()).append("Callback downloadEngineStatusDidChange: ").append(ivirtuosodownloadenginestatus.status().name()).toString());
        onDownloadEngineStatusChanged(ivirtuosodownloadenginestatus);
    }

    public void settingChanged(int i)
    {
    }

    gineStatus()
    {
        this$0 = DownloadServiceManager.this;
        super();
    }
}
