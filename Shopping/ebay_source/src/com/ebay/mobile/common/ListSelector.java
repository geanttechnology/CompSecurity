// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;

import android.os.Bundle;
import java.util.List;

public interface ListSelector
{
    public static interface ListItemSelector
    {

        public abstract boolean getIsSelectionEnabled();

        public abstract boolean isSelected(Object obj);

        public abstract void setOnSelectionModeChangeListener(OnSelectionModeChangeListener onselectionmodechangelistener);

        public abstract void toggleSelection(Object obj);
    }

    public static interface OnSelectionChangeListener
    {

        public abstract void onSelectionChanged(boolean flag);
    }

    public static interface OnSelectionModeChangeListener
    {

        public abstract void onSelectionModeChanged(boolean flag);
    }


    public abstract void clearSelectedItems();

    public abstract boolean getIsSelectionEnabled();

    public abstract ListItemSelector getListItemSelector();

    public abstract List getSelectedItems();

    public abstract boolean hasSelectedItems();

    public abstract void restoreState(Bundle bundle);

    public abstract void saveState(Bundle bundle);

    public abstract void setIsSelectionEnabled(boolean flag);

    public abstract void setOnSelectionChangeListener(OnSelectionChangeListener onselectionchangelistener);

    public abstract void setOnSelectionModeChangeListener(OnSelectionModeChangeListener onselectionmodechangelistener);
}
