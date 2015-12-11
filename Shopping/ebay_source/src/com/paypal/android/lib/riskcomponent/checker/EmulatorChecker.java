// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.lib.riskcomponent.checker;

import android.os.Build;

public class EmulatorChecker
{

    public static boolean isEmulator()
    {
        return Build.BRAND.equalsIgnoreCase("generic") || Build.PRODUCT.equals("sdk") || Build.HARDWARE.equals("goldfish") || Build.FINGERPRINT.startsWith("generic") || Build.MANUFACTURER.equals("unknown") || Build.PRODUCT.matches(".*_?sdk_?.*");
    }
}
