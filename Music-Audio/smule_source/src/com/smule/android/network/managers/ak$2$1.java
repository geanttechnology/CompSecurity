// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.f.j;
import com.smule.android.f.k;
import com.smule.android.network.core.b;

// Referenced classes of package com.smule.android.network.managers:
//            ak, am, al

class a
    implements Runnable
{

    final j a;
    final b b;

    public void run()
    {
        ak.a().a(com.smule.android.network.core.b.d().e(), b.b, b.b, b.b);
        a.b(a(b));
    }

    ( , j j1)
    {
        b = ;
        a = j1;
        super();
    }

    // Unreferenced inner class com/smule/android/network/managers/ak$2

/* anonymous class */
    class ak._cls2 extends k
    {

        final boolean a;
        final am b;
        final al c;
        final ak d;

        static k a(ak._cls2 _pcls2)
        {
            return _pcls2.h;
        }

        public void a(j j1)
        {
            (new Thread(new ak._cls2._cls1(this, j1))).start();
        }

            
            {
                d = ak1;
                a = flag;
                b = am;
                c = al;
                super();
            }
    }

}
