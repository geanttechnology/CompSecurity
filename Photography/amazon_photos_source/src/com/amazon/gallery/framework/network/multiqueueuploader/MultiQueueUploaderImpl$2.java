// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;


// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            MultiQueueUploaderImpl, QueueType, UploadError

static class 
{

    static final int $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$QueueType[];
    static final int $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[];

    static 
    {
        $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$QueueType = new int[QueueType.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$QueueType[QueueType.AUTO_SAVE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$QueueType[QueueType.MANUAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$QueueType[QueueType.FORCE_UPLOAD.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError = new int[UploadError.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.NO_ERROR.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.NO_SPACE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.WAITING_FOR_WIFI.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.UNKNOWN_ERROR.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.ACCOUNT_CHANGED.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.UNREGISTERED.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.UPLOAD_DISABLED.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.WAITING_FOR_POWER.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.LOW_BATTERY.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.NO_NETWORK.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
