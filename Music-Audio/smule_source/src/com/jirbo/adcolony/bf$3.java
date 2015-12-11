// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.media.MediaPlayer;
import android.widget.MediaController;

// Referenced classes of package com.jirbo.adcolony:
//            bf

class a
    implements android.media.Player.OnCompletionListener
{

    final bf a;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        a.e = 5;
        a.f = 5;
        if (a.m != null)
        {
            a.m.hide();
        }
        if (a.n != null)
        {
            a.n.onCompletion(a.h);
        }
    }

    r(bf bf1)
    {
        a = bf1;
        super();
    }
}
