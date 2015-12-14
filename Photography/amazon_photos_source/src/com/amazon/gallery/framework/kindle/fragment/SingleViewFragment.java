// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.Loader;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.touch.EnhancedGestureDetector;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.file.MimeTypeUtil;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.InvalidateDataEvent;
import com.amazon.gallery.framework.data.model.PhotoBeanImpl;
import com.amazon.gallery.framework.data.model.VideoBeanImpl;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.data.store.LenticularHelper;
import com.amazon.gallery.framework.gallery.lenticular.GalleryLenticularHelper;
import com.amazon.gallery.framework.gallery.lenticular.LenticularViewer;
import com.amazon.gallery.framework.gallery.video.GalleryVideoViewer;
import com.amazon.gallery.framework.gallery.video.GalleryVideoViewerFactory;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.gallery.view.android.GifPlayerWebView;
import com.amazon.gallery.framework.gallery.view.android.SingleViewMediaPlayer;
import com.amazon.gallery.framework.gallery.view.android.SingleViewMediaPlayerFactory;
import com.amazon.gallery.framework.gallery.view.android.SingleViewMediaPlayerManager;
import com.amazon.gallery.framework.gallery.widget.AbstractCoverViewFactory;
import com.amazon.gallery.framework.gallery.widget.ItemViewFactory;
import com.amazon.gallery.framework.gallery.widget.MediaItemCursorAdapter;
import com.amazon.gallery.framework.gallery.widget.SingleItemViewFactory;
import com.amazon.gallery.framework.gallery.widget.SingleMediaItemCoverViewFactory;
import com.amazon.gallery.framework.gallery.widget.ThumbnailSizeLookUp;
import com.amazon.gallery.framework.gallery.widget.UriViewFactory;
import com.amazon.gallery.framework.gallery.widget.ViewFactory;
import com.amazon.gallery.framework.gallery.widget.holder.ItemViewHolder;
import com.amazon.gallery.framework.glide.GlideWrapper;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.CommonActivity;
import com.amazon.gallery.framework.kindle.activity.OnSortingChangedListener;
import com.amazon.gallery.framework.kindle.amazon.ScreenModeManager;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.framework.kindle.recyclerview.DefaultAspectRatioLookUp;
import com.amazon.gallery.framework.kindle.recyclerview.MosaicLayoutCache;
import com.amazon.gallery.framework.kindle.ui.ActivityIndicatorCheckThread;
import com.amazon.gallery.framework.kindle.ui.LoadingSpinner;
import com.amazon.gallery.framework.kindle.ui.NetworkIndicator;
import com.amazon.gallery.framework.kindle.ui.ScreenUtil;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.network.disk.NetworkStore;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.thor.albums.AlbumPageTracker;
import com.amazon.gallery.thor.albums.ListChildrenTask;
import com.amazon.gallery.thor.app.FeatureChecker;
import com.amazon.gallery.thor.app.activity.MediaContentConfigurationHolder;
import com.amazon.gallery.thor.app.activity.ThorActionBar;
import com.amazon.gallery.thor.app.activity.ThorViewActivity;
import com.amazon.gallery.thor.app.ui.MarginHelper;
import com.amazon.gallery.thor.di.AppKeys;
import org.apache.commons.lang3.StringUtils;
import uk.co.senab.photoview.PhotoView;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            AdapterFragment

public class SingleViewFragment extends AdapterFragment
{
    private class CursorImagePagerAdapter extends PagerAdapter
    {

        final SingleViewFragment this$0;

        public View bindView(int i, View view)
        {
            if (isExternalAuthority())
            {
                return mViewFactory.getView(i, contentConfiguration.getContentUri(), view);
            }
            view = mMediaItemCursorAdapter.getView(i, view, null);
            int j = i;
            if (contentConfiguration.toViewDescriptor().isPreload())
            {
                Intent intent = getActivity().getIntent();
                j = i;
                if (intent != null)
                {
                    j = intent.getIntExtra("START_POSITION", 0);
                }
            }
            view.setTag(0x7f0c000d, Integer.valueOf(j));
            return view;
        }

        public void destroyItem(ViewGroup viewgroup, int i, Object obj)
        {
            mViewFactory.onViewDestroy((View)obj);
            viewgroup.removeView((View)obj);
        }

