// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import android.widget.ListView;
import com.helpshift.f.a;
import org.json.JSONArray;

// Referenced classes of package com.helpshift:
//            HSMessagesFragment

class a extends Handler
{

    final HSMessagesFragment a;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        if (((JSONArray)message.obj).length() > 0)
        {
            com.helpshift.HSMessagesFragment.a(a, com.helpshift.f.a.d(HSMessagesFragment.b(a)));
            com.helpshift.HSMessagesFragment.a(a);
            HSMessagesFragment.c(a);
            HSMessagesFragment.e(a).setSelection(HSMessagesFragment.d(a).getCount() - 1);
        }
    }

    (HSMessagesFragment hsmessagesfragment)
    {
        a = hsmessagesfragment;
        super();
    }
}
