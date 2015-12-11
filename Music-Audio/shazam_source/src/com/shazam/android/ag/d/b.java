// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ag.d;

import android.content.Intent;
import android.content.pm.PackageManager;
import com.shazam.android.k.i;

public final class b
    implements i
{

    private final PackageManager a;

    public b(PackageManager packagemanager)
    {
        a = packagemanager;
    }

    public final boolean a(Intent intent)
    {
        return intent != null && a.resolveActivity(intent, 0x10000) != null;
    }
}
