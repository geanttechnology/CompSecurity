// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import com.millennialmedia.internal.utils.ThreadUtils;

// Referenced classes of package com.millennialmedia.internal.video:
//            MMVideoView

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        if (MMVideoView.access$700(_fld0) != null)
        {
            MMVideoView.access$700(_fld0).onProgress(_fld0, getCurrentPosition());
        }
        if (MMVideoView.access$900(_fld0) != null)
        {
            MMVideoView.access$900(_fld0).rogress(getCurrentPosition());
        }
        MMVideoView.access$1002(_fld0, ThreadUtils.runOnWorkerThreadDelayed(new nit>(_fld0, null), 100L));
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
