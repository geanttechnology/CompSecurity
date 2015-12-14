// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

// Referenced classes of package com.livemixtapes:
//            Mixtapes, App, PullToRefreshListView, LazyAdapterMixtapes

class this._cls0
    implements android.view.kListener
{

    final Mixtapes this$0;

    public void onClick(View view)
    {
        if (App.viewStyle.equals("grid"))
        {
            grid.setVisibility(8);
            listView.setVisibility(0);
            adapter.notifyDataSetChanged();
            App.viewStyle = "list";
            layoutSwitchImage.setImageResource(0x7f02008c);
        } else
        if (App.viewStyle.equals("list"))
        {
            listView.setVisibility(8);
            grid.setVisibility(0);
            adapter.notifyDataSetChanged();
            App.viewStyle = "grid";
            layoutSwitchImage.setImageResource(0x7f02008b);
            return;
        }
    }

    Mixtapes()
    {
        this$0 = Mixtapes.this;
        super();
    }
}
