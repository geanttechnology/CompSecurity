// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.support.v4.widget.CursorAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.Util;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            FindFriendsNUXAddressFragment, Friendships, FindFriendsNUXActivity, UsersAdapter

private class <init> extends AppSessionListener
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
                FindFriendsNUXAddressFragment.access$200(FindFriendsNUXAddressFragment.this).setVisibility(0);
                FindFriendsNUXAddressFragment.access$300(FindFriendsNUXAddressFragment.this).setText(getString(0x7f0e00e3, new Object[] {
                    Integer.valueOf(j)
                }));
                s = FindFriendsNUXAddressFragment.access$500(FindFriendsNUXAddressFragment.this);
                if (FindFriendsNUXAddressFragment.access$400(FindFriendsNUXAddressFragment.this))
                {
                    i = 0x7f0e00b8;
                } else
                {
                    i = 0x7f0e01bc;
                }
                s.setText(i);
                FindFriendsNUXAddressFragment.access$600(FindFriendsNUXAddressFragment.this).addUsersToFollow(arraylist, mFriendships);
                FindFriendsNUXAddressFragment.access$700(FindFriendsNUXAddressFragment.this).addAll(arraylist);
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

    private ()
    {
        this$0 = FindFriendsNUXAddressFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
