// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import com.target.mothership.model.h;
import com.target.mothership.services.x;
import com.target.ui.util.q;

// Referenced classes of package com.target.ui.fragment.product.dialog:
//            BaseProductDialogFragment

class this._cls0 extends h
{

    final BaseProductDialogFragment this$0;

    public void a(x x1)
    {
        q.a(BaseProductDialogFragment.TAG, "Unable to verify if guest has override store, defaulting to false");
        BaseProductDialogFragment.a(BaseProductDialogFragment.this, Boolean.valueOf(false));
        BaseProductDialogFragment.this.a(Boolean.valueOf(false));
    }

    public void a(Boolean boolean1)
    {
        BaseProductDialogFragment.a(BaseProductDialogFragment.this, boolean1);
        BaseProductDialogFragment.this.a(boolean1);
    }

    public volatile void a(Object obj)
    {
        a((Boolean)obj);
    }

    public void b(Object obj)
    {
        a((x)obj);
    }

    ()
    {
        this$0 = BaseProductDialogFragment.this;
        super();
    }
}
