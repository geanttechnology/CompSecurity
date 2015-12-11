// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c;

import android.content.Intent;
import com.shazam.android.k.i;
import com.shazam.model.Action;
import java.util.Map;

public final class a
    implements com.shazam.b.a.a
{

    private final i a;
    private final Map b;

    public a(i j, Map map)
    {
        a = j;
        b = map;
    }

    public final Object a(Object obj)
    {
        obj = (Action)obj;
        com.shazam.b.a.a a1 = (com.shazam.b.a.a)b.get(((Action) (obj)).type);
        if (a1 == null)
        {
            obj = null;
        } else
        {
            obj = (Intent)a1.a(obj);
        }
        if (!a.a(((Intent) (obj))))
        {
            return null;
        } else
        {
            return obj;
        }
    }
}
