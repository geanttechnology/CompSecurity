// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import java.util.TimerTask;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            StartupActivity

class a extends TimerTask
{

    final StartupActivity a;

    public void run()
    {
        a.runOnUiThread(new Runnable() {

            final StartupActivity._cls2 a;

            public void run()
            {
label0:
                {
                    if (!StartupActivity.b(a.a))
                    {
                        if (!StartupActivity.c(a.a))
                        {
                            break label0;
                        }
                        StartupActivity.d(a.a);
                    }
                    return;
                }
                StartupActivity.a(a.a, true);
            }

            
            {
                a = StartupActivity._cls2.this;
                super();
            }
        });
    }

    _cls1.a(StartupActivity startupactivity)
    {
        a = startupactivity;
        super();
    }
}
