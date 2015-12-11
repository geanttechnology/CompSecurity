// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.smule.android.c.aa;

public class m
{

    public static android.os.Debug.MemoryInfo a(Context context)
    {
        return ((ActivityManager)context.getSystemService("activity")).getProcessMemoryInfo(new int[] {
            Process.myPid()
        })[0];
    }

    public static void a(Activity activity)
    {
        if (activity != null)
        {
            Object obj = a(((Context) (activity)));
            obj = (new StringBuilder()).append("dPD: ").append(((android.os.Debug.MemoryInfo) (obj)).dalvikPrivateDirty).append(" nPD: ").append(((android.os.Debug.MemoryInfo) (obj)).nativePrivateDirty).append(" oPD: ").append(((android.os.Debug.MemoryInfo) (obj)).otherPrivateDirty).toString();
            aa.c(activity.getClass().getName(), (new StringBuilder()).append("Memory ").append(((String) (obj))).toString());
        }
    }
}
