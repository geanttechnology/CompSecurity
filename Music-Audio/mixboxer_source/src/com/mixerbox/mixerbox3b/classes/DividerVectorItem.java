// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.classes:
//            MyItem

public class DividerVectorItem
    implements MyItem
{

    Context ctx;
    private JSONObject jOb;
    private String title;

    public DividerVectorItem(JSONObject jsonobject, Context context)
    {
        jOb = jsonobject;
        try
        {
            title = jsonobject.getString("title");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            title = "";
        }
        ctx = context;
    }

    public JSONObject getMyJSONObject()
    {
        return jOb;
    }

    public View getView(LayoutInflater layoutinflater, View view)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = layoutinflater.inflate(0x7f03003a, null);
        }
        ((TextView)view1.findViewById(0x7f0700b0)).setText((new StringBuilder()).append("  ").append(title).toString());
        return view1;
    }

    public int getViewType()
    {
        return com.mixerbox.mixerbox3b.adapters.VectorAdapter.RowType.DIVIDER_ITEM.ordinal();
    }
}
