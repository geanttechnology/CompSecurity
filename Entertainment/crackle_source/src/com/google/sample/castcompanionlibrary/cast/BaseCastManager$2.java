// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast;

import com.google.sample.castcompanionlibrary.utils.LogUtils;

// Referenced classes of package com.google.sample.castcompanionlibrary.cast:
//            BaseCastManager

class this._cls0
    implements Runnable
{

    final BaseCastManager this$0;

    public void run()
    {
        BaseCastManager basecastmanager = BaseCastManager.this;
        int i = basecastmanager.mVisibilityCounter - 1;
        basecastmanager.mVisibilityCounter = i;
        if (i == 0)
        {
            LogUtils.LOGD(BaseCastManager.access$000(), "UI is no longer visible");
            if (mUiVisible)
            {
                mUiVisible = false;
                onUiVisibilityChanged(false);
            }
            return;
        } else
        {
            LogUtils.LOGD(BaseCastManager.access$000(), "UI is visible");
            return;
        }
    }

    ()
    {
        this$0 = BaseCastManager.this;
        super();
    }
}
