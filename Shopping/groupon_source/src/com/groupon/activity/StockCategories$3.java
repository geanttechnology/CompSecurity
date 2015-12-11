// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.groupon.db.models.StockCategory;
import com.groupon.db.models.StockValue;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.groupon.activity:
//            StockCategories

class this._cls0
    implements android.widget.SelectedListener
{

    final StockCategories this$0;

    public void onItemSelected(AdapterView adapterview, final View stockValue, int i, long l)
    {
        adapterview = (StockCategory)stockCategoriesSpinner.getAdapter().getItem(i);
        if (adapterview != null)
        {
            stockValue = ((StockCategory) (adapterview)).stockValues;
            ViewGroup viewgroup = stockValuesContainer;
            if (stockValue.size() > 0)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            viewgroup.setVisibility(i);
            stockValuesTitle.setText(String.format(getString(0x7f0800b4), new Object[] {
                ((StockCategory) (adapterview)).name
            }).toUpperCase());
            valuesContainer.removeAllViews();
            adapterview = stockValue.iterator();
            while (adapterview.hasNext()) 
            {
                stockValue = (StockValue)adapterview.next();
                boolean flag;
                if (((StockValue) (stockValue)).maxStock - ((StockValue) (stockValue)).soldQuantity <= 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                StockCategories.access$400(StockCategories.this, valuesContainer, 0x7f03020e, ((StockValue) (stockValue)).name, new android.view.View.OnClickListener() {

                    final StockCategories._cls3 this$1;
                    final StockValue val$stockValue;

                    public void onClick(View view)
                    {
                        view = new Intent();
                        view.putExtra("stockValue", stockValue);
                        setResult(-1, view);
                        finish();
                    }

            
            {
                this$1 = StockCategories._cls3.this;
                stockValue = stockvalue;
                super();
            }
                }, flag);
                StockCategories.access$500(StockCategories.this);
            }
        }
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    _cls1.val.stockValue()
    {
        this$0 = StockCategories.this;
        super();
    }
}
