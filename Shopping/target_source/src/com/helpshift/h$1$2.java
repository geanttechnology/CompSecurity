// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import org.json.JSONException;

// Referenced classes of package com.helpshift:
//            h, l, x

class it>
    implements Runnable
{

    final ostDelayed a;

    public void run()
    {
        try
        {
            h.a(a.a).c(h.b(a.a), new Handler());
        }
        catch (JSONException jsonexception)
        {
            x.b("HelpShiftDebug", "get issues", jsonexception);
        }
        h.b(a.a).postDelayed(this, 3000L);
    }

    it>(it> it>)
    {
        a = it>;
        super();
    }

    // Unreferenced inner class com/helpshift/h$1

/* anonymous class */
    class h._cls1
        implements Runnable
    {

        final h a;

        public void run()
        {
            Looper.prepare();
            h.a(a, new h._cls1._cls1());
            (new h._cls1._cls2(this)).run();
            Looper.loop();
        }

            
            {
                a = h1;
                super();
            }

        // Unreferenced inner class com/helpshift/h$1$1

/* anonymous class */
        class h._cls1._cls1 extends Handler
        {

            final h._cls1 a;

            public void handleMessage(Message message)
            {
                a.a.runOnUiThread(new h._cls1._cls1._cls1(this));
            }

                    
                    {
                        a = h._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/helpshift/h$1$1$1

/* anonymous class */
        class h._cls1._cls1._cls1
            implements Runnable
        {

            final h._cls1._cls1 a;

            public void run()
            {
                h.a(a.a.a, h.a(a.a.a).B());
            }

                    
                    {
                        a = _pcls1;
                        super();
                    }
        }

    }

}
