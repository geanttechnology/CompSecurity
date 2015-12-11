// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.media.MediaPlayer;
import android.widget.FrameLayout;

// Referenced classes of package com.jirbo.adcolony:
//            e

final class 
    implements android.media.aPlayer.OnPreparedListener
{

    final e a;

    public final void onPrepared(MediaPlayer mediaplayer)
    {
        a.M.removeViewAt(1);
    }

    er(e e1)
    {
        a = e1;
        super();
    }
}
