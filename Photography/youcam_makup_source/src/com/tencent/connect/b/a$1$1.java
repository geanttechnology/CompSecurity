// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.b;

import android.app.Activity;
import com.tencent.open.utils.i;
import com.tencent.tauth.b;

// Referenced classes of package com.tencent.connect.b:
//            e, a

class a
    implements Runnable
{

    final  a;

    public void run()
    {
        e e1 = new e(com.tencent.connect.b.a.e(a.a), "action_login", a.a, a.a, com.tencent.connect.b.a.f(a.a));
        if (com.tencent.connect.b.a.e(a.a) != null && !com.tencent.connect.b.a.e(a.a).isFinishing())
        {
            e1.show();
        }
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/tencent/connect/b/a$1

/* anonymous class */
    class a._cls1
        implements Runnable
    {

        final String a;
        final b b;
        final a c;

        public void run()
        {
            i.a("libwbsafeedit", "libwbsafeedit.so", 2);
            if (com.tencent.connect.b.a.e(c) != null)
            {
                com.tencent.connect.b.a.e(c).runOnUiThread(new a._cls1._cls1(this));
            }
        }

            
            {
                c = a1;
                a = s;
                b = b1;
                super();
            }
    }

}
