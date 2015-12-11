// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.DialogInterface;

// Referenced classes of package jumiomobile:
//            lp, nh, nd, lm, 
//            ha, lq

class ly
    implements android.content.DialogInterface.OnClickListener
{

    final lp a;

    private ly(lp lp1)
    {
        a = lp1;
        super();
    }

    ly(lp lp1, lq lq)
    {
        this(lp1);
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        lp.c(a).setUploadStatus(nh.a);
        a.a.getController().j();
        dialoginterface.cancel();
    }
}
