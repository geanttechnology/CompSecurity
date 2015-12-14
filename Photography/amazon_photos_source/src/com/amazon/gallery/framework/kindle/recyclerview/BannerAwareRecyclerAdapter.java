// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.recyclerview;

import android.database.Cursor;
import com.amazon.gallery.framework.gallery.widget.GalleryBaseAdapter;
import com.amazon.gallery.framework.gallery.widget.MediaItemProxyAdapter;
import com.amazon.gallery.framework.gallery.widget.ViewFactory;

// Referenced classes of package com.amazon.gallery.framework.kindle.recyclerview:
//            RecyclerAdapter

public class BannerAwareRecyclerAdapter extends RecyclerAdapter
{

    public BannerAwareRecyclerAdapter(GalleryBaseAdapter gallerybaseadapter, ViewFactory viewfactory)
    {
        super(gallerybaseadapter, viewfactory);
    }

    public void notifyBannerMetadataChanged(Cursor cursor)
    {
        ((MediaItemProxyAdapter)mDelegateAdapter).onBannerMetadataChanged(cursor);
        notifyItemChanged(0);
    }
}
