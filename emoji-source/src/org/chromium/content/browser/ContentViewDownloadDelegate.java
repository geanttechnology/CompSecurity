// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.content.browser;


// Referenced classes of package org.chromium.content.browser:
//            DownloadInfo

public interface ContentViewDownloadDelegate
{

    public abstract void onDangerousDownload(String s, int i);

    public abstract void onDownloadStarted(String s, String s1);

    public abstract void requestHttpGetDownload(DownloadInfo downloadinfo);
}
