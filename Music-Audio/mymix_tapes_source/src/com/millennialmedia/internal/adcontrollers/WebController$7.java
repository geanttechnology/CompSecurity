// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adcontrollers;

import com.millennialmedia.MMLog;
import com.millennialmedia.internal.MMWebView;
import com.millennialmedia.internal.SizableStateManager;
import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.internal.adcontrollers:
//            WebController

class val.sizableStateManagerRef
    implements Runnable
{

    final WebController this$0;
    final com.millennialmedia.internal.ger.ExpandParams val$expandParams;
    final WeakReference val$sizableStateManagerRef;
    final WeakReference val$twoPartWebViewRef;

    public void run()
    {
        WebController.access$300(WebController.this).showLoadingSpinner(val$expandParams);
        ThreadUtils.runOnUiThread(new Runnable() {

            final WebController._cls7 this$1;
            final com.millennialmedia.internal.utils.HttpUtils.Response val$response;

            public void run()
            {
                MMWebView mmwebview = (MMWebView)twoPartWebViewRef.get();
                if (mmwebview != null) goto _L2; else goto _L1
_L1:
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(WebController.access$200(), "Expanded web view is no longer valid");
                }
_L4:
                return;
_L2:
                SizableStateManager sizablestatemanager;
                sizablestatemanager = (SizableStateManager)sizableStateManagerRef.get();
                if (sizablestatemanager != null)
                {
                    break; /* Loop/switch isn't completed */
                }
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(WebController.access$200(), "Sizing container is no longer valid");
                    return;
                }
                if (true) goto _L4; else goto _L3
_L3:
                if (!sizablestatemanager.isExpanded())
                {
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(WebController.access$200(), "Sizing container has been collapsed");
                        return;
                    }
                } else
                {
                    sizablestatemanager.hideLoadingSpinner(expandParams);
                    if (response != null && response.code == 200 && response.content != null)
                    {
                        mmwebview.setContent(response.content);
                    } else
                    {
                        MMLog.e(WebController.access$200(), "Unable to retrieve expanded content");
                        sizablestatemanager.showCloseIndicator(true);
                    }
                    mmwebview.setVisibility(0);
                    return;
                }
                if (true) goto _L4; else goto _L5
_L5:
            }

            
            {
                this$1 = WebController._cls7.this;
                response = response1;
                super();
            }
        });
    }

    ms()
    {
        this$0 = final_webcontroller;
        val$expandParams = expandparams;
        val$twoPartWebViewRef = weakreference;
        val$sizableStateManagerRef = WeakReference.this;
        super();
    }
}
