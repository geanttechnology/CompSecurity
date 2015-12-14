// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;

import java.io.File;

// Referenced classes of package com.amazon.gallery.framework.network.download:
//            SimpleDownloadManager, CustomDownloadId

private class resultFile
{

    CustomDownloadId customId;
    File resultFile;
    final SimpleDownloadManager this$0;

    public Y(CustomDownloadId customdownloadid, File file)
    {
        this$0 = SimpleDownloadManager.this;
        super();
        customId = customdownloadid;
        resultFile = file;
    }
}
