// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.os.Build;

final class as
{

    int a;
    private String b;
    private String c;
    private String d;

    as()
    {
        b = Build.MANUFACTURER;
        c = Build.MODEL;
        d = android.os.Build.VERSION.RELEASE;
        a = android.os.Build.VERSION.SDK_INT;
    }
}
