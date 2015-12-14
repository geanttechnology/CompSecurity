// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;

import android.net.Uri;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.network.download:
//            CustomDownloadId, DownloadTransaction, DownloadType

public interface FileDownloadManager
{

    public abstract void addDownloadRequest(CustomDownloadId customdownloadid, String s, String s1, DownloadTransaction downloadtransaction);

    public abstract void addSingleItemDownloadRequest(CustomDownloadId customdownloadid, String s, String s1, String s2, Uri uri);

    public abstract void addWhisperCacheDownloadRequest(CustomDownloadId customdownloadid, String s, String s1, DownloadType downloadtype, DownloadTransaction downloadtransaction);

    public abstract void commitDownloadRequest(DownloadTransaction downloadtransaction);

    public abstract Set getIncompleteDownloads();

    public abstract boolean hasIncompleteDownloads();

    public abstract DownloadTransaction startWhisperCacheDownload(CustomDownloadId customdownloadid, String s, DownloadType downloadtype);
}
