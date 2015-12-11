// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co.vine.android.BaseTimelineFragment;
import co.vine.android.CommentsActivity;
import co.vine.android.LikeCache;
import co.vine.android.ProfileActivity;
import co.vine.android.RevineCache;
import co.vine.android.ViewOffsetResolver;
import co.vine.android.VineLoggingException;
import co.vine.android.api.VineEntity;
import co.vine.android.api.VinePagedData;
import co.vine.android.api.VinePost;
import co.vine.android.api.VineRepost;
import co.vine.android.api.VineVenue;
import co.vine.android.client.AppController;
import co.vine.android.player.HasVideoPlayerAdapter;
import co.vine.android.player.OnListVideoClickListener;
import co.vine.android.player.SdkVideoView;
import co.vine.android.player.SensitiveImageClickListener;
import co.vine.android.player.VideoSensitiveImageClickListener;
import co.vine.android.player.VideoViewInterface;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.LoopManager;
import co.vine.android.util.MuteUtil;
import co.vine.android.util.SystemUtil;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.video.UrlVideo;
import co.vine.android.util.video.VideoKey;
import com.edisonwang.android.slog.SLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package co.vine.android.widget:
//            GenericTimelineAdapter, PinnedHeaderAdapter, FeedViewHolder, StyledClickableSpan, 
//            ColorizedCircleButton, PinnedHeaderListView, GenericFeedViewHolder, CounterView, 
//            TooltipOverlayView

