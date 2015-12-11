// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.common:
//            ListSelector

public class ListSelectionHandler
    implements ListSelector
{
    public class ListItemSelectionHandler
        implements ListSelector.ListItemSelector
    {

        final ListSelectionHandler this$0;

        public boolean getIsSelectionEnabled()
        {
            return isSelectionEnabled;
        }

        public boolean isSelected(Parcelable parcelable)
        {
            return selectedItems != null && parcelable != null && selectedItems.contains(parcelable);
        }

        public volatile boolean isSelected(Object obj)
        {
            return isSelected((Parcelable)obj);
        }

        public void setOnSelectionModeChangeListener(ListSelector.OnSelectionModeChangeListener onselectionmodechangelistener)
        {
            ListSelectionHandler.this.setOnSelectionModeChangeListener(onselectionmodechangelistener);
        }

        public void toggleSelection(Parcelable parcelable)
        {
            boolean flag = false;
            if (!isSelected(parcelable))
            {
                selectedItems.add(parcelable);
                flag = true;
            } else
            {
                selectedItems.remove(parcelable);
            }
            if (selectionChangeListener != null)
            {
                selectionChangeListener.onSelectionChanged(flag);
            }
        }

        public volatile void toggleSelection(Object obj)
        {
            toggleSelection((Parcelable)obj);
        }

        public ListItemSelectionHandler()
        {
            this$0 = ListSelectionHandler.this;
            super();
        }
    }


    private static final String KEY_SELECTED_ITEMS = "SelectionModeHandler.selectedItems";
    private static final String KEY_SELECTION_ENABLED = "SelectionModeHandler.selectionEnabled";
    private boolean isSelectionEnabled;
    private ListItemSelectionHandler listItemSelectionHandler;
    private ArrayList selectedItems;
    private ListSelector.OnSelectionChangeListener selectionChangeListener;
    private ListSelector.OnSelectionModeChangeListener selectionModeChangeListener;

    public ListSelectionHandler()
    {
        this(null);
    }

    public ListSelectionHandler(ListSelector.OnSelectionChangeListener onselectionchangelistener)
    {
        selectionModeChangeListener = null;
        selectionChangeListener = null;
        selectedItems = new ArrayList();
        listItemSelectionHandler = new ListItemSelectionHandler();
        selectionChangeListener = onselectionchangelistener;
    }

    public void clearSelectedItems()
    {
        selectedItems.clear();
        if (selectionChangeListener != null)
        {
            selectionChangeListener.onSelectionChanged(false);
        }
    }

    public boolean getIsSelectionEnabled()
    {
        return isSelectionEnabled;
    }

    public ListSelector.ListItemSelector getListItemSelector()
    {
        return listItemSelectionHandler;
    }

    public List getSelectedItems()
    {
        return selectedItems;
    }

    public boolean hasSelectedItems()
    {
        return selectedItems.size() > 0;
    }

    public void restoreState(Bundle bundle)
    {
        selectedItems = bundle.getParcelableArrayList("SelectionModeHandler.selectedItems");
        isSelectionEnabled = bundle.getBoolean("SelectionModeHandler.selectionEnabled");
    }

    public void saveState(Bundle bundle)
    {
        bundle.putParcelableArrayList("SelectionModeHandler.selectedItems", selectedItems);
        bundle.putBoolean("SelectionModeHandler.selectionEnabled", isSelectionEnabled);
    }

    public void setIsSelectionEnabled(boolean flag)
    {
        isSelectionEnabled = flag;
        if (!flag)
        {
            selectedItems.clear();
        }
        if (selectionModeChangeListener != null)
        {
            selectionModeChangeListener.onSelectionModeChanged(flag);
        }
    }

    public void setOnSelectionChangeListener(ListSelector.OnSelectionChangeListener onselectionchangelistener)
    {
        selectionChangeListener = onselectionchangelistener;
    }

    public void setOnSelectionModeChangeListener(ListSelector.OnSelectionModeChangeListener onselectionmodechangelistener)
    {
        selectionModeChangeListener = onselectionmodechangelistener;
    }



}
