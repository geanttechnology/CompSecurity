// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;
import com.mopub.c.p;
import com.mopub.common.m;
import java.util.List;

// Referenced classes of package com.mopub.mobileads:
//            an, ah, i, am, 
//            ak, aj, ai, x

final class b
    implements android.media.Player.OnCompletionListener
{

    final am a;
    final Context b;
    final an c;

    public final void onCompletion(MediaPlayer mediaplayer)
    {
        c.k();
        c.i();
        c.a(false);
        c.s = true;
        if (!c.t && c.d.a(0x7fffffff, 0x7fffffff).size() == 0)
        {
            mediaplayer = c.d;
            Context context = ((i) (c)).a;
            int j = c.e.getCurrentPosition();
            m.a(context, "context cannot be null");
            p.a(((ah) (mediaplayer)).d, null, Integer.valueOf(j), ((ah) (mediaplayer)).j, context);
        }
        a.setVisibility(4);
        c.i.setVisibility(8);
        c.p.setVisibility(8);
        c.f.a();
        c.g.a();
        mediaplayer = c.k;
        mediaplayer.b = true;
        mediaplayer.c = true;
        mediaplayer.a();
        if (c.l != null)
        {
            if (b.getResources().getConfiguration().orientation == 1)
            {
                c.n.setVisibility(0);
            } else
            {
                c.m.setVisibility(0);
            }
            c.l.a(b, c.w);
        } else
        if (c.h.getDrawable() != null)
        {
            c.h.setVisibility(0);
            return;
        }
    }

    (an an1, am am1, Context context)
    {
        c = an1;
        a = am1;
        b = context;
        super();
    }
}
