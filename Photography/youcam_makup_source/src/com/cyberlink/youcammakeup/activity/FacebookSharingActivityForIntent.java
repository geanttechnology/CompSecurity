// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import com.cyberlink.youcammakeup.Globals;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            FacebookSharingActivity, FacebookFriendPickerActivityForIntent, FacebookPlacePickerActivityForIntent

public class FacebookSharingActivityForIntent extends FacebookSharingActivity
{

    public FacebookSharingActivityForIntent()
    {
    }

    protected void a(FacebookSharingActivity.FacebookAction facebookaction)
    {
        if (facebookaction == FacebookSharingActivity.FacebookAction.a)
        {
            startActivity(new Intent(this, com/cyberlink/youcammakeup/activity/FacebookFriendPickerActivityForIntent));
        } else
        if (facebookaction == FacebookSharingActivity.FacebookAction.b)
        {
            startActivity(new Intent(this, com/cyberlink/youcammakeup/activity/FacebookPlacePickerActivityForIntent));
            return;
        }
    }

    protected void onPause()
    {
        super.onPause();
        Globals.d().c(null);
    }
}
