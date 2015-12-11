// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.CursorAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.Util;
import co.vine.android.widgets.PromptDialogSupportFragment;
import com.twitter.android.widget.ItemPosition;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            FindFriendsBaseFragment, FindFriendsNUXActivity, FollowButtonViewHolder, Friendships, 
//            ProfileActivity, UsersAdapter

public class FindFriendsNUXAddressFragment extends FindFriendsBaseFragment
{
    private class FriendsNUXListener extends AppSessionListener
    {

        final FindFriendsNUXAddressFragment this$0;

        public void onFollowComplete(String s, int i, String s1, long l)
        {
            if (s != null && i != 200)
            {
                mFriendships.removeFollowing(l);
            }
        }

        public void onGetAddressFriendsComplete(String s, int i, String s1, int j, ArrayList arraylist)
        {
            hideProgress(3);
            dismissDialog();
            if (s != null && i == 200)
            {
                if (j <= 0)
                {
                    showSadface(true);
                } else
                {
                    showSadface(false);
                    mContactsCountContainer.setVisibility(0);
                    mContactsText.setText(getString(0x7f0e00e3, new Object[] {
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
                    mAddressFriends.addAll(arraylist);
                }
                FlurryUtils.trackFindFriendsAddressCount(j);
                return;
            } else
            {
                showSadface(true);
                Util.showCenteredToast(getActivity(), 0x7f0e00e0);
                FlurryUtils.trackFindFriendsAddressFailure();
                return;
            }
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

        private FriendsNUXListener()
        {
            this$0 = FindFriendsNUXAddressFragment.this;
            super();
        }

    }


    private FindFriendsNUXActivity mActivity;
    private ArrayList mAddressFriends;
    private RelativeLayout mContactsCountContainer;
    private TextView mContactsText;
    private boolean mFilterLoaderIsReady;
    private Runnable mFilterRunnable;
    private Handler mHandler;
    private TextView mSelectAllToggle;
    private boolean mSelected;

    public FindFriendsNUXAddressFragment()
    {
        mFilterRunnable = new Runnable() {

            final FindFriendsNUXAddressFragment this$0;

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
                this$0 = FindFriendsNUXAddressFragment.this;
                super();
            }
        };
    }

    public ItemPosition getFirstItemPosition()
    {
        return null;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mActivity = (FindFriendsNUXActivity)activity;
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 2: default 32
    //                   2131362032: 112
    //                   2131362349: 33;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        if ((view = (FollowButtonViewHolder)view.getTag()) != null)
        {
            if (!((FollowButtonViewHolder) (view)).following)
            {
                mActivity.addUserToFollow(((FollowButtonViewHolder) (view)).userId);
                mFriendships.addFollowing(((FollowButtonViewHolder) (view)).userId);
                mCursorAdapter.notifyDataSetChanged();
                return;
            } else
            {
                mActivity.removeUserToFollow(((FollowButtonViewHolder) (view)).userId);
                mFriendships.removeFollowing(((FollowButtonViewHolder) (view)).userId);
                mCursorAdapter.notifyDataSetChanged();
                return;
            }
        }
          goto _L1
_L2:
        int i;
        boolean flag;
        if (!mSelected)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mSelected = flag;
        mActivity.toggleFollowAll(mSelected, mAddressFriends, mFriendships);
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
        bundle = getArguments();
        if (bundle != null)
        {
            setFocused(bundle.getBoolean("take_focus", true));
        }
        mAppSessionListener = new FriendsNUXListener();
        mSelected = true;
        mAddressFriends = new ArrayList();
        mHandler = new Handler();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        mContactsCountContainer = (RelativeLayout)layoutinflater.findViewById(0x7f0a00ee);
        mContactsText = (TextView)layoutinflater.findViewById(0x7f0a00ef);
        mSelectAllToggle = (TextView)layoutinflater.findViewById(0x7f0a00f0);
        mSelectAllToggle.setOnClickListener(this);
        return layoutinflater;
    }

    public void onMoveTo(int i)
    {
        mActivity.clearSearch();
        if (!mFetched)
        {
            PromptDialogSupportFragment promptdialogsupportfragment = PromptDialogSupportFragment.newInstance(1);
            promptdialogsupportfragment.setListener(this);
            promptdialogsupportfragment.setMessage(0x7f0e0234);
            promptdialogsupportfragment.setTitle(0x7f0e0233);
            promptdialogsupportfragment.setNegativeButton(0x7f0e014d);
            promptdialogsupportfragment.setPositiveButton(0x7f0e0163);
            promptdialogsupportfragment.setCancelable(false);
            promptdialogsupportfragment.show(getFragmentManager());
        }
    }

    public void onResume()
    {
        super.onResume();
        if (isFocused())
        {
            onMoveTo(-1);
        }
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

    protected void startProfileActivity(long l)
    {
        ProfileActivity.start(getActivity(), l, "Find Friends: Address", false);
    }



/*
    static boolean access$102(FindFriendsNUXAddressFragment findfriendsnuxaddressfragment, boolean flag)
    {
        findfriendsnuxaddressfragment.mFilterLoaderIsReady = flag;
        return flag;
    }

*/






}
