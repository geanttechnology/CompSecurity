// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.b;

import android.text.style.ClickableSpan;
import android.view.View;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.g.b:
//            k

final class s extends ClickableSpan
{

    private k a;

    s(k k1)
    {
        a = k1;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("SignupLogin_Privacy-Button_click");
        k.d(a).g();
    }
}
