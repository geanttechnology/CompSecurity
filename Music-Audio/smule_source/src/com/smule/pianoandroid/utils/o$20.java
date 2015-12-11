// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.app.Dialog;
import android.view.View;

// Referenced classes of package com.smule.pianoandroid.utils:
//            o

final class b
    implements android.view.OnClickListener
{

    final Dialog a;
    final Runnable b;

    public void onClick(View view)
    {
        a.dismiss();
        b.run();
    }

    (Dialog dialog, Runnable runnable)
    {
        a = dialog;
        b = runnable;
        super();
    }
}
