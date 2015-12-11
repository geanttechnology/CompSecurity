// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.offerup.android.activities:
//            ChangePostLocationActivity

final class ax
    implements android.view.View.OnClickListener
{

    private ChangePostLocationActivity a;

    ax(ChangePostLocationActivity changepostlocationactivity)
    {
        a = changepostlocationactivity;
        super();
    }

    public final void onClick(View view)
    {
        a.j.setError(null);
        a.b = "";
        a.j.setText("");
        a.c = false;
        a.d = true;
        a.g = ProgressDialog.show(a, "", a.getString(0x7f090144));
        a.g.setCancelable(true);
        a.f();
    }
}
