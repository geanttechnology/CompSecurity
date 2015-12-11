// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.callbacks.OnDealImageEventListener;
import com.groupon.models.nst.DealImageCarouselMetadata;
import com.groupon.util.ImageUrl;
import com.groupon.util.LoggingUtils;
import com.squareup.picasso.Callback;
import java.util.ArrayList;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.view:
//            UrlImageView

public class DealImageView extends FrameLayout
    implements Callback
{
    private class OnDealImageViewTouchListener
        implements android.view.View.OnTouchListener
    {

        final DealImageView this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            if (rotationRunning)
            {
                userInteractedWithImageView = true;
                doStopImageRotation();
            }
            if (onDealImageEventListener != null)
            {
                onDealImageEventListener.onUserInteraction();
            }
            return false;
        }

        private OnDealImageViewTouchListener()
        {
            this$0 = DealImageView.this;
            super();
        }

    }

    private class RotateImageRunnable
        implements Runnable
    {

        final DealImageView this$0;

        public void run()
        {
            if (imageCarouselPosition < imageCount)
            {
                if (imagePager.getLocalVisibleRect(scrollBounds))
                {
                    imagePager.setCurrentItem(int i = this.access$1702 + 1);
                }
                handler.postDelayed(this, DealImageView.ROTATION_INTERVAL_IN_MS);
                return;
            } else
            {
                handler.removeCallbacks(this);
                rotationRunning = false;
                return;
            }
        }

        private RotateImageRunnable()
        {
            this$0 = DealImageView.this;
            super();
        }

    }

    protected static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public SavedState[] newArray(int i)
            {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        protected int currentPosition;

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeInt(currentPosition);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            currentPosition = parcel.readInt();
        }


        protected SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }


    private static int ROTATION_INTERVAL_IN_MS = 4000;
    private Channel channel;
    private Context context;
    private String dealId;
    private RelativeLayout dealImageBadge;
    private String dealTitle;
    private Handler handler;
    private int imageCarouselPosition;
    private int imageCount;
    private TextView imageNumberView;
    private ViewPager imagePager;
    private List imageUrls;
    private IntentFactory intentFactory;
    private LoggingUtils loggingUtils;
    private OnDealImageEventListener onDealImageEventListener;
    private RotateImageRunnable rotateImage;
    private boolean rotationRunning;
    private Rect scrollBounds;
    private boolean userInteractedWithImageView;

    public DealImageView(Context context1)
    {
        this(context1, null, 0);
    }

    public DealImageView(Context context1, AttributeSet attributeset)
    {
        this(context1, attributeset, 0);
    }

    public DealImageView(Context context1, AttributeSet attributeset, int i)
    {
        super(context1, attributeset, i);
        imageCarouselPosition = 0;
        LayoutInflater.from(getContext()).inflate(0x7f0300c2, this, true);
        RoboGuice.getInjector(context1).injectMembers(this);
        context = context1;
        imagePager = (ViewPager)findViewById(0x7f10024d);
        imageNumberView = (TextView)findViewById(0x7f10024f);
        dealImageBadge = (RelativeLayout)findViewById(0x7f10024e);
        scrollBounds = new Rect();
        getRootView().getHitRect(scrollBounds);
        setOnPageChangeListener();
    }

    private void setOnPageChangeListener()
    {
        android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener = new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final DealImageView this$0;

            public void onPageScrollStateChanged(int i)
            {
            }

            public void onPageScrolled(int i, float f, int j)
            {
            }

            public void onPageSelected(int i)
            {
                imageCarouselPosition = i;
                if (onDealImageEventListener != null)
                {
                    onDealImageEventListener.onImageChange(i);
                }
                loggingUtils.logImpression("", "deal_image", "deal_details", (new StringBuilder()).append(i + 1).append(":").append(imageUrls.size()).toString(), new DealImageCarouselMetadata(channel));
            }

            
            {
                this$0 = DealImageView.this;
                super();
            }
        };
        imagePager.setOnPageChangeListener(onpagechangelistener);
    }

    public void doStartImageRotation()
    {
        if (!rotationRunning && !userInteractedWithImageView)
        {
            rotateImage = new RotateImageRunnable();
            handler.postDelayed(rotateImage, ROTATION_INTERVAL_IN_MS);
            rotationRunning = true;
        }
    }

    public void doStopImageRotation()
    {
        if (rotationRunning)
        {
            handler.removeCallbacks(rotateImage);
            rotationRunning = false;
        }
    }

    public void onError(ImageView imageview)
    {
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
label0:
        {
            if (parcelable != null)
            {
                if (!(parcelable instanceof SavedState))
                {
                    break label0;
                }
                parcelable = (SavedState)parcelable;
                super.onRestoreInstanceState(parcelable.getSuperState());
                imageCarouselPosition = ((SavedState) (parcelable)).currentPosition;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.currentPosition = imagePager.getCurrentItem();
        return savedstate;
    }

    public void onSuccess(ImageView imageview)
    {
        Ln.d("PAGER: onImageLoaded %s, size=%s x %s", new Object[] {
            imageview, Integer.valueOf(imageview.getWidth()), Integer.valueOf(imageview.getHeight())
        });
    }

    public DealImageView setChannel(Channel channel1)
    {
        channel = channel1;
        return this;
    }

    public DealImageView setCurrentItem(int i)
    {
        imageCarouselPosition = i;
        imagePager.setCurrentItem(i);
        return this;
    }

    public DealImageView setDealId(String s)
    {
        dealId = s;
        return this;
    }

    public void setDealImageHeight(float f)
    {
        imagePager.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, (int)TypedValue.applyDimension(1, f, getResources().getDisplayMetrics())));
    }

    public DealImageView setDealTitle(String s)
    {
        dealTitle = s;
        return this;
    }

    public DealImageView setImageUrls(List list)
    {
        imageUrls = list;
        int i;
        if (list != null)
        {
            i = list.size();
        } else
        {
            i = 0;
        }
        imageCount = i;
        return this;
    }

    public DealImageView setOnDealImageEventListener(OnDealImageEventListener ondealimageeventlistener)
    {
        onDealImageEventListener = ondealimageeventlistener;
        return this;
    }

    public DealImageView setupImagePager(final Callback callback)
    {
        callback = new PagerAdapter() {

            final DealImageView this$0;
            final Callback val$callback;

            public void destroyItem(ViewGroup viewgroup, int i, Object obj)
            {
                obj = (View)obj;
                Ln.d("PAGER: destroy %s: %s", new Object[] {
                    Integer.valueOf(i), obj
                });
                ((UrlImageView)obj).clearImage();
                viewgroup.removeView(((View) (obj)));
            }

            public int getCount()
            {
                return imageCount;
            }

            public Object instantiateItem(ViewGroup viewgroup, int i)
            {
                UrlImageView urlimageview = new UrlImageView(context);
                urlimageview.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
                ImageUrl imageurl = (ImageUrl)imageUrls.get(i);
                Ln.d("PAGER: instantiate %s: %s", new Object[] {
                    Integer.valueOf(i), urlimageview
                });
                if (callback != null)
                {
                    urlimageview.setCallback(callback);
                }
                urlimageview.setImageUrl(imageurl);
                urlimageview.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final _cls1 this$1;
                    final int val$position;

                    public void onClick(View view)
                    {
                        ((Activity)context).startActivityForResult(intentFactory.newDealImageCarouselIntent((ArrayList)imageUrls, position, dealId, channel, dealTitle), 10149);
                    }

            
            {
                this$1 = final__pcls1;
                position = I.this;
                super();
            }
                });
                urlimageview.setOnTouchListener(new OnDealImageViewTouchListener());
                viewgroup.addView(urlimageview, 0);
                return urlimageview;
            }

            public boolean isViewFromObject(View view, Object obj)
            {
                return view == obj;
            }

            
            {
                this$0 = DealImageView.this;
                callback = callback1;
                super();
            }
        };
        imagePager.setAdapter(callback);
        imagePager.setCurrentItem(imageCarouselPosition);
        loggingUtils.logImpression("", "deal_image", "deal_details", (new StringBuilder()).append(imageCarouselPosition + 1).append(":").append(imageCount).toString(), new DealImageCarouselMetadata(channel));
        updateImageControls();
        return this;
    }

    protected void updateImageControls()
    {
        if (imageCount > 1)
        {
            imageNumberView.setText(String.valueOf(imageCount));
            dealImageBadge.setVisibility(0);
        }
    }











/*
    static boolean access$1702(DealImageView dealimageview, boolean flag)
    {
        dealimageview.rotationRunning = flag;
        return flag;
    }

*/


/*
    static boolean access$1802(DealImageView dealimageview, boolean flag)
    {
        dealimageview.userInteractedWithImageView = flag;
        return flag;
    }

*/








/*
    static int access$802(DealImageView dealimageview, int i)
    {
        dealimageview.imageCarouselPosition = i;
        return i;
    }

*/


/*
    static int access$804(DealImageView dealimageview)
    {
        int i = dealimageview.imageCarouselPosition + 1;
        dealimageview.imageCarouselPosition = i;
        return i;
    }

*/

}
