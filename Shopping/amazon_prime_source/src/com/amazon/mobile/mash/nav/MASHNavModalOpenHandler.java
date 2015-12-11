// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.nav;

import android.content.Intent;
import com.amazon.mobile.mash.api.MASHNavigationPlugin;
import com.amazon.mobile.mash.constants.WebConstants;
import java.util.List;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mobile.mash.nav:
//            MASHNavHandler, MASHNavInterface, MASHNavOperation

public class MASHNavModalOpenHandler extends MASHNavHandler
{

    public MASHNavModalOpenHandler(MASHNavigationPlugin mashnavigationplugin, List list, int i)
    {
        super(mashnavigationplugin, list, i);
    }

    public void navigate()
    {
        MASHNavigationPlugin mashnavigationplugin = getMASHNavigationPlugin();
        Object obj = (MASHNavInterface)mashnavigationplugin.cordova.getActivity();
        obj = new Intent(mashnavigationplugin.cordova.getActivity(), ((MASHNavInterface) (obj)).getModalActivityClass());
        ((Intent) (obj)).putExtra(WebConstants.getWebViewUrlKey(), getCurrentOperation().getRequest().getUrl());
        mashnavigationplugin.cordova.startActivityForResult(mashnavigationplugin, ((Intent) (obj)), 10003);
    }
}
