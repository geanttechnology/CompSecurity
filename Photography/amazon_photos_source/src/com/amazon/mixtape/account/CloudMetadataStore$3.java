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
        CloudMetadataStore.access$300(CloudMetadataStore.this).delete("checkpoints", null, null);
        val$urisToNotify.add(com.amazon.mixtape.provider.eckpoints.getContentUri(CloudMetadataStore.access$400(CloudMetadataStore.this), CloudMetadataStore.access$500(CloudMetadataStore.this)));
        CloudMetadataStore.access$300(CloudMetadataStore.this).delete("cloud_nodes", null, null);
        val$urisToNotify.add(com.amazon.mixtape.provider.des.getContentUri(CloudMetadataStore.access$400(CloudMetadataStore.this), CloudMetadataStore.access$500(CloudMetadataStore.this)));
        CloudMetadataStore.access$300(CloudMetadataStore.this).delete("cloud_node_parents", null, null);
        val$urisToNotify.add(com.amazon.mixtape.provider.deParents.getContentUri(CloudMetadataStore.access$400(CloudMetadataStore.this), CloudMetadataStore.access$500(CloudMetadataStore.this)));
        val$urisToNotify.add(com.amazon.mixtape.provider.diaParents.getContentUri(CloudMetadataStore.access$400(CloudMetadataStore.this), CloudMetadataStore.access$500(CloudMetadataStore.this)));
        val$urisToNotify.add(com.amazon.mixtape.provider.deChildren.getContentUri(CloudMetadataStore.access$400(CloudMetadataStore.this), CloudMetadataStore.access$500(CloudMetadataStore.this)));
        CloudMetadataStore.access$300(CloudMetadataStore.this).delete("document_authors", null, null);
        val$urisToNotify.add(com.amazon.mixtape.provider.cumentAuthors.getContentUri(CloudMetadataStore.access$400(CloudMetadataStore.this), CloudMetadataStore.access$500(CloudMetadataStore.this)));
        CloudMetadataStore.access$300(CloudMetadataStore.this).delete("events", null, null);
        val$urisToNotify.add(com.amazon.mixtape.provider.ents.getContentUri(CloudMetadataStore.access$400(CloudMetadataStore.this), CloudMetadataStore.access$500(CloudMetadataStore.this)));
        CloudMetadataStore.access$300(CloudMetadataStore.this).delete("cloud_node_properties", null, null);
        val$urisToNotify.add(com.amazon.mixtape.provider.deProperties.getContentUri(CloudMetadataStore.access$400(CloudMetadataStore.this), CloudMetadataStore.access$500(CloudMetadataStore.this)));
        CloudMetadataStore.access$300(CloudMetadataStore.this).delete("cloud_node_labels", null, null);
        val$urisToNotify.add(com.amazon.mixtape.provider.deLabels.getContentUri(CloudMetadataStore.access$400(CloudMetadataStore.this), CloudMetadataStore.access$500(CloudMetadataStore.this)));
        CloudMetadataStore.access$300(CloudMetadataStore.this).delete("cloud_media_parents", null, null);
        val$urisToNotify.add(com.amazon.mixtape.provider.diaParents.getContentUri(CloudMetadataStore.access$400(CloudMetadataStore.this), CloudMetadataStore.access$500(CloudMetadataStore.this)));
        CloudMetadataStore.access$300(CloudMetadataStore.this).delete("cloud_node_transforms", null, null);
        val$urisToNotify.add(com.amazon.mixtape.provider.deTransforms.getContentUri(CloudMetadataStore.access$400(CloudMetadataStore.this), CloudMetadataStore.access$500(CloudMetadataStore.this)));
        CloudMetadataStore.access$300(CloudMetadataStore.this).delete("cloud_node_cover_photos", null, null);
        val$urisToNotify.add(com.amazon.mixtape.provider.deCoverPhotos.getContentUri(CloudMetadataStore.access$400(CloudMetadataStore.this), CloudMetadataStore.access$500(CloudMetadataStore.this)));
    }

    odeCoverPhotos()
    {
        this$0 = final_cloudmetadatastore;
        val$urisToNotify = Set.this;
        super();
    }
}
