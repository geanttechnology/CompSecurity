// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import co.vine.android.api.VineClientFlags;
import co.vine.android.api.VineRepost;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.network.HttpResult;
import co.vine.android.service.PendingAction;
import co.vine.android.util.ClientFlagsHelper;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.video.VideoKey;
import co.vine.android.widget.FeedAdapter;
import co.vine.android.widget.GenericTimelineAdapter;
import com.edisonwang.android.slog.SLog;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            BaseTimelineFragment, PendingRequestHelper, PendingRequest, LikeCache, 
//            RevineCache

class this._cls0 extends AppSessionListener
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
        BaseTimelineFragment.access$100(BaseTimelineFragment.this);
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
    //                   3 218;
           goto _L3 _L4
_L3:
        hideProgress(((PendingRequest) (s)).fetchType);
_L2:
        if (!TextUtils.isEmpty(s3) && BaseTimelineFragment.access$000(BaseTimelineFragment.this).getSupportActionBar() != null)
        {
            BaseTimelineFragment.access$000(BaseTimelineFragment.this).getSupportActionBar().setTitle(s3);
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

    ()
    {
        this$0 = BaseTimelineFragment.this;
        super();
    }
}
