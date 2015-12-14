// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.gl;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;

public final class GLUtils
{

    private static int mGlEsVersion = -1;

    private GLUtils()
    {
    }

    public static boolean getGlEsEnabled(Context context)
    {
        return n_getOpenGLEnabled();
    }

    public static int getGlEsVersion(Context context)
    {
        if (mGlEsVersion == -1)
        {
            mGlEsVersion = ((ActivityManager)context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion;
        }
        return mGlEsVersion;
    }

    public static native boolean n_getOpenGLEnabled();

}
