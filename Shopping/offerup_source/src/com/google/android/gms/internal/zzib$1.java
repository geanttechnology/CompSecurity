// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;

// Referenced classes of package com.google.android.gms.internal:
//            zzib

final class a extends a
{

    final boolean zzIo;
    final Context zzry;

    public final void zzbn()
    {
        android.content.references.Editor editor = zzib.zzG(zzry).edit();
        editor.putBoolean("use_https", zzIo);
        editor.apply();
    }

    r(Context context, boolean flag)
    {
        zzry = context;
        zzIo = flag;
        super(null);
    }
}
