// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.a;

import android.view.View;
import com.offerup.android.activities.a;
import com.offerup.android.dto.Message;
import com.offerup.android.dto.Person;

// Referenced classes of package com.offerup.android.a:
//            i

final class j
    implements android.view.View.OnClickListener
{

    private Message a;
    private i b;

    j(i k, Message message)
    {
        b = k;
        a = message;
        super();
    }

    public final void onClick(View view)
    {
        b.b.a(a.getSender().getId());
    }
}
