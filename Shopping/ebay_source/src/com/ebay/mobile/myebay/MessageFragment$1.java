// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.ebay.mobile.myebay:
//            MessageFragment

class this._cls0
    implements android.view.er
{

    final MessageFragment this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        int i = motionevent.getActionMasked();
        if (i == 0 || i == 1 || i == 3)
        {
            notifyPaneActivated(nt.ActivePane.MESSAGES_DETAIL);
        }
        return false;
    }

    nt.ActivePane()
    {
        this$0 = MessageFragment.this;
        super();
    }
}
