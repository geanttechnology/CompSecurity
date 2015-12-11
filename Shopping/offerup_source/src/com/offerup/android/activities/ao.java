// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.offerup.android.activities:
//            ChangeLocationActivity

final class ao
    implements android.view.View.OnClickListener
{

    private ChangeLocationActivity a;

    ao(ChangeLocationActivity changelocationactivity)
    {
        a = changelocationactivity;
        super();
    }

    public final void onClick(View view)
    {
        a.d.setError(null);
        a.b = "";
        a.d.setText("");
        a.c = true;
        a.g = ProgressDialog.show(a, "", a.getString(0x7f090144));
        a.g.setCancelable(true);
        a.f();
    }
}
