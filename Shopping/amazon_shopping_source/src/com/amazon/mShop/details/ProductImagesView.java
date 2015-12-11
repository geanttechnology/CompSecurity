// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.DelayedInitView;
import com.amazon.mShop.ObjectSubscriberAdapter;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.imageview.MShopScaleGestoreDetector;
import com.amazon.mShop.net.BitmapFetcher;
import com.amazon.mShop.ui.DrawableFactory;
import com.amazon.mShop.ui.WeakReferenceBitmapDrawable;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.MultiImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.details:
//            GalleryPinchImageView, CustomizedGallery

public class ProductImagesView extends LinearLayout
    implements android.widget.AdapterView.OnItemSelectedListener, com.amazon.mShop.AmazonActivity.OnConfigurationChangedListener, DelayedInitView, TitleProvider
{
    public class GalleryDelayImages
        implements com.amazon.mShop.net.HttpFetcher.Subscriber
    {

        private boolean mFirstImageReceived;
        private int mImageTotalCount;
        private List mImages;
        private final List mListeners = new ArrayList();
        private final int mMaxImageDimension;
        final ProductImagesView this$0;

        private void initWithPreviewMainImage(String s, int i)
        {
            if (!Util.isEmpty(s))
            {
                (new BitmapFetcher(s, Integer.valueOf(i), Integer.valueOf(0), new com.amazon.mShop.net.HttpFetcher.Subscriber() {

                    final GalleryDelayImages this$1;

                    public void onHttpRequestFailed(com.amazon.mShop.net.HttpFetcher.Params params)
                    {
                    }

                    public void onHttpResponseReceived(Bitmap bitmap, com.amazon.mShop.net.HttpFetcher.Params params)
                    {
                        if (!mFirstImageReceived)
                        {
                            bitmap = DrawableFactory.getInstance().createDrawable(getResources(), bitmap, params);
                            mImages.add(bitmap);
                            onImageReceived(bitmap, 0);
                        }
                    }

                    public volatile void onHttpResponseReceived(Object obj, com.amazon.mShop.net.HttpFetcher.Params params)
                    {
                        onHttpResponseReceived((Bitmap)obj, params);
                    }

            
            {
                this$1 = GalleryDelayImages.this;
                super();
            }
                })).fetch();
            }
        }

        public void addGalleryImageItemsListener(ImageAdapter imageadapter)
        {
            mListeners.add(imageadapter);
        }

        public int getCount()
        {
            return mImages.size();
        }

        public Drawable getImage(int i)
        {
            return (Drawable)mImages.get(i);
        }

        public void onHttpRequestFailed(com.amazon.mShop.net.HttpFetcher.Params params)
        {
            Log.v(ProductImagesView.TAG, "fetching image failed.");
        }

        public void onHttpResponseReceived(Bitmap bitmap, com.amazon.mShop.net.HttpFetcher.Params params)
        {
            if (!mFirstImageReceived)
            {
                mFirstImageReceived = true;
                if (mKeepImageOrder)
                {
                    Drawable drawable = DrawableFactory.getInstance().getDefaultDrawable(getResources());
                    for (int i = mImages.size(); i < mImageTotalCount; i++)
                    {
                        mImages.add(drawable);
                        addThumbnail(drawable, i);
                    }

                }
            }
            int j = ((Integer)params.getTag()).intValue();
            bitmap = DrawableFactory.getInstance().createDrawable(getResources(), bitmap, params);
            if (mKeepImageOrder)
            {
                mImages.set(j, bitmap);
            } else
            {
                mImages.add(bitmap);
            }
            if ((mStartIndex == -1 || mStartIndex == j) && mProgressBar.getVisibility() == 0)
            {
                mProgressBar.setVisibility(8);
                mMainGallery.setVisibility(0);
            }
            onImageReceived(bitmap, j);
        }

        public volatile void onHttpResponseReceived(Object obj, com.amazon.mShop.net.HttpFetcher.Params params)
        {
            onHttpResponseReceived((Bitmap)obj, params);
        }

        public void onImageReceived(Drawable drawable, int i)
        {
            for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((ImageAdapter)iterator.next()).onImageReceived(drawable, i)) { }
        }

        public void requestImage(String s, int i)
        {
            if (s != null)
            {
                (new BitmapFetcher(s, Integer.valueOf(mMaxImageDimension), Integer.valueOf(i), this)).fetch();
            }
        }

        public void setMultiImages(List list, String s, int i)
        {
            initWithPreviewMainImage(s, i);
            i = 0;
            Iterator iterator = list.iterator();
            do
            {
                int j;
label0:
                {
                    j = i;
                    if (iterator.hasNext())
                    {
                        MultiImage multiimage = (MultiImage)iterator.next();
                        s = multiimage.getHiresUrl();
                        list = s;
                        if (Util.isEmpty(s))
                        {
                            list = multiimage.getStandardUrl();
                        }
                        j = i + 1;
                        requestImage(list, i);
                        if (j != 7)
                        {
                            break label0;
                        }
                    }
                    mImageTotalCount = j;
                    return;
                }
                i = j;
            } while (true);
        }



        public GalleryDelayImages()
        {
            this$0 = ProductImagesView.this;
            super();
            mFirstImageReceived = false;
            mMaxImageDimension = UIUtils.getPortraitWidth(getContext()) - getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.product_images_spacing);
            mImages = new ArrayList();
        }
    }

    private class GestureListener extends android.view.GestureDetector.SimpleOnGestureListener
    {

        final ProductImagesView this$0;

        public boolean onDoubleTap(MotionEvent motionevent)
        {
            if (mMainGallery.getVisibility() == 0)
            {
                mPinchImage.setBackendResource();
                mMainGallery.setVisibility(4);
                mPinchImage.setVisibility(0);
            }
            mPinchImage.zoomTo(mPinchImage.onDoubleTapPost(mPinchImage.getScale(), 4F), motionevent.getX(), motionevent.getY());
            ((CustomizedGallery)mMainGallery).logImageZoomedRefMarker();
            return true;
        }

        private GestureListener()
        {
            this$0 = ProductImagesView.this;
            super();
        }

    }

    private class ImageAdapter extends ObjectSubscriberAdapter
    {

        final ProductImagesView this$0;

        public int getCount()
        {
            return mGalleryDelayImages.getCount();
        }

        public Drawable getItem(int i)
        {
            return mGalleryDelayImages.getImage(i);
        }

        public volatile Object getItem(int i)
        {
            return getItem(i);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (view instanceof ImageView)
            {
                viewgroup = (ImageView)view;
                view = viewgroup;
                if (Integer.valueOf(i).equals(viewgroup.getTag()))
                {
                    return viewgroup;
                }
            } else
            {
                view = new ImageView(getContext());
                view.setAdjustViewBounds(true);
                view.setFocusable(false);
                view.setLayoutParams(new android.widget.Gallery.LayoutParams(-1, -2));
                view.setTag(Integer.valueOf(i));
            }
            setDrawableForImageView(getItem(i), view, false);
            return view;
        }

        public void onImageReceived(Drawable drawable, int i)
        {
            notifyDataSetChanged();
            addThumbnail(drawable, i);
            if (mGestureDetector == null)
            {
                mGestureDetector = new GestureDetector(getContext(), new GestureListener());
                if (Integer.parseInt(android.os.Build.VERSION.SDK) >= 8)
                {
                    mScaleDetector = MShopScaleGestoreDetector.newInstance(getContext(), new ScaleListener());
                } else
                {
                    mScaleDetector = MShopScaleGestoreDetector.newInstance(getContext(), null);
                }
                mMainGallery.setOnTouchListener(onTouchListener);
                if (mStartIndex == -1)
                {
                    setSelectedState(0, MoveAction.CLICK);
                    mMainGallery.setSelection(0);
                }
            }
            if (mStartIndex == i)
            {
                setSelectedState(mStartIndex, MoveAction.CLICK);
                mMainGallery.setSelection(mStartIndex);
            }
        }

        public ImageAdapter(AmazonActivity amazonactivity)
        {
            this$0 = ProductImagesView.this;
            super(amazonactivity);
        }
    }

    public static final class MoveAction extends Enum
    {

        private static final MoveAction $VALUES[];
        public static final MoveAction CLICK;
        public static final MoveAction LEFT;
        public static final MoveAction RIGHT;

        public static MoveAction valueOf(String s)
        {
            return (MoveAction)Enum.valueOf(com/amazon/mShop/details/ProductImagesView$MoveAction, s);
        }

        public static MoveAction[] values()
        {
            return (MoveAction[])$VALUES.clone();
        }

        static 
        {
            CLICK = new MoveAction("CLICK", 0);
            LEFT = new MoveAction("LEFT", 1);
            RIGHT = new MoveAction("RIGHT", 2);
            $VALUES = (new MoveAction[] {
                CLICK, LEFT, RIGHT
            });
        }

        private MoveAction(String s, int i)
        {
            super(s, i);
        }
    }

    private class ScaleListener extends android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
    {

        final ProductImagesView this$0;

        public boolean onScale(ScaleGestureDetector scalegesturedetector)
        {
            if (mMainGallery.getVisibility() == 0)
            {
                if (scalegesturedetector.getScaleFactor() <= 1.0F)
                {
                    return false;
                }
                mPinchImage.setBackendResource();
                mPinchImage.setVisibility(0);
                mMainGallery.setVisibility(4);
            }
            mPinchImage.updateScale(scalegesturedetector);
            return true;
        }

        private ScaleListener()
        {
            this$0 = ProductImagesView.this;
            super();
        }

    }


    private static final String TAG = com/amazon/mShop/details/ProductImagesView.getSimpleName();
    private final AmazonActivity amazonActivity;
    private GalleryDelayImages mGalleryDelayImages;
    private GestureDetector mGestureDetector;
    private final ImageAdapter mImageAdapter;
    private final boolean mKeepImageOrder = true;
    private int mLastOrientation;
    private Gallery mMainGallery;
    private List mMultiImages;
    private GalleryPinchImageView mPinchImage;
    private View mProgressBar;
    private com.amazon.mShop.imageview.MShopScaleGestoreDetector.VersionedGestureDetector mScaleDetector;
    private HorizontalScrollView mScrollView;
    private int mStartIndex;
    private ViewGroup mThumbnails;
    private String mTitle;
    private final android.view.View.OnTouchListener onTouchListener = new android.view.View.OnTouchListener() {

        final ProductImagesView this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            if (ConfigUtils.isEnabledForApp(getContext(), com.amazon.mShop.android.lib.R.bool.config_isSupportPinchZoom))
            {
                mScaleDetector.onTouchEvent(motionevent);
                if (!mScaleDetector.isInProgress())
                {
                    mGestureDetector.onTouchEvent(motionevent);
                }
            } else
            {
                mGestureDetector.onTouchEvent(motionevent);
            }
            if (mPinchImage.getVisibility() != 4 || motionevent.getPointerCount() > 1)
            {
                return true;
            } else
            {
                view.onTouchEvent(motionevent);
                return true;
            }
        }

            
            {
                this$0 = ProductImagesView.this;
                super();
            }
    };

    public ProductImagesView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mStartIndex = -1;
        amazonActivity = (AmazonActivity)context;
        mImageAdapter = new ImageAdapter(amazonActivity);
        mGalleryDelayImages = new GalleryDelayImages();
    }

    private void addThumbnail(Drawable drawable, int i)
    {
        ImageView imageview = new ImageView(getContext());
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-1, -1);
        layoutparams.bottomMargin = (int)getResources().getDimension(com.amazon.mShop.android.lib.R.dimen.carousel_list_item_underline_height);
        imageview.setLayoutParams(layoutparams);
        setDrawableForImageView(drawable, imageview, true);
        drawable = new LinearLayout(getContext());
        drawable.setBackgroundResource(com.amazon.mShop.android.lib.R.color.product_detail_gallery_image_selector);
        drawable.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        drawable.addView(imageview);
        drawable.setFocusable(true);
        drawable.setClickable(true);
        drawable.setOnClickListener(new android.view.View.OnClickListener() {

            final ProductImagesView this$0;

            public void onClick(View view)
            {
                if (view.isSelected()) goto _L2; else goto _L1
_L1:
                int j;
                boolean flag;
                if (mProgressBar.getVisibility() == 0)
                {
                    mProgressBar.setVisibility(8);
                }
                mPinchImage.setVisibility(4);
                mMainGallery.setVisibility(0);
                flag = false;
                j = 0;
_L8:
                int k = ((flag) ? 1 : 0);
                if (j >= mThumbnails.getChildCount()) goto _L4; else goto _L3
_L3:
                if (mThumbnails.getChildAt(j) != view) goto _L6; else goto _L5
_L5:
                k = j;
_L4:
                setSelectedState(view, MoveAction.CLICK);
                mMainGallery.setSelection(k, true);
_L2:
                return;
_L6:
                j++;
                if (true) goto _L8; else goto _L7
_L7:
            }

            
            {
                this$0 = ProductImagesView.this;
                super();
            }
        });
        if (!mKeepImageOrder || mThumbnails.getChildCount() <= i)
        {
            mThumbnails.addView(drawable);
            return;
        } else
        {
            mThumbnails.removeViewAt(i);
            mThumbnails.addView(drawable, i);
            return;
        }
    }

    private List cloneMultiImages(List list)
    {
        ArrayList arraylist = new ArrayList();
        MultiImage multiimage1;
        for (list = list.iterator(); list.hasNext(); arraylist.add(multiimage1))
        {
            MultiImage multiimage = (MultiImage)list.next();
            multiimage1 = new MultiImage();
            multiimage1.setStandardUrl(((MultiImage)multiimage).getStandardUrl());
            multiimage1.setHiresUrl(((MultiImage)multiimage).getHiresUrl());
        }

        return arraylist;
    }

    private void setDrawableForImageView(Drawable drawable, ImageView imageview, boolean flag)
    {
        Bitmap bitmap;
        Object obj;
        Object obj1;
        obj1 = null;
        bitmap = obj1;
        obj = drawable;
        if (!flag) goto _L2; else goto _L1
_L1:
        if (!(drawable instanceof WeakReferenceBitmapDrawable)) goto _L4; else goto _L3
_L3:
        drawable = ((WeakReferenceBitmapDrawable)drawable).getBitmap();
        bitmap = Bitmap.createScaledBitmap(drawable, drawable.getWidth() / 8, drawable.getHeight() / 8, false);
        obj = new BitmapDrawable(getResources(), bitmap);
_L2:
        imageview.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
        imageview.setImageDrawable(((Drawable) (obj)));
        if (flag && bitmap != null)
        {
            int j;
            try
            {
                int k = getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.padding_smallest);
                int l = Math.max(bitmap.getHeight(), bitmap.getWidth());
                int i = (l - bitmap.getWidth()) / 2 + k;
                k = (l - bitmap.getHeight()) / 2 + k;
                imageview.setPadding(i, k, i, k);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Drawable drawable)
            {
                Log.e("AmazonActivity", (new StringBuilder()).append("could not decode image: ").append(drawable).toString());
            }
            break MISSING_BLOCK_LABEL_269;
        }
        break MISSING_BLOCK_LABEL_218;
