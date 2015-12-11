// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.a;

import android.view.View;
import com.offerup.android.activities.UserDetailActivity;

// Referenced classes of package com.offerup.android.a:
//            au

final class av
    implements android.view.View.OnClickListener
{

    private int a;
    private au b;

    av(au au1, int i)
    {
        b = au1;
        a = i;
        super();
    }

    public final void onClick(View view)
    {
        b.a.b(a);
    }
}
