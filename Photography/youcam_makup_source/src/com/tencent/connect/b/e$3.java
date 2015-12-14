// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.b;

import android.content.DialogInterface;
import com.tencent.open.web.security.JniInterface;

// Referenced classes of package com.tencent.connect.b:
//            e

class a
    implements android.content.ogInterface.OnDismissListener
{

    final e a;

    public void onDismiss(DialogInterface dialoginterface)
    {
        try
        {
            JniInterface.clearAllPWD();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            return;
        }
    }

    rface(e e1)
    {
        a = e1;
        super();
    }
}
