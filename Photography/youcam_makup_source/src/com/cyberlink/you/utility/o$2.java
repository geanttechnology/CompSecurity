// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.media.MediaPlayer;

// Referenced classes of package com.cyberlink.you.utility:
//            o

class a
    implements android.media.aPlayer.OnErrorListener
{

    final o a;

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        a.a();
        o.a(a, 2);
        return true;
    }

    rorListener(o o1)
    {
        a = o1;
        super();
    }
}
