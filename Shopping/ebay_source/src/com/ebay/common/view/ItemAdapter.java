// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view;

import android.content.res.Resources;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import com.ebay.mobile.common.EbayCurrencyUtil;

// Referenced classes of package com.ebay.common.view:
//            ViewCache

public abstract class ItemAdapter
{

    public final Resources resources;

    protected ItemAdapter(Resources resources1)
    {
        resources = resources1;
    }

    protected final String formatCurrency(double d, String s, int i)
    {
        return EbayCurrencyUtil.formatDisplay(s, d, i);
    }

    protected final String formatCurrency(String s, String s1, int i)
    {
        try
        {
            s = formatCurrency(Double.parseDouble(s), s1, i);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public void init(ViewCache viewcache)
    {
    }

    public abstract void markItemAsVisited(View view, Object obj);

    public void refresh(AbsListView abslistview)
    {
    }

    public void refresh(ExpandableListView expandablelistview)
    {
    }

    public abstract void setItem(ViewCache viewcache, Object obj);

    public abstract void setItem(ViewCache viewcache, Object obj, int i);
}
