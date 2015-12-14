// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.app.Activity;
import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.framework.kindle.CameraUtils;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.thor.app.FreeTime;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.di.AppKeys;
import java.util.EnumSet;
import java.util.Iterator;

public class Page
{
    public static final class VisibilityFlag extends Enum
    {

        private static final VisibilityFlag $VALUES[];
        public static final VisibilityFlag INVISIBLE_BEFORE_CLOUD_SYNC;
        public static final VisibilityFlag INVISIBLE_IN_AOSP;
        public static final VisibilityFlag INVISIBLE_IN_CHOOSER_MODE;
        public static final VisibilityFlag INVISIBLE_IN_FREETIME_MODE;
        public static final VisibilityFlag INVISIBLE_IN_PRODUCTION;
        public static final VisibilityFlag INVISIBLE_WHEN_CAMERA_UNAVAILABLE;

        public static VisibilityFlag valueOf(String s)
        {
            return (VisibilityFlag)Enum.valueOf(com/amazon/gallery/framework/kindle/activity/Page$VisibilityFlag, s);
        }

        public static VisibilityFlag[] values()
        {
            return (VisibilityFlag[])$VALUES.clone();
        }

        static 
        {
            INVISIBLE_IN_CHOOSER_MODE = new VisibilityFlag("INVISIBLE_IN_CHOOSER_MODE", 0);
            INVISIBLE_IN_AOSP = new VisibilityFlag("INVISIBLE_IN_AOSP", 1);
            INVISIBLE_WHEN_CAMERA_UNAVAILABLE = new VisibilityFlag("INVISIBLE_WHEN_CAMERA_UNAVAILABLE", 2);
            INVISIBLE_BEFORE_CLOUD_SYNC = new VisibilityFlag("INVISIBLE_BEFORE_CLOUD_SYNC", 3);
            INVISIBLE_IN_FREETIME_MODE = new VisibilityFlag("INVISIBLE_IN_FREETIME_MODE", 4);
            INVISIBLE_IN_PRODUCTION = new VisibilityFlag("INVISIBLE_IN_PRODUCTION", 5);
            $VALUES = (new VisibilityFlag[] {
                INVISIBLE_IN_CHOOSER_MODE, INVISIBLE_IN_AOSP, INVISIBLE_WHEN_CAMERA_UNAVAILABLE, INVISIBLE_BEFORE_CLOUD_SYNC, INVISIBLE_IN_FREETIME_MODE, INVISIBLE_IN_PRODUCTION
            });
        }

        private VisibilityFlag(String s, int i)
        {
            super(s, i);
        }
    }


    private volatile boolean doesCloudContentExist;
    private final com.amazon.gallery.framework.kindle.metrics.UIClickMetrics.MetricsEvent metric;
    protected final EnumSet visibilityFlags;

    public Page(com.amazon.gallery.framework.kindle.metrics.UIClickMetrics.MetricsEvent metricsevent, EnumSet enumset)
    {
        metric = metricsevent;
        visibilityFlags = enumset;
    }

    private boolean validateVisibilityCriteria(Activity activity, VisibilityFlag visibilityflag)
    {
        boolean flag = false;
        if (visibilityflag != VisibilityFlag.INVISIBLE_IN_CHOOSER_MODE) goto _L2; else goto _L1
_L1:
        if (IntentUtil.isChooser(activity.getIntent())) goto _L4; else goto _L3
_L3:
        flag = true;
_L6:
        return flag;
_L4:
        return false;
_L2:
        if (visibilityflag == VisibilityFlag.INVISIBLE_IN_AOSP)
        {
            return !BuildFlavors.isAosp();
        }
        if (visibilityflag == VisibilityFlag.INVISIBLE_WHEN_CAMERA_UNAVAILABLE)
        {
            return CameraUtils.isCameraAvailable(activity);
        }
        if (visibilityflag == VisibilityFlag.INVISIBLE_BEFORE_CLOUD_SYNC)
        {
            return doesCloudContentExist;
        }
        if (visibilityflag == VisibilityFlag.INVISIBLE_IN_FREETIME_MODE)
        {
            return !((FreeTime)ThorGalleryApplication.getBean(AppKeys.THOR_FREE_TIME)).isFreeTime();
        }
        if (visibilityflag == VisibilityFlag.INVISIBLE_IN_PRODUCTION)
        {
            return DebugAssert.isDebugBuild || BuildFlavors.isDebug();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean isValid(Activity activity)
    {
        if (!visibilityFlags.isEmpty()) goto _L2; else goto _L1
_L1:
        boolean flag1 = true;
_L4:
        return flag1;
_L2:
        boolean flag = true;
        Iterator iterator = visibilityFlags.iterator();
        do
        {
            flag1 = flag;
            if (!iterator.hasNext())
            {
                continue;
            }
            flag &= validateVisibilityCriteria(activity, (VisibilityFlag)iterator.next());
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean onClick(Activity activity)
    {
        return false;
    }

    public void setCloudContentExists(boolean flag)
    {
        doesCloudContentExist = flag;
    }
}
