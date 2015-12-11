// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.aq;

import android.content.Context;
import com.shazam.android.ax.e;
import com.shazam.i.b.c;
import com.shazam.model.availability.AppInstallationVerifier;

public final class a
{

    public static AppInstallationVerifier a()
    {
        return new e(c.a().getPackageManager());
    }
}
