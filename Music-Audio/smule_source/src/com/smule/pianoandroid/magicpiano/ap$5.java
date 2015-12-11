// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ap

class a
    implements android.view.OnClickListener
{

    final Runnable a;
    final ap b;

    public void onClick(View view)
    {
        a.run();
    }

    (ap ap1, Runnable runnable)
    {
        b = ap1;
        a = runnable;
        super();
    }
}
