// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.preference;

import android.content.DialogInterface;
import android.preference.CheckBoxPreference;
import com.socialin.android.apiv3.controllers.UpdateUserController;
import com.socialin.asyncnet.b;

// Referenced classes of package com.socialin.android.preference:
//            a

final class a
    implements android.content.ogInterface.OnCancelListener
{

    private a a;

    public final void onCancel(DialogInterface dialoginterface)
    {
        b.a().a(com.socialin.android.preference.a.e(a).getRequestId());
        com.socialin.android.preference.a.b(a).setEnabled(true);
    }

    e(a a1)
    {
        a = a1;
        super();
    }
}
