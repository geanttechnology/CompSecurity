// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

// Referenced classes of package com.groupon.activity:
//            BaseWebViewActivity, GrouponActivity

public class  extends 
{

    public void bind(butterknife.ewBinder ewbinder, BaseWebViewActivity basewebviewactivity, Object obj)
    {
        super.(ewbinder, basewebviewactivity, obj);
        basewebviewactivity.progressBar = (ProgressBar)ewbinder.gressBar((View)ewbinder.iew(obj, 0x7f1000df, "field 'progressBar'"), 0x7f1000df, "field 'progressBar'");
        basewebviewactivity.webViewPlaceholder = (FrameLayout)ewbinder.ViewPlaceholder((View)ewbinder.iew(obj, 0x7f1000de, "field 'webViewPlaceholder'"), 0x7f1000de, "field 'webViewPlaceholder'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (BaseWebViewActivity)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (BaseWebViewActivity)obj, obj1);
    }

    public void unbind(BaseWebViewActivity basewebviewactivity)
    {
        super.nd(basewebviewactivity);
        basewebviewactivity.progressBar = null;
        basewebviewactivity.webViewPlaceholder = null;
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((BaseWebViewActivity)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((BaseWebViewActivity)obj);
    }

    public ()
    {
    }
}
