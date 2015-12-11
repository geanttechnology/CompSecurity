// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.utils.RemoveEditListingImageListener;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMEditListingImageView

public class PMEditListingImageSelectorView extends FrameLayout
{

    private ImageButton deleteButton;
    private PMEditListingImageView imageView;
    private RemoveEditListingImageListener removeHandler;

    public PMEditListingImageSelectorView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public PMEditListingImageSelectorView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    private void setupView()
    {
        if (imageView == null)
        {
            imageView = (PMEditListingImageView)findViewById(0x7f0c00b5);
        }
        if (deleteButton == null)
        {
            deleteButton = (ImageButton)findViewById(0x7f0c01ab);
            deleteButton.setOnClickListener(new android.view.View.OnClickListener() {

                final PMEditListingImageSelectorView this$0;

                public void onClick(View view)
                {
                    if (removeHandler != null)
                    {
                        removeHandler.onDeleteButtonClick((PMEditListingImageSelectorView)view.getParent());
                    }
                }

            
            {
                this$0 = PMEditListingImageSelectorView.this;
                super();
            }
            });
        }
    }

    private void updateDeleteButtonVisibility()
    {
        if (!imageView.isCovershot())
        {
            deleteButton.setVisibility(0);
            deleteButton.bringToFront();
        }
    }

    public Uri getFileUri()
    {
        setupView();
        return imageView.getFileUri();
    }

    public Bitmap getImageBitmap()
    {
        setupView();
        return ((BitmapDrawable)imageView.getDrawable()).getBitmap();
    }

    public String getImageId()
    {
        setupView();
        return imageView.getImageId();
    }

    public String getImageUrl()
    {
        setupView();
        return imageView.getImageUrl();
    }

    public Uri getOriginalFileUri()
    {
        setupView();
        return imageView.getOriginalFileUri();
    }

    public void imageAssignedState(boolean flag)
    {
        setupView();
        imageView.imageAssignedState(flag);
    }

    public boolean isCovershot()
    {
        setupView();
        return imageView.isCovershot();
    }

    public boolean isImageSet()
    {
        setupView();
        return imageView.isImageSet();
    }

    public boolean isNextSelector()
    {
        setupView();
        return imageView.isNextSelector();
    }

    public void resetImageView()
    {
        imageView.setImageResource(0x106000d);
        imageView.imageAssignedState(false);
        imageView.setURL(null);
        imageView.setFileUri(null);
        imageView.setOriginalFileUri(null);
        deleteButton.setVisibility(4);
    }

    public void setAsNextSelector(boolean flag)
    {
        setupView();
        imageView.setAsNextEmptyImageView(flag);
        imageView.postInvalidate();
    }

    public void setCovershotStatus(boolean flag)
    {
        setupView();
        imageView.setCovershotStatus(flag);
    }

    public void setFileUri(Uri uri)
    {
        setupView();
        imageView.setFileUri(uri);
        updateDeleteButtonVisibility();
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        setupView();
        ImageLoader.getInstance().cancelDisplayTask(imageView);
        imageView.setImageBitmap(bitmap);
        updateDeleteButtonVisibility();
    }

    public void setOriginalFileUri(Uri uri)
    {
        setupView();
        imageView.setOriginalFileUri(uri);
        updateDeleteButtonVisibility();
    }

    public void setRemoteImageInfo(String s, String s1)
    {
        setupView();
        imageView.setRemoteImageInfo(s, s1);
        updateDeleteButtonVisibility();
    }

    public void setRemoveButtonClickListener(RemoveEditListingImageListener removeeditlistingimagelistener)
    {
        removeHandler = removeeditlistingimagelistener;
    }

}
