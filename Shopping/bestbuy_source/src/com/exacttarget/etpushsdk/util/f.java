// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;

// Referenced classes of package com.exacttarget.etpushsdk.util:
//            d

final class f
    implements Runnable
{

    final String a;
    final Context b;

    f(String s, Context context)
    {
        a = s;
        b = context;
        super();
    }

    public void run()
    {
        d.k().remove(a);
        b.getSharedPreferences("ETPush", 0).edit().remove(d.d(a)).commit();
    }
}
