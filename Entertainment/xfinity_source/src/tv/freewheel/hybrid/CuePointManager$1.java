// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid;

import android.util.Pair;
import java.util.ArrayList;
import tv.freewheel.hybrid.utils.Logger;
import tv.freewheel.hybrid.utils.events.Event;

// Referenced classes of package tv.freewheel.hybrid:
//            CuePointManager

class this._cls0
    implements Runnable
{

    final CuePointManager this$0;

    public void run()
    {
        CuePointManager.access$018(CuePointManager.this, CuePointManager.access$100());
        CuePointManager.access$200(CuePointManager.this).debug((new StringBuilder()).append("onTimer: ").append(CuePointManager.access$000(CuePointManager.this)).toString());
        if (!CuePointManager.access$300(CuePointManager.this).isEmpty()) goto _L2; else goto _L1
_L1:
        CuePointManager.access$200(CuePointManager.this).debug("no cue points left, stop timeline");
        stop();
_L4:
        return;
_L2:
        int i = 0;
_L5:
        if (i >= CuePointManager.access$300(CuePointManager.this).size())
        {
            continue; /* Loop/switch isn't completed */
        }
        Pair pair = (Pair)CuePointManager.access$300(CuePointManager.this).get(i);
        if (((Double)pair.second).doubleValue() - CuePointManager.access$100() >= CuePointManager.access$000(CuePointManager.this) || ((Double)pair.second).doubleValue() + CuePointManager.access$100() <= CuePointManager.access$000(CuePointManager.this))
        {
            break MISSING_BLOCK_LABEL_243;
        }
        CuePointManager.access$200(CuePointManager.this).debug((new StringBuilder()).append("Firing CuePoint at time ").append(pair.second).toString());
        dispatchEvent(new Event(CuePointManager.EVENT_CUE_POINT_REACHED, (String)pair.first));
        if (i >= CuePointManager.access$300(CuePointManager.this).size()) goto _L4; else goto _L3
_L3:
        CuePointManager.access$300(CuePointManager.this).remove(i);
        return;
        i++;
          goto _L5
    }

    ()
    {
        this$0 = CuePointManager.this;
        super();
    }
}
