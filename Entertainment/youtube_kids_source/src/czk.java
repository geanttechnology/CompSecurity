// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.SystemClock;
import java.util.Observable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public final class czk extends Observable
{

    private final ScheduledExecutorService a = Executors.newScheduledThreadPool(1);
    private ScheduledFuture b;
    private czn c;

    public czk()
    {
    }

    static ScheduledFuture a(czk czk1, ScheduledFuture scheduledfuture)
    {
        czk1.b = scheduledfuture;
        return scheduledfuture;
    }

    private void a()
    {
        if (c != null)
        {
            c.a();
            c = null;
        }
    }

    static void a(czk czk1)
    {
        czk1.setChanged();
    }

    static ScheduledFuture b(czk czk1)
    {
        return czk1.b;
    }

    static ScheduledExecutorService c(czk czk1)
    {
        return czk1.a;
    }

    protected final void handleVideoStageEvent(ctd ctd1)
    {
        Object obj = null;
        czl.a[ctd1.b.ordinal()];
        JVM INSTR tableswitch 1 3: default 40
    //                   1 44
    //                   2 44
    //                   3 45;
           goto _L1 _L2 _L2 _L3
_L2:
        break MISSING_BLOCK_LABEL_44;
_L1:
        a();
_L5:
        return;
_L3:
        bxb bxb1;
        bxb1 = ctd1.c;
        a();
        if (bxb1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (bxb1 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        ctd1 = obj;
_L6:
        if (ctd1 != null)
        {
            c = new czn(this, ctd1, bxb1.j());
            ctd1 = c;
            ctd1.b = SystemClock.elapsedRealtime();
            ctd1.i = 1;
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
        bxd bxd1 = bxb1.j();
        ctd1 = obj;
        if (bxd1 != null)
        {
            ctd1 = bxd1.a.a;
        }
          goto _L6
        if (true) goto _L5; else goto _L7
_L7:
    }

    protected final void handleYouTubePlayerStateEvent(ctf ctf1)
    {
        if (c == null)
        {
            return;
        }
        switch (ctf1.a)
        {
        case 6: // '\006'
        default:
            return;

        case 2: // '\002'
            ctf1 = c;
            ctf1.b();
            ctf1.a(3);
            return;

        case 5: // '\005'
            ctf1 = c;
            ctf1.b();
            switch (czl.b[((czn) (ctf1)).i - 1])
            {
            default:
                return;

            case 1: // '\001'
                ctf1.a(2);
                ctf1.a(((czn) (ctf1)).c - ((czn) (ctf1)).f);
                return;

            case 2: // '\002'
                ctf1.a(4);
                ctf1.a(((czn) (ctf1)).d - ((czn) (ctf1)).h);
                return;

            case 3: // '\003'
            case 4: // '\004'
                ctf1.a(6);
                break;
            }
            return;

        case 9: // '\t'
            ctf1 = c;
            ctf1.b();
            ctf1.a(5);
            return;

        case 3: // '\003'
            ctf1 = c;
            ctf1.b();
            ctf1.a(7);
            return;

        case 4: // '\004'
        case 7: // '\007'
        case 8: // '\b'
            a();
            return;
        }
    }
}
