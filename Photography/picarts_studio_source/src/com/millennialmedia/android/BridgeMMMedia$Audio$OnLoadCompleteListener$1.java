// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.media.SoundPool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

class a extends TimerTask
{

    private a a;

    public void run()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = a(a).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Integer integer = (Integer)iterator.next();
            int i = a(a).play(integer.intValue(), 0.0F, 0.0F, 0, 0, 1.0F);
            if (i != 0)
            {
                a(a).stop(i);
                a.LoadComplete(LoadComplete(a), integer.intValue(), 0);
                arraylist.add(integer);
            }
        } while (true);
        a(a).removeAll(arraylist);
        if (a(a).size() == 0)
        {
            a(a).cancel();
            a(a).purge();
        }
    }

    ( )
    {
        a = ;
        super();
    }
}
