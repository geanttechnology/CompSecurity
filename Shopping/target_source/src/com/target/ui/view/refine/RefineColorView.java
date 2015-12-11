// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.refine;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.target.mothership.model.product.interfaces.ProductEntry;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.view.refine:
//            BaseRefineFacetsContainer, RefineCheckBoxAndColorImageView

public class RefineColorView extends BaseRefineFacetsContainer
{
    private class a
        implements RefineCheckBoxAndColorImageView.a
    {

        final RefineColorView this$0;

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
            this$0 = RefineColorView.this;
            super();
        }

    }


    public static final String TAG = com/target/ui/view/refine/RefineColorView.getSimpleName();

    public RefineColorView(Context context)
    {
        super(context);
    }

    public RefineColorView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public RefineColorView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    private void c()
    {
        for (int i = 0; i < getChildCount(); i++)
        {
            ((RefineCheckBoxAndColorImageView)getChildAt(i)).a();
        }

    }

    public void a()
    {
        c();
    }

    protected void a(List list)
    {
        RefineCheckBoxAndColorImageView refinecheckboxandcolorimageview;
        for (list = list.iterator(); list.hasNext(); addView(refinecheckboxandcolorimageview))
        {
            ProductEntry productentry = (ProductEntry)list.next();
            refinecheckboxandcolorimageview = (RefineCheckBoxAndColorImageView)LayoutInflater.from(getContext()).inflate(0x7f0301cc, this, false);
            refinecheckboxandcolorimageview.a(productentry, a(productentry));
            refinecheckboxandcolorimageview.setClickListener(new a());
        }

        int i = getResources().getDimensionPixelSize(0x7f0a016f);
        setPadding(0, i, 0, i);
    }

}
