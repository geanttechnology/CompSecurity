// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;


// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            MultiQueueUploaderMessageHandler, UploadControlAction

static class 
{

    static final int $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[];
    static final int $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadListenerEvent$Action[];

    static 
    {
        $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadListenerEvent$Action = new int[on().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadListenerEvent$Action[on.on()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadListenerEvent$Action[on.on()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction = new int[UploadControlAction.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[UploadControlAction.START.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[UploadControlAction.RESUME.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[UploadControlAction.PAUSE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[UploadControlAction.CANCEL.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
