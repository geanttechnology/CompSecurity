// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            f, q, n

static final class 
    implements Runnable
{

    final Activity a;

    public final void run()
    {
        a.runOnUiThread(new Runnable() {

            final f._cls2 a;

            public final void run()
            {
                for (int i = 0; i < q.X.size(); i++)
                {
                    n n1 = (n)q.X.get(i);
                    if (n1 == null || q.b() != n1.a || n1.p)
                    {
                        continue;
                    }
                    n1.u = false;
                    n1.invalidate();
                    if (n1.I != null)
                    {
                        n1.I.a = false;
                        n1.I.invalidate();
                    }
                }

            }

            
            {
                a = f._cls2.this;
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
