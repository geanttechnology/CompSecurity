// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.content.DialogInterface;

// Referenced classes of package com.tapjoy:
//            TJAdUnitJSBridge

final class a
    implements android.content.lickListener
{

    final String a;
    final TJAdUnitJSBridge b;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        int j;
        boolean flag;
        flag = false;
        j = ((flag) ? 1 : 0);
        i;
        JVM INSTR tableswitch -3 -1: default 32
    //                   -3 58
    //                   -2 35
    //                   -1 63;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_63;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        j = ((flag) ? 1 : 0);
_L5:
        try
        {
            b.invokeJSCallback(a, new Object[] {
                Integer.valueOf(j)
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            dialoginterface.printStackTrace();
        }
        break MISSING_BLOCK_LABEL_73;
_L2:
        j = 1;
          goto _L5
        j = 2;
          goto _L5
    }

    e(TJAdUnitJSBridge tjadunitjsbridge, String s)
    {
        b = tjadunitjsbridge;
        a = s;
        super();
    }
}
