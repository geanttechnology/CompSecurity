// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.content.DialogInterface;

// Referenced classes of package com.applovin.impl.sdk:
//            ar, aq, z

class av
    implements android.content.DialogInterface.OnClickListener
{

    final ar a;

    av(ar ar1)
    {
        a = ar1;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        aq.f(a.a).a(aq.e(a.a));
    }
}
