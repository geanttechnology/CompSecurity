// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.common;


// Referenced classes of package com.target.ui.fragment.common:
//            TabbedFragment

class this._cls0
    implements android.support.v4.view.ent._cls2
{

    final TabbedFragment this$0;

    public void a(int i)
    {
        if (TabbedFragment.a(TabbedFragment.this) == null)
        {
            return;
        } else
        {
            TabbedFragment.this.a(i);
            TabbedFragment.b(TabbedFragment.this);
            return;
        }
    }

    public void a(int i, float f, int j)
    {
    }

    public void b(int i)
    {
        boolean flag = true;
        if (i == 1)
        {
            h();
        }
        TabbedFragment tabbedfragment = TabbedFragment.this;
        if (i != 0)
        {
            flag = false;
        }
        TabbedFragment.b(tabbedfragment, flag);
    }

    ()
    {
        this$0 = TabbedFragment.this;
        super();
    }
}
