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

final class a extends k
{

    boolean a;

    static k a(a a1)
    {
        return a1.h;
    }

    public void a(j j1)
    {
        Observer observer = new Observer(j1) {

            final j a;
            final i._cls3 b;

            public void update(Observable observable, Object obj)
            {
                a.b(i._cls3.a(b));
            }

            
            {
                b = i._cls3.this;
                a = j1;
                super();
            }
        };
        if (a && !r.a(MagicApplication.getContext()))
        {
            j1.b(h);
        }
        a = false;
        h.a().a("USER_LOGGED_IN_EVENT", observer);
        h.a().a("USER_RE_LOGGED_IN_EVENT", observer);
    }

    _cls1.a()
    {
        a = true;
    }
}
