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
        android.support.v7.widget.clerView.t t;
        for (Iterator iterator = a.b(a.this).iterator(); iterator.hasNext(); q(t))
        {
            t = (android.support.v7.widget.clerView.t)iterator.next();
        }

        a.b(a.this).clear();
    }

    .t()
    {
        this$0 = a.this;
        super();
    }
}
