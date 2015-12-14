// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.cab.SelectionChecker;
import com.amazon.gallery.framework.gallery.utils.messaging.CabMediaItemEvent;
import com.amazon.gallery.framework.gallery.widget.holder.ItemViewHolder;
import com.amazon.gallery.framework.glide.GlideWrapper;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.bumptech.glide.GenericRequestBuilder;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            ItemViewFactory, ItemMetadataViewHolder, AbstractCoverViewFactory

public class ItemMetadataViewFactory extends ItemViewFactory
{
    private static class ItemMetadataCoverViewFactory extends AbstractCoverViewFactory
    {

        public volatile ItemViewHolder createViewHolder(Persistable persistable, View view)
        {
            return createViewHolder((MediaItem)persistable, view);
        }

        public ItemViewHolder createViewHolder(MediaItem mediaitem, View view)
        {
            return new ItemMetadataViewHolder(mediaitem, view);
        }

        protected ItemMetadataCoverViewFactory()
        {
            super(0x7f03009e);
        }
    }


    SelectionChecker selectionChecker;

    public ItemMetadataViewFactory(Context context, SelectionChecker selectionchecker)
    {
        super(new ItemMetadataCoverViewFactory());
        this.context = context;
        selectionChecker = selectionchecker;
    }

    public volatile View getView(int i, Persistable persistable, View view)
    {
        return getView(i, (MediaItem)persistable, view);
    }

    public View getView(int i, final MediaItem item, View view)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = createView(item);
        }
        view = (ItemMetadataViewHolder)view1.getTag();
        ((ItemMetadataViewHolder) (view)).checkBox.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final ItemMetadataViewFactory this$0;
            final MediaItem val$item;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    GlobalMessagingBus.post(new CabMediaItemEvent(com.amazon.gallery.framework.gallery.utils.messaging.CabMediaItemEvent.Action.ADD, item));
                    return;
                } else
                {
                    GlobalMessagingBus.post(new CabMediaItemEvent(com.amazon.gallery.framework.gallery.utils.messaging.CabMediaItemEvent.Action.REMOVE, item));
                    return;
                }
            }

            
            {
                this$0 = ItemMetadataViewFactory.this;
                item = mediaitem;
                super();
            }
        });
        view.updateView(item, selectionChecker.isSelected(item));
        GlideWrapper.loadImage(item, view.getImageView(), view, getThumbnailRequest(context, item, i), forceFitCenter, i, this);
        return view1;
    }

    public volatile View getView(int i, Object obj, View view)
    {
        return getView(i, (MediaItem)obj, view);
    }

    public void onViewDestroy(View view)
    {
        view = (ItemMetadataViewHolder)view.getTag();
        if (view != null)
        {
            GlideWrapper.cancelLoadImage(view.getImageView());
        }
    }

    public volatile void overrideSizeToGlideBuilder(int i, Persistable persistable, GenericRequestBuilder genericrequestbuilder)
    {
        overrideSizeToGlideBuilder(i, (MediaItem)persistable, genericrequestbuilder);
    }

    public void overrideSizeToGlideBuilder(int i, MediaItem mediaitem, GenericRequestBuilder genericrequestbuilder)
    {
        genericrequestbuilder.override(128, 128);
    }
}
