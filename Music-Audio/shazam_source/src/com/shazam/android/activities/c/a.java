// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.c;

import android.app.Activity;
import com.shazam.android.p.i;
import com.shazam.i.b.r.d;

public final class a
{

    public static void a(Activity activity)
    {
        i j = d.a();
        if (j.c || j.d)
        {
            activity.setRequestedOrientation(1);
        }
    }
}
