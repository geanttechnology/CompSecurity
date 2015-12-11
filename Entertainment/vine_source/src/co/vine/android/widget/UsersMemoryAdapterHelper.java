// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import co.vine.android.BaseFragment;
import co.vine.android.FollowButtonViewHolder;
import co.vine.android.Friendships;
import co.vine.android.ListState;
import co.vine.android.PendingRequest;
import co.vine.android.PendingRequestHelper;
import co.vine.android.ProfileActivity;
import co.vine.android.UsersMemoryAdapter;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.Session;
import co.vine.android.service.PendingAction;
import java.util.ArrayList;
import java.util.HashMap;

public class UsersMemoryAdapterHelper
    implements android.view.View.OnClickListener
{
    class UsersAppSessionListener extends AppSessionListener
    {

        final UsersMemoryAdapterHelper this$0;

        public void onCaptchaRequired(String s, String s1, PendingAction pendingaction)
        {
            if (mPendingRequestHelper.removeRequest(s) != null)
            {
                mPendingRequestHelper.onCaptchaRequired(mFragment.getActivity(), s, pendingaction.actionCode, pendingaction.bundle, s1);
            }
        }

        public void onFollowComplete(String s, int i, String s1, long l)
        {
            if (mPendingRequestHelper.removeRequest(s) != null && i != 200)
            {
                mFriendships.removeFollowing(l);
                mAdapter.notifyDataSetChanged();
            }
        }

        public void onGetUsersComplete(Session session, String s, int i, String s1, int j, ArrayList arraylist, int k, 
                int l, long l1)
        {
            boolean flag = true;
            i;
            JVM INSTR tableswitch 200 200: default 24
        //                       200 36;
               goto _L1 _L2
_L1:
            mPendingRequestHelper.hideProgress(3);
_L4:
            return;
_L2:
            session = mPendingRequestHelper.removeRequest(s);
            if (session != null)
            {
                mPendingRequestHelper.hideProgress(((PendingRequest) (session)).fetchType);
                if (mAdapter != null)
                {
                    s = mAdapter;
                    if (((PendingRequest) (session)).fetchType != 1)
                    {
                        flag = false;
                    }
                    s.mergeData(arraylist, flag);
                }
                mNextPage = k;
                mAnchor = l1;
                return;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void onPhotoImageLoaded(HashMap hashmap)
        {
            if (mAdapter != null)
            {
                mAdapter.setUserImages(hashmap);
            }
        }

        public void onUnFollowComplete(String s, int i, String s1, long l)
        {
            if (mPendingRequestHelper.removeRequest(s) != null && i != 200)
            {
                mFriendships.addFollowing(l);
                mAdapter.notifyDataSetChanged();
            }
        }

        UsersAppSessionListener()
        {
            this$0 = UsersMemoryAdapterHelper.this;
            super();
        }
    }


    public static final String ARG_ANCHOR = "anchor";
    public static final String ARG_NOTIFICATION_ID = "notification_id";
    public static final String ARG_POST_ID = "post_id";
    public static final String ARG_PROFILE_ID = "p_id";
    public static final String ARG_USERS_TYPE = "u_type";
    private UsersMemoryAdapter mAdapter;
    private long mAnchor;
    private AppController mAppController;
    private UsersAppSessionListener mAppSessionListener;
    boolean mFetched;
    private final String mFlurryEventSource;
    private final BaseFragment mFragment;
    private Friendships mFriendships;
    private final String mFriendshipsTag;
    private final String mLoadFalgsTag;
    int mLoadFlags;
    private int mNextPage;
    long mNotificationId;
    private long mOriginalAnchor;
    private final PendingRequestHelper mPendingRequestHelper;
    long mPostId;
    long mProfileId;
    private boolean mRefreshable;
    int mUsersType;

    public UsersMemoryAdapterHelper(BaseFragment basefragment, PendingRequestHelper pendingrequesthelper, String s, String s1)
    {
        mNextPage = 1;
        mAnchor = 0L;
        mOriginalAnchor = 0L;
        mFragment = basefragment;
        mPendingRequestHelper = pendingrequesthelper;
        mFlurryEventSource = s;
        mLoadFalgsTag = (new StringBuilder()).append("state_load_flags_").append(s1).toString();
        mFriendshipsTag = (new StringBuilder()).append("state_friendships_").append(s1).toString();
    }

    private void fetchContent(int i)
    {
        if (!mPendingRequestHelper.hasPendingRequest(i)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s = null;
        i;
        JVM INSTR tableswitch 2 4: default 40
    //                   2 119
    //                   3 119
    //                   4 119;
           goto _L3 _L4 _L4 _L4
_L3:
        mUsersType;
        JVM INSTR lookupswitch 5: default 96
    //                   1: 135
    //                   2: 158
    //                   5: 181
    //                   9: 211
    //                   12: 241;
           goto _L5 _L6 _L7 _L8 _L9 _L10
_L5:
        if (s != null)
        {
            mPendingRequestHelper.showProgress(i);
            mPendingRequestHelper.addRequest(s, i);
            return;
        }
          goto _L1
_L4:
        mNextPage = 1;
        mAnchor = mOriginalAnchor;
          goto _L3
_L6:
        s = mAppController.fetchFollowing(mProfileId, mNextPage, mAnchor);
          goto _L5
_L7:
        s = mAppController.fetchFollowers(mProfileId, mNextPage, mAnchor);
          goto _L5
_L8:
        s = mAppController.fetchPostLikers(mAppController.getActiveSession(), mPostId, mNextPage, mAnchor);
          goto _L5
_L9:
        s = mAppController.fetchReviners(mAppController.getActiveSession(), mPostId, mNextPage, mAnchor);
          goto _L5
_L10:
        s = mAppController.fetchNotificationUsers(mAppController.getActiveSession(), mNotificationId, mNextPage, mAnchor);
          goto _L5
    }

    public UsersMemoryAdapter getAdapter(Activity activity, AppController appcontroller)
    {
        if (mAdapter == null)
        {
            mAdapter = new UsersMemoryAdapter(activity, appcontroller, true, this, mFriendships);
            mAppController = appcontroller;
        }
        return mAdapter;
    }

    public AppSessionListener getAppSessionListener()
    {
        if (mAppSessionListener == null)
        {
            mAppSessionListener = new UsersAppSessionListener();
        }
        return mAppSessionListener;
    }

    public PendingRequestHelper getPendingRequestHelper()
    {
        return mPendingRequestHelper;
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131362349 2131362349: default 24
    //                   2131362349 25;
           goto _L1 _L2
_L1:
        return;
_L2:
        if ((view = (FollowButtonViewHolder)view.getTag()) != null && mFriendships != null)
        {
            if (!((FollowButtonViewHolder) (view)).following)
            {
                mPendingRequestHelper.addRequest(mAppController.followUser(mAppController.getActiveSession(), ((FollowButtonViewHolder) (view)).userId, false));
                mFriendships.addFollowing(((FollowButtonViewHolder) (view)).userId);
                mAdapter.notifyDataSetChanged();
                return;
            } else
            {
                mPendingRequestHelper.addRequest(mAppController.unfollowUser(mAppController.getActiveSession(), ((FollowButtonViewHolder) (view)).userId, false, mProfileId));
                mFriendships.removeFollowing(((FollowButtonViewHolder) (view)).userId);
                mAdapter.notifyDataSetChanged();
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onCreate(Bundle bundle, Bundle bundle1, boolean flag)
    {
        mUsersType = bundle.getInt("u_type", -1);
        mProfileId = bundle.getLong("p_id");
        mPostId = bundle.getLong("post_id", -1L);
        mNotificationId = bundle.getLong("notification_id", -1L);
        mOriginalAnchor = bundle.getLong("anchor", -1L);
        mRefreshable = flag;
        if (bundle1 != null)
        {
            mLoadFlags = bundle1.getInt(mLoadFalgsTag);
            if (bundle1.containsKey(mFriendshipsTag))
            {
                mFriendships = (Friendships)bundle1.getParcelable(mFriendshipsTag);
            }
            if (mFriendships == null)
            {
                mFriendships = new Friendships();
            }
            return;
        } else
        {
            mLoadFlags = 0;
            mFriendships = new Friendships();
            return;
        }
    }

    public void onListItemClick(long l)
    {
        if (l > 0L)
        {
            ProfileActivity.start(mFragment.getActivity(), l, mFlurryEventSource);
        }
    }

    public void onResume()
    {
        if (mAdapter.isEmpty() && !mFetched)
        {
            fetchContent(3);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putParcelable(mFriendshipsTag, mFriendships);
        bundle.putInt(mLoadFalgsTag, mLoadFlags);
    }

    public void onScroll(ListState liststate, int i, int j, int k)
    {
        liststate.firstVisibleItem = i;
        liststate.visibleItemCount = j;
        for (liststate.totalItemCount = k; j == 0 || i <= 0 || mAdapter == null || i + j < k - 1 || mAdapter.getCount() <= 0 || !liststate.hasNewScrollState;)
        {
            return;
        }

        liststate.hasNewScrollState = false;
        onScrollLastItem();
    }

    public void onScrollLastItem()
    {
        if (mRefreshable && mNextPage > 0 && mAdapter.getCount() <= 400)
        {
            fetchContent(1);
        }
    }

    public void refresh()
    {
        fetchContent(2);
    }




/*
    static int access$202(UsersMemoryAdapterHelper usersmemoryadapterhelper, int i)
    {
        usersmemoryadapterhelper.mNextPage = i;
        return i;
    }

*/


/*
    static long access$302(UsersMemoryAdapterHelper usersmemoryadapterhelper, long l)
    {
        usersmemoryadapterhelper.mAnchor = l;
        return l;
    }

*/


}
