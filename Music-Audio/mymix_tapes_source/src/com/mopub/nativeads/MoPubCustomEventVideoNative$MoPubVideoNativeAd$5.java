// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.view.View;

// Referenced classes of package com.mopub.nativeads:
//            MoPubCustomEventVideoNative

class this._cls0
    implements android.view.veAd._cls5
{

    final this._cls0 this$0;

    public void onClick(View view)
    {
        view = this._cls0.this;
        boolean flag;
        if (!cess._mth1100(this._cls0.this))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        cess._mth1102(view, flag);
        cess._mth100(this._cls0.this);
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
