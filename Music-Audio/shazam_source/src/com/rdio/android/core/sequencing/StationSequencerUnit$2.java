// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.sequencing;

import com.rdio.android.api.models.ApiModel;
import java.util.List;

// Referenced classes of package com.rdio.android.core.sequencing:
//            StationSequencerUnit

class this._cls0
    implements Runnable
{

    final StationSequencerUnit this$0;

    public void run()
    {
        if (StationSequencerUnit.access$300(StationSequencerUnit.this) != null)
        {
            StationSequencerUnit.access$300(StationSequencerUnit.this).onMoveToNextComplete(((ApiModel)StationSequencerUnit.access$100(StationSequencerUnit.this).get(StationSequencerUnit.access$200(StationSequencerUnit.this))).key, StationSequencerUnit.this);
        }
    }

    ()
    {
        this$0 = StationSequencerUnit.this;
        super();
    }
}
