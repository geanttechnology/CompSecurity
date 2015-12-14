// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.actions;

import android.app.Activity;
import android.content.Intent;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.RefreshHeaderOptionsEvent;
import com.amazon.gallery.framework.gallery.actions.SwapIconAction;
import com.amazon.gallery.framework.gallery.actions.ViewDescriptorAction;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.activity.NativeGalleryActivity;
import com.amazon.gallery.framework.kindle.activity.SlideShowActivity;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.thor.app.FreeTimeCommon;
import com.amazon.gallery.thor.di.AppKeys;
import com.amazon.gallery.whisperplay.WhisperPlayConnectionManager;

public class StartSlideshowAction
    implements SwapIconAction, ViewDescriptorAction
{

    private final Activity activity;
    private final WhisperPlayConnectionManager whisperPlayConnectionManager;

    public StartSlideshowAction(Activity activity1)
    {
        activity = activity1;
        whisperPlayConnectionManager = (WhisperPlayConnectionManager)((BeanAwareApplication)activity1.getApplication()).getBeanFactory().getBean(AppKeys.WHISPER_PLAY_CONNECTION_MANAGER);
    }

    private void startLocalSlideshow(ViewDescriptor viewdescriptor)
    {
        Intent intent = new Intent(activity, com/amazon/gallery/framework/kindle/activity/SlideShowActivity);
        MediaContentConfiguration mediacontentconfiguration = ((NativeGalleryActivity)activity).getMediaContentConfiguration();
        intent.setData(mediacontentconfiguration.getContentUri());
        intent.putExtra("START_POSITION", viewdescriptor.getFocusedIndex());
        IntentUtil.setExtrasForDescriptor(mediacontentconfiguration.toViewDescriptor(), intent);
        activity.startActivity(intent);
    }

    public boolean canExecute(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        return viewdescriptor != null && viewdescriptor.getCollectionSize() > 0 && (!BuildFlavors.isAosp() || Api.isAtLeastKitkat());
    }

    public void executeViewDescriptor(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        if (FeatureManager.isFeatureEnabled(Features.WHISPER_PLAY) && whisperPlayConnectionManager.isWhisperPlayModeEnabled())
        {
            whisperPlayConnectionManager.toggleSlideShow();
            GlobalMessagingBus.post(new RefreshHeaderOptionsEvent());
            return;
        } else
        {
            startLocalSlideshow(viewdescriptor);
            return;
        }
    }

    public int getIcon()
    {
        return FreeTimeCommon.getUserTheme(activity) != com.amazon.gallery.thor.app.FreeTimeCommon.ProfileState.FREETIME ? 0x7f0201b8 : 0x7f0201b9;
    }

    public int getText()
    {
        return 0x7f0e004d;
    }

    public boolean isActive()
    {
        return FeatureManager.isFeatureEnabled(Features.WHISPER_PLAY) && whisperPlayConnectionManager.isSlideshowActive();
    }
}
