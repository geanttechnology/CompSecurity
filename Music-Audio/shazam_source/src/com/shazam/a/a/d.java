// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.a.a;

import com.shazam.a.a.a.g;
import com.shazam.android.analytics.TaggingStatus;
import com.shazam.h.l;
import com.shazam.h.x;
import com.shazam.model.Track;
import com.shazam.server.legacy.orbitconfig.OrbitConfig;
import java.net.URL;

public interface d
{

    public abstract g a(com.shazam.android.ay.b.d d1, int i, x x, TaggingStatus taggingstatus);

    public abstract Track a(URL url);

    public abstract OrbitConfig a(boolean flag, String s);

    public abstract void a();

    public abstract l b();
}
