// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.b;

import android.app.Activity;
import com.tencent.open.utils.i;
import com.tencent.tauth.b;

// Referenced classes of package com.tencent.connect.b:
//            a, e

class b
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
            com.tencent.connect.b.a.e(c).runOnUiThread(new Runnable() {

                final a._cls1 a;

                public void run()
                {
                    e e1 = new e(com.tencent.connect.b.a.e(a.c), "action_login", a.a, a.b, com.tencent.connect.b.a.f(a.c));
                    if (com.tencent.connect.b.a.e(a.c) != null && !com.tencent.connect.b.a.e(a.c).isFinishing())
                    {
                        e1.show();
                    }
                }

            
            {
                a = a._cls1.this;
                super();
            }
            });
        }
    }

    _cls1.a(a a1, String s, b b1)
    {
        c = a1;
        a = s;
        b = b1;
        super();
    }
}
