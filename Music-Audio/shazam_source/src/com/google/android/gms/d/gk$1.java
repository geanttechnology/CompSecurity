// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.content.SharedPreferences;

// Referenced classes of package com.google.android.gms.d:
//            gk

static final class <init> extends <init>
{

    final Context a;
    final boolean b;

    public final void a()
    {
        android.content.dPreferences.Editor editor = a.getSharedPreferences("admob", 0).edit();
        editor.putBoolean("use_https", b);
        editor.apply();
    }

    ces.Editor(Context context, boolean flag)
    {
        a = context;
        b = flag;
        super((byte)0);
    }
}
