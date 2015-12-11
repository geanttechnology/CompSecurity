// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads;

import com.comcast.playerplatform.primetime.android.ads.managers.FreewheelManager;
import com.comcast.playerplatform.primetime.android.util.ThreadManager;
import java.util.Vector;

// Referenced classes of package com.comcast.playerplatform.primetime.android.ads:
//            FreewheelAdResolver

class this._cls0
    implements Runnable
{

    final FreewheelAdResolver this$0;

    public void run()
    {
        final Vector proposals = freewheelManager.getAdProposals();
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final FreewheelAdResolver._cls1 this$1;
            final Vector val$proposals;

            public void run()
            {
                FreewheelAdResolver.access$000(this$0, proposals);
            }

            
            {
                this$1 = FreewheelAdResolver._cls1.this;
                proposals = vector;
                super();
            }
        });
    }

    _cls1.val.proposals()
    {
        this$0 = FreewheelAdResolver.this;
        super();
    }
}
