// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model.media;


public final class SyncState extends Enum
{

    private static final SyncState $VALUES[];
    public static final SyncState NOT_SYNCED;
    public static final SyncState PENDING_AUTO;
    public static final SyncState PENDING_EDITED;
    public static final SyncState PENDING_MANUAL;
    public static final SyncState SKIPPED;
    public static final SyncState SYNCED;
    public static final SyncState SYNCING;
    public static final SyncState SYNC_ERROR_TERMINAL;
    public static final SyncState SYNC_ERROR_TRANSIENT_AUTO;
    public static final SyncState SYNC_ERROR_TRANSIENT_MANUAL;
    public final int value;

    private SyncState(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static SyncState valueOf(int i)
    {
        switch (i)
        {
        default:
            throw new IllegalStateException("Invalid value");

        case 0: // '\0'
            return NOT_SYNCED;

        case 1: // '\001'
            return PENDING_EDITED;

        case 2: // '\002'
            return SYNCING;

        case 3: // '\003'
            return SYNCED;

        case 4: // '\004'
            return SKIPPED;

        case 5: // '\005'
            return SYNC_ERROR_TRANSIENT_AUTO;

        case 6: // '\006'
            return SYNC_ERROR_TERMINAL;

        case 7: // '\007'
            return PENDING_AUTO;

        case 8: // '\b'
            return PENDING_MANUAL;

        case 9: // '\t'
            return SYNC_ERROR_TRANSIENT_MANUAL;
        }
    }

    public static SyncState valueOf(String s)
    {
        return (SyncState)Enum.valueOf(com/amazon/gallery/framework/model/media/SyncState, s);
    }

    public static SyncState[] values()
    {
        return (SyncState[])$VALUES.clone();
    }

    static 
    {
        NOT_SYNCED = new SyncState("NOT_SYNCED", 0, 0);
        PENDING_EDITED = new SyncState("PENDING_EDITED", 1, 1);
        SYNCING = new SyncState("SYNCING", 2, 2);
        SYNCED = new SyncState("SYNCED", 3, 3);
        SKIPPED = new SyncState("SKIPPED", 4, 4);
        SYNC_ERROR_TRANSIENT_AUTO = new SyncState("SYNC_ERROR_TRANSIENT_AUTO", 5, 5);
        SYNC_ERROR_TERMINAL = new SyncState("SYNC_ERROR_TERMINAL", 6, 6);
        PENDING_AUTO = new SyncState("PENDING_AUTO", 7, 7);
        PENDING_MANUAL = new SyncState("PENDING_MANUAL", 8, 8);
        SYNC_ERROR_TRANSIENT_MANUAL = new SyncState("SYNC_ERROR_TRANSIENT_MANUAL", 9, 9);
        $VALUES = (new SyncState[] {
            NOT_SYNCED, PENDING_EDITED, SYNCING, SYNCED, SKIPPED, SYNC_ERROR_TRANSIENT_AUTO, SYNC_ERROR_TERMINAL, PENDING_AUTO, PENDING_MANUAL, SYNC_ERROR_TRANSIENT_MANUAL
        });
    }
}
