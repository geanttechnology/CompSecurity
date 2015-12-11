// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.refine;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;

// Referenced classes of package com.target.ui.view.refine:
//            RefineExpandView, RefineSortView

public class RefineSortExpandView extends RefineExpandView
{
    public static interface a
        extends com.target.ui.view.common.ExpandView.a
    {

        public abstract void a(com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel);

        public abstract void b(com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel);
    }

    private class b
        implements RefineSortView.a
    {

        final RefineSortExpandView this$0;

        public void a(com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel)
        {
            RefineSortExpandView.this.a(true);
            if (RefineSortExpandView.a(RefineSortExpandView.this) != null)
            {
                RefineSortExpandView.a(RefineSortExpandView.this).a(sortlabel);
            }
        }

        public void b(com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel)
        {
            RefineSortExpandView.this.a(false);
            if (RefineSortExpandView.a(RefineSortExpandView.this) != null)
            {
                RefineSortExpandView.a(RefineSortExpandView.this).b(sortlabel);
            }
        }

        private b()
        {
            this$0 = RefineSortExpandView.this;
            super();
        }

    }


    public static final String TAG = com/target/ui/view/refine/RefineSortExpandView.getSimpleName();
    private a mListener;

    public RefineSortExpandView(Context context)
    {
        super(context);
    }

    public RefineSortExpandView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public RefineSortExpandView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    static a a(RefineSortExpandView refinesortexpandview)
    {
        return refinesortexpandview.mListener;
    }

    public void setChildData(RefineSortView refinesortview)
    {
        if (refinesortview == null)
        {
            return;
        } else
        {
            String s = getResources().getString(0x7f090475);
            setChildView(refinesortview);
            setTitle(s);
            refinesortview.setClickListener(new b());
            return;
        }
    }

    public void setClickListener(a a1)
    {
        setExpandClickListener(a1);
        mListener = a1;
    }

}
