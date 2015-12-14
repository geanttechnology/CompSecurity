// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;


// Referenced classes of package com.amazon.gallery.thor.cds:
//            SyncNotificationObserver

static class ncState
{

    static final int $SwitchMap$com$amazon$gallery$thor$cds$SyncNotificationObserver$SyncState[];

    static 
    {
        $SwitchMap$com$amazon$gallery$thor$cds$SyncNotificationObserver$SyncState = new int[ncState.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$thor$cds$SyncNotificationObserver$SyncState[ncState.COLDBOOT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$thor$cds$SyncNotificationObserver$SyncState[ncState.INCREMENTAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
