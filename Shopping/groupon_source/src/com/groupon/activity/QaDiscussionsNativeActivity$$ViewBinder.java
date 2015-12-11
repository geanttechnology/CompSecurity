// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.ProgressBar;
import com.groupon.view.GrouponSwipeRefreshLayout;

// Referenced classes of package com.groupon.activity:
//            QaDiscussionsNativeActivity, GrouponListActivity

public class  extends 
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponListActivity grouponlistactivity, Object obj)
    {
        bind(ewbinder, (QaDiscussionsNativeActivity)grouponlistactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, QaDiscussionsNativeActivity qadiscussionsnativeactivity, Object obj)
    {
        super.bind(ewbinder, qadiscussionsnativeactivity, obj);
        qadiscussionsnativeactivity.swipeLayout = (GrouponSwipeRefreshLayout)ewbinder.peLayout((View)ewbinder.peLayout(obj, 0x7f1000db, "field 'swipeLayout'"), 0x7f1000db, "field 'swipeLayout'");
        qadiscussionsnativeactivity.loadingView = (ProgressBar)ewbinder.dingView((View)ewbinder.dingView(obj, 0x7f100173, "field 'loadingView'"), 0x7f100173, "field 'loadingView'");
        qadiscussionsnativeactivity.emptyView = (View)ewbinder.tyView(obj, 0x7f10019f, "field 'emptyView'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (QaDiscussionsNativeActivity)obj, obj1);
    }

    public volatile void unbind(GrouponListActivity grouponlistactivity)
    {
        unbind((QaDiscussionsNativeActivity)grouponlistactivity);
    }

    public void unbind(QaDiscussionsNativeActivity qadiscussionsnativeactivity)
    {
        super.unbind(qadiscussionsnativeactivity);
        qadiscussionsnativeactivity.swipeLayout = null;
        qadiscussionsnativeactivity.loadingView = null;
        qadiscussionsnativeactivity.emptyView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((QaDiscussionsNativeActivity)obj);
    }

    public ()
    {
    }
}
