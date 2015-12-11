// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.u;
import com.google.android.gms.b.y;

public class a
{

    private a a;
    private boolean b;
    private boolean c;

    public a()
    {
        c = ((Boolean)y.g.c()).booleanValue();
    }

    public a(boolean flag)
    {
        c = flag;
    }

    public void a(String s)
    {
        com.google.android.gms.ads.internal.util.client.b.a("Action was blocked because no click was detected.");
    /* block-local class not found */
    class a {}

        if (a != null)
        {
            a.a(s);
        }
    }

    public boolean a()
    {
        return !c || b;
    }
}
