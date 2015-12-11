// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.helpshift:
//            HSMessagesFragment, v

class a
    implements android.view.
{

    final HSMessagesFragment a;

    public void onClick(View view)
    {
        v.a("message-filing");
        HSMessagesFragment.a(a);
        HSMessagesFragment.b(a, true);
        HSMessagesFragment.o(a);
        if (HSMessagesFragment.l(a).getText().toString().trim().length() == 0)
        {
            HSMessagesFragment.a(a, HSMessagesFragment.l(a));
        }
        HSMessagesFragment.a(a, Boolean.valueOf(false));
        if (HSMessagesFragment.n(a) != null)
        {
            HSMessagesFragment.n(a).a("User rejected the solution");
        }
    }

    (HSMessagesFragment hsmessagesfragment)
    {
        a = hsmessagesfragment;
        super();
    }
}
