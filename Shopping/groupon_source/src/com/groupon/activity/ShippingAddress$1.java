// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.groupon.activity:
//            ShippingAddress

class this._cls0
    implements android.view.er
{

    final ShippingAddress this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        view.requestFocusFromTouch();
        return false;
    }

    ()
    {
        this$0 = ShippingAddress.this;
        super();
    }
}
