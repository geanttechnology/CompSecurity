// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.sequencing;

import android.util.Log;
import com.rdio.android.api.models.ApiModel;
import com.rdio.android.api.models.BaseStation;
import com.rdio.android.api.models.generated.BaseAlbum;
import com.rdio.android.api.models.generated.BaseArtist;
import com.rdio.android.api.models.generated.BaseLabel;
import com.rdio.android.api.models.generated.BasePlaylist;
import com.rdio.android.api.models.generated.BaseTrack;
import java.util.List;

// Referenced classes of package com.rdio.android.core.sequencing:
//            StationConvertingProxySequencerUnit, StationSequencerUnit, SequencerUnit

class this._cls0
    implements com.rdio.android.core.tasks.it._cls1
{

    final StationConvertingProxySequencerUnit this$0;

    public void onCompleted(com.rdio.android.core.tasks.it._cls1 _pcls1)
    {
        if (isCancelled || _pcls1.isCancelled)
        {
            return;
        }
        parentModel = (ApiModel)_pcls1.parentModel.get(0);
        _pcls1 = parentKey;
        if (!(parentModel instanceof BaseAlbum)) goto _L2; else goto _L1
_L1:
        _pcls1 = ((BaseAlbum)parentModel).radioKey;
_L4:
        if (_pcls1 == null)
        {
            Log.e(StationConvertingProxySequencerUnit.access$000(), (new StringBuilder("Unable to find a station for key ")).append(parentKey).toString());
            listener.stener(tation);
            forceSkipToNextSource();
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (parentModel instanceof BasePlaylist)
        {
            _pcls1 = ((BasePlaylist)parentModel).radioKey;
        } else
        if (parentModel instanceof BaseTrack)
        {
            _pcls1 = ((BaseTrack)parentModel).radioKey;
        } else
        if (parentModel instanceof BaseStation)
        {
            _pcls1 = parentKey;
        } else
        if (parentModel instanceof BaseLabel)
        {
            _pcls1 = ((BaseLabel)parentModel).radioKey;
        } else
        if (parentModel instanceof BaseArtist)
        {
            _pcls1 = ((BaseArtist)parentModel).radioKey;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!_pcls1.equals(parentKey))
        {
            StationConvertingProxySequencerUnit.access$000();
            (new StringBuilder("Switching from ")).append(parentKey).append(" to station key ").append(_pcls1);
            listener.ion(parentKey, _pcls1);
            parentKey = _pcls1;
        }
        internalUnit = new StationSequencerUnit();
        internalUnit.initialize(parentKey, startPosition, listener, eventBus);
        internalUnit.prepareForPlayback();
        return;
    }

    public volatile void onCompleted(Object obj)
    {
        onCompleted((com.rdio.android.core.tasks.it._cls1.onCompleted)obj);
    }

    public void onError(String s)
    {
        Log.e(StationConvertingProxySequencerUnit.access$000(), "Failed to load parent key");
        forceSkipToNextSource();
    }

    ()
    {
        this$0 = StationConvertingProxySequencerUnit.this;
        super();
    }
}
