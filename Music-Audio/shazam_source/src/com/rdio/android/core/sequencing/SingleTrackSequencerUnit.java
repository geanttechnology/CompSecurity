// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.sequencing;

import android.os.Handler;
import android.util.Log;
import com.google.a.d.e;
import com.rdio.android.api.models.ApiModel;
import com.rdio.android.api.models.generated.BaseAlbum;
import com.rdio.android.api.models.generated.BaseTrack;
import com.rdio.android.core.tasks.LoadModelsTask;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.rdio.android.core.sequencing:
//            SequencerUnit

public class SingleTrackSequencerUnit
    implements SequencerUnit
{

    private static final String TAG = "SingleTrackSequencerUnt";
    private BaseAlbum album;
    private e eventBus;
    private Handler handler;
    private boolean isInitialized;
    private SequencerUnit.Listener listener;
    private String parentKey;
    private SequencerUnit.Mode playbackMode;
    private BaseTrack track;

    public SingleTrackSequencerUnit()
    {
        playbackMode = SequencerUnit.Mode.Normal;
    }

    private void setEventBus(e e)
    {
        eventBus = e;
    }

    private void setParentKey(String s, int i)
    {
        parentKey = s;
    }

    public void cancel()
    {
        listener = null;
    }

    public void computeNextTrackKey()
    {
        final String trackKey;
        if (playbackMode != SequencerUnit.Mode.Normal)
        {
            trackKey = parentKey;
        } else
        {
            trackKey = null;
        }
        if (trackKey == null)
        {
            return;
        } else
        {
            trackKey = new Runnable() {

                final SingleTrackSequencerUnit this$0;
                final String val$trackKey;

                public void run()
                {
                    if (listener != null)
                    {
                        listener.onNextTrackKeyReady(trackKey, SingleTrackSequencerUnit.this);
                    }
                }

            
            {
                this$0 = SingleTrackSequencerUnit.this;
                trackKey = s;
                super();
            }
            };
            handler.post(trackKey);
            return;
        }
    }

    public void computePreviousTrackKey()
    {
        final String trackKey;
        if (playbackMode != SequencerUnit.Mode.Normal)
        {
            trackKey = parentKey;
        } else
        {
            trackKey = null;
        }
        if (trackKey == null)
        {
            return;
        } else
        {
            trackKey = new Runnable() {

                final SingleTrackSequencerUnit this$0;
                final String val$trackKey;

                public void run()
                {
                    if (listener != null)
                    {
                        listener.onPreviousTrackKeyReady(trackKey, SingleTrackSequencerUnit.this);
                    }
                }

            
            {
                this$0 = SingleTrackSequencerUnit.this;
                trackKey = s;
                super();
            }
            };
            handler.post(trackKey);
            return;
        }
    }

    public int getCurrentPosition()
    {
        return 0;
    }

    public SequencerUnit.Mode getMode()
    {
        return playbackMode;
    }

    public String getParentKey()
    {
        return parentKey;
    }

    public ApiModel getParentModel()
    {
        return track;
    }

    public List getSequenceAsKeys()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(parentKey);
        arraylist.add(parentKey);
        return arraylist;
    }

    public void initialize(String s, int i, SequencerUnit.Listener listener1, e e)
    {
        handler = new Handler();
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
    }

    public void moveToNext()
    {
        final Object trackKey;
        if (playbackMode != SequencerUnit.Mode.Normal)
        {
            trackKey = parentKey;
        } else
        {
            trackKey = null;
        }
        trackKey = new Runnable() {

            final SingleTrackSequencerUnit this$0;
            final String val$trackKey;

            public void run()
            {
label0:
                {
                    if (listener != null)
                    {
                        if (trackKey != null)
                        {
                            break label0;
                        }
                        listener.onSequenceReachedEnd(SingleTrackSequencerUnit.this);
                    }
                    return;
                }
                listener.onMoveToNextComplete(trackKey, SingleTrackSequencerUnit.this);
            }

            
            {
                this$0 = SingleTrackSequencerUnit.this;
                trackKey = s;
                super();
            }
        };
        handler.post(((Runnable) (trackKey)));
    }

    public void moveToPrevious()
    {
        final Object trackKey;
        if (playbackMode != SequencerUnit.Mode.Normal)
        {
            trackKey = parentKey;
        } else
        {
            trackKey = null;
        }
        trackKey = new Runnable() {

            final SingleTrackSequencerUnit this$0;
            final String val$trackKey;

            public void run()
            {
                if (listener != null)
                {
                    listener.onMoveToPreviousComplete(trackKey, SingleTrackSequencerUnit.this);
                }
            }

            
            {
                this$0 = SingleTrackSequencerUnit.this;
                trackKey = s;
                super();
            }
        };
        handler.post(((Runnable) (trackKey)));
    }

    public void prepareForPlayback()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("backgroundImageUrl");
        (new LoadModelsTask(eventBus, parentKey, true, arraylist)).startTask(new com.rdio.android.core.tasks.PresenterTask.TaskListener() {

            final SingleTrackSequencerUnit this$0;

            public void onCompleted(com.rdio.android.core.tasks.LoadModelsTask.Response response)
            {
                if (response.isPartial)
                {
                    return;
                } else
                {
                    response = (BaseTrack)response.models.get(0);
                    track = response;
                    ArrayList arraylist1 = new ArrayList();
                    arraylist1.add("dominantColor");
                    (new LoadModelsTask(eventBus, ((BaseTrack) (response)).albumKey, true, arraylist1)).startTask(new com.rdio.android.core.tasks.PresenterTask.TaskListener() {

                        final _cls5 this$1;

                        public void onCompleted(com.rdio.android.core.tasks.LoadModelsTask.Response response)
                        {
                            response = (BaseAlbum)response.models.get(0);
                            if (((BaseAlbum) (response)).loadedFields.contains("dominantColor"))
                            {
                                album = response;
                                isInitialized = true;
                                if (listener != null)
                                {
                                    listener.onInitialTrackKeyReady(parentKey, _fld0);
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
                            Log.e("SingleTrackSequencerUnt", (new StringBuilder("Error setting parent key: ")).append(parentKey).append(" message ").append(s).toString());
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    });
                    return;
                }
            }

            public volatile void onCompleted(Object obj)
            {
                onCompleted((com.rdio.android.core.tasks.LoadModelsTask.Response)obj);
            }

            public void onError(String s)
            {
            }

            
            {
                this$0 = SingleTrackSequencerUnit.this;
                super();
            }
        });
    }

    public void setListener(SequencerUnit.Listener listener1)
    {
        listener = listener1;
    }

    public void setMode(SequencerUnit.Mode mode)
    {
        playbackMode = mode;
    }

    public boolean toggleShuffle()
    {
        return false;
    }



/*
    static BaseTrack access$102(SingleTrackSequencerUnit singletracksequencerunit, BaseTrack basetrack)
    {
        singletracksequencerunit.track = basetrack;
        return basetrack;
    }

*/



/*
    static BaseAlbum access$302(SingleTrackSequencerUnit singletracksequencerunit, BaseAlbum basealbum)
    {
        singletracksequencerunit.album = basealbum;
        return basealbum;
    }

*/


/*
    static boolean access$402(SingleTrackSequencerUnit singletracksequencerunit, boolean flag)
    {
        singletracksequencerunit.isInitialized = flag;
        return flag;
    }

*/

}
