// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import org.json.JSONException;

// Referenced classes of package com.helpshift:
//            HSMessagesFragment, l

class a
    implements Runnable
{

    final HSMessagesFragment a;

    public void run()
    {
        Looper.prepare();
        HSMessagesFragment.a(a, new Handler() {

            final HSMessagesFragment._cls18 a;

            public void handleMessage(Message message)
            {
                Message message1 = HSMessagesFragment.h(a.a).obtainMessage();
                message1.obj = message.obj;
                HSMessagesFragment.h(a.a).sendMessage(message1);
            }

            
            {
                a = HSMessagesFragment._cls18.this;
                super();
            }
        });
        (new Runnable() {

            final HSMessagesFragment._cls18 a;

            public void run()
            {
                try
                {
                    HSMessagesFragment.k(a.a).a(HSMessagesFragment.f(a.a), HSMessagesFragment.i(a.a), HSMessagesFragment.j(a.a));
                }
                catch (JSONException jsonexception)
                {
                    Log.d("HelpShiftDebug", "get issues", jsonexception);
                }
                HSMessagesFragment.f(a.a).postDelayed(this, 3000L);
            }

            
            {
                a = HSMessagesFragment._cls18.this;
                super();
            }
        }).run();
        Looper.loop();
    }

    _cls2.a(HSMessagesFragment hsmessagesfragment)
    {
        a = hsmessagesfragment;
        super();
    }
}
