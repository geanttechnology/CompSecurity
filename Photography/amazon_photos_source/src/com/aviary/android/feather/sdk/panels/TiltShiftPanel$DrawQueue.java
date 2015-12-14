// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            TiltShiftPanel

static class completed extends LinkedBlockingQueue
{

    private static final long serialVersionUID = 1L;
    private volatile boolean completed;
    private com.aviary.android.feather.headless.filters.tMode tiltShiftMode;

    public void end()
    {
        completed = true;
    }

    public com.aviary.android.feather.headless.filters.tMode getMode()
    {
        return tiltShiftMode;
    }

    public boolean isCompleted()
    {
        return completed;
    }


    public ltShiftMode(com.aviary.android.feather.headless.filters.tMode tmode)
    {
        tiltShiftMode = tmode;
        completed = false;
    }
}
