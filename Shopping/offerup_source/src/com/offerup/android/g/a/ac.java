// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.content.Intent;
import android.support.v4.app.t;
import android.support.v4.e.a;
import android.view.View;
import android.widget.ImageView;
import com.offerup.android.activities.LoginActivity;
import com.offerup.android.utils.ba;

// Referenced classes of package com.offerup.android.g.a:
//            y

final class ac
    implements android.view.View.OnClickListener
{

    private y a;

    ac(y y1)
    {
        a = y1;
        super();
    }

    public final void onClick(View view)
    {
        if (ba.a())
        {
            if (android.support.v4.e.a.b(a.getActivity().getApplicationContext()))
            {
                y.d(a);
                if (!y.e(a))
                {
                    y.b(a, 0x7f09021d);
                    return;
                } else
                {
                    y.b(a, 0x7f09021e);
                    y.f(a);
                    return;
                }
            } else
            {
                y.b(a, 0x7f09021c);
                return;
            }
        } else
        {
            y.g(a).setOnClickListener(null);
            view = new Intent(a.getActivity(), com/offerup/android/activities/LoginActivity);
            a.startActivityForResult(view, 2);
            return;
        }
    }
}
