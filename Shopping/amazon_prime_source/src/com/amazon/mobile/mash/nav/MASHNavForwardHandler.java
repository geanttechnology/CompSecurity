// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.nav;

import android.util.Log;
import com.amazon.mobile.mash.MASHWebView;
import com.amazon.mobile.mash.api.MASHNavigationPlugin;
import java.util.List;

// Referenced classes of package com.amazon.mobile.mash.nav:
//            MASHNavHandler, MASHNavOperation, MASHNavUtils, MASHNavException

public class MASHNavForwardHandler extends MASHNavHandler
{

    public static final String TAG = "MASHNavForwardHandler";

    public MASHNavForwardHandler(MASHNavigationPlugin mashnavigationplugin, List list, int i)
    {
        super(mashnavigationplugin, list, i);
    }

    public void navigate()
    {
        MASHWebView mashwebview = (MASHWebView)getMASHNavigationPlugin().webView;
        if (getPreOperation() != null && getPreOperation().getOperation().startsWith("back"))
        {
            int i = MASHNavUtils.computeBackAmount(mashwebview, getPreOperation());
            if (mashwebview.canGoBackOrForward(0 - i))
            {
                MASHNavUtils.goBackAndForward(mashwebview, i, getCurrentOperation().getRequest());
                return;
            } else
            {
                Log.e("MASHNavForwardHandler", (new StringBuilder()).append("MASH API can not do operation ").append(getPreOperation().getOperation()).toString());
                throw new MASHNavException((new StringBuilder()).append("Not able to do op. ").append(getPreOperation().getOperation()).toString());
            }
        } else
        {
            MASHNavUtils.issuePageRequest(mashwebview, getCurrentOperation().getRequest());
            return;
        }
    }
}
