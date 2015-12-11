// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.ListFragment;
import android.os.Debug;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;
import com.groupon.adapter.VpsAdapter;

// Referenced classes of package com.groupon.util:
//            DialogManager

public class ViewsPerSecondHelper
{

    public ViewsPerSecondHelper()
    {
    }

    public static void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menu.add(0, 0x7f100023, 1, 0x7f0804e9);
        menu.add(0, 0x7f100025, 1, 0x7f0804eb);
        menu.add(0, 0x7f100024, 1, 0x7f0804ea);
    }

    public static boolean onOptionsItemSelected(DialogManager dialogmanager, ListFragment listfragment, MenuItem menuitem)
    {
        boolean flag = false;
        int i = menuitem.getItemId();
        menuitem = (VpsAdapter)listfragment.getListAdapter();
        switch (i)
        {
        default:
            return false;

        case 2131755043: 
        case 2131755045: 
            if (i == 0x7f100025)
            {
                flag = true;
            }
            i = Math.min(menuitem.getCount(), 50);
            ListView listview = listfragment.getListView();
            menuitem.resetViewsPerSecond();
            if (flag)
            {
                Debug.startMethodTracing();
            }
            listview.smoothScrollToPosition(i - 1);
            listview.setOnScrollListener(new android.widget.AbsListView.OnScrollListener(i, flag, dialogmanager, listfragment, menuitem) {

                int currentFirstVisibleItem;
                int currentVisibleItemCount;
                final VpsAdapter val$adapter;
                final DialogManager val$dialogManager;
                final ListFragment val$fragment;
                final int val$maxViews;
                final boolean val$trace;

                public void onScroll(AbsListView abslistview, int j, int k, int l)
                {
                    currentFirstVisibleItem = j;
                    currentVisibleItemCount = k;
                }

                public void onScrollStateChanged(AbsListView abslistview, int j)
                {
                    if (currentVisibleItemCount + currentFirstVisibleItem >= maxViews && j == 0)
                    {
                        if (trace)
                        {
                            Debug.stopMethodTracing();
                        }
                        ViewsPerSecondHelper.showResults(dialogManager, fragment, adapter);
                    }
                }

            
            {
                maxViews = i;
                trace = flag;
                dialogManager = dialogmanager;
                fragment = listfragment;
                adapter = vpsadapter;
                super();
            }
            });
            return true;

        case 2131755044: 
            showResults(dialogmanager, listfragment, menuitem);
            return true;
        }
    }

    private static void showResults(DialogManager dialogmanager, ListFragment listfragment, VpsAdapter vpsadapter)
    {
        dialogmanager.showAlertDialog(String.format("%.2f Views per second (%s views)", new Object[] {
            Double.valueOf(vpsadapter.getViewsPerSecond()), Integer.valueOf(vpsadapter.getViewsPerSecondViewCount())
        }));
        dialogmanager = listfragment.getListView();
        dialogmanager.setSelection(0);
        dialogmanager.setOnScrollListener(null);
    }

}
