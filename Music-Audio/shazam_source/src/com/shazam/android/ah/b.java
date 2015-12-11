// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ah;

import com.moodmedia.moodpresence.MoodPresence;
import com.moodmedia.moodpresence.MoodPresenceHandler;
import com.moodmedia.moodpresence.MoodPresenceResult;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.shazam.android.ah:
//            d, f

public final class b
    implements MoodPresenceHandler, d
{

    private final List c = new CopyOnWriteArrayList();

    public b(String s)
    {
        if (!MoodPresence.INSTANCE.isInitialized())
        {
            MoodPresence.INSTANCE.init(s);
        }
        if (!MoodPresence.INSTANCE.isPrepared())
        {
            MoodPresence.INSTANCE.prepare(44100);
        }
        MoodPresence.INSTANCE.subscribe(this);
    }

    public final void a()
    {
    }

    public final void a(f f1)
    {
        c.add(f1);
    }

    public final void a(com.shazam.android.ay.a.j.a a1)
    {
        MoodPresence.INSTANCE.reset();
    }

    public final void a(byte abyte0[], int i)
    {
        MoodPresence.INSTANCE.addSamples(abyte0, 0, i);
    }

    public final void b()
    {
        MoodPresence.INSTANCE.reset();
    }

    public final void b(f f1)
    {
        c.remove(f1);
    }

    public final void handlePresence(MoodPresenceResult moodpresenceresult)
    {
        long l = moodpresenceresult.getPresenceId();
        moodpresenceresult = moodpresenceresult.getType();
        (new StringBuilder("Found watermark presence - ID: ")).append(l).append(" Type: ").append(moodpresenceresult);
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((f)iterator.next()).a(l, moodpresenceresult)) { }
    }
}
