// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.activities.advert;

import android.os.Bundle;
import com.shazam.android.advert.a.e;
import com.shazam.android.aspects.b.a.b;
import com.shazam.i.b.e.a.a;

public class AdColonyActivityAspect extends b
{

    private final e adColonyWrapper = a.a();

    public AdColonyActivityAspect()
    {
    }

    public void onCreate(com.shazam.android.aspects.c.a.a a1, Bundle bundle)
    {
        super.onCreate(a1, bundle);
        adColonyWrapper.a(a1);
    }

    public void onPause(com.shazam.android.aspects.c.a.a a1)
    {
        adColonyWrapper.a();
    }

    public void onResume(com.shazam.android.aspects.c.a.a a1)
    {
        adColonyWrapper.b(a1);
    }
}
