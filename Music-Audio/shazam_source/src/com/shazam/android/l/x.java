// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l;

import android.content.Intent;
import android.net.Uri;
import com.shazam.b.a.a;
import com.shazam.model.Action;

public final class x
    implements a
{

    private final a a;

    public x(a a1)
    {
        a = a1;
    }

    public final Object a(Object obj)
    {
        obj = (Action)obj;
        return new Intent("android.intent.action.VIEW", (Uri)a.a(Uri.parse(((Action) (obj)).uri)));
    }
}
