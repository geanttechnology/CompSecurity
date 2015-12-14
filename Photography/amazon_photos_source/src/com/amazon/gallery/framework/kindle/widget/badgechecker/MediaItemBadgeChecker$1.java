// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.widget.badgechecker;

import com.amazon.gallery.framework.model.media.SyncState;

// Referenced classes of package com.amazon.gallery.framework.kindle.widget.badgechecker:
//            MediaItemBadgeChecker

static class 
{

    static final int $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[];

    static 
    {
        $SwitchMap$com$amazon$gallery$framework$model$media$SyncState = new int[SyncState.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.PENDING_AUTO.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.PENDING_MANUAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.SYNCING.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.SYNC_ERROR_TERMINAL.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.SYNC_ERROR_TRANSIENT_AUTO.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.SKIPPED.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.NOT_SYNCED.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.SYNC_ERROR_TRANSIENT_MANUAL.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
