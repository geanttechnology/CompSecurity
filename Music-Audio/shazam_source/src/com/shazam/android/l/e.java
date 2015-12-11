// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l;

import android.content.Intent;
import com.shazam.b.a.a;
import com.shazam.model.Action;

public final class e
    implements a
{

    private final a a;

    public e(a a1)
    {
        a = a1;
    }

    public final volatile Object a(Object obj)
    {
        obj = (Action)obj;
        return (Intent)a.a(com.shazam.android.k.f.a.a(com.shazam.android.k.f.a.m, new Object[] {
            ((Action) (obj)).id
        }));
    }
}
