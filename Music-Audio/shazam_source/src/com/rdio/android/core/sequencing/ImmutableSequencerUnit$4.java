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
        if (ImmutableSequencerUnit.access$300(ImmutableSequencerUnit.this) == One && ImmutableSequencerUnit.access$000(ImmutableSequencerUnit.this) != null)
        {
            ImmutableSequencerUnit.access$000(ImmutableSequencerUnit.this).MoveToPreviousComplete((String)ImmutableSequencerUnit.access$200(ImmutableSequencerUnit.this).get(ImmutableSequencerUnit.access$100(ImmutableSequencerUnit.this)), ImmutableSequencerUnit.this);
        } else
        {
            int _tmp = ImmutableSequencerUnit.access$110(ImmutableSequencerUnit.this);
            if (ImmutableSequencerUnit.access$100(ImmutableSequencerUnit.this) < 0)
            {
                if (ImmutableSequencerUnit.access$300(ImmutableSequencerUnit.this) == All)
                {
                    ImmutableSequencerUnit.access$102(ImmutableSequencerUnit.this, ImmutableSequencerUnit.access$200(ImmutableSequencerUnit.this).size() - 1);
                } else
                {
                    ImmutableSequencerUnit.access$102(ImmutableSequencerUnit.this, 0);
                }
            }
            if (ImmutableSequencerUnit.access$000(ImmutableSequencerUnit.this) != null)
            {
                ImmutableSequencerUnit.access$000(ImmutableSequencerUnit.this).MoveToPreviousComplete((String)ImmutableSequencerUnit.access$200(ImmutableSequencerUnit.this).get(ImmutableSequencerUnit.access$100(ImmutableSequencerUnit.this)), ImmutableSequencerUnit.this);
                return;
            }
        }
    }

    ()
    {
        this$0 = ImmutableSequencerUnit.this;
        super();
    }
}
