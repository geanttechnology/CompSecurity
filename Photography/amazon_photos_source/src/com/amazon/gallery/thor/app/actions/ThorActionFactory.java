// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.actions;

import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.framework.gallery.actions.AlbumInfoAction;
import com.amazon.gallery.framework.gallery.actions.ConvertFolderToAlbumAction;
import com.amazon.gallery.framework.gallery.actions.MediaItemAction;
import com.amazon.gallery.framework.gallery.actions.RenameAction;
import com.amazon.gallery.framework.gallery.actions.SelectionAction;
import com.amazon.gallery.framework.gallery.actions.ViewDescriptorAction;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.action.ActionFactory;
import com.amazon.gallery.framework.kindle.action.MultiselectModeAction;
import com.amazon.gallery.framework.kindle.activity.WhisperPlayActivity;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.camera.ThorLaunchCamera;
import com.amazon.gallery.thor.di.AppKeys;
import com.amazon.gallery.whisperplay.WhisperPlayConnectionManager;

// Referenced classes of package com.amazon.gallery.thor.app.actions:
//            FavoriteAction, LaunchCameraAction, WhisperplayToggleAction, StartSlideshowAction, 
//            SortAction

public class ThorActionFactory extends ActionFactory
{

    public static SelectionAction createSelectionAction(BeanAwareActivity beanawareactivity, Class class1)
    {
        NetworkConnectivity networkconnectivity = (NetworkConnectivity)ThorGalleryApplication.getBean(Keys.NETWORK_CONNECTIVITY);
        Profiler profiler = (Profiler)beanawareactivity.getApplicationBean(Keys.PROFILER);
        if (class1 == com/amazon/gallery/framework/gallery/actions/RenameAction)
        {
            return new RenameAction(beanawareactivity, networkconnectivity, profiler);
        }
        if (class1 == com/amazon/gallery/framework/gallery/actions/ConvertFolderToAlbumAction)
        {
            return new ConvertFolderToAlbumAction(beanawareactivity, networkconnectivity, profiler);
        }
        if (class1 == com/amazon/gallery/thor/app/actions/FavoriteAction)
        {
            return new FavoriteAction(beanawareactivity);
        }
        if (class1 == com/amazon/gallery/framework/gallery/actions/AlbumInfoAction)
        {
            return new AlbumInfoAction(beanawareactivity, networkconnectivity, profiler);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Action type not supported: ").append(class1.getSimpleName()).toString());
        }
    }

    public static MediaItemAction createThorAction(BeanAwareActivity beanawareactivity, Class class1)
    {
        return createAction(beanawareactivity, class1);
    }

    public static ViewDescriptorAction createViewDescriptorAction(BeanAwareActivity beanawareactivity, Class class1)
    {
        if (class1 == com/amazon/gallery/thor/app/actions/LaunchCameraAction)
        {
            return new LaunchCameraAction(beanawareactivity, new ThorLaunchCamera());
        }
        if (class1 == com/amazon/gallery/thor/app/actions/WhisperplayToggleAction)
        {
            return new WhisperplayToggleAction(beanawareactivity.getSharedPreferences("galleryKindleSharedPrefs", 0), (WhisperPlayConnectionManager)beanawareactivity.getApplicationBean(AppKeys.WHISPER_PLAY_CONNECTION_MANAGER), (WhisperPlayActivity)beanawareactivity);
        }
        if (class1 == com/amazon/gallery/thor/app/actions/StartSlideshowAction)
        {
            return new StartSlideshowAction(beanawareactivity);
        }
        if (class1 == com/amazon/gallery/thor/app/actions/SortAction)
        {
            return new SortAction();
        }
        if (class1 == com/amazon/gallery/framework/kindle/action/MultiselectModeAction)
        {
            return new MultiselectModeAction();
        }
        if (class1 == com/amazon/gallery/framework/gallery/actions/AlbumInfoAction)
        {
            return new AlbumInfoAction(beanawareactivity, (NetworkConnectivity)beanawareactivity.getApplicationBean(Keys.NETWORK_CONNECTIVITY), (Profiler)beanawareactivity.getApplicationBean(Keys.PROFILER));
        } else
        {
            return createThorAction(beanawareactivity, class1);
        }
    }
}
