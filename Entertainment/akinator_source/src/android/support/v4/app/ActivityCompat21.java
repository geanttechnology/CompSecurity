// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.media.session.MediaController;

class ActivityCompat21
{

    ActivityCompat21()
    {
    }

    private static SharedElementCallback createCallback(SharedElementCallback21 sharedelementcallback21)
    {
        SharedElementCallbackImpl sharedelementcallbackimpl = null;
    /* block-local class not found */
    class SharedElementCallbackImpl {}

        if (sharedelementcallback21 != null)
        {
            sharedelementcallbackimpl = new SharedElementCallbackImpl(sharedelementcallback21);
        }
        return sharedelementcallbackimpl;
    }

    public static void finishAfterTransition(Activity activity)
    {
        activity.finishAfterTransition();
    }

    public static void postponeEnterTransition(Activity activity)
    {
        activity.postponeEnterTransition();
    }

    public static void setEnterSharedElementCallback(Activity activity, SharedElementCallback21 sharedelementcallback21)
    {
        activity.setEnterSharedElementCallback(createCallback(sharedelementcallback21));
    }

    public static void setExitSharedElementCallback(Activity activity, SharedElementCallback21 sharedelementcallback21)
    {
        activity.setExitSharedElementCallback(createCallback(sharedelementcallback21));
    }

    public static void setMediaController(Activity activity, Object obj)
    {
        activity.setMediaController((MediaController)obj);
    }

    public static void startPostponedEnterTransition(Activity activity)
    {
        activity.startPostponedEnterTransition();
    }

    // Unreferenced inner class android/support/v4/app/ActivityCompat21$SharedElementCallback21
    /* block-local class not found */
    class SharedElementCallback21 {}

}
