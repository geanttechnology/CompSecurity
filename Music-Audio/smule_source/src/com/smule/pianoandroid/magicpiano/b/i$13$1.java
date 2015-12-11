// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.b;

import com.smule.android.f.j;
import com.smule.android.f.k;
import com.smule.android.network.core.r;
import com.smule.pianoandroid.magicpiano.MagicApplication;

// Referenced classes of package com.smule.pianoandroid.magicpiano.b:
//            i

class a
    implements Runnable
{

    final j a;
    final b b;

    public void run()
    {
        a.b(a(b));
    }

    ication(ication ication, j j1)
    {
        b = ication;
        a = j1;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/b/i$13

/* anonymous class */
    final class i._cls13 extends k
    {

        boolean a;

        static k a(i._cls13 _pcls13)
        {
            return _pcls13.h;
        }

        public void a(j j1)
        {
            if (!r.a(MagicApplication.getContext()) && a)
            {
                j1.b(h);
            }
            a = false;
            r.b(MagicApplication.getContext(), new i._cls13._cls1(this, j1));
        }

            
            {
                a = true;
            }
    }

}
