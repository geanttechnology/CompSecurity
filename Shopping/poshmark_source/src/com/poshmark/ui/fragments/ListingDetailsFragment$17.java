// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.poshmark.ui.PMActivity;
import com.poshmark.utils.ImageUtils;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingDetailsFragment, ShareFragment

class this._cls0
    implements ImageLoadingListener
{

    final ListingDetailsFragment this$0;

    public void onLoadingCancelled(String s, View view)
    {
    }

    public void onLoadingComplete(String s, View view, Bitmap bitmap)
    {
        view = ImageUtils.saveBitmapToDisk(bitmap, "ListingCoverShot.jpg");
        s = new Bundle();
        s.putString("MODE", com.poshmark.utils.ARE_MODE_LISTING.me());
        if (view != null)
        {
            s.putString("IMAGE_URI", view.toString());
        }
        view = (PMActivity)getActivity();
        if (isAdded())
        {
            view.launchFragmentInNewActivity(s, com/poshmark/ui/fragments/ShareFragment, listingDetails);
        }
    }

    public void onLoadingFailed(String s, View view, FailReason failreason)
    {
        s = new Bundle();
        s.putString("MODE", com.poshmark.utils.ARE_MODE_LISTING.me());
        ((PMActivity)getActivity()).launchFragmentInNewActivity(s, com/poshmark/ui/fragments/ShareFragment, listingDetails);
    }

    public void onLoadingStarted(String s, View view)
    {
    }

    ason()
    {
        this$0 = ListingDetailsFragment.this;
        super();
    }
}
