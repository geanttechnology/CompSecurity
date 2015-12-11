// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.f;

import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.android.f:
//            h, j, k

class a
    implements Observer
{

    final j a;
    final b b;

    public void update(Observable observable, Object obj)
    {
        if (b.b)
        {
            h.a().b(b.b, this);
        }
        a.b(b.b);
    }

    t>(t> t>, j j1)
    {
        b = t>;
        a = j1;
        super();
    }

    // Unreferenced inner class com/smule/android/f/j$1

/* anonymous class */
    class j._cls1 extends k
    {

        final boolean a;
        final String b;
        final j c;

        public void a(j j1)
        {
            j1 = new j._cls1._cls1(this, j1);
            h.a().a(b, j1);
        }

            
            {
                c = j1;
                a = flag;
                b = s;
                super();
            }
    }

}
