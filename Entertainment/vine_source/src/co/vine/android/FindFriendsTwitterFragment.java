// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.accounts.AccountManager;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.Session;
import co.vine.android.client.TwitterVineApp;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.Util;
import co.vine.android.widget.UserViewHolder;
import com.twitter.android.sdk.Twitter;
import com.twitter.android.widget.ItemPosition;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            BaseCursorListFragment, VineLoggingException, ProfileActivity, UsersAdapter, 
//            FindFriendsNUXActivity, FollowButtonViewHolder, Friendships

public class FindFriendsTwitterFragment extends BaseCursorListFragment
    implements android.view.View.OnClickListener, android.widget.AdapterView.OnItemClickListener, FindFriendsNUXActivity.FilterableFriendsList
{
    class FriendsListener extends AppSessionListener
    {

        final FindFriendsTwitterFragment this$0;

        public void onFollowComplete(String s, int i, String s1, long l)
        {
            if (s != null && i != 200)
            {
                mFriendships.removeFollowing(l);
            }
        }

        public void onGetTwitterFriendsComplete(String s, int i, String s1, int j, ArrayList arraylist)
        {
            dismissDialog();
            if (s == null || i != 200)
            {
                break MISSING_BLOCK_LABEL_163;
            }
            FlurryUtils.trackFindFriendsTwitterCount(j);
            if (!mFromSignup || j <= 0) goto _L2; else goto _L1
_L1:
            mContactsCountContainer.setVisibility(0);
            mContactsText.setText(getString(0x7f0e00ec, new Object[] {
                Integer.valueOf(j)
            }));
            s = mSelectAllToggle;
            if (mSelected)
            {
                i = 0x7f0e00b8;
            } else
            {
                i = 0x7f0e01bc;
            }
            s.setText(i);
            mActivity.addUsersToFollow(arraylist, mFriendships);
            mTwitterFriends.addAll(arraylist);
_L4:
            return;
_L2:
            if (j != 0) goto _L4; else goto _L3
_L3:
            Util.showCenteredToast(getActivity(), 0x7f0e00ef);
            return;
            FlurryUtils.trackFindFriendsTwitterFailure();
            Util.showCenteredToast(getActivity(), 0x7f0e00ee);
            return;
        }

        public void onPhotoImageLoaded(HashMap hashmap)
        {
            ((UsersAdapter)mCursorAdapter).setUserImages(hashmap);
        }

        public void onRemoveUsersComplete(String s)
        {
            if (mCursorAdapter.getCursor() == null)
            {
                initLoader();
            }
        }

        public void onUnFollowComplete(String s, int i, String s1, long l)
        {
            if (s != null && i != 200)
            {
                mFriendships.addFollowing(l);
            }
        }

        FriendsListener()
        {
            this$0 = FindFriendsTwitterFragment.this;
            super();
        }
    }


    public static final String ARG_FROM_SIGN_UP = "from_sign_up";
    private static final String EVENT_SOURCE_TITLE = "Find Friends: Twitter";
    protected static final int LOADER_ID_FILTER = 1;
    private static final String STATE_FETCHED = "fetch";
    private static final String STATE_FRIENDSHIPS = "friendships";
    private static final String STATE_FROM_SIGN_UP = "from_sign_up";
    private FindFriendsNUXActivity mActivity;
    private StyleSpan mBold[];
    private RelativeLayout mContactsCountContainer;
    private TextView mContactsText;
    private boolean mFetched;
    private boolean mFilterLoaderIsReady;
    private Runnable mFilterRunnable;
    private Friendships mFriendships;
    private boolean mFromSignup;
    private int mNewFollowsCount;
    private String mProjection[];
    private volatile String mSearchQuery;
    private String mSecret;
    private TextView mSelectAllToggle;
    private boolean mSelected;
    private String mSortOrder;
    private String mToken;
    private Twitter mTwitter;
    private ArrayList mTwitterFriends;

    public FindFriendsTwitterFragment()
    {
        mFilterRunnable = new Runnable() {

            final FindFriendsTwitterFragment this$0;

            public void run()
            {
                if (!mFilterLoaderIsReady)
                {
                    initLoader(1);
                    mFilterLoaderIsReady = true;
                    return;
                } else
                {
                    restartLoader(1);
                    return;
                }
            }

            
            {
                this$0 = FindFriendsTwitterFragment.this;
                super();
            }
        };
    }

    private void fetchContent(int i)
    {
        mFetched = true;
        android.support.v4.app.FragmentActivity fragmentactivity;
        switch (i)
        {
        default:
            return;

        case 3: // '\003'
            fragmentactivity = getActivity();
            break;
        }
        Object obj = mAppController.getActiveSession().getLoginEmail();
        android.accounts.Account account = VineAccountHelper.getAccount(fragmentactivity, ((String) (obj)));
        if (account == null)
        {
            CrashUtil.logException(new VineLoggingException("Find Friends Twitter account was null"), "Find Friends Twitter account was null. UniqueLogin: {} ", new Object[] {
                obj
            });
            Util.showCenteredToast(fragmentactivity, 0x7f0e00ee);
            return;
        }
        obj = AccountManager.get(getActivity());
        mToken = ((AccountManager) (obj)).getUserData(account, "account_t_token");
        mSecret = ((AccountManager) (obj)).getUserData(account, "account_t_secret");
        if (mToken == null || mSecret == null)
        {
            AppController.startTwitterAuthWithFinish(mTwitter, fragmentactivity);
            return;
        } else
        {
            fetchTwitterFriends(mToken, mSecret);
            return;
        }
    }

    private void fetchTwitterFriends(String s, String s1)
    {
        ProgressDialog progressdialog = new ProgressDialog(getActivity(), 0x7f0f0037);
        progressdialog.setProgress(0);
        progressdialog.setMessage(getString(0x7f0e00f5));
        progressdialog.show();
        mProgressDialog = progressdialog;
        mAppController.fetchTwitterFriends(mAppController.getActiveSession(), s, s1);
    }

    private void startProfileActivity(long l)
    {
        ProfileActivity.start(getActivity(), l, "Find Friends: Twitter", false);
    }

    public ItemPosition getFirstItemPosition()
    {
        return null;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (mCursorAdapter == null)
        {
            mProjection = co.vine.android.provider.VineDatabaseSQL.UsersQuery.PROJECTION;
            mSortOrder = "username ASC";
            mCursorAdapter = new UsersAdapter(getActivity(), mAppController, true, this, mFriendships, 0);
        }
        mListView.setAdapter(mCursorAdapter);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 1 2: default 24
    //                   1 32
    //                   2 91;
           goto _L1 _L2 _L3
_L1:
        super.onActivityResult(i, j, intent);
_L5:
        return;
_L2:
        if (j == -1)
        {
            mToken = intent.getStringExtra("tk");
            mSecret = intent.getStringExtra("ts");
            fetchTwitterFriends(mToken, mSecret);
            return;
        }
        if (j != 0)
        {
            dismissDialog();
            Util.showCenteredToast(getActivity(), 0x7f0e00f0);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (j == -1)
        {
            mToken = intent.getStringExtra("token");
            mSecret = intent.getStringExtra("secret");
            fetchTwitterFriends(mToken, mSecret);
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (activity instanceof FindFriendsNUXActivity)
        {
            mActivity = (FindFriendsNUXActivity)activity;
        }
    }

    public void onClick(View view)
    {
        boolean flag = true;
        view.getId();
        JVM INSTR lookupswitch 3: default 40
    //                   2131362032: 195
    //                   2131362038: 41
    //                   2131362349: 46;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L3:
        fetchContent(3);
_L4:
        view = (FollowButtonViewHolder)view.getTag();
        if (view != null)
        {
            if (!((FollowButtonViewHolder) (view)).following)
            {
                if (mFromSignup)
                {
                    mActivity.addUserToFollow(((FollowButtonViewHolder) (view)).userId);
                } else
                {
                    mAppController.followUser(mAppController.getActiveSession(), ((FollowButtonViewHolder) (view)).userId, true);
                }
                mFriendships.addFollowing(((FollowButtonViewHolder) (view)).userId);
                mCursorAdapter.notifyDataSetChanged();
                mNewFollowsCount = mNewFollowsCount + 1;
                return;
            }
            if (mFromSignup)
            {
                mActivity.removeUserToFollow(((FollowButtonViewHolder) (view)).userId);
            } else
            {
                mAppController.unfollowUser(mAppController.getActiveSession(), ((FollowButtonViewHolder) (view)).userId, true);
            }
            mFriendships.removeFollowing(((FollowButtonViewHolder) (view)).userId);
            mCursorAdapter.notifyDataSetChanged();
            return;
        }
          goto _L1
_L2:
        int i;
        if (mSelected)
        {
            flag = false;
        }
        mSelected = flag;
        mActivity.toggleFollowAll(mSelected, mTwitterFriends, mFriendships);
        view = mSelectAllToggle;
        if (mSelected)
        {
            i = 0x7f0e00b8;
        } else
        {
            i = 0x7f0e01bc;
        }
        view.setText(i);
        mCursorAdapter.notifyDataSetChanged();
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mBold = (new StyleSpan[] {
            new StyleSpan(1)
        });
        if (bundle == null) goto _L2; else goto _L1
_L1:
        if (bundle.containsKey("fetch"))
        {
            mFetched = bundle.getBoolean("fetch");
        }
        if (bundle.containsKey("friendships"))
        {
            mFriendships = (Friendships)bundle.getParcelable("friendships");
        }
        if (bundle.containsKey("from_sign_up"))
        {
            mFromSignup = bundle.getBoolean("from_sign_up");
        }
_L4:
        mAppController.removeUsers(mAppController.getActiveSession(), 6);
        mTwitter = new Twitter(TwitterVineApp.API_KEY, TwitterVineApp.API_SECRET);
        mAppSessionListener = new FriendsListener();
        mSelected = true;
        mTwitterFriends = new ArrayList();
        return;
_L2:
        mFriendships = new Friendships();
        bundle = getArguments();
        if (bundle != null)
        {
            mFromSignup = bundle.getBoolean("from_sign_up");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        switch (i)
        {
        default:
            bundle = ContentUris.withAppendedId(co.vine.android.provider.Vine.UserGroupsView.CONTENT_URI_FIND_FRIENDS_TWITTER, mAppController.getActiveId());
            return new CursorLoader(getActivity(), bundle, mProjection, null, null, mSortOrder);

        case 1: // '\001'
            bundle = ContentUris.withAppendedId(co.vine.android.provider.Vine.UserGroupsView.CONTENT_URI_FRIENDS_FILTER, mAppController.getActiveId()).buildUpon();
            break;
        }
        bundle.appendQueryParameter("filter", Uri.encode(mSearchQuery));
        bundle.appendQueryParameter("group_type", String.valueOf(6));
        return new CursorLoader(getActivity(), bundle.build(), mProjection, null, null, mSortOrder);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030041, viewgroup, false);
        mListView = (ListView)layoutinflater.findViewById(0x102000a);
        mListView.setEmptyView(layoutinflater.findViewById(0x1020004));
        mListView.setOnItemClickListener(this);
        mContactsCountContainer = (RelativeLayout)layoutinflater.findViewById(0x7f0a00ee);
        mContactsText = (TextView)layoutinflater.findViewById(0x7f0a00ef);
        mSelectAllToggle = (TextView)layoutinflater.findViewById(0x7f0a00f0);
        mSelectAllToggle.setOnClickListener(this);
        viewgroup = (Button)layoutinflater.findViewById(0x7f0a00f6);
        viewgroup.setText(Util.getSpannedText(mBold, getString(0x7f0e00ed), '"'));
        viewgroup.setOnClickListener(this);
        return layoutinflater;
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (view.getTag() instanceof UserViewHolder)
        {
            startProfileActivity(((UserViewHolder)view.getTag()).userId);
        }
    }

    public void onLoadFinished(Loader loader, Cursor cursor)
    {
        super.onLoadFinished(loader, cursor);
        if (mActivity != null && cursor.getCount() > 0 && mFromSignup)
        {
            mActivity.showSearchIcon(true);
        }
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Cursor)obj);
    }

    public void onLoaderReset(Loader loader)
    {
        mCursorAdapter.swapCursor(null);
    }

    public void onMoveAway(int i)
    {
        super.onMoveAway(i);
        if (mFetched)
        {
            String s;
            if (mNewFollowsCount > 15)
            {
                s = ">15";
            } else
            {
                s = String.valueOf(mNewFollowsCount);
            }
            FlurryUtils.trackTwitterNewFollowingCount(s);
        }
        mNewFollowsCount = 0;
    }

    public void onMoveTo(int i)
    {
        super.onMoveTo(i);
        if (mActivity != null)
        {
            mActivity.clearSearch();
        }
    }

    public void onResume()
    {
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("fetch", mFetched);
        bundle.putParcelable("friendships", mFriendships);
        bundle.putBoolean("from_sign_up", mFromSignup);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        mHandler.removeCallbacks(mFilterRunnable);
        mSearchQuery = charsequence.toString();
        if (!TextUtils.isEmpty(mSearchQuery))
        {
            mHandler.postDelayed(mFilterRunnable, 300L);
            return;
        } else
        {
            restartLoader(0);
            return;
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        if (!mFromSignup)
        {
            view = LayoutInflater.from(getActivity()).inflate(0x7f03004f, null);
            mListView.addHeaderView(view);
            ((TextView)view.findViewById(0x7f0a0110)).setText(0x7f0e00f1);
        }
    }

    public boolean shouldShowSearchIcon()
    {
        return mCursorAdapter != null && !mCursorAdapter.isEmpty();
    }



/*
    static boolean access$002(FindFriendsTwitterFragment findfriendstwitterfragment, boolean flag)
    {
        findfriendstwitterfragment.mFilterLoaderIsReady = flag;
        return flag;
    }

*/








}
