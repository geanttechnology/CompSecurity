// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.Intent;
import android.view.View;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.facebook.AccessToken;
import java.util.Set;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            HomeActivity, LeaderboardActivity, FacebookConnexionActivity

class this._cls0
    implements android.view.tener
{

    final HomeActivity this$0;

    public void onClick(View view)
    {
        BackgroundSoundsBinder.sharedInstance().playBip();
        AkGameFactory.sharedInstance().setComeFrom(0);
        if (AccessToken.getCurrentAccessToken() != null)
        {
            boolean flag = AccessToken.getCurrentAccessToken().getPermissions().contains("user_friends");
            boolean flag1 = AccessToken.getCurrentAccessToken().getPermissions().contains("publish_actions");
            if (flag && flag1)
            {
                view = new Intent(HomeActivity.this, com/digidust/elokence/akinator/activities/LeaderboardActivity);
                startActivity(view);
                finish();
            }
        }
        view = new Intent(HomeActivity.this, com/digidust/elokence/akinator/activities/FacebookConnexionActivity);
        startActivity(view);
        finish();
    }

    onActivity()
    {
        this$0 = HomeActivity.this;
        super();
    }
}
