// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.fragments;

import android.os.Bundle;
import com.shazam.android.aspects.b.b.a;
import com.shazam.android.widget.tagging.j;
import com.shazam.android.widget.tagging.n;

public class ShazamFloatingButtonDialogFragmentAspect extends a
{

    private final n lifecycleManager = new n();

    public ShazamFloatingButtonDialogFragmentAspect()
    {
    }

    public void onActivityCreated(com.shazam.android.aspects.c.b.a a1, Bundle bundle)
    {
        n.a(a1, j.a(a1));
    }

    public void onPause(com.shazam.android.aspects.c.b.a a1)
    {
        n.b(a1);
    }

    public void onResume(com.shazam.android.aspects.c.b.a a1)
    {
        n.a(a1);
    }
}
