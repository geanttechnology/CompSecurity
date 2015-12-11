// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.nav;

import android.util.Log;
import com.amazon.mobile.mash.MASHWebView;
import com.amazon.mobile.mash.api.MASHNavigationPlugin;
import java.util.List;
import org.apache.cordova.CordovaWebView;

// Referenced classes of package com.amazon.mobile.mash.nav:
//            MASHNavHandler, MASHNavOperation, MASHNavUtils, MASHNavException

public class MASHNavBackHandler extends MASHNavHandler
{

    public MASHNavBackHandler(MASHNavigationPlugin mashnavigationplugin, List list, int i)
    {
        super(mashnavigationplugin, list, i);
    }

    public void navigate()
    {
        if (getNextOperation() != null && ("replace".equals(getNextOperation().getOperation()) || "forward".equals(getNextOperation().getOperation())))
        {
            return;
        }
        MASHNavigationPlugin mashnavigationplugin = getMASHNavigationPlugin();
        int i = MASHNavUtils.computeBackAmount((MASHWebView)mashnavigationplugin.webView, getCurrentOperation());
        if (i == -1)
        {
            Log.e("MASHNavBackHandler", (new StringBuilder()).append("MASH API can not do operation ").append(getCurrentOperation().getOperation()).toString());
            throw new MASHNavException((new StringBuilder()).append("Not able to do op. ").append(getCurrentOperation().getOperation()).toString());
        } else
        {
            mashnavigationplugin.webView.goBackOrForward(0 - i);
            return;
        }
    }
}
