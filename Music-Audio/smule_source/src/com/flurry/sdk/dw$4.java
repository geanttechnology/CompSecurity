// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.media.MediaPlayer;
import android.net.Uri;

// Referenced classes of package com.flurry.sdk:
//            dw, dz

class it>
    implements android.media.Player.OnCompletionListener
{

    final dw a;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        dw.a(a, g);
        if (dw.b(a) != null)
        {
            dw.b(a).b(dw.d(a).toString());
        }
    }

    layer(dw dw1)
    {
        a = dw1;
        super();
    }
}
