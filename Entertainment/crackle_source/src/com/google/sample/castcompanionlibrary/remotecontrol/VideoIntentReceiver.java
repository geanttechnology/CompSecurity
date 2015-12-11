// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.remotecontrol;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.google.sample.castcompanionlibrary.cast.VideoCastManager;
import com.google.sample.castcompanionlibrary.cast.exceptions.CastException;
import com.google.sample.castcompanionlibrary.utils.LogUtils;

public class VideoIntentReceiver extends BroadcastReceiver
{

    private static final String TAG = LogUtils.makeLogTag(com/google/sample/castcompanionlibrary/remotecontrol/VideoIntentReceiver);

    public VideoIntentReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        VideoCastManager videocastmanager;
        Object obj;
        videocastmanager = null;
        try
        {
            obj = VideoCastManager.getInstance();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            LogUtils.LOGE(TAG, "onReceive(): No CastManager instance exists");
            continue; /* Loop/switch isn't completed */
        }
        videocastmanager = ((VideoCastManager) (obj));
_L6:
        obj = intent.getAction();
        if (obj != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!((String) (obj)).equals("com.google.sample.castcompanionlibrary.action.toggleplayback"))
        {
            break MISSING_BLOCK_LABEL_85;
        }
        if (videocastmanager != null)
        {
            try
            {
                LogUtils.LOGD(TAG, "Toggling playback via CastManager");
                videocastmanager.togglePlayback();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        LogUtils.LOGD(TAG, "Toggling playback via NotificationService");
        context.startService(new Intent("com.google.sample.castcompanionlibrary.action.toggleplayback"));
        return;
        if (!((String) (obj)).equals("com.google.sample.castcompanionlibrary.action.stop"))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (videocastmanager != null)
        {
            try
            {
                LogUtils.LOGD(TAG, "Calling stopApplication from intent");
                videocastmanager.disconnect();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                LogUtils.LOGE(TAG, "onReceive(): Failed to stop application");
            }
            return;
        }
        context.startService(new Intent("com.google.sample.castcompanionlibrary.action.stop"));
        return;
        if (!((String) (obj)).equals("android.intent.action.MEDIA_BUTTON")) goto _L1; else goto _L3
_L3:
        context = (KeyEvent)intent.getExtras().get("android.intent.extra.KEY_EVENT");
        if (context.getAction() != 0) goto _L1; else goto _L4
_L4:
        switch (context.getKeyCode())
        {
        default:
            return;

        case 85: // 'U'
            break;
        }
        try
        {
            videocastmanager.togglePlayback();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

}
