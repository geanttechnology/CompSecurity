// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.media.MediaPlayer;
import android.widget.FrameLayout;

// Referenced classes of package com.jirbo.adcolony:
//            e

final class 
    implements android.media.aPlayer.OnCompletionListener
{

    final e a;

    public final void onCompletion(MediaPlayer mediaplayer)
    {
        a.setContentView(a.K);
        a.M.removeAllViews();
        e.f = false;
    }

    er(e e1)
    {
        a = e1;
        super();
    }
}
