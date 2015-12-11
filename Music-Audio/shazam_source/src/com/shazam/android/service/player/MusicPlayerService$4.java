// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.player;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.shazam.android.service.player:
//            MusicPlayerService, y

final class a
    implements Runnable
{

    final MusicPlayerService a;

    public final void run()
    {
        if (MusicPlayerService.b(a))
        {
            Iterator iterator = MusicPlayerService.d(a).iterator();
            while (iterator.hasNext()) 
            {
                y y1 = (y)((WeakReference)iterator.next()).get();
                if (y1 != null)
                {
                    y1.a(a.g(), a.h());
                }
            }
        }
    }

    (MusicPlayerService musicplayerservice)
    {
        a = musicplayerservice;
        super();
    }
}
