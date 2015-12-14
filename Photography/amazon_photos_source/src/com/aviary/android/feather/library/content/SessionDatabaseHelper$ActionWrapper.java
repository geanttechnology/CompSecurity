// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.content;

import java.util.Locale;

// Referenced classes of package com.aviary.android.feather.library.content:
//            SessionDatabaseHelper

public static final class actions
{

    public final String actions;
    public final long bitmapPtr;
    public final long id;
    public final long sessionId;

    public String toString()
    {
        return String.format(Locale.US, "ActionWrapper{id: %d, session_id: %d, bitmap_ptr: %d, actions: %s}", new Object[] {
            Long.valueOf(id), Long.valueOf(sessionId), Long.valueOf(bitmapPtr), actions
        });
    }

    public (long l, long l1, long l2, byte abyte0[])
    {
        id = l;
        sessionId = l1;
        bitmapPtr = l2;
        actions = new String(abyte0);
    }
}
