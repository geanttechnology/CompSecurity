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

class val.stockValue
    implements android.view.
{

    final sh this$1;
    final StockValue val$stockValue;

    public void onClick(View view)
    {
        view = new Intent();
        view.putExtra("stockValue", val$stockValue);
        setResult(-1, view);
        finish();
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$stockValue = StockValue.this;
        super();
    }

    // Unreferenced inner class com/groupon/activity/StockCategories$3

/* anonymous class */
    class StockCategories._cls3
        implements android.widget.AdapterView.OnItemSelectedListener
    {

        final StockCategories this$0;

        public void onItemSelected(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = (StockCategory)stockCategoriesSpinner.getAdapter().getItem(i);
            if (adapterview != null)
            {
                view = ((StockCategory) (adapterview)).stockValues;
                ViewGroup viewgroup = stockValuesContainer;
                if (view.size() > 0)
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
                adapterview = view.iterator();
                while (adapterview.hasNext()) 
                {
                    view = (StockValue)adapterview.next();
                    boolean flag;
                    if (((StockValue) (view)).maxStock - ((StockValue) (view)).soldQuantity <= 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    StockCategories.access$400(StockCategories.this, valuesContainer, 0x7f03020e, ((StockValue) (view)).name, view. new StockCategories._cls3._cls1(), flag);
                    StockCategories.access$500(StockCategories.this);
                }
            }
        }

        public void onNothingSelected(AdapterView adapterview)
        {
        }

            
            {
                this$0 = StockCategories.this;
                super();
            }
    }

}
