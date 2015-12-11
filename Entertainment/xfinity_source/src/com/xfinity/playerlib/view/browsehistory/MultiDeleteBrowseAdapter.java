// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsehistory;

import android.view.LayoutInflater;
import com.comcast.cim.cmasl.android.util.view.widget.ViewHolderBaseAdapter;
import java.util.List;

public abstract class MultiDeleteBrowseAdapter extends ViewHolderBaseAdapter
{

    protected boolean isEditMode;

    public MultiDeleteBrowseAdapter(LayoutInflater layoutinflater)
    {
        super(layoutinflater);
    }

    public abstract List getData();

    public abstract void removeItems(List list);

    public abstract void setData(List list);

    public void setEditMode(boolean flag)
    {
        isEditMode = flag;
        notifyDataSetChanged();
    }
}
