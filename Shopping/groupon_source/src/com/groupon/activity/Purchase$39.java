// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;

// Referenced classes of package com.groupon.activity:
//            Purchase

class this._cls0
    implements android.view.Listener
{

    final Purchase this$0;

    public void onClick(View view)
    {
        startActivityForResult(Purchase.access$2800(Purchase.this, null, userAddress, true), 10120);
    }

    ()
    {
        this$0 = Purchase.this;
        super();
    }
}
