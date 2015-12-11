// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.c;

import android.widget.CompoundButton;
import com.offerup.android.b.a;
import com.squareup.otto.Bus;

// Referenced classes of package com.offerup.android.g.c:
//            z

final class ab
    implements android.widget.CompoundButton.OnCheckedChangeListener
{

    private z a;

    ab(z z1)
    {
        a = z1;
        super();
    }

    public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        com.offerup.android.g.c.z.a(a, flag);
        com.offerup.android.b.a.getInstance().post(a.k());
        if (flag)
        {
            z.b(a);
        }
    }
}
