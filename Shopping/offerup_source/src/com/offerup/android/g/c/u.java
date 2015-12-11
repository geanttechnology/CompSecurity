// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.c;

import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.offerup.android.g.c:
//            t

final class u
    implements android.view.View.OnClickListener
{

    private t a;

    u(t t1)
    {
        a = t1;
        super();
    }

    public final void onClick(View view)
    {
        t.a(a).setSelection(t.a(a).getText().toString().length());
    }
}
