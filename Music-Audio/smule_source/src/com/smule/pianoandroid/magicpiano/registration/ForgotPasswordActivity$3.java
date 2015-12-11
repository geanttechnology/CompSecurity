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
    implements NetworkResponseCallback
{

    final Handler a;
    final ForgotPasswordActivity b;

    public void handleResponse(o o1)
    {
        Runnable runnable = new Runnable(o1) {

            final o a;
            final ForgotPasswordActivity._cls3 b;

            public void run()
            {
                ForgotPasswordActivity.a(b.b, a);
            }

            
            {
                b = ForgotPasswordActivity._cls3.this;
                a = o1;
                super();
            }
        };
        if (!o1.a())
        {
            a.post(runnable);
            return;
        } else
        {
            a.post(new Runnable(runnable) {

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
            });
            return;
        }
    }

    public volatile void handleResponse(Object obj)
    {
        handleResponse((o)obj);
    }

    _cls2.a(ForgotPasswordActivity forgotpasswordactivity, Handler handler)
    {
        b = forgotpasswordactivity;
        a = handler;
        super();
    }
}
