// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import java.util.Set;

// Referenced classes of package com.crashlytics.android.answers:
//            EventFilter, SessionEvent, SessionEventMetadata

class SamplingEventFilter
    implements EventFilter
{

    static final Set EVENTS_TYPE_TO_SAMPLE = new _cls1();
    final int samplingRate;

    public SamplingEventFilter(int i)
    {
        samplingRate = i;
    }

    public boolean skipEvent(SessionEvent sessionevent)
    {
        boolean flag;
        boolean flag1;
        if (EVENTS_TYPE_TO_SAMPLE.contains(sessionevent.type) && sessionevent.sessionEventMetadata.betaDeviceToken == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (Math.abs(sessionevent.sessionEventMetadata.installationId.hashCode() % samplingRate) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return flag && flag1;
    }


    private class _cls1 extends HashSet
    {

        _cls1()
        {
            add(SessionEvent.Type.CREATE);
            add(SessionEvent.Type.START);
            add(SessionEvent.Type.RESUME);
            add(SessionEvent.Type.SAVE_INSTANCE_STATE);
            add(SessionEvent.Type.PAUSE);
            add(SessionEvent.Type.STOP);
            add(SessionEvent.Type.DESTROY);
            add(SessionEvent.Type.ERROR);
        }
    }

}
