// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.support.v4.app.Fragment;
import com.offerup.android.tracker.a;

public abstract class b extends Fragment
{

    public b()
    {
    }

    abstract String a();

    public void onResume()
    {
        super.onResume();
        com.offerup.android.tracker.a.a(a());
    }
}