public class FeedAdapter extends GenericTimelineAdapter
    implements HasVideoPlayerAdapter, PinnedHeaderAdapter
{
    private class LoopCountRunnable
        implements Runnable
    {

        public final int lastCurrentPlaying;
        public final long postId;
        final FeedAdapter this$0;

        public void run()
        {
            if (mCurrentPlaying == lastCurrentPlaying)
            {
                SLog.d("incrementing loops for currentPlaying={},  postId={}", Integer.valueOf(lastCurrentPlaying), Long.valueOf(postId));
                LoopManager.get(mContext).increment(postId);
            }
        }

        public LoopCountRunnable(int i, long l)
        {
            this$0 = FeedAdapter.this;
            super();
            lastCurrentPlaying = i;
            postId = l;
        }
    }

    public class PlayCurrentPositionRunnable
        implements Runnable
    {

        final FeedAdapter this$0;

        public void run()
        {
            this;
            JVM INSTR monitorenter ;
            int i = calculateCurrentPosition();
            if (i <= -1) goto _L2; else goto _L1
_L1:
            if (getExplicit(i)) goto _L4; else goto _L3
_L3:
            play(i);
_L2:
            this;
            JVM INSTR monitorexit ;
            return;
_L4:
            pauseCurrentPlayer();
            if (true) goto _L2; else goto _L5
_L5:
            Exception exception;
            exception;
            throw exception;
        }

        public PlayCurrentPositionRunnable()
        {
            this$0 = FeedAdapter.this;
            super();
        }
    }


    private int currentPlayerCount;
    private volatile int mCurrentPlaying;
    private int mDividerScrollAwayPadding;
    private final Drawable mFeedLocationPinDrawable;
    private boolean mFirstPlayed;
    private final Handler mHandler = new Handler();
    private boolean mHasFocus;
    private SdkVideoView mLastPlayer;
    private Handler mLoopCountHandler;
    private HandlerThread mLoopCountThread;
    private boolean mMuted;
    private boolean mNeedReleaseOtherPlayers;
    private final SparseArray mPaths = new SparseArray();
    private int mPinnedHeaderHeight;
    private int mPinnedHeaderListViewChildIndex;
    private int mPinnedHeaderPosition;
    private View mPinnedHeaderView;
    private final Runnable mPlayCurrentPositionRunnable = new PlayCurrentPositionRunnable();
    private final SparseArray mPlayers = new SparseArray();
    private final ArrayList mPosts = new ArrayList();
    private int mShouldBePlaying;
    private final HashMap mUrlReverse = new HashMap();
    private AttributeSet mVideoAttr;
    private boolean mWasResumed;
    private int maxPlayer;

    public FeedAdapter(Activity activity, ListView listview, LikeCache likecache, RevineCache revinecache, BaseTimelineFragment basetimelinefragment, String s)
    {
        super(activity, listview, likecache, revinecache, basetimelinefragment, s);
        mCurrentPlaying = 0x80000000;
        mShouldBePlaying = 0x80000000;
        maxPlayer = 10;
        currentPlayerCount = 0;
        mNeedReleaseOtherPlayers = false;
        mWasResumed = false;
        mVideoAttr = null;
        mPinnedHeaderPosition = -1;
        mPinnedHeaderHeight = 0;
        mPinnedHeaderView = null;
        mDividerScrollAwayPadding = 0;
        mPinnedHeaderListViewChildIndex = 0;
        SLog.d("Adapter constructed, accelerated? {}", Boolean.valueOf(listview.isHardwareAccelerated()));
        mFeedLocationPinDrawable = activity.getResources().getDrawable(0x7f02016d);
        mPinnedHeaderHeight = mContext.getResources().getDimensionPixelSize(0x7f0b0063);
        basetimelinefragment.addHeaderView(new LinearLayout(mContext), null, false);
        mLoopCountThread = new HandlerThread("loop-count-handler");
        mLoopCountThread.start();
        mLoopCountHandler = new Handler(mLoopCountThread.getLooper());
        mDividerScrollAwayPadding = activity.getResources().getDimensionPixelSize(0x7f0b002d);
    }

    private void bindHeader(FeedViewHolder feedviewholder)
    {
        final VinePost post = feedviewholder.post;
        Object obj = post.username;
        feedviewholder.avatarKey = null;
        bindAvatar(feedviewholder);
        String s = ((String) (obj));
        if (obj == null)
        {
            s = "";
            CrashUtil.logException(new VineLoggingException((new StringBuilder()).append("Invalid user name for post ").append(post.userId).toString()));
        }
        obj = new SpannableStringBuilder(s);
        Util.safeSetSpan(((android.text.Spannable) (obj)), mBoldSpan, 0, s.length(), 33);
        StyledClickableSpan styledclickablespan = new StyledClickableSpan(1, Long.valueOf(post.userId), mSpanClickListener);
        styledclickablespan.setColor(mProfileColor);
        Util.safeSetSpan(((android.text.Spannable) (obj)), styledclickablespan, 0, s.length(), 33);
        feedviewholder.userImage.setOnClickListener(new android.view.View.OnClickListener() {

            final FeedAdapter this$0;
            final VinePost val$post;

            public void onClick(View view)
            {
                ProfileActivity.start(mContext, post.userId, mFollowEventSource);
            }

            
            {
                this$0 = FeedAdapter.this;
                post = vinepost;
                super();
            }
        });
        feedviewholder.username.setMovementMethod(LinkMovementMethod.getInstance());
        feedviewholder.username.setText(((CharSequence) (obj)));
        s = Util.getRelativeTimeString(mContext, post.created, false);
        if (post.venueData != null && !TextUtils.isEmpty(post.venueData.venueName))
        {
            feedviewholder.timestamp.setCompoundDrawablesWithIntrinsicBounds(null, null, mFeedLocationPinDrawable, null);
            s = String.format(mContext.getString(0x7f0e00a8), new Object[] {
                s, post.venueData.venueName.trim()
            });
        } else
        {
            feedviewholder.timestamp.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
        feedviewholder.timestamp.setText(s);
        feedviewholder.updateCount(post);
    }

    private void bindView(FeedViewHolder feedviewholder)
    {
        final VinePost post;
        Object obj;
        Object obj2;
        int i;
        post = feedviewholder.post;
        i = feedviewholder.position;
        if (shouldShowThumbnail(i))
        {
            SLog.d("Should show thumbnail... {} {}.", Integer.valueOf(i), Integer.valueOf(mCurrentPlaying));
            feedviewholder.videoLoadImage.setVisibility(0);
            feedviewholder.videoView.setVisibility(8);
        }
        feedviewholder.videoImageKey = null;
        bindVideoImage(feedviewholder);
        if (!mIconsSwitched)
        {
            mIconsSwitched = true;
        }
        if (!feedviewholder.post.isExplicit() || mDismissedWarnings.contains(Integer.valueOf(i)))
        {
            feedviewholder.videoImage.setVisibility(0);
        } else
        {
            feedviewholder.videoImage.setVisibility(8);
        }
        if (post.repost != null)
        {
            feedviewholder.revineLine.setVisibility(0);
            final long userId = post.repost.userId;
            Iterator iterator;
            VineEntity vineentity;
            if (userId == mAppController.getActiveId())
            {
                feedviewholder.revineLine.setText(mContext.getString(0x7f0e01b1));
            } else
            if (post.repost.username != null)
            {
                feedviewholder.revineLine.setOnClickListener(new android.view.View.OnClickListener() {

                    final FeedAdapter this$0;
                    final long val$userId;

                    public void onClick(View view)
                    {
                        mTimelineFragment.onRevineBySpanClicked(userId);
                    }

            
            {
                this$0 = FeedAdapter.this;
                userId = l;
                super();
            }
                });
                SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(mContext.getString(0x7f0e01b0, new Object[] {
                    post.repost.username
                }));
                feedviewholder.revineLine.setMovementMethod(LinkMovementMethod.getInstance());
                feedviewholder.revineLine.setText(spannablestringbuilder);
            } else
            {
                feedviewholder.revineLine.setVisibility(8);
            }
        } else
        {
            feedviewholder.revineLine.setVisibility(8);
        }
        if (TextUtils.isEmpty(post.description))
        {
            break MISSING_BLOCK_LABEL_1009;
        }
        feedviewholder.description.setVisibility(0);
        if (post.transientEntities == null && post.entities != null)
        {
            post.transientEntities = new ArrayList();
            for (iterator = post.entities.iterator(); iterator.hasNext(); post.transientEntities.add(vineentity.duplicate()))
            {
                vineentity = (VineEntity)iterator.next();
            }

        }
        obj2 = post.transientEntities;
        obj = Util.addDirectionalMarkers(post.description);
        if (obj2 == null) goto _L2; else goto _L1
_L1:
        feedviewholder.description.setMovementMethod(LinkMovementMethod.getInstance());
        if (post.descriptionSb != null) goto _L4; else goto _L3
_L3:
        Object obj1;
        post.descriptionSb = new SpannableStringBuilder(((CharSequence) (obj)));
        obj1 = post.descriptionSb;
        Util.adjustEntities(((ArrayList) (obj2)), ((android.text.Editable) (obj1)), 0, false);
        obj2 = ((ArrayList) (obj2)).iterator();
_L8:
        if (!((Iterator) (obj2)).hasNext()) goto _L4; else goto _L5
_L5:
        VineEntity vineentity1 = (VineEntity)((Iterator) (obj2)).next();
        if (!vineentity1.isUserType()) goto _L7; else goto _L6
_L6:
        StyledClickableSpan styledclickablespan = new StyledClickableSpan(1, Long.valueOf(vineentity1.id), mSpanClickListener);
        styledclickablespan.setColor(mProfileColor);
        Util.safeSetSpan(((android.text.Spannable) (obj1)), styledclickablespan, vineentity1.start, vineentity1.end, 33);
          goto _L8
        obj1;
        CrashUtil.logException(((Throwable) (obj1)));
_L4:
        feedviewholder.description.setText(post.descriptionSb);
_L10:
        boolean flag;
        boolean flag1;
        if (Util.isRtlLanguage(((String) (obj))))
        {
            feedviewholder.description.setGravity(5);
        } else
        {
            feedviewholder.description.setGravity(3);
        }
_L11:
        feedviewholder.listener.setPosition(i);
        if (feedviewholder.imageListener != null)
        {
            feedviewholder.imageListener.setPosition(i);
        }
        bindHeader(feedviewholder);
        feedviewholder.comment.setColor(mProfileColor);
        feedviewholder.comment.setOnClickListener(new android.view.View.OnClickListener() {

            final FeedAdapter this$0;
            final VinePost val$post;

            public void onClick(View view)
            {
                CommentsActivity.start(mContext, post.postId, post.userId, false);
            }

            
            {
                this$0 = FeedAdapter.this;
                post = vinepost;
                super();
            }
        });
        obj = feedviewholder.commentList;
        if (feedviewholder.post.comments != null && feedviewholder.post.comments.items.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setStyledCompactLikesComments(feedviewholder);
        ((LinearLayout) (obj)).setVisibility(0);
        if (flag)
        {
            setStyledComments(feedviewholder, post.comments);
            ((LinearLayout) (obj)).setVisibility(0);
            StyledClickableSpan styledclickablespan1;
            if (post.commentsCount > 3)
            {
                feedviewholder.commentType = 2;
            } else
            {
                feedviewholder.commentType = 1;
            }
        } else
        {
            ((LinearLayout) (obj)).setVisibility(8);
        }
        if (mLikeCache.contains(post.postId))
        {
            flag1 = mLikeCache.isLike(post.postId);
            post.setFlagLiked(flag1);
        } else
        {
            flag1 = post.isLiked();
            if (flag1)
            {
                mLikeCache.like(post.postId);
            } else
            {
                mLikeCache.unlike(post.postId);
            }
        }
        feedviewholder.liked.setColor(mProfileColor);
        feedviewholder.liked.setSelected(flag1);
        feedviewholder.liked.setTag(Long.valueOf(post.postId));
        feedviewholder.liked.setOnClickListener(mViewClickListener);
        feedviewholder.more.setTag(post);
        feedviewholder.more.setOnClickListener(mViewClickListener);
        feedviewholder.share.setVisibility(0);
        if (mRevineCache.contains(post.postId))
        {
            flag1 = mRevineCache.isRevined(post.postId);
            post.setFlagRevined(flag1);
        } else
        {
            if (post.myRepostId > 0L || post.isRevined())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                mRevineCache.putMyRepostId(post.postId, post.myRepostId);
                mRevineCache.revine(post.postId);
            } else
            {
                mRevineCache.unRevine(post.postId);
            }
        }
        feedviewholder.share.setColor(mProfileColor);
        feedviewholder.share.setSelected(flag1);
        feedviewholder.share.setTag(post);
        feedviewholder.share.setOnClickListener(mViewClickListener);
        initVideoView(i, feedviewholder);
        if (!mFirstPlayed && i == 0 && !post.isExplicit())
        {
            play(0);
            if (SLog.sLogsOn && mStartLoadingTime > 0L)
            {
                SLog.i("Time since started loading to request 0th video to play: {}ms", Long.valueOf(timeSinceStartLoadingTime()));
            }
            mFirstPlayed = true;
        }
        return;
_L7:
        if (!vineentity1.isTagType()) goto _L8; else goto _L9
_L9:
        styledclickablespan1 = new StyledClickableSpan(4, vineentity1.title, mSpanClickListener);
        styledclickablespan1.setColor(mProfileColor);
        Util.safeSetSpan(((android.text.Spannable) (obj1)), styledclickablespan1, vineentity1.start, vineentity1.end, 33);
          goto _L8
_L2:
        feedviewholder.description.setText(((CharSequence) (obj)));
          goto _L10
        feedviewholder.description.setVisibility(8);
          goto _L11
    }

    private int calculateCurrentPosition()
    {
        int j = mListView.getFirstVisiblePosition();
        int i = 0;
        if (mViewOffsetResolver != null)
        {
            i = mViewOffsetResolver.getOffset(this);
        }
        j -= i;
        Object obj = mTimelineFragment.getHeaderViewParents();
        i = j;
        if (((HashSet) (obj)).size() > 0)
        {
            i = 0;
            obj = ((HashSet) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                if (!((View)((Iterator) (obj)).next()).isShown())
                {
                    i++;
                }
            } while (true);
            j -= i;
            SLog.d("Try to get current First: {}, missing header count: {}", Integer.valueOf(j), Integer.valueOf(i));
            i = j;
        }
        obj = getViewAtPosition(i);
        if (obj == null)
        {
            j = -1;
        } else
        {
            j = 0;
            if (getLastPlayer() != null)
            {
                j = getLastPlayer().getHeight() / 2;
            }
            float f2 = ((View) (obj)).getBottom();
            float f3 = j;
            float f1 = (float)((View) (obj)).getHeight() + (float)j;
            float f = f1;
            if (f1 == 0.0F)
            {
                f = 1.0F;
            }
            f = (f2 + f3) / f;
            SLog.d("Current First: {}, ratio: {}", Integer.valueOf(i), Float.valueOf(f));
            if ((double)f < 0.5D || i == -1 && i < getCount() - 1 && i + 1 != mCurrentPlaying)
            {
                return i + 1;
            }
            j = i;
            if (i == mCurrentPlaying)
            {
                return -1;
            }
        }
        return j;
    }

    private void countedMediaPlayerStart(VideoViewInterface videoviewinterface, long l)
    {
        videoviewinterface.start();
        mLoopCountHandler.postDelayed(new LoopCountRunnable(mCurrentPlaying, l), 500L);
    }

    private boolean getExplicit(int i)
    {
        VinePost vinepost = getPost(i);
        return vinepost != null && vinepost.isExplicit() && !mDismissedWarnings.contains(Integer.valueOf(i));
    }

    private VinePost getPost(int i)
    {
        if (i >= 0 && i < mPosts.size())
        {
            return (VinePost)mPosts.get(i);
        } else
        {
            return null;
        }
    }

    private boolean hasPlayerPlaying()
    {
        return mLastPlayer != null && !mLastPlayer.isPaused();
    }

    private void initVideoView(final int position, final FeedViewHolder tag)
    {
        tag.videoLoadImage.setVisibility(8);
        final SdkVideoView view = tag.videoView;
        view.setOnPreparedListener(new co.vine.android.player.VideoViewInterface.OnPreparedListener() {

            final FeedAdapter this$0;
            final FeedViewHolder val$tag;

            public void onPrepared(VideoViewInterface videoviewinterface)
            {
                if (videoviewinterface.getPlayingPosition() == mCurrentPlaying)
                {
                    countedMediaPlayerStart(videoviewinterface, tag.post.postId);
                } else
                {
                    SLog.e("This video should not be played: {}, {}.", Integer.valueOf(videoviewinterface.getPlayingPosition()), Integer.valueOf(mCurrentPlaying));
                }
                endLoadingTimeProfiling();
                tag.videoView.setVisibility(0);
            }

            
            {
                this$0 = FeedAdapter.this;
                tag = feedviewholder;
                super();
            }
        });
        view.setOnErrorListener(new co.vine.android.player.VideoViewInterface.OnErrorListener() {

            final FeedAdapter this$0;
            final int val$position;
            final FeedViewHolder val$tag;
            final SdkVideoView val$view;

            public boolean onError(VideoViewInterface videoviewinterface, int i, int j)
            {
                SLog.d("Got error, try recycling it more aggressively: {}, {}", Integer.valueOf(i), Integer.valueOf(j));
                maxPlayer = currentPlayerCount - 1;
                mNeedReleaseOtherPlayers = true;
                releaseOtherPlayers(view);
                if (!view.retryOpenVideo(false))
                {
                    SLog.e("Replay video using videoLowUrl.");
                    mPaths.remove(position);
                    if (tag.post != null && tag.post.videoLowURL != null)
                    {
                        tag.post.videoUrl = tag.post.videoLowURL;
                        tag.post.videoLowURL = null;
                        view.setReportOpenError(true);
                        if (mCurrentPlaying == position)
                        {
                            stopCurrentPlayer();
                        }
                        play(position);
                    }
                }
                return true;
            }

            
            {
                this$0 = FeedAdapter.this;
                view = sdkvideoview;
                position = i;
                tag = feedviewholder;
                super();
            }
        });
        view.setOnCompletionListener(new co.vine.android.player.VideoViewInterface.OnCompletionListener() {

            final FeedAdapter this$0;
            final FeedViewHolder val$tag;

            public void onCompletion(VideoViewInterface videoviewinterface)
            {
                videoviewinterface.seekTo(0);
                countedMediaPlayerStart(videoviewinterface, tag.post.postId);
                videoviewinterface = getPost(mCurrentPlaying);
                if (videoviewinterface != null)
                {
                    tag.counterView.adjustExtraCount(LoopManager.getLocalLoopCount(((VinePost) (videoviewinterface)).postId));
                    tag.counterView.invalidateCounterUI();
                }
                FlurryUtils.trackVineLoopWatched();
            }

            
            {
                this$0 = FeedAdapter.this;
                tag = feedviewholder;
                super();
            }
        });
        view.setSurfaceReadyListener(new co.vine.android.player.SdkVideoView.SurfaceReadyListener() {

            final FeedAdapter this$0;

            public void onSurfaceTextureAvailable(SdkVideoView sdkvideoview)
            {
                if (mHasFocus && sdkvideoview == mLastPlayer)
                {
                    sdkvideoview.startOpenVideo();
                }
            }

            
            {
                this$0 = FeedAdapter.this;
                super();
            }
        });
        mPlayers.put(position, view);
    }

    private boolean preFetch(int i)
    {
label0:
        {
label1:
            {
label2:
                {
                    VideoKey videokey;
label3:
                    {
                        if (i >= mPosts.size())
                        {
                            break label0;
                        }
                        Object obj = getPost(i);
                        if (obj == null)
                        {
                            break label1;
                        }
                        if (mPaths.get(i) != null)
                        {
                            break label2;
                        }
                        videokey = getRequestKey(getPost(i), false);
                        SLog.d("Pre-fetch {}: {}", Integer.valueOf(i), videokey);
                        if (videokey != null)
                        {
                            if (((VinePost) (obj)).thumbnailUrl != null)
                            {
                                Object obj1 = new ImageKey(((VinePost) (obj)).thumbnailUrl);
                                obj1 = mAppController.getPhotoBitmap(((ImageKey) (obj1)));
                                if (obj1 != null)
                                {
                                    mThumbnails.put(i, obj1);
                                }
                            }
                            if (((VinePost) (obj)).avatarUrl != null)
                            {
                                obj = new ImageKey(((VinePost) (obj)).avatarUrl, true);
                                obj = mAppController.getPhotoBitmap(((ImageKey) (obj)));
                                if (obj != null)
                                {
                                    mAvatars.put(i, obj);
                                }
                            }
                            obj = mAppController.getVideoFilePath(videokey);
                            if (obj == null)
                            {
                                break label3;
                            }
                            mPaths.put(i, obj);
                        }
                        return true;
                    }
                    mUrlReverse.put(videokey, Integer.valueOf(i));
                    return true;
                }
                SLog.d("{} is already fetched.", Integer.valueOf(i));
                return true;
            }
            SLog.d("End of list, no pre-fetching: {} {}", Integer.valueOf(i), Integer.valueOf(getCount()));
            return false;
        }
        return false;
    }

    private void refreshVideoView(int i, FeedViewHolder feedviewholder)
    {
        ViewGroup viewgroup = (ViewGroup)feedviewholder.videoView.getParent();
        if (mVideoAttr == null)
        {
            mVideoAttr = feedviewholder.videoView.getAttributes();
        }
        feedviewholder.videoView.suspend();
        try
        {
            viewgroup.removeView(feedviewholder.videoView);
        }
        catch (RuntimeException runtimeexception)
        {
            try
            {
                viewgroup.removeView(feedviewholder.videoView);
            }
            catch (Exception exception)
            {
                CrashUtil.logException(runtimeexception, "Weird things are happening.", new Object[0]);
            }
        }
        feedviewholder.videoView = new SdkVideoView(mContext, mVideoAttr);
        feedviewholder.videoView.setId(0x7f0a0075);
        viewgroup.addView(feedviewholder.videoView);
        initVideoView(i, feedviewholder);
    }

    private boolean shouldShowThumbnail(int i)
    {
        return mCurrentPlaying != i || !hasPlayerPlaying();
    }

    protected void createInsensitiveListener(FeedViewHolder feedviewholder)
    {
        feedviewholder.sensitiveTextContainer.setVisibility(8);
        feedviewholder.sensitiveTextContainer.setOnClickListener(null);
        feedviewholder.sensitiveTextContainer.setClickable(false);
    }

    protected volatile void createInsensitiveListener(GenericFeedViewHolder genericfeedviewholder)
    {
        createInsensitiveListener((FeedViewHolder)genericfeedviewholder);
    }

    protected void createSensitiveLisenter(FeedViewHolder feedviewholder)
    {
        feedviewholder.imageListener = new VideoSensitiveImageClickListener(this, mDismissedWarnings);
        feedviewholder.sensitiveTextContainer.setOnClickListener(feedviewholder.imageListener);
        feedviewholder.sensitiveTextContainer.setClickable(true);
        feedviewholder.isVideoImageLoaded = true;
    }

    protected volatile void createSensitiveLisenter(GenericFeedViewHolder genericfeedviewholder)
    {
        createSensitiveLisenter((FeedViewHolder)genericfeedviewholder);
    }

    public int getCount()
    {
        return mPosts.size();
    }

    protected FeedViewHolder getHolderFromPosition(int i)
    {
        WeakReference weakreference = (WeakReference)mViewHolders.get(i);
        if (weakreference != null)
        {
            return (FeedViewHolder)weakreference.get();
        } else
        {
            return null;
        }
    }

    public Object getItem(int i)
    {
        return getPost(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public SdkVideoView getLastPlayer()
    {
        return mLastPlayer;
    }

    public int getPinnedHeaderHeight()
    {
        return mPinnedHeaderHeight;
    }

    public PinnedHeaderAdapter.PinnedHeaderStatus getPinnedHeaderStatus(int i)
    {
        boolean flag4 = false;
        int k = mPinnedHeaderPosition;
        mPinnedHeaderListViewChildIndex = ((PinnedHeaderListView)mListView).getPositionForPixelLocation(i);
        mPinnedHeaderPosition = (mListView.getFirstVisiblePosition() - mListView.getHeaderViewsCount()) + mPinnedHeaderListViewChildIndex;
        View view = mListView.getChildAt(mPinnedHeaderListViewChildIndex);
        boolean flag = false;
        boolean flag2 = false;
        boolean flag5 = true;
        int j = ((flag) ? 1 : 0);
        boolean flag3 = flag5;
        if (view != null)
        {
            FeedViewHolder feedviewholder = (FeedViewHolder)view.getTag();
            j = ((flag) ? 1 : 0);
            flag3 = flag5;
            if (feedviewholder != null)
            {
                View view1 = ((ViewGroup)view).getChildAt(0);
                boolean flag1;
                int l;
                int i1;
                if (view1.getVisibility() == 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                l = view.getTop();
                i1 = view.getTop() + feedviewholder.divider.getTop();
                j = ((flag2) ? 1 : 0);
                if (i1 < mPinnedHeaderHeight + i + mDividerScrollAwayPadding)
                {
                    j = i1 - mPinnedHeaderHeight - i;
                }
                if (!flag1 || l <= i - view1.getHeight())
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
            }
        }
        if (mPinnedHeaderView == null || k != mPinnedHeaderPosition)
        {
            flag4 = true;
        }
        return new PinnedHeaderAdapter.PinnedHeaderStatus(j, flag4, flag3);
    }

    public View getPinnedHeaderView(View view)
    {
        view = (ViewGroup)mListView.getChildAt(mPinnedHeaderListViewChildIndex);
        if (view != null)
        {
            view = view.findViewById(0x7f0a0152);
            if (view != null)
            {
                view.setBackgroundColor(-1);
            }
            mPinnedHeaderView = view;
            return view;
        } else
        {
            return null;
        }
    }

    public SdkVideoView getPlayer(int i, boolean flag)
    {
        return (SdkVideoView)mPlayers.get(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = newView();
        }
        view = (FeedViewHolder)viewgroup.getTag();
        view.post = getPost(i);
        view.position = i;
        if (((FeedViewHolder) (view)).post != null)
        {
            bindView(view);
            return viewgroup;
        } else
        {
            CrashUtil.log("Post null: {} {}", new Object[] {
                Integer.valueOf(i), Integer.valueOf(mPosts.size())
            });
            return viewgroup;
        }
    }

    public boolean isPlaying()
    {
        return hasPlayerPlaying();
    }

    public void layoutPinnedHeader(View view, int i, int j, int k, int l)
    {
    }

    public void mergeMyPost(VinePost vinepost)
    {
        if (vinepost != null)
        {
            mPosts.add(0, vinepost);
            mPaths.clear();
            mUrlReverse.clear();
            mPlayers.clear();
            notifyDataSetChanged();
            playCurrentPosition();
        }
    }

    public void mergePost(VinePost vinepost)
    {
        mPosts.clear();
        mPosts.add(0, vinepost);
        notifyDataSetChanged();
    }

    public void mergePosts(ArrayList arraylist, boolean flag)
    {
        if (!flag)
        {
            mPosts.clear();
            mPaths.clear();
            mPlayers.clear();
            mUrlReverse.clear();
        }
        mPosts.addAll(arraylist);
        notifyDataSetChanged();
    }

    public View newView()
    {
        View view = LayoutInflater.from(mContext).inflate(0x7f030070, null);
        Object obj = (RelativeLayout)view.findViewById(0x7f0a0073);
        android.view.ViewGroup.LayoutParams layoutparams = ((RelativeLayout) (obj)).getLayoutParams();
        layoutparams.height = mDimen;
        layoutparams.width = mDimen;
        ((RelativeLayout) (obj)).setLayoutParams(layoutparams);
        obj = (ImageView)view.findViewById(0x7f0a012b);
        layoutparams = ((ImageView) (obj)).getLayoutParams();
        layoutparams.width = mDimen;
        layoutparams.height = mDimen;
        ((ImageView) (obj)).setLayoutParams(layoutparams);
        obj = new FeedViewHolder(view);
        obj.videoView = (SdkVideoView)view.findViewById(0x7f0a0075);
        obj.listener = new OnListVideoClickListener(this);
        view.findViewById(0x7f0a0073).setOnClickListener(((FeedViewHolder) (obj)).listener);
        view.setTag(obj);
        mViewHolders.add(new WeakReference(obj));
        SLog.d("Get view: {}", Integer.valueOf(((FeedViewHolder) (obj)).videoView.hashCode() % 100));
        if (android.os.Build.VERSION.SDK_INT > 15)
        {
            ((FeedViewHolder) (obj)).loopsHintButton.setOnTouchListener(new android.view.View.OnTouchListener() {

                final FeedAdapter this$0;

                public boolean onTouch(View view1, MotionEvent motionevent)
                {
                    if (motionevent.getAction() == 0 && (mListView instanceof PinnedHeaderListView))
                    {
                        TooltipOverlayView tooltipoverlayview = new TooltipOverlayView(mContext, 0x7f0e0134);
                        PinnedHeaderListView pinnedheaderlistview = (PinnedHeaderListView)mListView;
                        boolean flag = pinnedheaderlistview.isAbsoluteTouchInPinnedHeader(motionevent);
                        motionevent = new int[2];
                        view1.getLocationInWindow(motionevent);
                        int i;
                        if (flag)
                        {
                            i = pinnedheaderlistview.getPinnedHeaderBottomAbs();
                        } else
                        {
                            i = motionevent[1] + view1.getHeight();
                        }
                        tooltipoverlayview.showTooltip(i);
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            
            {
                this$0 = FeedAdapter.this;
                super();
            }
            });
        }
        return view;
    }

    public void onDestroy()
    {
        stopCurrentPlayer();
        releaseOtherPlayers(null);
        mLoopCountHandler.getLooper().quit();
        mLoopCountThread.interrupt();
        mLoopCountThread = null;
    }

    public void onDestroyView()
    {
        releaseOtherPlayers(null);
    }

    public void onPause(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        SLog.d("OnPause {}. {}", Boolean.valueOf(flag), this);
        mHasFocus = flag;
        mShouldBePlaying = 0x80000000;
        mHandler.removeCallbacks(mPlayCurrentPositionRunnable);
        releaseOtherPlayers(null);
        resetStates(false);
        mWasResumed = false;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void onResume(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        SLog.d("OnResume {}. {}", Boolean.valueOf(flag), this);
        if (!mWasResumed)
        {
            mWasResumed = true;
            mShouldBePlaying = 0x80000000;
            mMuted = MuteUtil.isMuted(mContext);
        }
        mHasFocus = flag;
        if (!mHasFocus)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        i = calculateCurrentPosition();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        int j = mViewHolders.size();
        if (j <= i)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        FeedViewHolder feedviewholder = getHolderFromPosition(i);
        if (feedviewholder == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        bindVideoImage(feedviewholder);
_L1:
        playCurrentPosition();
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        SLog.e("Race condition.", ((Throwable) (obj)));
          goto _L1
        obj;
        throw obj;
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (i == 0)
        {
            playCurrentPosition();
        }
    }

    protected void onVideoImageObtained(FeedViewHolder feedviewholder, boolean flag)
    {
        feedviewholder.isVideoImageLoaded = flag;
        playCurrentPosition();
    }

    protected volatile void onVideoImageObtained(GenericFeedViewHolder genericfeedviewholder, boolean flag)
    {
        onVideoImageObtained((FeedViewHolder)genericfeedviewholder, flag);
    }

    public void onVideoPathObtained(HashMap hashmap)
    {
        SLog.d("CALLBACK onVideoPathObtained");
        Iterator iterator = hashmap.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            VideoKey videokey = (VideoKey)iterator.next();
            UrlVideo urlvideo = (UrlVideo)hashmap.get(videokey);
            if (urlvideo.isValid() && mUrlReverse.get(videokey) != null)
            {
                mPaths.put(((Integer)mUrlReverse.get(videokey)).intValue(), urlvideo.getAbsolutePath());
                if (((Integer)mUrlReverse.get(videokey)).intValue() == mShouldBePlaying)
                {
                    playCurrentPosition();
                }
            }
        } while (true);
    }

    public void pauseCurrentPlayer()
    {
        if (hasPlayerPlaying())
        {
            SLog.d("Pause player {}.", Integer.valueOf(mLastPlayer.getPlayingPosition()));
            mLastPlayer.pause();
        }
    }

    public void play(int i)
    {
        this;
        JVM INSTR monitorenter ;
        SLog.d("play task executing with position {} ", Integer.valueOf(i));
        if (!mHasFocus)
        {
            break MISSING_BLOCK_LABEL_315;
        }
        if (mPaths.get(i) == null) goto _L2; else goto _L1
_L1:
        if (preFetch(i + 1))
        {
            preFetch(i + 2);
        }
        SLog.d("{} is in cache or it is already pre-fetched.", Integer.valueOf(i));
        SLog.d("playing file at position {}", Integer.valueOf(i));
        playFile(i, true);
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj;
        SLog.d("Real fetch for {}.", Integer.valueOf(i));
        obj = getPost(i);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_302;
        }
        obj = getRequestKey(((VinePost) (obj)), false);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        onInvalidRequestKey();
          goto _L3
        obj;
        throw obj;
        Object obj1;
        obj1 = mAppController.getVideoFilePath(((VideoKey) (obj)));
        if (preFetch(i + 1))
        {
            preFetch(i + 2);
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        mPaths.put(i, obj1);
        SLog.d("playing file at position {}", Integer.valueOf(i));
        playFile(i, true);
          goto _L3
        mShouldBePlaying = i;
        mUrlReverse.put(obj, Integer.valueOf(i));
        SLog.d("{} is not in app cache yet.", Integer.valueOf(i));
        pauseCurrentPlayer();
        obj = getViewAtPosition(i);
        if (obj == null) goto _L3; else goto _L4
_L4:
label0:
        {
            obj1 = ((View) (obj)).getTag();
            if (!(obj1 instanceof FeedViewHolder))
            {
                break label0;
            }
            ((FeedViewHolder)obj1).videoLoadImage.setVisibility(0);
        }
          goto _L3
        CrashUtil.logException(new IllegalStateException((new StringBuilder()).append("Somehow tag was ").append(obj1).append(", view class is '").append(obj.getClass().getName()).append("'.").toString()));
          goto _L3
        SLog.d("mPosts is {} or the requested position has no post object in it yet, return -1.", mPosts);
          goto _L3
        SLog.d("not playing because not focused.");
          goto _L3
    }

    public void playCurrentPosition()
    {
        this;
        JVM INSTR monitorenter ;
        mHandler.removeCallbacks(mPlayCurrentPositionRunnable);
        mHandler.postDelayed(mPlayCurrentPositionRunnable, 50L);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void playFile(int i, boolean flag)
    {
        boolean flag1 = true;
        this;
        JVM INSTR monitorenter ;
        if (i >= 0) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj;
        SLog.i("Playing item: {}", Integer.valueOf(i));
        obj = getViewAtPosition(i);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        SLog.i("Item is not visible: {}", Integer.valueOf(i));
          goto _L1
        obj;
        throw obj;
        FeedViewHolder feedviewholder = (FeedViewHolder)((View) (obj)).getTag();
        if (feedviewholder == null) goto _L1; else goto _L3
_L3:
        String s;
        obj = feedviewholder.videoView;
        if (obj != mLastPlayer)
        {
            SLog.i("Pause previous player.");
            pauseCurrentPlayer();
        }
        s = (String)mPaths.get(i);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        SLog.i("Path was cleared.");
          goto _L1
label0:
        {
            if (feedviewholder.post != null)
            {
                break label0;
            }
            SLog.i("Post was cleared.");
        }
          goto _L1
        if (((SdkVideoView) (obj)).isPathPlaying(s)) goto _L5; else goto _L4
_L4:
        if (!SystemUtil.isSinglePlayerEnabled(mContext)) goto _L7; else goto _L6
_L6:
        if (SdkVideoView.getCurrentUri() != null)
        {
            flag1 = false;
        }
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        refreshVideoView(i, feedviewholder);
        obj = feedviewholder.videoView;
        ((SdkVideoView) (obj)).setMute(mMuted);
        if (mNeedReleaseOtherPlayers && currentPlayerCount >= maxPlayer)
        {
            releaseOtherPlayers(feedviewholder.videoView);
        }
        SLog.i("Start playing by set path.");
        ((SdkVideoView) (obj)).setTag(Long.valueOf(feedviewholder.post.postId));
        CrashUtil.log("Setting video path in feed for post {}", new Object[] {
            Long.valueOf(feedviewholder.post.postId)
        });
        ((SdkVideoView) (obj)).setVideoPath(s);
        if (!((SdkVideoView) (obj)).isSurfaceReady() && ((SdkVideoView) (obj)).getVisibility() != 0)
        {
            ((SdkVideoView) (obj)).setVisibility(0);
        }
        currentPlayerCount = currentPlayerCount + 1;
_L8:
        ((SdkVideoView) (obj)).setPlayingPosition(i);
        feedviewholder.listener.setPosition(i);
        if (feedviewholder.imageListener != null)
        {
            feedviewholder.imageListener.setPosition(i);
        }
        mCurrentPlaying = i;
        mLastPlayer = ((SdkVideoView) (obj));
          goto _L1
_L7:
        if (((SdkVideoView) (obj)).getPath() == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        flag1 = false;
        break MISSING_BLOCK_LABEL_157;
_L5:
label1:
        {
            if (feedviewholder.videoView.getVisibility() != 0)
            {
                feedviewholder.videoView.setVisibility(0);
            }
            ((SdkVideoView) (obj)).setMute(mMuted);
            if (!((SdkVideoView) (obj)).isInPlaybackState())
            {
                break label1;
            }
            SLog.i("Start playing by calling start.");
            ((SdkVideoView) (obj)).start();
        }
          goto _L8
        SLog.i("Start playing by set path.");
        ((SdkVideoView) (obj)).setTag(Long.valueOf(feedviewholder.post.postId));
        CrashUtil.log("Setting video path in feed for post {}", new Object[] {
            Long.valueOf(feedviewholder.post.postId)
        });
        ((SdkVideoView) (obj)).setVideoPath(s);
          goto _L8
    }

    public void releaseOtherPlayers(SdkVideoView sdkvideoview)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = mViewHolders.iterator();
_L2:
        FeedViewHolder feedviewholder;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_85;
            }
            feedviewholder = (FeedViewHolder)((WeakReference)iterator.next()).get();
        } while (feedviewholder == null);
        if (sdkvideoview == feedviewholder.videoView) goto _L2; else goto _L1
_L1:
        SLog.d("Releasing player: {}", Integer.valueOf(feedviewholder.position));
        feedviewholder.videoView.suspend();
        currentPlayerCount = currentPlayerCount - 1;
          goto _L2
        sdkvideoview;
        throw sdkvideoview;
        this;
        JVM INSTR monitorexit ;
    }

    public void removePost(long l)
    {
        int i = 0;
        do
        {
label0:
            {
                if (i < mPosts.size())
                {
                    VinePost vinepost = getPost(i);
                    if (vinepost == null || vinepost.postId != l)
                    {
                        break label0;
                    }
                    mPosts.remove(i);
                }
                mPaths.clear();
                mUrlReverse.clear();
                mPlayers.clear();
                notifyDataSetChanged();
                playCurrentPosition();
                return;
            }
            i++;
        } while (true);
    }

    protected void resetStates(boolean flag)
    {
        super.resetStates(flag);
        stopCurrentPlayer();
        mLikeCache.clear();
        mRevineCache.clear();
        mShouldBePlaying = -1;
        currentPlayerCount = 0;
        mFirstPlayed = false;
    }

    public void stopCurrentPlayer()
    {
        if (mLastPlayer != null)
        {
            mLastPlayer.suspend();
            mLastPlayer = null;
            mCurrentPlaying = -1;
        }
    }

    public void toggleMute(boolean flag)
    {
        mMuted = flag;
        SLog.d("Mute state changed to muted? {}.", Boolean.valueOf(flag));
        SdkVideoView sdkvideoview = getLastPlayer();
        if (sdkvideoview != null)
        {
            sdkvideoview.setMute(mMuted);
        }
    }





/*
    static int access$202(FeedAdapter feedadapter, int i)
    {
        feedadapter.maxPlayer = i;
        return i;
    }

*/



/*
    static boolean access$402(FeedAdapter feedadapter, boolean flag)
    {
        feedadapter.mNeedReleaseOtherPlayers = flag;
        return flag;
    }

*/





}
