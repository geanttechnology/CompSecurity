// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.whisperplay;

import android.app.Activity;
import android.content.Context;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.whisperplay.metrics.WhisperPlayMetrics;

// Referenced classes of package com.amazon.gallery.whisperplay:
//            WhisperPlayConnectionManager

public class NoOpWhisperPlayConnectionManager
    implements WhisperPlayConnectionManager
{

    public NoOpWhisperPlayConnectionManager()
    {
    }

    public MediaContentConfiguration getContentConfiguration()
    {
        return null;
    }

    public WhisperPlayMetrics getWhisperPlayProfiler()
    {
        return null;
    }

    public void initWithActivity(Activity activity, boolean flag)
    {
    }

    public boolean isActive(MediaItem mediaitem)
    {
        return false;
    }

    public volatile boolean isActive(Object obj)
    {
        return isActive((MediaItem)obj);
    }

    public boolean isDeviceAvailable()
    {
        return false;
    }

    public boolean isDevicePickerAvailable()
    {
        return false;
    }

    public boolean isSlideshowActive()
    {
        return false;
    }

    public boolean isWhisperPlayModeEnabled()
    {
        return false;
    }

    public void onAccountDeregistered()
    {
    }

    public void onAccountRegistered()
    {
    }

    public void onEnterFullScreen()
    {
    }

    public void onExitFullScreen()
    {
    }

    public void onFocusedGained(ViewDescriptor viewdescriptor)
    {
    }

    public void onPause(Context context)
    {
    }

    public void onRotation()
    {
    }

    public void onViewStateChange(ViewDescriptor viewdescriptor, boolean flag)
    {
    }

    public void toggleSlideShow()
    {
    }

    public void whisperButtonClick()
    {
    }
}
