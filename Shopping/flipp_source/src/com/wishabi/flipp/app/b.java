// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.DialogInterface;
import android.content.SharedPreferences;

// Referenced classes of package com.wishabi.flipp.app:
//            a

final class b
    implements android.content.DialogInterface.OnClickListener
{

    final SharedPreferences a;
    final a b;

    b(a a1, SharedPreferences sharedpreferences)
    {
        b = a1;
        a = sharedpreferences;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = a.edit();
        i;
        JVM INSTR tableswitch -2 -1: default 32
    //                   -2 61
    //                   -1 48;
           goto _L1 _L2 _L3
_L1:
        dialoginterface.putBoolean("has_responded_to_push_prompt", true).commit();
        return;
_L3:
        dialoginterface.putBoolean("allow_push", true);
        continue; /* Loop/switch isn't completed */
_L2:
        dialoginterface.putBoolean("allow_push", false);
        if (true) goto _L1; else goto _L4
_L4:
    }
}
