// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip;

import android.content.DialogInterface;
import tz;

// Referenced classes of package com.pipcamera.activity.pip:
//            PipStyleActivity

class a
    implements android.content.ancelListener
{

    final PipStyleActivity a;

    public void onCancel(DialogInterface dialoginterface)
    {
        tz.a().b();
    }

    er(PipStyleActivity pipstyleactivity)
    {
        a = pipstyleactivity;
        super();
    }
}
