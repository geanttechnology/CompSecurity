// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.mopub.common.logging.MoPubLog;

// Referenced classes of package com.mopub.mobileads:
//            MraidVideoPlayerActivity, VastVideoConfig

public class BaseVideoPlayerActivity extends Activity
{

    public static final String VIDEO_CLASS_EXTRAS_KEY = "video_view_class_name";
    public static final String VIDEO_URL = "video_url";

    public BaseVideoPlayerActivity()
    {
    }

    static Intent createIntentMraid(Context context, String s)
    {
        context = new Intent(context, com/mopub/mobileads/MraidVideoPlayerActivity);
        context.setFlags(0x10000000);
        context.putExtra("video_view_class_name", "mraid");
        context.putExtra("video_url", s);
        return context;
    }

    public static Intent createIntentNativeVideo(Context context, long l, VastVideoConfig vastvideoconfig)
    {
        context = new Intent(context, com/mopub/mobileads/MraidVideoPlayerActivity);
        context.setFlags(0x10000000);
        context.putExtra("video_view_class_name", "native");
        context.putExtra("native_video_id", l);
        context.putExtra("native_vast_video_config", vastvideoconfig);
        return context;
    }

    static Intent createIntentVast(Context context, VastVideoConfig vastvideoconfig, long l)
    {
        context = new Intent(context, com/mopub/mobileads/MraidVideoPlayerActivity);
        context.setFlags(0x10000000);
        context.putExtra("video_view_class_name", "vast");
        context.putExtra("vast_video_config", vastvideoconfig);
        context.putExtra("broadcastIdentifier", l);
        return context;
    }

    public static void startMraid(Context context, String s)
    {
        s = createIntentMraid(context, s);
        try
        {
            context.startActivity(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MoPubLog.d("Activity MraidVideoPlayerActivity not found. Did you declare it in your AndroidManifest.xml?");
        }
    }

    public static void startNativeVideo(Context context, long l, VastVideoConfig vastvideoconfig)
    {
        vastvideoconfig = createIntentNativeVideo(context, l, vastvideoconfig);
        try
        {
            context.startActivity(vastvideoconfig);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MoPubLog.d("Activity MraidVideoPlayerActivity not found. Did you declare it in your AndroidManifest.xml?");
        }
    }

    static void startVast(Context context, VastVideoConfig vastvideoconfig, long l)
    {
        vastvideoconfig = createIntentVast(context, vastvideoconfig, l);
        try
        {
            context.startActivity(vastvideoconfig);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MoPubLog.d("Activity MraidVideoPlayerActivity not found. Did you declare it in your AndroidManifest.xml?");
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        AudioManager audiomanager = (AudioManager)getSystemService("audio");
        if (audiomanager != null)
        {
            audiomanager.abandonAudioFocus(null);
        }
    }
}
