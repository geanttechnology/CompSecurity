// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.deviantart;

import android.content.Context;
import android.content.SharedPreferences;

public final class a
{

    public Context a;
    public SharedPreferences b;

    public a(Context context)
    {
        a = null;
        b = null;
        a = context;
        b = context.getSharedPreferences("DeviantArtPrefs", 0);
    }
}
