// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.ui;

import com.targetspot.android.sdk.service.AdBreak;

// Referenced classes of package com.targetspot.android.sdk.ui:
//            AdPopup

class val.pos
    implements Runnable
{

    final AdPopup this$0;
    final AdBreak val$adBreak;
    final int val$pos;
    final boolean val$preRoll;

    public void run()
    {
        showPopup(val$preRoll, val$adBreak, val$pos);
    }

    ak()
    {
        this$0 = final_adpopup;
        val$preRoll = flag;
        val$adBreak = adbreak;
        val$pos = I.this;
        super();
    }
}
