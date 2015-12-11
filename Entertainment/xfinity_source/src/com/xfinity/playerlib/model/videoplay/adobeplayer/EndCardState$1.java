// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.content.DialogInterface;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            EndCardState, QuitState, VideoStateController

class this._cls0
    implements android.content..OnClickListener
{

    final EndCardState this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
        stateController.transitionToState(new QuitState(stateController));
    }

    oller()
    {
        this$0 = EndCardState.this;
        super();
    }
}
