// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.groupon.activity:
//            PoGWebview, BaseWebViewActivity, GrouponActivity

public class ewBinder extends ewBinder
{

    public volatile void bind(butterknife.ewBinder ewbinder, BaseWebViewActivity basewebviewactivity, Object obj)
    {
        bind(ewbinder, (PoGWebview)basewebviewactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (PoGWebview)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, PoGWebview pogwebview, Object obj)
    {
        super.bind(ewbinder, pogwebview, obj);
        pogwebview.closeButton = (ImageView)ewbinder.View((View)ewbinder.RequiredView(obj, 0x7f100214, "field 'closeButton'"), 0x7f100214, "field 'closeButton'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (PoGWebview)obj, obj1);
    }

    public volatile void unbind(BaseWebViewActivity basewebviewactivity)
    {
        unbind((PoGWebview)basewebviewactivity);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((PoGWebview)grouponactivity);
    }

    public void unbind(PoGWebview pogwebview)
    {
        super.unbind(pogwebview);
        pogwebview.closeButton = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((PoGWebview)obj);
    }

    public ewBinder()
    {
    }
}
