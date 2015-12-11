// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.c;

import android.view.View;
import android.widget.CheckBox;

// Referenced classes of package com.offerup.android.g.c:
//            t

final class v
    implements android.view.View.OnClickListener
{

    private t a;

    v(t t1)
    {
        a = t1;
        super();
    }

    public final void onClick(View view)
    {
        view = t.b(a);
        boolean flag;
        if (!t.b(a).isChecked())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setChecked(flag);
    }
}
