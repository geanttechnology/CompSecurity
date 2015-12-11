// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.f.a;

import android.content.Intent;
import android.net.Uri;
import com.shazam.android.k.f.ac;
import com.shazam.b.a.a;
import com.shazam.model.Action;

public final class c
    implements a
{

    private final String a;
    private final ac b;

    public c(ac ac1, String s)
    {
        b = ac1;
        a = s;
    }

    public final Object a(Object obj)
    {
        obj = (Action)obj;
        obj = new Intent("android.intent.action.VIEW", b.a(Uri.parse(((Action) (obj)).href)));
        ((Intent) (obj)).setPackage(a);
        return obj;
    }
}
