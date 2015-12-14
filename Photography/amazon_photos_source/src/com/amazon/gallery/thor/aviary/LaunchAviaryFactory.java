// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.aviary;

import android.content.Context;
import com.amazon.gallery.framework.gallery.actions.LaunchAviary;
import com.amazon.gallery.thor.app.FreeTime;
import com.amazon.gallery.thor.app.FreeTimeCommon;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.di.AppKeys;

// Referenced classes of package com.amazon.gallery.thor.aviary:
//            FreetimeLaunchAviary, ThorLaunchAviary

public class LaunchAviaryFactory
{

    public static LaunchAviary createLaunchAviary(Context context)
    {
        Object obj = (ThorGalleryApplication)context;
        obj = (FreeTime)ThorGalleryApplication.getBean(AppKeys.THOR_FREE_TIME);
        if (((FreeTime) (obj)).isFreeTimeFeatureEnabled() && ((FreeTime) (obj)).isFreeTime())
        {
            if (FreeTimeCommon.getUserTheme(context) == com.amazon.gallery.thor.app.FreeTimeCommon.ProfileState.FREETIME)
            {
                return new FreetimeLaunchAviary(context);
            } else
            {
                return new ThorLaunchAviary(context);
            }
        } else
        {
            return new ThorLaunchAviary(context);
        }
    }
}
