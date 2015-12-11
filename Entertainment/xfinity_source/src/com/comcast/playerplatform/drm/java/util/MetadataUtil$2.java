// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.util;

import com.comcast.playerplatform.util.android.AbstractResponseEventListener;

// Referenced classes of package com.comcast.playerplatform.drm.java.util:
//            MetadataUtil

static final class val.manifestUri
    implements Runnable
{

    final String val$manifestUri;
    final AbstractResponseEventListener val$responseEventListener;

    public void run()
    {
        val$responseEventListener.requestFailed((new StringBuilder()).append("manifest not found:").append(val$manifestUri).toString());
    }

    EventListener(AbstractResponseEventListener abstractresponseeventlistener, String s)
    {
        val$responseEventListener = abstractresponseeventlistener;
        val$manifestUri = s;
        super();
    }
}
