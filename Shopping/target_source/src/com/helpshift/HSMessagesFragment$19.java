// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.helpshift:
//            HSMessagesFragment, l, s

class a
    implements android.view.
{

    final HSMessagesFragment a;

    public void onClick(View view)
    {
        HSMessagesFragment.l(a).setText("");
        HSMessagesFragment.m(a).h("", HSMessagesFragment.k(a).B());
        HSMessagesFragment.a(a, Boolean.valueOf(true));
        HSMessagesFragment.b(a, false);
        HSMessagesFragment.c(a);
        if (HSMessagesFragment.n(a) != null)
        {
            HSMessagesFragment.n(a).a("User accepted the solution");
        }
    }

    (HSMessagesFragment hsmessagesfragment)
    {
        a = hsmessagesfragment;
        super();
    }
}
