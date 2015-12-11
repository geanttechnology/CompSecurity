// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.content.DialogInterface;
import com.xfinity.playerlib.model.videoplay.adobeplayer.VideoStateController;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment

class this._cls1
    implements android.content.PlayerUIController._cls9
{

    final nceled this$1;

    public void onCancel(DialogInterface dialoginterface)
    {
        VideoPlayerFragment.access$400().debug("Pinpad canceled");
        VideoPlayerFragment.access$500(_fld0).onPinCanceled();
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
