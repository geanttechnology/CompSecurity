// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import android.os.Handler;
import android.view.View;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.metrics.impressions.AsinImpressionTracker;
import com.amazon.retailsearch.metrics.impressions.ProductViewSnapshot;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.entity.ProductEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            StackLayout, ResultsController, StackView, LayoutElement, 
//            LayoutElementModel

private class interval
    implements Runnable
{

    private final long DEFAULT_REPORTER_INTERVAL_MS;
    private Handler handler;
    private long interval;
    private boolean monitoring;
    final StackLayout this$0;

    private void examineStackView()
    {
        if (results.size() != 0)
        {
            int k = stackView.getFirstVisiblePosition();
            int l = stackView.getLastVisiblePosition();
            int j = (l - k) + 1;
            int i = j;
            if (l >= results.size())
            {
                i = j - 1;
            }
            j = 0;
            while (j < i) 
            {
                Object obj = stackView.getChildAt(j);
                if (obj != null)
                {
                    ArrayList arraylist = new ArrayList(StackLayout.access$1200(StackLayout.this));
                    int i1 = k + j;
                    if (i1 >= 0 && i1 < results.size())
                    {
                        Iterator iterator = results.get(i1).getLayoutElementModel().getAllModels().iterator();
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                break;
                            }
                            Object obj1 = iterator.next();
                            if (obj1 instanceof ProductEntity)
                            {
                                obj1 = ((ProductEntity)obj1).getAsin();
                                if (!StackLayout.access$1300(StackLayout.this).wasAsinViewed(((String) (obj1))))
                                {
                                    arraylist.add(obj1);
                                }
                            }
                        } while (true);
                        if (!Utils.isEmpty(arraylist))
                        {
                            int j1 = ((View) (obj)).getHeight();
                            int k1 = ((View) (obj)).getTop();
                            int l1 = ((View) (obj)).getBottom();
                            int i2 = stackView.getHeight();
                            float f = 0.0F;
                            long l2;
                            if (k1 >= 0 && l1 <= i2)
                            {
                                f = 1.0F;
                            } else
                            if (k1 < 0)
                            {
                                f = ((float)j1 - (float)Math.abs(k1)) / (float)j1;
                            } else
                            if (l1 > i2)
                            {
                                f = ((float)i2 - (float)k1) / (float)j1;
                            }
                            l2 = System.currentTimeMillis();
                            obj = arraylist.iterator();
                            while (((Iterator) (obj)).hasNext()) 
                            {
                                ProductViewSnapshot productviewsnapshot = new ProductViewSnapshot((String)((Iterator) (obj)).next(), f, l2);
                                StackLayout.access$1300(StackLayout.this).evaluateByIncrementalSnapshot(productviewsnapshot);
                            }
                        }
                    }
                }
                j++;
            }
        }
    }

    private void monitor()
    {
        handler.postDelayed(this, interval);
    }

    public void run()
    {
        try
        {
            examineStackView();
        }
        catch (Exception exception)
        {
            StackLayout.access$800(StackLayout.this).error("Asin Impression Logger caused an exception ", exception);
        }
        monitor();
    }

    void startMonitoring()
    {
        if (monitoring)
        {
            return;
        } else
        {
            monitor();
            monitoring = true;
            return;
        }
    }

    void stopMonitoring()
    {
        if (!monitoring)
        {
            return;
        } else
        {
            handler.removeCallbacks(this);
            monitoring = false;
            return;
        }
    }

    ()
    {
        this(0L);
    }

    <init>(long l)
    {
        this$0 = StackLayout.this;
        super();
        DEFAULT_REPORTER_INTERVAL_MS = 500L;
        handler = new Handler();
        interval = 0L;
        monitoring = false;
        long l1 = l;
        if (l <= 0L)
        {
            l1 = 500L;
        }
        interval = l1;
    }
}
