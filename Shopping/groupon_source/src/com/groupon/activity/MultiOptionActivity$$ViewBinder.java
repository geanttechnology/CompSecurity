// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.groupon.util.GrouponNavigationDrawerActivity;

// Referenced classes of package com.groupon.activity:
//            MultiOptionActivity, GrouponFragmentActivity

public class der extends der
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponFragmentActivity grouponfragmentactivity, Object obj)
    {
        bind(ewbinder, (MultiOptionActivity)grouponfragmentactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, MultiOptionActivity multioptionactivity, Object obj)
    {
        super.bind(ewbinder, multioptionactivity, obj);
        multioptionactivity.optionsListView = (ListView)ewbinder.ionsListView((View)ewbinder.iew(obj, 0x7f10041b, "field 'optionsListView'"), 0x7f10041b, "field 'optionsListView'");
        multioptionactivity.loadingView = (ProgressBar)ewbinder.dingView((View)ewbinder.iew(obj, 0x7f100173, "field 'loadingView'"), 0x7f100173, "field 'loadingView'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponNavigationDrawerActivity grouponnavigationdraweractivity, Object obj)
    {
        bind(ewbinder, (MultiOptionActivity)grouponnavigationdraweractivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (MultiOptionActivity)obj, obj1);
    }

    public volatile void unbind(GrouponFragmentActivity grouponfragmentactivity)
    {
        unbind((MultiOptionActivity)grouponfragmentactivity);
    }

    public void unbind(MultiOptionActivity multioptionactivity)
    {
        super.unbind(multioptionactivity);
        multioptionactivity.optionsListView = null;
        multioptionactivity.loadingView = null;
    }

    public volatile void unbind(GrouponNavigationDrawerActivity grouponnavigationdraweractivity)
    {
        unbind((MultiOptionActivity)grouponnavigationdraweractivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((MultiOptionActivity)obj);
    }

    public der()
    {
    }
}
