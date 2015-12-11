// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.Intent;
import android.widget.GridView;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            LeaderboardActivity, FacebookConnexionActivity

class this._cls0 extends AccessTokenTracker
{

    final LeaderboardActivity this$0;

    protected void onCurrentAccessTokenChanged(AccessToken accesstoken, AccessToken accesstoken1)
    {
        if (accesstoken1 == null && LeaderboardActivity.access$000(LeaderboardActivity.this) != null)
        {
            LeaderboardActivity.access$000(LeaderboardActivity.this).setAdapter(null);
            LeaderboardActivity.access$102(LeaderboardActivity.this, null);
            accesstoken = new Intent(LeaderboardActivity.this, com/digidust/elokence/akinator/activities/FacebookConnexionActivity);
            startActivity(accesstoken);
            finish();
        }
    }

    ity()
    {
        this$0 = LeaderboardActivity.this;
        super();
    }
}
