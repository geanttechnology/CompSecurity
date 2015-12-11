// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.comcast.cim.android.accessibility.AccessibilityUtil;
import com.comcast.cim.android.view.common.Fade;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.utils.container.Option;
import com.comcast.cim.cmasl.utils.container.Tuple4;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.bookmarks.Bookmark;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.config.PlayerConfiguration;
import com.xfinity.playerlib.image.CoverArtImageLoader;
import com.xfinity.playerlib.image.VideoAdapter;
import com.xfinity.playerlib.model.CoverVideo;
import com.xfinity.playerlib.model.EditorialMovie;
import com.xfinity.playerlib.model.EditorialTVSeries;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.editorial.FeaturedResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.view.ScrollStateTracker;
import com.xfinity.playerlib.view.favorite.BookmarkUtils;
import com.xfinity.playerlib.view.programdetails.DetailIntentHelper;
import com.xfinity.playerlib.view.videoplay.VideoPlayerActivity;
import it.sephiroth.android.library.widget.AbsHListView;
import it.sephiroth.android.library.widget.AdapterView;
import it.sephiroth.android.library.widget.HListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            FeaturedFragment, CoverAdapter

public class TabletFeaturedFragment extends FeaturedFragment
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/featured/TabletFeaturedFragment);
    protected AccessibilityUtil accessibilityUtil;
    protected final PlayerConfiguration configuration = PlayerContainer.getInstance().getConfiguration();
    protected TextView coverVideoCollectionHeader;
    private HListView coverVideoGallery;
    private int coverVideoGalleryScrollState;
    private Fade fade;
    protected boolean isAccessibilityEnabled;
    private int lastCoverVideoCollectionPositionIndex;
    protected int lastMovieCollectionPositionIndex;
    private int lastSeriesCollectionPositionIndex;
    RelativeLayout lastWatched;
    View lastWatchedContainer;
    ImageView lastWatchedDelete;
    TextView lastWatchedHeader;
    ImageView lastWatchedImage;
    TextView lastWatchedPlaceHolderText;
    protected TextView movieCollectionHeader;
    private HListView movieGallery;
    private int movieGalleryScrollState;
    protected TaskExecutionListener programListener;
    ProgressBar progressBar;
    protected TextView seriesCollectionHeader;
    private HListView seriesGallery;
    private int seriesGalleryScrollState;

    public TabletFeaturedFragment()
    {
        fade = new Fade();
        accessibilityUtil = PlayerContainer.getInstance().getAccessibilityUtil();
    }

    private void adjustScrollShadows(HListView hlistview, ImageView imageview, ImageView imageview1)
    {
        int i = hlistview.getScrollX();
        int j;
        if (i > 0)
        {
            imageview.setVisibility(0);
            imageview.getLayoutParams().width = Math.min(i, imageview.getDrawable().getIntrinsicWidth());
        } else
        {
            imageview.setVisibility(4);
        }
        j = hlistview.getMaxScrollAmount();
        if (i < j)
        {
            imageview1.setVisibility(0);
            imageview1.getLayoutParams().width = Math.min(j - i, imageview1.getDrawable().getIntrinsicWidth());
            return;
        } else
        {
            imageview1.setVisibility(4);
            return;
        }
    }

    private int getCurrentPositionIndex(HListView hlistview)
    {
        int j = hlistview.getSelectedItemPosition();
        int i = j;
        if (j < 0)
        {
            i = hlistview.getFirstVisiblePosition();
        }
        return i;
    }

    private void persistGalleryPositions()
    {
        lastSeriesCollectionPositionIndex = getCurrentPositionIndex(seriesGallery);
        lastCoverVideoCollectionPositionIndex = getCurrentPositionIndex(coverVideoGallery);
        lastMovieCollectionPositionIndex = getCurrentPositionIndex(movieGallery);
    }

    private void setupViews(View view)
    {
        seriesCollectionHeader = (TextView)view.findViewById(com.xfinity.playerlib.R.id.justAiredHeader);
        coverVideoCollectionHeader = (TextView)view.findViewById(com.xfinity.playerlib.R.id.mustSeeHeader);
        movieCollectionHeader = (TextView)view.findViewById(com.xfinity.playerlib.R.id.newMoviesHeader);
        progressBar = (ProgressBar)view.findViewById(com.xfinity.playerlib.R.id.lastWatchedProgressBar);
        lastWatchedImage = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.cover_art);
        lastWatchedHeader = (TextView)view.findViewById(com.xfinity.playerlib.R.id.lastWatchedHeader);
        lastWatched = (RelativeLayout)view.findViewById(com.xfinity.playerlib.R.id.lastWatched);
        lastWatchedDelete = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.lastWatchedDelete);
        lastWatchedPlaceHolderText = (TextView)view.findViewById(com.xfinity.playerlib.R.id.placeholder_title);
        lastWatchedContainer = view.findViewById(com.xfinity.playerlib.R.id.lastWatchedContainer);
        lastWatchedDelete.setOnClickListener(new android.view.View.OnClickListener() {

            final TabletFeaturedFragment this$0;

            public void onClick(View view1)
            {
                if (seriesGallery == null)
                {
                    return;
                }
                if (isAccessibilityEnabled)
                {
                    lastWatchedContainer.setVisibility(8);
                } else
                {
                    fade.hide(lastWatchedContainer, 8);
                }
                ((PlayerUserSettings)userManager.getUserSettings()).setShowLastWatched(false);
                userManager.saveUserAsync();
            }

            
            {
                this$0 = TabletFeaturedFragment.this;
                super();
            }
        });
        setupJustAiredGallery(view);
        setupMustSeeGallery(view);
        setupNewMoviesGallery(view);
    }

    private void showLastWatchTitle(String s)
    {
        lastWatchedPlaceHolderText.setVisibility(0);
        lastWatchedPlaceHolderText.setText(s);
    }

    private void showLastWatched(final Bookmark bookmark, ProgressBar progressbar)
    {
        lastWatchedPlaceHolderText.setVisibility(4);
        final String title = bookmark.getTitle();
        if (bookmark instanceof VideoBookmark)
        {
            final MerlinId parentMerlinId = ((VideoBookmark)bookmark).getParentMerlinIdIfApplicable();
            coverArtImageLoader.loadImage(parentMerlinId, lastWatchedImage, new com.comcast.cim.android.image.CimImageLoader.OnLoadListener() {

                final TabletFeaturedFragment this$0;
                final MerlinId val$parentMerlinId;
                final String val$title;

                public void onLoad(ImageView imageview, String s1, Bitmap bitmap)
                {
                }

                public void onLoadError(ImageView imageview, String s1)
                {
                    TabletFeaturedFragment.LOG.warn("Couldn't load program art for last watched, show the title", parentMerlinId);
                    if (title != null && !title.isEmpty())
                    {
                        showLastWatchTitle(title);
                        return;
                    } else
                    {
                        programListener = programProvider.execute(new DefaultTaskExecutionListener() {

                            final _cls2 this$1;

                            public void onError(TaskExecutionException taskexecutionexception)
                            {
                                TabletFeaturedFragment.LOG.error("Couldn't get title for last watched", taskexecutionexception);
                            }

                            public void onPostExecute(DibicResource dibicresource)
                            {
                                dibicresource = dibicresource.getProgramByMerlinId(parentMerlinId);
                                showLastWatchTitle(dibicresource.getTitle());
                            }

                            public volatile void onPostExecute(Object obj)
                            {
                                onPostExecute((DibicResource)obj);
                            }

            
            {
                this$1 = _cls2.this;
                super();
            }
                        });
                        return;
                    }
                }

            
            {
                this$0 = TabletFeaturedFragment.this;
                parentMerlinId = merlinid;
                title = s;
                super();
            }
            });
            int i;
            if (bookmark.isFinished())
            {
                i = 0;
            } else
            {
                i = bookmark.getPercentWatched();
            }
            progressbar.setProgress(i);
            progressbar.setVisibility(0);
            if (isAccessibilityEnabled)
            {
                progressbar = lastWatchedContainer;
            } else
            {
                progressbar = lastWatched;
            }
            progressbar.setOnClickListener(new android.view.View.OnClickListener() {

                final TabletFeaturedFragment this$0;
                final Bookmark val$bookmark;

                public void onClick(View view)
                {
                    view = (new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder((VideoBookmark)bookmark)).loadAsActivity(true).build().getIntent(view.getContext());
                    startActivity(view);
                }

            
            {
                this$0 = TabletFeaturedFragment.this;
                bookmark = bookmark1;
                super();
            }
            });
        } else
        {
            final LiveStreamBookmark liveStreamBookmark = (LiveStreamBookmark)bookmark;
            int j = getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.live_stream_poster_art_width);
            int k = getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.live_stream_poster_art_height);
            String s = HalLiveStream.getArtworkUrl(liveStreamBookmark.getArtworkUrl(), j, k);
            if (!coverArtImageLoader.loadImageFromMemory(s, null, lastWatchedImage, null))
            {
                lastWatchedImage.setImageDrawable(null);
                coverArtImageLoader.loadImage(s, lastWatchedImage, null, new com.comcast.cim.android.image.CimImageLoader.OnLoadListener() {

                    final TabletFeaturedFragment this$0;

                    public void onLoad(ImageView imageview, String s1, Bitmap bitmap)
                    {
                        lastWatchedPlaceHolderText.setVisibility(8);
                    }

                    public void onLoadError(ImageView imageview, String s1)
                    {
                    }

            
            {
                this$0 = TabletFeaturedFragment.this;
                super();
            }
                });
                showLastWatchTitle(title);
            } else
            {
                lastWatchedPlaceHolderText.setVisibility(8);
            }
            progressbar.setVisibility(8);
            lastWatched.setOnClickListener(new android.view.View.OnClickListener() {

                final TabletFeaturedFragment this$0;
                final LiveStreamBookmark val$liveStreamBookmark;

                public void onClick(View view)
                {
                    view = VideoPlayerActivity.createIntentForPlayer(liveStreamBookmark.getStreamId());
                    startActivity(view);
                }

            
            {
                this$0 = TabletFeaturedFragment.this;
                liveStreamBookmark = livestreambookmark;
                super();
            }
            });
        }
        if (!isAccessibilityEnabled)
        {
            break MISSING_BLOCK_LABEL_394;
        }
        if (!(bookmark instanceof LiveStreamBookmark)) goto _L2; else goto _L1
