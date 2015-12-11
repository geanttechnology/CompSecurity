// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.content.DialogInterface;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            ErrorState, QuitState, VideoStateController

class this._cls0
    implements android.content.ce.OnDismissListener
{

    final ErrorState this$0;

    public void onDismiss(DialogInterface dialoginterface)
    {
        ErrorState.access$200(ErrorState.this).transitionToState(new QuitState(ErrorState.access$200(ErrorState.this)));
    }

    troller()
    {
        this$0 = ErrorState.this;
        super();
    }
}
