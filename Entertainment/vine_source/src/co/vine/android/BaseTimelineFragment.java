// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co.vine.android.api.VineClientFlags;
import co.vine.android.api.VinePost;
import co.vine.android.api.VineRepost;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.Session;
import co.vine.android.network.HttpResult;
import co.vine.android.service.PendingAction;
import co.vine.android.service.VineService;
import co.vine.android.util.ClientFlagsHelper;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.MuteUtil;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.video.VideoKey;
import co.vine.android.widget.FeedAdapter;
import co.vine.android.widget.GenericTimelineAdapter;
import co.vine.android.widget.PinnedHeaderListView;
import co.vine.android.widget.SpanClickListener;
import com.edisonwang.android.slog.SLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// Referenced classes of package co.vine.android:
//            BaseArrayListFragment, VineSpanClicker, HomeTabActivity, PostOptionsDialogActivity, 
//            LikeCache, RevineCache, PendingRequestHelper, PendingRequest

public abstract class BaseTimelineFragment extends BaseArrayListFragment
    implements SpanClickListener, android.view.View.OnClickListener
{
    class TimeLineSessionListener extends AppSessionListener
    {

        final BaseTimelineFragment this$0;

        public void onAbortAllRequestsComplete()
        {
            refreshSilently();
        }

        public void onCaptchaRequired(String s, String s1, PendingAction pendingaction)
        {
            if (removeRequest(s) != null)
            {
                mPendingRequestHelper.onCaptchaRequired(getActivity(), s, pendingaction.actionCode, pendingaction.bundle, s1);
            }
        }

        public void onDeletePostComplete(String s, long l, int i, String s1)
        {
label0:
            {
                if (removeRequest(s) != null)
                {
                    if (i != 200)
                    {
                        break label0;
                    }
                    Util.showCenteredToast(getActivity(), 0x7f0e0179);
                }
                return;
            }
            Util.showCenteredToast(getActivity(), 0x7f0e017a);
        }

        public void onFetchClientFlagsComplete(String s, int i, String s1, VineClientFlags vineclientflags, boolean flag)
        {
label0:
            {
                if (i == 200 && isFocused() && !mClientFlagsBannerWasDismissed)
                {
                    if (!flag)
                    {
                        break label0;
                    }
                    showClientFlagsBanner();
                    populateClientFlagsBanner(vineclientflags.messageTitle, vineclientflags.messageText);
                }
                return;
            }
            hideClientFlagsBanner();
        }

        public void onGetCommentsComplete(String s, int i, String s1, int j, long l, ArrayList arraylist)
        {
            super.onGetCommentsComplete(s, i, s1, j, l, arraylist);
        }

        public void onGetTimeLineComplete(String s, int i, String s1, int j, int k, boolean flag, ArrayList arraylist, 
                String s2, int l, int i1, int j1, long l1, boolean flag1, 
                int k1, String s3)
        {
            s = removeRequest(s);
            if (s == null) goto _L2; else goto _L1
_L1:
            if (flag && i == 200)
            {
                if (SLog.sLogsOn && mFeedAdapter.getStartLoadingTime() > 0L)
                {
                    SLog.i("Time since started loading to end fetch: {}ms", Long.valueOf(mFeedAdapter.timeSinceStartLoadingTime()));
                }
                if (arraylist != null)
                {
                    mNextPage = i1;
                    mAnchor = l1;
                    s1 = (FeedAdapter)mAdapter;
                    if (((PendingRequest) (s)).fetchType == 1)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    s1.mergePosts(arraylist, flag);
                    mAppController.saveLoadedPosts(arraylist, j, s2, l, i1, j1, l1, false);
                }
            }
            ((PendingRequest) (s)).fetchType;
            JVM INSTR tableswitch 3 3: default 164
        //                       3 218;
               goto _L3 _L4
_L3:
            hideProgress(((PendingRequest) (s)).fetchType);
_L2:
            if (!TextUtils.isEmpty(s3) && mCallback.getSupportActionBar() != null)
            {
                mCallback.getSupportActionBar().setTitle(s3);
            }
            return;
_L4:
            if (mAdapter != null && mAdapter.isEmpty() && k == 0)
            {
                hideProgress(((PendingRequest) (s)).fetchType);
                showSadface(true);
            } else
            {
                showSadface(false);
            }
            if (true) goto _L2; else goto _L5
_L5:
        }

        public void onLikePost(String s, int i, String s1, long l)
        {
            if (removeRequest(s) != null && i != 200)
            {
                mLikeCache.removeEntry(l);
                mFeedAdapter.showUnlikedByMe(l);
                mAdapter.notifyDataSetChanged();
            }
        }

        public void onLowMemory()
        {
            super.onLowMemory();
            GenericTimelineAdapter generictimelineadapter = mFeedAdapter;
            if (generictimelineadapter != null)
            {
                generictimelineadapter.onLowMemory();
            }
        }

        public void onMobileDataNetworkActivated()
        {
            if (ClientFlagsHelper.shouldShowClientFlagsBanner(getActivity()) && isFocused())
            {
                showClientFlagsBanner();
                Object obj = Util.getDefaultSharedPrefs(getActivity());
                String s = ((SharedPreferences) (obj)).getString("client_flags_message_title", null);
                obj = ((SharedPreferences) (obj)).getString("client_flags_message_text", null);
                populateClientFlagsBanner(s, ((String) (obj)));
            }
        }

        public void onPhotoImageError(ImageKey imagekey, HttpResult httpresult)
        {
            SLog.e((new StringBuilder()).append("Download of image failed: ").append(httpresult.reasonPhrase).append(" key: ").append(imagekey.url).toString());
        }

        public void onPhotoImageLoaded(HashMap hashmap)
        {
            mFeedAdapter.setImages(hashmap);
        }

        public void onReportPostComplete(String s, int i, String s1, long l)
        {
label0:
            {
                if (removeRequest(s) != null)
                {
                    if (i != 200)
                    {
                        break label0;
                    }
                    Util.showCenteredToast(getActivity(), 0x7f0e017e);
                }
                return;
            }
            Util.showCenteredToast(getActivity(), 0x7f0e017f);
        }

        public void onRevine(String s, int i, String s1, long l, VineRepost vinerepost)
        {
            if (removeRequest(s) != null && i == 200)
            {
                mRevineCache.revine(l);
                mRevineCache.putMyRepostId(l, vinerepost.repostId);
                mAdapter.notifyDataSetChanged();
                mFeedAdapter.updateRevinedCount(l, true);
            }
        }

        public void onTrimMemory(int i)
        {
            super.onTrimMemory(i);
            GenericTimelineAdapter generictimelineadapter = mFeedAdapter;
            if (generictimelineadapter != null)
            {
                generictimelineadapter.onTrimMemory(i);
            }
        }

        public void onUnlikePost(String s, int i, String s1, long l)
        {
            if (removeRequest(s) != null && i != 200)
            {
                mLikeCache.like(l);
                mFeedAdapter.showLikedByMe(l);
                mAdapter.notifyDataSetChanged();
            }
        }

        public void onUnrevine(String s, int i, String s1, long l)
        {
            if (removeRequest(s) != null && i == 200)
            {
                mRevineCache.unRevine(l);
                mRevineCache.removeMyRepostId(l);
                mAdapter.notifyDataSetChanged();
                mFeedAdapter.updateRevinedCount(l, false);
            }
        }

        public void onVideoPathError(VideoKey videokey, HttpResult httpresult)
        {
            SLog.e((new StringBuilder()).append("Download of video failed: ").append(httpresult.reasonPhrase).append(" key: ").append(videokey.url).toString());
        }

        public void onVideoPathObtained(HashMap hashmap)
        {
            mFeedAdapter.onVideoPathObtained(hashmap);
        }

        TimeLineSessionListener()
        {
            this$0 = BaseTimelineFragment.this;
            super();
        }
    }


    private static final int REQUEST_CODE_OPTIONS = 10;
    private static final String STATE_LIKE_CACHE = "state_like_cache";
    private static final String STATE_REVINE_CACHE = "state_revine_cache";
    private ActionBarActivity mCallback;
    protected ViewGroup mClientFlagsBannerParent;
    protected boolean mClientFlagsBannerWasDismissed;
    protected GenericTimelineAdapter mFeedAdapter;
    protected boolean mFetched;
    private String mFlurryEventSource;
    protected final HashSet mHeaderParents = new HashSet();
    protected int mLastFetchType;
    protected LikeCache mLikeCache;
    protected final BroadcastReceiver mMergePostReceiver = new BroadcastReceiver() {

        final BaseTimelineFragment this$0;

        public void onReceive(Context context, Intent intent)
        {
            if (intent != null && "co.vine.android.service.mergePostFeed".equals(intent.getAction()))
            {
                context = (VinePost)intent.getExtras().getParcelable("post");
                ((FeedAdapter)mFeedAdapter).mergeMyPost(context);
            }
        }

            
            {
                this$0 = BaseTimelineFragment.this;
                super();
            }
    };
    private boolean mMergePostReceiverRegistered;
    private final BroadcastReceiver mMuteChangeReceiver = new BroadcastReceiver() {

        final BaseTimelineFragment this$0;

        public void onReceive(Context context, Intent intent)
        {
            if (intent == null || intent.getAction() == null)
            {
                CrashUtil.log("Something wrong has happened");
                return;
            } else
            {
                boolean flag = intent.getAction().equals(MuteUtil.ACTION_CHANGED_TO_MUTE);
                mFeedAdapter.toggleMute(flag);
                return;
            }
        }

            
            {
                this$0 = BaseTimelineFragment.this;
                super();
            }
    };
    protected RevineCache mRevineCache;
    protected final VineSpanClicker mVineSpanClicker = new VineSpanClicker(this);

    public BaseTimelineFragment()
    {
        mMergePostReceiverRegistered = false;
    }

    private void hideClientFlagsBanner()
    {
        if (mClientFlagsBannerParent != null)
        {
            mClientFlagsBannerParent.findViewById(0x7f0a0237).setVisibility(8);
        }
    }

    public void addHeaderView(View view, Object obj, boolean flag)
    {
        mListView.addHeaderView(view, obj, flag);
        mHeaderParents.add(view);
    }

    protected void fetchContent(int i, boolean flag)
    {
        mLastFetchType = i;
        if (hasPendingRequest(i))
        {
            return;
        }
        mFetched = true;
        i;
        JVM INSTR tableswitch 2 4: default 48
    //                   2 77
    //                   3 77
    //                   4 77;
           goto _L1 _L2 _L2 _L2
_L1:
        if (flag)
        {
            showProgress(i);
        }
        addRequest(fetchPosts(mNextPage, mAnchor, flag), i);
        return;
_L2:
        mNextPage = 1;
        mAnchor = 0L;
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected abstract String fetchPosts(int i, long l, boolean flag);

    public HashSet getHeaderViewParents()
    {
        return mHeaderParents;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = getActivity();
        if (getActivity() instanceof HomeTabActivity)
        {
            setUpUnderNavHeader();
        }
        mFeedAdapter = new FeedAdapter(bundle, mListView, mLikeCache, mRevineCache, this, mFlurryEventSource);
        mAdapter = mFeedAdapter;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        switch (i)
        {
        default:
            super.onActivityResult(i, j, intent);
            return;

        case 10: // '\n'
            processPostOptionsResult(PostOptionsDialogActivity.onActivityResult(mAppController, getActivity(), j, intent));
            break;
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (activity instanceof ActionBarActivity)
        {
            mCallback = (ActionBarActivity)activity;
        }
    }

    public boolean onBackPressed()
    {
        return mFeedAdapter.onBackPressed();
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 4: default 48
    //                   2131362125: 190
    //                   2131362127: 49
    //                   2131362129: 243
    //                   2131362361: 310;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L3:
        view = (Long)view.getTag();
        if (mLikeCache.isLike(view.longValue()))
        {
            addRequest(mAppController.unlikePost(mFlurryEventSource, mAppController.getActiveSession(), view.longValue(), false));
            mLikeCache.unlike(view.longValue());
            mFeedAdapter.showUnlikedByMe(view.longValue());
            return;
        } else
        {
            addRequest(mAppController.likePost(mFlurryEventSource, mAppController.getActiveSession(), view.longValue(), mAppController.getActiveId(), mAppController.getActiveSession().getName(), false));
            mLikeCache.like(view.longValue());
            mFeedAdapter.showLikedByMe(view.longValue());
            return;
        }
_L2:
        view = (VinePost)view.getTag();
        FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity != null)
        {
            boolean flag;
            if (((VinePost) (view)).userId == mAppController.getActiveId())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            fragmentactivity.startActivityForResult(PostOptionsDialogActivity.getMoreIntent(view, fragmentactivity, flag, false), 10);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        view = (VinePost)view.getTag();
        FragmentActivity fragmentactivity1 = getActivity();
        if (fragmentactivity1 != null)
        {
            boolean flag1;
            if (((VinePost) (view)).userId == mAppController.getActiveId())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            fragmentactivity1.startActivityForResult(PostOptionsDialogActivity.getShareIntent(view, fragmentactivity1, flag1, mRevineCache.getMyRepostId(((VinePost) (view)).postId), mFlurryEventSource), 10);
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
        hideClientFlagsBanner();
        mClientFlagsBannerWasDismissed = true;
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mAppSessionListener = new TimeLineSessionListener();
        if (bundle != null && bundle.containsKey("state_like_cache"))
        {
            mLikeCache = (LikeCache)bundle.getParcelable("state_like_cache");
            mRevineCache = (RevineCache)bundle.getParcelable("state_revine_cache");
            return;
        } else
        {
            mLikeCache = new LikeCache();
            mRevineCache = new RevineCache();
            return;
        }
    }

    public void onDestroy()
    {
        try
        {
            super.onDestroy();
            mFeedAdapter.onDestroy();
            return;
        }
        catch (Exception exception)
        {
            CrashUtil.logException(exception, "Failed to remove timeline fragment", new Object[0]);
        }
    }

    public void onDestroyView()
    {
        mFeedAdapter.onDestroyView();
        if (mMergePostReceiverRegistered)
        {
            getActivity().unregisterReceiver(mMergePostReceiver);
        }
        super.onDestroyView();
    }

    public void onMoveAway(int i)
    {
        super.onMoveAway(i);
        mFeedAdapter.onPause(isFocused());
    }

    public void onMoveTo(int i)
    {
        super.onMoveTo(i);
        if (mAdapter.isEmpty())
        {
            fetchContent(3, true);
        }
        mFeedAdapter.onResume(isFocused());
    }

    public void onPause()
    {
        super.onPause();
        getActivity().unregisterReceiver(mMuteChangeReceiver);
    }

    public void onResume()
    {
        super.onResume();
        getActivity().registerReceiver(mMuteChangeReceiver, MuteUtil.MUTE_INTENT_FILTER, "co.vine.android.BROADCAST", null);
    }

    public void onRevineBySpanClicked(long l)
    {
        mVineSpanClicker.onRevineBySpanClicked(l);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("state_like_cache", mLikeCache);
        bundle.putParcelable("state_revine_cache", mRevineCache);
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        super.onScroll(abslistview, i, j, k);
    }

    protected void onScrollLastItem()
    {
        if (mRefreshable && mNextPage > 0 && mAdapter.getCount() <= 400)
        {
            mFeedAdapter.onPause(isFocused());
            fetchContent(1, true);
            showProgress(1);
            FlurryUtils.trackTimeLinePageScroll(getClass().getName(), mNextPage);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        this;
        JVM INSTR monitorenter ;
        super.onScrollStateChanged(abslistview, i);
        mFeedAdapter.onScrollStateChanged(abslistview, i);
        this;
        JVM INSTR monitorexit ;
        return;
        abslistview;
        throw abslistview;
    }

    public void onSpanClicked(View view, int i, Object obj)
    {
        mVineSpanClicker.onSpanClicked(view, i, obj);
    }

    protected void populateClientFlagsBanner(String s, String s1)
    {
        if (!TextUtils.isEmpty(s))
        {
            setBannerText(0x7f0a008d, s);
        }
        if (!TextUtils.isEmpty(s1))
        {
            setBannerText(0x7f0a0093, s1);
        }
    }

    protected void refresh()
    {
        hideProgress(2);
        fetchContent(2, true);
    }

    protected void refreshSilently()
    {
        hideProgress(2);
        fetchContent(2, false);
    }

    public void registerMergePostReceiver()
    {
        mMergePostReceiverRegistered = true;
        getActivity().registerReceiver(mMergePostReceiver, VineService.SHOW_POST_FILTER, "co.vine.android.BROADCAST", null);
    }

    protected void setBannerText(int i, String s)
    {
        if (mClientFlagsBannerParent != null)
        {
            ((TextView)mClientFlagsBannerParent.findViewById(i)).setText(s);
        }
    }

    protected void setFlurryEventSource(String s)
    {
        mFlurryEventSource = s;
        mVineSpanClicker.setFlurryEventSource(s);
    }

    public void setUpUnderNavHeader()
    {
        View view = LayoutInflater.from(getActivity()).inflate(0x7f03009d, null);
        ((PinnedHeaderListView)mListView).setRefreshHeader(view, getResources().getDimensionPixelSize(0x7f0b0084));
        addHeaderView(view, null, false);
    }

    protected void showClientFlagsBanner()
    {
        if (mClientFlagsBannerParent == null)
        {
            ListView listview = mListView;
            RelativeLayout relativelayout = (RelativeLayout)LayoutInflater.from(getActivity()).inflate(0x7f0300ab, listview, false);
            ImageButton imagebutton = (ImageButton)relativelayout.findViewById(0x7f0a0239);
            imagebutton.setColorFilter(getResources().getColor(0x7f090027));
            imagebutton.setOnClickListener(this);
            listview.addHeaderView(relativelayout);
            mClientFlagsBannerParent = relativelayout;
        }
        ViewGroup viewgroup = (ViewGroup)mClientFlagsBannerParent.findViewById(0x7f0a0237);
        int i = viewgroup.getVisibility();
        viewgroup.setVisibility(0);
        if (i != 0)
        {
            mFeedAdapter.notifyDataSetChanged();
        }
    }

    protected boolean trackNewCount()
    {
        return false;
    }


}
