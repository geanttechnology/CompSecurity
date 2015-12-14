// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.graphics.Bitmap;
import com.amazon.gallery.framework.gallery.widget.GridStatus;
import com.amazon.gallery.framework.gallery.widget.holder.LoadingHolderInterface;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            ThisDayRandomFragment

private static class gridStatus
    implements LoadingHolderInterface, RequestListener
{

    private GridStatus gridStatus;

    public boolean isLoading()
    {
        return true;
    }

    public boolean onException(Exception exception, MediaItem mediaitem, Target target, boolean flag)
    {
        gridStatus.onHidden(this);
        return false;
    }

    public volatile boolean onException(Exception exception, Object obj, Target target, boolean flag)
    {
        return onException(exception, (MediaItem)obj, target, flag);
    }

    public boolean onResourceReady(Bitmap bitmap, MediaItem mediaitem, Target target, boolean flag, boolean flag1)
    {
        gridStatus.onHidden(this);
        return false;
    }

    public volatile boolean onResourceReady(Object obj, Object obj1, Target target, boolean flag, boolean flag1)
    {
        return onResourceReady((Bitmap)obj, (MediaItem)obj1, target, flag, flag1);
    }

    public (GridStatus gridstatus)
    {
        gridStatus = gridstatus;
    }
}
