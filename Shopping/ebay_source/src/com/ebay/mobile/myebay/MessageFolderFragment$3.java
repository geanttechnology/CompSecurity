// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.ebay.mobile.myebay:
//            MessageFolderFragment

class notifyOnMove
    implements android.view.ragment._cls3
{

    private boolean notifyOnMove;
    final MessageFolderFragment this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        int i = motionevent.getActionMasked();
        if (i == 0)
        {
            notifyPaneActivated(ivePane.MESSAGES_DETAIL);
            notifyOnMove = true;
        } else
        if (i == 2 && notifyOnMove)
        {
            notifyPaneActivated(ivePane.MESSAGES_MASTER);
            notifyOnMove = false;
            return false;
        }
        return false;
    }

    ivePane()
    {
        this$0 = MessageFolderFragment.this;
        super();
        notifyOnMove = true;
    }
}
