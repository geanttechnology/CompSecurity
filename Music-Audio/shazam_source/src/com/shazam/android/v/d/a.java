// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.v.d;

import com.shazam.c.j.a.c;
import com.shazam.i.d.d;
import com.shazam.model.Factory;
import com.shazam.model.news.TrackInfoCard;

public final class a
    implements Factory
{

    public a()
    {
    }

    public final Object create(Object obj)
    {
        return new c(d.a((TrackInfoCard)obj));
    }
}
