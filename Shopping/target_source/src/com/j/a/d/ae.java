// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.content.DialogInterface;

// Referenced classes of package com.j.a.d:
//            e

class ae
    implements android.content.DialogInterface.OnClickListener
{

    final e a;

    ae(e e1)
    {
        a = e1;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
        e.k(a);
    }
}
