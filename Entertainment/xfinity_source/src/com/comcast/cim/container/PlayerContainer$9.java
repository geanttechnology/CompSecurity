// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.container;

import com.comcast.cim.model.user.User;
import com.comcast.cim.model.user.service.UserSettings;
import com.xfinity.playerlib.model.user.PlayNowUser;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.model.videoplay.PlayerConfigUtil;

// Referenced classes of package com.comcast.cim.container:
//            PlayerContainer

class this._cls0
    implements com.comcast.cim.model.user.nagerListener
{

    final PlayerContainer this$0;

    public volatile void onUserChanged(User user, UserSettings usersettings)
    {
        onUserChanged((PlayNowUser)user, (PlayerUserSettings)usersettings);
    }

    public void onUserChanged(PlayNowUser playnowuser, PlayerUserSettings playerusersettings)
    {
    }

    public volatile void onUserLoaded(User user, UserSettings usersettings)
    {
        onUserLoaded((PlayNowUser)user, (PlayerUserSettings)usersettings);
    }

    public void onUserLoaded(PlayNowUser playnowuser, PlayerUserSettings playerusersettings)
    {
    }

    public volatile void onUserLoggedIn(User user, UserSettings usersettings)
    {
        onUserLoggedIn((PlayNowUser)user, (PlayerUserSettings)usersettings);
    }

    public void onUserLoggedIn(PlayNowUser playnowuser, PlayerUserSettings playerusersettings)
    {
        getPlayerConfigUtil().configureESPNPlayer(getApplication());
    }

    public void onUserLoggedOut()
    {
    }

    ettings()
    {
        this$0 = PlayerContainer.this;
        super();
    }
}
