// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ctv
{

    ctn a;
    String b;
    volatile ctk c;
    volatile int d;
    private volatile boolean e;
    private volatile int f;

    ctv(ctw ctw)
    {
        f = 3;
    }

    private void handlePlaybackScriptedOperationEvent(cth cth1)
    {
        switch (ctu.c[cth1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            f = 1;
            return;

        case 2: // '\002'
            f = 2;
            break;
        }
    }

    private void handleSequenceChangedEvent(cti cti1)
    {
        b = cti1.a;
    }

    private void handleSequencerNavigationRequestEvent(ctj ctj1)
    {
        ctu.a[ctj1.b.ordinal()];
        JVM INSTR tableswitch 1 5: default 44
    //                   1 58
    //                   2 74
    //                   3 74
    //                   4 74
    //                   5 74;
           goto _L1 _L2 _L3 _L3 _L3 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_74;
_L4:
        if (f == 1)
        {
            f = 2;
            return;
        } else
        {
            f = 3;
            return;
        }
_L2:
        e = true;
        c = ctj1.b;
          goto _L4
        d = 0;
        e = false;
        c = ctj1.b;
          goto _L4
    }

    private void handleVideoStageEvent(ctd ctd1)
    {
        ctu.b[ctd1.b.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 33
    //                   2 56;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (e)
        {
            d = d + 1;
            e = false;
            return;
        }
          goto _L1
_L3:
        d = 0;
        e = false;
        return;
    }

    boolean a()
    {
        return f == 2;
    }
}
