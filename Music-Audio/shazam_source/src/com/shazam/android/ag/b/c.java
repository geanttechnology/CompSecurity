// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ag.b;

import com.shazam.android.k.f.x;
import com.shazam.model.TrackStyle;
import com.shazam.model.details.VersionDecider;

public final class c
    implements VersionDecider
{

    public c()
    {
    }

    public final boolean a(x x1)
    {
        return "unknown".equals(x1.g()) || !x1.m();
    }

    public final TrackStyle b(x x1)
    {
        if (a(x1))
        {
            return null;
        } else
        {
            return TrackStyle.from(x1.g());
        }
    }
}
