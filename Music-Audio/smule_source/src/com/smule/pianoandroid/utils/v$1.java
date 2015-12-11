// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.media.SoundPool;
import android.os.Handler;

// Referenced classes of package com.smule.pianoandroid.utils:
//            v

class a
    implements Runnable
{

    final v a;

    public void run()
    {
        if (v.a(a) != 0)
        {
            v.b(a).stop(v.a(a));
        }
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {

            final v._cls1 a;

            public void run()
            {
                v.a(a.a, v.b(a.a), v.c(a.a)[2], false);
            }

            
            {
                a = v._cls1.this;
                super();
            }
        };
        int i;
        if (v.d(a)[1] != 0)
        {
            i = v.d(a)[1];
        } else
        {
            i = 2000;
        }
        handler.postDelayed(runnable, i + 200);
        v.a(a, v.b(a), v.c(a)[1], false);
    }

    _cls1.a(v v1)
    {
        a = v1;
        super();
    }
}
