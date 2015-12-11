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

class this._cls0
    implements com.rdio.android.core.tasks.ner
{

    final StationSequencerUnit this$0;

    public void onCompleted(com.rdio.android.core.tasks. )
    {
        if (!.isPartial)
        {
            StationSequencerUnit.access$002(StationSequencerUnit.this, (ApiModel).models.get(0));
            try
            {
                 = StationSequencerUnit.access$000(StationSequencerUnit.this).getClass().getField("tracks");
                StationSequencerUnit.access$102(StationSequencerUnit.this, (List).get(StationSequencerUnit.access$000(StationSequencerUnit.this)));
            }
            // Misplaced declaration of an exception variable
            catch (com.rdio.android.core.tasks. )
            {
                Log.e("StationSequencerUnit", "Could not reflect tracks out of station", );
                return;
            }
            // Misplaced declaration of an exception variable
            catch (com.rdio.android.core.tasks. )
            {
                Log.e("StationSequencerUnit", "Could not reflect tracks out of station", );
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
                (new GenerateStationTask(StationSequencerUnit.access$000(StationSequencerUnit.this), null, 2, 0, StationSequencerUnit.access$600(StationSequencerUnit.this))).startTask(new com.rdio.android.core.tasks.PresenterTask.TaskListener() {

                    final StationSequencerUnit._cls4 this$1;

                    public volatile void onCompleted(Object obj)
                    {
                        onCompleted((List)obj);
                    }

                    public void onCompleted(List list)
                    {
                        if (StationSequencerUnit.access$300(this$0) == null)
                        {
                            return;
                        }
                        StationSequencerUnit.access$102(this$0, (List)list.get(1));
                        StationSequencerUnit.access$700(this$0, StationSequencerUnit.access$100(this$0));
                        StationSequencerUnit.access$502(this$0, true);
                        int i = Math.min(StationSequencerUnit.access$100(this$0).size() - 1, StationSequencerUnit.access$200(this$0));
                        if (i != StationSequencerUnit.access$200(this$0))
                        {
                            (new StringBuilder("Tried to jump to position ")).append(StationSequencerUnit.access$200(this$0)).append(" but the furtherest we could reach was ").append(i);
                        }
                        StationSequencerUnit.access$300(this$0).onInitialTrackKeyReady(((ApiModel)StationSequencerUnit.access$100(this$0).get(i)).key, this$0);
                    }

                    public void onError(String s)
                    {
                        Log.e("StationSequencerUnit", (new StringBuilder("Error generating tracks for station: ")).append(s).toString());
                    }

            
            {
                this$1 = StationSequencerUnit._cls4.this;
                super();
            }
                });
                return;
            }
        }
    }

    public volatile void onCompleted(Object obj)
    {
        onCompleted((com.rdio.android.core.tasks.)obj);
    }

    public void onError(String s)
    {
    }

    _cls1.this._cls1()
    {
        this$0 = StationSequencerUnit.this;
        super();
    }
}