_L1:
        lastWatchedContainer.setContentDescription(getString(com.xfinity.playerlib.R.string.content_description_last_watched_live_stream, new Object[] {
            bookmark.getTitle()
        }));
_L4:
        return;
_L2:
        if (!bookmark.isFinished())
        {
            lastWatchedContainer.setContentDescription(getString(com.xfinity.playerlib.R.string.content_description_last_watched, new Object[] {
                bookmark.getTitle(), Integer.valueOf(bookmark.getPercentWatched())
            }));
        } else
        {
            lastWatchedContainer.setContentDescription(getString(com.xfinity.playerlib.R.string.content_description_last_watched_finished, new Object[] {
                bookmark.getTitle()
            }));
        }
        if (((VideoBookmark)bookmark).isMovie()) goto _L4; else goto _L3
_L3:
        programListener = programProvider.execute(new DefaultTaskExecutionListener() {

            final TabletFeaturedFragment this$0;
            final Bookmark val$bookmark;

            public void onError(TaskExecutionException taskexecutionexception)
            {
                TabletFeaturedFragment.LOG.error("Couldn't get title for last watched", taskexecutionexception);
            }

            public void onPostExecute(DibicResource dibicresource)
            {
label0:
                {
                    if (bookmark instanceof VideoBookmark)
                    {
                        dibicresource = dibicresource.getProgramByMerlinId(((VideoBookmark)bookmark).getParentMerlinIdIfApplicable());
                        if (bookmark.isFinished())
                        {
                            break label0;
                        }
                        lastWatchedContainer.setContentDescription(getString(com.xfinity.playerlib.R.string.content_description_last_watched_episode, new Object[] {
                            dibicresource.getTitle(), bookmark.getTitle(), Integer.valueOf(bookmark.getPercentWatched())
                        }));
                    }
                    return;
                }
                lastWatchedContainer.setContentDescription(getString(com.xfinity.playerlib.R.string.content_description_last_watched_episode_finished, new Object[] {
                    dibicresource.getTitle(), bookmark.getTitle()
                }));
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((DibicResource)obj);
            }

            
            {
                this$0 = TabletFeaturedFragment.this;
                bookmark = bookmark1;
                super();
            }
        });
        return;
        fade.show(lastWatchedContainer);
        return;
    }

    protected int getLayoutId()
    {
        return com.xfinity.playerlib.R.layout.featured_w600;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (bundle != null)
        {
            lastSeriesCollectionPositionIndex = bundle.getInt("tvPosition", 0);
            lastCoverVideoCollectionPositionIndex = bundle.getInt("mustSeePosition", 0);
            lastMovieCollectionPositionIndex = bundle.getInt("moviesPosition", 0);
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        fade.setDuration(1000L);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        isAccessibilityEnabled = accessibilityUtil.isAccessibilityEnabled();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        setupViews(layoutinflater);
        return layoutinflater;
    }

    public void onPause()
    {
        super.onPause();
        persistGalleryPositions();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tvPosition", getCurrentPositionIndex(seriesGallery));
        bundle.putInt("mustSeePosition", getCurrentPositionIndex(coverVideoGallery));
        bundle.putInt("moviesPosition", getCurrentPositionIndex(movieGallery));
    }

    public void onStop()
    {
        super.onStop();
        if (programListener != null)
        {
            programProvider.cancelNotificationsFor(programListener);
        }
    }

    protected void postOnResourceFetched(Tuple4 tuple4)
    {
        VideoEntitlement videoentitlement = (VideoEntitlement)tuple4.e1;
        FeaturedResource featuredresource = (FeaturedResource)tuple4.e2;
        setupLastWatched((Bookmark)((Option)tuple4.e4).getValue());
        seriesCollectionHeader.setText(featuredresource.getSeriesCollectionTitle());
        coverVideoCollectionHeader.setText(featuredresource.getCoverVideoCollectionTitle());
        movieCollectionHeader.setText(featuredresource.getMovieCollectionTitle());
        Object obj = (VideoAdapter)seriesGallery.getAdapter();
        tuple4 = ((Tuple4) (obj));
        if (obj == null)
        {
            seriesGallery.setOnScrollListener(new it.sephiroth.android.library.widget.AbsHListView.OnScrollListener() {

                final TabletFeaturedFragment this$0;

                public void onScroll(AbsHListView abshlistview, int i, int j, int k)
                {
                }

                public void onScrollStateChanged(AbsHListView abshlistview, int i)
                {
                    seriesGalleryScrollState = i;
                }

            
            {
                this$0 = TabletFeaturedFragment.this;
                super();
            }
            });
            tuple4 = new ScrollStateTracker() {

                final TabletFeaturedFragment this$0;

                public boolean isFlinging()
                {
                    return coverVideoGalleryScrollState == 2;
                }

            
            {
                this$0 = TabletFeaturedFragment.this;
                super();
            }
            };
            tuple4 = new VideoAdapter(layoutInflator, coverArtImageLoader, networkLogoLoader, featuredresource.getSeriesCollectionTitle(), tuple4);
            seriesGallery.setAdapter(tuple4);
        }
        tuple4.setData(featuredresource.getSeries(), videoentitlement, premiumNetworks);
        tuple4.notifyDataSetChanged();
        seriesGallery.setSelection(lastSeriesCollectionPositionIndex);
        obj = (CoverAdapter)coverVideoGallery.getAdapter();
        tuple4 = ((Tuple4) (obj));
        if (obj == null)
        {
            coverVideoGallery.setOnScrollListener(new it.sephiroth.android.library.widget.AbsHListView.OnScrollListener() {

                final TabletFeaturedFragment this$0;

                public void onScroll(AbsHListView abshlistview, int i, int j, int k)
                {
                }

                public void onScrollStateChanged(AbsHListView abshlistview, int i)
                {
                    coverVideoGalleryScrollState = i;
                }

            
            {
                this$0 = TabletFeaturedFragment.this;
                super();
            }
            });
            tuple4 = new ScrollStateTracker() {

                final TabletFeaturedFragment this$0;

                public boolean isFlinging()
                {
                    return coverVideoGalleryScrollState == 2;
                }

            
            {
                this$0 = TabletFeaturedFragment.this;
                super();
            }
            };
            tuple4 = new CoverAdapter(layoutInflator, coverArtImageLoader, networkLogoLoader, featuredresource.getCoverVideoCollectionTitle(), tuple4);
            coverVideoGallery.setAdapter(tuple4);
        }
        tuple4.setData(featuredresource.getCoverVideos(), videoentitlement, premiumNetworks);
        tuple4.notifyDataSetChanged();
        coverVideoGallery.setSelection(lastCoverVideoCollectionPositionIndex);
        obj = (VideoAdapter)movieGallery.getAdapter();
        tuple4 = ((Tuple4) (obj));
        if (obj == null)
        {
            movieGallery.setOnScrollListener(new it.sephiroth.android.library.widget.AbsHListView.OnScrollListener() {

                final TabletFeaturedFragment this$0;

                public void onScroll(AbsHListView abshlistview, int i, int j, int k)
                {
                }

                public void onScrollStateChanged(AbsHListView abshlistview, int i)
                {
                    movieGalleryScrollState = i;
                }

            
            {
                this$0 = TabletFeaturedFragment.this;
                super();
            }
            });
            tuple4 = new ScrollStateTracker() {

                final TabletFeaturedFragment this$0;

                public boolean isFlinging()
                {
                    return coverVideoGalleryScrollState == 2;
                }

            
            {
                this$0 = TabletFeaturedFragment.this;
                super();
            }
            };
            tuple4 = new VideoAdapter(layoutInflator, coverArtImageLoader, networkLogoLoader, featuredresource.getMovieCollectionTitle(), tuple4);
            movieGallery.setAdapter(tuple4);
        }
        tuple4.setData(featuredresource.getMovies(), videoentitlement, premiumNetworks);
        tuple4.notifyDataSetChanged();
        movieGallery.setSelection(lastMovieCollectionPositionIndex);
    }

    protected void setupJustAiredGallery(final View justAiredShadowRight)
    {
        seriesGallery = (HListView)justAiredShadowRight.findViewById(com.xfinity.playerlib.R.id.justAiredGallery);
        seriesGallery.setOnItemClickListener(new it.sephiroth.android.library.widget.AdapterView.OnItemClickListener() {

            final TabletFeaturedFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (EditorialTVSeries)adapterview.getItemAtPosition(i);
                showDetail(adapterview.getMerlinId());
            }

            
            {
                this$0 = TabletFeaturedFragment.this;
                super();
            }
        });
        seriesGallery.setOnItemLongClickListener(new it.sephiroth.android.library.widget.AdapterView.OnItemLongClickListener() {

            final TabletFeaturedFragment this$0;

            public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (EditorialTVSeries)adapterview.getItemAtPosition(i);
                bookmarkUtils.promptBookmarkDialog(TabletFeaturedFragment.this, new VideoFavorite(adapterview.getMerlinId(), adapterview.getTitle()));
                return true;
            }

            
            {
                this$0 = TabletFeaturedFragment.this;
                super();
            }
        });
        if (!isAccessibilityEnabled)
        {
            final ImageView justAiredShadowLeft = (ImageView)justAiredShadowRight.findViewById(com.xfinity.playerlib.R.id.just_aired_shadow_left);
            justAiredShadowRight = (ImageView)justAiredShadowRight.findViewById(com.xfinity.playerlib.R.id.just_aired_shadow_right);
            seriesGallery.setOnScrollListener(new it.sephiroth.android.library.widget.AbsHListView.OnScrollListener() {

                final TabletFeaturedFragment this$0;
                final ImageView val$justAiredShadowLeft;
                final ImageView val$justAiredShadowRight;

                public void onScroll(AbsHListView abshlistview, int i, int j, int k)
                {
                }

                public void onScrollStateChanged(AbsHListView abshlistview, int i)
                {
                    adjustScrollShadows(seriesGallery, justAiredShadowLeft, justAiredShadowRight);
                }

            
            {
                this$0 = TabletFeaturedFragment.this;
                justAiredShadowLeft = imageview;
                justAiredShadowRight = imageview1;
                super();
            }
            });
        }
    }

    protected void setupLastWatched(Bookmark bookmark)
    {
        if (bookmark != null && ((PlayerUserSettings)userManager.getUserSettings()).getShowLastWatched())
        {
            showLastWatched(bookmark, progressBar);
            return;
        } else
        {
            lastWatchedContainer.setVisibility(8);
            return;
        }
    }

    protected void setupMustSeeGallery(final View mustSeeShadowRight)
    {
        coverVideoGallery = (HListView)mustSeeShadowRight.findViewById(com.xfinity.playerlib.R.id.mustSeeGallery);
        coverVideoGallery.setOnItemClickListener(new it.sephiroth.android.library.widget.AdapterView.OnItemClickListener() {

            final TabletFeaturedFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (CoverVideo)adapterview.getItemAtPosition(i);
                showDetail(adapterview.getParentMerlinIdIfApplicable(), adapterview.getEpisodeMerlinId());
            }

            
            {
                this$0 = TabletFeaturedFragment.this;
                super();
            }
        });
        coverVideoGallery.setOnItemLongClickListener(new it.sephiroth.android.library.widget.AdapterView.OnItemLongClickListener() {

            final TabletFeaturedFragment this$0;

            public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (CoverVideo)adapterview.getItemAtPosition(i);
                if (!adapterview.getEntityType().equalsIgnoreCase("Movie")) goto _L2; else goto _L1
_L1:
                bookmarkUtils.promptBookmarkDialog(TabletFeaturedFragment.this, new VideoFavorite(adapterview.getMerlinId(), adapterview.getTitle()));
_L4:
                return true;
_L2:
                if (adapterview.getEntityType().equalsIgnoreCase("TvSeries"))
                {
                    bookmarkUtils.promptBookmarkDialog(TabletFeaturedFragment.this, new VideoFavorite(adapterview.getParentMerlinIdIfApplicable(), adapterview.getTitle()));
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = TabletFeaturedFragment.this;
                super();
            }
        });
        if (!isAccessibilityEnabled)
        {
            final ImageView mustSeeShadowLeft = (ImageView)mustSeeShadowRight.findViewById(com.xfinity.playerlib.R.id.must_see_shadow_left);
            mustSeeShadowRight = (ImageView)mustSeeShadowRight.findViewById(com.xfinity.playerlib.R.id.must_see_shadow_right);
            coverVideoGallery.setOnScrollListener(new it.sephiroth.android.library.widget.AbsHListView.OnScrollListener() {

                final TabletFeaturedFragment this$0;
                final ImageView val$mustSeeShadowLeft;
                final ImageView val$mustSeeShadowRight;

                public void onScroll(AbsHListView abshlistview, int i, int j, int k)
                {
                }

                public void onScrollStateChanged(AbsHListView abshlistview, int i)
                {
                    adjustScrollShadows(coverVideoGallery, mustSeeShadowLeft, mustSeeShadowRight);
                }

            
            {
                this$0 = TabletFeaturedFragment.this;
                mustSeeShadowLeft = imageview;
                mustSeeShadowRight = imageview1;
                super();
            }
            });
        }
    }

    protected void setupNewMoviesGallery(final View newMoviesShadowRight)
    {
        movieGallery = (HListView)newMoviesShadowRight.findViewById(com.xfinity.playerlib.R.id.newMoviesGallery);
        movieGallery.setOnItemClickListener(new it.sephiroth.android.library.widget.AdapterView.OnItemClickListener() {

            final TabletFeaturedFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (EditorialMovie)adapterview.getItemAtPosition(i);
                showDetail(adapterview.getMerlinId());
            }

            
            {
                this$0 = TabletFeaturedFragment.this;
                super();
            }
        });
        movieGallery.setOnItemLongClickListener(new it.sephiroth.android.library.widget.AdapterView.OnItemLongClickListener() {

            final TabletFeaturedFragment this$0;

            public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (EditorialMovie)adapterview.getItemAtPosition(i);
                bookmarkUtils.promptBookmarkDialog(TabletFeaturedFragment.this, new VideoFavorite(adapterview.getMerlinId(), adapterview.getTitle()));
                return true;
            }

            
            {
                this$0 = TabletFeaturedFragment.this;
                super();
            }
        });
        if (!isAccessibilityEnabled)
        {
            final ImageView newMoviesShadowLeft = (ImageView)newMoviesShadowRight.findViewById(com.xfinity.playerlib.R.id.new_movies_shadow_left);
            newMoviesShadowRight = (ImageView)newMoviesShadowRight.findViewById(com.xfinity.playerlib.R.id.new_movies_shadow_right);
            movieGallery.setOnScrollListener(new it.sephiroth.android.library.widget.AbsHListView.OnScrollListener() {

                final TabletFeaturedFragment this$0;
                final ImageView val$newMoviesShadowLeft;
                final ImageView val$newMoviesShadowRight;

                public void onScroll(AbsHListView abshlistview, int i, int j, int k)
                {
                }

                public void onScrollStateChanged(AbsHListView abshlistview, int i)
                {
                    adjustScrollShadows(movieGallery, newMoviesShadowLeft, newMoviesShadowRight);
                }

            
            {
                this$0 = TabletFeaturedFragment.this;
                newMoviesShadowLeft = imageview;
                newMoviesShadowRight = imageview1;
                super();
            }
            });
        }
    }










/*
    static int access$702(TabletFeaturedFragment tabletfeaturedfragment, int i)
    {
        tabletfeaturedfragment.seriesGalleryScrollState = i;
        return i;
    }

*/



/*
    static int access$802(TabletFeaturedFragment tabletfeaturedfragment, int i)
    {
        tabletfeaturedfragment.coverVideoGalleryScrollState = i;
        return i;
    }

*/


/*
    static int access$902(TabletFeaturedFragment tabletfeaturedfragment, int i)
    {
        tabletfeaturedfragment.movieGalleryScrollState = i;
        return i;
    }

*/
}
