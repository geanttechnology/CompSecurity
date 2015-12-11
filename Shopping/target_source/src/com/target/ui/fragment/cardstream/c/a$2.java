// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.c;

import com.target.a.a.b;

// Referenced classes of package com.target.ui.fragment.cardstream.c:
//            a

class this._cls0
    implements Runnable
{

    final a this$0;

    public void run()
    {
        b.d("DataSource", (new StringBuilder()).append(a.a(a.this)).append(": doLoadData()").toString());
        a.this.a(a.d(a.this));
        b.d("DataSource", (new StringBuilder()).append(a.a(a.this)).append(": end doLoadData()").toString());
    }

    ()
    {
        this$0 = a.this;
        super();
    }
}
