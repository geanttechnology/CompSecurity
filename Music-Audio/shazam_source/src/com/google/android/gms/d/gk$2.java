// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

// Referenced classes of package com.google.android.gms.d:
//            gk

static final class <init> extends <init>
{

    final Context a;
    final a b;

    public final void a()
    {
        SharedPreferences sharedpreferences = a.getSharedPreferences("admob", 0);
        Bundle bundle = new Bundle();
        bundle.putBoolean("use_https", sharedpreferences.getBoolean("use_https", true));
        if (b != null)
        {
            b.a(bundle);
        }
    }

    ces(Context context, ces ces)
    {
        a = context;
        b = ces;
        super((byte)0);
    }
}
