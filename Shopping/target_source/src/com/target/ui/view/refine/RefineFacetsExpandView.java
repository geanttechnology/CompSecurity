// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.refine;

import android.content.Context;
import android.util.AttributeSet;
import com.target.mothership.model.product.interfaces.ProductEntry;

// Referenced classes of package com.target.ui.view.refine:
//            RefineExpandView, BaseRefineFacetsContainer

public class RefineFacetsExpandView extends RefineExpandView
{
    private class a
        implements BaseRefineFacetsContainer.a
    {

        final RefineFacetsExpandView this$0;

        public void a(ProductEntry productentry)
        {
            RefineFacetsExpandView.this.a(true);
            if (RefineFacetsExpandView.a(RefineFacetsExpandView.this) != null)
            {
                RefineFacetsExpandView.a(RefineFacetsExpandView.this).a(productentry);
            }
        }

        public void b(ProductEntry productentry)
        {
            RefineFacetsExpandView.this.a(false);
            if (RefineFacetsExpandView.a(RefineFacetsExpandView.this) != null)
            {
                RefineFacetsExpandView.a(RefineFacetsExpandView.this).b(productentry);
            }
        }

        private a()
        {
            this$0 = RefineFacetsExpandView.this;
            super();
        }

    }

    public static interface b
        extends com.target.ui.view.common.ExpandView.a
    {

        public abstract void a(ProductEntry productentry);

        public abstract void b(ProductEntry productentry);
    }


    public static final String TAG = com/target/ui/view/refine/RefineFacetsExpandView.getSimpleName();
    private b mListener;

    public RefineFacetsExpandView(Context context)
    {
        super(context);
    }

    public RefineFacetsExpandView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public RefineFacetsExpandView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    static b a(RefineFacetsExpandView refinefacetsexpandview)
    {
        return refinefacetsexpandview.mListener;
    }

    public void a(String s, BaseRefineFacetsContainer baserefinefacetscontainer)
    {
        setChildView(baserefinefacetscontainer);
        setTitle(s);
        baserefinefacetscontainer.setClickListener(new a());
    }

    public void setClickListener(b b1)
    {
        setExpandClickListener(b1);
        mListener = b1;
    }

}
