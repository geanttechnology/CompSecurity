// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.media.MediaPlayer;
import android.widget.FrameLayout;

// Referenced classes of package com.jirbo.adcolony:
//            o

class 
    implements android.media.aPlayer.OnPreparedListener
{

    final o a;

    public void onPrepared(MediaPlayer mediaplayer)
    {
        a.M.removeViewAt(1);
    }

    er(o o1)
    {
        a = o1;
        super();
    }
}
