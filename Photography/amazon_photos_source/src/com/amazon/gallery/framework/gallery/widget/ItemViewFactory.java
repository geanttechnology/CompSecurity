// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import android.view.View;
import com.amazon.gallery.foundation.utils.TimeTracker;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.widget.holder.ItemViewHolder;
import com.amazon.gallery.framework.glide.GlideWrapper;
import com.amazon.gallery.framework.model.Persistable;
import com.bumptech.glide.GenericRequestBuilder;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            ViewFactory, CoverViewInterface, GridStatus

public abstract class ItemViewFactory
    implements ViewFactory
{

    public static int PLACEHOLDER_DEFAULT = 0x7f0201de;
    public static int PLACEHOLDER_SINGLE_VIEW = 0x7f0201df;
    private static final String TAG = com/amazon/gallery/framework/gallery/widget/ItemViewFactory.getName();
    private static int loggerHolderCount = 0;
    protected int boundingHeight;
    protected int boundingWidth;
    protected Context context;
    protected CoverViewInterface coverViewFactory;
    private ViewFactory.VisibleEqualityCheck equalityCheck;
    protected boolean forceFitCenter;
    private GridStatus loadingStatusTracker;
    private int placeholderResourceId;

    public ItemViewFactory(CoverViewInterface coverviewinterface)
    {
        forceFitCenter = false;
        placeholderResourceId = PLACEHOLDER_DEFAULT;
        coverViewFactory = coverviewinterface;
    }

    public View createView(Persistable persistable)
    {
        return coverViewFactory.createCoverView(context, persistable);
    }

    public volatile View createView(Object obj)
    {
        return createView((Persistable)obj);
    }

    protected int getBoundingHeight(int i)
    {
        return boundingHeight;
    }

    protected int getBoundingWidth(int i)
    {
        return boundingWidth;
    }

    public int getPlaceholderResourceId()
    {
        return placeholderResourceId;
    }

    protected GenericRequestBuilder getThumbnailRequest(Context context1, Persistable persistable, int i)
    {
        return null;
    }

    public View getView(int i, Persistable persistable, View view)
    {
        TimeTracker.log("getView");
        View view1;
        ItemViewHolder itemviewholder;
        if (view == null)
        {
            view = TAG;
            int j = loggerHolderCount + 1;
            loggerHolderCount = j;
            GLogger.v(view, "create holder: %d", new Object[] {
                Integer.valueOf(j)
            });
            view1 = createView(persistable);
            itemviewholder = (ItemViewHolder)view1.getTag();
        } else
        {
            if (view.getTag(0x7f0c000e) == GalleryBaseAdapter.ItemViewType.DIVIDER)
            {
                return view;
            }
            ItemViewHolder itemviewholder1 = (ItemViewHolder)view.getTag();
            itemviewholder = itemviewholder1;
            view1 = view;
            if (itemviewholder1 == null)
            {
                return view;
            }
        }
        loadingStatusTracker.onVisible(itemviewholder);
        loadImage(persistable, itemviewholder, i);
        return view1;
    }

    public volatile View getView(int i, Object obj, View view)
    {
        return getView(i, (Persistable)obj, view);
    }

    protected void loadImage(Persistable persistable, ItemViewHolder itemviewholder, int i)
    {
        boolean flag = itemviewholder.updateBoundingImageSize(getBoundingWidth(i), getBoundingHeight(i));
        if (!sameItem(persistable, itemviewholder.getItem()) || flag)
        {
            itemviewholder.updateView(persistable, context);
            GlideWrapper.loadImage(persistable, itemviewholder.getImageView(), itemviewholder, getThumbnailRequest(context, persistable, i), forceFitCenter, i, this);
        }
    }

    public void onViewDestroy(View view)
    {
        view = (ItemViewHolder)view.getTag();
        if (view != null)
        {
            loadingStatusTracker.onHidden(view);
            view.resetLoading();
            view.resetItem();
            GlideWrapper.cancelLoadImage(view.getImageView());
        }
    }

    public abstract void overrideSizeToGlideBuilder(int i, Persistable persistable, GenericRequestBuilder genericrequestbuilder);

    public void reset()
    {
        loadingStatusTracker.reset();
    }

    public boolean sameItem(Persistable persistable, Persistable persistable1)
    {
        if (persistable == persistable1)
        {
            return true;
        }
        if (persistable == null || persistable1 == null)
        {
            return false;
        }
        if (equalityCheck != null)
        {
            return equalityCheck.visiblyEqual(persistable, persistable1);
        } else
        {
            return persistable.equals(persistable1);
        }
    }

    public void setBoundingSize(int i)
    {
        setBoundingSize(i, i);
    }

    public void setBoundingSize(int i, int j)
    {
        boundingWidth = i;
        boundingHeight = j;
    }

    public void setContext(Context context1)
    {
        context = context1;
    }

    public void setEqualityCheck(ViewFactory.VisibleEqualityCheck visibleequalitycheck)
    {
        equalityCheck = visibleequalitycheck;
    }

    public void setLoadingStatusTracker(GridStatus gridstatus)
    {
        loadingStatusTracker = gridstatus;
    }

    public void setPlaceholderResource(int i)
    {
        placeholderResourceId = i;
    }

}
