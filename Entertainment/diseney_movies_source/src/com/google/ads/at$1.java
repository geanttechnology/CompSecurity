// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

// Referenced classes of package com.google.ads:
//            at

static final class it>
    implements Runnable
{

    final Context a;

    public void run()
    {
        android.content.dPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a.getApplicationContext()).edit();
        editor.putString("drt", "");
        editor.putLong("drt_ts", 0L);
        editor.commit();
    }

    ext(Context context)
    {
        a = context;
        super();
    }
}
