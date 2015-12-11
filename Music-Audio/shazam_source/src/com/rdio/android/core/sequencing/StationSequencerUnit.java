// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.sequencing;

import android.os.Handler;
import android.util.Log;
import com.google.a.d.e;
import com.rdio.android.api.models.ApiModel;
import com.rdio.android.api.models.ApiModelUtil;
import com.rdio.android.api.models.BaseStation;
import com.rdio.android.core.tasks.GenerateStationTask;
import com.rdio.android.core.tasks.LoadModelsTask;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.rdio.android.core.sequencing:
//            SequencerUnit

public class StationSequencerUnit
    implements SequencerUnit
{

    private static final int MAX_POSITION = 10;
    private static final int MAX_TRACKS_TO_HOLD = 12;
    private static final List MODEL_EXTRAS = Arrays.asList(new String[] {
        "description", "allowVoting", "presetIndex", "availablePresets"
    });
    private static final int STATION_INIT_TRACK_COUNT = 2;
    private static final String TAG = "StationSequencerUnit";
    private e eventBus;
    private Handler handler;
    private boolean isInitialized;
    private SequencerUnit.Listener listener;
    private String parentKey;
    private int position;
    private ApiModel station;
    private List tracks;

    public StationSequencerUnit()
    {
        handler = new Handler();
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

    private void setTracksOnStation(List list)
    {
        try
        {
            station.getClass().getField("tracks").set(station, list);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            Log.e("StationSequencerUnit", "Could not set tracks on station");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            Log.e("StationSequencerUnit", "Could not set tracks on station");
        }
    }

    public void cancel()
    {
        listener = null;
    }

    public void computeNextTrackKey()
    {
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
        return SequencerUnit.Mode.Normal;
    }

    public String getParentKey()
    {
        return parentKey;
    }

    public ApiModel getParentModel()
    {
        return station;
    }

    public List getSequenceAsKeys()
    {
        if (!isInitialized)
        {
            Log.e("StationSequencerUnit", "getSequenceAsModels() called before initialized!");
            return null;
        }
        ArrayList arraylist = new ArrayList();
        arraylist.add(parentKey);
        for (Iterator iterator = tracks.iterator(); iterator.hasNext(); arraylist.add(((ApiModel)iterator.next()).key)) { }
        return arraylist;
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
    }

    public void moveToNext()
    {
        if (!isReady())
        {
            return;
        }
        if (position > 10)
        {
            (new StringBuilder("moveToNext(): ignoring request, position is: ")).append(position);
            return;
        }
        position = position + 1;
        if (position >= tracks.size() - 1 || position > 10)
        {
            ArrayList arraylist;
            final boolean trackReadyNow;
            if (position < tracks.size())
            {
                trackReadyNow = true;
            } else
            {
                trackReadyNow = false;
            }
            if (trackReadyNow && listener != null)
            {
                listener.onMoveToNextComplete(((ApiModel)tracks.get(position)).key, this);
            }
            arraylist = new ArrayList();
            for (Iterator iterator = tracks.iterator(); iterator.hasNext(); arraylist.add(((ApiModel)iterator.next()).key)) { }
            (new GenerateStationTask(station, arraylist, 1, 0, eventBus)).startTask(new com.rdio.android.core.tasks.PresenterTask.TaskListener() {

                final StationSequencerUnit this$0;
                final boolean val$trackReadyNow;

                public volatile void onCompleted(Object obj)
                {
                    onCompleted((List)obj);
                }

                public void onCompleted(List list)
                {
                    boolean flag1;
                    int l;
                    l = 0;
                    flag1 = false;
                    station = (BaseStation)list.get(0);
                    tracks = ApiModelUtil.getTracks(station);
                    if (tracks != null) goto _L2; else goto _L1
_L1:
                    Log.e("StationSequencerUnit", "Failed to get tracks from station model.");
_L4:
                    return;
_L2:
                    List list1 = (List)list.get(1);
                    boolean flag = false;
                    int k = 0;
                    while (tracks.size() > 12) 
                    {
                        tracks.remove(0);
                        k++;
                        flag = true;
                    }
                    if (flag)
                    {
                        list = ApiModelUtil.getTrackKeys(station);
                        list.clear();
                        for (Iterator iterator1 = tracks.iterator(); iterator1.hasNext(); list.add(((ApiModel)iterator1.next()).key)) { }
                    }
                    list = ((java.util) (this)). - list;
                    if (position < 0)
                    {
                        position = 0;
                    } else
                    if (position >= tracks.size())
                    {
                        position = tracks.size() - 1;
                    }
                    (new StringBuilder("moveToNext(): new position is: ")).append(position);
                    list = new int[list1.size()];
                    if (k != 0)
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    k = tracks.size();
                    l = list1.size();
                    for (int i = ((flag1) ? 1 : 0); i < list1.size(); i++)
                    {
                        list[i] = i + 1 + (k - l);
                    }

_L6:
                    if (listener != null)
                    {
                        listener.onSequenceChanged(list, StationSequencerUnit.this);
                        if (!trackReadyNow)
                        {
                            listener.onMoveToNextComplete(((ApiModel)tracks.get(position)).key, StationSequencerUnit.this);
                            return;
                        }
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                    int ai[];
                    int j;
                    ai = new int[tracks.size()];
                    j = l;
_L7:
                    list = ai;
                    if (j >= tracks.size()) goto _L6; else goto _L5
_L5:
                    ai[j] = j + 1;
                    j++;
                      goto _L7
                }

                public void onError(String s)
                {
                    Log.e("StationSequencerUnit", (new StringBuilder("Couldn't sequence key: ")).append(parentKey).append("message: ").append(s).toString());
                }

            
            {
                this$0 = StationSequencerUnit.this;
                trackReadyNow = flag;
                super();
            }
            });
            return;
        } else
        {
            handler.post(new Runnable() {

                final StationSequencerUnit this$0;

                public void run()
                {
                    if (listener != null)
                    {
                        listener.onMoveToNextComplete(((ApiModel)tracks.get(position)).key, StationSequencerUnit.this);
                    }
                }

            
            {
                this$0 = StationSequencerUnit.this;
                super();
            }
            });
            return;
        }
    }

    public void moveToPrevious()
    {
        if (!isReady())
        {
            return;
        }
        position = position - 1;
        if (position < 0)
        {
            position = 0;
        }
        handler.post(new Runnable() {

            final StationSequencerUnit this$0;

            public void run()
            {
                if (listener != null)
                {
                    listener.onMoveToPreviousComplete(((ApiModel)tracks.get(position)).key, StationSequencerUnit.this);
                }
            }

            
            {
                this$0 = StationSequencerUnit.this;
                super();
            }
        });
    }

    public void prepareForPlayback()
    {
        (new LoadModelsTask(eventBus, parentKey, true, MODEL_EXTRAS)).startTask(new com.rdio.android.core.tasks.PresenterTask.TaskListener() {

            final StationSequencerUnit this$0;

            public void onCompleted(com.rdio.android.core.tasks.LoadModelsTask.Response response)
            {
                if (!response.isPartial)
                {
                    station = (ApiModel)response.models.get(0);
                    try
                    {
                        response = station.getClass().getField("tracks");
                        tracks = (List)response.get(station);
                    }
                    // Misplaced declaration of an exception variable
                    catch (com.rdio.android.core.tasks.LoadModelsTask.Response response)
                    {
                        Log.e("StationSequencerUnit", "Could not reflect tracks out of station", response);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (com.rdio.android.core.tasks.LoadModelsTask.Response response)
                    {
                        Log.e("StationSequencerUnit", "Could not reflect tracks out of station", response);
                        return;
                    }
                    if (listener != null && tracks != null)
                    {
                        isInitialized = true;
                        listener.onInitialTrackKeyReady(((ApiModel)tracks.get(position)).key, StationSequencerUnit.this);
                        return;
                    }
                    if (tracks == null)
                    {
                        (new GenerateStationTask(station, null, 2, 0, eventBus)).startTask(new com.rdio.android.core.tasks.PresenterTask.TaskListener() {

                            final _cls4 this$1;

                            public volatile void onCompleted(Object obj)
                            {
                                onCompleted((List)obj);
                            }

                            public void onCompleted(List list)
                            {
                                if (listener == null)
                                {
                                    return;
                                }
                                tracks = (List)list.get(1);
                                setTracksOnStation(tracks);
                                isInitialized = true;
                                int i = Math.min(tracks.size() - 1, position);
                                if (i != position)
                                {
                                    (new StringBuilder("Tried to jump to position ")).append(position).append(" but the furtherest we could reach was ").append(i);
                                }
                                listener.onInitialTrackKeyReady(((ApiModel)tracks.get(i)).key, _fld0);
                            }

                            public void onError(String s)
                            {
                                Log.e("StationSequencerUnit", (new StringBuilder("Error generating tracks for station: ")).append(s).toString());
                            }

            
            {
                this$1 = _cls4.this;
                super();
            }
                        });
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
            }

            
            {
                this$0 = StationSequencerUnit.this;
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
    }

    public boolean toggleShuffle()
    {
        return false;
    }




/*
    static ApiModel access$002(StationSequencerUnit stationsequencerunit, ApiModel apimodel)
    {
        stationsequencerunit.station = apimodel;
        return apimodel;
    }

*/



/*
    static List access$102(StationSequencerUnit stationsequencerunit, List list)
    {
        stationsequencerunit.tracks = list;
        return list;
    }

*/



/*
    static int access$202(StationSequencerUnit stationsequencerunit, int i)
    {
        stationsequencerunit.position = i;
        return i;
    }

*/


/*
    static int access$220(StationSequencerUnit stationsequencerunit, int i)
    {
        i = stationsequencerunit.position - i;
        stationsequencerunit.position = i;
        return i;
    }

*/




/*
    static boolean access$502(StationSequencerUnit stationsequencerunit, boolean flag)
    {
        stationsequencerunit.isInitialized = flag;
        return flag;
    }

*/


}
