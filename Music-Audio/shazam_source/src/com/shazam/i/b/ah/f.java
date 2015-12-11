// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.ah;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.shazam.android.persistence.n.a;
import com.shazam.android.persistence.n.b;
import com.shazam.i.b.c;

public final class f
{

    private static final SharedPreferences a;
    private static final b b;

    public static b a()
    {
        return b;
    }

    static 
    {
        a = PreferenceManager.getDefaultSharedPreferences(c.a());
        b = new a(a, a.edit());
    }
}
