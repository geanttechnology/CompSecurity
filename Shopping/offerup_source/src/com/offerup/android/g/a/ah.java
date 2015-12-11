// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.view.View;
import com.offerup.android.dto.Person;

// Referenced classes of package com.offerup.android.g.a:
//            ag, ai

final class ah
    implements android.view.View.OnClickListener
{

    private ag a;

    ah(ag ag1)
    {
        a = ag1;
        super();
    }

    public final void onClick(View view)
    {
        ag.b(a).a(ag.a(a).getId());
    }
}
