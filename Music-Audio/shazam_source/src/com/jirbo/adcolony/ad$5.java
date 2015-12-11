// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.media.MediaPlayer;

// Referenced classes of package com.jirbo.adcolony:
//            ad

final class a
    implements android.media.Player.OnBufferingUpdateListener
{

    final ad a;

    public final void onBufferingUpdate(MediaPlayer mediaplayer, int i)
    {
        a.p = i;
    }

    r(ad ad1)
    {
        a = ad1;
        super();
    }
}
