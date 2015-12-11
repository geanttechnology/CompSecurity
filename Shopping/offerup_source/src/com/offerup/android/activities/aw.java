// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;
import android.widget.EditText;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            ChangePostLocationActivity, bb

final class aw
    implements android.view.View.OnClickListener
{

    private ChangePostLocationActivity a;

    aw(ChangePostLocationActivity changepostlocationactivity)
    {
        a = changepostlocationactivity;
        super();
    }

    public final void onClick(View view)
    {
        a.b = a.j.getText().toString();
        if (!a.d)
        {
            if (StringUtils.isEmpty(a.b) && !a.d)
            {
                a.m();
                return;
            }
            if (!ChangePostLocationActivity.a(a.b))
            {
                a.m();
                return;
            }
            if (a.a == null)
            {
                a.a(new bb(a, a, a.b, false, true, a.getString(0x7f090147), true), new Object[0]);
                return;
            }
        } else
        {
            a.j.setError(null);
        }
        a.a();
    }
}
