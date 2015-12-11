// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import co.vine.android.util.ConversationMenuHelper;
import co.vine.android.util.Util;

// Referenced classes of package co.vine.android:
//            InboxFragment, Settings, BaseActionBarActivity

class r extends BroadcastReceiver
{

    final InboxFragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        int i = Util.getDefaultSharedPrefs(getActivity()).getInt("profile_background", Settings.DEFAULT_PROFILE_COLOR);
        ((ConversationMenuHelper)((BaseActionBarActivity)getActivity()).getSlidingMenuHelper()).setPersonalizedColor(i);
    }

    nMenuHelper()
    {
        this$0 = InboxFragment.this;
        super();
    }
}
