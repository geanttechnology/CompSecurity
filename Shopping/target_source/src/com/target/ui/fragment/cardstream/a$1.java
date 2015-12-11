// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.target.ui.fragment.cardstream:
//            a

class this._cls0
    implements Runnable
{

    final a this$0;

    public void run()
    {
        .t t;
        for (Iterator iterator = a.a(a.this).iterator(); iterator.hasNext(); b(t.holder, t.fromX, t.fromY, t.toX, t.toY))
        {
            t = (toY)iterator.next();
        }

        a.a(a.this).clear();
    }

    ()
    {
        this$0 = a.this;
        super();
    }
}
