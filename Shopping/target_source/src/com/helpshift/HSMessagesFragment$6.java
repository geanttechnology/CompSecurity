// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import com.helpshift.f.c;
import com.helpshift.k.a;
import java.util.ArrayList;

// Referenced classes of package com.helpshift:
//            HSMessagesFragment

class a extends Handler
{

    final int a;
    final HSMessagesFragment b;

    public void handleMessage(Message message)
    {
        a a1 = (a)HSMessagesFragment.s(b).get(a);
        a1.i = Boolean.valueOf(false);
        a1.j = Boolean.valueOf(true);
        a1.k = Boolean.valueOf(false);
        HSMessagesFragment.d(b).notifyDataSetChanged();
        c.a(a1.g, true);
        c.b(a1.g, false);
        com.helpshift.HSMessagesFragment.a(b, message);
    }

    (HSMessagesFragment hsmessagesfragment, int i)
    {
        b = hsmessagesfragment;
        a = i;
        super();
    }
}
