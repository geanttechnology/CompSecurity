// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.packagemanager;

import android.content.Context;
import android.content.pm.PackageManager;

public class PackageHelper
{

    public static boolean isPackageAvailable(Context context, String s)
    {
        context = context.getPackageManager();
        try
        {
            context.getPackageInfo(s, 128);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }
}
