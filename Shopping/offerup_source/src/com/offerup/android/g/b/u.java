// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.b;

import android.content.DialogInterface;
import com.facebook.login.LoginManager;
import com.offerup.android.utils.v;

// Referenced classes of package com.offerup.android.g.b:
//            k

final class u
    implements android.content.DialogInterface.OnClickListener
{

    private k a;

    u(k k)
    {
        a = k;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        LoginManager.getInstance().logInWithReadPermissions(a, v.d);
    }
}
