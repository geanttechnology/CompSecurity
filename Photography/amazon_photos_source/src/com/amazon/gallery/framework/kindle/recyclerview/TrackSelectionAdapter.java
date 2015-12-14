// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;

// Referenced classes of package com.amazon.gallery.framework.kindle.recyclerview:
//            MosaicLayoutManager

public abstract class TrackSelectionAdapter extends android.support.v7.widget.RecyclerView.Adapter
{

    private int focusedItem;
    private boolean hasKeyboard;

    public TrackSelectionAdapter()
    {
        focusedItem = 0;
        hasKeyboard = false;
    }

    private int calculateDiffVertically(android.support.v7.widget.RecyclerView.LayoutManager layoutmanager, int i)
    {
        int j = 1;
        if (layoutmanager.canScrollVertically())
        {
            j = layoutmanager.getColumnCountForAccessibility(null, null);
        }
        int k = j;
        switch (i)
        {
        default:
            k = 0;
            // fall through

        case 20: // '\024'
            return k;

        case 19: // '\023'
            return -j;
        }
    }

    private boolean clickSelection(RecyclerView recyclerview)
    {
        recyclerview = recyclerview.findViewHolderForAdapterPosition(focusedItem);
        return recyclerview != null && ((android.support.v7.widget.RecyclerView.ViewHolder) (recyclerview)).itemView.performClick();
    }

    private boolean tryMoveSelection(android.support.v7.widget.RecyclerView.LayoutManager layoutmanager, int i)
    {
        boolean flag;
        boolean flag2;
        flag2 = false;
        flag = false;
        i;
        JVM INSTR tableswitch 19 22: default 36
    //                   19 111
    //                   20 111
    //                   21 126
    //                   22 121;
           goto _L1 _L2 _L2 _L3 _L4
_L3:
        break MISSING_BLOCK_LABEL_126;
_L1:
        i = ((flag) ? 1 : 0);
_L5:
        i = focusedItem + i;
        boolean flag1 = flag2;
        if (i >= 0)
        {
            flag1 = flag2;
            if (i < getItemCount())
            {
                notifyItemChanged(focusedItem);
                focusedItem = i;
                notifyItemChanged(focusedItem);
                if (layoutmanager instanceof MosaicLayoutManager)
                {
                    ((MosaicLayoutManager)layoutmanager).scrollToPositionWithOffset(focusedItem, 0);
                } else
                {
                    layoutmanager.scrollToPosition(focusedItem);
                }
                flag1 = true;
            }
        }
        return flag1;
_L2:
        i = calculateDiffVertically(layoutmanager, i);
          goto _L5
_L4:
        i = 1;
          goto _L5
        i = -1;
          goto _L5
    }

    public void onAttachedToRecyclerView(final RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.setOnKeyListener(new android.view.View.OnKeyListener() {

            final TrackSelectionAdapter this$0;
            final RecyclerView val$recyclerView;

            public boolean onKey(View view, int i, KeyEvent keyevent)
            {
                view = recyclerView.getLayoutManager();
                if (keyevent.getAction() != 0) goto _L2; else goto _L1
_L1:
                i;
                JVM INSTR lookupswitch 5: default 68
            //                           19: 70
            //                           20: 70
            //                           21: 70
            //                           22: 70
            //                           66: 89;
                   goto _L2 _L3 _L3 _L3 _L3 _L4
_L2:
                return false;
_L3:
                hasKeyboard = true;
                return tryMoveSelection(view, i);
_L4:
                hasKeyboard = true;
                return clickSelection(recyclerView);
            }

            
            {
                this$0 = TrackSelectionAdapter.this;
                recyclerView = recyclerview;
                super();
            }
        });
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        if (hasKeyboard)
        {
            viewholder = viewholder.itemView;
            boolean flag;
            if (focusedItem == i)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            viewholder.setSelected(flag);
        }
    }


/*
    static boolean access$002(TrackSelectionAdapter trackselectionadapter, boolean flag)
    {
        trackselectionadapter.hasKeyboard = flag;
        return flag;
    }

*/


}
