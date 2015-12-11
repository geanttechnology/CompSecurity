// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.vlc.service;

import com.target.ui.vlc.c;
import com.target.ui.vlc.d;

// Referenced classes of package com.target.ui.vlc.service:
//            VlcService, b

class val.vlcListener
    implements Runnable
{

    final this._cls1 this$1;
    final c val$vlcListener;
    final d val$vlcParams;

    public void run()
    {
        if (val.vlcListener(this._cls1.this))
        {
            com.target.ui.vlc.service.this._mth1(this._cls1.this, com.target.ui.vlc.service.this._mth1(this._cls1.this, val$vlcParams, val$vlcListener));
            val.vlcListener(this._cls1.this).a(val$vlcParams.siteInfo);
        }
        val.vlcParams(this._cls1.this, false);
    }

    ()
    {
        this$1 = final_;
        val$vlcParams = d1;
        val$vlcListener = c.this;
        super();
    }
}
