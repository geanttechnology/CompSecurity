// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.product;

import com.google.a.a.e;
import com.target.mothership.model.list.interfaces.ListItem;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.model.product.interfaces.Product;
import com.target.ui.helper.j.b;
import com.target.ui.model.list.ListCollectionItem;
import com.target.ui.service.m;
import com.target.ui.util.q;

public class d
{
    private class a
        implements com.target.ui.helper.j.b.d
    {

        final d this$0;

        public void a(ListItem listitem, int i, ListSummary listsummary)
        {
        }

        public void a(ListItem listitem, ListSummary listsummary)
        {
            if (d.a(d.this) == null)
            {
                return;
            } else
            {
                d.a(d.this).a(listsummary);
                return;
            }
        }

        public void a(com.target.ui.helper.j.b.n n, String s)
        {
            if (d.a(d.this) == null)
            {
                return;
            } else
            {
                d.a(d.this).a();
                return;
            }
        }

        private a()
        {
            this$0 = d.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void a();

        public abstract void a(ListSummary listsummary);
    }


    public static final String TAG = com/target/ui/helper/product/d.getSimpleName();
    private com.target.ui.helper.j.b mHelper;
    private b mListener;

    public d()
    {
        a();
    }

    static b a(d d1)
    {
        return d1.mListener;
    }

    private boolean a()
    {
        if (mHelper != null)
        {
            return true;
        }
        if (!m.a().b().b())
        {
            return false;
        } else
        {
            mHelper = new com.target.ui.helper.j.b(((ListCollectionItem)m.a().b().c()).d());
            return true;
        }
    }

    public void a(Product product)
    {
        if (!a())
        {
            q.a(TAG, "Unable to add a specific item to list due to no default list");
            return;
        } else
        {
            mHelper.a(product, new a());
            return;
        }
    }

    public void a(b b1)
    {
        mListener = b1;
    }

    public void a(String s)
    {
        if (!a())
        {
            q.a(TAG, "Unable to add a generic item to list due to no default list");
            return;
        } else
        {
            mHelper.a(s, new a());
            return;
        }
    }

}
