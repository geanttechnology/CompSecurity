// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;

import com.amazon.gallery.framework.model.media.SyncState;

// Referenced classes of package com.amazon.gallery.framework.kindle.action:
//            ManualUploadAction

static class stUploadAction
{

    static final int $SwitchMap$com$amazon$gallery$framework$kindle$action$ManualUploadAction$PostUploadAction[];
    static final int $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[];

    static 
    {
        $SwitchMap$com$amazon$gallery$framework$model$media$SyncState = new int[SyncState.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.PENDING_MANUAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.PENDING_AUTO.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.SYNCED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.SYNCING.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        $SwitchMap$com$amazon$gallery$framework$kindle$action$ManualUploadAction$PostUploadAction = new int[stUploadAction.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$action$ManualUploadAction$PostUploadAction[stUploadAction.WIRELESS_SETTINGS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$action$ManualUploadAction$PostUploadAction[stUploadAction.MANAGE_STORAGE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
