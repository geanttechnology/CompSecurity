// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.messaging;

import com.amazon.gallery.framework.network.download.CustomDownloadId;

public class DownloadFinishedEvent
{

    private final CustomDownloadId customDownloadId;
    private final boolean success;

    public DownloadFinishedEvent(CustomDownloadId customdownloadid, boolean flag)
    {
        customDownloadId = customdownloadid;
        success = flag;
    }

    public boolean isSuccessful()
    {
        return success;
    }
}
