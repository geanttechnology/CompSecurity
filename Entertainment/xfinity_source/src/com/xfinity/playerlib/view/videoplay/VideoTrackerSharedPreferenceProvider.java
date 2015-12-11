// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.content.Context;
import android.content.SharedPreferences;
import com.xfinity.playerlib.model.user.PlayNowUser;
import com.xfinity.playerlib.model.user.PlayNowUserManager;

public class VideoTrackerSharedPreferenceProvider
{

    private final Context context;
    private final PlayNowUserManager userManager;

    public VideoTrackerSharedPreferenceProvider(Context context1, PlayNowUserManager playnowusermanager)
    {
        context = context1;
        userManager = playnowusermanager;
    }

    public SharedPreferences getSharedPreferencesForCurrentUser()
    {
        PlayNowUser playnowuser = (PlayNowUser)userManager.getUser();
        return context.getSharedPreferences((new StringBuilder()).append("TRACK_").append(playnowuser.getUserName()).toString(), 0);
    }
}
