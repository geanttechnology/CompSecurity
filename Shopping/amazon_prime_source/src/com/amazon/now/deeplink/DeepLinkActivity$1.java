// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.deeplink;

import com.amazon.now.platform.TaskCallback;

// Referenced classes of package com.amazon.now.deeplink:
//            DeepLinkActivity

class this._cls0
    implements TaskCallback
{

    final DeepLinkActivity this$0;

    public void failure()
    {
        DeepLinkActivity.access$100(DeepLinkActivity.this, null);
    }

    public void success()
    {
        DeepLinkActivity.access$000(DeepLinkActivity.this, null);
    }

    ()
    {
        this$0 = DeepLinkActivity.this;
        super();
    }
}
