// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.widget.Toast;

// Referenced classes of package com.flurry.sdk:
//            da, ei, el, dl

class it>
    implements it>
{

    final String a;
    final String b;
    final da c;

    public volatile void a(ei ei1, Object obj)
    {
        a(ei1, (Void)obj);
    }

    public void a(ei ei1, Void void1)
    {
        int i = ei1.e();
        if (i > 0)
        {
            el.d(da.b(), (new StringBuilder()).append("FlurryDataSender: report ").append(a).append(" sent. HTTP response: ").append(i).toString());
            if (el.c() <= 3 && el.d())
            {
                dl.a().a(new Runnable(i) {

                    final int a;
                    final da._cls1 b;

                    public void run()
                    {
                        Toast.makeText(dl.a().b(), (new StringBuilder()).append("SD HTTP Response Code: ").append(a).toString(), 0).show();
                    }

            
            {
                b = da._cls1.this;
                a = i;
                super();
            }
                });
            }
            c.a(a, b, i);
            c.d();
            return;
        } else
        {
            c.b(a, b);
            return;
        }
    }

    it>(da da1, String s, String s1)
    {
        c = da1;
        a = s;
        b = s1;
        super();
    }
}
