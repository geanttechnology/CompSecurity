// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.media.MediaPlayer;
import android.net.Uri;

// Referenced classes of package com.flurry.sdk:
//            dw, gd, av, dz

class it>
    implements android.media.Player.OnErrorListener
{

    final dw a;

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        gd.a(5, dw.f(), (new StringBuilder()).append("Error: ").append(dw.d(a)).append(" framework_err ").append(i).append(" impl_err ").append(j).toString());
        dw.a(a, i);
        if (dw.b(a) != null)
        {
            dw.b(a).a(dw.d(a).toString(), av.r.a(), i, j);
        }
        return true;
    }

    layer(dw dw1)
    {
        a = dw1;
        super();
    }
}
