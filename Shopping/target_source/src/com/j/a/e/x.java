// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import android.content.DialogInterface;

// Referenced classes of package com.j.a.e:
//            az

class x
    implements android.content.DialogInterface.OnClickListener
{

    final az a;

    x(az az1)
    {
        a = az1;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
        az.d(a);
    }
}