_L4:
        bitmap = obj1;
        obj = drawable;
        if (!(drawable instanceof BitmapDrawable)) goto _L2; else goto _L5
_L5:
        drawable = ((BitmapDrawable)drawable).getBitmap();
        bitmap = Bitmap.createScaledBitmap(drawable, drawable.getWidth() / 8, drawable.getHeight() / 8, false);
        obj = new BitmapDrawable(getResources(), bitmap);
          goto _L2
        j = getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.product_gallery_images_padding);
        imageview.setPadding(j, 0, j, 0);
        return;
        imageview.setImageDrawable(DrawableFactory.getInstance().getDefaultDrawable(getResources()));
        imageview.setTag(null);
        return;
    }

    private void setProductImages(List list)
    {
        setProductImages(list, null, 0);
    }

    private void setProductImages(List list, String s, int i)
    {
        mMultiImages = cloneMultiImages(list);
        mGalleryDelayImages.addGalleryImageItemsListener(mImageAdapter);
        mGalleryDelayImages.setMultiImages(mMultiImages, s, i);
    }

    public volatile CharSequence getTitle()
    {
        return getTitle();
    }

    public String getTitle()
    {
        String s1 = mTitle;
        String s = s1;
        if (Util.isEmpty(s1))
        {
            s = getResources().getString(com.amazon.mShop.android.lib.R.string.product_details);
        }
        return s;
    }

    public void handleConfigurationChanged(Configuration configuration)
    {
        if (2 == configuration.orientation)
        {
            mThumbnails.setVisibility(8);
        } else
        {
            mThumbnails.setVisibility(0);
        }
        if (mLastOrientation != configuration.orientation && mPinchImage != null && mPinchImage.getVisibility() == 0)
        {
            mMainGallery.setVisibility(0);
            mPinchImage.setVisibility(4);
            mPinchImage.clear();
        }
        mLastOrientation = configuration.orientation;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        amazonActivity.registerConfigChangedListener(this);
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        amazonActivity.unregisterConfigChangedListener(this);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mMainGallery = (Gallery)findViewById(com.amazon.mShop.android.lib.R.id.images);
        mThumbnails = (ViewGroup)findViewById(com.amazon.mShop.android.lib.R.id.product_images_group);
        mProgressBar = findViewById(com.amazon.mShop.android.lib.R.id.product_images_view_progressbar);
        handleConfigurationChanged(amazonActivity.getResources().getConfiguration());
        mMainGallery.setHapticFeedbackEnabled(false);
        mMainGallery.setSoundEffectsEnabled(false);
        mMainGallery.setAdapter(mImageAdapter);
        mMainGallery.setOnItemSelectedListener(this);
        ((CustomizedGallery)mMainGallery).setCallbackDuringFling(false);
        mPinchImage = (GalleryPinchImageView)findViewById(com.amazon.mShop.android.lib.R.id.pinch_image);
        mPinchImage.setGallery(mMainGallery);
        mScrollView = (HorizontalScrollView)findViewById(com.amazon.mShop.android.lib.R.id.product_images_group_container);
    }

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        mMainGallery.postDelayed(new Runnable() {

            final ProductImagesView this$0;

            public void run()
            {
                setSelectedState(mMainGallery.getSelectedItemPosition(), ((CustomizedGallery)mMainGallery).getAction());
            }

            
            {
                this$0 = ProductImagesView.this;
                super();
            }
        }, 250L);
        ((CustomizedGallery)mMainGallery).logImageViewedRefMarker();
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    public void onPushViewCompleted()
    {
        if (mGalleryDelayImages != null && mGalleryDelayImages.mImages.size() == 0)
        {
            mMainGallery.setVisibility(8);
            mProgressBar.setVisibility(0);
        }
    }

    public void setImagesAndTitle(String s, List list)
    {
        mTitle = s;
        setProductImages(list);
    }

    public void setProductController(ProductController productcontroller)
    {
        mTitle = productcontroller.getTitle();
        setProductImages(productcontroller.getMultiImages(), productcontroller.getImageUrl(), productcontroller.getMaxImageDimension());
    }

    public void setSelectedState(int i, MoveAction moveaction)
    {
        setSelectedState(mThumbnails.getChildAt(i), moveaction);
    }

    public void setSelectedState(View view, MoveAction moveaction)
    {
        for (int i = 0; i < mThumbnails.getChildCount(); i++)
        {
            if (mThumbnails.getChildAt(i).isSelected())
            {
                mThumbnails.getChildAt(i).setSelected(false);
            }
        }

        if (view != null)
        {
            view.setSelected(true);
            Rect rect = new Rect();
            view.getLocalVisibleRect(rect);
            if (moveaction == MoveAction.LEFT && (rect.right - rect.left < view.getWidth() || rect.left < 0))
            {
                mScrollView.scrollBy(-view.getWidth(), 0);
            } else
            if (moveaction == MoveAction.RIGHT && rect.right - rect.left < view.getWidth())
            {
                mScrollView.scrollBy(view.getWidth(), 0);
                return;
            }
        }
    }

    public void setStartIndex(int i)
    {
        mStartIndex = i;
    }













/*
    static GestureDetector access$402(ProductImagesView productimagesview, GestureDetector gesturedetector)
    {
        productimagesview.mGestureDetector = gesturedetector;
        return gesturedetector;
    }

*/



/*
    static com.amazon.mShop.imageview.MShopScaleGestoreDetector.VersionedGestureDetector access$602(ProductImagesView productimagesview, com.amazon.mShop.imageview.MShopScaleGestoreDetector.VersionedGestureDetector versionedgesturedetector)
    {
        productimagesview.mScaleDetector = versionedgesturedetector;
        return versionedgesturedetector;
    }

*/


}
