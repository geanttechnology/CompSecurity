// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.content.Context;
import android.content.SharedPreferences;

public final class ej
{

    public SharedPreferences a;

    protected ej()
    {
    }

    public ej(Context context)
    {
        a = context.getSharedPreferences("com.crittercism.ratemyapp", 0);
    }

    public final int a()
    {
        return a.getInt("numAppLoads", 0);
    }

    public final void a(boolean flag)
    {
        a.edit().putBoolean("rateMyAppEnabled", flag).commit();
    }
}
