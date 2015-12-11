// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.DialogInterface;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ar

final class a
    implements android.content.gInterface.OnCancelListener
{

    final Runnable a;

    public void onCancel(DialogInterface dialoginterface)
    {
        if (a != null)
        {
            a.run();
        }
    }

    lListener(Runnable runnable)
    {
        a = runnable;
        super();
    }
}
