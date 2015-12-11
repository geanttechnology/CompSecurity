// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.content.DialogInterface;
import android.view.KeyEvent;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment

class this._cls1
    implements android.content.layerUIController._cls11
{

    final ssed this$1;

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        return onVolumeHardwareKeyPressed(i);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
