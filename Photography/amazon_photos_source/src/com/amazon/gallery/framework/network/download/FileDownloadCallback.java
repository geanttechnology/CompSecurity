// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;

import java.io.File;

// Referenced classes of package com.amazon.gallery.framework.network.download:
//            CustomDownloadId

public interface FileDownloadCallback
{

    public abstract void onDownloadCompleted(CustomDownloadId customdownloadid, File file);

    public abstract void onDownloadFail(CustomDownloadId customdownloadid, String s);
}
