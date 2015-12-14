// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.camera;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.widget.Toast;
import com.amazon.gallery.framework.kindle.LaunchCamera;

public class ThorLaunchCamera extends LaunchCamera
{

    public ThorLaunchCamera()
    {
    }

    public void launchCamera(Activity activity)
    {
        Object obj = new Intent("android.media.action.IMAGE_CAPTURE");
        obj = activity.getPackageManager().resolveActivity(((Intent) (obj)), 0);
        if (obj != null)
        {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(((ResolveInfo) (obj)).activityInfo.packageName, ((ResolveInfo) (obj)).activityInfo.name));
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            activity.startActivity(intent);
            return;
        } else
        {
            Toast.makeText(activity, 0x7f0e00f2, 0).show();
            return;
        }
    }
}
