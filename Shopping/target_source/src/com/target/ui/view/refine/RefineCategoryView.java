// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.refine;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.target.mothership.model.product.interfaces.ProductEntry;
import com.target.ui.view.product.FixedHeightListView;
import com.target.ui.view.refine.a.a;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.view.refine:
//            BaseRefineFacetsContainer

public class RefineCategoryView extends BaseRefineFacetsContainer
{
    static class Views extends com.target.ui.view.a
    {

        FixedHeightListView listView;

        public Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements com.target.ui.view.refine.a.a.a
    {

        final RefineCategoryView this$0;

        public void a(ProductEntry productentry)
        {
            if (getListener() == null)
            {
                return;
            } else
            {
                getListener().a(productentry);
                return;
            }
        }

        public void b(ProductEntry productentry)
        {
            if (getListener() == null)
            {
                return;
            } else
            {
                getListener().b(productentry);
                return;
            }
        }

        private a()
        {
            this$0 = RefineCategoryView.this;
            super();
        }

    }


    public static final String TAG = com/target/ui/view/refine/RefineCategoryView.getSimpleName();
    private com.target.ui.view.refine.a.a mAdapter;
    private Views mViews;

    public RefineCategoryView(Context context)
    {
        super(context);
        c();
    }

    public RefineCategoryView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c();
    }

    public RefineCategoryView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        c();
    }

    private void c()
    {
        inflate(getContext(), 0x7f0301c9, this);
        mViews = new Views(this);
        mAdapter = new com.target.ui.view.refine.a.a(getContext(), new ArrayList());
        mAdapter.a(new a());
        mViews.listView.setAdapter(mAdapter);
    }

    private void d()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mAdapter.a();
            return;
        }
    }

    public void a()
    {
        d();
    }

    protected void a(List list)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mAdapter.a(list, getSelectedFacets());
            return;
        }
    }

}
