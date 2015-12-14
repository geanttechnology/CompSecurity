// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.network.download:
//            SimpleDownloadManager

private class this._cls0
{

    private final List downloadedFilePaths = new ArrayList(5);
    final SimpleDownloadManager this$0;

    private void issueScanRequest()
    {
        if (!downloadedFilePaths.isEmpty())
        {
            String as[] = (String[])downloadedFilePaths.toArray(new String[downloadedFilePaths.size()]);
            startMediaScan(as);
        }
    }

    public void enqueue(String s)
    {
        downloadedFilePaths.add(s);
        if (downloadedFilePaths.size() == 5)
        {
            flush();
        }
    }

    public void flush()
    {
        issueScanRequest();
        downloadedFilePaths.clear();
    }

    public ()
    {
        this$0 = SimpleDownloadManager.this;
        super();
    }
}
