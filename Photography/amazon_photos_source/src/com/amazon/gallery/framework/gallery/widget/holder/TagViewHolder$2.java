// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget.holder;

import com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView;
import com.amazon.gallery.framework.model.ObjectID;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget.holder:
//            TagViewHolder

class val.tagId
    implements Runnable
{

    final TagViewHolder this$0;
    final ObjectID val$tagId;

    public void run()
    {
        badges.onDownloadRequested(val$tagId);
    }

    ew()
    {
        this$0 = final_tagviewholder;
        val$tagId = ObjectID.this;
        super();
    }
}
