// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.network.download.GalleryDownloadManager;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            AbstractBadgeableCoverView

public class AndroidGalleryBadgeableCoverView extends AbstractBadgeableCoverView
{
    private class RemoveDownloadClickListener
        implements android.view.View.OnClickListener
    {

        private ObjectID tagId;
        final AndroidGalleryBadgeableCoverView this$0;

        private void update(ObjectID objectid)
        {
            tagId = objectid;
        }

        public void onClick(View view)
        {
            (((GalleryDownloadManager)((BeanAwareActivity)view.getContext()).getApplicationBean(Keys.GALLERY_DOWNLOAD_MANAGER)). new AsyncTask() {

                final RemoveDownloadClickListener this$1;
                final GalleryDownloadManager val$dm;

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    dm.removeDownload(tagId);
                    return null;
                }

            
            {
                this$1 = final_removedownloadclicklistener;
                dm = GalleryDownloadManager.this;
                super();
            }
            }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            downloadCanceled = true;
            removeProgressBarBadge();
            toggleBadge(GalleryBadgeableCoverView.BadgeType.HIGHLIGHT, false);
            setQueued(false);
        }



        private RemoveDownloadClickListener(ObjectID objectid)
        {
            this$0 = AndroidGalleryBadgeableCoverView.this;
            super();
            update(objectid);
        }

    }


    boolean animationInitialized;
    private Animation checkInAnimation;
    private View checkMark;
    private Animation checkOutAnimation;
    private RemoveDownloadClickListener clickListener;
    private boolean downloadCanceled;
    private Animation fadeInSelectAnimation;
    private Animation fadeOutSelectAnimation;
    private View selectedBackground;

    public AndroidGalleryBadgeableCoverView(View view)
    {
        animationInitialized = false;
        coverView = view;
    }

    private void initializeAnimation()
    {
        if (!animationInitialized)
        {
            checkMark = coverView.findViewById(0x7f0c01c8);
            selectedBackground = coverView.findViewById(0x7f0c01c7);
            checkInAnimation = AnimationUtils.loadAnimation(coverView.getContext(), 0x7f04002f);
            fadeInSelectAnimation = AnimationUtils.loadAnimation(coverView.getContext(), 0x7f04002d);
            checkOutAnimation = AnimationUtils.loadAnimation(coverView.getContext(), 0x7f040030);
            fadeOutSelectAnimation = AnimationUtils.loadAnimation(coverView.getContext(), 0x7f04002e);
            animationInitialized = true;
        }
    }

    private void refreshBorder()
    {
        android.graphics.drawable.Drawable drawable = null;
        if (!isBadgeEnabled(GalleryBadgeableCoverView.BadgeType.SELECTED) || BuildFlavors.isAosp()) goto _L2; else goto _L1
_L1:
        drawable = coverView.getContext().getResources().getDrawable(0x7f020188);
_L4:
        coverView.setBackgroundDrawable(drawable);
        return;
_L2:
        if (isBadgeEnabled(GalleryBadgeableCoverView.BadgeType.ACTIVE))
        {
            drawable = coverView.getContext().getResources().getDrawable(0x7f02003c);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void removeProgressBarBadge()
    {
        ((ProgressBar)coverView.findViewById(0x7f0c0110)).setProgress(0);
        setBadgeVisible(GalleryBadgeableCoverView.BadgeType.UPLOADING, 0x7f0c0110, false);
    }

    private void showProgressBarBadge(int i)
    {
        setBadgeVisible(GalleryBadgeableCoverView.BadgeType.UPLOADING, 0x7f0c0110, true);
        ((ProgressBar)coverView.findViewById(0x7f0c0110)).setProgress(i);
    }

    private void updateRemoveDownloadClickListener(ObjectID objectid)
    {
        if (clickListener != null)
        {
            clickListener.update(objectid);
            return;
        } else
        {
            clickListener = new RemoveDownloadClickListener(objectid);
            coverView.findViewById(0x7f0c01c3).setOnClickListener(clickListener);
            return;
        }
    }

    public void onDownloadRequested(ObjectID objectid)
    {
        setProgress(objectid, true, 0, 1);
        downloadCanceled = false;
    }

    public void setActiveBadgeVisible(boolean flag)
    {
        setBadgeVisible(GalleryBadgeableCoverView.BadgeType.ACTIVE, flag);
        refreshBorder();
    }

    public void setProgress(ObjectID objectid, boolean flag, int i, int j)
    {
        if (downloadCanceled)
        {
            removeProgressBarBadge();
            setQueued(false);
            return;
        }
        setQueued(flag);
        if (flag)
        {
            showProgressBarBadge((i * 100) / j);
            updateRemoveDownloadClickListener(objectid);
        } else
        {
            removeProgressBarBadge();
        }
        toggleBadge(GalleryBadgeableCoverView.BadgeType.HIGHLIGHT, flag);
    }

    public void setQueued(boolean flag)
    {
        setBadgeVisible(GalleryBadgeableCoverView.BadgeType.QUEUED, 0x7f0c01c3, flag);
    }

    public void setSelectedBadgeVisible(boolean flag)
    {
        setBadgeVisible(GalleryBadgeableCoverView.BadgeType.SELECTED, 0x7f0c01c7, flag);
        if (flag)
        {
            initializeAnimation();
        }
        Long long1 = (Long)badgeToggleTimeMap.get(GalleryBadgeableCoverView.BadgeType.SELECTED);
        if (long1 != null && SystemClock.uptimeMillis() - long1.longValue() < checkInAnimation.getDuration())
        {
            checkInAnimation.setStartOffset(SystemClock.uptimeMillis() - long1.longValue());
            fadeInSelectAnimation.setStartOffset(SystemClock.uptimeMillis() - long1.longValue());
            if (flag)
            {
                checkMark.startAnimation(checkInAnimation);
                selectedBackground.startAnimation(fadeInSelectAnimation);
            } else
            {
                checkMark.startAnimation(checkOutAnimation);
                selectedBackground.startAnimation(fadeOutSelectAnimation);
            }
        }
        refreshBorder();
    }


/*
    static boolean access$302(AndroidGalleryBadgeableCoverView androidgallerybadgeablecoverview, boolean flag)
    {
        androidgallerybadgeablecoverview.downloadCanceled = flag;
        return flag;
    }

*/

}
