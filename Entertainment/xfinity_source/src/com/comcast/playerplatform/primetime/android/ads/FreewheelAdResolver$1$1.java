// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads;

import com.comcast.playerplatform.primetime.android.ads.managers.FreewheelManager;
import com.comcast.playerplatform.primetime.android.util.ThreadManager;
import java.util.Vector;

// Referenced classes of package com.comcast.playerplatform.primetime.android.ads:
//            FreewheelAdResolver

class val.proposals
    implements Runnable
{

    final val.proposals this$1;
    final Vector val$proposals;

    public void run()
    {
        FreewheelAdResolver.access$000(_fld0, val$proposals);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$proposals = Vector.this;
        super();
    }

    // Unreferenced inner class com/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver$1

/* anonymous class */
    class FreewheelAdResolver._cls1
        implements Runnable
    {

        final FreewheelAdResolver this$0;

        public void run()
        {
            Vector vector = freewheelManager.getAdProposals();
            ThreadManager.getInstance().executeOnUIThread(vector. new FreewheelAdResolver._cls1._cls1());
        }

            
            {
                this$0 = FreewheelAdResolver.this;
                super();
            }
    }

}
