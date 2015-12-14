// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.account;

import android.database.sqlite.SQLiteDatabase;
import java.util.Set;

// Referenced classes of package com.amazon.mixtape.account:
//            CloudMetadataStore

class val.urisToNotify
    implements Runnable
{

    final CloudMetadataStore this$0;
    final Set val$urisToNotify;

    public void run()
    {
        CloudMetadataStore.access$800(CloudMetadataStore.this, val$urisToNotify);
        CloudMetadataStore.access$300(CloudMetadataStore.this).delete("account_metadata_states", null, null);
        val$urisToNotify.add(com.amazon.mixtape.provider.countMetadataStates.getContentUri(CloudMetadataStore.access$400(CloudMetadataStore.this), CloudMetadataStore.access$500(CloudMetadataStore.this)));
    }

    ccountMetadataStates()
    {
        this$0 = final_cloudmetadatastore;
        val$urisToNotify = Set.this;
        super();
    }
}
