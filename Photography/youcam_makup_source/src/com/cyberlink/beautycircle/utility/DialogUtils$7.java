// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.cyberlink.beautycircle.c;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            DialogUtils, AccountManager

final class b
    implements android.view.stener
{

    final Activity a;
    final Dialog b;

    public void onClick(View view)
    {
        if (AccountManager.b() == null)
        {
            c.a(a, 2, 0, 0);
        }
        b.setOnDismissListener(null);
        b.dismiss();
    }

    (Activity activity, Dialog dialog)
    {
        a = activity;
        b = dialog;
        super();
    }
}
