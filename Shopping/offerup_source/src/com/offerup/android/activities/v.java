// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.DialogInterface;
import com.b.a.a.j;
import com.offerup.android.utils.az;

// Referenced classes of package com.offerup.android.activities:
//            k

final class v
    implements android.content.DialogInterface.OnClickListener
{

    private j a;
    private k b;

    v(k k1, j j1)
    {
        b = k1;
        a = j1;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        a.b(a.j());
        az.a(b.getApplicationContext());
    }
}
