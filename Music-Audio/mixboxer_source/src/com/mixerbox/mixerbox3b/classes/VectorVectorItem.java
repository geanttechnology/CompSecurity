// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.classes:
//            MyItem

public class VectorVectorItem
    implements MyItem
{

    private String count;
    private JSONObject jOb;
    private String title;

    public VectorVectorItem(JSONObject jsonobject)
    {
        jOb = jsonobject;
        try
        {
            title = jsonobject.getString("title");
        }
        catch (JSONException jsonexception)
        {
            title = "";
        }
        try
        {
            count = jsonobject.getString("size");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            count = "";
        }
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
            view1 = layoutinflater.inflate(0x7f030051, null);
        }
        layoutinflater = (TextView)view1.findViewById(0x7f070127);
        view = (TextView)view1.findViewById(0x7f070126);
        layoutinflater.setText(title);
        view.setText(count);
        return view1;
    }

    public int getViewType()
    {
        return com.mixerbox.mixerbox3b.adapters.VectorAdapter.RowType.VECTOR_ITEM.ordinal();
    }
}
