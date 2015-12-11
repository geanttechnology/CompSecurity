// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid;

import java.util.Comparator;
import tv.freewheel.hybrid.ad.interfaces.ISlot;

// Referenced classes of package tv.freewheel.hybrid:
//            StreamStitcherHelper

class this._cls0
    implements Comparator
{

    final StreamStitcherHelper this$0;

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((ISlot)obj, (ISlot)obj1);
    }

    public int compare(ISlot islot, ISlot islot1)
    {
        return Double.valueOf(islot.getTimePosition()).compareTo(Double.valueOf(islot1.getTimePosition()));
    }

    ()
    {
        this$0 = StreamStitcherHelper.this;
        super();
    }
}
