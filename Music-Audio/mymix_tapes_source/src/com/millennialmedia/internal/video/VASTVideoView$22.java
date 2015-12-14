// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;


// Referenced classes of package com.millennialmedia.internal.video:
//            VASTVideoView

class this._cls0
    implements Runnable
{

    final VASTVideoView this$0;

    public void run()
    {
        if (VASTVideoView.access$1700(VASTVideoView.this) != null)
        {
            VASTVideoView.access$1700(VASTVideoView.this).onClicked();
        }
    }

    TVideoViewListener()
    {
        this$0 = VASTVideoView.this;
        super();
    }
}
