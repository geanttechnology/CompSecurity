// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.b;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.offerup.android.d.d;
import com.offerup.android.tracker.a;
import com.offerup.android.utils.as;

// Referenced classes of package com.offerup.android.g.b:
//            z, ag

final class ab
    implements android.view.View.OnClickListener
{

    private Button a;
    private z b;

    ab(z z1, Button button)
    {
        b = z1;
        a = button;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("Signup_Signup-Button_click");
        as.a(b.getContext(), a);
        com.offerup.android.g.b.z.d(b).a(new ag(b, com.offerup.android.g.b.z.a(b).getText().toString(), z.b(b).getText().toString(), z.c(b).getText().toString()));
    }
}
