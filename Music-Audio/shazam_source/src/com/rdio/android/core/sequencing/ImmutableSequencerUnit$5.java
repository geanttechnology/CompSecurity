// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.sequencing;

import android.util.Log;
import com.rdio.android.api.models.ApiModel;
import com.rdio.android.api.models.generated.BaseAlbum;
import com.rdio.android.api.models.generated.BasePlaylist;
import com.rdio.android.api.models.generated.BaseTrack;
import java.util.List;

// Referenced classes of package com.rdio.android.core.sequencing:
//            ImmutableSequencerUnit

class this._cls0
    implements com.rdio.android.core.tasks.r
{

    final ImmutableSequencerUnit this$0;

    public void onCompleted(com.rdio.android.core.tasks.it._cls5 _pcls5)
    {
        if (!ImmutableSequencerUnit.access$500(ImmutableSequencerUnit.this) && !_pcls5.sPartial)
        {
            ImmutableSequencerUnit.access$602(ImmutableSequencerUnit.this, (ApiModel)_pcls5.odels.get(0));
            if (ImmutableSequencerUnit.access$600(ImmutableSequencerUnit.this) instanceof BaseAlbum)
            {
                ImmutableSequencerUnit.access$202(ImmutableSequencerUnit.this, ((BaseAlbum)ImmutableSequencerUnit.access$600(ImmutableSequencerUnit.this)).trackKeys);
                _pcls5 = (String)ImmutableSequencerUnit.access$200(ImmutableSequencerUnit.this).get(ImmutableSequencerUnit.access$100(ImmutableSequencerUnit.this));
            } else
            if (ImmutableSequencerUnit.access$600(ImmutableSequencerUnit.this) instanceof BaseTrack)
            {
                _pcls5 = ImmutableSequencerUnit.access$700(ImmutableSequencerUnit.this);
            } else
            if (ImmutableSequencerUnit.access$600(ImmutableSequencerUnit.this) instanceof BasePlaylist)
            {
                ImmutableSequencerUnit.access$202(ImmutableSequencerUnit.this, ((BasePlaylist)ImmutableSequencerUnit.access$600(ImmutableSequencerUnit.this)).trackKeys);
                _pcls5 = (String)ImmutableSequencerUnit.access$200(ImmutableSequencerUnit.this).get(ImmutableSequencerUnit.access$100(ImmutableSequencerUnit.this));
            } else
            {
                Log.e("ImmutableSequencerUnit", (new StringBuilder("Unable to sequence parentKey: ")).append(ImmutableSequencerUnit.access$600(ImmutableSequencerUnit.this).key).toString());
                return;
            }
            ImmutableSequencerUnit.access$502(ImmutableSequencerUnit.this, true);
            if (ImmutableSequencerUnit.access$000(ImmutableSequencerUnit.this) != null)
            {
                ImmutableSequencerUnit.access$000(ImmutableSequencerUnit.this).InitialTrackKeyReady(_pcls5, ImmutableSequencerUnit.this);
                return;
            }
        }
    }

    public volatile void onCompleted(Object obj)
    {
        onCompleted((com.rdio.android.core.tasks.it._cls5.onCompleted)obj);
    }

    public void onError(String s)
    {
        Log.e("ImmutableSequencerUnit", (new StringBuilder("Unable to sequence parentKey: ")).append(ImmutableSequencerUnit.access$700(ImmutableSequencerUnit.this)).append(" message ").append(s).toString());
    }

    ()
    {
        this$0 = ImmutableSequencerUnit.this;
        super();
    }
}
