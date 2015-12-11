// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playnow;

import android.content.SharedPreferences;
import com.comcast.cim.model.user.UserManager;
import com.xfinity.playerlib.PlayerAppUpgradeHelper;
import com.xfinity.playerlib.PlayerApplication;
import com.xfinity.playerlib.captions.PersistentCaptionsCache;
import com.xfinity.playerlib.model.database.VideoBookmarkDAO;
import com.xfinity.playerlib.model.downloads.PersistentEntityCache;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;

public class PlayNowAppUpgradHelper extends PlayerAppUpgradeHelper
{

    public PlayNowAppUpgradHelper(PlayerApplication playerapplication, UserManager usermanager, SharedPreferences sharedpreferences, PlayerDownloadServiceManager playerdownloadservicemanager, PersistentEntityCache persistententitycache, PersistentCaptionsCache persistentcaptionscache, VideoBookmarkDAO videobookmarkdao)
    {
        super(playerapplication, usermanager, sharedpreferences, playerdownloadservicemanager, persistententitycache, persistentcaptionscache, videobookmarkdao);
    }

    protected boolean upgradeRequiresFilterReset(int i)
    {
        return i < 2217;
    }

    protected boolean upgradeRequiresSignout(int i)
    {
        return i < 2211;
    }
}
