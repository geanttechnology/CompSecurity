// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.media.MediaPlayer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.millennialmedia.android:
//            o, an

final class a
    implements Runnable
{

    final a a;

    public final void run()
    {
        if (a(a) != null)
        {
            if (a(a).isPlaying())
            {
                int i = g(a).getCurrentPosition();
                if (a.a != null)
                {
                    for (Iterator iterator = a.a.iterator(); iterator.hasNext(); ((rayList.iterator)iterator.next()).a(i)) { }
                }
            }
            an.a(this, 500L);
        }
    }

    rayList(rayList raylist)
    {
        a = raylist;
        super();
    }
}
