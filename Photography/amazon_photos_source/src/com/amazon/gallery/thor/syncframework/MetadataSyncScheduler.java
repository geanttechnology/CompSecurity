// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.syncframework;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.thor.cds.GalleryMetadataSyncService;

// Referenced classes of package com.amazon.gallery.thor.syncframework:
//            SyncScheduler

public abstract class MetadataSyncScheduler extends SyncScheduler
{

    private static final String TAG = com/amazon/gallery/thor/syncframework/MetadataSyncScheduler.getName();

    protected MetadataSyncScheduler(Context context, String s)
    {
        super(context, s, context.getResources().getString(0x7f0e02fb));
    }

    public void syncNow(Context context)
    {
        GLogger.d(TAG, "Sync now", new Object[0]);
        Intent intent = new Intent(context, com/amazon/gallery/thor/cds/GalleryMetadataSyncService);
        intent.setAction("com.amazon.mixtape.sync.service.FORCE_START");
        intent.putExtra("accountName", getSyncAccount().name);
        intent.putExtra("accountType", getSyncAccount().type);
        intent.putExtra("authority", getAuthority());
        context.startService(intent);
    }

}
