// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.ebay.mobile.viewitem.ItemViewPhotoGalleryActivity;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.ebay.android.widget:
//            RemoteImageView

public class ImageViewPager extends FrameLayout
    implements RemoteImageView.OnRemoteImageLoadedListener
{
    public static class ImageViewPagerAdapter extends PagerAdapter
    {

        private ImageViewPager imageViewPager;
        private final com.ebay.nautilus.domain.content.dm.ImageDataManager.UrlRewriterType urlRewriterType;
        private final List viewContentUris;

        public void destroyItem(ViewGroup viewgroup, int i, Object obj)
        {
            obj = (View)obj;
            if (obj != null)
            {
                if (obj instanceof RemoteImageView)
                {
                    ((RemoteImageView)obj).setOnRemoteImageLoadedListener(null);
                }
                ((View) (obj)).setOnClickListener(null);
                viewgroup.removeView(((View) (obj)));
            }
        }

        public void finishUpdate(ViewGroup viewgroup)
        {
        }

        public int getCount()
        {
            return viewContentUris.size();
        }

        public Object instantiateItem(ViewGroup viewgroup, int i)
        {
            String s = (String)viewContentUris.get(i);
            final Context context = viewgroup.getContext();
            RemoteImageView remoteimageview = new RemoteImageView(context);
            if (imageViewPager != null)
            {
                remoteimageview.setOnRemoteImageLoadedListener(imageViewPager);
            }
            remoteimageview.setTag(Integer.valueOf(i));
            remoteimageview.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            remoteimageview.setUrlRewriter(urlRewriterType);
            remoteimageview.setAverageBackgroundColor(true);
            remoteimageview.setFadeInAnimation(100);
            remoteimageview.setRemoteImageUrl(s);
            remoteimageview.setOnClickListener(i. new android.view.View.OnClickListener() {

                final ImageViewPagerAdapter this$0;
                final Context val$context;
                final int val$imagePosition;

                public void onClick(View view)
                {
                    if (context instanceof Activity)
                    {
                        ItemViewPhotoGalleryActivity.StartActivity((Activity)context, Integer.valueOf(imagePosition), viewContentUris);
                    }
                }

            
            {
                this$0 = final_imageviewpageradapter;
                context = context1;
                imagePosition = I.this;
                super();
            }
            });
            viewgroup.addView(remoteimageview);
            return remoteimageview;
        }

        public boolean isViewFromObject(View view, Object obj)
        {
            return view == obj;
        }

        public void setImageViewPager(ImageViewPager imageviewpager)
        {
            imageViewPager = imageviewpager;
        }

        public void startUpdate(ViewGroup viewgroup)
        {
        }


        public ImageViewPagerAdapter(List list, com.ebay.nautilus.domain.content.dm.ImageDataManager.UrlRewriterType urlrewritertype)
        {
            viewContentUris = Collections.unmodifiableList(list);
            urlRewriterType = urlrewritertype;
        }
    }

    public static interface OnImageLoadedListener
    {

        public abstract void onImageLoaded(String s, int i);
    }


    private static final int PARENT_SCROLL_INTERRUPT_THRESHOLD = 5;
    protected TextView collectionBounds;
    protected ViewPager imagePager;
    private OnImageLoadedListener onImageLoadedListener;

    public ImageViewPager(Context context)
    {
        super(context);
        initializeLayout();
    }

    public ImageViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        initializeLayout();
    }

    public PagerAdapter getAdapter()
    {
        if (imagePager == null)
        {
            return null;
        } else
        {
            return imagePager.getAdapter();
        }
    }

    protected void initializeLayout()
    {
        LayoutInflater.from(getContext()).inflate(0x7f030129, this);
        imagePager = (ViewPager)findViewById(0x7f1001f3);
        collectionBounds = (TextView)findViewById(0x7f1002ea);
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        imagePager.setOnTouchListener(new android.view.View.OnTouchListener() {

            final ImageViewPager this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                boolean flag = false;
                boolean flag1;
                if (motionevent.getHistorySize() > 0)
                {
                    if (Math.abs(motionevent.getHistoricalX(0) - motionevent.getX()) > 5F)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                }
                flag1 = imagePager.onTouchEvent(motionevent);
                if (flag1 && flag)
                {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                return flag1;
            }

            
            {
                this$0 = ImageViewPager.this;
                super();
            }
        });
        imagePager.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final ImageViewPager this$0;

            public void onPageScrollStateChanged(int i)
            {
            }

            public void onPageScrolled(int i, float f, int j)
            {
            }

            public void onPageSelected(int i)
            {
                setCollectionBounds(i, imagePager.getAdapter().getCount());
            }

            
            {
                this$0 = ImageViewPager.this;
                super();
            }
        });
    }

    protected void onDetachedFromWindow()
    {
        imagePager.setOnTouchListener(null);
        imagePager.setOnPageChangeListener(null);
        super.onDetachedFromWindow();
    }

    public void onRemoteImageLoaded(RemoteImageView remoteimageview, String s)
    {
        remoteimageview = (Integer)remoteimageview.getTag();
        if (onImageLoadedListener != null && remoteimageview != null)
        {
            onImageLoadedListener.onImageLoaded(s, remoteimageview.intValue());
        }
    }

    public void setAdapter(ImageViewPagerAdapter imageviewpageradapter)
    {
        PagerAdapter pageradapter = imagePager.getAdapter();
        if (pageradapter != null && (pageradapter instanceof ImageViewPagerAdapter))
        {
            ((ImageViewPagerAdapter)pageradapter).setImageViewPager(null);
        }
        imagePager.setAdapter(imageviewpageradapter);
        if (imageviewpageradapter != null)
        {
            imageviewpageradapter.setImageViewPager(this);
        }
        int i;
        if (imageviewpageradapter != null)
        {
            i = imageviewpageradapter.getCount();
        } else
        {
            i = 0;
        }
        setCollectionBounds(imagePager.getCurrentItem(), i);
    }

    protected void setCollectionBounds(int i, int j)
    {
        boolean flag = false;
        if (collectionBounds != null)
        {
            if (j > 1)
            {
                collectionBounds.setText(getContext().getString(0x7f0704c3, new Object[] {
                    Integer.valueOf(i + 1), Integer.valueOf(j)
                }));
            }
            TextView textview = collectionBounds;
            if (j > 1)
            {
                i = ((flag) ? 1 : 0);
            } else
            {
                i = 4;
            }
            textview.setVisibility(i);
        }
    }

    public void setOnImageLoadedListener(OnImageLoadedListener onimageloadedlistener)
    {
        onImageLoadedListener = onimageloadedlistener;
    }
}
