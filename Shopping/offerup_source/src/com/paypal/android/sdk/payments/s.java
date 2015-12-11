// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import com.paypal.android.sdk.fd;
import com.paypal.android.sdk.ff;
import com.paypal.android.sdk.fg;
import java.util.List;

// Referenced classes of package com.paypal.android.sdk.payments:
//            r, LoginActivity

final class s
    implements android.content.DialogInterface.OnClickListener
{

    private r a;

    s(r r1)
    {
        a = r1;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        LoginActivity.a(a.c, i);
        a.a.a(i);
        LoginActivity.k(a.c).o.a((String)a.b.get(i));
    }
}
