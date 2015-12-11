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
//            FindFriendsTwitterFragment, Friendships, FindFriendsNUXActivity, UsersAdapter

class this._cls0 extends AppSessionListener
{

    final FindFriendsTwitterFragment this$0;

    public void onFollowComplete(String s, int i, String s1, long l)
    {
        if (s != null && i != 200)
        {
            FindFriendsTwitterFragment.access$600(FindFriendsTwitterFragment.this).removeFollowing(l);
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
        if (!FindFriendsTwitterFragment.access$100(FindFriendsTwitterFragment.this) || j <= 0) goto _L2; else goto _L1
_L1:
        FindFriendsTwitterFragment.access$200(FindFriendsTwitterFragment.this).setVisibility(0);
        FindFriendsTwitterFragment.access$300(FindFriendsTwitterFragment.this).setText(getString(0x7f0e00ec, new Object[] {
            Integer.valueOf(j)
        }));
        s = FindFriendsTwitterFragment.access$500(FindFriendsTwitterFragment.this);
        if (FindFriendsTwitterFragment.access$400(FindFriendsTwitterFragment.this))
        {
            i = 0x7f0e00b8;
        } else
        {
            i = 0x7f0e01bc;
        }
        s.setText(i);
        FindFriendsTwitterFragment.access$700(FindFriendsTwitterFragment.this).addUsersToFollow(arraylist, FindFriendsTwitterFragment.access$600(FindFriendsTwitterFragment.this));
        FindFriendsTwitterFragment.access$800(FindFriendsTwitterFragment.this).addAll(arraylist);
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
            FindFriendsTwitterFragment.access$600(FindFriendsTwitterFragment.this).addFollowing(l);
        }
    }

    ()
    {
        this$0 = FindFriendsTwitterFragment.this;
        super();
    }
}
