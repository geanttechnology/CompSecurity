// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.android.view.launch.AuthenticatingFragment;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate;
import com.comcast.cim.cmasl.android.util.view.widget.EntityGridView;
import com.comcast.cim.cmasl.android.util.view.widget.LoadingIndicator;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutorFactory;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.utils.CommonUtils;
import com.comcast.cim.cmasl.utils.container.Tuple3;
import com.comcast.cim.container.PlayerContainer;
import com.comcast.cim.utils.AppLauncher;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.image.CoverArtImageLoader;
import com.xfinity.playerlib.model.consumable.hal.HalLiveFeaturedContent;
import com.xfinity.playerlib.model.consumable.hal.HalLiveFeaturedContentResource;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStreamResource;
import com.xfinity.playerlib.model.database.LiveStreamBookmarkDAO;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.tracking.PlayNowTab;
import com.xfinity.playerlib.tracking.PlayNowTrackingService;
import com.xfinity.playerlib.view.DimmingPageTransformer;
import com.xfinity.playerlib.view.PagerContainer;
import com.xfinity.playerlib.view.common.UpsellDialog;
import com.xfinity.playerlib.view.favorite.BookmarkEventListener;
import com.xfinity.playerlib.view.favorite.BookmarkUtils;
import com.xfinity.playerlib.view.widget.ProgramCover;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            LiveFeaturedCarouselPagerAdapter, LiveFeaturedCarouselAdapter, BabyGuideLiveStreamsActivity

public class LiveStreamsFragment extends AuthenticatingFragment
{
    private class DataFetcher extends NonCachingBaseTask
    {

        final LiveStreamsFragment this$0;

        public Tuple3 execute()
        {
            List list = liveStreamBookmarkDAO.getFavorites();
            return new Tuple3((VideoEntitlement)videoEntitlementCache.execute(), (HalLiveStreamResource)liveStreamResourceCache.execute(), list);
        }

        public volatile Object execute()
        {
            return execute();
        }

        private DataFetcher()
        {
            this$0 = LiveStreamsFragment.this;
            super();
        }

    }

    public static interface HalLiveFeaturedContentContainer
    {

        public abstract void setLiveFeaturedContentList(List list);
    }

    private class LiveStreamAdapter extends com.comcast.cim.cmasl.android.util.view.widget.EntityGridView.EntityGridViewAdapter
    {

        final LiveStreamsFragment this$0;

        protected void bindItem(StreamViewHolder streamviewholder, HalLiveStream hallivestream)
        {
            String s = hallivestream.getTitle();
            com.comcast.cim.android.image.CimImageLoader.OnLoadListener onloadlistener;
            final boolean placeHolderTitleIsPresent;
            boolean flag;
            if (streamviewholder.placeholderTitle != null)
            {
                placeHolderTitleIsPresent = true;
            } else
            {
                placeHolderTitleIsPresent = false;
            }
            if (placeHolderTitleIsPresent)
            {
                streamviewholder.placeholderTitle.setText(s);
            }
            onloadlistener = streamviewholder. new com.comcast.cim.android.image.CimImageLoader.OnLoadListener() {

                final LiveStreamAdapter this$1;
                final StreamViewHolder val$holder;
                final boolean val$placeHolderTitleIsPresent;

                public void onLoad(ImageView imageview, String s, Bitmap bitmap)
                {
                    if (placeHolderTitleIsPresent)
                    {
                        holder.placeholderTitle.setText(null);
                    }
                }

                public void onLoadError(ImageView imageview, String s)
                {
                }

            
            {
                this$1 = final_livestreamadapter;
                placeHolderTitleIsPresent = flag;
                holder = StreamViewHolder.this;
                super();
            }
            };
            flag = coverArtImageLoader.loadImageFromMemory(hallivestream.getExpandedArtworkLink(imageWidth, imageHeight), null, streamviewholder.coverArt, onloadlistener);
            if (entityGridView.isFlinging())
            {
                streamviewholder.coverArt.setTag(null);
                if (!flag)
                {
                    streamviewholder.coverArt.setImageDrawable(null);
                }
            } else
            {
                streamviewholder.coverArt.setImageDrawable(null);
                coverArtImageLoader.loadImage(hallivestream.getExpandedArtworkLink(imageWidth, imageHeight), streamviewholder.coverArt, onloadlistener);
            }
            if (placeHolderTitleIsPresent)
            {
                streamviewholder.placeholderTitle.setContentDescription(s);
            }
            hallivestream = hallivestream.getProviderCodes();
            if (videoEntitlement.isEntitledToList((String[])hallivestream.toArray(new String[hallivestream.size()])))
            {
                streamviewholder.lockedIndicator.setVisibility(8);
                return;
            } else
            {
                streamviewholder.lockedIndicator.setVisibility(0);
                return;
            }
        }

