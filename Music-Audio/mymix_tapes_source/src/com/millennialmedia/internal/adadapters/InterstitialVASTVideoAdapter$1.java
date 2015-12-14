// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adadapters;


// Referenced classes of package com.millennialmedia.internal.adadapters:
//            InterstitialVASTVideoAdapter

class this._cls0
    implements com.millennialmedia.internal.adcontrollers.ntrollerListener
{

    final InterstitialVASTVideoAdapter this$0;

    public void attachFailed()
    {
        if (!InterstitialVASTVideoAdapter.access$000(InterstitialVASTVideoAdapter.this))
        {
            adapterListener.showFailed(new com.millennialmedia.rStatus(7));
        }
    }

    public void attachSucceeded()
    {
        if (!InterstitialVASTVideoAdapter.access$000(InterstitialVASTVideoAdapter.this))
        {
            InterstitialVASTVideoAdapter.access$002(InterstitialVASTVideoAdapter.this, true);
            adapterListener.shown();
        }
    }

    public void initFailed()
    {
        adapterListener.initFailed();
    }

    public void initSucceeded()
    {
        adapterListener.initSucceeded();
    }

    public void onClick()
    {
        adapterListener.onClicked();
    }

    lAdapterListener()
    {
        this$0 = InterstitialVASTVideoAdapter.this;
        super();
    }
}
