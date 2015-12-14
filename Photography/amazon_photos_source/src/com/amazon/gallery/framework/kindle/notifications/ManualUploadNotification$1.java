// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.notifications;


// Referenced classes of package com.amazon.gallery.framework.kindle.notifications:
//            ManualUploadNotification, NotificationState

static class 
{

    static final int $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[];

    static 
    {
        $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState = new int[NotificationState.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.ACTIVE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.PAUSED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.NO_SPACE_ALL.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.NO_SPACE_PHOTOS.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.UNKNOWN_PROBLEM.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.COMPLETE.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.CANCELED.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.NO_NETWORK.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.WAITING_FOR_WIFI.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.WAITING_FOR_POWER.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.LOW_BATTERY.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
