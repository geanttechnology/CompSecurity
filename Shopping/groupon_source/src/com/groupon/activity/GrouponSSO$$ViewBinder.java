// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.TextView;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.activity:
//            GrouponSSO, GrouponActivity

public class nder extends nder
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (GrouponSSO)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, GrouponSSO grouponsso, Object obj)
    {
        super.bind(ewbinder, grouponsso, obj);
        grouponsso.ssoSignInButton = (SpinnerButton)ewbinder.View((View)ewbinder.RequiredView(obj, 0x7f10036e, "field 'ssoSignInButton'"), 0x7f10036e, "field 'ssoSignInButton'");
        grouponsso.ssoSwitchUserButton = (SpinnerButton)ewbinder.View((View)ewbinder.RequiredView(obj, 0x7f10036f, "field 'ssoSwitchUserButton'"), 0x7f10036f, "field 'ssoSwitchUserButton'");
        grouponsso.viewTerms = (TextView)ewbinder.View((View)ewbinder.RequiredView(obj, 0x7f1002d1, "field 'viewTerms'"), 0x7f1002d1, "field 'viewTerms'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (GrouponSSO)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((GrouponSSO)grouponactivity);
    }

    public void unbind(GrouponSSO grouponsso)
    {
        super.unbind(grouponsso);
        grouponsso.ssoSignInButton = null;
        grouponsso.ssoSwitchUserButton = null;
        grouponsso.viewTerms = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((GrouponSSO)obj);
    }

    public nder()
    {
    }
}