        public int getCount()
        {
            if (mMediaItemCursorAdapter == null)
            {
                return 1;
            } else
            {
                return mMediaItemCursorAdapter.getCount();
            }
        }

        public int getItemPosition(Object obj)
        {
            obj = (MediaItem)((ItemViewHolder)((View)obj).getTag()).getItem();
            if (GroupType.REWIND == ((MediaItem) (obj)).getGroupType())
            {
                return -2;
            } else
            {
                Cursor cursor = mMediaItemCursorAdapter.getCursor();
                return getMediaItemPosition(((MediaItem) (obj)).getObjectId(), cursor);
            }
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
            View view;
            if (isExternalAuthority())
            {
                view = mViewFactory.createView(contentConfiguration.getContentUri());
            } else
            {
                View view1 = mMediaItemCursorAdapter.newView(getActivity(), null, null);
                ItemViewHolder itemviewholder = (ItemViewHolder)view1.getTag();
                view = view1;
                if (itemviewholder != null)
                {
                    view = view1;
                    if (itemviewholder.getImageView() instanceof PhotoView)
                    {
                        PhotoView photoview = (PhotoView)itemviewholder.getImageView();
                        photoview.setOnViewTapListener(mViewTapListener);
                        photoview.setOnScaleChangeListener(mScaleChangeListener);
                        photoview.setOnTouchListener(((android.view.View.OnTouchListener)photoview.getIPhotoViewImplementation()). new android.view.View.OnTouchListener() {

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
                        return view1;
                    }
                }
            }
            return view;
        }

        private CursorImagePagerAdapter()
        {
            this$0 = SingleViewFragment.this;
            super();
        }

    }


    private static final String TAG = com/amazon/gallery/framework/kindle/fragment/SingleViewFragment.getName();
    private final long ARGB_LOAD_DELAY = 750L;
    private float cumulativeScale;
    private boolean firstLoad;
    private Handler mArgbHandler;
    private ThumbnailSizeLookUp mArgbSizeLookUp;
    private int mBoundingHeight;
    private int mBoundingWidth;
    private PagerAdapter mEmptyPageAdapter;
    private EnhancedGestureDetector mGestureDetector;
    private SingleViewMediaPlayerManager mMediaPlayerView;
    private android.support.v4.view.ViewPager.OnPageChangeListener mPageChangeListener;
    private ViewPager mPager;
    private CursorImagePagerAdapter mPagerAdapter;
    private uk.co.senab.photoview.PhotoViewAttacher.OnScaleChangeListener mScaleChangeListener;
    private SingleViewMediaPlayerFactory mSingleViewMediaPlayerFactory;
    private uk.co.senab.photoview.PhotoViewAttacher.OnViewTapListener mViewTapListener;
    private MosaicLayoutCache mosaicCache;

    public SingleViewFragment()
    {
        cumulativeScale = 1.0F;
        firstLoad = true;
        mPageChangeListener = new android.support.v4.view.ViewPager.SimpleOnPageChangeListener() {

            private boolean finished;
            final SingleViewFragment this$0;
            private final int visibleThreshold = 10;

            public void onPageScrollStateChanged(int i)
            {
                if (!isExternalAuthority()) goto _L2; else goto _L1
_L1:
                return;
_L2:
                switch (i)
                {
                default:
                    return;

                case 0: // '\0'
                    MediaItem mediaitem = mMediaItemCursorAdapter.getItem(mPager.getCurrentItem());
                    if (usesPlayer(mediaitem) && MediaType.VIDEO != mediaitem.getType())
                    {
                        mMediaPlayerView.onFocusedGained(mediaitem);
                    }
                    if (!isInFullScreen())
                    {
                        enterFullScreen();
                        return;
                    }
                    break;

                case 1: // '\001'
                    mMediaPlayerView.onFocusedLost();
                    return;
                }
                if (true) goto _L1; else goto _L3
_L3:
            }

            public void onPageSelected(final int position)
            {
                ViewDescriptor viewdescriptor = contentConfiguration.toViewDescriptor();
                int i = viewdescriptor.getFocusedIndex();
                Object obj = getViewForPosition(i);
                if (obj != null)
                {
                    ((PhotoView) (obj)).setScale(1.0F);
                }
                obj = mMediaItemCursorAdapter.getItem(position);
                viewdescriptor.setFocusedIndex(position);
                viewdescriptor.setMediaItem(((MediaItem) (obj)).getObjectId());
                if (viewdescriptor.getCollectionType() == com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.DYNAMIC_ALBUM)
                {
                    com.amazon.gallery.framework.model.tags.Tag tag = viewdescriptor.getTag();
                    if (tag != null)
                    {
                        AlbumPageTracker albumpagetracker = AlbumPageTracker.getInstance();
                        if (!finished && !albumpagetracker.isLoading() && position + 10 > mPagerAdapter.getCount())
                        {
                            viewdescriptor.setCollectionSize(albumpagetracker.getTotalItems());
                            if (albumpagetracker.getCurrentItems() < albumpagetracker.getTotalItems())
                            {
                                ListChildrenTask.executeWithOffset(tag, albumpagetracker.getCurrentItems());
                            } else
                            {
                                finished = true;
                            }
                        }
                    }
                } else
                {
                    viewdescriptor.setCollectionSize(mPagerAdapter.getCount());
                }
                updateScreenModeForItem(((MediaItem) (obj)));
                updateHeaderOptions(((MediaItem) (obj)));
                cumulativeScale = 1.0F;
                mArgbHandler.removeCallbacksAndMessages(null);
                mArgbHandler.postDelayed(((_cls1) (obj)). new Runnable() {

                    final _cls5 this$1;
                    final MediaItem val$mediaItem;
                    final int val$position;

                    public void run()
                    {
                        PhotoView photoview = getViewForPosition(position);
                        if (photoview != null)
                        {
                            FragmentActivity fragmentactivity = getActivity();
                            if (fragmentactivity != null)
                            {
                                GlideWrapper.loadFullQualityImage(fragmentactivity, mediaItem, photoview, mArgbSizeLookUp.getWidth(position), mArgbSizeLookUp.getHeight(position));
                            }
                        }
                    }

            
            {
                this$1 = final__pcls5;
                position = i;
                mediaItem = MediaItem.this;
                super();
            }
                }, 750L);
            }

            
            {
                this$0 = SingleViewFragment.this;
                super();
                finished = false;
            }
        };
        mViewTapListener = new uk.co.senab.photoview.PhotoViewAttacher.OnViewTapListener() {

            final SingleViewFragment this$0;

            public void onViewTap(View view, float f, float f1)
            {
                if (mMediaItemCursorAdapter.getItem(mPager.getCurrentItem()).getType() == MediaType.VIDEO && mMediaPlayerView.getVisibility() == 0)
                {
                    return;
                }
                if (mScreenModeManager.isFullScreen())
                {
                    exitFullScreen();
                    return;
                } else
                {
                    enterFullScreen();
                    return;
                }
            }

            
            {
                this$0 = SingleViewFragment.this;
                super();
            }
        };
        mScaleChangeListener = new uk.co.senab.photoview.PhotoViewAttacher.OnScaleChangeListener() ;
        mEmptyPageAdapter = new PagerAdapter() {

            final SingleViewFragment this$0;

            public int getCount()
            {
                return 0;
            }

            public boolean isViewFromObject(View view, Object obj)
            {
                return false;
            }

            
            {
                this$0 = SingleViewFragment.this;
                super();
            }
        };
        mSingleViewMediaPlayerFactory = new SingleViewMediaPlayerFactory() {

            final SingleViewFragment this$0;

            public SingleViewMediaPlayer getPlayerForMediaItem(MediaItem mediaitem, Context context)
            {
                GifPlayerWebView gifplayerwebview = null;
                if ("image/gif".equals(mediaitem.getMIMEType()))
                {
                    gifplayerwebview = new GifPlayerWebView(context);
                    gifplayerwebview.setDiskStore((DiskStore)getApplicationBean(Keys.DISK_STORE));
                    gifplayerwebview.setNetworkStore((NetworkStore)getApplicationBean(Keys.NETWORK_STORE));
                    gifplayerwebview.resumeTimers();
                } else
                {
                    if (GroupType.LENTICULAR.equals(mediaitem.getGroupType()))
                    {
                        mediaitem = new LenticularViewer(context);
                        ((LenticularViewer)mediaitem).setLenticularHelper((GalleryLenticularHelper)getApplicationBean(Keys.LENTICULAR_HELPER));
                        mediaitem.onResume();
                        return mediaitem;
                    }
                    if (mediaitem.getType() == MediaType.VIDEO)
                    {
                        mediaitem = GalleryVideoViewerFactory.createGalleryVideoViewer(context);
                        mediaitem.setRestClient((RestClient)getApplicationBean(Keys.REST_CLIENT));
                        mediaitem.setProfiler((Profiler)getApplicationBean(Keys.PROFILER));
                        mediaitem.setFeatureChecker((FeatureChecker)getApplicationBean(AppKeys.FEATURE_CHECKER));
                        mediaitem.setScreenModeManager((ScreenModeManager)getApplicationBean(Keys.SCREEN_MODE_MANAGER));
                        mediaitem.setToggleScreenModeRunnable(new Runnable() {

                            final _cls9 this$1;

                            public void run()
                            {
                                if (isExternalAuthority())
                                {
                                    return;
                                }
                                if (mScreenModeManager.isFullScreen())
                                {
                                    exitFullScreen();
                                    return;
                                } else
                                {
                                    enterFullScreen();
                                    return;
                                }
                            }

            
            {
                this$1 = _cls9.this;
                super();
            }
                        });
                        return mediaitem;
                    }
                }
                return gifplayerwebview;
            }

            
            {
                this$0 = SingleViewFragment.this;
                super();
            }
        };
    }

    private void animateBackgroundColor(int i, final View view)
    {
        animateColor(i, Integer.valueOf(((ColorDrawable)view.getBackground()).getColor()).intValue(), new android.animation.ValueAnimator.AnimatorUpdateListener() {

            final SingleViewFragment this$0;
            final View val$view;

            public void onAnimationUpdate(ValueAnimator valueanimator)
            {
                view.setBackgroundColor(((Integer)valueanimator.getAnimatedValue()).intValue());
            }

            
            {
                this$0 = SingleViewFragment.this;
                view = view1;
                super();
            }
        });
    }

    private void animateColor(int i, int j, android.animation.ValueAnimator.AnimatorUpdateListener animatorupdatelistener)
    {
        ValueAnimator valueanimator = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[] {
            Integer.valueOf(j), Integer.valueOf(i)
        });
        valueanimator.addUpdateListener(animatorupdatelistener);
        valueanimator.start();
    }

