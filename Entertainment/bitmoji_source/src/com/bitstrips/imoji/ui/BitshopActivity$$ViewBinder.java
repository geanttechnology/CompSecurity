// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

// Referenced classes of package com.bitstrips.imoji.ui:
//            BitshopActivity

public class 
    implements butterknife.ViewBinder
{

    public void bind(butterknife.ViewBinder viewbinder, BitshopActivity bitshopactivity, Object obj)
    {
        bitshopactivity.mPackListView = (RecyclerView)viewbinder.PackListView((View)viewbinder.redView(obj, 0x7f0b0084, "field 'mPackListView'"), 0x7f0b0084, "field 'mPackListView'");
        bitshopactivity.toolbar = (Toolbar)viewbinder.oolbar((View)viewbinder.redView(obj, 0x7f0b0074, "field 'toolbar'"), 0x7f0b0074, "field 'toolbar'");
    }

    public volatile void bind(butterknife.ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (BitshopActivity)obj, obj1);
    }

    public void unbind(BitshopActivity bitshopactivity)
    {
        bitshopactivity.mPackListView = null;
        bitshopactivity.toolbar = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((BitshopActivity)obj);
    }

    public ()
    {
    }
}
