// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.os.Handler;
import android.view.View;

// Referenced classes of package com.apprupt.sdk:
//            CvCloseButton

class this._cls0
    implements android.view.ener
{

    final CvCloseButton this$0;

    public void onClick(View view)
    {
    /* block-local class not found */
    class _cls1 {}

        CvCloseButton.access$100(CvCloseButton.this).post(new _cls1());
    }

    _cls1()
    {
        this$0 = CvCloseButton.this;
        super();
    }
}
