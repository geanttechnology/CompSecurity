// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem;
import com.amazon.retailsearch.android.api.display.results.listeners.ResultItemSelectionListener;
import com.amazon.retailsearch.android.ui.results.views.ArrowView;
import com.amazon.retailsearch.android.ui.results.views.RatingsLine;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.searchapp.retailsearch.model.Product;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            ProductView, ResultLayoutType

public class SplitProduct extends ProductView
{
    private class SplitItemSelectionListener
        implements ResultItemSelectionListener
    {

        private String asin;
        final SplitProduct this$0;

        public void onResultItemSelected(RetailSearchResultItem retailsearchresultitem)
        {
            if (asin != null && asin.equals(SplitProduct.this.asin))
            {
                updateIndicator(asin, retailsearchresultitem.getAsin());
            }
            userInteractionListener.removeListener(this);
        }

        public SplitItemSelectionListener(String s)
        {
            this$0 = SplitProduct.this;
            super();
            asin = s;
        }
    }

    private class SplitProductGestureListener extends android.view.GestureDetector.SimpleOnGestureListener
    {

        final SplitProduct this$0;

        public boolean onSingleTapConfirmed(MotionEvent motionevent)
        {
            if (selectionIndicator != null)
            {
                selectionIndicator.setImageDrawable(mArrowGenerator.getArrow(mOrientation));
            }
            userInteractionListener.addListener(new SplitItemSelectionListener(asin));
            return super.onSingleTapUp(motionevent);
        }

        private SplitProductGestureListener()
        {
            this$0 = SplitProduct.this;
            super();
        }

    }


    private String asin;
    private TextView byLine;
    private ArrowView mArrowGenerator;
    private Context mContext;
    private int mOrientation;
    private android.view.View.OnTouchListener onTouchListener;
    private RatingsLine ratingsLine;
    private ResultItemSelectionListener resultItemSelectionListener;
    private ImageView selectionIndicator;
    protected GestureDetector splitGestureDetector;
    private SplitProductGestureListener splitGestureListener;

    public SplitProduct(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        resultLayoutType = ResultLayoutType.SplitView;
        mContext = context;
    }

    private void updateIndicator(String s, String s1)
    {
        if (selectionIndicator == null)
        {
            return;
        }
        if (s != null && s.equals(s1))
        {
            selectionIndicator.setImageDrawable(mArrowGenerator.getArrow(mOrientation));
            return;
        } else
        {
            selectionIndicator.setImageDrawable(null);
            return;
        }
    }

    protected void buildView()
    {
        super.buildView();
        String s;
        if (TextUtils.isEmpty(product.getByLine()))
        {
            byLine.setVisibility(8);
        } else
        {
            byLine.setText(product.getByLine());
            byLine.setVisibility(0);
        }
        if (ratingsLine != null)
        {
            com.amazon.retailsearch.android.ui.results.views.RatingsLineModel ratingslinemodel = (new com.amazon.retailsearch.android.ui.results.views.RatingsLineModel.Builder()).build(ratings, getResources());
            ratingsLine.buildView(ratingslinemodel, resultLayoutType);
        }
        asin = product.getAsin();
        s = userInteractionListener.getSelectedAsin();
        updateIndicator(asin, s);
        if (resultItemSelectionListener != null)
        {
            userInteractionListener.removeListener(resultItemSelectionListener);
        }
        if (asin != null && asin.equals(s))
        {
            userInteractionListener.addListener(new SplitItemSelectionListener(asin));
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (onTouchListener != null)
        {
            onTouchListener.onTouch(this, motionevent);
        }
        super.onTouchEvent(motionevent);
        super.dispatchTouchEvent(motionevent);
        if (splitGestureDetector != null)
        {
            splitGestureDetector.onTouchEvent(motionevent);
        }
        return true;
    }

    protected void init(Context context)
    {
        super.init(context);
        inflate(context, com.amazon.retailsearch.R.layout.split_product_items, this);
        splitGestureListener = new SplitProductGestureListener();
        splitGestureDetector = new GestureDetector(getContext(), splitGestureListener);
        mArrowGenerator = new ArrowView(context);
        initProductElements();
    }

    protected void initProductElements()
    {
        super.initProductElements();
        byLine = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_item_byline);
        selectionIndicator = (ImageView)findViewById(com.amazon.retailsearch.R.id.arrow_selection_indicator_icon);
        if (getResources().getConfiguration().orientation == 2)
        {
            mOrientation = 2;
            ratingsLine = (RatingsLine)findViewById(com.amazon.retailsearch.R.id.rs_results_ratings);
        } else
        if (getResources().getConfiguration().orientation == 1)
        {
            mOrientation = 1;
            selectionIndicator.getLayoutParams().height = mArrowGenerator.getArrow(mOrientation).getIntrinsicHeight();
            return;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return false;
    }

    public void setOnTouchListener(android.view.View.OnTouchListener ontouchlistener)
    {
        onTouchListener = ontouchlistener;
    }





}
