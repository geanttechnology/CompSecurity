// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.media;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.amazon.now.media:
//            HorizontalContainer, FullScreenGalleryActivity, GalleryPanel, PinchImageView

public class Gallery extends HorizontalContainer
{

    private final Context mContext;
    private final HorizontalContainer.OnScrollListener mOnScrollListener = new HorizontalContainer.OnScrollListener() {

        final Gallery this$0;

        public void onPageChanged(int i)
        {
            mPanel.selectDot(i, true);
        }

        public void onScroll(int i)
        {
        }

        public void onViewScrollFinished(int i)
        {
            mPanel.selectDot(i, false);
        }

            
            {
                this$0 = Gallery.this;
                super();
            }
    };
    private GalleryPanel mPanel;
    private PinchImageView mPinchImage;

    public Gallery(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mContext = context;
    }

    private View makeImageViewWithImage(Bitmap bitmap)
    {
        ImageView imageview = new ImageView(mContext);
        imageview.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        imageview.setAdjustViewBounds(true);
        imageview.setBackgroundColor(getResources().getColor(0x7f0d0083));
        imageview.setImageBitmap(bitmap);
        if (!(mContext instanceof FullScreenGalleryActivity))
        {
            imageview.setOnClickListener(new android.view.View.OnClickListener() {

                final Gallery this$0;

                public void onClick(View view)
                {
                    setVisibility(4);
                }

            
            {
                this$0 = Gallery.this;
                super();
            }
            });
        }
        return imageview;
    }

    private void removeAllImages()
    {
        removeAllViews();
    }

    public void addImageViewToTheGallery(Bitmap bitmap, int i)
    {
        if (getChildAt(i) == null)
        {
            addView(makeImageViewWithImage(bitmap), i);
        }
    }

    public android.view.View.OnClickListener getOnClickListener()
    {
        return new android.view.View.OnClickListener() {

            final Gallery this$0;

            public void onClick(View view)
            {
                view = ((View) (view.getTag()));
                if (view instanceof Integer)
                {
                    view = (Integer)view;
                    setCurrentPage(view.intValue());
                    mPanel.selectDot(view.intValue(), false);
                    if (getVisibility() == 4)
                    {
                        setVisibility(0);
                        if (mPinchImage != null)
                        {
                            mPinchImage.setVisibility(4);
                        }
                    }
                }
            }

            
            {
                this$0 = Gallery.this;
                super();
            }
        };
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        removeAllImages();
    }

    protected void onVisibilityChanged(View view, int i)
    {
        if (i == 0 && mPanel != null)
        {
            mPanel.selectDot(getCurrentPage(), false);
        }
    }

    public void setPanel(GalleryPanel gallerypanel)
    {
        mPanel = gallerypanel;
        addOnScrollListener(mOnScrollListener);
    }

    public void setPinchImage(PinchImageView pinchimageview)
    {
        mPinchImage = pinchimageview;
    }


}
