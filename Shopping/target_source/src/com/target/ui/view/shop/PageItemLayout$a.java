// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.shop;

import android.support.v7.widget.RecyclerView;
import com.h.c.u;
import com.target.ui.e.f;

// Referenced classes of package com.target.ui.view.shop:
//            PageItemLayout, PageItemView

private class <init> extends android.support.v7.widget.nit>
{

    final u picasso;
    final PageItemLayout this$0;

    public void a(RecyclerView recyclerview, int i)
    {
        super.nit>(recyclerview, i);
        switch (i)
        {
        default:
            picasso.b(PageItemView.IMAGE_LOADING_TAG);
            if (PageItemLayout.a(PageItemLayout.this) != null)
            {
                PageItemLayout.a(PageItemLayout.this).f();
            }
            return;

        case 2: // '\002'
            picasso.a(PageItemView.IMAGE_LOADING_TAG);
            return;
        }
    }

    public void a(RecyclerView recyclerview, int i, int j)
    {
        super.LOADING_TAG(recyclerview, i, j);
        if (PageItemLayout.a(PageItemLayout.this) == null)
        {
            return;
        } else
        {
            PageItemLayout.a(PageItemLayout.this).b(j);
            return;
        }
    }

    private ()
    {
        this$0 = PageItemLayout.this;
        super();
        picasso = u.a(getContext());
    }

    tContext(tContext tcontext)
    {
        this();
    }
}
