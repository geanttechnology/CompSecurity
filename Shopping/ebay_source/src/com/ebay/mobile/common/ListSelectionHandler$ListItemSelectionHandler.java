// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;

import android.os.Parcelable;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.common:
//            ListSelectionHandler

public class this._cls0
    implements this._cls0
{

    final ListSelectionHandler this$0;

    public boolean getIsSelectionEnabled()
    {
        return ListSelectionHandler.access$000(ListSelectionHandler.this);
    }

    public boolean isSelected(Parcelable parcelable)
    {
        return ListSelectionHandler.access$100(ListSelectionHandler.this) != null && parcelable != null && ListSelectionHandler.access$100(ListSelectionHandler.this).contains(parcelable);
    }

    public volatile boolean isSelected(Object obj)
    {
        return isSelected((Parcelable)obj);
    }

    public void setOnSelectionModeChangeListener(isSelected isselected)
    {
        ListSelectionHandler.this.setOnSelectionModeChangeListener(isselected);
    }

    public void toggleSelection(Parcelable parcelable)
    {
        boolean flag = false;
        if (!isSelected(parcelable))
        {
            ListSelectionHandler.access$100(ListSelectionHandler.this).add(parcelable);
            flag = true;
        } else
        {
            ListSelectionHandler.access$100(ListSelectionHandler.this).remove(parcelable);
        }
        if (ListSelectionHandler.access$200(ListSelectionHandler.this) != null)
        {
            ListSelectionHandler.access$200(ListSelectionHandler.this).tionChanged(flag);
        }
    }

    public volatile void toggleSelection(Object obj)
    {
        toggleSelection((Parcelable)obj);
    }

    public ()
    {
        this$0 = ListSelectionHandler.this;
        super();
    }
}
