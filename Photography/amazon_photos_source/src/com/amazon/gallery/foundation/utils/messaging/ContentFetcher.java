// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.messaging;

import com.amazon.gallery.foundation.utils.log.GLogger;

public abstract class ContentFetcher
{

    private static final String TAG = com/amazon/gallery/foundation/utils/messaging/ContentFetcher.getName();
    protected Object event;

    public ContentFetcher()
    {
    }

    public Object getContentFromProducer()
    {
        register();
        if (event != null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        GLogger.d(TAG, "Tried to get content when no producer is present", new Object[0]);
        unregister();
        return null;
        Object obj = event;
        unregister();
        return obj;
        Exception exception;
        exception;
        unregister();
        throw exception;
    }

    protected abstract void register();

    protected abstract void unregister();

}
