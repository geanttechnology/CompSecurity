// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.media.MediaPlayer;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            af, m

class a
    implements android.media.Player.OnCompletionListener
{

    final af a;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        a.f = a.g;
        if (!a.a.a && !af.a(a))
        {
            if (a.c != null)
            {
                a.c.a();
            }
            if (a.e != null)
            {
                a.e.q();
            }
        }
        af.a(a, false);
        af.b(a, false);
    }

    ner(af af1)
    {
        a = af1;
        super();
    }
}
