// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.media.SoundPool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.millennialmedia.android:
//            o

final class a extends TimerTask
{

    final a a;

    public final void run()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = a.a.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Integer integer = (Integer)iterator.next();
            int i = a.a.play(integer.intValue(), 0.0F, 0.0F, 0, 0, 1.0F);
            if (i != 0)
            {
                a.a.stop(i);
                a.a(a.a, integer.intValue());
                arraylist.add(integer);
            }
        } while (true);
        a.a.removeAll(arraylist);
        if (a.a.size() == 0)
        {
            a.a.cancel();
            a.a.purge();
        }
    }

    ( )
    {
        a = ;
        super();
    }
}
