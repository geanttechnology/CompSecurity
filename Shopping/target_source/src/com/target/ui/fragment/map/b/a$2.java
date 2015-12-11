// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.map.b;

import com.google.a.a.e;
import com.target.ui.model.MapDisplayableItem;

// Referenced classes of package com.target.ui.fragment.map.b:
//            a

class this._cls0
    implements Runnable
{

    final a this$0;

    public void run()
    {
        Object obj = a.a(a.this, com.target.ui.fragment.map.b.a.e(a.this));
        if (((e) (obj)).b())
        {
            obj = (MapDisplayableItem)((e) (obj)).c();
            a.a(a.this, ((MapDisplayableItem) (obj)));
        }
    }

    eItem()
    {
        this$0 = a.this;
        super();
    }
}
