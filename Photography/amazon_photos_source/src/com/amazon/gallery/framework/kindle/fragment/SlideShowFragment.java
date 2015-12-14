// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.Loader;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import com.amazon.gallery.foundation.touch.EnhancedGestureDetector;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.gallery.widget.AbstractCoverViewFactory;
import com.amazon.gallery.framework.gallery.widget.MediaItemCursorAdapter;
import com.amazon.gallery.framework.gallery.widget.SingleItemViewFactory;
import com.amazon.gallery.framework.gallery.widget.SlideshowMediaItemCoverViewFactory;
import com.amazon.gallery.framework.gallery.widget.ThumbnailSizeLookUp;
import com.amazon.gallery.framework.gallery.widget.UriViewFactory;
import com.amazon.gallery.framework.gallery.widget.ViewFactory;
import com.amazon.gallery.framework.gallery.widget.holder.ItemViewHolder;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.OnSortingChangedListener;
import com.amazon.gallery.framework.kindle.activity.SlideShowActivity;
import com.amazon.gallery.framework.kindle.amazon.ScreenModeManager;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.framework.kindle.recyclerview.MosaicLayoutCache;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.screensaver.AutoScrollViewPager;
import com.amazon.gallery.framework.screensaver.FadingTransformer;
import com.amazon.gallery.thor.app.FeatureChecker;
import com.amazon.gallery.thor.app.activity.MediaContentConfigurationHolder;
import com.amazon.gallery.thor.app.activity.ThorActionBar;
import com.amazon.gallery.thor.di.AppKeys;
import org.apache.commons.lang3.StringUtils;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            AdapterFragment

public class SlideShowFragment extends AdapterFragment
{
    private class CursorImagePagerAdapter extends PagerAdapter
    {

        final SlideShowFragment this$0;

        public View bindView(int i, View view)
        {
            view = mMediaItemCursorAdapter.getView(i, view, null);
            view.setTag(0x7f0c000d, Integer.valueOf(i));
            ItemViewHolder itemviewholder = (ItemViewHolder)view.getTag();
            if (itemviewholder != null)
            {
                itemviewholder.setResourceReadyListener(new com.amazon.gallery.framework.gallery.widget.holder.ItemViewHolder.ResourceReadyListener() {

                    final CursorImagePagerAdapter this$1;

                    public void onResourceReady(ImageView imageview, Bitmap bitmap)
                    {
                        if (imageview instanceof PhotoView)
                        {
                            startZoomAnimation((PhotoView)imageview, bitmap.getWidth(), bitmap.getHeight());
                        }
                    }

            
            {
                this$1 = CursorImagePagerAdapter.this;
                super();
            }
                });
            }
            return view;
        }

        public void destroyItem(ViewGroup viewgroup, int i, Object obj)
        {
            mViewFactory.onViewDestroy((View)obj);
            viewgroup.removeView((View)obj);
        }

        public int getCount()
        {
            return mMediaItemCursorAdapter.getCount();
        }

        public int getItemPosition(Object obj)
        {
            obj = (MediaItem)((ItemViewHolder)((View)obj).getTag()).getItem();
            Cursor cursor = mMediaItemCursorAdapter.getCursor();
            return getMediaItemPosition(((MediaItem) (obj)).getObjectId(), cursor);
        }

        public Object instantiateItem(ViewGroup viewgroup, int i)
        {
            View view = bindView(i, newView());
            if (view != null)
            {
                viewgroup.addView(view);
            }
            return view;
        }

        public boolean isViewFromObject(View view, Object obj)
        {
            return obj == view;
        }

