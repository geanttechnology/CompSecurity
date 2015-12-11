// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.view.ViewStub;

// Referenced classes of package com.groupon.fragment:
//            Coupons

public class 
    implements butterknife.er
{

    public void bind(butterknife.ewBinder ewbinder, Coupons coupons, Object obj)
    {
        coupons.viewStub = (ViewStub)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f1001ea, "field 'viewStub'"), 0x7f1001ea, "field 'viewStub'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (Coupons)obj, obj1);
    }

    public void unbind(Coupons coupons)
    {
        coupons.viewStub = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((Coupons)obj);
    }

    public ()
    {
    }
}
