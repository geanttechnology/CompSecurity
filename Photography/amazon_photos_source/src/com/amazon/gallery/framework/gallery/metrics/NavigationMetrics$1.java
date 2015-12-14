// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.metrics;

import com.amazon.gallery.framework.model.media.MediaType;

// Referenced classes of package com.amazon.gallery.framework.gallery.metrics:
//            NavigationMetrics

static class onType
{

    static final int $SwitchMap$com$amazon$gallery$framework$gallery$metrics$NavigationMetrics$TimerType[];
    static final int $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[];
    static final int $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[];

    static 
    {
        $SwitchMap$com$amazon$gallery$framework$gallery$metrics$NavigationMetrics$TimerType = new int[merType.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$metrics$NavigationMetrics$TimerType[merType.SINGLE_VIEW_TIMER.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$metrics$NavigationMetrics$TimerType[merType.COLLECTION_TIMER.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        $SwitchMap$com$amazon$gallery$framework$model$media$MediaType = new int[MediaType.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.PHOTO.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.VIDEO.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType = new int[com.amazon.gallery.framework.gallery.view.ctionType.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ctionType.EVERYTHING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ctionType.MEDIA_PROPERTY.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ctionType.MEDIA_TYPE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ctionType.TAG.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ctionType.DYNAMIC_ALBUM.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ctionType.CUSTOM_DATA_SET.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
