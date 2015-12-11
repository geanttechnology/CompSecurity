// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.target.mothership.common.params.c;
import com.target.mothership.model.bazaar_voice.interfaces.ProductReviewWrapper;
import com.target.mothership.model.product.interfaces.Product;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.helper.n.a;
import com.target.ui.util.al;
import com.target.ui.util.q;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.product.common:
//            a

public abstract class BaseProductReviewFragment extends BaseNavigationFragment
    implements com.target.ui.fragment.product.common.a, com.target.ui.helper.n.a.a
{
    private class a
    {

        final View content;
        final View errorContainer;
        final View loader;
        final BaseProductReviewFragment this$0;

        a(View view)
        {
            this$0 = BaseProductReviewFragment.this;
            super();
            content = view.findViewById(r());
            loader = view.findViewById(s());
            errorContainer = view.findViewById(t());
        }
    }


    private static final int DEFAULT_PAGE_NUMBER = 0;
    private static final int DEFAULT_PAGE_VALUE = -1;
    private static final int PAGE_SIZE = 10;
    public static final String TAG = com/target/ui/fragment/product/common/BaseProductReviewFragment.getSimpleName();
    private int mCurrentPageNumber;
    private int mPageSize;
    private com.target.ui.helper.n.a mProductReviewHelper;
    private int mTotalPageCount;
    private int mTotalRecordCount;
    private a mViews;

    public BaseProductReviewFragment()
    {
    }

    private c a(int i1)
    {
        return new c(a().k_(), 10, i1);
    }

    protected abstract Product a();

    public void a(ProductReviewWrapper productreviewwrapper)
    {
        if (mViews == null || productreviewwrapper == null)
        {
            return;
        }
        mPageSize = productreviewwrapper.c();
        mCurrentPageNumber = productreviewwrapper.d();
        mTotalPageCount = productreviewwrapper.f();
        mTotalRecordCount = productreviewwrapper.e();
        if (d())
        {
            b(productreviewwrapper.b());
        }
        a(productreviewwrapper.a());
    }

    protected abstract void a(List list);

    protected abstract void b();

    protected abstract void b(List list);

    protected abstract void c();

    protected abstract boolean d();

    public void e()
    {
        if (mViews == null)
        {
            return;
        }
        if (mCurrentPageNumber == -1)
        {
            h();
            return;
        } else
        {
            b();
            q.a(TAG, (new StringBuilder()).append("Error loading the page : ").append(mCurrentPageNumber).toString());
            return;
        }
    }

    public void f()
    {
        if (mViews == null)
        {
            return;
        }
        if (mCurrentPageNumber == -1)
        {
            c();
            return;
        } else
        {
            b();
            q.a(TAG, (new StringBuilder()).append("Error loading the page : ").append(mCurrentPageNumber).toString());
            return;
        }
    }

    public void g()
    {
        al.a(mViews.loader, new View[] {
            mViews.errorContainer, mViews.content
        });
    }

    public void h()
    {
        al.a(mViews.errorContainer, new View[] {
            mViews.content, mViews.loader
        });
    }

    public void i()
    {
        al.a(mViews.content, new View[] {
            mViews.errorContainer, mViews.loader
        });
    }

    protected com.target.ui.helper.n.a j()
    {
        return mProductReviewHelper;
    }

    protected void k()
    {
        mProductReviewHelper.a(a(0));
    }

    protected void l()
    {
        mProductReviewHelper.a(a(mCurrentPageNumber + 1));
    }

    protected boolean n()
    {
        return mCurrentPageNumber <= mTotalPageCount;
    }

    protected int o()
    {
        return mPageSize;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mProductReviewHelper = new com.target.ui.helper.n.a(this);
        mCurrentPageNumber = -1;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(q(), viewgroup, false);
        mViews = new a(layoutinflater);
        a(layoutinflater);
        u();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mProductReviewHelper = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        if (mProductReviewHelper != null)
        {
            mProductReviewHelper.a();
        }
        mViews = null;
    }

    protected int p()
    {
        return mTotalRecordCount;
    }

}
