// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.whisperplay;

import android.app.Activity;
import android.content.Context;
import com.amazon.gallery.framework.data.account.AccountChangeListener;
import com.amazon.gallery.framework.gallery.view.ViewStateListener;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.framework.kindle.widget.badgechecker.ActivePhotoChecker;
import com.amazon.gallery.whisperplay.metrics.WhisperPlayMetrics;

public interface WhisperPlayConnectionManager
    extends AccountChangeListener, ViewStateListener, ActivePhotoChecker
{

    public abstract MediaContentConfiguration getContentConfiguration();

    public abstract WhisperPlayMetrics getWhisperPlayProfiler();

    public abstract void initWithActivity(Activity activity, boolean flag);

    public abstract boolean isDeviceAvailable();

    public abstract boolean isDevicePickerAvailable();

    public abstract boolean isSlideshowActive();

    public abstract boolean isWhisperPlayModeEnabled();

    public abstract void onPause(Context context);

    public abstract void toggleSlideShow();

    public abstract void whisperButtonClick();
}
