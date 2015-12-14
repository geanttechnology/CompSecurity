// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.ui;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.LinearLayout;

// Referenced classes of package com.targetspot.android.sdk.ui:
//            AdPopup

class owner extends LinearLayout
{

    AdPopup owner;
    final AdPopup this$0;

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (keyevent.getKeyCode() == 4)
        {
            if (keyevent.getAction() == 0 && keyevent.getRepeatCount() == 0)
            {
                return true;
            }
            if (keyevent.getAction() == 1)
            {
                owner.dismissPopup();
                return true;
            } else
            {
                return super.dispatchKeyEvent(keyevent);
            }
        } else
        {
            return super.dispatchKeyEvent(keyevent);
        }
    }

    (AdPopup adpopup1, Context context)
    {
        this$0 = AdPopup.this;
        super(context);
        owner = adpopup1;
    }
}
