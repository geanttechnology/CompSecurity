// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.j;

import com.target.mothership.util.o;
import java.util.TreeSet;

// Referenced classes of package com.target.ui.helper.j:
//            b

class this._cls0 extends TreeSet
{

    final b this$0;

    public boolean a(String s)
    {
        return !o.c(s) && super.add(s);
    }

    public boolean add(Object obj)
    {
        return a((String)obj);
    }

    o()
    {
        this$0 = b.this;
        super();
    }
}
