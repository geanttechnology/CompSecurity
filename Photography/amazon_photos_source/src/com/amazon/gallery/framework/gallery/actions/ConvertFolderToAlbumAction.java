// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.os.AsyncTask;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.albums.ConvertFolderToAlbumBlockingProgressDialog;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            TagAction

public class ConvertFolderToAlbumAction extends TagAction
{

    public static final String TAG = com/amazon/gallery/framework/gallery/actions/ConvertFolderToAlbumAction.getName();
    private final CloudDriveServiceClientManager cloudDriveServiceClientManager;
    private final ComponentProfiler componentProfiler;
    private final NetworkConnectivity networkConnectivity;

    public ConvertFolderToAlbumAction(Activity activity, NetworkConnectivity networkconnectivity, Profiler profiler)
    {
        super(activity, 0x7f0e01a8, profiler);
        networkConnectivity = networkconnectivity;
        cloudDriveServiceClientManager = (CloudDriveServiceClientManager)ThorGalleryApplication.getBean(Keys.CLOUD_DRIVE_SERVICE_CLIENT_MANAGER);
        componentProfiler = new ComponentProfiler(profiler, "AlbumsMetrics");
    }

    public boolean canExecuteTags(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            Tag tag = (Tag)list.next();
            if (tag.hasProperty(TagProperty.CAMERA) || tag.hasProperty(TagProperty.FREETIME) || !tag.getType().equals(TagType.FOLDER) || !tag.hasProperty(TagProperty.CLOUD))
            {
                return false;
            }
        }

        return true;
    }

    public void executeTags(List list)
    {
        GLogger.d(TAG, "Converting to folder", new Object[0]);
        if (list.size() == 0 || networkConnectivity.promptIfOffline(context))
        {
            return;
        } else
        {
            (new ConvertFolderToAlbumBlockingProgressDialog(context, list, componentProfiler, cloudDriveServiceClientManager.getForegroundCdsClient())).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
    }

}
