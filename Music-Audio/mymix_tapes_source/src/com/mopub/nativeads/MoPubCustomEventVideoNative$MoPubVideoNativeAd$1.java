// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import java.util.List;

// Referenced classes of package com.mopub.nativeads:
//            MoPubCustomEventVideoNative

class this._cls0
    implements this._cls0
{

    final this._cls0 this$0;

    public void onVisibilityChanged(List list, List list1)
    {
        if (!list.isEmpty() && !cess._mth000(this._cls0.this))
        {
            cess._mth002(this._cls0.this, true);
            cess._mth100(this._cls0.this);
        } else
        if (!list1.isEmpty() && cess._mth000(this._cls0.this))
        {
            cess._mth002(this._cls0.this, false);
            cess._mth100(this._cls0.this);
            return;
        }
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
