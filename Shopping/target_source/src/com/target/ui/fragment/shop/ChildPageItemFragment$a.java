// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop;

import com.target.mothership.model.page_item.interfaces.PageItem;
import com.target.ui.f.c;
import com.target.ui.util.ai;
import com.target.ui.util.y;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.shop:
//            ChildPageItemFragment

private class <init>
    implements com.target.ui.view.agment.a
{

    final ChildPageItemFragment this$0;

    public void a(int i)
    {
        Object obj = (PageItem)ChildPageItemFragment.a(ChildPageItemFragment.this).get(i);
        if (y.a(ChildPageItemFragment.b(ChildPageItemFragment.this), ((PageItem) (obj))))
        {
            return;
        }
        obj = y.a(((PageItem) (obj)), q(), ChildPageItemFragment.a(ChildPageItemFragment.this), p());
        if (obj == null)
        {
            ai.a(getActivity(), "Unable to navigate to category");
            return;
        } else
        {
            m().d(((android.support.v4.app.Fragment) (obj)));
            return;
        }
    }

    private eItem()
    {
        this$0 = ChildPageItemFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
