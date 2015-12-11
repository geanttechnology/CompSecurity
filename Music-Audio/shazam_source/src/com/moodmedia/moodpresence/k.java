// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.moodmedia.moodpresence;

import android.media.AudioRecord;
import android.os.SystemClock;

// Referenced classes of package com.moodmedia.moodpresence:
//            i

class k
    implements Runnable
{

    private static final int a = (int)Math.floor(0.0D);
    private static AudioRecord b;
    private i c;

    k(i j)
    {
        c = j;
    }

    private void a()
    {
        b();
        b = new AudioRecord(5, 44100, 16, 2, Math.max(AudioRecord.getMinBufferSize(44100, 16, 2) * 4, 32768));
    }

    private void b()
    {
        if (b == null)
        {
            return;
        }
        if (b.getRecordingState() == 3)
        {
            b.stop();
        }
        b.release();
        b = null;
    }

    public void run()
    {
        a();
        Object obj;
        int j;
        int l;
        long l1;
        long l2;
        boolean flag;
        try
        {
            b.startRecording();
        }
        catch (IllegalStateException illegalstateexception) { }
        l1 = SystemClock.uptimeMillis();
        obj = new short[2048];
_L4:
        flag = Thread.currentThread().isInterrupted();
        if (!flag) goto _L2; else goto _L1
_L1:
        b();
        return;
_L2:
        l2 = l1 + (long)a;
        l = (int)(l2 - SystemClock.uptimeMillis());
        j = l;
        if (l < 0)
        {
            j = 0;
        }
        Thread.sleep(j);
        j = 0;
_L5:
        if (j < 2048)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        l1 = l2;
        if (c.b() != i.a.c) goto _L4; else goto _L3
_L3:
        c.b(((short []) (obj)));
        l1 = l2;
          goto _L4
        obj;
        Thread.currentThread().interrupt();
          goto _L1
        l = b.read(((short []) (obj)), j, 2048 - j);
        j += l;
          goto _L5
    }

}
