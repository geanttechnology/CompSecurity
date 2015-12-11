// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.sequencing;

import android.util.Log;
import com.rdio.android.api.models.ApiModel;
import com.rdio.android.api.models.BaseStation;
import com.rdio.android.api.models.generated.BaseAlbum;
import com.rdio.android.api.models.generated.BasePlaylist;
import com.rdio.android.api.models.generated.BaseTrack;
import java.util.List;

// Referenced classes of package com.rdio.android.core.sequencing:
//            ProxySequencerUnit, ImmutableSequencerUnit, SequencerUnit, SingleTrackSequencerUnit, 
//            StationSequencerUnit

class this._cls0
    implements com.rdio.android.core.tasks.tener
{

    final ProxySequencerUnit this$0;

    public void onCompleted(com.rdio.android.core.tasks.se se)
    {
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = false;
        if (isCancelled || se.isPartial)
        {
            return;
        }
        parentModel = (ApiModel)se.models.get(0);
        se = com/rdio/android/core/sequencing/ImmutableSequencerUnit;
        if (!(parentModel instanceof BaseAlbum)) goto _L2; else goto _L1
_L1:
        if (((BaseAlbum)parentModel).trackKeys == null || ((BaseAlbum)parentModel).trackKeys.size() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        se = com/rdio/android/core/sequencing/ImmutableSequencerUnit;
_L4:
        try
        {
            internalUnit = (SequencerUnit)se.newInstance();
        }
        // Misplaced declaration of an exception variable
        catch (com.rdio.android.core.tasks.se se)
        {
            Log.e("ProxySequencerUnit", "Failed to create internal sequencer unit", se);
            forceSkipToNextSource();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.rdio.android.core.tasks.se se)
        {
            Log.e("ProxySequencerUnit", "Failed to create internal sequencer unit", se);
            forceSkipToNextSource();
            return;
        }
        internalUnit.initialize(parentKey, startPosition, listener, eventBus);
        if (flag)
        {
            Log.e("ProxySequencerUnit", "A list of trackKeys was expected, but not found");
            forceSkipToNextSource();
            return;
        } else
        {
            internalUnit.prepareForPlayback();
            return;
        }
_L2:
        if (parentModel instanceof BasePlaylist)
        {
            if (((BasePlaylist)parentModel).trackKeys == null || ((BasePlaylist)parentModel).trackKeys.size() == 0)
            {
                flag = true;
            }
            se = com/rdio/android/core/sequencing/ImmutableSequencerUnit;
        } else
        if (parentModel instanceof BaseTrack)
        {
            se = com/rdio/android/core/sequencing/SingleTrackSequencerUnit;
            flag = flag1;
        } else
        {
            flag = flag1;
            if (parentModel instanceof BaseStation)
            {
                se = com/rdio/android/core/sequencing/StationSequencerUnit;
                flag = flag1;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public volatile void onCompleted(Object obj)
    {
        onCompleted((com.rdio.android.core.tasks.se)obj);
    }

    public void onError(String s)
    {
        Log.e("ProxySequencerUnit", "Failed to load parent key");
        forceSkipToNextSource();
    }

    nit()
    {
        this$0 = ProxySequencerUnit.this;
        super();
    }
}
