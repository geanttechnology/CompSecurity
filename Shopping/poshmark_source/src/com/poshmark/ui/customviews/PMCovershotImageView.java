// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.ListingDetailsFragment;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMListingImageView, PMImageViewOnClickListener

public class PMCovershotImageView extends PMListingImageView
{

    boolean isImageSet;
    int layoutType;
    String listingId;

    public PMCovershotImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        listingId = null;
        isImageSet = false;
    }

    public void launchFragmentOnClick()
    {
        Bundle bundle = new Bundle();
        bundle.putString("ID", listingId);
        if (customOnCLickListener != null)
        {
            customOnCLickListener.onClick(this, bundle);
            return;
        } else
        {
            ((PMActivity)getContext()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/ListingDetailsFragment, null);
            return;
        }
    }

    public void loadImage(String s)
    {
        releaseInternalBitmap();
        setImageBitmap(null);
        if (s != null)
        {
            ImageLoader.getInstance().displayImage(s, this);
            isImageSet = true;
            imgURL = s;
            bUsingResourceBitmap = false;
        } else
        {
            imgURL = "";
            bUsingResourceBitmap = true;
            s = getResources().getDrawable(0x7f0200d4);
            if (s instanceof BitmapDrawable)
            {
                setImageBitmap(((BitmapDrawable)s).getBitmap());
                return;
            }
        }
    }

    public void requestLayout()
    {
        if (!isImageSet)
        {
            super.requestLayout();
        }
    }

    public void setListingId(String s)
    {
        listingId = s;
    }
}
