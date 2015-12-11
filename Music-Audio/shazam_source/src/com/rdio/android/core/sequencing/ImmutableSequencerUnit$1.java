// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.sequencing;


// Referenced classes of package com.rdio.android.core.sequencing:
//            ImmutableSequencerUnit

class val.nextKey
    implements Runnable
{

    final ImmutableSequencerUnit this$0;
    final String val$nextKey;

    public void run()
    {
        if (ImmutableSequencerUnit.access$000(ImmutableSequencerUnit.this) != null)
        {
            ImmutableSequencerUnit.access$000(ImmutableSequencerUnit.this).NextTrackKeyReady(val$nextKey, ImmutableSequencerUnit.this);
        }
    }

    ()
    {
        this$0 = final_immutablesequencerunit;
        val$nextKey = String.this;
        super();
    }
}
