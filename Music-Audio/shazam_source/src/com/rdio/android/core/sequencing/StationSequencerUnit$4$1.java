// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.sequencing;

import android.util.Log;
import com.rdio.android.api.models.ApiModel;
import com.rdio.android.core.tasks.GenerateStationTask;
import java.lang.reflect.Field;
import java.util.List;

// Referenced classes of package com.rdio.android.core.sequencing:
//            StationSequencerUnit

class this._cls1
    implements com.rdio.android.core.tasks.r
{

    final is._cls0 this$1;

    public volatile void onCompleted(Object obj)
    {
        onCompleted((List)obj);
    }

    public void onCompleted(List list)
    {
        if (StationSequencerUnit.access$300(_fld0) == null)
        {
            return;
        }
        StationSequencerUnit.access$102(_fld0, (List)list.get(1));
        StationSequencerUnit.access$700(_fld0, StationSequencerUnit.access$100(_fld0));
        StationSequencerUnit.access$502(_fld0, true);
        int i = Math.min(StationSequencerUnit.access$100(_fld0).size() - 1, StationSequencerUnit.access$200(_fld0));
        if (i != StationSequencerUnit.access$200(_fld0))
        {
            (new StringBuilder("Tried to jump to position ")).append(StationSequencerUnit.access$200(_fld0)).append(" but the furtherest we could reach was ").append(i);
        }
        StationSequencerUnit.access$300(_fld0).InitialTrackKeyReady(((ApiModel)StationSequencerUnit.access$100(_fld0).get(i)).key, _fld0);
    }

    public void onError(String s)
    {
        Log.e("StationSequencerUnit", (new StringBuilder("Error generating tracks for station: ")).append(s).toString());
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/rdio/android/core/sequencing/StationSequencerUnit$4

/* anonymous class */
    class StationSequencerUnit._cls4
        implements com.rdio.android.core.tasks.PresenterTask.TaskListener
    {

        final StationSequencerUnit this$0;

        public void onCompleted(com.rdio.android.core.tasks.LoadModelsTask.Response response)
        {
            if (!response.isPartial)
            {
                StationSequencerUnit.access$002(StationSequencerUnit.this, (ApiModel)response.models.get(0));
                try
                {
                    response = StationSequencerUnit.access$000(StationSequencerUnit.this).getClass().getField("tracks");
                    StationSequencerUnit.access$102(StationSequencerUnit.this, (List)response.get(StationSequencerUnit.access$000(StationSequencerUnit.this)));
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
                if (StationSequencerUnit.access$300(StationSequencerUnit.this) != null && StationSequencerUnit.access$100(StationSequencerUnit.this) != null)
                {
                    StationSequencerUnit.access$502(StationSequencerUnit.this, true);
                    StationSequencerUnit.access$300(StationSequencerUnit.this).onInitialTrackKeyReady(((ApiModel)StationSequencerUnit.access$100(StationSequencerUnit.this).get(StationSequencerUnit.access$200(StationSequencerUnit.this))).key, StationSequencerUnit.this);
                    return;
                }
                if (StationSequencerUnit.access$100(StationSequencerUnit.this) == null)
                {
                    (new GenerateStationTask(StationSequencerUnit.access$000(StationSequencerUnit.this), null, 2, 0, StationSequencerUnit.access$600(StationSequencerUnit.this))).startTask(new StationSequencerUnit._cls4._cls1());
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
    }

}
