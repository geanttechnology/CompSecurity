// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.download;

import java.util.TimerTask;

// Referenced classes of package com.penthera.virtuososdk.download:
//            DownloadEngineClientManager

class client extends TimerTask
{

    final String client;
    final DownloadEngineClientManager this$0;

    public void run()
    {
        DownloadEngineClientManager.access$6(DownloadEngineClientManager.this, client);
    }

    (String s)
    {
        this$0 = DownloadEngineClientManager.this;
        super();
        client = s;
    }
}
