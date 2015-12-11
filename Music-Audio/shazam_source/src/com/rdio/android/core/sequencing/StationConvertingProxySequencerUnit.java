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
import com.rdio.android.core.tasks.LoadModelsTask;
import com.rdio.android.core.tasks.PresenterTask;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.rdio.android.core.sequencing:
//            ProxySequencerUnit, SequencerUnit, StationSequencerUnit

public class StationConvertingProxySequencerUnit extends ProxySequencerUnit
{

    private static final String TAG = "StationConvertingProxySequencerUnit".substring(0, 23);
    public final List EXTRAS = Arrays.asList(new String[] {
        "trackKeys", "hasRadio", "radioKey"
    });

    public StationConvertingProxySequencerUnit()
    {
    }

    public ApiModel getParentModel()
    {
        return internalUnit.getParentModel();
    }

    public void prepareForPlayback()
    {
        loadModelsTask = new LoadModelsTask(eventBus, parentKey, true, EXTRAS);
        loadModelsTask.startTask(new com.rdio.android.core.tasks.PresenterTask.TaskListener() {

            final StationConvertingProxySequencerUnit this$0;

            public void onCompleted(com.rdio.android.core.tasks.LoadModelsTask.Response response)
            {
                if (isCancelled || response.isPartial)
                {
                    return;
                }
                parentModel = (ApiModel)response.models.get(0);
                response = parentKey;
                if (!(parentModel instanceof BaseAlbum)) goto _L2; else goto _L1
_L1:
                response = ((BaseAlbum)parentModel).radioKey;
_L4:
                if (response == null)
                {
                    Log.e(StationConvertingProxySequencerUnit.TAG, (new StringBuilder("Unable to find a station for key ")).append(parentKey).toString());
                    listener.onError(SequencerUnit.Error.UnableToConvertToStation);
                    forceSkipToNextSource();
                    return;
                }
                break; /* Loop/switch isn't completed */
_L2:
                if (parentModel instanceof BasePlaylist)
                {
                    response = ((BasePlaylist)parentModel).radioKey;
                } else
                if (parentModel instanceof BaseTrack)
                {
                    response = ((BaseTrack)parentModel).radioKey;
                } else
                if (parentModel instanceof BaseStation)
                {
                    response = parentKey;
                } else
                if (parentModel instanceof BaseLabel)
                {
                    response = ((BaseLabel)parentModel).radioKey;
                } else
                if (parentModel instanceof BaseArtist)
                {
                    response = ((BaseArtist)parentModel).radioKey;
                }
                if (true) goto _L4; else goto _L3
_L3:
                if (!response.equals(parentKey))
                {
                    StationConvertingProxySequencerUnit.TAG;
                    (new StringBuilder("Switching from ")).append(parentKey).append(" to station key ").append(response);
                    listener.onSourceConversion(parentKey, response);
                    parentKey = response;
                }
                internalUnit = new StationSequencerUnit();
                internalUnit.initialize(parentKey, startPosition, listener, eventBus);
                internalUnit.prepareForPlayback();
                return;
            }

            public volatile void onCompleted(Object obj)
            {
                onCompleted((com.rdio.android.core.tasks.LoadModelsTask.Response)obj);
            }

            public void onError(String s)
            {
                Log.e(StationConvertingProxySequencerUnit.TAG, "Failed to load parent key");
                forceSkipToNextSource();
            }

            
            {
                this$0 = StationConvertingProxySequencerUnit.this;
                super();
            }
        });
    }


}
