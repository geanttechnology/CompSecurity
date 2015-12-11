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

class this._cls1
    implements com.rdio.android.core.tasks.._cls5._cls1
{

    final is._cls0 this$1;

    public void onCompleted(com.rdio.android.core.tasks.._cls5._cls1 _pcls1)
    {
        _pcls1 = (BaseAlbum)_pcls1.s.get(0);
        if (((BaseAlbum) (_pcls1)).loadedFields.contains("dominantColor"))
        {
            SingleTrackSequencerUnit.access$302(_fld0, _pcls1);
            SingleTrackSequencerUnit.access$402(_fld0, true);
            if (SingleTrackSequencerUnit.access$000(_fld0) != null)
            {
                SingleTrackSequencerUnit.access$000(_fld0).ialTrackKeyReady(SingleTrackSequencerUnit.access$500(_fld0), _fld0);
                return;
            }
        }
    }

    public volatile void onCompleted(Object obj)
    {
        onCompleted((com.rdio.android.core.tasks.._cls5._cls1.onCompleted)obj);
    }

    public void onError(String s)
    {
        Log.e("SingleTrackSequencerUnt", (new StringBuilder("Error setting parent key: ")).append(SingleTrackSequencerUnit.access$500(_fld0)).append(" message ").append(s).toString());
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/rdio/android/core/sequencing/SingleTrackSequencerUnit$5

/* anonymous class */
    class SingleTrackSequencerUnit._cls5
        implements com.rdio.android.core.tasks.PresenterTask.TaskListener
    {

        final SingleTrackSequencerUnit this$0;

        public void onCompleted(com.rdio.android.core.tasks.LoadModelsTask.Response response)
        {
            if (response.isPartial)
            {
                return;
            } else
            {
                response = (BaseTrack)response.models.get(0);
                SingleTrackSequencerUnit.access$102(SingleTrackSequencerUnit.this, response);
                ArrayList arraylist = new ArrayList();
                arraylist.add("dominantColor");
                (new LoadModelsTask(SingleTrackSequencerUnit.access$200(SingleTrackSequencerUnit.this), ((BaseTrack) (response)).albumKey, true, arraylist)).startTask(new SingleTrackSequencerUnit._cls5._cls1());
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
    }

}
