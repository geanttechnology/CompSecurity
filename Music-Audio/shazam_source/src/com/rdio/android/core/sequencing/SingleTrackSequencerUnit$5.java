// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.sequencing;

import android.util.Log;
import com.rdio.android.api.models.generated.BaseAlbum;
import com.rdio.android.api.models.generated.BaseTrack;
import com.rdio.android.core.tasks.LoadModelsTask;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.rdio.android.core.sequencing:
//            SingleTrackSequencerUnit

class this._cls0
    implements com.rdio.android.core.tasks.it._cls5
{

    final SingleTrackSequencerUnit this$0;

    public void onCompleted(com.rdio.android.core.tasks.it._cls5 _pcls5)
    {
        if (_pcls5.artial)
        {
            return;
        } else
        {
            _pcls5 = (BaseTrack)_pcls5.els.get(0);
            SingleTrackSequencerUnit.access$102(SingleTrackSequencerUnit.this, _pcls5);
            ArrayList arraylist = new ArrayList();
            arraylist.add("dominantColor");
            (new LoadModelsTask(SingleTrackSequencerUnit.access$200(SingleTrackSequencerUnit.this), ((BaseTrack) (_pcls5)).albumKey, true, arraylist)).startTask(new com.rdio.android.core.tasks.PresenterTask.TaskListener() {

                final SingleTrackSequencerUnit._cls5 this$1;

                public void onCompleted(com.rdio.android.core.tasks.LoadModelsTask.Response response)
                {
                    response = (BaseAlbum)response.models.get(0);
                    if (((BaseAlbum) (response)).loadedFields.contains("dominantColor"))
                    {
                        SingleTrackSequencerUnit.access$302(this$0, response);
                        SingleTrackSequencerUnit.access$402(this$0, true);
                        if (SingleTrackSequencerUnit.access$000(this$0) != null)
                        {
                            SingleTrackSequencerUnit.access$000(this$0).onInitialTrackKeyReady(SingleTrackSequencerUnit.access$500(this$0), this$0);
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
                    Log.e("SingleTrackSequencerUnt", (new StringBuilder("Error setting parent key: ")).append(SingleTrackSequencerUnit.access$500(this$0)).append(" message ").append(s).toString());
                }

            
            {
                this$1 = SingleTrackSequencerUnit._cls5.this;
                super();
            }
            });
            return;
        }
    }

    public volatile void onCompleted(Object obj)
    {
        onCompleted((com.rdio.android.core.tasks.it._cls5.onCompleted)obj);
    }

    public void onError(String s)
    {
    }

    _cls1.this._cls1()
    {
        this$0 = SingleTrackSequencerUnit.this;
        super();
    }
}
