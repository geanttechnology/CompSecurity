// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.content.DialogInterface;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            MobileDataWarningState, QuitState, VideoStateController

class this._cls0
    implements android.content.istener
{

    final MobileDataWarningState this$0;

    public void onCancel(DialogInterface dialoginterface)
    {
        stateController.transitionToState(new QuitState(stateController));
    }

    ()
    {
        this$0 = MobileDataWarningState.this;
        super();
    }
}
