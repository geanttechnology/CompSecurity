// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            BridgeMMCachedVideo, VideoPlayerActivity, MMJSResponse

class a
    implements Callable
{

    private VideoPlayerActivity a;

    public MMJSResponse call()
    {
        a.m();
        return MMJSResponse.a();
    }

    public volatile Object call()
    {
        return call();
    }

    (VideoPlayerActivity videoplayeractivity)
    {
        a = videoplayeractivity;
        super();
    }
}
