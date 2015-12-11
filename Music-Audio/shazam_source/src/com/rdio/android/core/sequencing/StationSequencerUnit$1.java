// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.sequencing;

import android.util.Log;
import com.rdio.android.api.models.ApiModel;
import com.rdio.android.api.models.ApiModelUtil;
import com.rdio.android.api.models.BaseStation;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.rdio.android.core.sequencing:
//            StationSequencerUnit

class val.trackReadyNow
    implements com.rdio.android.core.tasks.ner
{

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
        StationSequencerUnit.access$002(StationSequencerUnit.this, (BaseStation)list.get(0));
        StationSequencerUnit.access$102(StationSequencerUnit.this, ApiModelUtil.getTracks(StationSequencerUnit.access$000(StationSequencerUnit.this)));
        if (StationSequencerUnit.access$100(StationSequencerUnit.this) != null) goto _L2; else goto _L1
_L1:
        Log.e("StationSequencerUnit", "Failed to get tracks from station model.");
_L4:
        return;
_L2:
        List list1 = (List)list.get(1);
        boolean flag = false;
        int k = 0;
        while (StationSequencerUnit.access$100(StationSequencerUnit.this).size() > 12) 
        {
            StationSequencerUnit.access$100(StationSequencerUnit.this).remove(0);
            k++;
            flag = true;
        }
        if (flag)
        {
            list = ApiModelUtil.getTrackKeys(StationSequencerUnit.access$000(StationSequencerUnit.this));
            list.clear();
            for (Iterator iterator = StationSequencerUnit.access$100(StationSequencerUnit.this).iterator(); iterator.hasNext(); list.add(((ApiModel)iterator.next()).key)) { }
        }
        StationSequencerUnit.access$220(StationSequencerUnit.this, k);
        if (StationSequencerUnit.access$200(StationSequencerUnit.this) < 0)
        {
            StationSequencerUnit.access$202(StationSequencerUnit.this, 0);
        } else
        if (StationSequencerUnit.access$200(StationSequencerUnit.this) >= StationSequencerUnit.access$100(StationSequencerUnit.this).size())
        {
            StationSequencerUnit.access$202(StationSequencerUnit.this, StationSequencerUnit.access$100(StationSequencerUnit.this).size() - 1);
        }
        (new StringBuilder("moveToNext(): new position is: ")).append(StationSequencerUnit.access$200(StationSequencerUnit.this));
        list = new int[list1.size()];
        if (k != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        k = StationSequencerUnit.access$100(StationSequencerUnit.this).size();
        l = list1.size();
        for (int i = ((flag1) ? 1 : 0); i < list1.size(); i++)
        {
            list[i] = i + 1 + (k - l);
        }

_L6:
        if (StationSequencerUnit.access$300(StationSequencerUnit.this) != null)
        {
            StationSequencerUnit.access$300(StationSequencerUnit.this).onSequenceChanged(list, StationSequencerUnit.this);
            if (!val$trackReadyNow)
            {
                StationSequencerUnit.access$300(StationSequencerUnit.this).onMoveToNextComplete(((ApiModel)StationSequencerUnit.access$100(StationSequencerUnit.this).get(StationSequencerUnit.access$200(StationSequencerUnit.this))).key, StationSequencerUnit.this);
                return;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        int ai[];
        int j;
        ai = new int[StationSequencerUnit.access$100(StationSequencerUnit.this).size()];
        j = l;
_L7:
        list = ai;
        if (j >= StationSequencerUnit.access$100(StationSequencerUnit.this).size()) goto _L6; else goto _L5
_L5:
        ai[j] = j + 1;
        j++;
          goto _L7
    }

    public void onError(String s)
    {
        Log.e("StationSequencerUnit", (new StringBuilder("Couldn't sequence key: ")).append(StationSequencerUnit.access$400(StationSequencerUnit.this)).append("message: ").append(s).toString());
    }

    ()
    {
        this$0 = final_stationsequencerunit;
        val$trackReadyNow = Z.this;
        super();
    }
}
