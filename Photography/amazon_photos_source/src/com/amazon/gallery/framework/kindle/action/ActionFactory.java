// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;

import android.content.Context;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.packagemanager.PackageHelper;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.gallery.actions.DeleteAction;
import com.amazon.gallery.framework.gallery.actions.DownloadAction;
import com.amazon.gallery.framework.gallery.actions.GenericShareAction;
import com.amazon.gallery.framework.gallery.actions.HideAction;
import com.amazon.gallery.framework.gallery.actions.ImageRewindAction;
import com.amazon.gallery.framework.gallery.actions.LaunchAviary;
import com.amazon.gallery.framework.gallery.actions.MediaItemAction;
import com.amazon.gallery.framework.gallery.actions.PrepareMediaItemsHelper;
import com.amazon.gallery.framework.gallery.actions.RemoveAction;
import com.amazon.gallery.framework.gallery.actions.SendShareAction;
import com.amazon.gallery.framework.gallery.actions.ShareAlbumAction;
import com.amazon.gallery.framework.gallery.actions.ShareToEmailAction;
import com.amazon.gallery.framework.gallery.actions.UnHideAction;
import com.amazon.gallery.framework.gallery.actions.UnifiedShareAction;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.print.GalleryPrintContext;
import com.amazon.gallery.framework.gallery.share.ShareStore;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.disk.NetworkStore;
import com.amazon.gallery.framework.network.download.GalleryDownloadManager;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.thor.albums.AddToAlbumAction;
import com.amazon.gallery.thor.albums.CreateAlbumAction;
import com.amazon.gallery.thor.albums.SetCoverPhotoAction;
import com.amazon.gallery.thor.removablestorage.RemovableStorageManager;

// Referenced classes of package com.amazon.gallery.framework.kindle.action:
//            EditMediaItemAction, PrintAction, ShareToEmailPostAction, ManualUploadAction, 
//            InfoAction, LockscreenAction

public class ActionFactory
{

