// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.downloads;

import java.util.List;
import java.util.Map;

// Referenced classes of package com.comcast.cim.downloads:
//            DownloadServiceManager

class ateDownloadableFileMapTask extends ateDownloadableFileMapTask
{

    final DownloadServiceManager this$0;

    protected void onFileMapRetrieved()
    {
        DownloadServiceManager.access$702(DownloadServiceManager.this, true);
    }

    ateDownloadableFileMapTask(List list, Map map)
    {
        this$0 = DownloadServiceManager.this;
        super(DownloadServiceManager.this, list, map);
    }
}
