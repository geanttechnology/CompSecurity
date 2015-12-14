// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.view.View;
import com.amazon.gallery.framework.gallery.widget.holder.ItemViewHolder;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.tags.Tag;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            AbstractCoverViewFactory, FolderSettingsViewFactory, FolderSettingsViewHolder

private static class a extends AbstractCoverViewFactory
{

    public volatile ItemViewHolder createViewHolder(Persistable persistable, View view)
    {
        return createViewHolder((Tag)persistable, view);
    }

    public ItemViewHolder createViewHolder(Tag tag, View view)
    {
        return new FolderSettingsViewHolder(tag, view);
    }

    protected a()
    {
        super(0x7f03008d);
    }
}
