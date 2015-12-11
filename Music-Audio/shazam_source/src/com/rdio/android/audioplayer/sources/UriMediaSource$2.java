// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.sources;

import com.rdio.android.audioplayer.io.UriAudioStream;

// Referenced classes of package com.rdio.android.audioplayer.sources:
//            UriMediaSource

class rapper
    implements Runnable
{

    final UriMediaSource this$0;
    final long val$startByteOffset;
    final com.rdio.android.audioplayer.io.reamWrapper val$streamWrapper;
    final String val$uri;

    public void run()
    {
        UriMediaSource.access$500(UriMediaSource.this).start(val$uri, val$startByteOffset, val$streamWrapper);
    }

    rapper()
    {
        this$0 = final_urimediasource;
        val$uri = s;
        val$startByteOffset = l;
        val$streamWrapper = com.rdio.android.audioplayer.io.reamWrapper.this;
        super();
    }
}
