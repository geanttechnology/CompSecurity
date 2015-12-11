// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.vlc;

import com.target.ui.analytics.a.r;
import java.util.List;

// Referenced classes of package com.target.ui.vlc:
//            b

class >
    implements Runnable
{

    final b this$0;

    public void run()
    {
        if (b.a(b.this).size() > 0)
        {
            r.a(b.a(b.this)).e();
            b.a(b.this).clear();
        }
        if (b.b(b.this))
        {
            return;
        } else
        {
            b.c(b.this);
            return;
        }
    }

    s.a.r()
    {
        this$0 = b.this;
        super();
    }
}
