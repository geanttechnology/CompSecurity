// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.view.View;
import com.mopub.common.UrlAction;

// Referenced classes of package com.mopub.nativeads:
//            NativeClickHandler, SpinningProgressView

class val.spinningProgressView
    implements com.mopub.common.ons
{

    final NativeClickHandler this$0;
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
        NativeClickHandler.access$002(NativeClickHandler.this, false);
    }

    public void urlHandlingSucceeded(String s, UrlAction urlaction)
    {
        removeSpinningProgressView();
        NativeClickHandler.access$002(NativeClickHandler.this, false);
    }

    ()
    {
        this$0 = final_nativeclickhandler;
        val$view = view1;
        val$spinningProgressView = SpinningProgressView.this;
        super();
    }
}
