// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.view.View;
import com.mopub.common.UrlAction;

// Referenced classes of package com.mopub.nativeads:
//            NativeResponse, SpinningProgressView

class iew
    implements com.mopub.common.Actions
{

    final NativeResponse this$0;
    final SpinningProgressView val$spinningProgressView;
    final View val$view;

    private void removeSpinningProgressView()
    {
        if (val$view != null)
        {
            val$spinningProgressView.removeFromRoot();
        }
    }

    public void urlHandlingFailed(String s, UrlAction urlaction)
    {
        removeSpinningProgressView();
    }

    public void urlHandlingSucceeded(String s, UrlAction urlaction)
    {
        removeSpinningProgressView();
    }

    iew()
    {
        this$0 = final_nativeresponse;
        val$view = view1;
        val$spinningProgressView = SpinningProgressView.this;
        super();
    }
}
