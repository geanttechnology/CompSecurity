// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.view.View;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            DialogUtils

final class d
    implements android.view.stener
{

    final Activity a;
    final Fragment b;
    final int c;
    final Dialog d;

    public void onClick(View view)
    {
        DialogUtils.a(a, b, c);
        d.setOnDismissListener(null);
        d.dismiss();
    }

    (Activity activity, Fragment fragment, int i, Dialog dialog)
    {
        a = activity;
        b = fragment;
        c = i;
        d = dialog;
        super();
    }
}
