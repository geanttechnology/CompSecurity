// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.device.DeviceUtil;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.gallery.widget.holder.ItemViewHolder;
import com.amazon.gallery.framework.glide.GlideWrapper;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.tags.Tag;
import com.bumptech.glide.GenericRequestBuilder;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            GridItemViewFactory, CoverViewInterface

public class TagGridItemViewFactory extends GridItemViewFactory
{

    private static final String TAG = com/amazon/gallery/framework/gallery/widget/TagGridItemViewFactory.getName();

    public TagGridItemViewFactory(Context context, CoverViewInterface coverviewinterface, MediaItemDao mediaitemdao)
    {
        super(context, coverviewinterface, null);
    }

    public int getPlaceholderResourceId()
    {
        return 0x7f020140;
    }

    protected volatile void loadImage(Persistable persistable, ItemViewHolder itemviewholder, int i)
    {
        loadImage((Tag)persistable, itemviewholder, i);
    }

    protected void loadImage(Tag tag, ItemViewHolder itemviewholder, int i)
    {
        itemviewholder.updateBoundingImageSize(getBoundingWidth(i), getBoundingHeight(i));
        itemviewholder.updateView(tag, context);
        GLogger.d(TAG, "%s has a cover photo", new Object[] {
            tag.getLabel()
        });
        GlideWrapper.loadImage(tag, itemviewholder.getImageView(), itemviewholder, getThumbnailRequest(context, tag, i), false, i, this);
    }

    public volatile void overrideSizeToGlideBuilder(int i, Persistable persistable, GenericRequestBuilder genericrequestbuilder)
    {
        overrideSizeToGlideBuilder(i, (Tag)persistable, genericrequestbuilder);
    }

    public void overrideSizeToGlideBuilder(int i, Tag tag, GenericRequestBuilder genericrequestbuilder)
    {
        genericrequestbuilder.override(getBoundingWidth(i), getBoundingHeight(i));
    }

    public void setBoundingSize(int i, int j)
    {
        boundingWidth = i;
        if (!DeviceUtil.isTablet(context) && BuildFlavors.isAosp())
        {
            boundingHeight = Math.round((float)j / 1.25F);
            return;
        } else
        {
            boundingHeight = (j * 2) / 3;
            return;
        }
    }

}
