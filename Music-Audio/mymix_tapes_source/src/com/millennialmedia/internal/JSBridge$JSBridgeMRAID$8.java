// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.net.Uri;
import com.millennialmedia.MMLog;

// Referenced classes of package com.millennialmedia.internal:
//            JSBridge

class this._cls1
    implements com.millennialmedia.internal.utils.ner
{

    final oListener this$1;

    public void onError(String s)
    {
        throwMraidError(s, "playVideo");
    }

    public void onVideoStarted(Uri uri)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("Video activity started for <").append(uri.toString()).append(">").toString());
        }
    }

    oListener()
    {
        this$1 = this._cls1.this;
        super();
    }
}
