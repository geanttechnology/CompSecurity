// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.content.DialogInterface;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            StartState, QuitState

class this._cls0
    implements android.content.ce.OnCancelListener
{

    final StartState this$0;

    public void onCancel(DialogInterface dialoginterface)
    {
        transitionToState(new QuitState(stateController));
    }

    ()
    {
        this$0 = StartState.this;
        super();
    }
}