    public static MediaItemAction createAction(BeanAwareActivity beanawareactivity, Class class1)
    {
        DiskStore diskstore = (DiskStore)beanawareactivity.getApplicationBean(Keys.DISK_STORE);
        NetworkStore networkstore = (NetworkStore)beanawareactivity.getApplicationBean(Keys.NETWORK_STORE);
        MediaItemDao mediaitemdao = (MediaItemDao)beanawareactivity.getApplicationBean(Keys.MEDIA_ITEM_DAO);
        TagDao tagdao = (TagDao)beanawareactivity.getApplicationBean(Keys.TAG_DAO);
        RestClient restclient = (RestClient)beanawareactivity.getApplicationBean(Keys.REST_CLIENT);
        NetworkConnectivity networkconnectivity = (NetworkConnectivity)beanawareactivity.getApplicationBean(Keys.NETWORK_CONNECTIVITY);
        ShareStore sharestore = (ShareStore)beanawareactivity.getApplicationBean(Keys.SHARE_STORE);
        GalleryDownloadManager gallerydownloadmanager = (GalleryDownloadManager)beanawareactivity.getApplicationBean(Keys.GALLERY_DOWNLOAD_MANAGER);
        PhotosDemoManager photosdemomanager = (PhotosDemoManager)beanawareactivity.getApplicationBean(Keys.DEMO_MANAGER);
        LaunchAviary launchaviary = (LaunchAviary)beanawareactivity.getApplicationBean(Keys.LAUNCH_AVIARY);
        GalleryPrintContext galleryprintcontext = (GalleryPrintContext)beanawareactivity.getBean(Keys.PRINT_CONTEXT);
        Profiler profiler = (Profiler)beanawareactivity.getApplicationBean(Keys.PROFILER);
        AuthenticationManager authenticationmanager = (AuthenticationManager)beanawareactivity.getApplicationBean(Keys.AUTHENTICATING_MANAGER);
        RemovableStorageManager removablestoragemanager = (RemovableStorageManager)beanawareactivity.getApplicationBean(Keys.REMOVABLE_STORAGE_MANAGER);
        PrepareMediaItemsHelper preparemediaitemshelper = new PrepareMediaItemsHelper(beanawareactivity, NetworkExecutor.getInstance(), restclient, sharestore);
        preparemediaitemshelper.setUriPreference(com.amazon.gallery.framework.gallery.actions.PrepareMediaItemsHelper.UriPreference.CONTENT);
        if (class1 == com/amazon/gallery/framework/gallery/actions/GenericShareAction)
        {
            if (isUnifiedShareAvailable(beanawareactivity))
            {
                return new UnifiedShareAction(beanawareactivity, networkconnectivity, photosdemomanager, sharestore, restclient, profiler);
            } else
            {
                return new SendShareAction(beanawareactivity, networkconnectivity, photosdemomanager, sharestore, restclient, profiler);
            }
        }
        if (class1 == com/amazon/gallery/framework/kindle/action/EditMediaItemAction)
        {
            beanawareactivity = new EditMediaItemAction(beanawareactivity, networkconnectivity, photosdemomanager, launchaviary, sharestore, diskstore, networkstore);
            beanawareactivity.setProfiler(profiler);
            return beanawareactivity;
        }
        if (class1 == com/amazon/gallery/framework/kindle/action/PrintAction)
        {
            beanawareactivity = new PrintAction(beanawareactivity, networkconnectivity, photosdemomanager, galleryprintcontext, sharestore);
            beanawareactivity.setProfiler(profiler);
            return beanawareactivity;
        }
        if (class1 == com/amazon/gallery/framework/gallery/actions/RemoveAction)
        {
            beanawareactivity = new RemoveAction(beanawareactivity, networkconnectivity, photosdemomanager);
            beanawareactivity.setProfiler(profiler);
            return beanawareactivity;
        }
        if (class1 == com/amazon/gallery/framework/gallery/actions/DeleteAction)
        {
            beanawareactivity = new DeleteAction(beanawareactivity, networkconnectivity, photosdemomanager);
            beanawareactivity.setProfiler(profiler);
            return beanawareactivity;
        }
        if (class1 == com/amazon/gallery/thor/albums/SetCoverPhotoAction)
        {
            beanawareactivity = new SetCoverPhotoAction(beanawareactivity, networkconnectivity, photosdemomanager);
            beanawareactivity.setProfiler(profiler);
            return beanawareactivity;
        }
        if (class1 == com/amazon/gallery/thor/albums/AddToAlbumAction)
        {
            beanawareactivity = new AddToAlbumAction(beanawareactivity, networkconnectivity, photosdemomanager);
            beanawareactivity.setProfiler(profiler);
            return beanawareactivity;
        }
        if (class1 == com/amazon/gallery/thor/albums/CreateAlbumAction)
        {
            beanawareactivity = new CreateAlbumAction(beanawareactivity, networkconnectivity, photosdemomanager);
            beanawareactivity.setProfiler(profiler);
            return beanawareactivity;
        }
        if (class1 == com/amazon/gallery/framework/gallery/actions/ShareToEmailAction)
        {
            class1 = new ShareToEmailAction(beanawareactivity, networkconnectivity, photosdemomanager, sharestore, restclient, profiler);
            class1.setPostShareAction(new ShareToEmailPostAction(beanawareactivity));
            return class1;
        }
        if (class1 == com/amazon/gallery/framework/gallery/actions/DownloadAction)
        {
            beanawareactivity = (new com.amazon.gallery.framework.gallery.actions.DownloadAction.Builder()).withContext(beanawareactivity).withNetworkConnectivity(networkconnectivity).withPhotosDemoManager(photosdemomanager).withMediaItemDao(mediaitemdao).withRestClient(restclient).withGalleryDownloadManager(gallerydownloadmanager).withRemovableStorageManager(removablestoragemanager).build();
            beanawareactivity.setProfiler(profiler);
            return beanawareactivity;
        }
        if (class1 == com/amazon/gallery/framework/kindle/action/ManualUploadAction)
        {
            beanawareactivity = new ManualUploadAction(beanawareactivity, networkconnectivity, photosdemomanager, restclient, mediaitemdao, authenticationmanager);
            beanawareactivity.setProfiler(profiler);
            return beanawareactivity;
        }
        if (class1 == com/amazon/gallery/framework/kindle/action/InfoAction)
        {
            beanawareactivity = new InfoAction(beanawareactivity, networkconnectivity, photosdemomanager);
            beanawareactivity.setProfiler(profiler);
            return beanawareactivity;
        }
        if (class1 == com/amazon/gallery/framework/gallery/actions/ImageRewindAction)
        {
            return new ImageRewindAction(beanawareactivity, networkconnectivity, photosdemomanager, galleryprintcontext, sharestore);
        }
        if (class1 == com/amazon/gallery/framework/kindle/action/LockscreenAction)
        {
            beanawareactivity = new LockscreenAction(beanawareactivity, networkconnectivity, photosdemomanager, sharestore, preparemediaitemshelper);
            beanawareactivity.addLocationTarget(com.amazon.gallery.framework.kindle.action.wallpaper.WallpaperConstants.TargetLocations.HOME);
            if (beanawareactivity.canSetLockscreen())
            {
                beanawareactivity.addLocationTarget(com.amazon.gallery.framework.kindle.action.wallpaper.WallpaperConstants.TargetLocations.LOCKSCREEN);
            }
            beanawareactivity.setProfiler(profiler);
            return beanawareactivity;
        }
        if (class1 == com/amazon/gallery/framework/gallery/actions/HideAction)
        {
            beanawareactivity = new HideAction(beanawareactivity, networkconnectivity, photosdemomanager, tagdao, mediaitemdao);
            beanawareactivity.setProfiler(profiler);
            return beanawareactivity;
        }
        if (class1 == com/amazon/gallery/framework/gallery/actions/UnHideAction)
        {
            beanawareactivity = new UnHideAction(beanawareactivity, networkconnectivity, photosdemomanager, tagdao, mediaitemdao);
            beanawareactivity.setProfiler(profiler);
            return beanawareactivity;
        }
        if (class1 == com/amazon/gallery/framework/gallery/actions/ShareAlbumAction)
        {
            beanawareactivity = new ShareAlbumAction(beanawareactivity, networkconnectivity, photosdemomanager);
            beanawareactivity.setProfiler(profiler);
            return beanawareactivity;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Action type not supported: ").append(class1.getSimpleName()).toString());
        }
    }

    private static boolean isUnifiedShareAvailable(Context context)
    {
        return (BuildFlavors.isFos4() || BuildFlavors.isGen5()) && PackageHelper.isPackageAvailable(context, "com.amazon.socialplatform");
    }
}
