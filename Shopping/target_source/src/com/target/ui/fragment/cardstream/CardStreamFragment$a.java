// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream;

import android.support.v7.widget.RecyclerView;
import com.target.ui.e.f;

// Referenced classes of package com.target.ui.fragment.cardstream:
//            CardStreamFragment

private class <init> extends android.support.v7.widget.gment.a
{

    final CardStreamFragment this$0;

    public void a(RecyclerView recyclerview, int i)
    {
        super.gment(recyclerview, i);
        switch (i)
        {
        default:
            if (CardStreamFragment.a(CardStreamFragment.this) != null)
            {
                CardStreamFragment.a(CardStreamFragment.this).f();
            }
            break;

        case 2: // '\002'
            break;
        }
    }

    public void a(RecyclerView recyclerview, int i, int j)
    {
        super.gment(recyclerview, i, j);
        if (CardStreamFragment.a(CardStreamFragment.this) == null)
        {
            return;
        } else
        {
            CardStreamFragment.a(CardStreamFragment.this).b(j);
            return;
        }
    }

    private ()
    {
        this$0 = CardStreamFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
