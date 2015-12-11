// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import com.smule.android.c.a;
import com.smule.android.d.u;
import com.smule.android.network.models.f;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            as, at

class b
    implements android.view.OnClickListener
{

    final f a;
    final u b;
    final as c;

    public void onClick(View view)
    {
        if (as.b(c) != null)
        {
            com.smule.android.c.a.a(a.sku, a.period, b.b());
            as.b(c).a(a.sku);
        }
        c.dismiss();
    }

    (as as1, f f1, u u1)
    {
        c = as1;
        a = f1;
        b = u1;
        super();
    }
}
