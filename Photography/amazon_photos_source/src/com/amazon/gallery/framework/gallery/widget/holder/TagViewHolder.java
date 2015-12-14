// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.amazon.gallery.framework.gallery.view.ViewNameFactory;
import com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.download.GalleryDownloadListener;
import com.amazon.gallery.framework.network.download.GalleryDownloadManager;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget.holder:
//            ItemViewHolder

public class TagViewHolder extends ItemViewHolder
    implements GalleryDownloadListener
{

    private final GalleryDownloadManager downloadManager;
    private TextView textView;

    public TagViewHolder(Tag tag, View view, GalleryDownloadManager gallerydownloadmanager)
    {
        super(tag, view);
        setImageView((ImageView)view.findViewById(0x7f0c01e8));
        downloadManager = gallerydownloadmanager;
        textView = (TextView)view.findViewById(0x7f0c01e9);
    }

    public void onProgress(final ObjectID tagId, ObjectID objectid, final int count, final int total)
    {
        if (getImageView() != null)
        {
            getImageView().post(new Runnable() {

                final TagViewHolder this$0;
                final int val$count;
                final ObjectID val$tagId;
                final int val$total;

                public void run()
                {
                    GalleryBadgeableCoverView gallerybadgeablecoverview = badges;
                    ObjectID objectid1 = tagId;
                    boolean flag;
                    if (count != total)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    gallerybadgeablecoverview.setProgress(objectid1, flag, count, total);
                }

            
            {
                this$0 = TagViewHolder.this;
                tagId = objectid;
                count = i;
                total = j;
                super();
            }
            });
        }
    }

    public void onRequested(final ObjectID tagId)
    {
        if (getImageView() != null)
        {
            getImageView().post(new Runnable() {

                final TagViewHolder this$0;
                final ObjectID val$tagId;

                public void run()
                {
                    badges.onDownloadRequested(tagId);
                }

            
            {
                this$0 = TagViewHolder.this;
                tagId = objectid;
                super();
            }
            });
        }
    }

    public volatile void updateView(Persistable persistable, Context context)
    {
        updateView((Tag)persistable, context);
    }

    public void updateView(Tag tag, Context context)
    {
        downloadManager.removeListener(((Tag)item).getObjectId());
        super.updateView(tag, context);
        downloadManager.addListener(tag.getObjectId(), this);
        textView.setText(ViewNameFactory.getTitle(tag, context));
    }
}
