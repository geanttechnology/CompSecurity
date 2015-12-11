// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.util.GrouponNavigationDrawerActivity;
import com.groupon.view.GrouponListView;

// Referenced classes of package com.groupon.activity:
//            GoodsMultiOption, GrouponFragmentActivity

public class Binder extends Binder
{

    public void bind(butterknife.ewBinder ewbinder, GoodsMultiOption goodsmultioption, Object obj)
    {
        super.bind(ewbinder, goodsmultioption, obj);
        goodsmultioption.listView = (GrouponListView)ewbinder.tView((View)ewbinder.edView(obj, 0x102000a, "field 'listView'"), 0x102000a, "field 'listView'");
        goodsmultioption.progress = (View)ewbinder.edView(obj, 0x7f10010b, "field 'progress'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponFragmentActivity grouponfragmentactivity, Object obj)
    {
        bind(ewbinder, (GoodsMultiOption)grouponfragmentactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponNavigationDrawerActivity grouponnavigationdraweractivity, Object obj)
    {
        bind(ewbinder, (GoodsMultiOption)grouponnavigationdraweractivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (GoodsMultiOption)obj, obj1);
    }

    public void unbind(GoodsMultiOption goodsmultioption)
    {
        super.unbind(goodsmultioption);
        goodsmultioption.listView = null;
        goodsmultioption.progress = null;
    }

    public volatile void unbind(GrouponFragmentActivity grouponfragmentactivity)
    {
        unbind((GoodsMultiOption)grouponfragmentactivity);
    }

    public volatile void unbind(GrouponNavigationDrawerActivity grouponnavigationdraweractivity)
    {
        unbind((GoodsMultiOption)grouponnavigationdraweractivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((GoodsMultiOption)obj);
    }

    public Binder()
    {
    }
}
