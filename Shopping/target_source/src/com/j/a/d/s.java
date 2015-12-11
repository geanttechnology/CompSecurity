// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.os.Handler;
import android.widget.TextView;

// Referenced classes of package com.j.a.d:
//            r, p, ag

class s
    implements Runnable
{

    final r a;

    s(r r1)
    {
        a = r1;
        super();
    }

    public void run()
    {
        if (ag.j(a.f.a))
        {
            if (a.a.getText().length() > 5)
            {
                a.a.setText("");
            }
            a.a.append(".");
            a.b.postDelayed(this, 100L);
        }
    }
}
