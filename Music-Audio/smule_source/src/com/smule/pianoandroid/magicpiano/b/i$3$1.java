// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.b;

import com.smule.android.f.h;
import com.smule.android.f.j;
import com.smule.android.f.k;
import com.smule.android.network.core.r;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano.b:
//            i

class a
    implements Observer
{

    final j a;
    final b b;

    public void update(Observable observable, Object obj)
    {
        a.b(a(b));
    }

    lication(lication lication, j j1)
    {
        b = lication;
        a = j1;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/b/i$3

/* anonymous class */
    final class i._cls3 extends k
    {

        boolean a;

        static k a(i._cls3 _pcls3)
        {
            return _pcls3.h;
        }

        public void a(j j1)
        {
            i._cls3._cls1 _lcls1 = new i._cls3._cls1(this, j1);
            if (a && !r.a(MagicApplication.getContext()))
            {
                j1.b(h);
            }
            a = false;
            h.a().a("USER_LOGGED_IN_EVENT", _lcls1);
            h.a().a("USER_RE_LOGGED_IN_EVENT", _lcls1);
        }

            
            {
                a = true;
            }
    }

}
