// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.b;

import com.smule.android.f.j;
import com.smule.android.f.k;
import com.smule.android.network.managers.ak;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.magicpiano.b:
//            i

class a
    implements Runnable
{

    final j a;
    final b b;

    public void run()
    {
        if (ak.a().e().size() <= 0)
        {
            ak.a().c();
        }
        a.b(a(b));
    }

    ( , j j1)
    {
        b = ;
        a = j1;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/b/i$15

/* anonymous class */
    final class i._cls15 extends k
    {

        static k a(i._cls15 _pcls15)
        {
            return _pcls15.h;
        }

        public void a(j j1)
        {
            ak.a().a(new i._cls15._cls1(this, j1));
        }

    }

}
