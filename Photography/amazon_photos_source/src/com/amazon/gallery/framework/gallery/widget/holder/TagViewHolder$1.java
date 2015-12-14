// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget.holder;

import com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView;
import com.amazon.gallery.framework.model.ObjectID;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget.holder:
//            TagViewHolder

class val.total
    implements Runnable
{

    final TagViewHolder this$0;
    final int val$count;
    final ObjectID val$tagId;
    final int val$total;

    public void run()
    {
        GalleryBadgeableCoverView gallerybadgeablecoverview = badges;
        ObjectID objectid = val$tagId;
        boolean flag;
        if (val$count != val$total)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        gallerybadgeablecoverview.setProgress(objectid, flag, val$count, val$total);
    }

    ew()
    {
        this$0 = final_tagviewholder;
        val$tagId = objectid;
        val$count = i;
        val$total = I.this;
        super();
    }
}
