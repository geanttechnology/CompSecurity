// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.mobile.search.SearchRefineFragment;
import java.util.List;

// Referenced classes of package com.ebay.mobile.search.refine.adapters:
//            RefineSingleOptionAdapter

public class RefineSingleOptionAdapterWithHeader extends RefineSingleOptionAdapter
{

    private static Rect defaultPadding;

    public RefineSingleOptionAdapterWithHeader(Context context, List list)
    {
        super(context, list);
    }

    public RefineSingleOptionAdapterWithHeader(Context context, Object aobj[])
    {
        super(context, aobj);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = super.getView(i, view, viewgroup);
        RefineOptionAdapter.ViewCache viewcache = (RefineOptionAdapter.ViewCache)view1.getTag();
        viewgroup = null;
        if (defaultPadding == null)
        {
            defaultPadding = new Rect(viewcache.titleView.getPaddingLeft(), viewcache.titleView.getPaddingTop(), viewcache.titleView.getPaddingRight(), viewcache.titleView.getPaddingBottom());
        }
        Integer integer = Integer.valueOf((int)(2.0F * (float)defaultPadding.left));
        view = Integer.valueOf(getContext().getResources().getColor(0x7f0d00dd));
        if (showLeftArrowForPosition(i))
        {
            viewgroup = getContext().getResources().getDrawable(0x7f0201be);
            integer = Integer.valueOf(defaultPadding.left);
            view = Integer.valueOf(SearchRefineFragment.textHighlightColor);
        }
        viewcache.titleView.setPadding(integer.intValue(), defaultPadding.top, defaultPadding.right, defaultPadding.bottom);
        viewcache.titleView.setCompoundDrawablesWithIntrinsicBounds(viewgroup, null, null, null);
        viewcache.titleView.setContentDescription(getContext().getResources().getString(0x7f07096a));
        viewcache.titleView.setTextColor(view.intValue());
        return view1;
    }

    public boolean showLeftArrowForPosition(int i)
    {
        return false;
    }
}
