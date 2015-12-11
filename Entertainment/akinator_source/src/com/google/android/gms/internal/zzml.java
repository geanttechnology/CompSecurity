// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.regex.Pattern;

public final class zzml
{

    private static Pattern zzaij = null;

    public static boolean zzan(Context context)
    {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static int zzca(int i)
    {
        return i / 1000;
    }

    public static boolean zzcb(int i)
    {
        return false;
    }

}
