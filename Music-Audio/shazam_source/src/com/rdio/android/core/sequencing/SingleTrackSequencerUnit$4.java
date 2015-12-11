// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.sequencing;


// Referenced classes of package com.rdio.android.core.sequencing:
//            SingleTrackSequencerUnit

class val.trackKey
    implements Runnable
{

    final SingleTrackSequencerUnit this$0;
    final String val$trackKey;

    public void run()
    {
        if (SingleTrackSequencerUnit.access$000(SingleTrackSequencerUnit.this) != null)
        {
            SingleTrackSequencerUnit.access$000(SingleTrackSequencerUnit.this).veToPreviousComplete(val$trackKey, SingleTrackSequencerUnit.this);
        }
    }

    A()
    {
        this$0 = final_singletracksequencerunit;
        val$trackKey = String.this;
        super();
    }
}
