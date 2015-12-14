// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.account;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.mixtape.account:
//            CloudMetadataStore

class val.checkpoint
    implements Runnable
{

    final CloudMetadataStore this$0;
    final String val$checkpoint;
    final String val$lastCheckpoint;
    final List val$nodes;
    final Set val$urisToNotify;

    public void run()
    {
        String s = getLastCheckpoint();
        if (val$lastCheckpoint != null && !val$lastCheckpoint.equals(s) || s != null && !s.equals(val$lastCheckpoint))
        {
            return;
        } else
        {
            CloudMetadataStore.access$200(CloudMetadataStore.this, val$nodes, true, val$urisToNotify);
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("checkpoint_id", val$checkpoint);
            CloudMetadataStore.access$300(CloudMetadataStore.this).insert("checkpoints", null, contentvalues);
            val$urisToNotify.add(com.amazon.mixtape.provider.eckpoints.getContentUri(CloudMetadataStore.access$400(CloudMetadataStore.this), CloudMetadataStore.access$500(CloudMetadataStore.this)));
            return;
        }
    }

    heckpoints()
    {
        this$0 = final_cloudmetadatastore;
        val$lastCheckpoint = s;
        val$nodes = list;
        val$urisToNotify = set;
        val$checkpoint = String.this;
        super();
    }
}
