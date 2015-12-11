// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import co.vine.android.api.VinePagedData;
import co.vine.android.api.VineUser;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.service.GCMNotificationService;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.Util;
import co.vine.android.widget.ActivityViewHolder;
import co.vine.android.widget.OnTabChangedListener;
import co.vine.android.widget.PinnedHeaderListView;
import co.vine.android.widget.SpanClickListener;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            BaseArrayListFragment, HomeTabActivity, ActivityAdapter, ProfileActivity, 
//            SingleActivity, UsersActivity, CommentsActivity, HashtagActivity, 
//            PendingRequest

public class ActivityFragment extends BaseArrayListFragment
    implements SpanClickListener, android.view.View.OnClickListener, OnTabChangedListener
{
    class ActivityListener extends AppSessionListener
    {

        final ActivityFragment this$0;

        public void onFollowComplete(String s, int i, String s1, long l)
        {
            if (removeRequest(s) != null && i != 200)
            {
                ((ActivityAdapter)mAdapter).unfollow(l);
            }
        }

        public void onGetActivityComplete(String s, int i, String s1, VinePagedData vinepageddata, VinePagedData vinepageddata1)
        {
            PendingRequest pendingrequest = removeRequest(s);
            if (pendingrequest != null)
            {
                hideProgress(pendingrequest.fetchType);
                s = Util.getDefaultSharedPrefs(getActivity());
                mPrivate = s.getBoolean("settings_private", false);
                int j = 0;
                int k;
                if (vinepageddata != null)
                {
                    if (vinepageddata.items == null)
                    {
                        j = 0;
                    } else
                    {
                        j = vinepageddata.items.size();
                    }
                }
                k = 0;
                if (vinepageddata1 != null)
                {
                    if (vinepageddata1.items == null)
                    {
                        k = 0;
                    } else
                    {
                        k = vinepageddata1.items.size();
                    }
                }
                if (mAdapter.getCount() == 0 && j == 0 && k == 0)
                {
                    if (i != 200)
                    {
                        mEmptyTextStringRes = 0x7f0e00d8;
                        mEmptyText.setText(mEmptyTextStringRes);
                    }
                    showSadface(true);
                } else
                {
                    showSadface(false);
                }
                if (i == 200)
                {
                    if (vinepageddata != null)
                    {
                        mNextPage = vinepageddata.nextPage;
                        mAnchor = vinepageddata.anchor;
                    }
                    if (mAdapter != null)
                    {
                        ActivityAdapter activityadapter = (ActivityAdapter)mAdapter;
                        boolean flag;
                        if (vinepageddata == null)
                        {
                            s = null;
                        } else
                        {
                            s = vinepageddata.items;
                        }
                        if (vinepageddata1 == null)
                        {
                            s1 = null;
                        } else
                        {
                            s1 = vinepageddata1.items;
                        }
                        if (pendingrequest.fetchType == 1)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        activityadapter.mergeData(s, s1, flag);
                    }
                }
                s = getActivity();
                if (s != null)
                {
                    s.startService(GCMNotificationService.getClearNotificationIntent(getActivity(), 1));
                    ((HomeTabActivity)s).markActivitiesRead();
                }
            }
        }

        public void onGetUsersMeComplete(String s, int i, String s1, long l, VineUser vineuser)
        {
            if (vineuser != null && vineuser.isPrivate())
            {
                mPrivate = true;
            }
        }

        public void onPhotoImageLoaded(HashMap hashmap)
        {
            ((ActivityAdapter)mAdapter).setImages(hashmap);
        }

        public void onUnFollowComplete(String s, int i, String s1, long l)
        {
            if (removeRequest(s) != null && i != 200)
            {
                ((ActivityAdapter)mAdapter).follow(l);
            }
        }

        ActivityListener()
        {
            this$0 = ActivityFragment.this;
            super();
        }
    }


    private static final String EVENT_SOURCE_TITLE = "Activity Feed";
    private static final String STATE_PRIVATE = "state_private";
    private static final String TAG = "ActivityFragment";
    private boolean mFetched;
    private boolean mPrivate;

    public ActivityFragment()
    {
    }

    private void fetchContent(int i)
    {
        fetchContent(i, false);
    }

    private void fetchContent(int i, boolean flag)
    {
        if (hasPendingRequest(i))
        {
            return;
        }
        mFetched = true;
        if (!flag)
        {
            showProgress(i);
        }
        i;
        JVM INSTR tableswitch 2 3: default 48
    //                   2 93
    //                   3 106;
           goto _L1 _L2 _L3
_L1:
        addRequest(mAppController.fetchActivity(mAppController.getActiveSession(), mNextPage, mAnchor, mPrivate, isFocused()), i);
        mAppController.fetchActivityCounts();
        return;
_L2:
        mNextPage = 1;
        mAnchor = 0L;
        continue; /* Loop/switch isn't completed */
_L3:
        mNextPage = 1;
        mAnchor = 0L;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (getArguments().getBoolean("take_focus", false) && !mFetched)
        {
            ((HomeTabActivity)getActivity()).showPage(1, this);
            if (BuildUtil.isLogsOn())
            {
                Log.d("ActivityFragment", "Activity tab took focus.");
            }
        }
    }

    public void onClick(View view)
    {
        ActivityAdapter activityadapter = (ActivityAdapter)mAdapter;
        long l;
        switch (view.getId())
        {
        case 2131361892: 
        case 2131361893: 
        case 2131361895: 
        default:
            return;

        case 2131361891: 
        case 2131361896: 
            ProfileActivity.start(getActivity(), ((Long)view.getTag()).longValue(), "Activity Feed");
            return;

        case 2131361894: 
            l = ((Long)view.getTag()).longValue();
            break;
        }
        if (!((ActivityAdapter)mAdapter).isFollowing(l))
        {
            activityadapter.follow(l);
            addRequest(mAppController.followUser(mAppController.getActiveSession(), l, false));
            return;
        } else
        {
            activityadapter.unfollow(l);
            addRequest(mAppController.unfollowUser(mAppController.getActiveSession(), l, false));
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mAppSessionListener = new ActivityListener();
        if (bundle != null)
        {
            if (bundle.containsKey("state_private"))
            {
                mPrivate = bundle.getBoolean("state_private");
            }
            return;
        } else
        {
            mPrivate = Util.getDefaultSharedPrefs(getActivity()).getBoolean("settings_private", false);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = createView(layoutinflater, 0x7f030060, viewgroup);
        mListView.setDividerHeight(0);
        mAdapter = new ActivityAdapter(getActivity(), mListView, mAppController, this, this);
        mListView.setAdapter(mAdapter);
        if (getActivity() instanceof HomeTabActivity)
        {
            viewgroup = LayoutInflater.from(getActivity()).inflate(0x7f03009d, null);
            ((PinnedHeaderListView)mListView).setRefreshHeader(viewgroup, getResources().getDimensionPixelSize(0x7f0b0084));
            mListView.addHeaderView(viewgroup, null, false);
        }
        return layoutinflater;
    }

    protected void onListItemClick(ListView listview, View view, int i, long l)
    {
        if (view.getTag() instanceof ActivityViewHolder)
        {
            listview = (ActivityViewHolder)view.getTag();
            if (((ActivityViewHolder) (listview)).clickable)
            {
                if (((ActivityViewHolder) (listview)).listItemClickType == 1 && ((ActivityViewHolder) (listview)).postId > 0L)
                {
                    SingleActivity.start(getActivity(), ((ActivityViewHolder) (listview)).postId);
                } else
                {
                    if (((ActivityViewHolder) (listview)).listItemClickType == 0 && ((ActivityViewHolder) (listview)).userId > 0L)
                    {
                        ProfileActivity.start(getActivity(), ((ActivityViewHolder) (listview)).userId, "Activity Feed");
                        return;
                    }
                    if (((ActivityViewHolder) (listview)).listItemClickType == 2 && ((ActivityViewHolder) (listview)).notificationId > 0L)
                    {
                        UsersActivity.launchUserListForNotification(getActivity(), ((ActivityViewHolder) (listview)).notificationId, ((ActivityViewHolder) (listview)).anchor);
                        return;
                    }
                    if (((ActivityViewHolder) (listview)).listItemClickType == 3 && ((ActivityViewHolder) (listview)).postId > 0L)
                    {
                        CommentsActivity.start(getActivity(), ((ActivityViewHolder) (listview)).postId, mAppController.getActiveId(), true);
                        return;
                    }
                }
            }
        }
    }

    public void onMoveAway(int i)
    {
        super.onMoveAway(i);
        mFocused = false;
    }

    public void onMoveTo(int i)
    {
label0:
        {
            super.onMoveTo(i);
            mFocused = true;
            mPrivate = Util.getDefaultSharedPrefs(getActivity()).getBoolean("settings_private", false);
            if (mAdapter != null && !hasPendingRequest())
            {
                if (!mAdapter.isEmpty())
                {
                    break label0;
                }
                fetchContent(3);
            }
            return;
        }
        fetchContent(2, true);
    }

    public void onResume()
    {
        super.onResume();
        if (mAdapter.isEmpty() && !mFetched)
        {
            fetchContent(3);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("state_private", mPrivate);
    }

    protected void onScrollLastItem()
    {
        if (mRefreshable && mNextPage > 0 && mAdapter.getCount() <= 400)
        {
            fetchContent(1);
        }
    }

    public void onSpanClicked(View view, int i, Object obj)
    {
        switch (i)
        {
        case 2: // '\002'
        default:
            switch (view.getId())
            {
            default:
                return;

            case 2131361886: 
                ProfileActivity.start(getActivity(), ((Long)obj).longValue(), "Activity Feed");
                break;
            }
            break;

        case 1: // '\001'
            ProfileActivity.start(getActivity(), ((Long)obj).longValue(), "Activity Feed");
            return;

        case 3: // '\003'
            HashtagActivity.start(getActivity(), (String)obj);
            return;

        case 4: // '\004'
            UsersActivity.launchUserListForNotification(getActivity(), ((Long)((Object[])(Object[])obj)[0]).longValue(), ((Long)((Object[])(Object[])obj)[1]).longValue());
            return;

        case 5: // '\005'
            CommentsActivity.start(getActivity(), ((Long)obj).longValue(), 0L, true);
            return;
        }
    }

    protected void refresh()
    {
        fetchContent(2);
    }


/*
    static boolean access$002(ActivityFragment activityfragment, boolean flag)
    {
        activityfragment.mPrivate = flag;
        return flag;
    }

*/
}
