// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.view.KeyEvent;
import android.view.View;

// Referenced classes of package com.amazon.device.ads:
//            MraidDisplayController

class this._cls0
    implements android.view.roller._cls3
{

    final MraidDisplayController this$0;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (i == 4 && keyevent.getRepeatCount() == 0)
        {
            close();
            return true;
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = MraidDisplayController.this;
        super();
    }
}
