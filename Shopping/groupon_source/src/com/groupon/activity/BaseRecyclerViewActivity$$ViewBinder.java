// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.groupon.activity:
//            BaseRecyclerViewActivity, GrouponActivity

public class  extends 
{

    public void bind(butterknife.ewBinder ewbinder, BaseRecyclerViewActivity baserecyclerviewactivity, Object obj)
    {
        super.(ewbinder, baserecyclerviewactivity, obj);
        baserecyclerviewactivity.scrollableContent = (ViewGroup)ewbinder.ollableContent((View)ewbinder.ollableContent(obj, 0x7f1000da, "field 'scrollableContent'"), 0x7f1000da, "field 'scrollableContent'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (BaseRecyclerViewActivity)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (BaseRecyclerViewActivity)obj, obj1);
    }

    public void unbind(BaseRecyclerViewActivity baserecyclerviewactivity)
    {
        super.bind(baserecyclerviewactivity);
        baserecyclerviewactivity.scrollableContent = null;
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((BaseRecyclerViewActivity)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((BaseRecyclerViewActivity)obj);
    }

    public ()
    {
    }
}
