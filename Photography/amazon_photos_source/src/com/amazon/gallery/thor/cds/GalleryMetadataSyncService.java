// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.content.SharedPreferences;
import com.amazon.clouddrive.extended.AmazonCloudDriveExtended;
import com.amazon.clouddrive.extended.AmazonCloudDriveExtendedClient;
import com.amazon.clouddrive.model.ListNodesRequest;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.mixtape.metrics.MixtapeMetricRecorder;
import com.amazon.mixtape.service.MixtapeSyncService;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            CloudDriveServiceClientManager, ThorMixtapeMetricRecorder

public class GalleryMetadataSyncService extends MixtapeSyncService
{

    private static final String TAG = com/amazon/gallery/thor/cds/GalleryMetadataSyncService.getName();
    private CloudDriveServiceClientManager cloudDriveServiceClientManager;
    private MixtapeMetricRecorder mixtapeMetricRecorder;
    private Profiler profiler;

    public GalleryMetadataSyncService()
    {
    }

    public volatile AmazonCloudDriveExtended getAmazonCloudDriveExtendedClient(String s)
    {
        return getAmazonCloudDriveExtendedClient(s);
    }

    public AmazonCloudDriveExtendedClient getAmazonCloudDriveExtendedClient(String s)
    {
        return cloudDriveServiceClientManager.getBackgroundCdsClient(s);
    }

    public MixtapeMetricRecorder getMixtapeMetricsRecorder()
    {
        return mixtapeMetricRecorder;
    }

    public List getPartialSyncListNodeRequests()
    {
        ListNodesRequest listnodesrequest = new ListNodesRequest();
        listnodesrequest.setSort("[\"contentProperties.contentDate DESC\"]");
        listnodesrequest.setFilters("kind:FILE AND contentProperties.contentType:(image* OR video*)");
        return Collections.singletonList(listnodesrequest);
    }

    public boolean isSyncProgressEnabled()
    {
        boolean flag = false;
        if (!getSharedPreferences("galleryKindleSharedPrefs", 0).getBoolean("coldBootStatus", false))
        {
            flag = true;
        }
        return flag;
    }

    public void onCreate()
    {
        super.onCreate();
        cloudDriveServiceClientManager = (CloudDriveServiceClientManager)ThorGalleryApplication.getBean(Keys.CLOUD_DRIVE_SERVICE_CLIENT_MANAGER);
        profiler = (Profiler)ThorGalleryApplication.getBean(Keys.PROFILER);
        mixtapeMetricRecorder = new ThorMixtapeMetricRecorder(profiler);
    }

}
