// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.offerup.android.g.a:
//            p

final class q
    implements android.view.View.OnClickListener
{

    private p a;

    q(p p1)
    {
        a = p1;
        super();
    }

    public final void onClick(View view)
    {
        p.a(a).performClick();
    }
}
