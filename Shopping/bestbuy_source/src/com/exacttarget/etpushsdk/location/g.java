// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.location;

import android.app.PendingIntent;
import android.location.LocationManager;

public abstract class g
{

    protected LocationManager a;

    protected g(LocationManager locationmanager)
    {
        a = locationmanager;
    }

    public void a(long l, long l1, PendingIntent pendingintent)
    {
    }
}
