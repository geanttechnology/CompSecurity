// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.timeline;


// Referenced classes of package com.amazon.gallery.framework.kindle.timeline:
//            TimelineNavigatorListImpl

static class ent
{

    static final int $SwitchMap$com$amazon$gallery$framework$gallery$timeline$TimelineNavigator$TimelineEvent[];
    static final int $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[];

    static 
    {
        $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType = new int[com.amazon.gallery.framework.gallery.view..values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view..EVERYTHING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view..MEDIA_PROPERTY.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view..MEDIA_TYPE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view..TAG.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view..CUSTOM_DATA_SET.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        $SwitchMap$com$amazon$gallery$framework$gallery$timeline$TimelineNavigator$TimelineEvent = new int[com.amazon.gallery.framework.gallery.timeline.nt.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$timeline$TimelineNavigator$TimelineEvent[com.amazon.gallery.framework.gallery.timeline.nt.AUTO_OPEN.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$timeline$TimelineNavigator$TimelineEvent[com.amazon.gallery.framework.gallery.timeline.nt.SWIPE_OPEN.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$timeline$TimelineNavigator$TimelineEvent[com.amazon.gallery.framework.gallery.timeline.nt.TAP_OPEN.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$timeline$TimelineNavigator$TimelineEvent[com.amazon.gallery.framework.gallery.timeline.nt.SWIPE_CLOSE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$timeline$TimelineNavigator$TimelineEvent[com.amazon.gallery.framework.gallery.timeline.nt.TAP_CLOSE.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$timeline$TimelineNavigator$TimelineEvent[com.amazon.gallery.framework.gallery.timeline.nt.AUTO_CLOSE.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
