// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.google.android.youtube.player.internal.z;

// Referenced classes of package com.google.android.youtube.player:
//            YouTubeInitializationResult

public final class YouTubeStandalonePlayer
{

    private YouTubeStandalonePlayer()
    {
    }

    private static Intent a(Intent intent, Activity activity, String s, int i, boolean flag, boolean flag1)
    {
        s = intent.putExtra("developer_key", s).putExtra("app_package", activity.getPackageName()).putExtra("app_version", z.d(activity)).putExtra("autoplay", flag).putExtra("lightbox_mode", flag1).putExtra("start_time_millis", i);
        if ((activity.getWindow().getAttributes().flags & 0x400) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s.putExtra("window_has_status_bar", flag);
        return intent;
    }

    public static Intent createPlaylistIntent(Activity activity, String s, String s1)
    {
        return createPlaylistIntent(activity, s, s1, 0, 0, false, false);
    }

    public static Intent createPlaylistIntent(Activity activity, String s, String s1, int i, int j, boolean flag, boolean flag1)
    {
        return a((new Intent("com.google.android.youtube.api.StandalonePlayerActivity.START")).putExtra("playlist_id", s1).putExtra("current_index", i), activity, s, j, flag, flag1);
    }

    public static Intent createVideoIntent(Activity activity, String s, String s1)
    {
        return createVideoIntent(activity, s, s1, 0, false, false);
    }

    public static Intent createVideoIntent(Activity activity, String s, String s1, int i, boolean flag, boolean flag1)
    {
        return a((new Intent("com.google.android.youtube.api.StandalonePlayerActivity.START")).putExtra("video_id", s1), activity, s, i, flag, flag1);
    }

    public static YouTubeInitializationResult getReturnedInitializationResult(Intent intent)
    {
        intent = intent.getExtras().getString("initialization_result");
        try
        {
            intent = YouTubeInitializationResult.valueOf(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        }
        return intent;
    }
}
