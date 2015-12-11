// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.sequencing;

import java.util.List;

// Referenced classes of package com.rdio.android.core.sequencing:
//            ImmutableSequencerUnit

class this._cls0
    implements Runnable
{

    final ImmutableSequencerUnit this$0;

    public void run()
    {
        if (ImmutableSequencerUnit.access$000(ImmutableSequencerUnit.this) != null)
        {
            ImmutableSequencerUnit.access$000(ImmutableSequencerUnit.this).JumpComplete((String)ImmutableSequencerUnit.access$200(ImmutableSequencerUnit.this).get(ImmutableSequencerUnit.access$100(ImmutableSequencerUnit.this)), ImmutableSequencerUnit.this);
        }
    }

    ()
    {
        this$0 = ImmutableSequencerUnit.this;
        super();
    }
}
