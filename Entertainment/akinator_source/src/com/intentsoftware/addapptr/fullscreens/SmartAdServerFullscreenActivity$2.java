// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.intentsoftware.addapptr.fullscreens;

import com.smartadserver.android.library.SASBannerView;

// Referenced classes of package com.intentsoftware.addapptr.fullscreens:
//            SmartAdServerFullscreenActivity

class this._cls0
    implements com.smartadserver.android.library.ui.._cls2
{

    final SmartAdServerFullscreenActivity this$0;

    public void onStateChanged(com.smartadserver.android.library.ui.._cls2 _pcls2)
    {
        if (_pcls2.() == 2)
        {
            SmartAdServerFullscreenActivity.access$000(SmartAdServerFullscreenActivity.this).close();
            SmartAdServerFullscreenActivity.access$202(SmartAdServerFullscreenActivity.this, true);
            SmartAdServerFullscreenActivity.access$100(SmartAdServerFullscreenActivity.this);
        }
    }

    ()
    {
        this$0 = SmartAdServerFullscreenActivity.this;
        super();
    }
}
