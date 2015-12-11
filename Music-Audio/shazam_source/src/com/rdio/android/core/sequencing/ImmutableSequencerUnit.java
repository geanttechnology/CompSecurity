// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.sequencing;

import android.os.Handler;
import android.util.Log;
import com.google.a.d.e;
import com.rdio.android.api.models.ApiModel;
import com.rdio.android.api.models.generated.BaseAlbum;
import com.rdio.android.api.models.generated.BasePlaylist;
import com.rdio.android.api.models.generated.BaseTrack;
import com.rdio.android.core.tasks.LoadModelsTask;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.rdio.android.core.sequencing:
//            SequencerUnit

public class ImmutableSequencerUnit
    implements SequencerUnit
{

    private static final String TAG = "ImmutableSequencerUnit";
    private final int END_OF_SEQUENCE_POSITION = -1;
    private e eventBus;
    private Handler handler;
    private boolean isInitialized;
    private SequencerUnit.Listener listener;
    private SequencerUnit.Mode mode;
    private String parentKey;
    private ApiModel parentModel;
    private int position;
    private List trackKeys;

    public ImmutableSequencerUnit()
    {
        handler = new Handler();
        mode = SequencerUnit.Mode.Normal;
    }

    private int computeNextPosition()
    {
label0:
        {
            int j = position + 1;
            int i = j;
            if (j >= trackKeys.size())
            {
                if (mode != SequencerUnit.Mode.RepeatAll)
                {
                    break label0;
                }
                i = 0;
            }
            return i;
        }
        return -1;
    }

    private void setEventBus(e e)
    {
        eventBus = e;
    }

    private void setParentKey(String s, int i)
    {
        parentKey = s;
        position = i;
    }

    public void cancel()
    {
        listener = null;
    }

    public void computeNextTrackKey()
    {
        int i = computeNextPosition();
        if (i != -1)
        {
            final String nextKey = (String)trackKeys.get(i);
            handler.post(new Runnable() {

                final ImmutableSequencerUnit this$0;
                final String val$nextKey;

                public void run()
                {
                    if (listener != null)
                    {
                        listener.onNextTrackKeyReady(nextKey, ImmutableSequencerUnit.this);
                    }
                }

            
            {
                this$0 = ImmutableSequencerUnit.this;
                nextKey = s;
                super();
            }
            });
        }
    }

    public void computePreviousTrackKey()
    {
    }

    public int getCurrentPosition()
    {
        return position;
    }

    public SequencerUnit.Mode getMode()
    {
        return mode;
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
        if (!isInitialized)
        {
            Log.e("ImmutableSequencerUnit", "getSequenceAsModels() called before initialized!");
            return null;
        } else
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(parentKey);
            arraylist.addAll(trackKeys);
            return arraylist;
        }
    }

    public void initialize(String s, int i, SequencerUnit.Listener listener1, e e)
    {
        setListener(listener1);
        setEventBus(e);
        setParentKey(s, i);
    }

    public boolean isReady()
    {
        return isInitialized;
    }

    public boolean isShuffling()
    {
        return false;
    }

    public void jumpToPosition(int i)
    {
        position = i;
        if (position < trackKeys.size()) goto _L2; else goto _L1
_L1:
        position = trackKeys.size() - 1;
_L4:
        handler.post(new Runnable() {

            final ImmutableSequencerUnit this$0;

            public void run()
            {
                if (listener != null)
                {
                    listener.onJumpComplete((String)trackKeys.get(position), ImmutableSequencerUnit.this);
                }
            }

            
            {
                this$0 = ImmutableSequencerUnit.this;
                super();
            }
        });
        return;
_L2:
        if (position < 0)
        {
            position = 0;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void moveToNext()
    {
        handler.post(new Runnable() {

            final ImmutableSequencerUnit this$0;

            public void run()
            {
                if (mode == SequencerUnit.Mode.RepeatOne && listener != null)
                {
                    listener.onMoveToNextComplete((String)trackKeys.get(position), ImmutableSequencerUnit.this);
                } else
                {
                    position = computeNextPosition();
                    if (position == -1)
                    {
                        listener.onSequenceReachedEnd(ImmutableSequencerUnit.this);
                        return;
                    }
                    if (listener != null)
                    {
                        listener.onMoveToNextComplete((String)trackKeys.get(position), ImmutableSequencerUnit.this);
                        return;
                    }
                }
            }

            
            {
                this$0 = ImmutableSequencerUnit.this;
                super();
            }
        });
    }

    public void moveToPrevious()
    {
        handler.post(new Runnable() {

            final ImmutableSequencerUnit this$0;

            public void run()
            {
                if (mode == SequencerUnit.Mode.RepeatOne && listener != null)
                {
                    listener.onMoveToPreviousComplete((String)trackKeys.get(position), ImmutableSequencerUnit.this);
                } else
                {
                    int i = ((size) (this)).size;
                    if (position < 0)
                    {
                        if (mode == SequencerUnit.Mode.RepeatAll)
                        {
                            position = trackKeys.size() - 1;
                        } else
                        {
                            position = 0;
                        }
                    }
                    if (listener != null)
                    {
                        listener.onMoveToPreviousComplete((String)trackKeys.get(position), ImmutableSequencerUnit.this);
                        return;
                    }
                }
            }

            
            {
                this$0 = ImmutableSequencerUnit.this;
                super();
            }
        });
    }

    public void prepareForPlayback()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("trackKeys");
        arraylist.add("iconKey");
        arraylist.add("customIconKey");
        arraylist.add("bigIcon1200");
        (new LoadModelsTask(eventBus, parentKey, true, arraylist)).startTask(new com.rdio.android.core.tasks.PresenterTask.TaskListener() {

            final ImmutableSequencerUnit this$0;

            public void onCompleted(com.rdio.android.core.tasks.LoadModelsTask.Response response)
            {
                if (!isInitialized && !response.isPartial)
                {
                    parentModel = (ApiModel)response.models.get(0);
                    if (parentModel instanceof BaseAlbum)
                    {
                        trackKeys = ((BaseAlbum)parentModel).trackKeys;
                        response = (String)trackKeys.get(position);
                    } else
                    if (parentModel instanceof BaseTrack)
                    {
                        response = parentKey;
                    } else
                    if (parentModel instanceof BasePlaylist)
                    {
                        trackKeys = ((BasePlaylist)parentModel).trackKeys;
                        response = (String)trackKeys.get(position);
                    } else
                    {
                        Log.e("ImmutableSequencerUnit", (new StringBuilder("Unable to sequence parentKey: ")).append(parentModel.key).toString());
                        return;
                    }
                    isInitialized = true;
                    if (listener != null)
                    {
                        listener.onInitialTrackKeyReady(response, ImmutableSequencerUnit.this);
                        return;
                    }
                }
            }

            public volatile void onCompleted(Object obj)
            {
                onCompleted((com.rdio.android.core.tasks.LoadModelsTask.Response)obj);
            }

            public void onError(String s)
            {
                Log.e("ImmutableSequencerUnit", (new StringBuilder("Unable to sequence parentKey: ")).append(parentKey).append(" message ").append(s).toString());
            }

            
            {
                this$0 = ImmutableSequencerUnit.this;
                super();
            }
        });
    }

    public void setListener(SequencerUnit.Listener listener1)
    {
        listener = listener1;
    }

    public void setMode(SequencerUnit.Mode mode1)
    {
        mode = mode1;
    }

    public boolean toggleShuffle()
    {
        return false;
    }




/*
    static int access$102(ImmutableSequencerUnit immutablesequencerunit, int i)
    {
        immutablesequencerunit.position = i;
        return i;
    }

*/


/*
    static int access$110(ImmutableSequencerUnit immutablesequencerunit)
    {
        int i = immutablesequencerunit.position;
        immutablesequencerunit.position = i - 1;
        return i;
    }

*/



/*
    static List access$202(ImmutableSequencerUnit immutablesequencerunit, List list)
    {
        immutablesequencerunit.trackKeys = list;
        return list;
    }

*/





/*
    static boolean access$502(ImmutableSequencerUnit immutablesequencerunit, boolean flag)
    {
        immutablesequencerunit.isInitialized = flag;
        return flag;
    }

*/



/*
    static ApiModel access$602(ImmutableSequencerUnit immutablesequencerunit, ApiModel apimodel)
    {
        immutablesequencerunit.parentModel = apimodel;
        return apimodel;
    }

*/

}
