// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import co.vine.android.util.FlurryUtils;

// Referenced classes of package co.vine.android:
//            HomeTimelineFragment, FindFriendsActivity

class this._cls0
    implements android.view.._cls1
{

    final HomeTimelineFragment this$0;

    public void onClick(View view)
    {
        FlurryUtils.trackVisitFindFriends("InviteBanner");
        view = new Intent(getActivity(), co/vine/android/FindFriendsActivity);
        getActivity().startActivityForResult(view, 0);
    }

    ()
    {
        this$0 = HomeTimelineFragment.this;
        super();
    }
}
