// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.DialogInterface;
import b.a.a;
import com.b.a.a.j;
import com.offerup.android.utils.az;

// Referenced classes of package com.offerup.android.activities:
//            k

final class m
    implements android.content.DialogInterface.OnClickListener
{

    private j a;
    private a b;
    private k c;

    m(k k1, j j1, a a1)
    {
        c = k1;
        a = j1;
        b = a1;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        a.b(b.toString());
        az.a(c.getApplicationContext());
    }
}
