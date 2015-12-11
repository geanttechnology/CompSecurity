// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.sequencing;

import android.os.Handler;
import android.util.Log;
import com.google.a.d.e;
import com.rdio.android.api.models.ApiModel;
import com.rdio.android.api.models.BaseStation;
import com.rdio.android.api.models.generated.BaseAlbum;
import com.rdio.android.api.models.generated.BasePlaylist;
import com.rdio.android.api.models.generated.BaseTrack;
import com.rdio.android.core.tasks.LoadModelsTask;
import com.rdio.android.core.tasks.PresenterTask;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.rdio.android.core.sequencing:
//            SequencerUnit, ImmutableSequencerUnit, SingleTrackSequencerUnit, StationSequencerUnit

public class ProxySequencerUnit
    implements SequencerUnit
{

    private static final String TAG = "ProxySequencerUnit";
    public final List EXTRAS = Arrays.asList(new String[] {
        "trackKeys"
    });
    protected e eventBus;
    protected SequencerUnit internalUnit;
    protected boolean isCancelled;
    protected SequencerUnit.Listener listener;
    protected PresenterTask loadModelsTask;
    protected String parentKey;
    protected ApiModel parentModel;
    protected int startPosition;

    public ProxySequencerUnit()
    {
    }

    public void cancel()
    {
        isCancelled = true;
        if (loadModelsTask != null)
        {
            loadModelsTask.cancel();
            loadModelsTask = null;
        }
    }

    public void computeNextTrackKey()
    {
        internalUnit.computeNextTrackKey();
    }

    public void computePreviousTrackKey()
    {
        internalUnit.computePreviousTrackKey();
    }

    protected void forceSkipToNextSource()
    {
        (new Handler()).post(new Runnable() {

            final ProxySequencerUnit this$0;

            public void run()
            {
                listener.onSequenceReachedEnd(ProxySequencerUnit.this);
            }

            
            {
                this$0 = ProxySequencerUnit.this;
                super();
            }
        });
    }

    public int getCurrentPosition()
    {
        if (internalUnit != null)
        {
            return internalUnit.getCurrentPosition();
        } else
        {
            return 0;
        }
    }

    public SequencerUnit.Mode getMode()
    {
        return internalUnit.getMode();
    }

    public String getParentKey()
    {
        return parentKey;
    }

    public ApiModel getParentModel()
    {
        return parentModel;
    }

    public List getSequenceAsKeys()
    {
        return internalUnit.getSequenceAsKeys();
    }

    public void initialize(String s, int i, SequencerUnit.Listener listener1, e e)
    {
        parentKey = s;
        startPosition = i;
        listener = listener1;
        eventBus = e;
    }

    public boolean isReady()
    {
        return internalUnit != null && internalUnit.isReady();
    }

    public boolean isShuffling()
    {
        return internalUnit.isShuffling();
    }

    public void jumpToPosition(int i)
    {
        internalUnit.jumpToPosition(i);
    }

    public void moveToNext()
    {
        if (internalUnit != null)
        {
            internalUnit.moveToNext();
        }
    }

    public void moveToPrevious()
    {
        if (internalUnit != null)
        {
            internalUnit.moveToPrevious();
        }
    }

    public void prepareForPlayback()
    {
        loadModelsTask = new LoadModelsTask(eventBus, parentKey, true, EXTRAS);
        loadModelsTask.startTask(new com.rdio.android.core.tasks.PresenterTask.TaskListener() {

            final ProxySequencerUnit this$0;

            public void onCompleted(com.rdio.android.core.tasks.LoadModelsTask.Response response)
            {
                boolean flag;
                boolean flag1;
                flag = false;
                flag1 = false;
                if (isCancelled || response.isPartial)
                {
                    return;
                }
                parentModel = (ApiModel)response.models.get(0);
                response = com/rdio/android/core/sequencing/ImmutableSequencerUnit;
                if (!(parentModel instanceof BaseAlbum)) goto _L2; else goto _L1
_L1:
                if (((BaseAlbum)parentModel).trackKeys == null || ((BaseAlbum)parentModel).trackKeys.size() == 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                response = com/rdio/android/core/sequencing/ImmutableSequencerUnit;
_L4:
                try
                {
                    internalUnit = (SequencerUnit)response.newInstance();
                }
                // Misplaced declaration of an exception variable
                catch (com.rdio.android.core.tasks.LoadModelsTask.Response response)
                {
                    Log.e("ProxySequencerUnit", "Failed to create internal sequencer unit", response);
                    forceSkipToNextSource();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (com.rdio.android.core.tasks.LoadModelsTask.Response response)
                {
                    Log.e("ProxySequencerUnit", "Failed to create internal sequencer unit", response);
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
                    response = com/rdio/android/core/sequencing/ImmutableSequencerUnit;
                } else
                if (parentModel instanceof BaseTrack)
                {
                    response = com/rdio/android/core/sequencing/SingleTrackSequencerUnit;
                    flag = flag1;
                } else
                {
                    flag = flag1;
                    if (parentModel instanceof BaseStation)
                    {
                        response = com/rdio/android/core/sequencing/StationSequencerUnit;
                        flag = flag1;
                    }
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            public volatile void onCompleted(Object obj)
            {
                onCompleted((com.rdio.android.core.tasks.LoadModelsTask.Response)obj);
            }

            public void onError(String s)
            {
                Log.e("ProxySequencerUnit", "Failed to load parent key");
                forceSkipToNextSource();
            }

            
            {
                this$0 = ProxySequencerUnit.this;
                super();
            }
        });
    }

    public void setListener(SequencerUnit.Listener listener1)
    {
        if (internalUnit == null)
        {
            listener = listener1;
            return;
        } else
        {
            internalUnit.setListener(listener1);
            return;
        }
    }

    public void setMode(SequencerUnit.Mode mode)
    {
        internalUnit.setMode(mode);
    }

    public boolean toggleShuffle()
    {
        return internalUnit.toggleShuffle();
    }
}
