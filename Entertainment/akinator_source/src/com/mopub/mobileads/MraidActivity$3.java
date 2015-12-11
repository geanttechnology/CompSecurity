// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


// Referenced classes of package com.mopub.mobileads:
//            MraidActivity

class this._cls0
    implements com.mopub.mraid.UseCustomCloseListener
{

    final MraidActivity this$0;

    public void useCustomCloseChanged(boolean flag)
    {
        if (flag)
        {
            hideInterstitialCloseButton();
            return;
        } else
        {
            showInterstitialCloseButton();
            return;
        }
    }

    ustomCloseListener()
    {
        this$0 = MraidActivity.this;
        super();
    }
}
