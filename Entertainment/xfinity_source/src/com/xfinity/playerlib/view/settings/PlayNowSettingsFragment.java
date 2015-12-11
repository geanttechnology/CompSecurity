// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.comcast.cim.android.view.common.errorformatter.ErrorFormatter;
import com.comcast.cim.android.view.settings.SettingsFragment;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutorFactory;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.config.PlayerConfiguration;
import com.xfinity.playerlib.downloads.RegistrationListClient;
import com.xfinity.playerlib.downloads.UnregisterDeviceClient;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.tracking.PlayNowTab;
import com.xfinity.playerlib.tracking.PlayNowTrackingService;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.settings:
//            PlayNowPreferenceDelegate

public class PlayNowSettingsFragment extends SettingsFragment
{

    private final PlayerConfiguration configuration = PlayerContainer.getInstance().getConfiguration();
    private final List configurationList = PlayerContainer.getInstance().getAvailableConfigurations();
    private final ErrorFormatter errorFormatter = PlayerContainer.getInstance().getErrorFormatter();
    private final Task liveStreamsResourceCache = PlayerContainer.getInstance().getLiveStreamResourceCache();
    private Task parentalControlsCache;
    private PlayerDownloadServiceManager playerDownloadServiceManager;
    private PlayNowPreferenceDelegate preferenceDelegate;
    private RegistrationListClient registrationListClient;
    private TaskExecutorFactory taskExecutorFactory;
    protected final PlayNowTrackingService trackingService = PlayerContainer.getInstance().getTrackingService();
    private UnregisterDeviceClient unregisterDeviceClient;
    private PlayNowUserManager userManager;

    public PlayNowSettingsFragment()
    {
        userManager = PlayerContainer.getInstance().getUserManager();
        parentalControlsCache = PlayerContainer.getInstance().getParentalControlsCache();
        taskExecutorFactory = PlayerContainer.getInstance().getTaskExecutorFactory();
        unregisterDeviceClient = PlayerContainer.getInstance().getUnregisterDeviceClient();
        playerDownloadServiceManager = PlayerContainer.getInstance().getDownloadServiceManager();
        registrationListClient = PlayerContainer.getInstance().getRegistrationListClient();
        preferenceDelegate = null;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        trackingService.trackTabRendered(PlayNowTab.SETTINGS);
        return layoutinflater;
    }

    public void onPause()
    {
        super.onPause();
        if (preferenceDelegate != null)
        {
            preferenceDelegate.cancelListeners();
            preferenceDelegate = null;
        }
    }

    public void onResumeInternal()
    {
        super.onResumeInternal();
        preferenceDelegate = new PlayNowPreferenceDelegate(this, userManager, parentalControlsCache, taskExecutorFactory, unregisterDeviceClient, playerDownloadServiceManager, registrationListClient, errorFormatter, configuration, configurationList, liveStreamsResourceCache);
        preferenceDelegate.initPreferences();
    }
}
