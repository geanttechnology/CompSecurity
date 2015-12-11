// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.b;

import android.media.MediaPlayer;
import android.widget.ImageButton;

// Referenced classes of package com.mopub.b:
//            h

final class 
    implements android.media.aPlayer.OnErrorListener
{

    final h a;

    public final boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        a.d.setVisibility(0);
        a.h();
        return false;
    }

    diaPlayer(h h1)
    {
        a = h1;
        super();
    }
}
