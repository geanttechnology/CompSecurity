// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            q, ak, ad, af

final class 
    implements Runnable
{

    final Activity a;

    public void run()
    {
        a.runOnUiThread(new Runnable() {

            final q._cls2 a;

            public void run()
            {
                for (int i = 0; i < ak.X.size(); i++)
                {
                    ad ad1 = (ad)ak.X.get(i);
                    if (ad1 == null || ak.b() != ad1.a || ad1.p)
                    {
                        continue;
                    }
                    ad1.u = false;
                    ad1.invalidate();
                    if (ad1.J != null)
                    {
                        ad1.J.a = false;
                        ad1.J.invalidate();
                    }
                }

            }

            
            {
                a = q._cls2.this;
                super();
            }
        });
    }

    (Activity activity)
    {
        a = activity;
        super();
    }
}
