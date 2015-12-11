// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;
import android.widget.EditText;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            ChangeLocationActivity, as

final class an
    implements android.view.View.OnClickListener
{

    private ChangeLocationActivity a;

    an(ChangeLocationActivity changelocationactivity)
    {
        a = changelocationactivity;
        super();
    }

    public final void onClick(View view)
    {
        a.b = a.d.getText().toString();
        if (!a.c)
        {
            if (StringUtils.isEmpty(a.b) && !a.c)
            {
                a.m();
                return;
            }
            if (!ChangeLocationActivity.a(a.b))
            {
                a.m();
                return;
            }
            if (a.a == null)
            {
                a.a(new as(a, a, a.b, true, true, a.getString(0x7f090147), true), new Object[0]);
                return;
            }
        } else
        {
            a.d.setError(null);
        }
        a.a();
    }
}
