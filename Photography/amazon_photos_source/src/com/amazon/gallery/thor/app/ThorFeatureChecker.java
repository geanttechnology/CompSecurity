// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;

// Referenced classes of package com.amazon.gallery.thor.app:
//            FeatureChecker

public class ThorFeatureChecker
    implements FeatureChecker
{

    private PhotosDemoManager demoManager;
    private FreeTimeCommon.ProfileState profileState;

    public ThorFeatureChecker(FreeTimeCommon.ProfileState profilestate, PhotosDemoManager photosdemomanager)
    {
        profileState = profilestate;
        demoManager = photosdemomanager;
    }

    public boolean alwaysTransparentHAB()
    {
        return profileState == FreeTimeCommon.ProfileState.FREETIME;
    }

    public int getContextMenuResource()
    {
        return profileState == FreeTimeCommon.ProfileState.PARENT ? 0x7f10000f : 0x7f10000a;
    }

    public int getScreenOrientation()
    {
        return profileState != FreeTimeCommon.ProfileState.FREETIME ? -1 : 6;
    }

    public boolean hasCloudSync()
    {
        return profileState == FreeTimeCommon.ProfileState.PARENT && !demoManager.isInDemoMode();
    }

    public boolean hasFTUE()
    {
        return FeatureManager.isFeatureEnabled(Features.FTUE) && profileState == FreeTimeCommon.ProfileState.PARENT;
    }

    public boolean hasFreetimeActionBar()
    {
        return profileState != FreeTimeCommon.ProfileState.PARENT;
    }

    public boolean hasLeftPanel()
    {
        return profileState == FreeTimeCommon.ProfileState.PARENT;
    }

    public boolean hasSingleLayout()
    {
        return profileState != FreeTimeCommon.ProfileState.FREETIME;
    }

    public boolean hasWhisperplay()
    {
        return FeatureManager.isFeatureEnabled(Features.WHISPER_PLAY) && profileState == FreeTimeCommon.ProfileState.PARENT && !demoManager.isInDemoMode();
    }
}