        public View newView()
        {
            View view = mMediaItemCursorAdapter.newView(getActivity(), null, null);
            Object obj = (ItemViewHolder)view.getTag();
            if (obj != null && (((ItemViewHolder) (obj)).getImageView() instanceof PhotoView))
            {
                obj = (PhotoView)((ItemViewHolder) (obj)).getImageView();
                ((PhotoView) (obj)).setZoomTransitionDuration(5000);
                ((PhotoView) (obj)).setOnTouchListener(((android.view.View.OnTouchListener)((PhotoView) (obj)).getIPhotoViewImplementation()). new android.view.View.OnTouchListener() {

                    final CursorImagePagerAdapter this$1;
                    final android.view.View.OnTouchListener val$photoViewTouchListener;

                    public boolean onTouch(View view, MotionEvent motionevent)
                    {
                        if (!mGestureDetector.onTouchEvent(motionevent))
                        {
                            return photoViewTouchListener.onTouch(view, motionevent);
                        } else
                        {
                            return true;
                        }
                    }

            
            {
                this$1 = final_cursorimagepageradapter;
                photoViewTouchListener = android.view.View.OnTouchListener.this;
                super();
            }
                });
                ((PhotoViewAttacher)((PhotoView) (obj)).getIPhotoViewImplementation()).getImageView().setOnTouchListener(null);
            }
            return view;
        }

        private CursorImagePagerAdapter()
        {
            this$0 = SlideShowFragment.this;
            super();
        }

    }


    private static final String TAG = com/amazon/gallery/framework/kindle/fragment/SlideShowFragment.getName();
    private boolean firstLoad;
    private int mBoundingHeight;
    private int mBoundingWidth;
    private PagerAdapter mEmptyPageAdapter;
    private EnhancedGestureDetector mGestureDetector;
    private android.support.v4.view.ViewPager.OnPageChangeListener mPageChangeListener;
    private AutoScrollViewPager mPager;
    private CursorImagePagerAdapter mPagerAdapter;

    public SlideShowFragment()
    {
        firstLoad = true;
        mPageChangeListener = new android.support.v4.view.ViewPager.SimpleOnPageChangeListener() {

            final SlideShowFragment this$0;

            public void onPageSelected(int i)
            {
                ViewDescriptor viewdescriptor = contentConfiguration.toViewDescriptor();
                viewdescriptor.setFocusedIndex(i);
                viewdescriptor.setCollectionSize(mPagerAdapter.getCount());
            }

            
            {
                this$0 = SlideShowFragment.this;
                super();
            }
        };
        mEmptyPageAdapter = new PagerAdapter() {

            final SlideShowFragment this$0;

            public int getCount()
            {
                return 0;
            }

            public boolean isViewFromObject(View view, Object obj)
            {
                return false;
            }

            
            {
                this$0 = SlideShowFragment.this;
                super();
            }
        };
    }

    private float calculateMinZoom(int i, int j)
    {
        boolean flag1 = true;
        float f1 = 1.5F;
        float f;
        boolean flag;
        if (i >= j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((float)i / (float)j > 3F)
        {
            j = ((flag1) ? 1 : 0);
        } else
        {
            j = 0;
        }
        f = f1;
        if (flag)
        {
            f = f1;
            if (j == 0)
            {
                f = Math.min((float)mPager.getWidth() / (float)i, 1.77F);
            }
        }
        return f;
    }

    private int getMediaItemPosition(ObjectID objectid, Cursor cursor)
    {
        cursor.moveToPosition(-1);
        for (int i = 0; cursor.moveToNext(); i++)
        {
            long l = cursor.getLong(cursor.getColumnIndex("object_id_hi"));
            long l1 = cursor.getLong(cursor.getColumnIndex("object_id_low"));
            if (objectid.getMostSignificantBits() == l && objectid.getLeastSignificantBits() == l1)
            {
                return i;
            }
        }

        return -2;
    }

    private ThumbnailSizeLookUp getThumbnailSizeLookUp()
    {
        MosaicLayoutCache mosaiclayoutcache = (MosaicLayoutCache)getApplicationBean(Keys.MOSAIC_CACHE);
        if (mosaiclayoutcache != null && getResources().getConfiguration().orientation == 2)
        {
            return new com.amazon.gallery.framework.gallery.widget.MosaicItemViewFactory.MosaicThumbnailSizeLookUp(mosaiclayoutcache);
        } else
        {
            return new com.amazon.gallery.framework.gallery.widget.GridItemViewFactory.GridThumbnailSizeLookUp(getActivity());
        }
    }

    private void startZoomAnimation(PhotoView photoview, int i, int j)
    {
        float f2 = calculateMinZoom(i, j);
        float f1 = 2.0F - f2;
        float f = f1;
        if (f1 > 0.4F)
        {
            f = 0.4F;
        }
        f1 = f2 + (float)(Math.random() * (double)f);
        f = f2 + (float)(Math.random() * (double)f);
        GLogger.d(TAG, "Width: %d, height: %d, startScale: %f, endScale: %f", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Float.valueOf(f)
        });
        photoview.setZoomTransitionDuration(12000);
        photoview.setScale(f1);
        photoview.setScale(f, true);
    }

