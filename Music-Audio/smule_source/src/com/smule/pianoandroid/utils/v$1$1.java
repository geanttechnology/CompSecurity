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

    final a a;

    public void run()
    {
        v.a(a.a, v.b(a.a), v.c(a.a)[2], false);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/utils/v$1

/* anonymous class */
    class v._cls1
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
            v._cls1._cls1 _lcls1 = new v._cls1._cls1(this);
            int i;
            if (v.d(a)[1] != 0)
            {
                i = v.d(a)[1];
            } else
            {
                i = 2000;
            }
            handler.postDelayed(_lcls1, i + 200);
            v.a(a, v.b(a), v.c(a)[1], false);
        }

            
            {
                a = v1;
                super();
            }
    }

}
