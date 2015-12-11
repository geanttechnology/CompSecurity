// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.a;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.target.ui.a:
//            a

class it>
    implements Runnable
{

    final a this$0;
    final ArrayList val$changes;

    public void run()
    {
        it> it>;
        for (Iterator iterator = val$changes.iterator(); iterator.hasNext(); a.a(a.this, it>))
        {
            it> = (this._cls0)iterator.next();
        }

        val$changes.clear();
        a.b(a.this).remove(val$changes);
    }

    ()
    {
        this$0 = final_a1;
        val$changes = ArrayList.this;
        super();
    }
}
