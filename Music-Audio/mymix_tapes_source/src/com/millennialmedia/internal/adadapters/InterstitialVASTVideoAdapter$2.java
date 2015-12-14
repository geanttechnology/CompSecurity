// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adadapters;

import com.millennialmedia.internal.MMActivity;
import com.millennialmedia.internal.adcontrollers.VASTVideoController;

// Referenced classes of package com.millennialmedia.internal.adadapters:
//            InterstitialVASTVideoAdapter

class this._cls0 extends com.millennialmedia.internal.oAdapter._cls2
{

    final InterstitialVASTVideoAdapter this$0;

    public boolean onBackPressed()
    {
        return InterstitialVASTVideoAdapter.access$100(InterstitialVASTVideoAdapter.this).onBackPressed();
    }

    public void onCreate(MMActivity mmactivity)
    {
        InterstitialVASTVideoAdapter.access$100(InterstitialVASTVideoAdapter.this).attach(mmactivity);
    }

    public void onDestroy(MMActivity mmactivity)
    {
        if (mmactivity.isFinishing())
        {
            InterstitialVASTVideoAdapter.access$100(InterstitialVASTVideoAdapter.this).shutdown();
            adapterListener.onClosed();
        }
    }

    lAdapterListener()
    {
        this$0 = InterstitialVASTVideoAdapter.this;
        super();
    }
}
