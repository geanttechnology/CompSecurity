// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.content.SharedPreferences;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoTrackerSharedPreferenceProvider

public class VideoTracker
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/videoplay/VideoTracker);
    private final VideoTrackerSharedPreferenceProvider sharedPreferencesProvider;

    public VideoTracker(VideoTrackerSharedPreferenceProvider videotrackersharedpreferenceprovider)
    {
        sharedPreferencesProvider = videotrackersharedpreferenceprovider;
    }

    public int getPosition(long l)
    {
        return sharedPreferencesProvider.getSharedPreferencesForCurrentUser().getInt(Long.toString(l), -1);
    }

}
