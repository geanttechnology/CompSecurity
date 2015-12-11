// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import org.json.JSONException;

// Referenced classes of package com.helpshift:
//            HSMessagesFragment, l, s

class a extends Handler
{

    final String a;
    final HSMessagesFragment b;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        try
        {
            HSMessagesFragment.k(b).a.f(a, HSMessagesFragment.k(b).B());
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            Log.d("HelpShiftDebug", "addMessageHandler", message);
        }
        HSMessagesFragment.a(b);
    }

    (HSMessagesFragment hsmessagesfragment, String s1)
    {
        b = hsmessagesfragment;
        a = s1;
        super();
    }
}
