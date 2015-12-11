// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.DialogInterface;
import com.offerup.android.utils.ba;

// Referenced classes of package com.offerup.android.activities:
//            MyAccountActivity, a

final class dc
    implements android.content.DialogInterface.OnClickListener
{

    private MyAccountActivity a;

    dc(MyAccountActivity myaccountactivity)
    {
        a = myaccountactivity;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        ba.a(a.getApplicationContext());
        a.f.m();
        a.finish();
    }
}
