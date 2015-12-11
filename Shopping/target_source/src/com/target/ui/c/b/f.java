// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.c.b;

import android.view.Menu;
import android.view.MenuInflater;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingBase;
import com.target.ui.g.a;
import com.target.ui.helper.product.d;

// Referenced classes of package com.target.ui.c.b:
//            c, a

public class f
    implements com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.c, com.target.ui.g.a
{
    public class a
        implements com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.b
    {

        final f this$0;

        public void a()
        {
            if (com.target.ui.c.b.f.a(f.this) == null)
            {
                return;
            } else
            {
                f.this.c();
                return;
            }
        }

        public void a(ListSummary listsummary)
        {
            if (com.target.ui.c.b.f.a(f.this) == null)
            {
                return;
            } else
            {
                f.this.a(listsummary);
                return;
            }
        }

        public void b()
        {
            com.target.ui.c.b.f.a(f.this).a(false);
        }

        public a()
        {
            this$0 = f.this;
            super();
        }
    }

    public class b
        implements com.target.ui.helper.product.d.b
    {

        final f this$0;

        public void a()
        {
            if (com.target.ui.c.b.f.a(f.this) == null)
            {
                return;
            } else
            {
                c();
                return;
            }
        }

        public void a(ListSummary listsummary)
        {
            if (com.target.ui.c.b.f.a(f.this) == null)
            {
                return;
            } else
            {
                f.this.a(listsummary);
                return;
            }
        }

        public b()
        {
            this$0 = f.this;
            super();
        }
    }


    private com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.b mAddToListDialogListener;
    private d mAddToSingleListHelper;
    private c mPresentation;
    private boolean mSingleListMode;

    public f(d d1, boolean flag)
    {
        mAddToListDialogListener = new a();
        mSingleListMode = flag;
        if (mSingleListMode && d1 == null)
        {
            throw new IllegalStateException("Single list helper is required when in single list mode");
        }
        mAddToSingleListHelper = d1;
        if (mAddToSingleListHelper != null)
        {
            mAddToSingleListHelper.a(new b());
            mAddToSingleListHelper.a(new b());
        }
    }

    static c a(f f1)
    {
        return f1.mPresentation;
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
    }

    protected void a(ListSummary listsummary)
    {
        mPresentation.a(0x7f09046d, listsummary);
    }

    public void a(Product product)
    {
        mPresentation.a(true);
        if (mSingleListMode)
        {
            mAddToSingleListHelper.a(product);
            return;
        } else
        {
            mPresentation.a(new com.target.ui.c.b.a(product));
            return;
        }
    }

    public void a(WeeklyAdListingBase weeklyadlistingbase)
    {
        mPresentation.a(true);
        weeklyadlistingbase = new com.target.ui.c.b.a(weeklyadlistingbase);
        if (mSingleListMode)
        {
            if (weeklyadlistingbase.b() != null)
            {
                mAddToSingleListHelper.a(weeklyadlistingbase.b());
                return;
            } else
            {
                mAddToSingleListHelper.a(weeklyadlistingbase.a());
                return;
            }
        } else
        {
            mPresentation.a(weeklyadlistingbase);
            return;
        }
    }

    public void a(c c1)
    {
        mPresentation = c1;
    }

    public volatile void a(Object obj)
    {
        a((c)obj);
    }

    protected void c()
    {
        mPresentation.a(0x7f09046c);
    }

    public com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.b s_()
    {
        return mAddToListDialogListener;
    }

    public void v_()
    {
        mAddToSingleListHelper = null;
    }

    public void z_()
    {
        mPresentation = null;
    }
}