    private void animateTextColor(int i, final TextView textView)
    {
        animateColor(i, Integer.valueOf(textView.getCurrentTextColor()).intValue(), new android.animation.ValueAnimator.AnimatorUpdateListener() {

            final SingleViewFragment this$0;
            final TextView val$textView;

            public void onAnimationUpdate(ValueAnimator valueanimator)
            {
                textView.setTextColor(((Integer)valueanimator.getAnimatedValue()).intValue());
            }

            
            {
                this$0 = SingleViewFragment.this;
                textView = textview;
                super();
            }
        });
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

    private MediaType getMediaType()
    {
        if (mMediaItemCursorAdapter != null)
        {
            return mMediaItemCursorAdapter.getItem(mPager.getCurrentItem()).getType();
        } else
        {
            return IntentUtil.getMediaTypeFromIntent(getActivity().getIntent());
        }
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

    private PhotoView getViewForPosition(int i)
    {
        for (int j = 0; j < mPager.getChildCount(); j++)
        {
            View view = mPager.getChildAt(j);
            ItemViewHolder itemviewholder = (ItemViewHolder)view.getTag();
            if (view.getTag(0x7f0c000d).equals(Integer.valueOf(i)) && itemviewholder != null)
            {
                return (PhotoView)itemviewholder.getImageView();
            }
        }

        return null;
    }

    private boolean isExternalAuthority()
    {
        return mMediaItemCursorAdapter == null;
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

    private void updatePlaceholder(int i)
    {
        if (isExternalAuthority())
        {
            return;
        } else
        {
            ((ItemViewFactory)mViewFactory).setPlaceholderResource(i);
            return;
        }
    }

    private void updateScreenModeForItem(MediaItem mediaitem)
    {
        boolean flag;
        if (mediaitem.getType() == MediaType.VIDEO)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && !mScreenModeManager.hasOpaqueUI() || !flag && mScreenModeManager.hasOpaqueUI())
        {
            mScreenModeManager.setScreenMode(mScreenModeManager.getAlternateScreenMode(), getActivity(), false);
        }
    }

    private boolean usesPlayer(MediaItem mediaitem)
    {
        return mediaitem != null && (LenticularHelper.isLenticular(mediaitem.getName()) || "image/gif".equals(mediaitem.getMIMEType()) || MediaType.VIDEO == mediaitem.getType());
    }

    protected void createMediaItemCursorAdapter()
    {
        super.createMediaItemCursorAdapter();
        mMediaItemCursorAdapter.setViewFactory(mViewFactory);
        if (mosaicCache != null)
        {
            mosaicCache.setAspectRatioLookUp(new DefaultAspectRatioLookUp(mMediaItemCursorAdapter));
        }
    }

    protected void enterFullScreen()
    {
        super.enterFullScreen();
        updatePlaceholder(ItemViewFactory.PLACEHOLDER_SINGLE_VIEW);
        Integer integer = Integer.valueOf(getResources().getColor(0x7f0900c8));
        animateBackgroundColor(integer.intValue(), getView().findViewById(0x7f0c0086));
        animateBackgroundColor(integer.intValue(), getView());
        animateTextColor(Integer.valueOf(getResources().getColor(0x7f090099)).intValue(), mActivityIndicatorCheckThread.getLoadingSpinner().getTextView());
    }

    protected void exitFullScreen()
    {
        super.exitFullScreen();
        updatePlaceholder(ItemViewFactory.PLACEHOLDER_DEFAULT);
        Integer integer = Integer.valueOf(getResources().getColor(0x7f0900ab));
        animateBackgroundColor(integer.intValue(), getView().findViewById(0x7f0c0086));
        animateBackgroundColor(integer.intValue(), getView());
        animateTextColor(Integer.valueOf(getResources().getColor(0x7f090098)).intValue(), mActivityIndicatorCheckThread.getLoadingSpinner().getTextView());
        mNavigationBar.resetBackground(true);
    }

    protected int getActionBarMenuId()
    {
        if (((KeyguardManager)getActivity().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
        {
            return 0x7f100010;
        } else
        {
            return super.getActionBarMenuId();
        }
    }

    protected com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode getDefaultScreenMode()
    {
        if (mMediaItemCursorAdapter.getCount() > 0 && mMediaItemCursorAdapter.getItem(mPager.getCurrentItem()).getType() == MediaType.VIDEO)
        {
            return com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.NORMAL_STABLE_OPAQUE_UI;
        } else
        {
            return super.getDefaultScreenMode();
        }
    }

    public int getFirstVisiblePosition()
    {
        return mPager.getCurrentItem();
    }

    protected com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode getFullScreenMode()
    {
        if (mMediaItemCursorAdapter.getItem(mPager.getCurrentItem()).getType() == MediaType.VIDEO)
        {
            return com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.SUPER_FULL_SCREEN_OPAQUE_UI;
        } else
        {
            return super.getFullScreenMode();
        }
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

    protected com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode getStableScreenMode()
    {
        if (getMediaType() == MediaType.VIDEO)
        {
            return com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.NORMAL_STABLE_OPAQUE_UI;
        } else
        {
            return super.getStableScreenMode();
        }
    }

    protected boolean isInNavBarDecorMode()
    {
        return true;
    }

    protected boolean isValidFragment()
    {
        return contentConfiguration.toViewDescriptor().getCollectionSize() > 0;
    }

    public void onActionCompleteEvent(ActionCompleteEvent actioncompleteevent)
    {
        actioncompleteevent = mMediaItemCursorAdapter.getItem(mPager.getCurrentItem());
        if (actioncompleteevent != null)
        {
            updateHeaderOptions(actioncompleteevent);
        }
    }

    public boolean onBackPressed()
    {
        mMediaPlayerView.shutDown();
        contentConfiguration.toViewDescriptor().setMediaItem(null);
        return true;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (mMediaPlayerView != null)
        {
            mMediaPlayerView.onConfigChanged(configuration);
        }
        updateBoundingSize();
        mViewFactory.setBoundingSize(mBoundingWidth, mBoundingHeight);
        mPagerAdapter = new CursorImagePagerAdapter();
        int i = mPager.getCurrentItem();
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(i);
        updateIndicatorMargins();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mArgbHandler = new Handler();
        mArgbSizeLookUp = new com.amazon.gallery.framework.gallery.widget.SingleItemViewFactory.SingleImageSizeLookUp(getActivity());
        firstLoad = true;
        if (getResources().getConfiguration().orientation == 2)
        {
            mosaicCache = new MosaicLayoutCache(getResources().getDisplayMetrics().widthPixels);
        }
        mGestureDetector = new EnhancedGestureDetector(getActivity(), new com.amazon.gallery.foundation.touch.EnhancedGestureDetector.EnhancedSimpleOnGestureListener() {

            final SingleViewFragment this$0;

            public boolean onTwoFingerTapUp(MotionEvent motionevent)
            {
                getActivity().onBackPressed();
                return true;
            }

            
            {
                this$0 = SingleViewFragment.this;
                super();
            }
        });
        mFeatureChecker = (FeatureChecker)getApplicationBean(AppKeys.FEATURE_CHECKER);
        updateBoundingSize();
        if (contentConfiguration == null)
        {
            if (getActivity() instanceof ThorViewActivity)
            {
                GLogger.errorStackTrace(TAG, "ContentConfiguration was null coming from ThorViewActivity: %s", new Object[] {
                    getActivity()
                });
            }
            contentConfiguration = ((MediaContentConfigurationHolder)getActivity()).getMediaContentConfiguration();
            bundle = getActivity().getIntent();
            if (bundle != null && bundle.hasExtra("mediaItem"))
            {
                contentConfiguration.toViewDescriptor().setMediaItem((ObjectID)bundle.getSerializableExtra("mediaItem"));
            }
        }
        if (contentConfiguration != null && StringUtils.equals(contentConfiguration.getContentUri().getAuthority(), "com.amazon.gallery.provider.internal"))
        {
            bundle = new SingleMediaItemCoverViewFactory(new android.view.View.OnClickListener() {

                final SingleViewFragment this$0;

                public void onClick(View view)
                {
                    view = mMediaItemCursorAdapter.getItem(mPager.getCurrentItem());
                    mMediaPlayerView.onFocusedGained(view);
                }

            
            {
                this$0 = SingleViewFragment.this;
                super();
            }
            });
            bundle.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            bundle = new SingleItemViewFactory(getThumbnailSizeLookUp(), bundle);
            mViewFactory = bundle;
            mViewFactory.setContext(getActivity());
            bundle.setLoadingStatusTracker(mGridStatus);
            createMediaItemCursorAdapter();
        } else
        {
            bundle = new UriViewFactory();
            mViewFactory = bundle;
            bundle.setLoadingStatusTracker(mGridStatus);
        }
        mViewFactory.setContext(getActivity());
        mViewFactory.setBoundingSize(mBoundingWidth, mBoundingHeight);
        mPagerAdapter = new CursorImagePagerAdapter();
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        if (isExternalAuthority())
        {
            return null;
        } else
        {
            return super.onCreateLoader(i, bundle);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f03009d, viewgroup, false);
        int i = ScreenUtil.getStatusBarHeightForPadding(getActivity().getResources());
        MarginHelper.adjustTopMargin(layoutinflater.findViewById(0x7f0c0086), i);
        mPager = (ViewPager)layoutinflater.findViewById(0x7f0c0177);
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageMargin((int)getResources().getDimension(0x7f0a0169));
        mPager.setOffscreenPageLimit(1);
        mPager.setOnPageChangeListener(mPageChangeListener);
        mMediaPlayerView = (SingleViewMediaPlayerManager)layoutinflater.findViewById(0x7f0c0178);
        mMediaPlayerView.setSingleViewMediaPlayerFactory(mSingleViewMediaPlayerFactory);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mPager.setAdapter(mEmptyPageAdapter);
        if (mMediaPlayerView != null)
        {
            mMediaPlayerView.shutDown();
        }
    }

    public void onInvalidateDataEvent(InvalidateDataEvent invalidatedataevent)
    {
        onDataInvalidated(invalidatedataevent.isHardReset());
    }

    public void onLoadFinished(Loader loader, Cursor cursor)
    {
        super.onLoadFinished(loader, cursor);
        mPagerAdapter.notifyDataSetChanged();
        if (isValidFragment()) goto _L2; else goto _L1
_L1:
        getActivity().finish();
_L4:
        return;
_L2:
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
        if (cursor == null) goto _L4; else goto _L3
_L3:
        ViewDescriptor viewdescriptor;
        ObjectID objectid;
        viewdescriptor = contentConfiguration.toViewDescriptor();
        objectid = viewdescriptor.getMediaItem();
        loader = mMediaItemCursorAdapter.getItem(mPager.getCurrentItem());
        if (MediaItemUtil.isLocalMediaItem(loader))
        {
            ((CommonActivity)getActivity()).setLocalView(true);
        }
        if (objectid == null || objectid.equals(loader.getObjectId())) goto _L6; else goto _L5
_L5:
        mMediaPlayerView.onFocusedLost();
        int j = getMediaItemPosition(objectid, cursor);
        if (j >= 0)
        {
            mPager.setCurrentItem(j, false);
            loader = mMediaItemCursorAdapter.getItem(j);
        }
        mPageChangeListener.onPageScrollStateChanged(0);
        cursor = loader;
_L8:
        firstLoad = false;
        viewdescriptor.setMediaItem(cursor.getObjectId());
        viewdescriptor.setMediaItemType(cursor.getType());
        updateHeaderOptions(cursor);
        return;
_L6:
        cursor = loader;
        if (firstLoad)
        {
            cursor = loader;
            if (usesPlayer(loader))
            {
                cursor = loader;
                if (loader.getType() != MediaType.VIDEO)
                {
                    mMediaPlayerView.onFocusedGained(loader);
                    cursor = loader;
                }
            }
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Cursor)obj);
    }

    public void onPause()
    {
        super.onPause();
        if (mMediaPlayerView != null)
        {
            mMediaPlayerView.onPause();
        }
        mArgbHandler.removeCallbacksAndMessages(null);
    }

    public void onResume()
    {
        super.onResume();
        if (mMediaPlayerView != null)
        {
            mMediaPlayerView.onResume();
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        Intent intent;
        super.onViewCreated(view, bundle);
        intent = getActivity().getIntent();
        bundle = intent.getData();
        if (!isExternalAuthority()) goto _L2; else goto _L1
_L1:
        view.findViewById(0x7f0c0086).setVisibility(8);
        mActivityIndicatorCheckThread.getLoadingSpinner().setEnabled(false);
        mActivityIndicatorCheckThread.getNetworkIndicator().setEnabled(false);
        if (IntentUtil.getMediaTypeFromIntent(intent) != MediaType.VIDEO) goto _L4; else goto _L3
_L3:
        mScreenModeManager.setScreenMode(com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.NORMAL_STABLE_OPAQUE_UI, getActivity(), false);
        view = new VideoBeanImpl();
_L7:
        view.setLocalPath(bundle.toString());
        mMediaPlayerView.onFocusedGained(view);
_L2:
        return;
_L4:
        if (!".gif".equals(MimeTypeUtil.getFileExtensionFromPath(bundle.getPath())) && !"image/gif".equals(intent.getType())) goto _L2; else goto _L5
_L5:
        view = new PhotoBeanImpl();
        view.setMIMEType("image/gif");
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected void resetScreenMode()
    {
        if (isExternalAuthority()) goto _L2; else goto _L1
_L1:
        super.resetScreenMode();
        if (!mScreenModeManager.isFullScreen()) goto _L4; else goto _L3
_L3:
        getView().setBackgroundColor(getResources().getColor(0x7f0900c8));
        updatePlaceholder(ItemViewFactory.PLACEHOLDER_SINGLE_VIEW);
_L6:
        return;
_L4:
        mActivityIndicatorCheckThread.getLoadingSpinner().getTextView().setTextColor(getResources().getColor(0x7f090098));
        return;
_L2:
        if (mNavigationBar != null)
        {
            mNavigationBar.forceHide();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void updateHeaderOptions(MediaItem mediaitem)
    {
        if (mNavigationBar != null)
        {
            mNavigationBar.viewStateChanged(contentConfiguration.toViewDescriptor());
            mNavigationBar.updateHeaderOptions(contentConfiguration.toViewDescriptor(), mediaitem);
        }
    }







/*
    static float access$1102(SingleViewFragment singleviewfragment, float f)
    {
        singleviewfragment.cumulativeScale = f;
        return f;
    }

*/


/*
    static float access$1132(SingleViewFragment singleviewfragment, float f)
    {
        f = singleviewfragment.cumulativeScale * f;
        singleviewfragment.cumulativeScale = f;
        return f;
    }

*/










}
