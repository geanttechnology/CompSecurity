// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.c;

import android.view.View;
import android.widget.CheckBox;

// Referenced classes of package com.offerup.android.g.c:
//            z

final class aa
    implements android.view.View.OnClickListener
{

    private z a;

    aa(z z1)
    {
        a = z1;
        super();
    }

    public final void onClick(View view)
    {
        z.a(a).toggle();
    }
}
