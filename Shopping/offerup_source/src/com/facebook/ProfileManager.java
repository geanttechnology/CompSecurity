// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Intent;
import android.support.v4.b.h;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;

// Referenced classes of package com.facebook:
//            FacebookSdk, ProfileCache, Profile

final class ProfileManager
{

    static final String ACTION_CURRENT_PROFILE_CHANGED = "com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED";
    static final String EXTRA_NEW_PROFILE = "com.facebook.sdk.EXTRA_NEW_PROFILE";
    static final String EXTRA_OLD_PROFILE = "com.facebook.sdk.EXTRA_OLD_PROFILE";
    private static volatile ProfileManager instance;
    private Profile currentProfile;
    private final h localBroadcastManager;
    private final ProfileCache profileCache;

    ProfileManager(h h1, ProfileCache profilecache)
    {
        Validate.notNull(h1, "localBroadcastManager");
        Validate.notNull(profilecache, "profileCache");
        localBroadcastManager = h1;
        profileCache = profilecache;
    }

    static ProfileManager getInstance()
    {
        if (instance != null) goto _L2; else goto _L1
_L1:
        com/facebook/ProfileManager;
        JVM INSTR monitorenter ;
        if (instance == null)
        {
            instance = new ProfileManager(h.a(FacebookSdk.getApplicationContext()), new ProfileCache());
        }
        com/facebook/ProfileManager;
        JVM INSTR monitorexit ;
_L2:
        return instance;
        Exception exception;
        exception;
        com/facebook/ProfileManager;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void sendCurrentProfileChangedBroadcast(Profile profile, Profile profile1)
    {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", profile);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", profile1);
        localBroadcastManager.a(intent);
    }

    private void setCurrentProfile(Profile profile, boolean flag)
    {
        Profile profile1 = currentProfile;
        currentProfile = profile;
        if (flag)
        {
            if (profile != null)
            {
                profileCache.save(profile);
            } else
            {
                profileCache.clear();
            }
        }
        if (!Utility.areObjectsEqual(profile1, profile))
        {
            sendCurrentProfileChangedBroadcast(profile1, profile);
        }
    }

    final Profile getCurrentProfile()
    {
        return currentProfile;
    }

    final boolean loadCurrentProfile()
    {
        boolean flag = false;
        Profile profile = profileCache.load();
        if (profile != null)
        {
            setCurrentProfile(profile, false);
            flag = true;
        }
        return flag;
    }

    final void setCurrentProfile(Profile profile)
    {
        setCurrentProfile(profile, true);
    }
}
