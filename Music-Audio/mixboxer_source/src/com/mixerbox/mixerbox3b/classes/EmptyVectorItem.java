// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.view.LayoutInflater;
import android.view.View;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.classes:
//            MyItem

public class EmptyVectorItem
    implements MyItem
{

    public EmptyVectorItem()
    {
    }

    public JSONObject getMyJSONObject()
    {
        return new JSONObject();
    }

    public View getView(LayoutInflater layoutinflater, View view)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = layoutinflater.inflate(0x7f030049, null);
        }
        return view1;
    }

    public int getViewType()
    {
        return com.mixerbox.mixerbox3b.adapters.VectorAdapter.RowType.EMPTY_ITEM.ordinal();
    }
}