        protected volatile void bindItem(Object obj, Object obj1)
        {
            bindItem((StreamViewHolder)obj, (HalLiveStream)obj1);
        }

        protected StreamViewHolder createViewHolder()
        {
            return new StreamViewHolder();
        }

        protected volatile Object createViewHolder()
        {
            return createViewHolder();
        }

        protected int getViewLayoutId()
        {
            return com.xfinity.playerlib.R.layout.browse_live_stream_grid_item;
        }

        protected void initializeViewHolder(View view, ViewGroup viewgroup, StreamViewHolder streamviewholder)
        {
            viewgroup = (ProgramCover)view.findViewById(com.xfinity.playerlib.R.id.program_cover);
            streamviewholder.coverArt = (ImageView)viewgroup.findViewById(com.xfinity.playerlib.R.id.cover_art);
            streamviewholder.placeholderTitle = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.placeholder_title);
            streamviewholder.lockedIndicator = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.locked_indicator);
            view = viewgroup.getLayoutParams();
            if (((android.view.ViewGroup.LayoutParams) (view)).width != -1)
            {
                view.width = imageViewWidth;
            }
            view.height = imageViewHeight;
            viewgroup.setLayoutParams(view);
        }

        protected volatile void initializeViewHolder(View view, ViewGroup viewgroup, Object obj)
        {
            initializeViewHolder(view, viewgroup, (StreamViewHolder)obj);
        }

        public LiveStreamAdapter(LayoutInflater layoutinflater)
        {
            this$0 = LiveStreamsFragment.this;
            super(layoutinflater);
        }
    }

    private class LiveStreamBookmarkEventListener
        implements BookmarkEventListener
    {

        final LiveStreamsFragment this$0;

        public void onLiveStreamBookmarkAdded(LiveStreamBookmark livestreambookmark)
        {
            liveStreamBookmarks.add(livestreambookmark);
        }

        public void onLiveStreamBookmarkDeleted(String s)
        {
            Iterator iterator = liveStreamBookmarks.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                if (!((LiveStreamBookmark)iterator.next()).getStreamId().equals(s))
                {
                    continue;
                }
                iterator.remove();
                break;
            } while (true);
        }

        private LiveStreamBookmarkEventListener()
        {
            this$0 = LiveStreamsFragment.this;
            super();
        }

    }

    public static interface LiveStreamOnClickListener
    {

        public abstract void onLiveEventClick(HalLiveStream hallivestream, String s);

        public abstract void onLiveStreamClick(HalLiveStream hallivestream);
    }

    class OnLiveStreamClickedListener
        implements android.widget.AdapterView.OnItemClickListener
    {

        final LiveStreamsFragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = (HalLiveStream)CommonUtils.uncheckedCast(adapterview.getItemAtPosition(i));
            launchLiveStream(adapterview, null);
        }

        OnLiveStreamClickedListener()
        {
            this$0 = LiveStreamsFragment.this;
            super();
        }
    }

    class OnLiveStreamLongClickedListener
        implements android.widget.AdapterView.OnItemLongClickListener
    {

        private AuthenticatingFragment fragment;
        final LiveStreamsFragment this$0;

        public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = (HalLiveStream)CommonUtils.uncheckedCast(adapterview.getItemAtPosition(i));
            boolean flag1 = false;
            view = liveStreamBookmarks.iterator();
            boolean flag;
            do
            {
                flag = flag1;
                if (!view.hasNext())
                {
                    break;
                }
                if (!((LiveStreamBookmark)view.next()).getStreamId().equals(adapterview.getStreamId()))
                {
                    continue;
                }
                flag = true;
                break;
            } while (true);
            bookmarkUtils.promptBookmarkDialog(fragment, adapterview, flag, new LiveStreamBookmarkEventListener());
            return true;
        }

        public OnLiveStreamLongClickedListener(AuthenticatingFragment authenticatingfragment)
        {
            this$0 = LiveStreamsFragment.this;
            super();
            fragment = authenticatingfragment;
        }
    }

    private static class StreamViewHolder
    {

        public ImageView coverArt;
        public ImageView lockedIndicator;
        public TextView placeholderTitle;

        private StreamViewHolder()
        {
        }

    }


    private AlternateInterfaceListener alternateInterfaceListener;
    private final AndroidDevice androidDevice = PlayerContainer.getInstance().getAndroidDevice();
    private final AppLauncher appLauncher = PlayerContainer.getInstance().getAppLauncher();
    private ViewGroup bodyContainer;
    protected BookmarkUtils bookmarkUtils;
    private PagerAdapter carouselAdapter;
    private int carouselCurrentItem;
    private int carouselIndex;
    private final CoverArtImageLoader coverArtImageLoader = PlayerContainer.getInstance().createCoverArtImageLoader();
    private EntityGridView entityGridView;
    private ViewPager featuredCarousel;
    private PagerContainer featuredCarouselContainer;
    private TaskExecutionListener featuredContentTaskExecutionListener;
    private TaskExecutor featuredContentTaskExecutor;
    private Parcelable gridState;
    private int imageHeight;
    private int imageViewHeight;
    private int imageViewWidth;
    private int imageWidth;
    private boolean inTabletBabyGuide;
    private final InternetConnection internetConnection = PlayerContainer.getInstance().getInternetConnection();
    private List liveFeaturedContentList;
    private Task liveFeaturedContentResourceCache;
    private LiveStreamBookmarkDAO liveStreamBookmarkDAO;
    private List liveStreamBookmarks;
    private LiveStreamOnClickListener liveStreamClickListener;
    private Task liveStreamResourceCache;
    private List liveStreams;
    private DefaultLoadingViewDelegate loadingViewDelegate;
    private android.content.DialogInterface.OnDismissListener onDismissListener;
    private final DimmingPageTransformer pageTransformer = new DimmingPageTransformer();
    private TaskExecutionListener taskExecutionListener;
    private TaskExecutor taskExecutor;
    private TaskExecutorFactory taskExecutorFactory;
    private final PlayNowTrackingService trackingService = PlayerContainer.getInstance().getTrackingService();
    private final PlayNowUserManager userManager = PlayerContainer.getInstance().getUserManager();
    private VideoEntitlement videoEntitlement;
    private Task videoEntitlementCache;

    public LiveStreamsFragment()
    {
        taskExecutorFactory = PlayerContainer.getInstance().getTaskExecutorFactory();
        liveStreamResourceCache = PlayerContainer.getInstance().getLiveStreamResourceCache();
        videoEntitlementCache = PlayerContainer.getInstance().getVideoEntitlementCache();
        liveStreamBookmarkDAO = PlayerContainer.getInstance().getLiveStreamBookmarkDAO();
        bookmarkUtils = PlayerContainer.getInstance().getBookmarkUtils();
        liveFeaturedContentResourceCache = PlayerContainer.getInstance().getLiveFeaturedContentResourceCache();
        featuredContentTaskExecutor = taskExecutorFactory.create(liveFeaturedContentResourceCache);
        featuredContentTaskExecutionListener = new DefaultTaskExecutionListener() {

            final LiveStreamsFragment this$0;

            public void onError(TaskExecutionException taskexecutionexception)
            {
                featuredCarouselContainer.setVisibility(8);
            }

            public void onPostExecute(HalLiveFeaturedContentResource hallivefeaturedcontentresource)
            {
                liveFeaturedContentList = hallivefeaturedcontentresource.getLiveFeaturedContent();
                displayLiveFeaturedContent();
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((HalLiveFeaturedContentResource)obj);
            }

            
            {
                this$0 = LiveStreamsFragment.this;
                super();
            }
        };
        carouselCurrentItem = -1;
        onDismissListener = new android.content.DialogInterface.OnDismissListener() {

            final LiveStreamsFragment this$0;

            public void onDismiss(DialogInterface dialoginterface)
            {
                if (featuredCarousel != null)
                {
                    dialoginterface = featuredCarousel.getChildAt(featuredCarousel.getCurrentItem());
                    if (dialoginterface != null)
                    {
                        dialoginterface.setAlpha(DimmingPageTransformer.MAX_ALPHA);
                    }
                }
            }

            
            {
                this$0 = LiveStreamsFragment.this;
                super();
            }
        };
    }

    private void displayLiveFeaturedContent()
    {
        if (liveFeaturedContentList.size() == 0)
        {
            featuredCarouselContainer.setVisibility(8);
            return;
        }
        featuredCarouselContainer.setVisibility(0);
        ((HalLiveFeaturedContentContainer)carouselAdapter).setLiveFeaturedContentList(liveFeaturedContentList);
        carouselAdapter.notifyDataSetChanged();
        if (carouselCurrentItem == -1)
        {
            carouselCurrentItem = carouselAdapter.getCount() / 2;
        }
        featuredCarousel.setCurrentItem(carouselCurrentItem, false);
        carouselIndex = featuredCarousel.getCurrentItem();
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            final ViewTreeObserver viewTreeObserver = featuredCarousel.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final LiveStreamsFragment this$0;
                final ViewTreeObserver val$viewTreeObserver;

                public void onGlobalLayout()
                {
label0:
                    {
                        if (featuredCarousel.getMeasuredWidth() > 0)
                        {
                            transformCarouselItems();
                            if (viewTreeObserver.isAlive())
                            {
                                if (android.os.Build.VERSION.SDK_INT < 16)
                                {
                                    break label0;
                                }
                                viewTreeObserver.removeOnGlobalLayoutListener(this);
                            }
                        }
                        return;
                    }
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }

            
            {
                this$0 = LiveStreamsFragment.this;
                viewTreeObserver = viewtreeobserver;
                super();
            }
            });
        }
        ((BaseAdapter)entityGridView.getWrappedAdapter()).notifyDataSetChanged();
    }

    private void displayLiveStreams()
    {
        if (!((PlayerUserSettings)userManager.getUserSettings()).getWantsAdultContent())
        {
            Iterator iterator = liveStreams.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                if (((HalLiveStream)iterator.next()).isAdultContent())
                {
                    iterator.remove();
                }
            } while (true);
        }
        ((LiveStreamAdapter)CommonUtils.uncheckedCast(entityGridView.getWrappedAdapter())).setEntities(liveStreams);
        loadingViewDelegate.onLoadingFinished();
        entityGridView.update();
        if (gridState != null)
        {
            entityGridView.onRestoreInstanceState(gridState);
        }
    }

    private void initFeaturedCarousel()
    {
        int i = getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.live_featured_carousel_image_width);
        int j = getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.live_featured_carousel_image_height);
        android.view.ViewGroup.LayoutParams layoutparams;
        if (android.os.Build.VERSION.SDK_INT <= 16)
        {
            if (androidDevice.isTabletDevice())
            {
                featuredCarouselContainer.setLayerType(1, null);
            }
            carouselAdapter = new LiveFeaturedCarouselPagerAdapter(getActivity(), coverArtImageLoader, liveFeaturedContentList, i, j);
        } else
        {
            carouselAdapter = new LiveFeaturedCarouselAdapter(getFragmentManager(), liveFeaturedContentList, i, j);
        }
        if (featuredCarousel == null)
        {
            featuredCarousel = (ViewPager)getView().findViewById(com.xfinity.playerlib.R.id.carousel_pager);
        }
        featuredCarousel.setAdapter(carouselAdapter);
        featuredCarousel.setOffscreenPageLimit(4);
        featuredCarousel.setClipChildren(false);
        layoutparams = featuredCarousel.getLayoutParams();
        if (layoutparams.width == -1)
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getRealMetrics(displaymetrics);
            layoutparams.height = (int)((double)(displaymetrics.widthPixels / 2) / 0.75D);
        }
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            featuredCarousel.setPageTransformer(false, pageTransformer);
        }
        featuredCarousel.setOnTouchListener(new android.view.View.OnTouchListener() {

            int downX;
            int downY;
            boolean dragStarted;
            int dragThreshold;
            final LiveStreamsFragment this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                motionevent.getAction();
                JVM INSTR tableswitch 0 2: default 32
            //                           0 34
            //                           1 373
            //                           2 92;
                   goto _L1 _L2 _L3 _L4
_L1:
                return false;
_L2:
                bodyContainer.getParent().requestDisallowInterceptTouchEvent(false);
                featuredCarousel.getParent().requestDisallowInterceptTouchEvent(false);
                dragStarted = false;
                downX = (int)motionevent.getRawX();
                downY = (int)motionevent.getRawY();
                continue; /* Loop/switch isn't completed */
_L4:
                int k = Math.abs((int)motionevent.getRawX() - downX);
                int l = Math.abs((int)motionevent.getRawY() - downY);
                if (dragStarted)
                {
                    continue; /* Loop/switch isn't completed */
                }
                boolean flag;
                boolean flag2;
                if (k == l && k > dragThreshold)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    view = new Rect();
                    featuredCarousel.getGlobalVisibleRect(view);
                    flag2 = view.contains(downX, downY);
                    if (!flag2)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                } else
                {
                    if (l > k && l > dragThreshold)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (k > l && k > dragThreshold)
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                }
                if (flag)
                {
                    featuredCarousel.getParent().requestDisallowInterceptTouchEvent(false);
                    bodyContainer.getParent().requestDisallowInterceptTouchEvent(true);
                } else
                if (flag2)
                {
                    featuredCarousel.getParent().requestDisallowInterceptTouchEvent(true);
                    bodyContainer.getParent().requestDisallowInterceptTouchEvent(false);
                }
                if (k > dragThreshold || l > dragThreshold)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                dragStarted = flag2;
                continue; /* Loop/switch isn't completed */
_L3:
                if (!dragStarted)
                {
                    featuredCarousel.getChildAt(featuredCarousel.getCurrentItem()).setAlpha(DimmingPageTransformer.MIN_ALPHA);
                    view = (HalLiveFeaturedContent)liveFeaturedContentList.get(carouselIndex);
                    if (view != null)
                    {
                        if (view.getPackageName() == null)
                        {
                            break; /* Loop/switch isn't completed */
                        }
                        appLauncher.startApplication(view.getPackageName(), getActivity());
                    }
                }
_L6:
                bodyContainer.getParent().requestDisallowInterceptTouchEvent(false);
                featuredCarousel.getParent().requestDisallowInterceptTouchEvent(false);
                dragStarted = false;
                if (true) goto _L1; else goto _L5
_L5:
                if (view.getPlaybackLink() != null && view.getPlaybackLink().length() > 0)
                {
                    boolean flag1 = false;
                    motionevent = liveStreams.iterator();
                    do
                    {
                        if (!motionevent.hasNext())
                        {
                            break;
                        }
                        HalLiveStream hallivestream = (HalLiveStream)motionevent.next();
                        if (hallivestream.getSelfLink().equals(view.getPlaybackLink()))
                        {
                            launchLiveStream(hallivestream, view.getEventId());
                            flag1 = true;
                        }
                    } while (true);
                    if (!flag1)
                    {
                        view = CALDialogFragment.newInstance("errorDlg");
                        motionevent = new Bundle();
                        motionevent.putString("description", getString(com.xfinity.playerlib.R.string.error_stream_not_available_text));
                        view.addArguments(motionevent);
                        view.setOnDismissListener(onDismissListener);
                        view.show(getFragmentManager(), "caldialogfragment");
                    }
                } else
                if (view.getWebsiteLink() != null)
                {
                    view = new Intent("android.intent.action.VIEW", Uri.parse(view.getWebsiteLink()));
                    view.setFlags(0x10000000);
                    startActivity(view);
                }
                  goto _L6
                if (true) goto _L1; else goto _L7
_L7:
            }

            
            {
                this$0 = LiveStreamsFragment.this;
                super();
                dragThreshold = 30;
            }
        });
        featuredCarousel.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final LiveStreamsFragment this$0;

            public void onPageScrollStateChanged(int k)
            {
                featuredCarouselContainer.onPageScrollStateChanged(k);
            }

            public void onPageScrolled(int k, float f, int l)
            {
                featuredCarouselContainer.onPageScrolled(k, f, l);
            }

            public void onPageSelected(int k)
            {
                featuredCarouselContainer.onPageSelected(k);
                carouselIndex = k;
            }

            
            {
                this$0 = LiveStreamsFragment.this;
                super();
            }
        });
    }

    private boolean isInBabyGuide()
    {
        return inTabletBabyGuide || (getActivity() instanceof BabyGuideLiveStreamsActivity);
    }

    private void launchLiveStream(HalLiveStream hallivestream, String s)
    {
        if (hallivestream == null || hallivestream.getPlaybackLink() == null)
        {
            s = new Bundle();
            s.putString("title", getString(com.xfinity.playerlib.R.string.unavailable));
            s.putString("description", getString(com.xfinity.playerlib.R.string.error_stream_not_available_text));
            hallivestream = CALDialogFragment.newInstance("inputPromptDlg");
            hallivestream.addArguments(s);
            s = new ArrayList();
            s.add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getString(com.xfinity.playerlib.R.string.dlg_btn_ok), new android.content.DialogInterface.OnClickListener() {

                final LiveStreamsFragment this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = LiveStreamsFragment.this;
                super();
            }
            }));
            hallivestream.setButtonList(s);
            hallivestream.setOnDismissListener(onDismissListener);
            hallivestream.show(getFragmentManager(), "caldialogfragment");
            return;
        }
        List list = hallivestream.getProviderCodes();
        if (videoEntitlement.isEntitledToList((String[])list.toArray(new String[list.size()])))
        {
            if (s == null)
            {
                liveStreamClickListener.onLiveStreamClick(hallivestream);
                return;
            } else
            {
                liveStreamClickListener.onLiveEventClick(hallivestream, s);
                return;
            }
        } else
        {
            s = getFragmentManager();
            UpsellDialog.newInstance(com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAYBACK, hallivestream).show(s, "upsell_dialog");
            return;
        }
    }

    private void transformCarouselItems()
    {
        int j = featuredCarousel.getScrollX();
        int k = featuredCarousel.getChildCount();
        int i = 0;
        while (i < k) 
        {
            View view = featuredCarousel.getChildAt(i);
            if (!((android.support.v4.view.ViewPager.LayoutParams)view.getLayoutParams()).isDecor)
            {
                float f = (float)(view.getLeft() - j) / (float)(featuredCarousel.getMeasuredWidth() - featuredCarousel.getPaddingLeft() - featuredCarousel.getPaddingRight());
                pageTransformer.transformPage(view, f);
            }
            i++;
        }
    }

    protected int getLayoutId()
    {
        return com.xfinity.playerlib.R.layout.browse_live_streams;
    }

    protected TaskExecutionListener getTaskExecutionListener()
    {
        if (taskExecutionListener == null)
        {
            taskExecutionListener = new DefaultTaskExecutionListener() {

                final LiveStreamsFragment this$0;

                public void onError(TaskExecutionException taskexecutionexception)
                {
                    loadingViewDelegate.onLoadingFailed();
                }

                public void onPostExecute(Tuple3 tuple3)
                {
                    videoEntitlement = (VideoEntitlement)tuple3.e1;
                    liveStreamBookmarks = (List)tuple3.e3;
                    liveStreams = ((HalLiveStreamResource)tuple3.e2).getLiveStreams();
                    displayLiveStreams();
                    alternateInterfaceListener.getTalkDelegate().speakManagedMessage(com.xfinity.playerlib.R.id.ACCESSIBILITY_ANNOUNCE_LOADED);
                }

                public volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Tuple3)obj);
                }

                public void onPreAsynchronousExecute()
                {
                    alternateInterfaceListener.getTalkDelegate().speakManagedMessage(com.xfinity.playerlib.R.string.loading);
                }

            
            {
                this$0 = LiveStreamsFragment.this;
                super();
            }
            };
        }
        return taskExecutionListener;
    }

    protected TaskExecutor getTaskExecutor()
    {
        if (taskExecutor == null)
        {
            taskExecutor = taskExecutorFactory.create(new DataFetcher());
        }
        return taskExecutor;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        liveStreamClickListener = (LiveStreamOnClickListener)activity;
        alternateInterfaceListener = (AlternateInterfaceListener)activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Object obj = getActivity().getActionBar();
        if (obj != null)
        {
            obj = (ImageView)((ActionBar) (obj)).getCustomView().findViewById(com.xfinity.playerlib.R.id.xod);
            if (obj != null)
            {
                ((ImageView) (obj)).setVisibility(8);
            }
        }
        if (bundle != null)
        {
            carouselCurrentItem = bundle.getInt("carouselCurrentItem");
            gridState = bundle.getParcelable("gridState");
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = (ViewGroup)layoutinflater.inflate(com.xfinity.playerlib.R.layout.browse_live_streams, viewgroup, false);
        bodyContainer = (ViewGroup)viewgroup.findViewById(com.xfinity.playerlib.R.id.body_container);
        featuredCarouselContainer = (PagerContainer)layoutinflater.inflate(com.xfinity.playerlib.R.layout.live_featured_carousel, null, false);
        featuredCarousel = (ViewPager)featuredCarouselContainer.findViewById(com.xfinity.playerlib.R.id.carousel_pager);
        entityGridView = (EntityGridView)viewgroup.findViewById(com.xfinity.playerlib.R.id.list_view);
        entityGridView.addHeaderView(featuredCarouselContainer);
        if (bundle != null)
        {
            carouselCurrentItem = bundle.getInt("carouselCurrentItem");
            gridState = bundle.getParcelable("gridState");
        }
        initFeaturedCarousel();
        if (getArguments() != null && getArguments().containsKey("numColumns"))
        {
            int i = getArguments().getInt("numColumns");
            entityGridView.setNumColumns(i);
        }
        bundle = viewgroup.findViewById(com.xfinity.playerlib.R.id.top_scrolling_shadow);
        entityGridView.setScrollingShadow(bundle);
        bundle = getArguments();
        boolean flag;
        if (bundle != null && bundle.getBoolean("inBabyGuide", false))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        inTabletBabyGuide = flag;
        if (inTabletBabyGuide)
        {
            imageWidth = getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.babyguide_live_stream_poster_art_width);
            imageViewWidth = getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.baby_guide_panel_size) - entityGridView.getPaddingLeft() - entityGridView.getPaddingRight();
            imageHeight = imageWidth / 2;
            imageViewHeight = imageViewWidth / 2;
        } else
        {
            imageWidth = getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.live_stream_poster_art_width);
            imageHeight = getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.live_stream_poster_art_height);
            if (androidDevice.isTabletDevice())
            {
                imageViewWidth = imageWidth;
                imageViewHeight = imageHeight;
            } else
            {
                imageViewWidth = getActivity().getWindowManager().getDefaultDisplay().getWidth();
                imageViewHeight = imageViewWidth / 2;
            }
        }
        entityGridView.setColumnWidth(imageViewWidth);
        entityGridView.initialize(new LiveStreamAdapter(layoutinflater));
        entityGridView.setOnItemClickListener(new OnLiveStreamClickedListener());
        if (!inTabletBabyGuide && !(getActivity() instanceof BabyGuideLiveStreamsActivity))
        {
            entityGridView.setOnItemLongClickListener(new OnLiveStreamLongClickedListener(this));
        }
        layoutinflater = viewgroup.findViewById(0x1020004);
        entityGridView.setEmptyView(layoutinflater);
        trackingService.trackTabRendered(PlayNowTab.LIVE);
        entityGridView.setContentDescription(getString(com.xfinity.playerlib.R.string.live));
        layoutinflater = (LoadingIndicator)viewgroup.findViewById(com.xfinity.playerlib.R.id.loading_indicator);
        loadingViewDelegate = new DefaultLoadingViewDelegate(getActivity(), bodyContainer, layoutinflater, internetConnection, new com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate.ReadyListener() {

            final LiveStreamsFragment this$0;

            public void onReady()
            {
                getTaskExecutor().execute(getTaskExecutionListener());
                if (!isInBabyGuide())
                {
                    featuredContentTaskExecutor.execute(featuredContentTaskExecutionListener);
                }
            }

            
            {
                this$0 = LiveStreamsFragment.this;
                super();
            }
        });
        return viewgroup;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putInt("carouselCurrentItem", featuredCarousel.getCurrentItem());
        bundle.putParcelable("gridState", entityGridView.onSaveInstanceState());
    }

    public void onStartInternal()
    {
        super.onStartInternal();
        loadingViewDelegate.onStart();
    }

    public void onStop()
    {
        super.onStop();
        loadingViewDelegate.onStop();
        if (taskExecutor != null && taskExecutionListener != null)
        {
            taskExecutor.cancelNotificationsFor(taskExecutionListener);
        }
        if (featuredContentTaskExecutor != null && featuredContentTaskExecutionListener != null)
        {
            featuredContentTaskExecutor.cancelNotificationsFor(featuredContentTaskExecutionListener);
        }
    }



/*
    static List access$002(LiveStreamsFragment livestreamsfragment, List list)
    {
        livestreamsfragment.liveFeaturedContentList = list;
        return list;
    }

*/




/*
    static List access$1002(LiveStreamsFragment livestreamsfragment, List list)
    {
        livestreamsfragment.liveStreams = list;
        return list;
    }

*/






/*
    static VideoEntitlement access$1502(LiveStreamsFragment livestreamsfragment, VideoEntitlement videoentitlement)
    {
        livestreamsfragment.videoEntitlement = videoentitlement;
        return videoentitlement;
    }

*/



/*
    static List access$1602(LiveStreamsFragment livestreamsfragment, List list)
    {
        livestreamsfragment.liveStreamBookmarks = list;
        return list;
    }

*/





















/*
    static int access$802(LiveStreamsFragment livestreamsfragment, int i)
    {
        livestreamsfragment.carouselIndex = i;
        return i;
    }

*/

}
