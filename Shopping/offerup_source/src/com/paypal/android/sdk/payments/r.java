// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.app.AlertDialog;
import android.view.View;
import com.paypal.android.sdk.ex;
import com.paypal.android.sdk.fa;
import com.paypal.android.sdk.ff;
import java.util.List;

// Referenced classes of package com.paypal.android.sdk.payments:
//            s, LoginActivity

final class r
    implements android.view.View.OnClickListener
{

    final ff a;
    final List b;
    final LoginActivity c;

    r(LoginActivity loginactivity, ff ff, List list)
    {
        c = loginactivity;
        a = ff;
        b = list;
        super();
    }

    public final void onClick(View view)
    {
        view = new android.app.AlertDialog.Builder(view.getContext());
        view.setTitle(ex.a(fa.aX)).setAdapter(a, new s(this));
        view.create().show();
    }
}
