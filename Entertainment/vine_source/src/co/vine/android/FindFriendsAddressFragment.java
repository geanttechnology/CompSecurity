// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.accounts.AccountManager;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.Session;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.Util;
import co.vine.android.widgets.PromptDialogSupportFragment;
import com.twitter.android.widget.ItemPosition;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            FindFriendsBaseFragment, FollowButtonViewHolder, Friendships, ProfileActivity, 
//            UsersAdapter

public class FindFriendsAddressFragment extends FindFriendsBaseFragment
{
    class FriendsListener extends AppSessionListener
    {

        final FindFriendsAddressFragment this$0;

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
                if (mCursorAdapter.isEmpty())
                {
                    showSadface(true);
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

        FriendsListener()
        {
            this$0 = FindFriendsAddressFragment.this;
            super();
        }
    }


    public FindFriendsAddressFragment()
    {
    }

    public ItemPosition getFirstItemPosition()
    {
        return null;
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
        if ((view = (FollowButtonViewHolder)view.getTag()) != null)
        {
            if (!((FollowButtonViewHolder) (view)).following)
            {
                mAppController.followUser(mAppController.getActiveSession(), ((FollowButtonViewHolder) (view)).userId, true);
                mFriendships.addFollowing(((FollowButtonViewHolder) (view)).userId);
                mCursorAdapter.notifyDataSetChanged();
                mNewFollowsCount = mNewFollowsCount + 1;
                return;
            } else
            {
                mAppController.unfollowUser(mAppController.getActiveSession(), ((FollowButtonViewHolder) (view)).userId, true);
                mFriendships.removeFollowing(((FollowButtonViewHolder) (view)).userId);
                mCursorAdapter.notifyDataSetChanged();
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mAppSessionListener = new FriendsListener();
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
            FlurryUtils.trackAddressNewFollowingCount(s);
        }
        mNewFollowsCount = 0;
    }

    public void onResume()
    {
label0:
        {
            super.onResume();
            if (!mFetched)
            {
                if (!VineAccountHelper.shouldShowStoreContactsPrompt(AccountManager.get(getActivity()), VineAccountHelper.getAccount(getActivity(), mAppController.getActiveSession().getLoginEmail())))
                {
                    break label0;
                }
                PromptDialogSupportFragment promptdialogsupportfragment = PromptDialogSupportFragment.newInstance(1);
                promptdialogsupportfragment.setListener(this);
                promptdialogsupportfragment.setMessage(0x7f0e0234);
                promptdialogsupportfragment.setTitle(0x7f0e0233);
                promptdialogsupportfragment.setNegativeButton(0x7f0e014d);
                promptdialogsupportfragment.setPositiveButton(0x7f0e0163);
                promptdialogsupportfragment.setCancelable(false);
                promptdialogsupportfragment.show(getFragmentManager());
            }
            return;
        }
        fetchContent(3);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        view = LayoutInflater.from(getActivity()).inflate(0x7f03004f, null);
        mListView.addHeaderView(view);
        ((TextView)view.findViewById(0x7f0a0110)).setText(0x7f0e00e2);
    }

    protected void startProfileActivity(long l)
    {
        ProfileActivity.start(getActivity(), l, "Find Friends: Address", true);
    }
}
