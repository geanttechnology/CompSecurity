// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.SharedPreferences;

// Referenced classes of package com.google.android.gms.d:
//            au

static final class nit> extends au
{

    public final Object a(SharedPreferences sharedpreferences)
    {
        return Long.valueOf(sharedpreferences.getLong(super.a, ((Long)super.b).longValue()));
    }

    ces(String s, Long long1)
    {
        super(s, long1, (byte)0);
    }
}
