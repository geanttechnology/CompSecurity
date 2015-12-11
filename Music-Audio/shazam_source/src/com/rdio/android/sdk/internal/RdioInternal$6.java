// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import com.google.a.d.e;
import com.rdio.android.core.managers.PlaybackSequenceManager;
import com.rdio.android.core.sequencing.SequencerUnit;
import com.rdio.android.core.util.Logging;

// Referenced classes of package com.rdio.android.sdk.internal:
//            RdioInternal

class ceManager extends PlaybackSequenceManager
{

    final RdioInternal this$0;

    public boolean canGoNext()
    {
        return true;
    }

    public boolean canGoPrev()
    {
        return true;
    }

    public SequencerUnit instantiateSequenceUnit(Class class1)
    {
        return (SequencerUnit)class1.newInstance();
    }

    t(e e, Logging logging)
    {
        this$0 = RdioInternal.this;
        super(e, logging);
    }
}
