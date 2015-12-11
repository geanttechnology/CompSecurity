// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l;

import android.content.Intent;
import android.net.Uri;
import com.shazam.b.a.a;
import com.shazam.model.Action;

public final class ad
    implements a
{

    private final a a;

    public ad(a a1)
    {
        a = a1;
    }

    public final Object a(Object obj)
    {
        obj = (Action)obj;
        Object obj1 = Uri.parse(((Action) (obj)).uri);
        obj1 = new Intent("android.intent.action.VIEW", (Uri)a.a(obj1));
        if (((Action) (obj)).panel)
        {
            obj = "com.shazam.intent.category.PANEL";
        } else
        {
            obj = "com.shazam.intent.category.FULL_SCREEN";
        }
        ((Intent) (obj1)).addCategory(((String) (obj)));
        return obj1;
    }
}
