// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.widget.Toast;

// Referenced classes of package com.flurry.sdk:
//            iy, kn, kg, js

class it>
    implements it>
{

    final String a;
    final String b;
    final iy c;

    public volatile void a(kn kn1, Object obj)
    {
        a(kn1, (Void)obj);
    }

    public void a(kn kn1, Void void1)
    {
        int i = kn1.h();
        if (i > 0)
        {
            kg.e(iy.c(), "Analytics report sent.");
            kg.a(3, iy.c(), (new StringBuilder()).append("FlurryDataSender: report ").append(a).append(" sent. HTTP response: ").append(i).toString());
            if (kg.c() <= 3 && kg.d())
            {
                js.a().a(new Runnable(i) {

                    final int a;
                    final iy._cls1 b;

                    public void run()
                    {
                        Toast.makeText(js.a().c(), (new StringBuilder()).append("SD HTTP Response Code: ").append(a).toString(), 0).show();
                    }

            
            {
                b = iy._cls1.this;
                a = i;
                super();
            }
                });
            }
            c.a(a, b, i);
            iy.a(c);
            return;
        } else
        {
            iy.a(c, a, b);
            return;
        }
    }

    it>(iy iy1, String s, String s1)
    {
        c = iy1;
        a = s;
        b = s1;
        super();
    }
}
