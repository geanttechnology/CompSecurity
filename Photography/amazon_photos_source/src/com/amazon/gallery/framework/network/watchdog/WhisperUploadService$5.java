// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.watchdog;

import com.amazon.gallery.framework.network.multiqueueuploader.QueueType;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadControlAction;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadError;

// Referenced classes of package com.amazon.gallery.framework.network.watchdog:
//            WhisperUploadService

static class Action
{

    static final int $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$QueueType[];
    static final int $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[];
    static final int $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[];

    static 
    {
        $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction = new int[UploadControlAction.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[UploadControlAction.CANCEL.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[UploadControlAction.PAUSE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$QueueType = new int[QueueType.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$QueueType[QueueType.MANUAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$QueueType[QueueType.AUTO_SAVE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$QueueType[QueueType.FORCE_UPLOAD.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError = new int[UploadError.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.WAITING_FOR_POWER.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.LOW_BATTERY.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