    private void updateBoundingSize()
    {
        if (Api.isAtLeastJellyBeanMR1())
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getRealMetrics(displaymetrics);
            mBoundingHeight = displaymetrics.heightPixels;
            mBoundingWidth = displaymetrics.widthPixels;
            return;
        } else
        {
            DisplayMetrics displaymetrics1 = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics1);
            mBoundingHeight = displaymetrics1.heightPixels;
            mBoundingWidth = displaymetrics1.widthPixels;
            return;
        }
    }

    protected void createActionBar(ViewGroup viewgroup)
    {
    }

    protected void createMediaItemCursorAdapter()
    {
        super.createMediaItemCursorAdapter();
        mMediaItemCursorAdapter.setViewFactory(mViewFactory);
    }

    public int getFirstVisiblePosition()
    {
        return mPager.getCurrentItem();
    }

    protected Bundle getPreloadArgs()
    {
        Intent intent = getActivity().getIntent();
        if (intent.hasExtra("START_POSITION"))
        {
            Bundle bundle = new Bundle();
            bundle.putBoolean("preload", true);
            bundle.putInt("preload_limit", 1);
            bundle.putInt("preload_offset", intent.getIntExtra("START_POSITION", -1));
            return bundle;
        } else
        {
            return null;
        }
    }

    protected OnSortingChangedListener getSortingChangedListener()
    {
        return null;
    }

    protected boolean isInNavBarDecorMode()
    {
        return true;
    }

    protected boolean isValidFragment()
    {
        return contentConfiguration.toViewDescriptor().getCollectionSize() > 0;
    }

    public boolean onBackPressed()
    {
        contentConfiguration.toViewDescriptor().setMediaItem(null);
        return true;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        updateBoundingSize();
        mViewFactory.setBoundingSize(mBoundingWidth, mBoundingHeight);
        mPagerAdapter = new CursorImagePagerAdapter();
        int i = mPager.getCurrentItem();
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(i);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        firstLoad = true;
        mGestureDetector = new EnhancedGestureDetector(getActivity(), new com.amazon.gallery.foundation.touch.EnhancedGestureDetector.EnhancedSimpleOnGestureListener() {

            final SlideShowFragment this$0;

            public boolean onTwoFingerTapUp(MotionEvent motionevent)
            {
                getActivity().onBackPressed();
                return true;
            }

            
            {
                this$0 = SlideShowFragment.this;
                super();
            }
        });
        mFeatureChecker = (FeatureChecker)getApplicationBean(AppKeys.FEATURE_CHECKER);
        updateBoundingSize();
        if (contentConfiguration == null)
        {
            contentConfiguration = ((MediaContentConfigurationHolder)getActivity()).getMediaContentConfiguration();
            bundle = getActivity().getIntent();
            if (bundle != null && bundle.hasExtra("mediaItem"))
            {
                contentConfiguration.toViewDescriptor().setMediaItem((ObjectID)bundle.getSerializableExtra("mediaItem"));
            }
        }
        if (contentConfiguration != null && StringUtils.equals(contentConfiguration.getContentUri().getAuthority(), "com.amazon.gallery.provider.internal"))
        {
            bundle = new SlideshowMediaItemCoverViewFactory();
            bundle.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            bundle = new SingleItemViewFactory(getThumbnailSizeLookUp(), bundle);
            mViewFactory = bundle;
            mViewFactory.setContext(getActivity());
            bundle.setLoadingStatusTracker(mGridStatus);
            createMediaItemCursorAdapter();
        } else
        {
            mViewFactory = new UriViewFactory();
        }
        mViewFactory.setContext(getActivity());
        mViewFactory.setBoundingSize(mBoundingWidth, mBoundingHeight);
        mPagerAdapter = new CursorImagePagerAdapter();
    }

    public View onCreateView(LayoutInflater layoutinflater, final ViewGroup gestureDetector, Bundle bundle)
    {
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f0300dd, gestureDetector, false);
        mPager = (AutoScrollViewPager)layoutinflater.findViewById(0x7f0c0177);
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageMargin((int)getResources().getDimension(0x7f0a0169));
        mPager.setOffscreenPageLimit(1);
        mPager.setOnPageChangeListener(mPageChangeListener);
        mPager.setPageTransformer(false, new FadingTransformer());
        mPager.setInterval(4000L);
        mPager.startAutoScroll();
        gestureDetector = new android.view.GestureDetector.SimpleOnGestureListener() {

            final SlideShowFragment this$0;

            public boolean onSingleTapUp(MotionEvent motionevent)
            {
                if (mScreenModeManager.isFullScreen())
                {
                    exitFullScreen(true);
                } else
                {
                    enterFullScreen(true);
                }
                return false;
            }

            
            {
                this$0 = SlideShowFragment.this;
                super();
            }
        };
        gestureDetector = new GestureDetector(getActivity(), gestureDetector);
        mPager.setOnTouchListener(new android.view.View.OnTouchListener() {

            final SlideShowFragment this$0;
            final GestureDetector val$gestureDetector;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                gestureDetector.onTouchEvent(motionevent);
                return false;
            }

            
            {
                this$0 = SlideShowFragment.this;
                gestureDetector = gesturedetector;
                super();
            }
        });
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mPager.setAdapter(mEmptyPageAdapter);
    }

    public void onLoadFinished(Loader loader, Cursor cursor)
    {
        super.onLoadFinished(loader, cursor);
        mPagerAdapter.notifyDataSetChanged();
        if (!isValidFragment())
        {
            getActivity().finish();
        } else
        {
            int i = -1;
            if (getActivity().getIntent().hasExtra("START_POSITION"))
            {
                firstLoad = true;
                i = getActivity().getIntent().getIntExtra("START_POSITION", 0);
            }
            if (i >= 0 && cursor != null && i < cursor.getCount())
            {
                getActivity().getIntent().removeExtra("START_POSITION");
                mPager.setCurrentItem(i, false);
                if (i == 0)
                {
                    mPageChangeListener.onPageSelected(i);
                }
            }
            if (cursor != null)
            {
                ViewDescriptor viewdescriptor = contentConfiguration.toViewDescriptor();
                ObjectID objectid = viewdescriptor.getMediaItem();
                loader = mMediaItemCursorAdapter.getItem(mPager.getCurrentItem());
                if (MediaItemUtil.isLocalMediaItem(loader))
                {
                    ((SlideShowActivity)getActivity()).setLocalView(true);
                }
                Loader loader1 = loader;
                if (objectid != null)
                {
                    loader1 = loader;
                    if (!objectid.equals(loader.getObjectId()))
                    {
                        int j = getMediaItemPosition(objectid, cursor);
                        if (j >= 0)
                        {
                            mPager.setCurrentItem(j, false);
                            loader = mMediaItemCursorAdapter.getItem(j);
                        }
                        mPageChangeListener.onPageScrollStateChanged(0);
                        loader1 = loader;
                    }
                }
                firstLoad = false;
                viewdescriptor.setMediaItem(loader1.getObjectId());
                viewdescriptor.setMediaItemType(loader1.getType());
                return;
            }
        }
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Cursor)obj);
    }

    protected void onRestoreState(Bundle bundle)
    {
        super.onRestoreState(bundle);
        if (bundle != null)
        {
            getArguments().putInt("START_POSITION", bundle.getInt("START_POSITION"));
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        enterFullScreen(true);
    }

    protected void setUpActionBar(ThorActionBar thoractionbar, int i, int j, OnSortingChangedListener onsortingchangedlistener)
    {
    }





}
