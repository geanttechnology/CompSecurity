// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.b;

import com.smule.android.f.j;
import com.smule.android.f.k;
import com.smule.android.network.managers.a;
import com.smule.pianoandroid.e.f;
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
        if (!com.smule.android.network.managers.a.a().a("piandroid.notifications", "localNotificationsEnabled", true))
        {
            f.a().c();
        }
        a.b(com.smule.pianoandroid.magicpiano.b.a(b));
    }

    lication(lication lication, j j1)
    {
        b = lication;
        a = j1;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/b/i$4

/* anonymous class */
    final class i._cls4 extends k
    {

        static k a(i._cls4 _pcls4)
        {
            return _pcls4.h;
        }

        public void a(j j1)
        {
            com.smule.android.network.managers.a.a(MagicApplication.getContext()).a(new i._cls4._cls1(this, j1));
        }

    }

}
