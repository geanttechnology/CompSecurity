// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.activities;

import android.os.Bundle;
import com.shazam.android.aspects.b.a.b;
import com.shazam.android.aspects.c.a.a;
import com.shazam.android.widget.tagging.j;
import com.shazam.android.widget.tagging.n;

public class ShazamFloatingButtonActivityAspect extends b
{

    private final n shazamFloatingButtonLifecycleManager = new n();

    public ShazamFloatingButtonActivityAspect()
    {
    }

    public void onPause(a a)
    {
        n.a(a, a);
    }

    public void onPostCreate(a a, Bundle bundle)
    {
        n.a(a, a, j.a(a));
    }

    public void onResume(a a)
    {
        n.b(a, a);
    }
}
