// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.controllers;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.ebay.mobile.search.SearchRefineFragment;
import com.ebay.mobile.search.refine.adapters.RefineOptionAdapter;
import com.ebay.mobile.search.refine.adapters.RefineSingleOptionAdapter;
import java.util.BitSet;

// Referenced classes of package com.ebay.mobile.search.refine.controllers:
//            BaseDetailController

public abstract class CheckedDetailController extends BaseDetailController
    implements android.widget.AdapterView.OnItemClickListener
{

    protected RefineSingleOptionAdapter adapter;
    protected ListView listView;
    private boolean singleSelectionMode;

    public CheckedDetailController(SearchRefineFragment searchrefinefragment, ListView listview, boolean flag)
    {
        super(searchrefinefragment);
        singleSelectionMode = false;
        listView = listview;
        singleSelectionMode = flag;
    }

    public RefineOptionAdapter getAdapter()
    {
        return adapter;
    }

    public ListView getListView()
    {
        return listView;
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (update(adapterview.getItemAtPosition(i)))
        {
            refineFragment.commitDetail();
        }
    }

    protected void setupListView(int i)
    {
        BitSet bitset = new BitSet();
        bitset.set(i);
        setupListView(bitset);
    }

    protected void setupListView(final BitSet checkedItems)
    {
        if (!isActive())
        {
            return;
        }
        if (singleSelectionMode)
        {
            listView.setChoiceMode(1);
        } else
        {
            listView.setChoiceMode(2);
        }
        listView.setAdapter(getAdapter());
        listView.post(new Runnable() {

            final CheckedDetailController this$0;
            final BitSet val$checkedItems;

            public void run()
            {
                int j = checkedItems.length();
                for (int i = 0; i < j; i++)
                {
                    listView.setItemChecked(i, checkedItems.get(i));
                }

                listView.setOnItemClickListener(CheckedDetailController.this);
            }

            
            {
                this$0 = CheckedDetailController.this;
                checkedItems = bitset;
                super();
            }
        });
    }

    protected abstract boolean update(Object obj);
}
