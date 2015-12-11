// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;


// Referenced classes of package com.target.ui.view.list:
//            ListDetailView

class this._cls0
    implements nsView.a
{

    final ListDetailView this$0;

    public void a(String s)
    {
        ListDetailView.a(ListDetailView.this, s);
    }

    public void a(boolean flag)
    {
        ListDetailView listdetailview = ListDetailView.this;
        this._cls0 _lcls0;
        if (flag)
        {
            _lcls0 = FADE_OUT;
        } else
        {
            _lcls0 = FADE_IN;
        }
        ListDetailView.a(listdetailview, _lcls0);
    }

    nsView.a()
    {
        this$0 = ListDetailView.this;
        super();
    }
}
