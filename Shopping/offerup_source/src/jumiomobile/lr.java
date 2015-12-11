// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.DialogInterface;

// Referenced classes of package jumiomobile:
//            lp, lm, ht

class lr
    implements android.content.DialogInterface.OnCancelListener
{

    final ht a;
    final lp b;

    lr(lp lp1, ht ht)
    {
        b = lp1;
        a = ht;
        super();
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        b.a.cancelSDK(a);
    }
}
