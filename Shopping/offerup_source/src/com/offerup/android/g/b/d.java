// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.b;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.offerup.android.tracker.a;
import com.offerup.android.utils.as;

// Referenced classes of package com.offerup.android.g.b:
//            a, j

final class d
    implements android.view.View.OnClickListener
{

    private Button a;
    private com.offerup.android.g.b.a b;

    d(com.offerup.android.g.b.a a1, Button button)
    {
        b = a1;
        a = button;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("Login_Login-Button_click");
        as.a(b.getContext(), a);
        com.offerup.android.g.b.a.c(b).a(new j(b, com.offerup.android.g.b.a.a(b).getText().toString(), com.offerup.android.g.b.a.b(b).getText().toString()));
    }
}
