// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.poshmark.data_model.models.ListingSocial;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.ShareFragment;
import com.poshmark.utils.ImageUtils;

// Referenced classes of package com.poshmark.data_model.adapters:
//            FeedListAdapter

class val.feedItem
    implements ImageLoadingListener
{

    final val.feedItem this$1;
    final ListingSocial val$feedItem;
    final View val$v;

    public void onLoadingCancelled(String s, View view)
    {
    }

    public void onLoadingComplete(String s, View view, Bitmap bitmap)
    {
        s = ImageUtils.saveBitmapToDisk(bitmap, "ListingCoverShot.jpg");
        view = new Bundle();
        view.putString("MODE", com.poshmark.utils.ODE.SHARE_MODE_LISTING.name());
        view.putString("IMAGE_URI", s.toString());
        ((PMActivity)val$v.getContext()).launchFragmentInNewActivity(view, com/poshmark/ui/fragments/ShareFragment, val$feedItem);
    }

    public void onLoadingFailed(String s, View view, FailReason failreason)
    {
        s = new Bundle();
        s.putString("MODE", com.poshmark.utils.ODE.SHARE_MODE_LISTING.name());
        ((PMActivity)val$v.getContext()).launchFragmentInNewActivity(s, com/poshmark/ui/fragments/ShareFragment, val$feedItem);
    }

    public void onLoadingStarted(String s, View view)
    {
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$v = view;
        val$feedItem = ListingSocial.this;
        super();
    }

    // Unreferenced inner class com/poshmark/data_model/adapters/FeedListAdapter$3

/* anonymous class */
    class FeedListAdapter._cls3
        implements android.view.View.OnClickListener
    {

        final FeedListAdapter this$0;

        public void onClick(final View v)
        {
            ListingSocial listingsocial = (ListingSocial)v.getTag();
            ImageLoader.getInstance().loadImage(listingsocial.getCovershot(), listingsocial. new FeedListAdapter._cls3._cls1());
        }

            
            {
                this$0 = FeedListAdapter.this;
                super();
            }
    }

}
