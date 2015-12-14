// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.notifications;

import com.amazon.gallery.framework.network.multiqueueuploader.UploadControlAction;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadError;

// Referenced classes of package com.amazon.gallery.framework.kindle.notifications:
//            UploadNotification, NotificationState

static class tion
{

    static final int $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[];
    static final int $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[];
    static final int $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[];

    static 
    {
        $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction = new int[UploadControlAction.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[UploadControlAction.RESUME.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror18) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[UploadControlAction.PAUSE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror17) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[UploadControlAction.CANCEL.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror16) { }
        $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError = new int[UploadError.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.NO_SPACE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.NO_NETWORK.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.WAITING_FOR_WIFI.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.WAITING_FOR_POWER.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.LOW_BATTERY.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.UNKNOWN_ERROR.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState = new int[NotificationState.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.ACTIVE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.PAUSED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.NO_SPACE_ALL.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.NO_SPACE_PHOTOS.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.UNKNOWN_PROBLEM.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.COMPLETE.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.NO_NETWORK.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.WAITING_FOR_WIFI.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.WAITING_FOR_POWER.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.LOW_BATTERY.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
