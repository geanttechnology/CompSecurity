// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.sources;


// Referenced classes of package com.rdio.android.audioplayer.sources:
//            RdioMediaSource

class this._cls0
    implements Runnable
{

    final RdioMediaSource this$0;

    public void run()
    {
        onPrepareUri();
    }

    ()
    {
        this$0 = RdioMediaSource.this;
        super();
    }
}
