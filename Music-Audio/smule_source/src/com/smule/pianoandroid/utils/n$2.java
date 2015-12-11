// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.app.Activity;

// Referenced classes of package com.smule.pianoandroid.utils:
//            n

final class b
    implements Runnable
{

    final Activity a;
    final Runnable b;

    public void run()
    {
        a.runOnUiThread(b);
    }

    (Activity activity, Runnable runnable)
    {
        a = activity;
        b = runnable;
        super();
    }
}
