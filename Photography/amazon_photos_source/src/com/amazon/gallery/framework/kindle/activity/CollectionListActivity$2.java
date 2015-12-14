// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import com.amazon.gallery.framework.model.tags.Tag;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            CollectionListActivity

class this._cls0
    implements com.amazon.gallery.framework.gallery.widget.tyCheck
{

    final CollectionListActivity this$0;

    public boolean visiblyEqual(Tag tag, Tag tag1)
    {
        return tag != null && tag.visiblyEqual(tag1);
    }

    public volatile boolean visiblyEqual(Object obj, Object obj1)
    {
        return visiblyEqual((Tag)obj, (Tag)obj1);
    }

    yCheck()
    {
        this$0 = CollectionListActivity.this;
        super();
    }
}
