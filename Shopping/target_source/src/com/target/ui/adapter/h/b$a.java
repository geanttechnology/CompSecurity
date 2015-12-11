// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.h;

import android.view.View;
import com.target.ui.view.shop.ShopDvmView;

// Referenced classes of package com.target.ui.adapter.h:
//            b

private class <init>
    implements android.view..OnClickListener
{

    final b this$0;

    public void onClick(View view)
    {
        if (view == null || b.a(b.this) == null)
        {
            return;
        } else
        {
            b.a(b.this).a((ShopDvmView)view);
            return;
        }
    }

    private DvmView()
    {
        this$0 = b.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
