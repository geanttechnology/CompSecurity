// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.refine;

import android.content.Context;
import android.util.AttributeSet;
import com.google.a.a.e;
import com.target.mothership.model.product.interfaces.ProductEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.view.refine:
//            BaseRefineView

public abstract class BaseRefineFacetsContainer extends BaseRefineView
{
    public static interface a
    {

        public abstract void a(ProductEntry productentry);

        public abstract void b(ProductEntry productentry);
    }


    private a mListener;
    private List mSelectedFacets;

    public BaseRefineFacetsContainer(Context context)
    {
        super(context);
        mSelectedFacets = new ArrayList();
    }

    public BaseRefineFacetsContainer(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mSelectedFacets = new ArrayList();
    }

    public BaseRefineFacetsContainer(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mSelectedFacets = new ArrayList();
    }

    protected abstract void a(List list);

    public void a(List list, List list1)
    {
        mSelectedFacets = list1;
        a(list);
    }

    protected boolean a(ProductEntry productentry)
    {
label0:
        {
            Iterator iterator = mSelectedFacets.iterator();
            ProductEntry productentry1;
label1:
            do
            {
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    productentry1 = (ProductEntry)iterator.next();
                    if (!productentry.f())
                    {
                        continue label1;
                    }
                } while (!productentry.d().equalsIgnoreCase(productentry1.d()));
                return true;
            } while (!((String)productentry.c().c()).equalsIgnoreCase((String)productentry1.c().c()));
            return true;
        }
        return false;
    }

    protected boolean b()
    {
        return !mSelectedFacets.isEmpty();
    }

    protected a getListener()
    {
        return mListener;
    }

    protected List getSelectedFacets()
    {
        return mSelectedFacets;
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }
}
