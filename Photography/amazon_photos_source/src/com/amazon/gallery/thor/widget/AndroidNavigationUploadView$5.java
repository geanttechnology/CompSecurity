// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import com.amazon.gallery.framework.network.multiqueueuploader.UploadError;

// Referenced classes of package com.amazon.gallery.thor.widget:
//            AndroidNavigationUploadView

static class ewState
{

    static final int $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[];
    static final int $SwitchMap$com$amazon$gallery$thor$widget$AndroidNavigationUploadView$ViewState[];

    static 
    {
        $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError = new int[UploadError.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.NO_NETWORK.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.WAITING_FOR_WIFI.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.LOW_BATTERY.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.WAITING_FOR_POWER.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.NO_SPACE.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.ACCOUNT_CHANGED.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.UNREGISTERED.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.UPLOAD_DISABLED.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.UNKNOWN_ERROR.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.NO_ERROR.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        $SwitchMap$com$amazon$gallery$thor$widget$AndroidNavigationUploadView$ViewState = new int[ewState.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$thor$widget$AndroidNavigationUploadView$ViewState[ewState.UPLOADING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$gallery$thor$widget$AndroidNavigationUploadView$ViewState[ewState.REST.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$gallery$thor$widget$AndroidNavigationUploadView$ViewState[ewState.PAUSED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$thor$widget$AndroidNavigationUploadView$ViewState[ewState.SYNCING.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
