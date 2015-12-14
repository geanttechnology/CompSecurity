// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.actions;

import android.content.SharedPreferences;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.framework.gallery.actions.SwapIconAction;
import com.amazon.gallery.framework.gallery.actions.ViewDescriptorAction;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.WhisperPlayActivity;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.whisperplay.WhisperPlayConnectionManager;
import com.amazon.gallery.whisperplay.metrics.WhisperPlayMetrics;
import java.util.concurrent.TimeUnit;

public class WhisperplayToggleAction
    implements SwapIconAction, ViewDescriptorAction
{

    private static final long GRACE_TIME;
    private static final long ONE_HOUR;
    private final WhisperPlayActivity activity;
    private final AuthenticationManager authenticationManager;
    private long lastAvailableTime;
    private final SharedPreferences sharedPreferences;
    private final WhisperPlayConnectionManager whisperPlayConnectionManager;
    private boolean whisperplayShownPreviously;

    public WhisperplayToggleAction(SharedPreferences sharedpreferences, WhisperPlayConnectionManager whisperplayconnectionmanager, WhisperPlayActivity whisperplayactivity)
    {
        whisperPlayConnectionManager = whisperplayconnectionmanager;
        activity = whisperplayactivity;
        sharedPreferences = sharedpreferences;
        whisperplayShownPreviously = sharedpreferences.getBoolean("seen_whisperplay_icon", false);
        lastAvailableTime = sharedpreferences.getLong("whisperplay_last_device_available_time", 0L);
        authenticationManager = (AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER);
    }

    private boolean isLastAvailableTimeOutdated()
    {
        long l = System.currentTimeMillis() - lastAvailableTime;
        return l < 0L || l > ONE_HOUR;
    }

    private boolean isWithinGraceTime()
    {
        long l = System.currentTimeMillis() - lastAvailableTime;
        return l > 0L && l < GRACE_TIME;
    }

    public boolean canExecute(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        boolean flag;
        for (flag = true; !FeatureManager.isFeatureEnabled(Features.WHISPER_PLAY) || authenticationManager.getAccountId() == null;)
        {
            return false;
        }

        boolean flag1 = whisperPlayConnectionManager.isDeviceAvailable();
        if (flag1 && !whisperplayShownPreviously)
        {
            whisperPlayConnectionManager.getWhisperPlayProfiler().trackEvent(com.amazon.gallery.whisperplay.metrics.WhisperPlayMetrics.MetricsEvent.WPFirstTimeIconShown);
            sharedPreferences.edit().putBoolean("seen_whisperplay_icon", true).apply();
            whisperplayShownPreviously = true;
        }
        if (flag1 && isLastAvailableTimeOutdated())
        {
            long l = System.currentTimeMillis();
            lastAvailableTime = l;
            sharedPreferences.edit().putLong("whisperplay_last_device_available_time", l).apply();
        }
        if (!flag1 && !isWithinGraceTime() || !whisperPlayConnectionManager.isDevicePickerAvailable())
        {
            flag = false;
        }
        return flag;
    }

    public void executeViewDescriptor(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        if (!activity.isWhisperPlayModeEnabled())
        {
            whisperPlayConnectionManager.getWhisperPlayProfiler().trackEvent(com.amazon.gallery.whisperplay.metrics.WhisperPlayMetrics.MetricsEvent.WPInitiateConnection);
        } else
        {
            whisperPlayConnectionManager.getWhisperPlayProfiler().trackEvent(com.amazon.gallery.whisperplay.metrics.WhisperPlayMetrics.MetricsEvent.WPEndConnection);
        }
        whisperPlayConnectionManager.whisperButtonClick();
    }

    public int getIcon()
    {
        return 0x7f020181;
    }

    public int getText()
    {
        return !whisperPlayConnectionManager.isWhisperPlayModeEnabled() ? 0x7f0e004c : 0x7f0e01ae;
    }

    public boolean isActive()
    {
        return whisperPlayConnectionManager.isWhisperPlayModeEnabled();
    }

    static 
    {
        GRACE_TIME = TimeUnit.HOURS.toMillis(24L);
        ONE_HOUR = TimeUnit.HOURS.toMillis(1L);
    }
}
