// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.app.Dialog;
import android.content.DialogInterface;

// Referenced classes of package com.flurry.sdk:
//            eb

class >
    implements android.content.nterface.OnShowListener
{

    final e a;

    public void onShow(DialogInterface dialoginterface)
    {
        if (eb.z(a.a) != null)
        {
            eb.z(a.a).hide();
        }
    }

    Interface(Interface interface1)
    {
        a = interface1;
        super();
    }
}
