// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.nav;

import android.util.Log;
import com.amazon.mobile.mash.MASHWebView;
import com.amazon.mobile.mash.api.MASHNavigationPlugin;
import java.util.List;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mobile.mash.nav:
//            MASHNavHandler, MASHNavOperation, MASHNavUtils, MASHNavInterface, 
//            MASHNavException

public class MASHNavReplaceHandler extends MASHNavHandler
{

    public static final String TAG = "MASHNavReplaceHandler";

    public MASHNavReplaceHandler(MASHNavigationPlugin mashnavigationplugin, List list, int i)
    {
        super(mashnavigationplugin, list, i);
    }

    public void navigate()
    {
        MASHNavigationPlugin mashnavigationplugin = getMASHNavigationPlugin();
        MASHWebView mashwebview = (MASHWebView)mashnavigationplugin.webView;
        if (getPreOperation() != null && getPreOperation().getOperation().startsWith("back"))
        {
            int i = MASHNavUtils.computeBackAmount(mashwebview, getPreOperation());
            if (mashwebview.canGoBackOrForward(0 - i - 1))
            {
                MASHNavUtils.goBackAndForward(mashwebview, i + 1, getCurrentOperation().getRequest());
                return;
            }
            if (mashwebview.canGoBackOrForward(0 - i))
            {
                ((MASHNavInterface)mashnavigationplugin.cordova.getActivity()).replaceRootWebViewWithNewUrl(mashwebview, getCurrentOperation().getRequest());
                return;
            } else
            {
                Log.e("MASHNavReplaceHandler", (new StringBuilder()).append("MASH API can not do operation ").append(getPreOperation().getOperation()).toString());
                throw new MASHNavException((new StringBuilder()).append("Not able to do op. ").append(getPreOperation().getOperation()).toString());
            }
        }
        if (mashwebview.canGoBackOrForward(-1))
        {
            MASHNavUtils.goBackAndForward(mashwebview, 1, getCurrentOperation().getRequest());
            return;
        } else
        {
            ((MASHNavInterface)mashnavigationplugin.cordova.getActivity()).replaceRootWebViewWithNewUrl(mashwebview, getCurrentOperation().getRequest());
            return;
        }
    }
}
