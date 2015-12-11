// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.classes:
//            MyItem

public class MoreVectorItem
    implements MyItem
{

    private Context ctx;
    private JSONObject jOb;

    public MoreVectorItem(Context context, JSONObject jsonobject)
    {
        jOb = jsonobject;
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
            view1 = layoutinflater.inflate(0x7f03004b, null);
        }
        ((TextView)view1.findViewById(0x7f070118)).setText((new StringBuilder()).append(ctx.getResources().getString(0x7f0800fb)).append(" >").toString());
        return view1;
    }

    public int getViewType()
    {
        return com.mixerbox.mixerbox3b.adapters.VectorAdapter.RowType.MORE_ITEM.ordinal();
    }
}
