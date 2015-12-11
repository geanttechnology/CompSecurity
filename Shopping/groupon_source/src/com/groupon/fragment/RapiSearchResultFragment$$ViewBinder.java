// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.widget.TextView;
import com.groupon.view.HeaderToggle;

// Referenced classes of package com.groupon.fragment:
//            RapiSearchResultFragment

public class 
    implements butterknife.ewBinder
{

    public void bind(butterknife.ewBinder ewbinder, RapiSearchResultFragment rapisearchresultfragment, Object obj)
    {
        rapisearchresultfragment.headerToggle = (HeaderToggle)ewbinder.derToggle((View)ewbinder.derToggle(obj, 0x7f1004a6, "field 'headerToggle'"), 0x7f1004a6, "field 'headerToggle'");
        rapisearchresultfragment.dateTimeHeader = (TextView)ewbinder.eTimeHeader((View)ewbinder.eTimeHeader(obj, 0x7f1004a7, "field 'dateTimeHeader'"), 0x7f1004a7, "field 'dateTimeHeader'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (RapiSearchResultFragment)obj, obj1);
    }

    public void unbind(RapiSearchResultFragment rapisearchresultfragment)
    {
        rapisearchresultfragment.headerToggle = null;
        rapisearchresultfragment.dateTimeHeader = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((RapiSearchResultFragment)obj);
    }

    public ()
    {
    }
}
