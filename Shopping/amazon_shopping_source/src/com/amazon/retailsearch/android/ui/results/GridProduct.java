// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.results.events.ProductGestureListener;
import com.amazon.retailsearch.android.ui.results.views.messaging.Availability;
import com.amazon.retailsearch.android.ui.results.views.messaging.NewerEditionAvailable;
import com.amazon.searchapp.retailsearch.model.Product;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            ProductView, ViewType

public class GridProduct extends ProductView
{

    private Availability availability;
    private TextView byLine;
    private int column;
    private NewerEditionAvailable newerEditionAvailable;

    public GridProduct(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        viewType = ViewType.GridView;
    }

    protected void buildView()
    {
        super.buildView();
        Object obj;
        if (TextUtils.isEmpty(product.getByLine()))
        {
            byLine.setVisibility(8);
        } else
        {
            byLine.setText(product.getByLine());
            byLine.setVisibility(0);
        }
        obj = (new com.amazon.retailsearch.android.ui.results.views.messaging.AvailabilityModel.Builder()).build(availabilityInfo);
        availability.buildView(((com.amazon.retailsearch.android.ui.results.views.messaging.AvailabilityModel) (obj)), viewType);
        obj = (new com.amazon.retailsearch.android.ui.results.views.messaging.NewerEditionAvailableModel.Builder()).build(product.getNewerVersion(), product.getGroup());
        newerEditionAvailable.buildView(((com.amazon.retailsearch.android.ui.results.views.messaging.NewerEditionAvailableModel) (obj)), viewType);
    }

    public int getColumn()
    {
        return column;
    }

    protected void init(Context context)
    {
        super.init(context);
        inflate(context, com.amazon.retailsearch.R.layout.grid_product_items, this);
        initProductElements();
    }

    protected void initProductElements()
    {
        super.initProductElements();
        byLine = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_item_byline);
        availability = (Availability)findViewById(com.amazon.retailsearch.R.id.rs_results_availability);
        newerEditionAvailable = (NewerEditionAvailable)findViewById(com.amazon.retailsearch.R.id.rs_results_newer_edition_available);
        gestureListener.addTapTarget(newerEditionAvailable);
        gestureListener.addTapTarget(twister);
    }

    public void setColumn(int i)
    {
        column = i;
    }
}
