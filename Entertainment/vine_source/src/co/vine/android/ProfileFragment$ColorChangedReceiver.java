// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import co.vine.android.api.VineUser;
import co.vine.android.util.Util;
import co.vine.android.widget.GenericTimelineAdapter;

// Referenced classes of package co.vine.android:
//            ProfileFragment, BaseControllerActionBarActivity, Settings

private class <init> extends BroadcastReceiver
{

    final ProfileFragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (intent != null && "co.vine.android.profileColor".equals(intent.getAction()) && ProfileFragment.access$400(ProfileFragment.this) != null && mFocused)
        {
            context = (BaseControllerActionBarActivity)getActivity();
            ProfileFragment.access$400(ProfileFragment.this).profileBackground = Util.getDefaultSharedPrefs(context).getInt("profile_background", Settings.DEFAULT_PROFILE_COLOR);
            context.setActionBarColor(ProfileFragment.access$400(ProfileFragment.this).profileBackground);
            context.notifyColorChange(ProfileFragment.access$400(ProfileFragment.this).profileBackground);
            if (mFeedAdapter != null)
            {
                mFeedAdapter.notifyDataSetChanged();
            }
        }
    }

    private ()
    {
        this$0 = ProfileFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
