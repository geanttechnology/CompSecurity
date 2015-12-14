// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;

import android.content.Context;
import android.content.pm.PackageManager;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;

public class CameraUtils
{

    public static boolean isCameraAvailable(Context context)
    {
        context = context.getPackageManager();
        return !BuildFlavors.isAosp() && (context.hasSystemFeature("android.hardware.camera") || context.hasSystemFeature("android.hardware.camera.front"));
    }
}
