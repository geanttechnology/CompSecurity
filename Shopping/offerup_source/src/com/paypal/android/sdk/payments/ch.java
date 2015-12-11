// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.content.DialogInterface;

// Referenced classes of package com.paypal.android.sdk.payments:
//            ca

final class ch
    implements android.content.DialogInterface.OnClickListener
{

    private ca a;

    ch(ca ca1)
    {
        a = ca1;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        ca.c(a);
    }
}
