// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.app.Activity;

// Referenced classes of package com.smule.pianoandroid.utils:
//            o

final class a
    implements Runnable
{

    final Activity a;

    public void run()
    {
        a.overridePendingTransition(0x7f040014, 0x7f04001b);
        o.e(a);
    }

    (Activity activity)
    {
        a = activity;
        super();
    }
}
