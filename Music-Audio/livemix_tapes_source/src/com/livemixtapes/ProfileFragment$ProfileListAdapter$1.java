// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.view.View;

// Referenced classes of package com.livemixtapes:
//            ProfileFragment

class val.position
    implements android.view.r._cls1
{

    final this._cls1 this$1;
    private final int val$position;

    public void onClick(View view)
    {
        if (val$position == 0)
        {
            cess._mth1(this._cls1.this).openSeeAllFragment(1);
            return;
        }
        if (val$position == 1)
        {
            cess._mth1(this._cls1.this).openSeeAllFragment(2);
            return;
        } else
        {
            cess._mth1(this._cls1.this).openSeeAllFragment(3);
            return;
        }
    }

    ()
    {
        this$1 = final_;
        val$position = I.this;
        super();
    }
}
