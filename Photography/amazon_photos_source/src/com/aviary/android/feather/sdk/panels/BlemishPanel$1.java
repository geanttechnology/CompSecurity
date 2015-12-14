// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.os.Message;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            BlemishPanel

class this._cls0
    implements android.os.k
{

    final BlemishPanel this$0;

    public boolean handleMessage(Message message)
    {
        message.what;
        JVM INSTR lookupswitch 3: default 40
    //                   4: 42
    //                   5: 52
    //                   12: 62;
           goto _L1 _L2 _L3 _L4
_L1:
        return false;
_L2:
        onProgressStart();
        continue; /* Loop/switch isn't completed */
_L3:
        onProgressEnd();
        continue; /* Loop/switch isn't completed */
_L4:
        if (isActive() && mImageView != null)
        {
            mImageView.postInvalidate();
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    ()
    {
        this$0 = BlemishPanel.this;
        super();
    }
}
