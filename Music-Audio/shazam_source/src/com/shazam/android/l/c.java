// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l;

import android.content.Intent;
import com.shazam.android.k.f.x;
import com.shazam.b.a.a;
import com.shazam.model.Action;

public final class c
    implements a
{

    public c()
    {
    }

    public final Object a(Object obj)
    {
        obj = (Action)obj;
        com.shazam.android.k.f.aa.a a1 = new com.shazam.android.k.f.aa.a();
        a1.l = true;
        a1.c = ((Action) (obj)).trackTitle;
        a1.e = ((Action) (obj)).artist;
        a1.f = ((Action) (obj)).coverArt;
        a1.b = ((Action) (obj)).id;
        a1.d = ((Action) (obj)).key;
        return new Intent("android.intent.action.VIEW", a1.a().a());
    }
}
