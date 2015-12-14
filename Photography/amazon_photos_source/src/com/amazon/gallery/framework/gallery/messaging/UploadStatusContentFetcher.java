// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.messaging;

import com.amazon.gallery.foundation.utils.messaging.ContentFetcher;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadStatusEvent;

public class UploadStatusContentFetcher extends ContentFetcher
{

    public UploadStatusContentFetcher()
    {
    }

    public void onUploadStatusEvent(UploadStatusEvent uploadstatusevent)
    {
        event = uploadstatusevent;
    }

    protected void register()
    {
        GlobalMessagingBus.register(this);
    }

    protected void unregister()
    {
        GlobalMessagingBus.unregister(this);
    }
}
