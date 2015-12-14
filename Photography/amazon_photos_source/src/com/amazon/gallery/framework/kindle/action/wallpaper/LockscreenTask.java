// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action.wallpaper;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.LockscreenWallpaperUtil;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.actions.PrepareMediaItemsHelper;
import com.amazon.gallery.framework.gallery.share.ShareStore;
import com.amazon.gallery.framework.gallery.wallpaper.LockscreenWallpaperUtilWrapper;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.IOUtils;

public class LockscreenTask
    implements Runnable
{

    private static final String TAG = com/amazon/gallery/framework/kindle/action/wallpaper/LockscreenTask.getName();
    private final Activity context;
    private Set locationTargets;
    private final List mediaItems;
    private final PrepareMediaItemsHelper prepareItemsHelper;
    private final ComponentProfiler profiler;
    private final ShareStore shareStore;

    public LockscreenTask(Activity activity, ShareStore sharestore, PrepareMediaItemsHelper preparemediaitemshelper, List list)
    {
        locationTargets = EnumSet.noneOf(com/amazon/gallery/framework/kindle/action/wallpaper/WallpaperConstants$TargetLocations);
        mediaItems = list;
        context = activity;
        shareStore = sharestore;
        prepareItemsHelper = preparemediaitemshelper;
        profiler = new ComponentProfiler((Profiler)ThorGalleryApplication.getBean(Keys.PROFILER), getClass());
    }

    private String[] getLocationExtra()
    {
        String as[] = new String[locationTargets.size()];
        int i = 0;
        for (Iterator iterator = locationTargets.iterator(); iterator.hasNext();)
        {
            as[i] = ((WallpaperConstants.TargetLocations)iterator.next()).key;
            i++;
        }

        return as;
    }

    private boolean trySetLockscreenFromFile(List list)
    {
        LockscreenWallpaperUtilWrapper lockscreenwallpaperutilwrapper;
        lockscreenwallpaperutilwrapper = new LockscreenWallpaperUtilWrapper();
        lockscreenwallpaperutilwrapper.prepareLockscreenDirectory();
        list = list.iterator();
_L1:
        Object obj;
        if (!list.hasNext())
        {
            break MISSING_BLOCK_LABEL_97;
        }
        obj = (MediaItem)list.next();
        obj = shareStore.prepareMediaItemForSharing(((MediaItem) (obj)), 2048, 2048, com.amazon.gallery.framework.data.store.Asset.AssetType.JPG, 3);
label0:
        {
            if (obj == null)
            {
                break label0;
            }
            try
            {
                if (!((File) (obj)).exists())
                {
                    break label0;
                }
                lockscreenwallpaperutilwrapper.addLockscreenWallpaper(((File) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (List list)
            {
                GLogger.ex(TAG, "Exception caught while preparing wallpaper", list);
                return false;
            }
        }
          goto _L1
        return false;
        return true;
    }

    private boolean tryWallpaperIntent(MediaItem mediaitem, String as[], WallpaperManager wallpapermanager)
    {
        mediaitem = prepareItemsHelper.prepareItems(Collections.singletonList(mediaitem));
        if (mediaitem.size() == 1 && mediaitem.get(0) != null)
        {
            mediaitem = wallpapermanager.getCropAndSetWallpaperIntent((Uri)mediaitem.get(0));
            if (mediaitem == null)
            {
                return false;
            } else
            {
                mediaitem.setPackage("com.amazon.photos");
                mediaitem.putExtra("location", as);
                mediaitem.putExtra("EXTRA_CROP_INTERNAL", true);
                context.startActivity(mediaitem);
                return true;
            }
        } else
        {
            GLogger.e(TAG, "Failed to retrieve URI for mediaItem", new Object[0]);
            return false;
        }
    }

    private boolean tryWallpaperStream(MediaItem mediaitem, WallpaperManager wallpapermanager)
    {
        File file = shareStore.prepareMediaItemForSharing(mediaitem, 2048, 2048, com.amazon.gallery.framework.data.store.Asset.AssetType.JPG, 3);
        if (file == null || !file.exists()) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        Object obj2;
        obj1 = null;
        obj2 = null;
        obj = obj1;
        GLogger.i(TAG, "Setting wallpaper: %s", new Object[] {
            file.getAbsolutePath()
        });
        obj = obj1;
        obj1 = new FileInputStream(file);
        wallpapermanager.setStream(((java.io.InputStream) (obj1)));
        IOUtils.closeQuietly(((java.io.InputStream) (obj1)));
        return true;
        obj1;
        wallpapermanager = obj2;
_L6:
        obj = wallpapermanager;
        GLogger.wx(TAG, (new StringBuilder()).append("Failed to download image for item: %s").append(mediaitem.getObjectId()).toString(), ((Throwable) (obj1)));
        IOUtils.closeQuietly(wallpapermanager);
        return false;
        mediaitem;
_L4:
        IOUtils.closeQuietly(((java.io.InputStream) (obj)));
        throw mediaitem;
_L2:
        GLogger.e(TAG, "Unknown error occurred while preparing to share.", new Object[0]);
        return false;
        mediaitem;
        obj = obj1;
        if (true) goto _L4; else goto _L3
_L3:
        IOException ioexception;
        ioexception;
        wallpapermanager = ((WallpaperManager) (obj1));
        obj1 = ioexception;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void run()
    {
        WallpaperManager wallpapermanager;
        boolean flag1;
        wallpapermanager = WallpaperManager.getInstance(context);
        flag1 = true;
        if (!mediaItems.isEmpty() && !locationTargets.isEmpty()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L8:
        if (flag) goto _L4; else goto _L3
_L3:
        context.runOnUiThread(new Runnable() {

            final LockscreenTask this$0;

            public void run()
            {
                Toast.makeText(context, 0x7f0e018d, 0).show();
            }

            
            {
                this$0 = LockscreenTask.this;
                super();
            }
        });
        if (locationTargets.contains(WallpaperConstants.TargetLocations.HOME))
        {
            profiler.trackEvent(com.amazon.gallery.framework.kindle.action.LockscreenAction.MetricsEvent.WallpaperSetFailure);
        }
        if (locationTargets.contains(WallpaperConstants.TargetLocations.LOCKSCREEN))
        {
            profiler.trackEvent(com.amazon.gallery.framework.kindle.action.LockscreenAction.MetricsEvent.LockscreenSetFailure);
        }
_L6:
        return;
_L2:
        if (mediaItems.size() == 1)
        {
            MediaItem mediaitem = (MediaItem)mediaItems.get(0);
            flag1 = tryWallpaperIntent(mediaitem, getLocationExtra(), wallpapermanager);
            flag = flag1;
            if (!flag1)
            {
                if (locationTargets.contains(WallpaperConstants.TargetLocations.HOME))
                {
                    flag1 = tryWallpaperStream(mediaitem, wallpapermanager);
                }
                flag = flag1;
                if (locationTargets.contains(WallpaperConstants.TargetLocations.LOCKSCREEN))
                {
                    flag = flag1 & trySetLockscreenFromFile(mediaItems);
                }
            }
        } else
        {
            if (locationTargets.contains(WallpaperConstants.TargetLocations.HOME))
            {
                flag1 = tryWallpaperIntent((MediaItem)mediaItems.get(0), new String[] {
                    WallpaperConstants.TargetLocations.HOME.key
                }, wallpapermanager);
            }
            flag = flag1;
            if (locationTargets.contains(WallpaperConstants.TargetLocations.LOCKSCREEN))
            {
                flag = flag1 & trySetLockscreenFromFile(mediaItems);
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (locationTargets.contains(WallpaperConstants.TargetLocations.HOME))
        {
            profiler.trackEvent(com.amazon.gallery.framework.kindle.action.LockscreenAction.MetricsEvent.WallpaperSetSuccessfully);
        }
        if (!locationTargets.contains(WallpaperConstants.TargetLocations.LOCKSCREEN)) goto _L6; else goto _L5
_L5:
        profiler.trackEvent(com.amazon.gallery.framework.kindle.action.LockscreenAction.MetricsEvent.LockscreenSetSuccessfully);
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void setLocationTargets(Set set)
    {
        locationTargets = set;
    }


}
