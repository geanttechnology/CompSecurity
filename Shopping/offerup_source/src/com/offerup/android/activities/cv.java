// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.activities:
//            MyAccountActivity

final class cv
    implements android.view.View.OnClickListener
{

    private MyAccountActivity a;

    cv(MyAccountActivity myaccountactivity)
    {
        a = myaccountactivity;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("MyAccount_Logout-Button_click");
        com.offerup.android.activities.MyAccountActivity.a(a);
    }
}
