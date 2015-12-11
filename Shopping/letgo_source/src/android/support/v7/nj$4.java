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

    public String b(SharedPreferences sharedpreferences)
    {
        return sharedpreferences.getString(a(), (String)b());
    }

    eferences(String s, String s1)
    {
        super(s, s1, null);
    }
}
