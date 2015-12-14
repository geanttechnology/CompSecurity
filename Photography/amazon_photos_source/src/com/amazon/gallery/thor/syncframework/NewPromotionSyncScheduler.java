// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.syncframework;

import android.content.Context;
import android.content.res.Resources;

// Referenced classes of package com.amazon.gallery.thor.syncframework:
//            SyncScheduler

public abstract class NewPromotionSyncScheduler extends SyncScheduler
{

    protected NewPromotionSyncScheduler(Context context, String s)
    {
        super(context, s, context.getResources().getString(0x7f0e02fc), false);
    }

    public void syncNow(Context context)
    {
    }
}
