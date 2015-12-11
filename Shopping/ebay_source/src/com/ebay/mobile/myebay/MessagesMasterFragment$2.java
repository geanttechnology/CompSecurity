// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.ebay.mobile.myebay:
//            MessagesMasterFragment

class this._cls0
    implements android.view.ragment._cls2
{

    final MessagesMasterFragment this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1 && !isDraftInProgress())
        {
            notifyPaneActivated(vePane.MESSAGES_MASTER);
        }
        return false;
    }

    vePane()
    {
        this$0 = MessagesMasterFragment.this;
        super();
    }
}
