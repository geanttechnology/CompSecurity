// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.controller;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaTagTypeObserver;
import com.amazon.gallery.framework.data.dao.tag.TagTagTypeObserver;
import com.amazon.gallery.framework.model.tags.TagType;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.thor.controller:
//            NavigationPaneController

private class <init>
    implements MediaTagTypeObserver, TagTagTypeObserver
{

    final NavigationPaneController this$0;

    private void notify(TagType tagtype)
    {
        if (NavigationPaneController.access$400().contains(tagtype))
        {
            GLogger.d(NavigationPaneController.access$500(), "Changes for tag type %s are found", new Object[] {
                tagtype
            });
            updateItems();
        }
    }

    public void onMediaItemCollectionChanged(TagType tagtype)
    {
        notify(tagtype);
    }

    public void onTagsChanged(TagType tagtype, ChangeList changelist)
    {
        notify(tagtype);
    }

    private ()
    {
        this$0 = NavigationPaneController.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
