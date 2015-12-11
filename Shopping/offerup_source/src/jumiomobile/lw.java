// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.DialogInterface;

// Referenced classes of package jumiomobile:
//            lp, lm, ht

class lw
    implements android.content.DialogInterface.OnClickListener
{

    final lp a;
    private ht b;

    public lw(lp lp1, ht ht)
    {
        a = lp1;
        super();
        b = ht;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        a.a.cancelSDK(b);
    }
}
