// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.messaging;

import com.amazon.gallery.foundation.utils.messaging.ContentFetcher;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;

// Referenced classes of package com.amazon.gallery.framework.gallery.messaging:
//            ContentConfigurationEvent

public class ConfigurationContentFetcher extends ContentFetcher
{

    public ConfigurationContentFetcher()
    {
    }

    public void onContentConfigurationEvent(ContentConfigurationEvent contentconfigurationevent)
    {
        event = contentconfigurationevent;
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
