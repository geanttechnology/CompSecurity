// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.SharedPreferences;

// Referenced classes of package android.support.v7:
//            nj

static final class nit> extends nj
{

    public Object a(SharedPreferences sharedpreferences)
    {
        return b(sharedpreferences);
    }

    public Long b(SharedPreferences sharedpreferences)
    {
        return Long.valueOf(sharedpreferences.getLong(a(), ((Long)b()).longValue()));
    }

    eferences(String s, Long long1)
    {
        super(s, long1, null);
    }
}
