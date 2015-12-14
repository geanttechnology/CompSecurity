// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.view.View;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.EnvironmentUtils;

// Referenced classes of package com.millennialmedia.internal:
//            JSBridge, MMWebView

class this._cls0
    implements android.view.utChangeListener
{

    final JSBridge this$0;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        if (view instanceof MMWebView)
        {
            i = EnvironmentUtils.getCurrentConfigOrientation();
            if (lastOrientation != i)
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("Detected change in orientation to ").append(EnvironmentUtils.getCurrentConfigOrientationString()).toString());
                }
                lastOrientation = i;
                sendPositions((MMWebView)view);
            }
        }
    }

    onmentUtils()
    {
        this$0 = JSBridge.this;
        super();
    }
}
