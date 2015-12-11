// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.offerup.android.activities.UserDetailActivity;
import com.offerup.android.dto.Notification;
import com.offerup.android.dto.Person;

// Referenced classes of package com.offerup.android.a:
//            a

final class b
    implements android.view.View.OnClickListener
{

    private Notification a;
    private a b;

    b(a a1, Notification notification)
    {
        b = a1;
        a = notification;
        super();
    }

    public final void onClick(View view)
    {
        if (a.getSender() != null && a.getSender().getId() > 0L)
        {
            view = new Intent(b.a, com/offerup/android/activities/UserDetailActivity);
            view.putExtra("userId", a.getSender().getId());
            b.a.startActivity(view);
        }
    }
}
