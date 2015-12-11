// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.support.v4.widget.CursorAdapter;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.Util;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            FindFriendsAddressFragment, Friendships, UsersAdapter

class this._cls0 extends AppSessionListener
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

    ()
    {
        this$0 = FindFriendsAddressFragment.this;
        super();
    }
}
