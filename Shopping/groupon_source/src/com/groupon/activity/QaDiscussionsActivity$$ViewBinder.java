// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;

// Referenced classes of package com.groupon.activity:
//            QaDiscussionsActivity, GrouponActivity

public class  extends 
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (QaDiscussionsActivity)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, QaDiscussionsActivity qadiscussionsactivity, Object obj)
    {
        super.bind(ewbinder, qadiscussionsactivity, obj);
        qadiscussionsactivity.qaDiscussionsView = (WebView)ewbinder.iscussionsView((View)ewbinder.w(obj, 0x7f1004a2, "field 'qaDiscussionsView'"), 0x7f1004a2, "field 'qaDiscussionsView'");
        qadiscussionsactivity.loading = (ProgressBar)ewbinder.ding((View)ewbinder.w(obj, 0x7f1000df, "field 'loading'"), 0x7f1000df, "field 'loading'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (QaDiscussionsActivity)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((QaDiscussionsActivity)grouponactivity);
    }

    public void unbind(QaDiscussionsActivity qadiscussionsactivity)
    {
        super.(qadiscussionsactivity);
        qadiscussionsactivity.qaDiscussionsView = null;
        qadiscussionsactivity.loading = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((QaDiscussionsActivity)obj);
    }

    public ()
    {
    }
}
