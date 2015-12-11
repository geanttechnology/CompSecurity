// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.os.Handler;
import com.smule.android.network.core.NetworkResponseCallback;
import com.smule.android.network.core.o;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            ForgotPasswordActivity, b

class a
    implements Runnable
{

    final o a;
    final a b;

    public void run()
    {
        ForgotPasswordActivity.a(b.b, a);
    }

    a(a a1, o o)
    {
        b = a1;
        a = o;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/registration/ForgotPasswordActivity$3

/* anonymous class */
    class ForgotPasswordActivity._cls3
        implements NetworkResponseCallback
    {

        final Handler a;
        final ForgotPasswordActivity b;

        public void handleResponse(o o1)
        {
            ForgotPasswordActivity._cls3._cls1 _lcls1 = new ForgotPasswordActivity._cls3._cls1(this, o1);
            if (!o1.a())
            {
                a.post(_lcls1);
                return;
            } else
            {
                a.post(new ForgotPasswordActivity._cls3._cls2(_lcls1));
                return;
            }
        }

        public volatile void handleResponse(Object obj)
        {
            handleResponse((o)obj);
        }

            
            {
                b = forgotpasswordactivity;
                a = handler;
                super();
            }

        // Unreferenced inner class com/smule/pianoandroid/magicpiano/registration/ForgotPasswordActivity$3$2

/* anonymous class */
        class ForgotPasswordActivity._cls3._cls2
            implements Runnable
        {

            final Runnable a;
            final ForgotPasswordActivity._cls3 b;

            public void run()
            {
                b.b.b.b(b.b.getString(0x7f0c00e9));
                b.a.postDelayed(a, 2000L);
            }

                    
                    {
                        b = ForgotPasswordActivity._cls3.this;
                        a = runnable;
                        super();
                    }
        }

    }

}
