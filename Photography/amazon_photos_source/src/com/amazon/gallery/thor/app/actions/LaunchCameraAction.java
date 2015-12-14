// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.actions;

import android.app.Activity;
import com.amazon.gallery.framework.gallery.actions.ViewDescriptorAction;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.CameraUtils;
import com.amazon.gallery.framework.kindle.LaunchCamera;
import com.amazon.gallery.framework.model.media.MediaItem;

public class LaunchCameraAction
    implements ViewDescriptorAction
{

    private final Activity activity;
    private final LaunchCamera cameraLauncher;

    public LaunchCameraAction(Activity activity1, LaunchCamera launchcamera)
    {
        activity = activity1;
        cameraLauncher = launchcamera;
    }

    public boolean canExecute(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        return mediaitem == null && CameraUtils.isCameraAvailable(activity);
    }

    public void executeViewDescriptor(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        cameraLauncher.launchCamera(activity);
    }
}
