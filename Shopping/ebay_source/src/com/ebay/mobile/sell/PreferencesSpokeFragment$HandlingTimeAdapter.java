// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.ebay.nautilus.domain.data.LdsOption;

// Referenced classes of package com.ebay.mobile.sell:
//            PreferencesSpokeFragment

private class context extends ArrayAdapter
{

    private final Context context;
    final PreferencesSpokeFragment this$0;

    public boolean areAllItemsEnabled()
    {
        return false;
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        view = (LayoutInflater)context.getSystemService("layout_inflater");
        if (isEnabled(i))
        {
            view = view.inflate(0x7f030217, viewgroup, false);
            ((TextView)view.findViewById(0x1020014)).setText(((LdsOption)getItem(i)).caption);
            return view;
        } else
        {
            view = view.inflate(0x7f030219, viewgroup, false);
            ((TextView)view.findViewById(0x7f1003b9)).setText(((LdsOption)getItem(i)).caption);
            return view;
        }
    }

    public boolean isEnabled(int i)
    {
        return ((LdsOption)getItem(i)).getIntValue() != -1;
    }

    public (Context context1)
    {
        this$0 = PreferencesSpokeFragment.this;
        super(context1, 0x7f030223);
        context = context1;
    }
}
