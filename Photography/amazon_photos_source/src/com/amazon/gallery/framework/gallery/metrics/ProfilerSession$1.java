// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.metrics;


// Referenced classes of package com.amazon.gallery.framework.gallery.metrics:
//            ProfilerSession, NavigationMetrics, SessionMetrics

class this._cls0
    implements Runnable
{

    final ProfilerSession this$0;

    public void run()
    {
        if (ProfilerSession.access$000(ProfilerSession.this) == 0)
        {
            if (ProfilerSession.access$100(ProfilerSession.this) != null)
            {
                ProfilerSession.access$100(ProfilerSession.this).stopAllTimers();
            }
            ProfilerSession.access$200(ProfilerSession.this).endSession();
        }
    }

    ()
    {
        this$0 = ProfilerSession.this;
        super();
    }
}
