// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.webkit.WebView;

// Referenced classes of package com.groupon.activity:
//            FinePrint, GrouponActivity

public class inder extends inder
{

    public void bind(butterknife.ewBinder ewbinder, FinePrint fineprint, Object obj)
    {
        super.bind(ewbinder, fineprint, obj);
        fineprint.finePrint = (WebView)ewbinder.tView((View)ewbinder.dRequiredView(obj, 0x7f10029e, "field 'finePrint'"), 0x7f10029e, "field 'finePrint'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (FinePrint)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (FinePrint)obj, obj1);
    }

    public void unbind(FinePrint fineprint)
    {
        super.unbind(fineprint);
        fineprint.finePrint = null;
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((FinePrint)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((FinePrint)obj);
    }

    public inder()
    {
    }
}
