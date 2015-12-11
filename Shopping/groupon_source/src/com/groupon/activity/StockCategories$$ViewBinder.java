// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

// Referenced classes of package com.groupon.activity:
//            StockCategories, GrouponActivity

public class  extends 
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (StockCategories)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, StockCategories stockcategories, Object obj)
    {
        super.bind(ewbinder, stockcategories, obj);
        stockcategories.stockCategoriesSpinner = (Spinner)ewbinder.ckCategoriesSpinner((View)ewbinder.redView(obj, 0x7f10053b, "field 'stockCategoriesSpinner'"), 0x7f10053b, "field 'stockCategoriesSpinner'");
        stockcategories.stockCategoriesTitle = (TextView)ewbinder.ckCategoriesTitle((View)ewbinder.redView(obj, 0x7f10053a, "field 'stockCategoriesTitle'"), 0x7f10053a, "field 'stockCategoriesTitle'");
        stockcategories.stockValuesTitle = (TextView)ewbinder.ckValuesTitle((View)ewbinder.redView(obj, 0x7f10053e, "field 'stockValuesTitle'"), 0x7f10053e, "field 'stockValuesTitle'");
        stockcategories.valuesContainer = (ViewGroup)ewbinder.uesContainer((View)ewbinder.redView(obj, 0x7f10053f, "field 'valuesContainer'"), 0x7f10053f, "field 'valuesContainer'");
        stockcategories.stockValuesContainer = (ViewGroup)ewbinder.ckValuesContainer((View)ewbinder.redView(obj, 0x7f10053d, "field 'stockValuesContainer'"), 0x7f10053d, "field 'stockValuesContainer'");
        stockcategories.stockProgressView = (View)ewbinder.redView(obj, 0x7f10053c, "field 'stockProgressView'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (StockCategories)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((StockCategories)grouponactivity);
    }

    public void unbind(StockCategories stockcategories)
    {
        super.unbind(stockcategories);
        stockcategories.stockCategoriesSpinner = null;
        stockcategories.stockCategoriesTitle = null;
        stockcategories.stockValuesTitle = null;
        stockcategories.valuesContainer = null;
        stockcategories.stockValuesContainer = null;
        stockcategories.stockProgressView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((StockCategories)obj);
    }

    public ()
    {
    }
}
