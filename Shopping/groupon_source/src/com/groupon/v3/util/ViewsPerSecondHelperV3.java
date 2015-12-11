// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.util;

import android.os.Debug;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import com.groupon.util.DialogManager;

public class ViewsPerSecondHelperV3
{

    private RecyclerView recyclerView;
    protected long vpsLastViewTime;
    protected long vpsStartTimeNanos;
    protected int vpsViewCount;

    public ViewsPerSecondHelperV3()
    {
        vpsViewCount = 0;
        vpsStartTimeNanos = System.nanoTime();
        vpsLastViewTime = 0x7fffffffffffffffL;
    }

    private void showResults(DialogManager dialogmanager)
    {
        dialogmanager.showAlertDialog(String.format("%.2f Views per second (%s views)", new Object[] {
            Double.valueOf(getViewsPerSecond()), Integer.valueOf(getViewsPerSecondViewCount())
        }));
        recyclerView.scrollToPosition(0);
        recyclerView.setOnScrollListener(null);
    }

    public double getViewsPerSecond()
    {
        return ((double)vpsViewCount / (double)(vpsLastViewTime - vpsStartTimeNanos)) * 1000000000D;
    }

    public int getViewsPerSecondViewCount()
    {
        return vpsViewCount;
    }

    public void onCreateOptionsMenu(Menu menu)
    {
        menu.add(0, 0x7f100023, 1, 0x7f0804e9);
        menu.add(0, 0x7f100025, 1, 0x7f0804eb);
        menu.add(0, 0x7f100024, 1, 0x7f0804ea);
    }

    public boolean onOptionsItemSelected(final DialogManager dialogManager, RecyclerView recyclerview, MenuItem menuitem)
    {
        final boolean trace = false;
        recyclerView = recyclerview;
        int i = menuitem.getItemId();
        menuitem = recyclerview.getAdapter();
        switch (i)
        {
        default:
            return false;

        case 2131755043: 
        case 2131755045: 
            if (i == 0x7f100025)
            {
                trace = true;
            }
            i = Math.min(menuitem.getItemCount(), 50);
            resetViewsPerSecond();
            vpsViewCount = i;
            if (trace)
            {
                Debug.startMethodTracing();
            }
            recyclerview.smoothScrollToPosition(i - 1);
            recyclerview.setOnScrollListener(new android.support.v7.widget.RecyclerView.OnScrollListener() {

                final ViewsPerSecondHelperV3 this$0;
                final DialogManager val$dialogManager;
                final boolean val$trace;

                public void onScrollStateChanged(RecyclerView recyclerview1, int j)
                {
                    if (j == 0)
                    {
                        if (trace)
                        {
                            Debug.stopMethodTracing();
                        }
                        vpsLastViewTime = System.nanoTime();
                        showResults(dialogManager);
                    }
                }

            
            {
                this$0 = ViewsPerSecondHelperV3.this;
                trace = flag;
                dialogManager = dialogmanager;
                super();
            }
            });
            return true;

        case 2131755044: 
            showResults(dialogManager);
            return true;
        }
    }

    public void resetViewsPerSecond()
    {
        vpsViewCount = 0;
        vpsStartTimeNanos = System.nanoTime();
        vpsLastViewTime = 0x7fffffffffffffffL;
    }

}
